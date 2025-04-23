package org.gte.gtecore.client.gui;

import org.gte.gtecore.api.gui.PatternSlotWidget;
import org.gte.gtecore.api.item.ItemHandlerModifiable;
import org.gte.gtecore.api.machine.IMultiblockMachineDefinition;
import org.gte.gtecore.api.machine.feature.multiblock.IMultiStructureMachine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.predicates.SimplePredicate;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.integration.xei.handlers.item.CycleItemStackHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.lowdragmc.lowdraglib.client.scene.WorldSceneRenderer;
import com.lowdragmc.lowdraglib.client.utils.RenderUtils;
import com.lowdragmc.lowdraglib.gui.editor.ColorPattern;
import com.lowdragmc.lowdraglib.gui.texture.ColorRectTexture;
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup;
import com.lowdragmc.lowdraglib.gui.texture.TextTexture;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import com.lowdragmc.lowdraglib.utils.BlockPosFace;
import com.lowdragmc.lowdraglib.utils.TrackedDummyWorld;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.emi.screen.RecipeScreen;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.longs.LongSets;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public final class PatternPreview extends WidgetGroup {

    private boolean isLoaded;
    private static TrackedDummyWorld LEVEL;
    private static final Map<MultiblockMachineDefinition, MBPattern[]> CACHE = new Object2ObjectOpenHashMap<>();
    private final SceneWidget sceneWidget;
    @Getter
    private final DraggableScrollableWidgetGroup scrollableWidgetGroup;
    private final MBPattern[] patterns;
    private final List<SimplePredicate> predicates = new ArrayList<>();
    private int index;
    private int layer;
    private SlotWidget[] slotWidgets;
    private SlotWidget[] candidates;

    private PatternPreview(MultiblockMachineDefinition controllerDefinition) {
        super(0, 0, 160, 160);
        setClientSideWidget();
        layer = -1;

        addWidget(sceneWidget = new MySceneWidget()
                .setOnSelected(this::onPosSelected)
                .setRenderFacing(false)
                .setRenderFacing(false));

        scrollableWidgetGroup = new DraggableScrollableWidgetGroup(3, 132, 154, 22)
                .setXScrollBarHeight(4)
                .setXBarStyle(GuiTextures.SLIDER_BACKGROUND, GuiTextures.BUTTON)
                .setScrollable(true)
                .setDraggable(true)
                .setScrollWheelDirection(DraggableScrollableWidgetGroup.ScrollWheelDirection.HORIZONTAL);
        scrollableWidgetGroup.setScrollYOffset(0);
        addWidget(scrollableWidgetGroup);

        if (ConfigHolder.INSTANCE.client.useVBO) {
            if (!RenderSystem.isOnRenderThread()) {
                RenderSystem.recordRenderCall(sceneWidget::useCacheBuffer);
            } else {
                sceneWidget.useCacheBuffer();
            }
        }

        addWidget(new ImageWidget(3, 3, 160, 10,
                new TextTexture(controllerDefinition.getDescriptionId(), -1)
                        .setType(TextTexture.TextType.ROLL)
                        .setWidth(170)
                        .setDropShadow(true)));

        if (CACHE.containsKey(controllerDefinition)) {
            patterns = CACHE.get(controllerDefinition);
        } else {
            IMultiblockMachineDefinition.Pattern[] pattern = ((IMultiblockMachineDefinition) controllerDefinition).gtecore$getPatterns();
            patterns = new MBPattern[pattern.length];
            for (int i = 0; i < pattern.length; i++) {
                patterns[i] = initializePattern(pattern[i], i);
            }
            CACHE.put(controllerDefinition, patterns);
            ((IMultiblockMachineDefinition) controllerDefinition).gtecore$clear();
        }

        addWidget(new ButtonWidget(138, 30, 18, 18, new GuiTextureGroup(
                ColorPattern.T_GRAY.rectTexture(),
                new TextTexture("1").setSupplier(() -> "P:" + index)),
                (x) -> {
                    index = (index + 1 >= patterns.length) ? 0 : index + 1;
                    setPage();
                })
                .setHoverBorderTexture(1, -1));

        addWidget(new ButtonWidget(138, 50, 18, 18, new GuiTextureGroup(
                ColorPattern.T_GRAY.rectTexture(),
                new TextTexture("1").setSupplier(() -> layer >= 0 ? "L:" + layer : "ALL")),
                cd -> updateLayer())
                .setHoverBorderTexture(1, -1));

        setPage();
    }

    private void updateLayer() {
        MBPattern pattern = patterns[index];
        if (layer + 1 >= -1 && layer + 1 <= pattern.maxY - pattern.minY) {
            layer += 1;
            if (pattern.controllerBase.isFormed()) {
                onFormedSwitch(false);
            }
        } else {
            layer = -1;
            if (!pattern.controllerBase.isFormed()) {
                onFormedSwitch(true);
            }
        }
        setupScene(pattern);
    }

    private void setupScene(MBPattern pattern) {
        Stream<BlockPos> stream = pattern.blockMap.keySet().stream()
                .filter(pos -> layer == -1 || layer + pattern.minY == pos.getY());
        if (pattern.controllerBase.isFormed()) {
            LongSet set = pattern.controllerBase.getMultiblockState().getMatchContext().getOrDefault("renderMask",
                    LongSets.EMPTY_SET);
            Set<BlockPos> modelDisabled = set.stream().map(BlockPos::of).collect(Collectors.toSet());
            if (!modelDisabled.isEmpty()) {
                sceneWidget.setRenderedCore(
                        stream.filter(pos -> !modelDisabled.contains(pos)).collect(Collectors.toList()), null);
            } else {
                sceneWidget.setRenderedCore(stream.toList(), null);
            }
        } else {
            sceneWidget.setRenderedCore(stream.toList(), null);
        }
    }

    public static PatternPreview getPatternWidget(MultiblockMachineDefinition controllerDefinition) {
        if (LEVEL == null) {
            if (Minecraft.getInstance().level == null) {
                GTCEu.LOGGER.error("Try to init pattern previews before level load");
                throw new IllegalStateException();
            }
            LEVEL = new TrackedDummyWorld();
        }
        return new PatternPreview(controllerDefinition);
    }

    private void setPage() {
        List<ItemStack> itemList;
        if (index < patterns.length && index >= 0) {
            layer = -1;
            MBPattern pattern = patterns[index];
            setupScene(pattern);
            itemList = pattern.parts;
        } else {
            return;
        }
        if (slotWidgets != null) {
            for (SlotWidget slotWidget : slotWidgets) {
                scrollableWidgetGroup.removeWidget(slotWidget);
            }
        }
        slotWidgets = new SlotWidget[itemList.size()];
        for (int i = 0; i < slotWidgets.length; i++) {
            slotWidgets[i] = new PatternSlotWidget(new ItemHandlerModifiable(itemList.get(i)), i, 4 + i * 18, 0);
            scrollableWidgetGroup.addWidget(slotWidgets[i]);
        }
    }

    private void onFormedSwitch(boolean isFormed) {
        MBPattern pattern = patterns[index];
        IMultiController controllerBase = pattern.controllerBase;
        if (isFormed) {
            layer = -1;
            loadControllerFormed(pattern.blockMap.keySet(), controllerBase, index);
        } else {
            sceneWidget.setRenderedCore(pattern.blockMap.keySet(), null);
            controllerBase.onStructureInvalid();
        }
    }

    private void onPosSelected(BlockPos pos, Direction facing) {
        if (index >= patterns.length || index < 0) return;
        TraceabilityPredicate predicate = patterns[index].predicateMap.get(pos);
        if (predicate != null) {
            predicates.clear();
            predicates.addAll(predicate.common);
            predicates.addAll(predicate.limited);
            predicates.removeIf(p -> p == null || p.candidates == null); // why it happens?
            if (candidates != null) {
                for (SlotWidget candidate : candidates) {
                    removeWidget(candidate);
                }
            }
            List<List<ItemStack>> candidateStacks = new ArrayList<>();
            List<List<Component>> predicateTips = new ArrayList<>();
            for (SimplePredicate simplePredicate : predicates) {
                List<ItemStack> itemStacks = simplePredicate.getCandidates();
                if (!itemStacks.isEmpty()) {
                    candidateStacks.add(itemStacks);
                    predicateTips.add(simplePredicate.getToolTips(predicate));
                }
            }
            candidates = new SlotWidget[candidateStacks.size()];
            CycleItemStackHandler itemHandler = new CycleItemStackHandler(candidateStacks);
            int maxCol = (160 - (((slotWidgets.length - 1) / 9 + 1) * 18) - 35) % 18;
            for (int i = 0; i < candidateStacks.size(); i++) {
                int finalI = i;
                candidates[i] = new PatternSlotWidget(itemHandler, i, 3 + (i / maxCol) * 18, 3 + (i % maxCol) * 18)
                        .setBackgroundTexture(new ColorRectTexture(0x4fffffff))
                        .setOnAddedTooltips((slot, list) -> list.addAll(predicateTips.get(finalI)));
                addWidget(candidates[i]);
            }
        }
    }

    private void loadControllerFormed(Collection<BlockPos> poses, IMultiController controllerBase, int index) {
        BlockPattern pattern;
        if (controllerBase instanceof IMultiStructureMachine machine) {
            pattern = machine.getMultiPattern().get(index);
        } else {
            pattern = controllerBase.getPattern();
        }
        if (pattern != null && pattern.checkPatternAt(controllerBase.getMultiblockState(), true)) {
            controllerBase.onStructureFormed();
        }
        if (controllerBase.isFormed()) {
            LongSet set = controllerBase.getMultiblockState().getMatchContext().getOrDefault("renderMask",
                    LongSets.EMPTY_SET);
            Set<BlockPos> modelDisabled = set.stream().map(BlockPos::of).collect(Collectors.toSet());
            if (!modelDisabled.isEmpty()) {
                sceneWidget.setRenderedCore(
                        poses.stream().filter(pos -> !modelDisabled.contains(pos)).collect(Collectors.toList()), null);
            } else {
                sceneWidget.setRenderedCore(poses, null);
            }
        } else {
            GTCEu.LOGGER.warn("Pattern formed checking failed: {}", controllerBase.self().getDefinition());
        }
    }

    private MBPattern initializePattern(IMultiblockMachineDefinition.Pattern pattern, int index) {
        Map<BlockPos, BlockInfo> blockMap = pattern.blockMap();
        IMultiController controllerBase = pattern.multiController();
        LEVEL.addBlocks(blockMap);
        if (controllerBase != null) {
            controllerBase.self().holder.getSelf().setLevel(LEVEL);
            LEVEL.setInnerBlockEntity(controllerBase.self().holder.getSelf());
        }
        Map<BlockPos, TraceabilityPredicate> predicateMap = controllerBase == null ? null : new HashMap<>();
        if (controllerBase != null) {
            loadControllerFormed(predicateMap.keySet(), controllerBase, index);
            predicateMap = controllerBase.getMultiblockState().getMatchContext().get("predicates");
        }
        return controllerBase == null ? null : new MBPattern(blockMap, pattern.parts(), predicateMap, controllerBase);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (!isLoaded && Minecraft.getInstance().screen instanceof RecipeScreen) {
            setPage();
            isLoaded = true;
        }
    }

    @Override
    public void drawInBackground(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.enableBlend();
        super.drawInBackground(graphics, mouseX, mouseY, partialTicks);
    }

    private static class MBPattern {

        @NotNull
        final List<ItemStack> parts;
        @NotNull
        final Map<BlockPos, TraceabilityPredicate> predicateMap;
        @NotNull
        final Map<BlockPos, BlockInfo> blockMap;
        @NotNull
        final IMultiController controllerBase;
        final int maxY, minY;

        MBPattern(@NotNull Map<BlockPos, BlockInfo> blockMap, @NotNull List<ItemStack> parts,
                  @NotNull Map<BlockPos, TraceabilityPredicate> predicateMap,
                  @NotNull IMultiController controllerBase) {
            this.parts = parts;
            this.blockMap = blockMap;
            this.predicateMap = predicateMap;
            this.controllerBase = controllerBase;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (BlockPos pos : blockMap.keySet()) {
                min = Math.min(min, pos.getY());
                max = Math.max(max, pos.getY());
            }
            minY = min;
            maxY = max;
        }
    }

    private static class MySceneWidget extends SceneWidget {

        private MySceneWidget() {
            super(3, 3, 150, 150, LEVEL);
        }

        @Override
        public void renderBlockOverLay(WorldSceneRenderer renderer) {
            PoseStack poseStack = new PoseStack();
            hoverPosFace = null;
            hoverItem = null;
            if (isMouseOverElement(currentMouseX, currentMouseY)) {
                BlockHitResult hit = renderer.getLastTraceResult();
                if (hit != null) {
                    if (core.contains(hit.getBlockPos())) {
                        hoverPosFace = new BlockPosFace(hit.getBlockPos(), hit.getDirection());
                    } else if (!useOrtho) {
                        Vector3f hitPos = hit.getLocation().toVector3f();
                        Level world = renderer.world;
                        Vec3 eyePos = new Vec3(renderer.getEyePos());
                        hitPos.mul(2);
                        Vec3 endPos = new Vec3((hitPos.x - eyePos.x), (hitPos.y - eyePos.y), (hitPos.z - eyePos.z));
                        double min = Float.MAX_VALUE;
                        for (BlockPos pos : core) {
                            BlockState blockState = world.getBlockState(pos);
                            if (blockState.getBlock() == Blocks.AIR) {
                                continue;
                            }
                            hit = world.clipWithInteractionOverride(eyePos, endPos, pos,
                                    blockState.getShape(world, pos), blockState);
                            if (hit != null && hit.getType() != HitResult.Type.MISS) {
                                double dist = eyePos.distanceToSqr(hit.getLocation());
                                if (dist < min) {
                                    min = dist;
                                    hoverPosFace = new BlockPosFace(hit.getBlockPos(), hit.getDirection());
                                }
                            }
                        }
                    }
                }
            }
            if (hoverPosFace != null) {
                var state = getDummyWorld().getBlockState(hoverPosFace.pos);
                hoverItem = state.getBlock().getCloneItemStack(getDummyWorld(), hoverPosFace.pos, state);
            }
            BlockPosFace tmp = dragging ? clickPosFace : hoverPosFace;
            if (selectedPosFace != null || tmp != null) {
                if (selectedPosFace != null && renderFacing) {
                    drawFacingBorder(poseStack, selectedPosFace, 0xff00ff00);
                }
                if (tmp != null && !tmp.equals(selectedPosFace) && renderFacing) {
                    drawFacingBorder(poseStack, tmp, 0xffffffff);
                }
            }
            if (selectedPosFace != null && renderSelect) {
                RenderUtils.renderBlockOverLay(poseStack, selectedPosFace.pos, 0.6f, 0, 0, 1.03f);
            }

            if (this.afterWorldRender != null) {
                this.afterWorldRender.accept(this);
            }
        }
    }
}
