package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.GTEValues;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import com.enderio.base.common.init.EIOItems;
import committee.nova.mods.avaritia.init.registry.ModBlocks;
import committee.nova.mods.avaritia.init.registry.ModItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.STELLAR_FORGE_RECIPES;

interface StellarForge {

    static void init() {
        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("compressed_stone"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Stone, 1024)
                .outputItems(TagPrefix.dust, GTEMaterials.CompressedStone)
                .chancedOutput(TagPrefix.nugget, GTEMaterials.Bedrockium, 1, 100, 1)
                .EUt(31457280)
                .duration(200)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("neutron"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(TagPrefix.block, GTEMaterials.SuperheavyMix)
                .outputFluids(GTEMaterials.Neutron.getFluid(100))
                .EUt(31457280)
                .duration(200)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("contained_reissner_nordstrom_singularity"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asStack(64))
                .inputItems(GTEItems.CHARGED_TRIPLET_NEUTRONIUM_SPHERE.asStack(64))
                .outputItems(GTEItems.CONTAINED_REISSNER_NORDSTROM_SINGULARITY.asStack(64))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("closed_timelike_curvecomputational_unit"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(GTEItems.EIGENFOLDED_KERR_MANIFOLD.asItem())
                .inputItems(GTEItems.CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT_CONTAINER.asItem())
                .outputItems(GTEItems.CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT.asItem())
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("cosmic_mesh_plasma"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(GTEItems.HIGHLY_DENSE_POLYMER_PLATE.asItem())
                .outputFluids(GTEMaterials.CosmicMesh.getFluid(FluidStorageKeys.PLASMA, 1000))
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("legendarium_plasma"))
                .inputItems(GTEBlocks.LEPTONIC_CHARGE.asItem())
                .inputItems(GTEItems.NEUTRON_PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTEMaterials.Lemurite.getFluid(576))
                .inputFluids(GTEMaterials.Alduorite.getFluid(576))
                .inputFluids(GTEMaterials.Kalendrite.getFluid(576))
                .inputFluids(GTEMaterials.Haderoth.getFluid(576))
                .inputFluids(GTEMaterials.Ignatius.getFluid(576))
                .inputFluids(GTEMaterials.Ceruclase.getFluid(576))
                .inputFluids(GTEMaterials.Sanguinite.getFluid(576))
                .inputFluids(GTEMaterials.Quicksilver.getFluid(576))
                .inputFluids(GTEMaterials.Celenegil.getFluid(576))
                .outputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .outputFluids(GTEMaterials.Legendarium.getFluid(FluidStorageKeys.PLASMA, 2304))
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("degenerate_rhenium_plasma"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(TagPrefix.plateDouble, GTMaterials.Rhenium, 5)
                .outputFluids(GTEMaterials.DegenerateRhenium.getFluid(FluidStorageKeys.PLASMA, 10000))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("free_proton_gas"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(GTEItems.CONTAINED_HIGH_DENSITY_PROTONIC_MATTER.asItem())
                .outputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asItem())
                .outputFluids(GTEMaterials.FreeProtonGas.getFluid(10000))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("recursively_folded_negative_space"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(GTEItems.MACROWORMHOLE_GENERATOR.asStack(2))
                .inputItems(GTEItems.TEMPORAL_MATTER.asStack(2))
                .outputItems(GTEItems.RECURSIVELY_FOLDED_NEGATIVE_SPACE.asItem())
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("dense_neutron_plasma"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(TagPrefix.block, GTEMaterials.Neutron, 5)
                .inputItems(TagPrefix.block, GTEMaterials.HeavyQuarkDegenerateMatter, 5)
                .inputFluids(GTEMaterials.Periodicium.getFluid(2736))
                .inputFluids(GTEMaterials.Gluons.getFluid(6000))
                .inputFluids(GTEMaterials.HeavyLeptonMixture.getFluid(6000))
                .outputFluids(GTEMaterials.DenseNeutron.getFluid(FluidStorageKeys.PLASMA, 6000))
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("quantum_chromo_dynamically_confined_matter_plasma"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(GTEItems.QUANTUMCHROMODYNAMIC_PROTECTIVE_PLATING.asStack(20))
                .outputFluids(GTEMaterials.QuantumChromoDynamicallyConfinedMatter.getFluid(FluidStorageKeys.PLASMA, 2000))
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("chaos_shard"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(GTEBlocks.INFUSED_OBSIDIAN.asItem())
                .inputItems(new ItemStack(Blocks.BEDROCK.asItem()))
                .inputFluids(GTEMaterials.Radox.getFluid(1000))
                .outputItems(GTEItems.CHAOS_SHARD.asItem())
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("contained_kerr_newmann_singularity"))
                .inputItems(GTEBlocks.LEPTONIC_CHARGE.asItem())
                .inputItems(GTEItems.CONTAINED_REISSNER_NORDSTROM_SINGULARITY.asStack(64))
                .outputItems(GTEItems.CONTAINED_KERR_NEWMANN_SINGULARITY.asItem())
                .outputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asStack(63))
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("adamantium_plasma"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.Bloodstone, 24)
                .inputFluids(GTEMaterials.Orichalcum.getFluid(576))
                .inputFluids(GTMaterials.Tin.getFluid(1024))
                .inputFluids(GTMaterials.Antimony.getFluid(864))
                .inputFluids(GTMaterials.Iron.getFluid(1152))
                .inputFluids(GTMaterials.Mercury.getFluid(1000))
                .outputFluids(GTEMaterials.Adamantium.getFluid(FluidStorageKeys.PLASMA, 2304))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("contained_exotic_matter"))
                .inputItems(GTEBlocks.LEPTONIC_CHARGE.asItem())
                .inputItems(GTEItems.CONTAINED_HIGH_DENSITY_PROTONIC_MATTER.asItem())
                .inputItems(TagPrefix.dustTiny, GTEMaterials.DegenerateRhenium, 9)
                .outputItems(GTEItems.CONTAINED_EXOTIC_MATTER.asItem())
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("celestial_tungsten_plasma"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputFluids(GTEMaterials.Tartarite.getFluid(576))
                .inputFluids(GTMaterials.Tungsten.getFluid(576))
                .inputFluids(GTMaterials.Americium.getFluid(288))
                .inputFluids(GTEMaterials.TitanPrecisionSteel.getFluid(144))
                .inputFluids(GTEMaterials.AstralTitanium.getFluid(144))
                .inputFluids(GTMaterials.Xenon.getFluid(1000))
                .outputFluids(GTEMaterials.CelestialTungsten.getFluid(FluidStorageKeys.PLASMA, 1000))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("neutron_plasma_containment_cell"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTEMaterials.Neutron.getFluid(1000))
                .inputFluids(GTEMaterials.HeavyLeptonMixture.getFluid(1000))
                .outputItems(GTEItems.NEUTRON_PLASMA_CONTAINMENT_CELL.asItem())
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("starmetal_plasma"))
                .inputItems(GTEBlocks.LEPTONIC_CHARGE.asItem())
                .inputItems(GTEItems.RESONATING_GEM.asStack(10))
                .inputFluids(GTEMaterials.FreeProtonGas.getFluid(1000))
                .inputFluids(GTEMaterials.FreeElectronGas.getFluid(1000))
                .outputFluids(GTEMaterials.Starmetal.getFluid(FluidStorageKeys.PLASMA, 1000))
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("exciteddtec"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(EIOItems.PRESCIENT_POWDER.asItem())
                .inputFluids(GTEMaterials.DimensionallyTranscendentExoticCatalyst.getFluid(10000))
                .outputFluids(GTEMaterials.ExcitedDtec.getFluid(10000))
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("eternity_dust"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asStack(4))
                .inputItems(ModItems.eternal_singularity.get())
                .inputFluids(GTEMaterials.PrimordialMatter.getFluid(1000))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Eternity)
                .outputFluids(GTEMaterials.TemporalFluid.getFluid(1000))
                .EUt(2013265920)
                .duration(800)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("extremely_durable_plasma_cell"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(GTEItems.DENSE_NEUTRON_PLASMA_CELL.asStack(2))
                .outputItems(GTEItems.COSMIC_NEUTRON_PLASMA_CELL.asItem())
                .outputItems(GTEItems.EXTREMELY_DURABLE_PLASMA_CELL.asItem())
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("infinity_ingot"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(EIOItems.VIBRANT_POWDER.asItem())
                .inputFluids(GTEMaterials.CrystalMatrix.getFluid(2000))
                .inputFluids(GTEMaterials.CosmicNeutronium.getFluid(1000))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Infinity)
                .outputFluids(GTEMaterials.Infinity.getFluid(10))
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("heavy_quark_degenerate_matter_plasma"))
                .inputItems(GTEBlocks.LEPTONIC_CHARGE.asItem())
                .inputFluids(GTEMaterials.HeavyQuarkEnrichedMixture.getFluid(1152))
                .inputFluids(GTMaterials.Flerovium.getFluid(144))
                .inputFluids(GTMaterials.Oganesson.getFluid(144))
                .inputFluids(GTMaterials.Hassium.getFluid(144))
                .inputFluids(GTMaterials.Deuterium.getFluid(1000))
                .outputFluids(GTEMaterials.HeavyQuarkDegenerateMatter.getFluid(FluidStorageKeys.PLASMA, 1152))
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("astral_titanium_plasma"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputFluids(GTEMaterials.Force.getFluid(576))
                .inputFluids(GTMaterials.Titanium.getFluid(576))
                .inputFluids(GTMaterials.Cobalt.getFluid(288))
                .inputFluids(GTMaterials.Copper.getFluid(288))
                .inputFluids(GTMaterials.Tritium.getFluid(1000))
                .outputFluids(GTEMaterials.AstralTitanium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("dragon_heart"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(new ItemStack(Blocks.DRAGON_EGG.asItem(), 64))
                .inputItems(TagPrefix.plateDouble, GTEMaterials.AwakenedDraconium)
                .outputItems(GTEItems.DRAGON_HEART.asItem())
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("quark_gluon_plasma"))
                .inputItems(GTEBlocks.LEPTONIC_CHARGE.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.DegenerateRhenium, 10)
                .outputFluids(GTEMaterials.QuarkGluon.getFluid(FluidStorageKeys.PLASMA, 10000))
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("contained_high_density_protonic_matter"))
                .inputItems(GTEBlocks.LEPTONIC_CHARGE.asItem())
                .inputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asItem())
                .inputItems(GTEItems.CHARGED_TRIPLET_NEUTRONIUM_SPHERE.asItem())
                .outputItems(GTEItems.CONTAINED_HIGH_DENSITY_PROTONIC_MATTER.asItem())
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("temporalfluid"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asStack(4))
                .inputItems(GTEItems.HYPERCUBE.asItem())
                .inputFluids(GTEMaterials.SpaceTime.getFluid(1000))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .outputFluids(GTEMaterials.TemporalFluid.getFluid(500))
                .outputFluids(GTEMaterials.SpatialFluid.getFluid(500))
                .EUt(2013265920)
                .duration(800)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("enderium_plasma"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(EIOItems.ENDER_CRYSTAL_POWDER.asItem())
                .inputFluids(GTMaterials.EnderEye.getFluid(2304))
                .inputFluids(GTMaterials.Lead.getFluid(2304))
                .inputFluids(GTMaterials.Bismuth.getFluid(2304))
                .inputFluids(GTMaterials.Platinum.getFluid(1152))
                .inputFluids(GTMaterials.LiquidEnderAir.getFluid(100000))
                .outputFluids(GTEMaterials.Enderium.getFluid(FluidStorageKeys.PLASMA, 2304))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("crystal_matrix_plasma"))
                .inputItems(GTEBlocks.LEPTONIC_CHARGE.asItem())
                .inputItems(ModBlocks.crystal_matrix.get().asItem())
                .inputItems(GTEItems.CORPOREAL_MATTER.asStack(16))
                .inputFluids(GTEMaterials.FreeProtonGas.getFluid(20000))
                .outputFluids(GTEMaterials.CrystalMatrix.getFluid(FluidStorageKeys.PLASMA, 1000))
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("high_energy_quark_gluon_plasma"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(TagPrefix.plateDouble, GTEMaterials.HeavyQuarkDegenerateMatter, 10)
                .inputItems(EIOItems.PULSATING_POWDER.asItem())
                .outputFluids(GTEMaterials.HighEnergyQuarkGluon.getFluid(FluidStorageKeys.PLASMA, 2000))
                .EUt(125829120)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 2)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("infuscolium_plasma"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(new ItemStack(Items.END_CRYSTAL.asItem(), 16))
                .inputItems(new ItemStack(Items.POPPED_CHORUS_FRUIT.asItem(), 16))
                .inputFluids(GTEMaterials.Adamantine.getFluid(2304))
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .outputFluids(GTEMaterials.Infuscolium.getFluid(FluidStorageKeys.PLASMA, 2304))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("actinium_superhydride_plasma"))
                .inputItems(GTEBlocks.NAQUADRIA_CHARGE.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.ActiniumHydride, 36)
                .inputFluids(GTMaterials.Hydrogen.getFluid(81000))
                .outputFluids(GTEMaterials.ActiniumSuperhydride.getFluid(FluidStorageKeys.PLASMA, 36000))
                .EUt(31457280)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 1)
                .save();

        STELLAR_FORGE_RECIPES.recipeBuilder(GTECore.id("eigenfolded_kerr_manifold"))
                .inputItems(GTEBlocks.QUANTUM_CHROMODYNAMIC_CHARGE.asItem())
                .inputItems(GTEItems.STABILIZED_WORMHOLE_GENERATOR.asItem())
                .inputItems(GTEItems.RECURSIVELY_FOLDED_NEGATIVE_SPACE.asItem())
                .outputItems(GTEItems.EIGENFOLDED_KERR_MANIFOLD.asItem())
                .EUt(503316480)
                .duration(200)
                .addData(GTEValues.STELLAR_CONTAINMENT_TIER, 3)
                .save();
    }
}
