package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.PLASMA_CONDENSER_RECIPES;

interface PlasmaCondenser {

    static void init() {
        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("chromatic_glass"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.ChromaticGlass.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.ChromaticGlass.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("celestial_tungsten_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.CelestialTungsten.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.CelestialTungsten.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("awakened_draconium"))
                .inputItems(GTEItems.AWAKENED_DRACONIUM_PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .outputFluids(GTEMaterials.AwakenedDraconium.getFluid(1000))
                .EUt(125829120)
                .duration(1200)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("orichalcum_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Orichalcum.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Orichalcum)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("degenerate_rhenium"))
                .inputItems(GTEItems.RHENIUM_PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .outputFluids(GTEMaterials.DegenerateRhenium.getFluid(FluidStorageKeys.LIQUID, 1000))
                .EUt(7864320)
                .duration(1200)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("quantumchromodynamic_protective_plating"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Vibranium)
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Infuscolium)
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 10000))
                .inputFluids(GTEMaterials.HighEnergyQuarkGluon.getFluid(FluidStorageKeys.PLASMA, 100))
                .outputItems(GTEItems.QUANTUMCHROMODYNAMIC_PROTECTIVE_PLATING.asItem())
                .outputFluids(GTMaterials.Helium.getFluid(10000))
                .EUt(125829120)
                .duration(300)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("taranium_rich_liquid_helium_4_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.TaraniumRichLiquidHelium4.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.TaraniumRichLiquidHelium4.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("hassium"))
                .inputFluids(GTEMaterials.MetastableHassium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .outputFluids(GTEMaterials.MetastableHassium.getFluid(FluidStorageKeys.LIQUID, 1000))
                .EUt(1966080)
                .duration(1200)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("adamantium_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Adamantium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Adamantium.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("neutronium_sphere"))
                .notConsumable(GTEItems.BALL_FIELD_SHAPE.asItem())
                .inputItems(GTEItems.NEUTRON_PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 32000))
                .outputItems(GTEItems.NEUTRONIUM_SPHERE.asStack(4))
                .outputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .outputFluids(GTMaterials.Helium.getFluid(32000))
                .EUt(1966080)
                .duration(800)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("mithril_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Mithril.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Mithril.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("quantum_chromo_dynamically_confined_matter_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.QuantumChromoDynamicallyConfinedMatter.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.QuantumChromoDynamicallyConfinedMatter.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("actinium_superhydride_dust"))
                .inputItems(GTEItems.ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 24000))
                .outputItems(TagPrefix.dust, GTEMaterials.ActiniumSuperhydride, 13)
                .outputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .outputFluids(GTMaterials.Helium.getFluid(24000))
                .EUt(31457280)
                .duration(340)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("infuscolium_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Infuscolium.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Infuscolium)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("crystal_matrix"))
                .inputItems(GTEItems.CRYSTAL_MATRIX_PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .outputFluids(GTEMaterials.CrystalMatrix.getFluid(1000))
                .EUt(503316480)
                .duration(1000)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("infuscolium_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Infuscolium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Infuscolium.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("heavy_quark_degenerate_matter_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.HeavyQuarkDegenerateMatter.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.HeavyQuarkDegenerateMatter.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("legendarium_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Legendarium.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Legendarium)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("echoite_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Echoite.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Echoite)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("starmetal_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Starmetal.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Starmetal.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("cosmic_neutronium"))
                .inputItems(GTEItems.COSMIC_NEUTRON_PLASMA_CELL.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputItems(GTEItems.EXTREMELY_DURABLE_PLASMA_CELL.asItem())
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .outputFluids(GTEMaterials.CosmicNeutronium.getFluid(1000))
                .EUt(503316480)
                .duration(1200)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("legendarium_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Legendarium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Legendarium.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("enderium_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Enderium.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Enderium)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("quantum_chromo_dynamically_confined_matter_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.QuantumChromoDynamicallyConfinedMatter.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.QuantumChromoDynamicallyConfinedMatter)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("vibranium_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Vibranium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Vibranium.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("heavy_quark_degenerate_matter_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.HeavyQuarkDegenerateMatter.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.HeavyQuarkDegenerateMatter)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("astral_titanium_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.AstralTitanium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.AstralTitanium.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("mithril_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Mithril.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Mithril)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("cosmic_mesh"))
                .inputItems(GTEItems.COSMIC_MESH_CONTAINMENT_UNIT.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asItem())
                .outputFluids(GTEMaterials.CosmicMesh.getFluid(FluidStorageKeys.LIQUID, 1000))
                .EUt(503316480)
                .duration(800)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("starmetal_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Starmetal.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Starmetal)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("echoite_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Echoite.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Echoite.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("adamantium_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Adamantium.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Adamantium)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("chaos"))
                .inputItems(GTEItems.CHAOS_CONTAINMENT_UNIT.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asItem())
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .outputFluids(GTEMaterials.Chaos.getFluid(1000))
                .EUt(503316480)
                .duration(1600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("vibranium_ingot_condenser"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputFluids(GTEMaterials.Vibranium.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 14400))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Vibranium)
                .outputFluids(GTMaterials.Helium.getFluid(14400))
                .EUt(1966080)
                .duration(60)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("enderium_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Enderium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Enderium.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();

        PLASMA_CONDENSER_RECIPES.recipeBuilder(GTECore.id("orichalcum_condenser"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Orichalcum.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 100000))
                .outputFluids(GTEMaterials.Orichalcum.getFluid(1000))
                .outputFluids(GTMaterials.Helium.getFluid(100000))
                .EUt(1966080)
                .duration(600)
                .save();
    }
}
