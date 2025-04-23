package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import static org.gte.gtecore.common.data.GTERecipeTypes.GRAVITATION_SHOCKBURST_RECIPES;

interface GravitationShockburst {

    static void init() {
        GRAVITATION_SHOCKBURST_RECIPES.recipeBuilder(GTECore.id("command_block_broken"))
                .inputItems(new ItemStack(Blocks.COMMAND_BLOCK.asItem()))
                .inputItems(TagPrefix.dust, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .outputItems(GTEBlocks.COMMAND_BLOCK_BROKEN.asItem())
                .EUt(131941395333120L)
                .duration(20)
                .save();

        GRAVITATION_SHOCKBURST_RECIPES.recipeBuilder(GTECore.id("repeating_command_block_core"))
                .inputItems(GTEItems.CHAIN_COMMAND_BLOCK_CORE.asItem())
                .inputItems(new ItemStack(Blocks.CALIBRATED_SCULK_SENSOR.asItem(), 64))
                .outputItems(GTEItems.REPEATING_COMMAND_BLOCK_CORE.asItem())
                .EUt(131941395333120L)
                .duration(20)
                .save();

        GRAVITATION_SHOCKBURST_RECIPES.recipeBuilder(GTECore.id("chain_command_block_core"))
                .inputItems(GTEItems.COMMAND_BLOCK_CORE.asItem())
                .inputItems(new ItemStack(Blocks.OBSERVER.asItem(), 64))
                .outputItems(GTEItems.CHAIN_COMMAND_BLOCK_CORE.asItem())
                .EUt(131941395333120L)
                .duration(20)
                .save();

        GRAVITATION_SHOCKBURST_RECIPES.recipeBuilder(GTECore.id("chain_command_block_broken"))
                .inputItems(new ItemStack(Blocks.CHAIN_COMMAND_BLOCK.asItem()))
                .inputItems(TagPrefix.dust, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .outputItems(GTEBlocks.CHAIN_COMMAND_BLOCK_BROKEN.asItem())
                .EUt(131941395333120L)
                .duration(20)
                .save();
    }
}
