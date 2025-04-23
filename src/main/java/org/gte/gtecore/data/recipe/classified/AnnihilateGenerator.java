package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.ANNIHILATE_GENERATOR_RECIPES;

interface AnnihilateGenerator {

    static void init() {
        ANNIHILATE_GENERATOR_RECIPES.recipeBuilder(GTECore.id("neutronium_antimatter_fuel_rod"))
                .inputItems(GTEItems.NEUTRONIUM_ANTIMATTER_FUEL_ROD.asItem())
                .chancedOutput(GTEItems.ANNIHILATION_CONSTRAINER.asStack(), 9000, 0)
                .EUt(-549755813888L)
                .duration(200)
                .save();

        ANNIHILATE_GENERATOR_RECIPES.recipeBuilder(GTECore.id("draconium_antimatter_fuel_rod"))
                .inputItems(GTEItems.DRACONIUM_ANTIMATTER_FUEL_ROD.asItem())
                .chancedOutput(GTEItems.ANNIHILATION_CONSTRAINER.asStack(), 8000, 0)
                .EUt(-8796093022208L)
                .duration(200)
                .save();

        ANNIHILATE_GENERATOR_RECIPES.recipeBuilder(GTECore.id("cosmic_neutronium_antimatter_fuel_rod"))
                .inputItems(GTEItems.COSMIC_NEUTRONIUM_ANTIMATTER_FUEL_ROD.asItem())
                .chancedOutput(GTEItems.ANNIHILATION_CONSTRAINER.asStack(), 7000, 0)
                .EUt(-140737488355328L)
                .duration(200)
                .save();

        ANNIHILATE_GENERATOR_RECIPES.recipeBuilder(GTECore.id("infinity_antimatter_fuel_rod"))
                .inputItems(GTEItems.INFINITY_ANTIMATTER_FUEL_ROD.asItem())
                .chancedOutput(GTEItems.ANNIHILATION_CONSTRAINER.asStack(), 6000, 0)
                .EUt(-2251799813685248L)
                .duration(200)
                .save();
    }
}
