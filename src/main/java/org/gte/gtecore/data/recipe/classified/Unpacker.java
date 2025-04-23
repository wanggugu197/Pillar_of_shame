package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.UNPACKER_RECIPES;

interface Unpacker {

    static void init() {
        UNPACKER_RECIPES.recipeBuilder(GTECore.id("carrot"))
                .inputItems("farmersdelight:carrot_crate")
                .outputItems(new ItemStack(Items.CARROT.asItem(), 9))
                .EUt(12)
                .duration(10)
                .save();

        UNPACKER_RECIPES.recipeBuilder(GTECore.id("potato"))
                .inputItems("farmersdelight:potato_crate")
                .outputItems(new ItemStack(Items.POTATO.asItem(), 9))
                .EUt(12)
                .duration(10)
                .save();

        UNPACKER_RECIPES.recipeBuilder(GTECore.id("beetroot"))
                .inputItems("farmersdelight:beetroot_crate")
                .outputItems(new ItemStack(Items.BEETROOT.asItem(), 9))
                .EUt(12)
                .duration(10)
                .save();

        UNPACKER_RECIPES.recipeBuilder(GTECore.id("cabbage"))
                .inputItems("farmersdelight:cabbage_crate")
                .outputItems("farmersdelight:cabbage", 9)
                .EUt(12)
                .duration(10)
                .save();

        UNPACKER_RECIPES.recipeBuilder(GTECore.id("tomato"))
                .inputItems("farmersdelight:tomato_crate")
                .outputItems("farmersdelight:tomato", 9)
                .EUt(12)
                .duration(10)
                .save();

        UNPACKER_RECIPES.recipeBuilder(GTECore.id("onion"))
                .inputItems("farmersdelight:onion_crate")
                .outputItems("farmersdelight:onion", 9)
                .EUt(12)
                .duration(10)
                .save();

        UNPACKER_RECIPES.recipeBuilder(GTECore.id("rice_panicle"))
                .inputItems("farmersdelight:rice_bale")
                .outputItems("farmersdelight:rice_panicle", 9)
                .EUt(12)
                .duration(10)
                .save();

        UNPACKER_RECIPES.recipeBuilder(GTECore.id("rice"))
                .inputItems("farmersdelight:rice_bag")
                .outputItems("farmersdelight:rice", 9)
                .EUt(12)
                .duration(10)
                .save();

        UNPACKER_RECIPES.recipeBuilder(GTECore.id("straw"))
                .inputItems("farmersdelight:straw_bale")
                .outputItems("farmersdelight:straw", 9)
                .EUt(12)
                .duration(10)
                .save();
    }
}
