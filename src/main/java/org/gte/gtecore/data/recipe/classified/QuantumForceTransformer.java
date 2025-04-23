package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import committee.nova.mods.avaritia.init.registry.ModItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.QUANTUM_FORCE_TRANSFORMER_RECIPES;

interface QuantumForceTransformer {

    static void init() {
        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("hyper_stable_self_healing_adhesive"))
                .chancedInput(ChemicalHelper.get(GTETagPrefix.NANITES, GTEMaterials.Uruium), 500, 0)
                .inputItems(TagPrefix.dust, GTMaterials.ActivatedCarbon, 64)
                .inputItems(TagPrefix.dust, GTMaterials.Bismuth, 64)
                .inputFluids(GTMaterials.Oxygen.getFluid(20000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(20000))
                .chancedOutput(GTEItems.HYPER_STABLE_SELF_HEALING_ADHESIVE.asStack(), 2000, 0)
                .EUt(8053063680L)
                .duration(20)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("spacetime_hex_wire"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.SpaceTime, 32)
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.TranscendentMetal, 32)
                .inputItems(TagPrefix.wireGtOctal, GTEMaterials.SpaceTime, 2)
                .inputFluids(GTEMaterials.Rhugnor.getFluid(1600))
                .outputItems(TagPrefix.wireGtHex, GTEMaterials.SpaceTime)
                .EUt(32212254720L)
                .duration(6400)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("magmatter"))
                .notConsumable(GTEItems.SPACETIME_CATALYST.asItem())
                .inputItems(TagPrefix.block, GTEMaterials.AttunedTengam)
                .inputFluids(GTEMaterials.Chaos.getFluid(1000))
                .inputFluids(GTEMaterials.SpatialFluid.getFluid(1000))
                .inputFluids(GTEMaterials.ExcitedDtsc.getFluid(1000))
                .outputFluids(GTEMaterials.Magmatter.getFluid(1000))
                .EUt(32212254720L)
                .duration(800)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("spatialfluid"))
                .notConsumable(GTEItems.HYPERCUBE.asItem())
                .notConsumable(GTEItems.QUANTUM_ANOMALY.asItem())
                .inputItems(TagPrefix.plate, GTEMaterials.CosmicNeutronium, 16)
                .inputFluids(GTEMaterials.TemporalFluid.getFluid(10000))
                .inputFluids(GTEMaterials.ExcitedDtsc.getFluid(10000))
                .outputFluids(GTEMaterials.SpatialFluid.getFluid(10000))
                .EUt(8053063680L)
                .duration(600)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("radox"))
                .inputItems(TagPrefix.dust, GTEMaterials.MolybdenumTrioxide, 16)
                .inputItems(TagPrefix.dust, GTMaterials.ChromiumTrioxide, 16)
                .inputItems(TagPrefix.dust, GTMaterials.PhosphorusPentoxide, 14)
                .inputItems(TagPrefix.dust, GTEMaterials.CubicZirconia, 12)
                .inputItems(TagPrefix.dust, GTEMaterials.GermaniumDioxide, 12)
                .inputItems(TagPrefix.dust, GTMaterials.SiliconDioxide, 12)
                .inputItems(TagPrefix.dust, GTMaterials.ArsenicTrioxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.AntimonyTrioxide, 10)
                .inputItems(TagPrefix.dust, GTEMaterials.BoronTrioxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Zincite, 8)
                .inputItems(TagPrefix.dust, GTMaterials.Magnesia, 8)
                .inputItems(TagPrefix.dust, GTMaterials.CobaltOxide, 8)
                .inputItems(TagPrefix.dust, GTMaterials.Massicot, 8)
                .inputItems(TagPrefix.dust, GTMaterials.CupricOxide, 8)
                .inputItems(TagPrefix.dust, GTMaterials.Potash, 6)
                .inputItems(TagPrefix.dust, GTEMaterials.SilverOxide, 6)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumOxide, 6)
                .inputItems(TagPrefix.dust, GTEMaterials.RareEarthOxide, 4)
                .inputFluids(GTEMaterials.RadoxGas.getFluid(21600))
                .inputFluids(GTMaterials.Oxygen.getFluid(FluidStorageKeys.PLASMA, 75000))
                .inputFluids(GTEMaterials.Titanium50Tetrachloride.getFluid(1000))
                .outputFluids(GTEMaterials.Radox.getFluid(10800))
                .EUt(503316480)
                .duration(8000)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("spacetime_double_wire"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.SpaceTime, 4)
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.TranscendentMetal, 4)
                .inputItems(TagPrefix.wireGtSingle, GTEMaterials.SpaceTime, 2)
                .inputFluids(GTEMaterials.Rhugnor.getFluid(200))
                .outputItems(TagPrefix.wireGtDouble, GTEMaterials.SpaceTime)
                .EUt(32212254720L)
                .duration(800)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("spacetime_octal_wire"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.SpaceTime, 16)
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.TranscendentMetal, 16)
                .inputItems(TagPrefix.wireGtQuadruple, GTEMaterials.SpaceTime, 2)
                .inputFluids(GTEMaterials.Rhugnor.getFluid(800))
                .outputItems(TagPrefix.wireGtOctal, GTEMaterials.SpaceTime)
                .EUt(32212254720L)
                .duration(3200)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("cosmic_ingot"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.CosmicNeutronium)
                .chancedInput(GTEItems.COSMIC_SINGULARITY.asStack(), 1000, 0)
                .inputItems(GTEItems.HYPERCUBE.asItem())
                .inputItems(TagPrefix.ingot, GTEMaterials.Infinity)
                .inputFluids(GTEMaterials.WhiteDwarfMatter.getFluid(576))
                .inputFluids(GTEMaterials.BlackDwarfMatter.getFluid(576))
                .inputFluids(GTEMaterials.PrimordialMatter.getFluid(500))
                .outputItems(TagPrefix.ingot, GTEMaterials.Cosmic)
                .EUt(128849018880L)
                .duration(200)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("quantum_anomaly"))
                .chancedInput(ChemicalHelper.get(GTETagPrefix.NANITES, GTEMaterials.Draconium), 100, 0)
                .inputItems(GTEItems.ENTANGLED_SINGULARITY.asItem())
                .inputFluids(GTMaterials.Duranium.getFluid(144))
                .inputFluids(GTEMaterials.ExcitedDtec.getFluid(100))
                .chancedOutput(GTEItems.QUANTUM_ANOMALY.asStack(), 1000, 0)
                .EUt(2013265920)
                .duration(400)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("black_body_naquadria_supersolid"))
                .chancedInput(ChemicalHelper.get(GTETagPrefix.NANITES, GTEMaterials.Uruium), 500, 0)
                .inputItems(TagPrefix.dust, GTMaterials.Naquadria, 64)
                .inputItems(TagPrefix.dust, GTMaterials.Magnesium, 64)
                .inputFluids(GTMaterials.PhosphoricAcid.getFluid(20000))
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(20000))
                .chancedOutput(GTEItems.BLACK_BODY_NAQUADRIA_SUPERSOLID.asStack(), 2000, 0)
                .EUt(8053063680L)
                .duration(20)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("spacetime_single_wire"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.SpaceTime)
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.TranscendentMetal)
                .inputItems(TagPrefix.wireGtSingle, GTEMaterials.Infinity)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(100))
                .inputFluids(GTEMaterials.Rhugnor.getFluid(100))
                .outputItems(TagPrefix.wireGtSingle, GTEMaterials.SpaceTime)
                .EUt(32212254720L)
                .duration(400)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("fullerene_polymer_matrix_pulp_dust"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Starmetal)
                .inputItems(TagPrefix.dust, GTEMaterials.Fullerene, 16)
                .inputItems(TagPrefix.dust, GTMaterials.Palladium, 8)
                .inputFluids(GTMaterials.Nitrogen.getFluid(15000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(73000))
                .inputFluids(GTMaterials.Oxygen.getFluid(13000))
                .outputItems(TagPrefix.dust, GTEMaterials.FullerenePolymerMatrixPulp, 16)
                .EUt(2013265920)
                .duration(400)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("spacetime_quadruple_wire"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.SpaceTime, 8)
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.wireGtDouble, GTEMaterials.SpaceTime, 2)
                .inputFluids(GTEMaterials.Rhugnor.getFluid(400))
                .outputItems(TagPrefix.wireGtQuadruple, GTEMaterials.SpaceTime)
                .EUt(32212254720L)
                .duration(1600)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("eternal_singularity_1"))
                .notConsumable(GTEItems.ETERNITY_CATALYST.asItem())
                .inputItems(TagPrefix.block, GTEMaterials.Neutron, 64)
                .inputItems(GTEItems.COMBINED_SINGULARITY_0.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_1.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_2.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_3.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_4.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_5.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_6.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_7.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_8.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_9.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_10.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_11.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_12.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_13.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_14.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_15.asItem())
                .inputFluids(GTEMaterials.CosmicNeutronium.getFluid(1000))
                .inputFluids(GTEMaterials.ExcitedDtec.getFluid(1000))
                .inputFluids(GTEMaterials.SpatialFluid.getFluid(1000))
                .outputItems(ModItems.eternal_singularity.get(), 16)
                .EUt(32212254720L)
                .duration(200)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("radox_gas"))
                .notConsumable(GTEItems.QUANTUM_ANOMALY.asItem())
                .inputItems(GTEBlocks.VARIATION_WOOD.asStack(64))
                .inputFluids(GTEMaterials.Xenoxene.getFluid(10000))
                .inputFluids(GTEMaterials.UnknowWater.getFluid(90000))
                .inputFluids(GTEMaterials.TemporalFluid.getFluid(100))
                .outputFluids(GTEMaterials.RadoxGas.getFluid(100000))
                .EUt(2013265920)
                .duration(400)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("taranium_dust"))
                .notConsumable(ModItems.infinity_catalyst.get())
                .inputItems(TagPrefix.dust, GTEMaterials.Bedrockium, 176)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 64)
                .inputItems(TagPrefix.dust, GTMaterials.Deepslate, 640)
                .inputFluids(GTMaterials.Helium.getFluid(37000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(73000))
                .inputFluids(GTMaterials.Xenon.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.Taranium, 64)
                .EUt(2013265920)
                .duration(1600)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("eternal_singularity"))
                .notConsumable(ModItems.infinity_catalyst.get())
                .inputItems(TagPrefix.block, GTEMaterials.Neutron, 64)
                .inputItems(GTEItems.COMBINED_SINGULARITY_0.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_1.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_2.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_3.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_4.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_5.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_6.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_7.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_8.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_9.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_10.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_11.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_12.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_13.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_14.asItem())
                .inputItems(GTEItems.COMBINED_SINGULARITY_15.asItem())
                .inputFluids(GTEMaterials.AwakenedDraconium.getFluid(1000))
                .inputFluids(GTEMaterials.CosmicNeutronium.getFluid(1000))
                .inputFluids(GTEMaterials.DimensionallyTranscendentStellarCatalyst.getFluid(1000))
                .outputItems(ModItems.eternal_singularity.get())
                .EUt(32212254720L)
                .duration(200)
                .save();

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("timepiece"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.WhiteDwarfMatter)
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.BlackDwarfMatter)
                .chancedInput(ChemicalHelper.get(TagPrefix.wireGtHex, GTEMaterials.SpaceTime), 1, 0)
                .inputFluids(GTEMaterials.CosmicElement.getFluid(100))
                .chancedOutput(GTEItems.TIMEPIECE.asStack(), 2500, 0)
                .EUt(2013265920)
                .duration(200)
                .save();
    }
}
