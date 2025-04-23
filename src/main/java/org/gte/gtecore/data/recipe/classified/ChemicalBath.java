package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import appeng.core.definitions.AEBlocks;

import static org.gte.gtecore.common.data.GTERecipeTypes.CHEMICAL_BATH_RECIPES;

interface ChemicalBath {

    static void init() {
        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("petri_dish"))
                .inputItems(GTEItems.CONTAMINATED_PETRI_DISH)
                .outputItems(GTItems.PETRI_DISH)
                .inputFluids(GTEMaterials.PiranhaSolution.getFluid(100))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(25).EUt(30).save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("naquadria_sulfate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium, 6)
                .inputFluids(GTEMaterials.AcidicNaquadriaCaesiumfluoride.getFluid(3000))
                .outputItems(TagPrefix.dust, GTMaterials.NaquadriaSulfate, 6)
                .outputItems(TagPrefix.dust, GTMaterials.TriniumSulfide, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 8)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumSulfate, 7)
                .chancedOutput(TagPrefix.dust, GTMaterials.Caesium, 8000, 500)
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("caesium_hydroxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Caesium, 2)
                .inputFluids(GTMaterials.HydrogenPeroxide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.CaesiumHydroxide, 6)
                .EUt(120)
                .duration(180)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("glucose"))
                .inputItems(TagPrefix.gem, GTMaterials.Sugar, 2)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Glucose, 24)
                .EUt(480)
                .duration(300)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("kevlar_plate"))
                .inputItems(GTEItems.WOVEN_KEVLAR.asItem())
                .inputFluids(GTEMaterials.PolyurethaneResin.getFluid(1000))
                .outputItems(TagPrefix.plate, GTEMaterials.Kevlar)
                .EUt(480)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("photon_carrying_wafer"))
                .inputItems(GTEItems.RAW_PHOTON_CARRYING_WAFER.asItem())
                .inputFluids(GTMaterials.Blaze.getFluid(288))
                .outputItems(GTEItems.PHOTON_CARRYING_WAFER.asItem())
                .EUt(1920)
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("high_strength_concrete"))
                .inputItems(TagPrefix.frameGt, GTMaterials.Steel)
                .inputFluids(GTMaterials.Concrete.getFluid(1152))
                .outputItems(GTEBlocks.HIGH_STRENGTH_CONCRETE.asItem())
                .EUt(480)
                .duration(200)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("damascus_steel_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Steel)
                .inputFluids(GTMaterials.Lubricant.getFluid(100))
                .outputItems(TagPrefix.dust, GTMaterials.DamascusSteel)
                .EUt(120)
                .duration(200)
                .dimension(GTEDimensions.ANCIENT_WORLD)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("end_stone"))
                .inputItems(new ItemStack(Blocks.ANDESITE.asItem()))
                .inputFluids(GTMaterials.LiquidEnderAir.getFluid(1000))
                .outputItems(TagPrefix.rock, GTMaterials.Endstone)
                .EUt(480)
                .duration(800)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("resonating_gem"))
                .inputItems(TagPrefix.gemExquisite, GTMaterials.Sapphire)
                .inputFluids(GTEMaterials.LiquidStarlight.getFluid(1000))
                .outputItems(GTEItems.RESONATING_GEM.asItem())
                .EUt(31457280)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("leached_turpentine"))
                .inputItems(Blocks.DARK_OAK_LOG.asItem(), 16)
                .inputFluids(GTMaterials.Naphtha.getFluid(1000))
                .outputFluids(GTEMaterials.LeachedTurpentine.getFluid(1000))
                .EUt(480)
                .duration(80)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("vibrant_alloy_ingot"))
                .inputItems(TagPrefix.ingotHot, GTEMaterials.VibrantAlloy)
                .inputFluids(GTEMaterials.CoolantLiquid.getFluid(100))
                .outputItems(TagPrefix.ingot, GTEMaterials.VibrantAlloy)
                .EUt(120)
                .duration(280)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("electronic_grade_silicon"))
                .inputItems(TagPrefix.ingotHot, GTEMaterials.ElectronicGradeSilicon)
                .outputItems(TagPrefix.ingot, GTEMaterials.ElectronicGradeSilicon)
                .inputFluids(GTEMaterials.CoolantLiquid.getFluid(100))
                .EUt(120)
                .duration(250)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("terrasteel_silicon"))
                .inputItems(TagPrefix.ingotHot, GTEMaterials.Terrasteel)
                .outputItems(TagPrefix.ingot, GTEMaterials.Terrasteel)
                .inputFluids(GTEMaterials.CoolantLiquid.getFluid(100))
                .EUt(120)
                .duration(230)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("sculk_vein"))
                .inputItems(new ItemStack(Blocks.VINE.asItem()))
                .inputFluids(GTMaterials.EchoShard.getFluid(10))
                .outputItems(new ItemStack(Blocks.SCULK_VEIN.asItem()))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("x_ray_waveguide"))
                .inputItems(GTEItems.FULLERENE_POLYMER_MATRIX_FINE_TUBING.asItem())
                .inputFluids(GTEMaterials.IridiumTrichlorideSolution.getFluid(100))
                .outputItems(GTEItems.X_RAY_WAVEGUIDE.asItem())
                .EUt(8000000)
                .duration(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("netherrack"))
                .inputItems(new ItemStack(Blocks.GRANITE.asItem()))
                .inputFluids(GTMaterials.LiquidNetherAir.getFluid(1000))
                .outputItems(TagPrefix.rock, GTMaterials.Netherrack)
                .EUt(120)
                .duration(800)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("x_ray_mirror_plate"))
                .inputItems(TagPrefix.plate, GTMaterials.Graphene)
                .inputFluids(GTEMaterials.IridiumTrichlorideSolution.getFluid(100))
                .outputItems(GTEItems.X_RAY_MIRROR_PLATE.asItem())
                .EUt(2000000)
                .duration(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("black_candle"))
                .inputItems(new ItemStack(Blocks.TRIPWIRE.asItem()))
                .inputFluids(GTMaterials.Oil.getFluid(100))
                .outputItems(new ItemStack(Blocks.BLACK_CANDLE.asItem()))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("ash_leaching_solution"))
                .inputItems(TagPrefix.dust, GTMaterials.Ash, 12)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.AshLeachingSolution.getFluid(1000))
                .EUt(120)
                .duration(400)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("fullerene_polymer_matrix_pulp_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PalladiumFullereneMatrix)
                .inputFluids(GTEMaterials.PCBs.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.FullerenePolymerMatrixPulp, 2)
                .EUt(8000000)
                .duration(40)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("metal_residue_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PartiallyOxidizedResidues)
                .inputFluids(GTEMaterials.BedrockGas.getFluid(100))
                .outputItems(TagPrefix.dust, GTEMaterials.MetalResidue)
                .EUt(122880)
                .duration(200)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("ender_obsidian"))
                .inputItems(GTEBlocks.SHINING_OBSIDIAN.asItem())
                .inputFluids(GTMaterials.EnderEye.getFluid(1152))
                .outputItems(GTEBlocks.ENDER_OBSIDIAN.asItem())
                .EUt(480)
                .duration(200)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("flawless_budding_quartz"))
                .inputItems(new ItemStack(AEBlocks.FLAWED_BUDDING_QUARTZ.block().asItem()))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(new ItemStack(AEBlocks.FLAWLESS_BUDDING_QUARTZ.block().asItem()))
                .EUt(30)
                .duration(400)
                .save();

        CHEMICAL_BATH_RECIPES.recipeBuilder(GTECore.id("eternity_catalyst"))
                .inputItems(GTEItems.SPACETIME_CATALYST.asItem())
                .inputFluids(GTEMaterials.Eternity.getFluid(1000))
                .outputItems(GTEItems.ETERNITY_CATALYST.asItem())
                .EUt(8053063680L)
                .duration(1600)
                .save();
    }
}
