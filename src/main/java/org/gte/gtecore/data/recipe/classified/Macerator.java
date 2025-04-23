package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.TagUtils;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import com.enderio.base.common.init.EIOItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.MACERATOR_RECIPES;

interface Macerator {

    static void init() {
        MACERATOR_RECIPES.recipeBuilder(GTECore.id("prescient_powder"))
                .inputItems(EIOItems.PRESCIENT_CRYSTAL.asItem())
                .outputItems(EIOItems.PRESCIENT_POWDER.asItem())
                .EUt(30)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("spacetime_dust"))
                .inputItems(TagPrefix.ingot, GTEMaterials.SpaceTime)
                .outputItems(TagPrefix.dust, GTEMaterials.SpaceTime)
                .EUt(2013265920)
                .duration(400)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("essence"))
                .inputItems(GTEBlocks.ESSENCE_BLOCK.asItem())
                .outputItems(GTEItems.ESSENCE.asItem())
                .chancedOutput(GTEItems.ESSENCE.asStack(), 5000, 400)
                .chancedOutput(GTEItems.ESSENCE.asStack(), 5000, 200)
                .chancedOutput(GTEItems.ESSENCE.asStack(), 5000, 100)
                .EUt(30)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("silicon_dust"))
                .inputItems(new ItemStack(AEItems.SILICON.asItem()))
                .outputItems(TagPrefix.dust, GTMaterials.Silicon)
                .EUt(16)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("vibrant_powder"))
                .inputItems(EIOItems.VIBRANT_CRYSTAL.asItem())
                .outputItems(EIOItems.VIBRANT_POWDER.asItem())
                .EUt(30)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("draconium_dust"))
                .inputItems(GTEBlocks.DRACONIUM_BLOCK_CHARGED.asItem())
                .outputItems(GTEItems.DRACONIUM_DIRT.asStack(9))
                .outputItems(TagPrefix.dust, GTMaterials.Obsidian)
                .outputItems(TagPrefix.dust, GTMaterials.EnderEye)
                .outputItems(TagPrefix.dust, GTMaterials.Redstone)
                .EUt(1920)
                .duration(400)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("sculk_catalyst"))
                .inputItems(new ItemStack(Blocks.SCULK_CATALYST.asItem()))
                .outputItems(TagPrefix.dust, GTMaterials.EchoShard)
                .EUt(7)
                .duration(100)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("sculk_shrieker"))
                .inputItems(new ItemStack(Blocks.SCULK_SHRIEKER.asItem()))
                .outputItems(TagPrefix.dust, GTMaterials.EchoShard)
                .EUt(7)
                .duration(100)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("pulsating_powder"))
                .inputItems(EIOItems.PULSATING_CRYSTAL.asItem())
                .outputItems(EIOItems.PULSATING_POWDER.asItem())
                .EUt(30)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("sculk_sensor"))
                .inputItems(new ItemStack(Blocks.SCULK_SENSOR.asItem()))
                .outputItems(TagPrefix.dust, GTMaterials.EchoShard)
                .EUt(7)
                .duration(100)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("ender_crystal_powder"))
                .inputItems(EIOItems.ENDER_CRYSTAL.asItem())
                .outputItems(EIOItems.ENDER_CRYSTAL_POWDER.asItem())
                .EUt(30)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("degenerate_rhenium_dust"))
                .inputItems(TagPrefix.plate, GTEMaterials.DegenerateRhenium)
                .outputItems(TagPrefix.dust, GTEMaterials.DegenerateRhenium)
                .EUt(31457280)
                .duration(100)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("prismarine_shard"))
                .inputItems(new ItemStack(Blocks.PRISMARINE.asItem()))
                .outputItems(new ItemStack(Items.PRISMARINE_SHARD.asItem()))
                .EUt(2)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("wheat_seeds"))
                .inputItems(new ItemStack(Items.WHEAT.asItem()))
                .outputItems(new ItemStack(Blocks.WHEAT.asItem(), 64))
                .EUt(2)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("sky_dust"))
                .inputItems(new ItemStack(AEBlocks.SKY_STONE_BLOCK.block().asItem()))
                .outputItems(new ItemStack(AEItems.SKY_DUST.asItem()))
                .EUt(2)
                .duration(200)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("treated_wood_dust"))
                .inputItems(GTBlocks.TREATED_WOOD_PLANK.asItem())
                .outputItems(TagPrefix.dust, GTMaterials.TreatedWood)
                .EUt(2)
                .duration(98)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("algae_paper"))
                .inputItems(TagUtils.createTag(GTECore.id("algae_fiber")))
                .outputItems(TagPrefix.dust, GTMaterials.Paper)
                .duration(320)
                .EUt(2)
                .save();

        MACERATOR_RECIPES.recipeBuilder(GTECore.id("yeast"))
                .inputItems(Items.SWEET_BERRIES.asItem())
                .chancedOutput(TagPrefix.dust, GTEMaterials.Yeast, 500, 500)
                .EUt(30)
                .duration(50)
                .save();
    }
}
