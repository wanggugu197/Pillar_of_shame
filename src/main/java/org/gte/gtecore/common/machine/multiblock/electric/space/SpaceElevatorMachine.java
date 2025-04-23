package org.gte.gtecore.common.machine.multiblock.electric.space;

import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.api.gui.GTEGuiTextures;
import org.gte.gtecore.api.machine.feature.multiblock.IHighlightMachine;
import org.gte.gtecore.api.machine.multiblock.TierCasingMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.misc.PlanetManagement;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.utils.MachineUtils;
import org.gte.gtecore.utils.MathUtil;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfiguratorButton;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import earth.terrarium.adastra.common.menus.base.PlanetsMenuProvider;
import earth.terrarium.botarium.common.menu.MenuHooks;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static org.gte.gtecore.api.GTEValues.POWER_MODULE_TIER;

public class SpaceElevatorMachine extends TierCasingMultiblockMachine implements IHighlightMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            SpaceElevatorMachine.class, TierCasingMultiblockMachine.MANAGED_FIELD_HOLDER);

    public SpaceElevatorMachine(IMachineBlockEntity holder) {
        super(holder, POWER_MODULE_TIER);
    }

    @Override
    @NotNull
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Getter
    @Persisted
    @DescSynced
    private double high;

    @Getter
    @Persisted
    @DescSynced
    private int spoolCount;

    private int moduleCount;

    @DescSynced
    final List<BlockPos> poss = new ArrayList<>();

    private ServerPlayer player;

    private void update(boolean promptly) {
        if (promptly || getOffsetTimer() % 40 == 0) {
            moduleCount = 0;
            if (spoolCount < getMaxSpoolCount()) {
                forEachInputItems(stack -> {
                    if (stack.getItem() == GTEItems.NANOTUBE_SPOOL.get()) {
                        int count = Math.min(stack.getCount(), getMaxSpoolCount() - spoolCount);
                        if (count < 1) return true;
                        spoolCount += count;
                        stack.shrink(count);
                    }
                    return false;
                });
                return;
            }
            Level level = getLevel();
            if (level == null) return;
            for (BlockPos blockPoss : poss) {
                MetaMachine metaMachine = getMachine(level, blockPoss);
                if (metaMachine instanceof SpaceElevatorModuleMachine moduleMachine && moduleMachine.isFormed()) {
                    moduleMachine.spaceElevatorMachine = this;
                    moduleCount++;
                }
            }
        }
    }

    public int getMaxSpoolCount() {
        return 256;
    }

    int getBaseHigh() {
        poss.clear();
        BlockPos blockPos = MachineUtils.getOffsetPos(3, -2, getFrontFacing(), getPos());
        poss.add(blockPos.offset(7, 2, 0));
        poss.add(blockPos.offset(7, 2, 2));
        poss.add(blockPos.offset(7, 2, -2));
        poss.add(blockPos.offset(-7, 2, 0));
        poss.add(blockPos.offset(-7, 2, 2));
        poss.add(blockPos.offset(-7, 2, -2));
        poss.add(blockPos.offset(0, 2, 7));
        poss.add(blockPos.offset(2, 2, 7));
        poss.add(blockPos.offset(-2, 2, 7));
        poss.add(blockPos.offset(0, 2, -7));
        poss.add(blockPos.offset(2, 2, -7));
        poss.add(blockPos.offset(-2, 2, -7));
        return 40;
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        high = getBaseHigh();
        update(true);
    }

    @Override
    public boolean onWorking() {
        if (!super.onWorking()) return false;
        update(false);
        high = 12 * getBaseHigh() + 100 + ((100 + getBaseHigh()) * MathUtil.sin(getOffsetTimer() / 160.0F));
        return true;
    }

    @Override
    public InteractionResult onUse(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
                                   BlockHitResult hit) {
        if (player instanceof ServerPlayer serverPlayer) {
            this.player = serverPlayer;
        }
        return super.onUse(state, level, pos, player, hand, hit);
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        update(false);
        if (spoolCount < getMaxSpoolCount()) textList.add(Component.translatable("item.gtecore.nanotube_spool").append(": ").append(Component.translatable("gui.ae2.Missing", getMaxSpoolCount() - spoolCount)));
        textList.add(Component.translatable("gtecore.machine.module", moduleCount));
    }

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        super.attachConfigurators(configuratorPanel);
        attachHighlightConfigurators(configuratorPanel);
        configuratorPanel.attachConfigurators(new IFancyConfiguratorButton.Toggle(
                GTEGuiTextures.PLANET_TELEPORT.getSubTexture(0, 0.5, 1, 0.5),
                GTEGuiTextures.PLANET_TELEPORT.getSubTexture(0, 0, 1, 0.5),
                getRecipeLogic()::isWorking, (clickData, pressed) -> {
                    if (!clickData.isRemote && getRecipeLogic().isWorking() && player != null) {
                        PlanetManagement.unlock(player.getUUID(), GTEDimensions.BARNARDA_C);
                        player.addTag("spaceelevatorst");
                        MenuHooks.openMenu(player, new PlanetsMenuProvider());
                    }
                })
                .setTooltipsSupplier(pressed -> List.of(Component.translatable("gtecore.machine.space_elevator.set_out"))));
    }

    @Nullable
    private GTRecipe getRecipe() {
        if (getTier() > GTValues.ZPM) {
            GTRecipe recipe = GTERecipeBuilder.ofRaw().duration(400).CWUt(128 * (getTier() - GTValues.ZPM)).EUt(GTValues.VA[getTier()]).buildRawRecipe();
            if (RecipeRunnerHelper.matchRecipeTickInput(this, recipe)) return recipe;
        }
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe, true);
    }

    @Override
    public List<BlockPos> getHighlightPos() {
        return poss;
    }
}
