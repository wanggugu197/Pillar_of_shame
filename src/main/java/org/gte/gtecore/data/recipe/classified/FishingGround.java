package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.FISHING_GROUND_RECIPES;

interface FishingGround {

    static void init() {
        FISHING_GROUND_RECIPES.recipeBuilder(GTECore.id("fishing_ground4"))
                .notConsumable(new ItemStack(Items.PUFFERFISH.asItem(), 64))
                .inputItems(TagPrefix.dustTiny, GTMaterials.Meat, 64)
                .outputItems(new ItemStack(Items.PUFFERFISH.asItem(), 32))
                .EUt(1)
                .duration(2000)
                .save();

        FISHING_GROUND_RECIPES.recipeBuilder(GTECore.id("fishing_ground3"))
                .notConsumable(new ItemStack(Items.TROPICAL_FISH.asItem(), 64))
                .inputItems(TagPrefix.dustTiny, GTMaterials.Meat, 64)
                .outputItems(new ItemStack(Items.TROPICAL_FISH.asItem(), 32))
                .EUt(1)
                .duration(2000)
                .save();

        FISHING_GROUND_RECIPES.recipeBuilder(GTECore.id("fishing_ground2"))
                .notConsumable(new ItemStack(Items.SALMON.asItem(), 64))
                .inputItems(TagPrefix.dustTiny, GTMaterials.Meat, 64)
                .outputItems(new ItemStack(Items.SALMON.asItem(), 32))
                .EUt(1)
                .duration(2000)
                .save();

        FISHING_GROUND_RECIPES.recipeBuilder(GTECore.id("fishing_ground1"))
                .notConsumable(new ItemStack(Items.COD.asItem(), 64))
                .inputItems(TagPrefix.dustTiny, GTMaterials.Meat, 64)
                .outputItems(new ItemStack(Items.COD.asItem(), 32))
                .EUt(1)
                .duration(2000)
                .save();
    }
}
