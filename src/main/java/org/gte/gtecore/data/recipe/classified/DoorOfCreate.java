package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.GTEDimensions;

import static org.gte.gtecore.common.data.GTERecipeTypes.DOOR_OF_CREATE_RECIPES;

interface DoorOfCreate {

    static void init() {
        DOOR_OF_CREATE_RECIPES.recipeBuilder(GTECore.id("1"))
                .circuitMeta(1)
                .EUt(8053063680L)
                .duration(20)
                .dimension(GTEDimensions.OVERWORLD)
                .save();
    }
}
