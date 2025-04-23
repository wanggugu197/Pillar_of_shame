package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.WATER_PURIFICATION_PLANT_RECIPES;

interface WaterPurificationPlant {

    static void init() {
        WATER_PURIFICATION_PLANT_RECIPES.recipeBuilder(GTECore.id("a"))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTEMaterials.FilteredSater.getFluid(1000))
                .duration(2400)
                .addData("tier", 1)
                .save();

        WATER_PURIFICATION_PLANT_RECIPES.recipeBuilder(GTECore.id("b"))
                .inputFluids(GTEMaterials.FilteredSater.getFluid(1000))
                .outputFluids(GTEMaterials.OzoneWater.getFluid(1000))
                .duration(2400)
                .addData("tier", 2)
                .save();

        WATER_PURIFICATION_PLANT_RECIPES.recipeBuilder(GTECore.id("c"))
                .inputFluids(GTEMaterials.OzoneWater.getFluid(1000))
                .outputFluids(GTEMaterials.FlocculentWater.getFluid(1000))
                .duration(2400)
                .addData("tier", 3)
                .save();

        WATER_PURIFICATION_PLANT_RECIPES.recipeBuilder(GTECore.id("d"))
                .inputFluids(GTEMaterials.FlocculentWater.getFluid(1000))
                .outputFluids(GTEMaterials.PHNeutralWater.getFluid(1000))
                .duration(2400)
                .addData("tier", 4)
                .save();

        WATER_PURIFICATION_PLANT_RECIPES.recipeBuilder(GTECore.id("e"))
                .inputFluids(GTEMaterials.PHNeutralWater.getFluid(1000))
                .outputFluids(GTEMaterials.ExtremeTemperatureWater.getFluid(1000))
                .duration(2400)
                .addData("tier", 5)
                .save();

        WATER_PURIFICATION_PLANT_RECIPES.recipeBuilder(GTECore.id("f"))
                .inputFluids(GTEMaterials.ExtremeTemperatureWater.getFluid(1000))
                .outputFluids(GTEMaterials.ElectricEquilibriumWater.getFluid(1000))
                .duration(2400)
                .addData("tier", 6)
                .save();

        WATER_PURIFICATION_PLANT_RECIPES.recipeBuilder(GTECore.id("g"))
                .inputFluids(GTEMaterials.ElectricEquilibriumWater.getFluid(1000))
                .outputFluids(GTEMaterials.DegassedWater.getFluid(1000))
                .duration(2400)
                .addData("tier", 7)
                .save();

        WATER_PURIFICATION_PLANT_RECIPES.recipeBuilder(GTECore.id("h"))
                .inputFluids(GTEMaterials.DegassedWater.getFluid(1000))
                .outputFluids(GTEMaterials.BaryonicPerfectionWater.getFluid(1000))
                .duration(2400)
                .addData("tier", 8)
                .save();
    }
}
