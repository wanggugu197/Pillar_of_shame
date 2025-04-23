package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.ALCHEMY_CAULDRON_RECIPES;

interface AlchemyCauldron {

    static void init() {
        ALCHEMY_CAULDRON_RECIPES.recipeBuilder(GTECore.id("coal_slurry"))
                .inputItems(TagPrefix.dust, GTMaterials.Coal, 2)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTEMaterials.CoalSlurry.getFluid(1000))
                .duration(240)
                .temperature(340)
                .save();
    }
}
