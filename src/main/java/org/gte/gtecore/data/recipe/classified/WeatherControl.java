package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;

import static org.gte.gtecore.common.data.GTERecipeTypes.WEATHER_CONTROL_RECIPES;

interface WeatherControl {

    static void init() {
        WEATHER_CONTROL_RECIPES.recipeBuilder(GTECore.id("3"))
                .circuitMeta(3)
                .EUt(30)
                .duration(200)
                .save();

        WEATHER_CONTROL_RECIPES.recipeBuilder(GTECore.id("1"))
                .circuitMeta(1)
                .EUt(30)
                .duration(200)
                .save();

        WEATHER_CONTROL_RECIPES.recipeBuilder(GTECore.id("2"))
                .circuitMeta(2)
                .EUt(30)
                .duration(200)
                .save();
    }
}
