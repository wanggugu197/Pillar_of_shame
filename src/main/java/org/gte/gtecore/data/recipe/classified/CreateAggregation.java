package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.GTEDimensions;

import static org.gte.gtecore.common.data.GTERecipeTypes.CREATE_AGGREGATION_RECIPES;

interface CreateAggregation {

    static void init() {
        CREATE_AGGREGATION_RECIPES.recipeBuilder(GTECore.id("1"))
                .circuitMeta(1)
                .EUt(32212254720L)
                .duration(20)
                .dimension(GTEDimensions.CREATE)
                .save();
    }
}
