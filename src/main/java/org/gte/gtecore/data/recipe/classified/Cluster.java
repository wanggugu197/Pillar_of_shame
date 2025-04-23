package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.common.data.GTEItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.CLUSTER_RECIPES;

interface Cluster {

    static void init() {
        CLUSTER_RECIPES.builder("mica_insulator_foil")
                .inputItems(GTEItems.MICA_INSULATOR_SHEET.asItem())
                .outputItems(GTEItems.MICA_INSULATOR_FOIL.asStack(4))
                .EUt(30)
                .duration(100)
                .save();
    }
}
