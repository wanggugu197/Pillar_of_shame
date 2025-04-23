package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.common.data.GTEItems;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;

import static org.gte.gtecore.common.data.GTERecipeTypes.LARGE_GAS_COLLECTOR_RECIPES;

interface LargeGasCollector {

    static void init() {
        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("1"))
                .notConsumable(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.OVERWORLD))
                .circuitMeta(1)
                .outputFluids(GTMaterials.Air.getFluid(100000))
                .EUt(120)
                .duration(200)
                .save();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("3"))
                .notConsumable(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.THE_END))
                .circuitMeta(1)
                .outputFluids(GTMaterials.EnderAir.getFluid(100000))
                .EUt(1920)
                .duration(200)
                .save();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("2"))
                .notConsumable(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.THE_NETHER))
                .circuitMeta(1)
                .outputFluids(GTMaterials.NetherAir.getFluid(100000))
                .EUt(480)
                .duration(200)
                .save();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("5"))
                .notConsumable(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.THE_NETHER))
                .notConsumable(GTMultiMachines.VACUUM_FREEZER.getItem())
                .outputFluids(GTMaterials.LiquidNetherAir.getFluid(100000))
                .EUt(1920)
                .duration(2000)
                .save();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("4"))
                .notConsumable(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.OVERWORLD))
                .notConsumable(GTMultiMachines.VACUUM_FREEZER.getItem())
                .outputFluids(GTMaterials.LiquidAir.getFluid(100000))
                .EUt(480)
                .duration(2000)
                .save();

        LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("6"))
                .notConsumable(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.THE_END))
                .notConsumable(GTMultiMachines.VACUUM_FREEZER.getItem())
                .outputFluids(GTMaterials.LiquidEnderAir.getFluid(100000))
                .EUt(7680)
                .duration(2000)
                .save();
    }
}
