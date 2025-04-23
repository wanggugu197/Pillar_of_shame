package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import static org.gte.gtecore.common.data.GTERecipeTypes.DRAGON_EGG_COPIER_RECIPES;

interface DragonEggCopier {

    static void init() {
        DRAGON_EGG_COPIER_RECIPES.recipeBuilder(GTECore.id("dragon_egg_copier"))
                .inputItems(new ItemStack(Blocks.DRAGON_EGG.asItem()))
                .inputFluids(GTEMaterials.BiohmediumSterilized.getFluid(100))
                .outputItems(new ItemStack(Blocks.DRAGON_EGG.asItem()))
                .chancedOutput(new ItemStack(Blocks.DRAGON_EGG.asItem()), 2000, 1000)
                .EUt(122880)
                .duration(200)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();
    }
}
