package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.FISSION_REACTOR_RECIPES;

interface FissionReactor {

    static void init() {
        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_uranium_dual"))
                .inputItems(GTEItems.REACTOR_URANIUM_DUAL.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_URANIUM_DUAL.asItem())
                .EUt(4)
                .duration(144000)
                .addData("FRheat", 5)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_uranium_quad"))
                .inputItems(GTEItems.REACTOR_URANIUM_QUAD.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_URANIUM_QUAD.asItem())
                .EUt(5)
                .duration(180000)
                .addData("FRheat", 6)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_naquadah_simple"))
                .inputItems(GTEItems.REACTOR_NAQUADAH_SIMPLE.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_NAQUADAH_SIMPLE.asItem())
                .EUt(3)
                .duration(160000)
                .addData("FRheat", 7)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_uranium_simple"))
                .inputItems(GTEItems.REACTOR_URANIUM_SIMPLE.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_URANIUM_SIMPLE.asItem())
                .EUt(3)
                .duration(112000)
                .addData("FRheat", 4)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_thorium_dual"))
                .inputItems(GTEItems.REACTOR_THORIUM_DUAL.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_THORIUM_DUAL.asItem())
                .EUt(8)
                .duration(172800)
                .addData("FRheat", 2)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_mox_quad"))
                .inputItems(GTEItems.REACTOR_MOX_QUAD.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_MOX_QUAD.asItem())
                .EUt(3)
                .duration(128000)
                .addData("FRheat", 8)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_thorium_quad"))
                .inputItems(GTEItems.REACTOR_THORIUM_QUAD.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_THORIUM_QUAD.asItem())
                .EUt(10)
                .duration(216000)
                .addData("FRheat", 3)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_mox_dual"))
                .inputItems(GTEItems.REACTOR_MOX_DUAL.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_MOX_DUAL.asItem())
                .EUt(2)
                .duration(100800)
                .addData("FRheat", 7)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_mox_simple"))
                .inputItems(GTEItems.REACTOR_MOX_SIMPLE.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_MOX_SIMPLE.asItem())
                .EUt(1)
                .duration(78400)
                .addData("FRheat", 6)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_naquadah_quad"))
                .inputItems(GTEItems.REACTOR_NAQUADAH_QUAD.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_NAQUADAH_QUAD.asItem())
                .EUt(7)
                .duration(360000)
                .addData("FRheat", 9)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_naquadah_dual"))
                .inputItems(GTEItems.REACTOR_NAQUADAH_DUAL.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_NAQUADAH_DUAL.asItem())
                .EUt(5)
                .duration(240000)
                .addData("FRheat", 8)
                .save();

        FISSION_REACTOR_RECIPES.recipeBuilder(GTECore.id("reactor_thorium_simple"))
                .inputItems(GTEItems.REACTOR_THORIUM_SIMPLE.asItem())
                .outputItems(GTEItems.DEPLETED_REACTOR_THORIUM_SIMPLE.asItem())
                .EUt(6)
                .duration(134400)
                .addData("FRheat", 1)
                .save();
    }
}
