package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import committee.nova.mods.avaritia.init.registry.ModBlocks;
import committee.nova.mods.avaritia.init.registry.ModItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES;
import static org.gte.gtecore.common.data.GTERecipeTypes.IMPLOSION_RECIPES;

interface ImplosionCompressor {

    static void init() {
        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("diamond_lattice_tnt"))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.ManaDiamond, 4)
                .inputItems(new ItemStack(Items.NETHERITE_SCRAP.asItem()))
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(ModItems.diamond_lattice.get())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("command_block_core_tnt"))
                .inputItems(new ItemStack(Blocks.COMMAND_BLOCK.asItem()))
                .inputItems(GTEItems.TWO_WAY_FOIL.asItem())
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(GTEItems.COMMAND_BLOCK_CORE.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("compressed_chest_tnt"))
                .inputItems(new ItemStack(Blocks.CHEST.asItem(), 2))
                .inputItems(new ItemStack(AEBlocks.SMOOTH_SKY_STONE_CHEST.block().asItem(), 2))
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(ModBlocks.compressed_chest.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("neutron_nugget_tnt"))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(ModItems.neutron_nugget.get())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("crystal_matrix_itnt"))
                .inputItems(ModBlocks.diamond_lattice_block.get().asItem())
                .inputItems(TagPrefix.gem, GTMaterials.NetherStar)
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(ModBlocks.crystal_matrix.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("diamond_lattice_dynamite"))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.ManaDiamond, 4)
                .inputItems(new ItemStack(Items.NETHERITE_SCRAP.asItem()))
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(ModItems.diamond_lattice.get())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("double_compressed_crafting_table_powderbarrel"))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(ModBlocks.double_compressed_crafting_table.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("diamond_lattice_itnt"))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.ManaDiamond, 4)
                .inputItems(new ItemStack(Items.NETHERITE_SCRAP.asItem()))
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(ModItems.diamond_lattice.get())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_1_dynamite"))
                .inputItems(TagPrefix.plateDouble, GTMaterials.StainlessSteel, 4)
                .inputItems(TagPrefix.plateDense, GTMaterials.Steel, 2)
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_1.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("double_compressed_crafting_table_itnt"))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(ModBlocks.double_compressed_crafting_table.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("command_block_core_dynamite"))
                .inputItems(new ItemStack(Blocks.COMMAND_BLOCK.asItem()))
                .inputItems(GTEItems.TWO_WAY_FOIL.asItem())
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(GTEItems.COMMAND_BLOCK_CORE.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("command_block_core_powderbarrel"))
                .inputItems(new ItemStack(Blocks.COMMAND_BLOCK.asItem()))
                .inputItems(GTEItems.TWO_WAY_FOIL.asItem())
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(GTEItems.COMMAND_BLOCK_CORE.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_1_powderbarrel"))
                .inputItems(TagPrefix.plateDouble, GTMaterials.StainlessSteel, 4)
                .inputItems(TagPrefix.plateDense, GTMaterials.Steel, 2)
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_1.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("compressed_chest_powderbarrel"))
                .inputItems(new ItemStack(Blocks.CHEST.asItem(), 2))
                .inputItems(new ItemStack(AEBlocks.SMOOTH_SKY_STONE_CHEST.block().asItem(), 2))
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(ModBlocks.compressed_chest.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_3_dynamite"))
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_2.asStack(4))
                .inputItems(TagPrefix.plateDense, GTMaterials.TungstenSteel, 2)
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_3.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_1_itnt"))
                .inputItems(TagPrefix.plateDouble, GTMaterials.StainlessSteel, 4)
                .inputItems(TagPrefix.plateDense, GTMaterials.Steel, 2)
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_1.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("compressed_chest_dynamite"))
                .inputItems(new ItemStack(Blocks.CHEST.asItem(), 2))
                .inputItems(new ItemStack(AEBlocks.SMOOTH_SKY_STONE_CHEST.block().asItem(), 2))
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(ModBlocks.compressed_chest.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("entangled_singularity_powderbarrel"))
                .inputItems(new ItemStack(AEItems.SINGULARITY.asItem()))
                .inputItems(GTEItems.WARPED_ENDER_PEARL.asItem())
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(GTEItems.ENTANGLED_SINGULARITY.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("crystal_matrix_tnt"))
                .inputItems(ModBlocks.diamond_lattice_block.get().asItem())
                .inputItems(TagPrefix.gem, GTMaterials.NetherStar)
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(ModBlocks.crystal_matrix.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("entangled_singularity_itnt"))
                .inputItems(new ItemStack(AEItems.SINGULARITY.asItem()))
                .inputItems(GTEItems.WARPED_ENDER_PEARL.asItem())
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(GTEItems.ENTANGLED_SINGULARITY.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_3_tnt"))
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_2.asStack(4))
                .inputItems(TagPrefix.plateDense, GTMaterials.TungstenSteel, 2)
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_3.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("diamond_lattice_powderbarrel"))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.ManaDiamond, 4)
                .inputItems(new ItemStack(Items.NETHERITE_SCRAP.asItem()))
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(ModItems.diamond_lattice.get())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_3_powderbarrel"))
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_2.asStack(4))
                .inputItems(TagPrefix.plateDense, GTMaterials.TungstenSteel, 2)
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_3.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("crystal_matrix_dynamite"))
                .inputItems(ModBlocks.diamond_lattice_block.get().asItem())
                .inputItems(TagPrefix.gem, GTMaterials.NetherStar)
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(ModBlocks.crystal_matrix.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_3_itnt"))
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_2.asStack(4))
                .inputItems(TagPrefix.plateDense, GTMaterials.TungstenSteel, 2)
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_3.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("neutron_nugget_powderbarrel"))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(ModItems.neutron_nugget.get())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("neutron_nugget_itnt"))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(ModItems.neutron_nugget.get())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("double_compressed_crafting_table_dynamite"))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(ModBlocks.double_compressed_crafting_table.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("double_compressed_crafting_table_tnt"))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(ModBlocks.double_compressed_crafting_table.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("entangled_singularity_dynamite"))
                .inputItems(new ItemStack(AEItems.SINGULARITY.asItem()))
                .inputItems(GTEItems.WARPED_ENDER_PEARL.asItem())
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(GTEItems.ENTANGLED_SINGULARITY.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("neutron_nugget_dynamite"))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(GTItems.DYNAMITE.asStack(2))
                .outputItems(ModItems.neutron_nugget.get())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("entangled_singularity_tnt"))
                .inputItems(new ItemStack(AEItems.SINGULARITY.asItem()))
                .inputItems(GTEItems.WARPED_ENDER_PEARL.asItem())
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(GTEItems.ENTANGLED_SINGULARITY.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_1_tnt"))
                .inputItems(TagPrefix.plateDouble, GTMaterials.StainlessSteel, 4)
                .inputItems(TagPrefix.plateDense, GTMaterials.Steel, 2)
                .inputItems(new ItemStack(Blocks.TNT.asItem(), 4))
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_1.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("crystal_matrix_powderbarrel"))
                .inputItems(ModBlocks.diamond_lattice_block.get().asItem())
                .inputItems(TagPrefix.gem, GTMaterials.NetherStar)
                .inputItems(GTBlocks.POWDERBARREL.asStack(8))
                .outputItems(ModBlocks.crystal_matrix.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("command_block_core_itnt"))
                .inputItems(new ItemStack(Blocks.COMMAND_BLOCK.asItem()))
                .inputItems(GTEItems.TWO_WAY_FOIL.asItem())
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(GTEItems.COMMAND_BLOCK_CORE.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        IMPLOSION_RECIPES.recipeBuilder(GTECore.id("compressed_chest_itnt"))
                .inputItems(new ItemStack(Blocks.CHEST.asItem(), 2))
                .inputItems(new ItemStack(AEBlocks.SMOOTH_SKY_STONE_CHEST.block().asItem(), 2))
                .inputItems(GTBlocks.INDUSTRIAL_TNT.asItem())
                .outputItems(ModBlocks.compressed_chest.get().asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.DarkAsh, 2500, 0)
                .EUt(30)
                .duration(20)
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("double_compressed_crafting_table"))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .inputItems(new ItemStack(ModBlocks.compressed_crafting_table.get().asItem(), 64))
                .outputItems(ModBlocks.double_compressed_crafting_table.get().asItem())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("compressed_chest"))
                .inputItems(new ItemStack(Blocks.CHEST.asItem(), 2))
                .inputItems(new ItemStack(AEBlocks.SMOOTH_SKY_STONE_CHEST.block().asItem(), 2))
                .outputItems(ModBlocks.compressed_chest.get().asItem())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("eternal_singularity"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Eternity, 16)
                .inputItems(TagPrefix.dust, GTEMaterials.SpaceTime)
                .outputItems(ModItems.eternal_singularity.get())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("crystal_matrix"))
                .inputItems(ModBlocks.diamond_lattice_block.get().asItem())
                .inputItems(TagPrefix.gem, GTMaterials.NetherStar)
                .outputItems(ModBlocks.crystal_matrix.get().asItem())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("command_block_core"))
                .inputItems(new ItemStack(Blocks.COMMAND_BLOCK.asItem()))
                .inputItems(GTEItems.TWO_WAY_FOIL.asItem())
                .outputItems(GTEItems.COMMAND_BLOCK_CORE.asItem())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("neutron_nugget"))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .inputItems(new ItemStack(ModItems.neutron_pile.get(), 64))
                .outputItems(ModItems.neutron_nugget.get())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("diamond_lattice"))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.ManaDiamond, 4)
                .inputItems(new ItemStack(Items.NETHERITE_SCRAP.asItem()))
                .outputItems(ModItems.diamond_lattice.get())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_3"))
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_2.asStack(4))
                .inputItems(TagPrefix.plateDense, GTMaterials.TungstenSteel, 2)
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_3.asItem())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_1"))
                .inputItems(TagPrefix.plateDouble, GTMaterials.StainlessSteel, 4)
                .inputItems(TagPrefix.plateDense, GTMaterials.Steel, 2)
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_1.asItem())
                .save();

        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("entangled_singularity"))
                .inputItems(new ItemStack(AEItems.SINGULARITY.asItem()))
                .inputItems(GTEItems.WARPED_ENDER_PEARL.asItem())
                .outputItems(GTEItems.ENTANGLED_SINGULARITY.asItem())
                .save();
    }
}
