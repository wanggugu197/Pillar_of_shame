package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.utils.TagUtils;

import static org.gte.gtecore.common.data.GTERecipeTypes.RECYCLER_RECIPES;

interface Recycler {

    static void init() {
        RECYCLER_RECIPES.recipeBuilder(GTECore.id("recycler_a"))
                .inputItems(TagUtils.createTGTag("ingots"))
                .outputItems(GTEItems.SCRAP.asItem())
                .EUt(30)
                .duration(200)
                .save();

        RECYCLER_RECIPES.recipeBuilder(GTECore.id("recycler_b"))
                .inputItems(TagUtils.createTGTag("storage_blocks"))
                .outputItems(GTEItems.SCRAP.asStack(9))
                .EUt(120)
                .duration(200)
                .save();

        RECYCLER_RECIPES.recipeBuilder(GTECore.id("recycler_c"))
                .inputItems(TagUtils.createTGTag("gems"))
                .outputItems(GTEItems.SCRAP.asItem())
                .EUt(30)
                .duration(200)
                .save();
    }
}
