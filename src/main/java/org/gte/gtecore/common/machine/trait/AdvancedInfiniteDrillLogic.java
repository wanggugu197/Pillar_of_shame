package org.gte.gtecore.common.machine.trait;

import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.machine.multiblock.electric.voidseries.AdvancedInfiniteDrillMachine;

import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.BedrockFluidVeinSavedData;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.FluidVeinWorldEntry;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;

import net.minecraft.core.SectionPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public final class AdvancedInfiniteDrillLogic extends RecipeLogic {

    private static final int MAX_PROGRESS = 20;

    private final Map<Fluid, Integer> veinFluids = new Object2IntOpenHashMap<>();

    @Getter
    @Setter
    private int range;

    public AdvancedInfiniteDrillLogic(IRecipeLogicMachine machine, int range) {
        super(machine);
        this.range = range;
    }

    @Override
    public AdvancedInfiniteDrillMachine getMachine() {
        return (AdvancedInfiniteDrillMachine) super.getMachine();
    }

    @Override
    public void findAndHandleRecipe() {
        if (getMachine().getLevel() instanceof ServerLevel serverLevel) {
            lastRecipe = null;
            var data = BedrockFluidVeinSavedData.getOrCreate(serverLevel);
            if (veinFluids.isEmpty()) {
                getGridFluid(data);
                if (veinFluids.isEmpty()) {
                    if (subscription != null) {
                        subscription.unsubscribe();
                        subscription = null;
                    }
                }
            }
            if (getMachine().isEmpty() || !getMachine().canRunnable()) return;
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
        if (!veinFluids.isEmpty()) {
            var recipe = GTERecipeBuilder.ofRaw()
                    .duration(MAX_PROGRESS)
                    .EUt(20000)
                    .outputFluids(veinFluids.entrySet().stream()
                            .map(entry -> new FluidStack(entry.getKey(), entry.getValue()))
                            .toArray(FluidStack[]::new))
                    .buildRawRecipe();
            recipe = recipe.copy(new ContentModifier(getParallel(),
                    efficiency(getMachine().getRate() * 500)), false);
            if (RecipeRunnerHelper.matchRecipe(machine, recipe) && RecipeRunnerHelper.matchTickRecipe(machine, recipe)) {
                return recipe;
            }
        }
        return null;
    }

    private long getParallel() {
        AdvancedInfiniteDrillMachine drill = getMachine();
        var currentHeat = drill.getCurrentHeat();
        var heat = drill.getRate();
        var efficiency = efficiency(currentHeat);
        return (long) efficiency * heat;
    }

    /**
     * 温度倍率计算
     *
     * @param heat 当前温度
     * @return 倍率
     */
    private static int efficiency(int heat) {
        if (heat < 6000) {
            return 2;
        } else if (heat < 8000) {
            return 4;
        } else {
            return 8;
        }
    }

    private static int getFluidToProduce(FluidVeinWorldEntry entry) {
        var definition = entry.getDefinition();
        if (definition != null) {
            int depletedYield = definition.getDepletedYield();
            int regularYield = entry.getFluidYield();
            int remainingOperations = entry.getOperationsRemaining();

            return Math.max(depletedYield,
                    regularYield * remainingOperations / BedrockFluidVeinSavedData.MAXIMUM_VEIN_OPERATIONS);
        }
        return 0;
    }

    private void getGridFluid(BedrockFluidVeinSavedData data) {
        int x = getChunkX();
        int z = getChunkZ();
        int mid = range / 2;
        for (int i = -mid; i <= mid; i++) {
            for (int j = -mid; j <= mid; j++) {
                var fluid = data.getFluidInChunk(x + i, z + j);
                if (fluid != null) {
                    int produced = getFluidToProduce(data.getFluidVeinWorldEntry(x + i, z + j));
                    if (produced > 0) {
                        int value = veinFluids.getOrDefault(fluid, 0) + produced * 10;
                        veinFluids.put(fluid, value);
                    }
                }
            }
        }
    }

    @NotNull
    public Map<Fluid, Integer> getVeinFluids() {
        return veinFluids;
    }

    @Override
    public void onRecipeFinish() {
        machine.afterWorking();
        if (lastRecipe != null) {
            RecipeRunnerHelper.handleRecipeOutput(machine, lastRecipe);
        }
        // try it again
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

    private int getChunkX() {
        return SectionPos.blockToSectionCoord(getMachine().getPos().getX());
    }

    private int getChunkZ() {
        return SectionPos.blockToSectionCoord(getMachine().getPos().getZ());
    }
}
