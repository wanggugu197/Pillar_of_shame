package org.gte.gtecore.common.machine.noenergy;

import org.gte.gtecore.api.data.GTEDimensions;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import com.glodblock.github.extendedae.client.render.EAEHighlightHandler;
import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public final class PerformanceMonitorMachine extends MetaMachine implements IFancyUIMachine {

    public static boolean observe;

    public static final Map<MetaMachine, Integer> PERFORMANCE_MAP = new WeakHashMap<>();

    private List<Component> textListCache;

    public PerformanceMonitorMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    private static void handleDisplayClick(String componentData, ClickData clickData) {
        if (clickData.isRemote) {
            String[] parts = componentData.split(", ");
            BlockPos pos = new BlockPos(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            EAEHighlightHandler.highlight(pos, GTEDimensions.getDimensionKey(new ResourceLocation(parts[3])), System.currentTimeMillis() + 15000);
        }
    }

    @Override
    public Widget createUIWidget() {
        WidgetGroup group = new WidgetGroup(0, 0, 182 + 8, 117 + 8);
        group.addWidget(new DraggableScrollableWidgetGroup(4, 4, 182, 117).setBackground(GuiTextures.DISPLAY)
                .addWidget(new LabelWidget(4, 5, self().getBlockState().getBlock().getDescriptionId()))
                .addWidget(new ComponentPanelWidget(4, 17, this::addDisplayText).setMaxWidthLimit(150).clickHandler(PerformanceMonitorMachine::handleDisplayClick)));
        group.setBackground(GuiTextures.BACKGROUND_INVERSE);
        return group;
    }

    private void addDisplayText(@NotNull List<Component> textList) {
        if (isRemote()) return;
        observe = true;
        if (textListCache == null || getOffsetTimer() % 40 == 0) {
            textListCache = new ArrayList<>();
            Map<MetaMachine, Integer> sortedMap = new TreeMap<>((mm1, mm2) -> PERFORMANCE_MAP.get(mm2).compareTo(PERFORMANCE_MAP.get(mm1)));
            sortedMap.putAll(PERFORMANCE_MAP);
            PERFORMANCE_MAP.clear();
            for (Map.Entry<MetaMachine, Integer> entry : sortedMap.entrySet()) {
                MetaMachine machine = entry.getKey();
                String pos = machine.getPos().toShortString();
                Level level = machine.getLevel();
                if (level == null) continue;
                textListCache.add(Component.translatable(machine.getBlockState().getBlock().getDescriptionId()).append(" ")
                        .withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("recipe.condition.dimension.tooltip", level.dimension().location()).append(" [").append(pos).append("] "))))
                        .append(Component.translatable("tooltip.jade.delay", entry.getValue()).append(" μs"))
                        .append(ComponentPanelWidget.withButton(Component.literal(" [ ] "), pos + ", " + level.dimension().location())));
            }
        }
        textList.addAll(textListCache);
    }
}
