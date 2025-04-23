package org.gte.gtecore.common.machine.multiblock.water;

import org.gte.gtecore.api.machine.IIWirelessInteractorMachine;
import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.client.ClientUtil;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;

import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.ComponentPanelWidget;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class WaterPurificationPlantMachine extends ElectricMultiblockMachine {

    public static final Map<ResourceLocation, Set<WaterPurificationPlantMachine>> NETWORK = new Object2ObjectOpenHashMap<>();

    static final int DURATION = 2400;

    static final Fluid GradePurifiedWater1 = GTEMaterials.FilteredSater.getFluid();
    static final Fluid GradePurifiedWater2 = GTEMaterials.OzoneWater.getFluid();
    static final Fluid GradePurifiedWater3 = GTEMaterials.FlocculentWater.getFluid();
    static final Fluid GradePurifiedWater4 = GTEMaterials.PHNeutralWater.getFluid();
    static final Fluid GradePurifiedWater5 = GTEMaterials.ExtremeTemperatureWater.getFluid();
    static final Fluid GradePurifiedWater6 = GTEMaterials.ElectricEquilibriumWater.getFluid();
    static final Fluid GradePurifiedWater7 = GTEMaterials.DegassedWater.getFluid();
    static final Fluid GradePurifiedWater8 = GTEMaterials.BaryonicPerfectionWater.getFluid();

    final Map<WaterPurificationUnitMachine, Boolean> waterPurificationUnitMachineMap = new Object2ObjectOpenHashMap<>();

    public WaterPurificationPlantMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        IIWirelessInteractorMachine.addToNet(NETWORK, this);
    }

    @Override
    public void onUnload() {
        super.onUnload();
        IIWirelessInteractorMachine.removeFromNet(NETWORK, this);
    }

    @Override
    public void onStructureInvalid() {
        IIWirelessInteractorMachine.removeFromNet(NETWORK, this);
        for (Map.Entry<WaterPurificationUnitMachine, Boolean> entry : waterPurificationUnitMachineMap.entrySet()) {
            if (entry.getValue()) {
                entry.getKey().getRecipeLogic().resetRecipeLogic();
            }
        }
        super.onStructureInvalid();
    }

    @Override
    public void onWaiting() {
        for (Map.Entry<WaterPurificationUnitMachine, Boolean> entry : waterPurificationUnitMachineMap.entrySet()) {
            if (entry.getValue()) {
                entry.getKey().getRecipeLogic().setWaiting(null);
            }
        }
        super.onWaiting();
    }

    @Override
    public void setWorkingEnabled(boolean isWorkingAllowed) {
        for (WaterPurificationUnitMachine machine : waterPurificationUnitMachineMap.keySet()) {
            machine.setWorking(isWorkingAllowed);
            waterPurificationUnitMachineMap.put(machine, machine.getRecipeLogic().isWorking());
        }
        super.setWorkingEnabled(isWorkingAllowed);
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe r) {
        for (Map.Entry<WaterPurificationUnitMachine, Boolean> entry : waterPurificationUnitMachineMap.entrySet()) {
            if (entry.getValue()) {
                entry.getKey().getRecipeLogic().resetRecipeLogic();
                entry.getKey().getRecipeLogic().setupRecipe(entry.getKey().recipe);
            }
        }
        return super.beforeWorking(r);
    }

    @Override
    public int getOutputSignal(@Nullable Direction side) {
        return 15 * DURATION / getRecipeLogic().getProgress();
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        textList.add(ComponentPanelWidget.withButton(Component.translatable("gui.enderio.range.show"), "show"));
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        if (!isFormed()) return;
        textList.add(Component.translatable("gtocore.machine.water_purification_plant.bind"));
        for (Map.Entry<WaterPurificationUnitMachine, Boolean> entry : waterPurificationUnitMachineMap.entrySet()) {
            MutableComponent component = Component.translatable(entry.getKey().getBlockState().getBlock().getDescriptionId()).append(" ");
            if (entry.getValue()) {
                component.append(Component.translatable("gtceu.multiblock.running").append("\n").append(Component.translatable("gtceu.multiblock.energy_consumption", FormattingUtil.formatNumbers(entry.getKey().eut), Component.literal(GTValues.VNF[GTUtil.getTierByVoltage(entry.getKey().eut)]))));
            } else {
                component.append(Component.translatable("gtceu.multiblock.idling"));
            }
            textList.add(component);
        }
    }

    @Override
    public void handleDisplayClick(String componentData, ClickData clickData) {
        if (clickData.isRemote && "show".equals(componentData)) {
            ClientUtil.highlighting(getPos(), 32);
        }
    }

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }

    @Nullable
    private GTRecipe getRecipe() {
        long eut = 0;
        for (WaterPurificationUnitMachine machine : waterPurificationUnitMachineMap.keySet()) {
            if (machine.isFormed() && machine.getRecipeLogic().isIdle()) {
                long eu = machine.before();
                if (eu > 0) {
                    waterPurificationUnitMachineMap.put(machine, true);
                    eut += eu;
                }
            }
        }
        if (eut > 0) {
            GTRecipe recipe = GTERecipeBuilder.ofRaw().duration(DURATION).EUt(eut).buildRawRecipe();
            if (RecipeRunnerHelper.matchRecipeTickInput(this, recipe)) {
                return recipe;
            }
        }
        return null;
    }
}
