package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.LAMINATOR_RECIPES;

interface Laminator {

    static void init() {
        LAMINATOR_RECIPES.recipeBuilder(GTECore.id("fluix_covered_cable_1"))
                .inputItems("ae2:fluix_glass_cable")
                .outputItems("ae2:fluix_covered_cable")
                .inputFluids(GTMaterials.Rubber.getFluid(72))
                .EUt(20)
                .duration(30)
                .save();

        LAMINATOR_RECIPES.recipeBuilder(GTECore.id("fluix_covered_cable_2"))
                .inputItems("ae2:fluix_glass_cable", 4)
                .outputItems("ae2:fluix_covered_cable", 4)
                .inputFluids(GTMaterials.SiliconeRubber.getFluid(72))
                .EUt(20)
                .duration(30)
                .save();

        LAMINATOR_RECIPES.recipeBuilder(GTECore.id("fluix_covered_cable_3"))
                .inputItems("ae2:fluix_glass_cable", 16)
                .outputItems("ae2:fluix_covered_cable", 16)
                .inputFluids(GTMaterials.StyreneButadieneRubber.getFluid(72))
                .EUt(20)
                .duration(30)
                .save();
    }
}
