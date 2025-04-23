package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.GAS_COMPRESSOR_RECIPES;

interface GasCompressor {

    static void init() {
        GAS_COMPRESSOR_RECIPES.builder("high_pressure_nitrogen")
                .inputFluids(GTMaterials.Nitrogen, 1000)
                .outputFluids(GTEMaterials.HighPressureNitrogen, 1000)
                .EUt(30)
                .duration(600)
                .save();

        GAS_COMPRESSOR_RECIPES.builder("high_pressure_hydrogen")
                .inputFluids(GTMaterials.Hydrogen, 1000)
                .outputFluids(GTEMaterials.HighPressureHydrogen, 1000)
                .EUt(480)
                .duration(400)
                .save();

        GAS_COMPRESSOR_RECIPES.builder("high_pressure_oxygen")
                .inputFluids(GTMaterials.Oxygen, 1000)
                .outputFluids(GTEMaterials.HighPressureOxygen, 1000)
                .EUt(120)
                .duration(400)
                .save();

        GAS_COMPRESSOR_RECIPES.builder("high_pressure_steam")
                .inputFluids(GTMaterials.Steam, 120000)
                .outputFluids(GTEMaterials.HighPressureSteam, 30000)
                .EUt(120)
                .duration(1000)
                .save();
    }
}
