package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.recipe.condition.GravityCondition;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.CENTRIFUGE_RECIPES;

interface Centrifuge {

    static void init() {
        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_thorium_simple"))
                .inputItems(GTEItems.DEPLETED_REACTOR_THORIUM_SIMPLE.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.Uranium238, 4, 4000, 500)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(2), 1600, 500)
                .EUt(480)
                .duration(40)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_uranium_dual"))
                .inputItems(GTEItems.DEPLETED_REACTOR_URANIUM_DUAL.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asStack(2))
                .outputItems(TagPrefix.rod, GTMaterials.Steel, 4)
                .chancedOutput(TagPrefix.dust, GTMaterials.Plutonium239, 12, 2500, 100)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(4), 3600, 500)
                .EUt(480)
                .duration(80)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("fissioned_uranium_235_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.FissionedUranium235)
                .outputItems(TagPrefix.dust, GTMaterials.Tin)
                .outputItems(TagPrefix.dust, GTMaterials.Technetium)
                .EUt(1920)
                .duration(400)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_mox_simple"))
                .inputItems(GTEItems.DEPLETED_REACTOR_MOX_SIMPLE.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asItem())
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(8), 2000, 1000)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(2), 1600, 500)
                .EUt(480)
                .duration(40)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_naquadah_quad"))
                .inputItems(GTEItems.DEPLETED_REACTOR_NAQUADAH_QUAD.asItem())
                .outputItems(GTEItems.TUNGSTEN_CARBIDE_REACTOR_FUEL_ROD.asStack(4))
                .outputItems(TagPrefix.rod, GTMaterials.TungstenCarbide, 12)
                .chancedOutput(TagPrefix.dust, GTMaterials.Plutonium239, 8, 8000, 200)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(8), 8000, 500)
                .EUt(480)
                .duration(160)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("dragon_element"))
                .inputFluids(GTEMaterials.TurbidDragonBlood.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Collagen)
                .outputFluids(GTEMaterials.DragonElement.getFluid(500))
                .EUt(7680)
                .duration(200)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_uranium_quad"))
                .inputItems(GTEItems.DEPLETED_REACTOR_URANIUM_QUAD.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asStack(4))
                .outputItems(TagPrefix.rod, GTMaterials.Steel, 12)
                .chancedOutput(TagPrefix.dust, GTMaterials.Plutonium239, 24, 2500, 100)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(8), 8000, 500)
                .EUt(480)
                .duration(160)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_naquadah_dual"))
                .inputItems(GTEItems.DEPLETED_REACTOR_NAQUADAH_DUAL.asItem())
                .outputItems(GTEItems.TUNGSTEN_CARBIDE_REACTOR_FUEL_ROD.asStack(2))
                .outputItems(TagPrefix.rod, GTMaterials.TungstenCarbide, 4)
                .chancedOutput(TagPrefix.dust, GTMaterials.Plutonium239, 4, 8000, 200)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(4), 3600, 500)
                .EUt(480)
                .duration(80)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("superheavyradox"))
                .inputFluids(GTEMaterials.SuperHeavyRadox.getFluid(1000))
                .outputFluids(GTEMaterials.HeavyRadox.getFluid(2000))
                .EUt(1966080)
                .duration(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_uranium_simple"))
                .inputItems(GTEItems.DEPLETED_REACTOR_URANIUM_SIMPLE.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.Plutonium239, 6, 2500, 100)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(2), 1600, 500)
                .EUt(480)
                .duration(40)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("clean_bedrock_solution"))
                .inputFluids(GTEMaterials.BedrockSootSolution.getFluid(2000))
                .outputItems(TagPrefix.dustSmall, GTMaterials.Naquadah)
                .outputItems(TagPrefix.dustTiny, GTMaterials.NaquadahEnriched)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Naquadria)
                .outputFluids(GTEMaterials.CleanBedrockSolution.getFluid(1000))
                .EUt(491520)
                .duration(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("tcetiedandelions"))
                .inputFluids(GTEMaterials.SeaweedBroth.getFluid(1000))
                .outputItems(GTEItems.TCETIEDANDELIONS.asStack(64))
                .EUt(120)
                .duration(200)
                .addCondition(new GravityCondition(false))
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("nuclear_waste"))
                .inputItems(GTEItems.NUCLEAR_WASTE.asItem())
                .outputItems(TagPrefix.dustTiny, GTMaterials.Plutonium239)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Polonium)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Uranium238)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Thorium)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Protactinium)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Neptunium)
                .EUt(2048)
                .duration(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("free_electron_gas"))
                .notConsumable(GTEItems.SEPARATION_ELECTROMAGNET.asItem())
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .outputFluids(GTEMaterials.FreeElectronGas.getFluid(1000))
                .outputFluids(GTEMaterials.FreeAlphaGas.getFluid(500))
                .EUt(491520)
                .duration(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("iodine_dust"))
                .inputFluids(GTEMaterials.IodineContainingSlurry.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Iodine)
                .outputItems(TagPrefix.dust, GTMaterials.RockSalt, 2)
                .EUt(120)
                .duration(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("actinium_radium_nitrate_solution"))
                .notConsumable(TagPrefix.dust, GTEMaterials.TrifluoroaceticPhosphateEster)
                .inputFluids(GTEMaterials.ActiniumRadiumNitrateSolution.getFluid(13000))
                .outputItems(TagPrefix.dust, GTEMaterials.ActiniumNitrate, 26)
                .outputItems(TagPrefix.dust, GTEMaterials.RadiumNitrate, 27)
                .chancedOutput(TagPrefix.dust, GTMaterials.Francium, 4, 2500, 0)
                .chancedOutput(TagPrefix.dust, GTMaterials.Thorium, 2500, 0)
                .chancedOutput(TagPrefix.dust, GTMaterials.Protactinium, 2, 2500, 0)
                .chancedOutput(TagPrefix.dust, GTMaterials.Radium, 2500, 0)
                .outputFluids(GTMaterials.Water.getFluid(13000))
                .EUt(480)
                .duration(160)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("uranium_sulfate_waste_solution"))
                .inputFluids(GTEMaterials.UraniumSulfateWasteSolution.getFluid(1000))
                .outputItems(TagPrefix.dustTiny, GTMaterials.Lead)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Barium)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Strontium)
                .outputItems(TagPrefix.dustTiny, GTMaterials.Radium)
                .outputFluids(GTMaterials.DilutedSulfuricAcid.getFluid(1000))
                .EUt(480)
                .duration(500)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_mox_dual"))
                .inputItems(GTEItems.DEPLETED_REACTOR_MOX_DUAL.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asStack(2))
                .outputItems(TagPrefix.rod, GTMaterials.Steel, 4)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(16), 2000, 1000)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(4), 3600, 500)
                .EUt(480)
                .duration(80)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("flerovium"))
                .inputFluids(GTEMaterials.Flyb.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(GTMaterials.Flerovium.getFluid(288))
                .outputFluids(GTEMaterials.Ytterbium178.getFluid(288))
                .EUt(1920)
                .duration(290)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("rare_earth_chlorides"))
                .notConsumable(GTItems.ITEM_MAGNET_HV.asItem())
                .inputFluids(GTEMaterials.RareEarthChlorides.getFluid(2000))
                .outputFluids(GTEMaterials.LaNdOxidesSolution.getFluid(250))
                .outputFluids(GTEMaterials.SmGdOxidesSolution.getFluid(250))
                .outputFluids(GTEMaterials.TbHoOxidesSolution.getFluid(250))
                .outputFluids(GTEMaterials.ErLuOxidesSolution.getFluid(250))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("quark_gluon"))
                .notConsumable(GTEItems.SEPARATION_ELECTROMAGNET.asItem())
                .inputFluids(GTEMaterials.QuarkGluon.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(GTEMaterials.HeavyQuarks.getFluid(200))
                .outputFluids(GTEMaterials.LightQuarks.getFluid(600))
                .outputFluids(GTEMaterials.Gluons.getFluid(200))
                .EUt(7864320)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("titanium_50_tetrafluoride"))
                .inputFluids(GTEMaterials.TitaniumTetrafluoride.getFluid(1000))
                .outputFluids(GTEMaterials.Titanium50Tetrafluoride.getFluid(10))
                .outputFluids(GTEMaterials.TitaniumTetrafluoride.getFluid(990))
                .EUt(480)
                .duration(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("inert_residues_dust"))
                .notConsumable(GTEItems.SEPARATION_ELECTROMAGNET.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.MetalResidue, 10)
                .inputFluids(GTMaterials.DistilledWater.getFluid(10000))
                .outputItems(TagPrefix.dust, GTEMaterials.InertResidues)
                .outputFluids(GTEMaterials.OxidizedResidualSolution.getFluid(10000))
                .EUt(491520)
                .duration(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_mox_quad"))
                .inputItems(GTEItems.DEPLETED_REACTOR_MOX_QUAD.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asStack(4))
                .outputItems(TagPrefix.rod, GTMaterials.Steel, 12)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(32), 2000, 1000)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(8), 8000, 500)
                .EUt(480)
                .duration(160)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_thorium_quad"))
                .inputItems(GTEItems.DEPLETED_REACTOR_THORIUM_QUAD.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asStack(4))
                .outputItems(TagPrefix.rod, GTMaterials.Steel, 12)
                .chancedOutput(TagPrefix.dust, GTMaterials.Uranium238, 16, 4000, 500)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(8), 8000, 500)
                .EUt(480)
                .duration(160)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_naquadah_simple"))
                .inputItems(GTEItems.DEPLETED_REACTOR_NAQUADAH_SIMPLE.asItem())
                .outputItems(GTEItems.TUNGSTEN_CARBIDE_REACTOR_FUEL_ROD.asItem())
                .chancedOutput(TagPrefix.dust, GTMaterials.Plutonium239, 2, 8000, 200)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(2), 1600, 500)
                .EUt(480)
                .duration(40)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("taranium_enriched_liquid_helium_3"))
                .notConsumable(GTEItems.SEPARATION_ELECTROMAGNET.asItem())
                .inputFluids(GTEMaterials.DustyLiquidHeliumIII.getFluid(1000))
                .outputFluids(GTEMaterials.TaraniumEnrichedLiquidHelium3.getFluid(500))
                .EUt(3000)
                .duration(400)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("depleted_reactor_thorium_dual"))
                .inputItems(GTEItems.DEPLETED_REACTOR_THORIUM_DUAL.asItem())
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asStack(2))
                .outputItems(TagPrefix.rod, GTMaterials.Steel, 4)
                .chancedOutput(TagPrefix.dust, GTMaterials.Uranium238, 8, 4000, 500)
                .chancedOutput(GTEItems.NUCLEAR_WASTE.asStack(4), 3600, 500)
                .EUt(480)
                .duration(80)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("heavily_fluorinated_trinium_solution"))
                .inputFluids(GTEMaterials.HeavilyFluorinatedTriniumSolution.getFluid(8000))
                .outputItems(TagPrefix.dust, GTEMaterials.TriniumTetrafluoride, 60)
                .outputFluids(GTMaterials.Fluorine.getFluid(16000))
                .outputFluids(GTEMaterials.Perfluorobenzene.getFluid(2000))
                .EUt(30720)
                .duration(350)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("water_gas"))
                .inputFluids(GTEMaterials.WaterGas.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(900))
                .outputFluids(GTMaterials.CarbonMonoxide.getFluid(800))
                .outputFluids(GTMaterials.CoalGas.getFluid(10))
                .EUt(7)
                .duration(380)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("blood"))
                .inputFluids(GTEMaterials.Blood.getFluid(1000))
                .outputFluids(GTEMaterials.BloodCells.getFluid(500))
                .outputFluids(GTEMaterials.BloodPlasma.getFluid(500))
                .EUt(480)
                .duration(200)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("blood_plasma"))
                .inputFluids(GTEMaterials.BloodPlasma.getFluid(1000))
                .outputFluids(GTEMaterials.Catalase.getFluid(200))
                .outputFluids(GTEMaterials.BasicFibroblastGrowthFactor.getFluid(200))
                .outputFluids(GTEMaterials.EpidermalGrowthFactor.getFluid(200))
                .EUt(480)
                .duration(50)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();
    }
}
