package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.HEAT_EXCHANGER_RECIPES;

interface HeatExchanger {

    static void init() {
        HEAT_EXCHANGER_RECIPES.recipeBuilder(GTECore.id("hot_sodium_potassium"))
                .inputFluids(GTEMaterials.HotSodiumPotassium.getFluid(1))
                .inputFluids(GTMaterials.Water.getFluid(160))
                .outputFluids(GTMaterials.SodiumPotassium.getFluid(1))
                .outputFluids(GTMaterials.Steam.getFluid(25600))
                .outputFluids(GTEMaterials.HighPressureSteam.getFluid(6400))
                .duration(200)
                .save();

        HEAT_EXCHANGER_RECIPES.recipeBuilder(GTECore.id("supercritical_sodium_potassium"))
                .inputFluids(GTEMaterials.SupercriticalSodiumPotassium.getFluid(1))
                .inputFluids(GTMaterials.DistilledWater.getFluid(80))
                .outputFluids(GTMaterials.SodiumPotassium.getFluid(1))
                .outputFluids(GTEMaterials.HighPressureSteam.getFluid(3200))
                .outputFluids(GTEMaterials.SupercriticalSteam.getFluid(800))
                .duration(200)
                .save();
    }
}
