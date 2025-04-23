package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import committee.nova.mods.avaritia.init.registry.ModBlocks;

import static org.gte.gtecore.common.data.GTERecipeTypes.COMPRESSOR_RECIPES;

interface Compressor {

    static void init() {
        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("compressed_crafting_table"))
                .inputItems(new ItemStack(Blocks.CRAFTING_TABLE.asItem(), 64))
                .outputItems(ModBlocks.compressed_crafting_table.get().asItem())
                .EUt(480)
                .duration(200)
                .save();

        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("spacetime_block"))
                .inputItems(TagPrefix.ingot, GTEMaterials.SpaceTime, 9)
                .outputItems(TagPrefix.block, GTEMaterials.SpaceTime)
                .EUt(2013265920)
                .duration(3000)
                .save();

        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("spongebob"))
                .inputItems(TagPrefix.foil, GTMaterials.Polycaprolactam, 2)
                .outputItems(new ItemStack(Blocks.SPONGE.asItem()))
                .EUt(2)
                .duration(200)
                .save();

        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("graphite_ingot"))
                .inputItems(TagPrefix.dust, GTMaterials.Graphite)
                .outputItems(TagPrefix.ingot, GTMaterials.Graphite)
                .EUt(30)
                .duration(300)
                .save();

        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("bedrock"))
                .inputItems(TagPrefix.block, GTEMaterials.Bedrockium)
                .outputItems(new ItemStack(Blocks.BEDROCK.asItem()))
                .EUt(31457280)
                .duration(4000)
                .save();

        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("netherite_block"))
                .inputItems(TagPrefix.ingot, GTMaterials.Netherite, 9)
                .outputItems(new ItemStack(Blocks.NETHERITE_BLOCK.asItem()))
                .EUt(2)
                .duration(300)
                .save();

        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("alumina_ceramic"))
                .inputItems(TagPrefix.dust, GTEMaterials.AluminaCeramic, 10)
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.AluminaCeramic)
                .EUt(120)
                .duration(800)
                .save();

        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("superheavy_mix"))
                .inputItems(TagPrefix.dust, GTEMaterials.SuperheavyMix, 9)
                .outputItems(TagPrefix.block, GTEMaterials.SuperheavyMix)
                .EUt(524288)
                .duration(200)
                .save();

        COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("diamond_lattice_block"))
                .inputItems("avaritia:diamond_lattice", 9)
                .outputItems("avaritia:diamond_lattice_block")
                .EUt(1920)
                .duration(400)
                .save();

        COMPRESSOR_RECIPES.builder("dense_steel_plate")
                .inputItems(TagPrefix.plate, GTMaterials.Steel, 9)
                .outputItems(TagPrefix.plateDense, GTMaterials.Steel)
                .EUt(30)
                .duration(800)
                .save();
    }
}
