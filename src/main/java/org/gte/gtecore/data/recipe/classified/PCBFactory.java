package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.PCB_FACTORY_RECIPES;

interface PCBFactory {

    static void init() {
        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("wetware_printed_circuit_board"))
                .inputItems(GTItems.WETWARE_BOARD.asItem())
                .inputItems(TagPrefix.foil, GTMaterials.NiobiumTitanium, 32)
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(1000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(500))
                .outputItems(GTItems.WETWARE_CIRCUIT_BOARD.asItem())
                .EUt(1920)
                .duration(450)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("epoxy_printed_circuit_board"))
                .inputItems(TagPrefix.plate, GTMaterials.Epoxy, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Electrum, 128)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(2000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(1000))
                .outputItems(GTItems.ADVANCED_CIRCUIT_BOARD.asStack(8))
                .EUt(120)
                .duration(600)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("polytetrafluoroethylene_plate1"))
                .inputItems(TagPrefix.plate, GTMaterials.Polytetrafluoroethylene, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Copper, 160)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(4000))
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(4000))
                .outputItems(GTItems.PLASTIC_CIRCUIT_BOARD.asStack(32))
                .EUt(120)
                .duration(1600)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("fiber_reinforced_printed_circuit_board1"))
                .inputItems(TagPrefix.plate, GTMaterials.ReinforcedEpoxyResin, 8)
                .inputItems(TagPrefix.foil, GTMaterials.AnnealedCopper, 160)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(500))
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(4000))
                .outputItems(GTItems.EXTREME_CIRCUIT_BOARD.asStack(8))
                .EUt(120)
                .duration(800)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("polyvinyl_chloride_plate1"))
                .inputItems(TagPrefix.plate, GTMaterials.PolyvinylChloride, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Copper, 96)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(2000))
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(2000))
                .outputItems(GTItems.PLASTIC_CIRCUIT_BOARD.asStack(16))
                .EUt(120)
                .duration(800)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("supracausal_circuit_board"))
                .inputItems(GTEItems.COSMIC_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.foil, GTEMaterials.Echoite, 32)
                .inputFluids(GTEMaterials.DenseNeutron.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTEMaterials.QuantumChromoDynamicallyConfinedMatter.getFluid(FluidStorageKeys.PLASMA, 100))
                .outputItems(GTEItems.SUPRACAUSAL_CIRCUIT_BOARD.asItem())
                .EUt(1966080)
                .duration(1500)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("polybenzimidazole_plate"))
                .inputItems(TagPrefix.plate, GTMaterials.Polybenzimidazole, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Copper, 288)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(8000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(4000))
                .outputItems(GTItems.PLASTIC_CIRCUIT_BOARD.asStack(64))
                .EUt(120)
                .duration(3200)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("bioware_printed_circuit_board"))
                .inputItems(GTEItems.BIOWARE_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.foil, GTMaterials.VanadiumGallium, 32)
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(2000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(1000))
                .outputItems(GTEItems.BIOWARE_PRINTED_CIRCUIT_BOARD.asItem())
                .EUt(7680)
                .duration(525)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("optical_circuit_board"))
                .inputItems(TagPrefix.plate, GTEMaterials.Kevlar)
                .inputItems(TagPrefix.foil, GTMaterials.Rhodium, 32)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.Mithril.getFluid(FluidStorageKeys.PLASMA, 100))
                .outputItems(GTEItems.OPTICAL_CIRCUIT_BOARD.asItem())
                .EUt(30720)
                .duration(600)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("polyethylene_plate"))
                .inputItems(TagPrefix.plate, GTMaterials.Polyethylene, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Copper, 64)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(500))
                .outputItems(GTItems.PLASTIC_CIRCUIT_BOARD.asStack(8))
                .EUt(120)
                .duration(400)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("multilayer_fiber_reinforced_printed_circuit_board1"))
                .inputItems(GTItems.FIBER_BOARD.asStack(16))
                .inputItems(TagPrefix.foil, GTMaterials.Platinum, 128)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(2000))
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(8000))
                .outputItems(GTItems.ELITE_CIRCUIT_BOARD.asStack(8))
                .EUt(480)
                .duration(800)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("epoxy_printed_circuit_board1"))
                .inputItems(TagPrefix.plate, GTMaterials.Epoxy, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Electrum, 128)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(2000))
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(2000))
                .outputItems(GTItems.ADVANCED_CIRCUIT_BOARD.asStack(8))
                .EUt(120)
                .duration(600)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("polytetrafluoroethylene_plate"))
                .inputItems(TagPrefix.plate, GTMaterials.Polytetrafluoroethylene, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Copper, 160)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(4000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(2000))
                .outputItems(GTItems.PLASTIC_CIRCUIT_BOARD.asStack(32))
                .EUt(120)
                .duration(1600)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("polyethylene_plate1"))
                .inputItems(TagPrefix.plate, GTMaterials.Polyethylene, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Copper, 64)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(1000))
                .outputItems(GTItems.PLASTIC_CIRCUIT_BOARD.asStack(8))
                .EUt(120)
                .duration(400)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("exotic_circuit_board"))
                .inputItems(TagPrefix.plate, GTEMaterials.Kevlar, 2)
                .inputItems(TagPrefix.foil, GTEMaterials.Enderium, 32)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.Vibranium.getFluid(FluidStorageKeys.PLASMA, 100))
                .outputItems(GTEItems.EXOTIC_CIRCUIT_BOARD.asItem())
                .EUt(122880)
                .duration(900)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("optical_printed_circuit_board"))
                .inputItems(GTEItems.OPTICAL_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.foil, GTMaterials.Ruthenium, 32)
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(4000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(2000))
                .outputItems(GTEItems.OPTICAL_PRINTED_CIRCUIT_BOARD.asItem())
                .EUt(30720)
                .duration(600)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("multilayer_fiber_reinforced_printed_circuit_board"))
                .inputItems(GTItems.FIBER_BOARD.asStack(16))
                .inputItems(TagPrefix.foil, GTMaterials.Platinum, 128)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(2000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(1000))
                .outputItems(GTItems.ELITE_CIRCUIT_BOARD.asStack(8))
                .EUt(480)
                .duration(800)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("polybenzimidazole_plate1"))
                .inputItems(TagPrefix.plate, GTMaterials.Polybenzimidazole, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Copper, 288)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(8000))
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(8000))
                .outputItems(GTItems.PLASTIC_CIRCUIT_BOARD.asStack(64))
                .EUt(120)
                .duration(3200)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("polyvinyl_chloride_plate"))
                .inputItems(TagPrefix.plate, GTMaterials.PolyvinylChloride, 8)
                .inputItems(TagPrefix.foil, GTMaterials.Copper, 96)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(2000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(1000))
                .outputItems(GTItems.PLASTIC_CIRCUIT_BOARD.asStack(16))
                .EUt(120)
                .duration(800)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("exotic_printed_circuit_board"))
                .inputItems(GTEItems.EXOTIC_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.foil, GTMaterials.Americium, 32)
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(8000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(4000))
                .outputItems(GTEItems.EXOTIC_PRINTED_CIRCUIT_BOARD.asItem())
                .EUt(122880)
                .duration(900)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("cosmic_printed_circuit_board"))
                .inputItems(GTEItems.COSMIC_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.foil, GTEMaterials.Uruium, 32)
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(8000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(4000))
                .outputItems(GTEItems.COSMIC_PRINTED_CIRCUIT_BOARD.asItem())
                .EUt(491520)
                .duration(1200)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("fiber_reinforced_printed_circuit_board"))
                .inputItems(TagPrefix.plate, GTMaterials.ReinforcedEpoxyResin, 8)
                .inputItems(TagPrefix.foil, GTMaterials.AnnealedCopper, 160)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(500))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(2000))
                .outputItems(GTItems.EXTREME_CIRCUIT_BOARD.asStack(8))
                .EUt(120)
                .duration(800)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("supracausal_printed_circuit_board"))
                .inputItems(GTEItems.SUPRACAUSAL_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.foil, GTEMaterials.Legendarium, 32)
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(16000))
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(8000))
                .outputItems(GTEItems.SUPRACAUSAL_PRINTED_CIRCUIT_BOARD.asItem())
                .EUt(1966080)
                .duration(1500)
                .save();

        PCB_FACTORY_RECIPES.recipeBuilder(GTECore.id("cosmic_circuit_board"))
                .inputItems(TagPrefix.plate, GTEMaterials.Kevlar, 4)
                .inputItems(TagPrefix.foil, GTEMaterials.HeavyQuarkDegenerateMatter, 32)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.MetastableHassium.getFluid(FluidStorageKeys.PLASMA, 100))
                .outputItems(GTEItems.COSMIC_CIRCUIT_BOARD.asItem())
                .EUt(491520)
                .duration(1200)
                .save();
    }
}
