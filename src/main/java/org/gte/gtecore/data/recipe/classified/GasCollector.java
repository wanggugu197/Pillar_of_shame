package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.GAS_COLLECTOR_RECIPES;

interface GasCollector {

    static void init() {
        GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("barnarda_c"))
                .circuitMeta(6)
                .outputFluids(GTEMaterials.BarnardaAir.getFluid(10000))
                .EUt(1024)
                .duration(200)
                .dimension(GTEDimensions.BARNARDA_C)
                .save();

        GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("flat"))
                .circuitMeta(5)
                .outputFluids(GTMaterials.Air.getFluid(10000))
                .EUt(16)
                .duration(200)
                .dimension(GTEDimensions.FLAT)
                .save();

        GAS_COLLECTOR_RECIPES.recipeBuilder(GTECore.id("void"))
                .circuitMeta(4)
                .outputFluids(GTMaterials.Air.getFluid(10000))
                .EUt(16)
                .duration(200)
                .dimension(GTEDimensions.VOID)
                .save();
    }
}
