package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.EVAPORATION_RECIPES;

interface Evaporation {

    static void init() {
        EVAPORATION_RECIPES.recipeBuilder(GTECore.id("salt_water"))
                .inputFluids(GTMaterials.Water.getFluid(50000))
                .outputFluids(GTMaterials.SaltWater.getFluid(1000))
                .EUt(30)
                .duration(600)
                .save();
    }
}
