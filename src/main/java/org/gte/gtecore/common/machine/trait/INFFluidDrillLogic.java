package org.gte.gtecore.common.machine.trait;

import org.gte.gtecore.api.machine.trait.IFluidDrillLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.machine.multiblock.electric.voidseries.DrillingControlCenterMachine;
import org.gte.gtecore.common.machine.multiblock.electric.voidseries.INFFluidDrillMachine;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.BedrockFluidVeinSavedData;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.FluidVeinWorldEntry;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.core.SectionPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public final class INFFluidDrillLogic extends RecipeLogic implements IFluidDrillLogic {

    public static final int MAX_PROGRESS = 20;

    private DrillingControlCenterMachine cache;

    @Nullable
    private Fluid veinFluid;
    private static final int parallel = 1;

    public INFFluidDrillLogic(INFFluidDrillMachine machine) {
        super(machine);
    }

    @Override
    public INFFluidDrillMachine getMachine() {
        return (INFFluidDrillMachine) super.getMachine();
    }

    @Override
    public void findAndHandleRecipe() {
        if (getMachine().getLevel() instanceof ServerLevel serverLevel) {
            lastRecipe = null;
            var data = BedrockFluidVeinSavedData.getOrCreate(serverLevel);
            if (veinFluid == null) {
                veinFluid = data.getFluidInChunk(getChunkX(), getChunkZ());
                if (veinFluid == null) {
                    if (subscription != null) {
                        subscription.unsubscribe();
                        subscription = null;
                    }
                    return;
                }
            }
            var match = getFluidDrillRecipe();
            if (match != null) {
                if (RecipeRunnerHelper.matchRecipe(machine, match) && RecipeRunnerHelper.matchTickRecipe(machine, match)) {
                    setupRecipe(match);
                }
            }
        }
    }

    @Nullable
    private GTRecipe getFluidDrillRecipe() {
        if (getMachine().getLevel() instanceof ServerLevel serverLevel && veinFluid != null) {
            var data = BedrockFluidVeinSavedData.getOrCreate(serverLevel);
            var recipe = GTERecipeBuilder.ofRaw()
                    .outputFluids(new FluidStack(veinFluid, getFluidToProduce(data.getFluidVeinWorldEntry(getChunkX(), getChunkZ()))))
                    .duration(MAX_PROGRESS)
                    .EUt((long) (GTValues.VA[getMachine().getEnergyTier()] * Math.pow(parallel, 1.2)))
                    .buildRawRecipe();
            if (RecipeRunnerHelper.matchRecipe(machine, recipe) && RecipeRunnerHelper.matchTickRecipe(machine, recipe)) {
                return recipe;
            }
        }
        return null;
    }

    public int getFluidToProduce() {
        if (getMachine().getLevel() instanceof ServerLevel serverLevel && veinFluid != null) {
            var data = BedrockFluidVeinSavedData.getOrCreate(serverLevel);
            return getFluidToProduce(data.getFluidVeinWorldEntry(getChunkX(), getChunkZ()));
        }
        return 0;
    }

    private int getFluidToProduce(FluidVeinWorldEntry entry) {
        var definition = entry.getDefinition();
        if (definition != null) {
            int depletedYield = definition.getDepletedYield();
            int regularYield = entry.getFluidYield();
            int remainingOperations = entry.getOperationsRemaining();

            int produced = Math.max(depletedYield,
                    regularYield * remainingOperations / BedrockFluidVeinSavedData.MAXIMUM_VEIN_OPERATIONS);
            produced *= getMachine().getBasis();

            if (isOverclocked()) {
                produced = produced * 3 / 2;
            }
            DrillingControlCenterMachine machine = getNetMachine();
            if (machine != null) produced = (int) (produced * machine.getMultiplier());
            return produced;
        }
        return 0;
    }

    @Override
    public void onRecipeFinish() {
        machine.afterWorking();
        if (lastRecipe != null) {
            RecipeRunnerHelper.handleRecipeOutput(machine, lastRecipe);
        }
        var match = getFluidDrillRecipe();
        if (match != null) {
            if (RecipeRunnerHelper.matchRecipe(machine, match) && RecipeRunnerHelper.matchTickRecipe(machine, match)) {
                setupRecipe(match);
                return;
            }
        }
        setStatus(Status.IDLE);
        progress = 0;
        duration = 0;
    }

    private boolean isOverclocked() {
        return getMachine().getEnergyTier() > getMachine().getTier();
    }

    private int getChunkX() {
        return SectionPos.blockToSectionCoord(getMachine().getPos().getX());
    }

    private int getChunkZ() {
        return SectionPos.blockToSectionCoord(getMachine().getPos().getZ());
    }

    @Override
    public DrillingControlCenterMachine getNetMachineCache() {
        return cache;
    }

    @Override
    public void setNetMachineCache(DrillingControlCenterMachine cache) {
        this.cache = cache;
    }

    @Override
    public void onMachineUnLoad() {
        super.onMachineUnLoad();
        this.cache = null;
    }
}
