package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import committee.nova.mods.avaritia.init.registry.ModBlocks;
import committee.nova.mods.avaritia.init.registry.ModItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES;

interface DimensionallytranscendentPlasmaForge {

    static void init() {
        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("spacetime_ingot"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asStack(64))
                .notConsumable(GTEBlocks.SPACETIMEBENDINGCORE.asStack(64))
                .inputFluids(GTEMaterials.SpaceTime.getFluid(1000))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(TagPrefix.ingot, GTEMaterials.SpaceTime, 8)
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(6400)
                .blastFurnaceTemp(62000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("hypercube_1"))
                .inputItems(TagPrefix.rod, GTEMaterials.TranscendentMetal, 16)
                .inputItems(GTEItems.QUANTUM_ANOMALY.asItem())
                .inputFluids(GTEMaterials.ExcitedDtec.getFluid(1000))
                .inputFluids(GTEMaterials.SpatialFluid.getFluid(1000))
                .outputItems(GTEItems.HYPERCUBE.asStack(64))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(32212254720L)
                .duration(6400)
                .blastFurnaceTemp(62000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("hypercube"))
                .inputItems(TagPrefix.rod, GTEMaterials.CosmicNeutronium, 12)
                .inputItems(TagPrefix.rod, GTEMaterials.CelestialTungsten, 24)
                .inputFluids(GTEMaterials.ExcitedDtec.getFluid(1000))
                .outputItems(GTEItems.HYPERCUBE.asItem())
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(2400)
                .blastFurnaceTemp(30000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("rhugnor"))
                .notConsumable(ModItems.infinity_catalyst.get())
                .inputItems(GTItems.ENERGIUM_CRYSTAL.asStack(64))
                .inputFluids(GTEMaterials.Infinity.getFluid(10000))
                .inputFluids(GTEMaterials.Quantum.getFluid(10000))
                .outputFluids(GTEMaterials.Rhugnor.getFluid(10000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(8053063680L)
                .duration(3600)
                .blastFurnaceTemp(36000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("crystal_matrix_plasma"))
                .notConsumable(ModItems.infinity_catalyst.get())
                .inputItems(ModBlocks.crystal_matrix.get().asItem())
                .inputFluids(GTMaterials.UUMatter.getFluid(1000000))
                .inputFluids(GTEMaterials.FreeProtonGas.getFluid(20000))
                .outputFluids(GTEMaterials.CrystalMatrix.getFluid(FluidStorageKeys.PLASMA, 10000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(800)
                .blastFurnaceTemp(28000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("dense_neutron_plasma"))
                .notConsumable(ModItems.infinity_catalyst.get())
                .inputItems(GTEItems.NEUTRON_PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTEMaterials.HeavyQuarkDegenerateMatter.getFluid(FluidStorageKeys.PLASMA, 10000))
                .inputFluids(GTEMaterials.Periodicium.getFluid(1000))
                .outputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .outputFluids(GTEMaterials.DenseNeutron.getFluid(FluidStorageKeys.PLASMA, 10000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(800)
                .blastFurnaceTemp(26000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("create_casing"))
                .inputItems(TagPrefix.frameGt, GTEMaterials.Eternity)
                .inputItems(GTEItems.COMMAND_BLOCK_CORE.asItem())
                .inputFluids(GTEMaterials.ExcitedDtsc.getFluid(1000))
                .inputFluids(GTEMaterials.PrimordialMatter.getFluid(1000))
                .outputItems(GTEBlocks.CREATE_CASING.asItem())
                .EUt(32985348833280L)
                .duration(3200)
                .blastFurnaceTemp(96000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("infinity_catalyst"))
                .inputItems(GTEItems.CONTAINED_EXOTIC_MATTER.asStack(64))
                .inputItems(GTEItems.ESSENTIA_MATTER.asStack(64))
                .inputFluids(GTEMaterials.Infinity.getFluid(1000))
                .inputFluids(GTEMaterials.HighEnergyQuarkGluon.getFluid(FluidStorageKeys.PLASMA, 100000))
                .outputItems(ModItems.infinity_catalyst.get())
                .outputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asStack(64))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(4800)
                .blastFurnaceTemp(32000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("chaos_plasma"))
                .inputItems(GTEItems.CHAOS_SHARD.asItem())
                .inputFluids(GTEMaterials.DimensionallyTranscendentResplendentCatalyst.getFluid(1000))
                .inputFluids(GTEMaterials.CosmicMesh.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(GTEMaterials.Chaos.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(1600)
                .blastFurnaceTemp(32000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("spacetime"))
                .notConsumable(GTEItems.SPACETIME_CATALYST.asItem())
                .inputFluids(GTEMaterials.Infinity.getFluid(100))
                .inputFluids(GTEMaterials.Hypogen.getFluid(100))
                .outputFluids(GTEMaterials.SpaceTime.getFluid(200))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(8053063680L)
                .duration(1600)
                .blastFurnaceTemp(36000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("cosmic_neutron_plasma_cell"))
                .notConsumable(ModItems.infinity_catalyst.get())
                .inputItems(GTEItems.EXTREMELY_DURABLE_PLASMA_CELL.asStack(5))
                .inputFluids(GTMaterials.UUMatter.getFluid(1000000))
                .inputFluids(GTEMaterials.DenseNeutron.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.COSMIC_NEUTRON_PLASMA_CELL.asStack(5))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(800)
                .blastFurnaceTemp(28000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matter"))
                .notConsumable(GTEItems.ETERNITY_CATALYST.asItem())
                .inputItems(GTETagPrefix.NANITES, GTEMaterials.Eternity)
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 100000))
                .inputFluids(GTEMaterials.ExcitedDtsc.getFluid(100000))
                .chancedOutput(GTETagPrefix.CONTAMINABLE_NANITES, GTEMaterials.Eternity, 5000, 0)
                .outputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(100000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2061584302080L)
                .duration(6400)
                .blastFurnaceTemp(81000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("infinity"))
                .notConsumable(GTEItems.SPACETIME_CATALYST.asItem())
                .inputFluids(GTEMaterials.CrystalMatrix.getFluid(FluidStorageKeys.PLASMA, 10000))
                .inputFluids(GTEMaterials.CosmicNeutronium.getFluid(5000))
                .outputFluids(GTEMaterials.Infinity.getFluid(1000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(8053063680L)
                .duration(1600)
                .blastFurnaceTemp(32000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("dimensionallytranscendentresidue"))
                .inputFluids(GTEMaterials.DimensionallyTranscendentCrudeCatalyst.getFluid(100))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 100))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(400)
                .blastFurnaceTemp(36000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("hypogen"))
                .notConsumable(ModItems.infinity_catalyst.get())
                .inputItems(TagPrefix.block, GTEMaterials.QuantumChromoDynamicallyConfinedMatter)
                .inputFluids(GTEMaterials.Rhugnor.getFluid(10000))
                .inputFluids(GTEMaterials.DragonBlood.getFluid(10000))
                .outputFluids(GTEMaterials.Hypogen.getFluid(10000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(1200)
                .blastFurnaceTemp(26000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("transcendent_metal"))
                .notConsumable(GTEItems.SPACETIME_CATALYST.asItem())
                .inputItems(GTEItems.HYPERCUBE.asItem())
                .inputFluids(GTEMaterials.SpaceTime.getFluid(100))
                .inputFluids(GTMaterials.Tennessine.getFluid(144))
                .outputFluids(GTEMaterials.TranscendentMetal.getFluid(144))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(2013265920)
                .duration(3200)
                .blastFurnaceTemp(36000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("infinity_glass"))
                .inputItems(GTEItems.BLACK_BODY_NAQUADRIA_SUPERSOLID.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.Infinity, 2)
                .inputFluids(GTEMaterials.DimensionallyTranscendentExoticCatalyst.getFluid(1000))
                .inputFluids(GTEMaterials.WoodsGlass.getFluid(9216))
                .outputItems(GTEBlocks.INFINITY_GLASS.asItem())
                .EUt(8246337208320L)
                .duration(1600)
                .blastFurnaceTemp(88000)
                .save();

        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES.recipeBuilder(GTECore.id("eternity"))
                .notConsumable(GTEItems.ETERNITY_CATALYST.asItem())
                .inputItems(ModItems.eternal_singularity.get())
                .inputFluids(GTEMaterials.PrimordialMatter.getFluid(1000))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 9000))
                .outputFluids(GTEMaterials.Eternity.getFluid(10000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(100))
                .EUt(32212254720L)
                .duration(4800)
                .blastFurnaceTemp(56000)
                .save();
    }
}
