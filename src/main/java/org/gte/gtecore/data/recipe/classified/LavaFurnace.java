package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.utils.RLUtils;
import org.gte.gtecore.utils.TagUtils;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.LAVA_FURNACE_RECIPES;

interface LavaFurnace {

    static void init() {
        LAVA_FURNACE_RECIPES.recipeBuilder(GTECore.id("lava_furnace"))
                .inputItems(TagUtils.createTag(RLUtils.forge("cobblestone")))
                .outputFluids(GTMaterials.Lava.getFluid(1000))
                .EUt(16)
                .duration(200)
                .save();

        LAVA_FURNACE_RECIPES.recipeBuilder(GTECore.id("lava_furnace1"))
                .inputItems(TagUtils.createTag(RLUtils.forge("stone")))
                .outputFluids(GTMaterials.Lava.getFluid(1000))
                .EUt(16)
                .duration(200)
                .save();
    }
}
