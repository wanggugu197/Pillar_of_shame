package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.recipe.condition.GravityCondition;
import org.gte.gtecore.common.recipe.condition.VacuumCondition;
import org.gte.gtecore.utils.RegistriesUtils;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import appeng.core.definitions.AEItems;
import com.enderio.base.common.init.EIOBlocks;
import com.enderio.base.common.init.EIOItems;
import com.kyanite.deeperdarker.content.DDItems;
import earth.terrarium.adastra.common.registry.ModItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.ARC_GENERATOR_RECIPES;

interface ArcGenerator {

    static void init() {
        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("ender_pearl_dust")).duration(400).EUt(30)
                .inputItems(TagPrefix.dust, GTMaterials.Beryllium)
                .inputItems(TagPrefix.dust, GTMaterials.Potassium, 4)
                .inputFluids(GTMaterials.Nitrogen.getFluid(5000))
                .circuitMeta(1)
                .outputItems(TagPrefix.dust, GTMaterials.EnderPearl, 10)
                .addCondition(new VacuumCondition(3))
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("fluix_pearl"))
                .inputItems(TagPrefix.gem, GTMaterials.EnderPearl)
                .inputItems(TagPrefix.gemFlawless, GTEMaterials.Fluix)
                .outputItems(new ItemStack(AEItems.FLUIX_PEARL.asItem()))
                .EUt(30)
                .duration(160)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("piglin_head"))
                .notConsumable(RegistriesUtils.getItemStack("enderio:filled_soul_vial", 1, "{BlockEntityTag:{EntityStorage:{Entity:{id:\"minecraft:piglin\"}}}}"))
                .inputItems(new ItemStack(Items.PORKCHOP.asItem(), 9))
                .inputItems(TagPrefix.nugget, GTMaterials.Gold)
                .outputItems(new ItemStack(Blocks.PIGLIN_HEAD.asItem()))
                .EUt(120)
                .duration(200)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("zombie_head"))
                .notConsumable(RegistriesUtils.getItemStack("enderio:filled_soul_vial", 1, "{BlockEntityTag:{EntityStorage:{Entity:{id:\"minecraft:zombie\"}}}}"))
                .inputItems(new ItemStack(Items.ROTTEN_FLESH.asItem(), 9))
                .outputItems(new ItemStack(Blocks.ZOMBIE_HEAD.asItem()))
                .EUt(120)
                .duration(100)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("adamantine_compounds_dust_a"))
                .notConsumable(GTEItems.MICROWORMHOLE_GENERATOR.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.AdamantineCompounds, 4)
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Adamantine)
                .EUt(125829120)
                .duration(20)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("skeleton_skull"))
                .notConsumable(RegistriesUtils.getItemStack("enderio:filled_soul_vial", 1, "{BlockEntityTag:{EntityStorage:{Entity:{id:\"minecraft:skeleton\"}}}}"))
                .inputItems(TagPrefix.rod, GTMaterials.Bone, 9)
                .outputItems(new ItemStack(Blocks.SKELETON_SKULL.asItem()))
                .EUt(120)
                .duration(100)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("thaumium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.InfusedGold, 8)
                .inputItems(TagPrefix.dust, GTEMaterials.Soularium, 4)
                .inputItems(TagPrefix.dust, GTMaterials.Iron, 4)
                .inputItems(TagPrefix.dust, GTMaterials.Lapis, 16)
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Thaumium, 16)
                .EUt(7680)
                .duration(480)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("ender_air"))
                .inputItems(TagPrefix.dust, GTMaterials.EnderPearl, 64)
                .inputFluids(GTEMaterials.FumingNitricAcid.getFluid(1000))
                .inputFluids(GTMaterials.NitrogenDioxide.getFluid(10000))
                .inputFluids(GTMaterials.Helium.getFluid(10000))
                .inputFluids(GTMaterials.Radon.getFluid(1000))
                .inputFluids(GTMaterials.Deuterium.getFluid(1000))
                .inputFluids(GTMaterials.Xenon.getFluid(1000))
                .outputFluids(GTMaterials.EnderAir.getFluid(1000))
                .EUt(480)
                .duration(800)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("nitric_oxide"))
                .inputFluids(GTMaterials.Air.getFluid(10000))
                .outputFluids(GTMaterials.NitricOxide.getFluid(1000))
                .EUt(120)
                .duration(200)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("wither_skeleton_skull"))
                .notConsumable(RegistriesUtils.getItemStack("enderio:filled_soul_vial", 1, "{BlockEntityTag:{EntityStorage:{Entity:{id:\"minecraft:wither_skeleton\"}}}}"))
                .inputItems(new ItemStack(Blocks.SKELETON_SKULL.asItem()))
                .inputItems(TagPrefix.gemExquisite, GTMaterials.Coal)
                .outputItems(new ItemStack(Blocks.WITHER_SKELETON_SKULL.asItem()))
                .EUt(480)
                .duration(200)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("netherite_scrap"))
                .inputItems(new ItemStack(Blocks.ANCIENT_DEBRIS.asItem()))
                .inputItems(new ItemStack(Items.PRISMARINE_SHARD.asItem()))
                .inputFluids(GTMaterials.NetherAir.getFluid(100))
                .outputItems(new ItemStack(Items.NETHERITE_SCRAP.asItem()))
                .EUt(480)
                .duration(240)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("nether_air"))
                .inputItems(TagPrefix.dust, GTMaterials.Gunpowder, 64)
                .inputFluids(GTMaterials.Blaze.getFluid(1000))
                .inputFluids(GTMaterials.HydrogenSulfide.getFluid(10000))
                .inputFluids(GTMaterials.SulfurDioxide.getFluid(10000))
                .inputFluids(GTMaterials.CarbonMonoxide.getFluid(10000))
                .inputFluids(GTMaterials.CoalGas.getFluid(1000))
                .inputFluids(GTMaterials.Helium.getFluid(1000))
                .outputFluids(GTMaterials.NetherAir.getFluid(1000))
                .EUt(120)
                .duration(400)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("dragon_egg"))
                .inputItems(new ItemStack(Items.EGG.asItem()))
                .inputItems(GTEItems.WARPED_ENDER_PEARL.asStack(64))
                .inputFluids(GTEMaterials.Antimatter.getFluid(1000))
                .inputFluids(GTMaterials.EnderEye.getFluid(10000))
                .inputFluids(GTMaterials.SterileGrowthMedium.getFluid(10000))
                .chancedOutput(new ItemStack(Blocks.DRAGON_EGG.asItem()), 9000, 0)
                .EUt(491520)
                .duration(2000)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("grains_of_infinity"))
                .chancedInput(ChemicalHelper.get(TagPrefix.gem, GTMaterials.Flint), 2000, 0)
                .inputItems(TagPrefix.dustTiny, GTMaterials.Obsidian)
                .outputItems(EIOItems.GRAINS_OF_INFINITY.asItem())
                .EUt(30)
                .duration(200)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("crying_obsidian"))
                .inputItems(TagPrefix.rock, GTMaterials.Obsidian)
                .inputFluids(GTEMaterials.Antimatter.getFluid(10))
                .outputItems(new ItemStack(Blocks.CRYING_OBSIDIAN.asItem()))
                .EUt(480)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("nether_star_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Diamond)
                .inputItems(TagPrefix.dust, GTMaterials.Iridium)
                .inputFluids(GTMaterials.RocketFuel.getFluid(1000))
                .inputFluids(GTMaterials.NetherAir.getFluid(8000))
                .outputItems(TagPrefix.dust, GTMaterials.NetherStar, 3)
                .EUt(480)
                .duration(200)
                .addCondition(new GravityCondition(true))
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("nether_star"))
                .inputItems(new ItemStack(Blocks.SOUL_SAND.asItem(), 4))
                .inputItems(new ItemStack(Blocks.WITHER_SKELETON_SKULL.asItem(), 3))
                .outputItems(TagPrefix.gem, GTMaterials.NetherStar)
                .EUt(1920)
                .duration(800)
                .addCondition(new GravityCondition(true))
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("energetic_alloy_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .inputItems(TagPrefix.dust, GTMaterials.Gold)
                .inputItems(TagPrefix.dust, GTMaterials.Glowstone)
                .inputFluids(GTMaterials.Water.getFluid(100))
                .outputItems(TagPrefix.dust, GTEMaterials.EnergeticAlloy, 3)
                .EUt(30)
                .duration(480)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("naquadah_contain_rare_earth_fluoride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Alunite)
                .inputFluids(GTEMaterials.RareEarthChlorides.getFluid(6000))
                .inputFluids(GTMaterials.AcidicEnrichedNaquadahSolution.getFluid(3000))
                .inputFluids(GTMaterials.AcidicNaquadriaSolution.getFluid(3000))
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(2000))
                .inputFluids(GTEMaterials.EnrichedNaquadahFront.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.NaquadahContainRareEarthFluoride)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(6000))
                .EUt(491520)
                .duration(400)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("ghast_tear"))
                .inputItems(TagPrefix.dustTiny, GTMaterials.Lithium)
                .inputItems(TagPrefix.dustTiny, GTMaterials.Potassium)
                .inputFluids(GTMaterials.SaltWater.getFluid(1000))
                .outputItems(new ItemStack(Items.GHAST_TEAR.asItem()))
                .EUt(30)
                .duration(400)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("glowstone_dust"))
                .circuitMeta(1)
                .inputItems(TagPrefix.dust, GTMaterials.Gold)
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .outputItems(TagPrefix.dust, GTMaterials.Glowstone, 2)
                .EUt(30)
                .duration(200)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("creeper_head"))
                .notConsumable(RegistriesUtils.getItemStack("enderio:filled_soul_vial", 1, "{BlockEntityTag:{EntityStorage:{Entity:{id:\"minecraft:creeper\"}}}}"))
                .inputItems(TagPrefix.dust, GTMaterials.Gunpowder, 9)
                .outputItems(new ItemStack(Blocks.CREEPER_HEAD.asItem()))
                .EUt(120)
                .duration(100)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("fluix_crystal"))
                .circuitMeta(2)
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .inputItems(TagPrefix.gem, GTMaterials.NetherQuartz)
                .inputItems(TagPrefix.gem, GTMaterials.CertusQuartz)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.gem, GTEMaterials.Fluix, 2)
                .EUt(30)
                .duration(80)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("enderman_head"))
                .notConsumable(RegistriesUtils.getItemStack("enderio:filled_soul_vial", 1, "{BlockEntityTag:{EntityStorage:{Entity:{id:\"minecraft:enderman\"}}}}"))
                .inputItems(TagPrefix.gem, GTMaterials.EnderPearl, 9)
                .outputItems(EIOBlocks.ENDERMAN_HEAD.asItem())
                .EUt(480)
                .duration(100)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("charged_certus_quartz_crystal"))
                .circuitMeta(1)
                .inputItems(TagPrefix.gem, GTMaterials.CertusQuartz)
                .outputItems(new ItemStack(AEItems.CERTUS_QUARTZ_CRYSTAL_CHARGED.asItem()))
                .EUt(30)
                .duration(60)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("echobone"))
                .inputItems(TagPrefix.rod, GTMaterials.Bone)
                .inputFluids(GTMaterials.EchoShard.getFluid(144))
                .outputItems(DDItems.SCULK_BONE.get())
                .EUt(480)
                .duration(400)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("ice_shard"))
                .inputItems(new ItemStack(Blocks.BLUE_ICE.asItem()))
                .outputItems(ModItems.ICE_SHARD.get())
                .EUt(30)
                .duration(200)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("prismarine"))
                .inputItems(new ItemStack(Blocks.COBBLESTONE.asItem()))
                .inputFluids(GTMaterials.SaltWater.getFluid(10))
                .outputItems(new ItemStack(Blocks.PRISMARINE.asItem()))
                .EUt(30)
                .duration(200)
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("reinforced_deepslate"))
                .inputItems(TagPrefix.rock, GTMaterials.Deepslate)
                .inputItems(TagPrefix.block, GTMaterials.EchoShard)
                .inputItems(new ItemStack(DDItems.SCULK_BONE.get(), 4))
                .inputFluids(GTMaterials.EchoShard.getFluid(1440))
                .outputItems(new ItemStack(Blocks.REINFORCED_DEEPSLATE.asItem()))
                .EUt(480)
                .duration(200)
                .save();
    }
}
