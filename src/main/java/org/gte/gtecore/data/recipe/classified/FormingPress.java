package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import appeng.core.definitions.AEItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.FORMING_PRESS_RECIPES;

interface FormingPress {

    static void init() {
        FORMING_PRESS_RECIPES.builder("mica_based_sheet")
                .inputItems(GTEItems.MICA_BASED_PULP.asStack(3))
                .inputItems(TagPrefix.dust, GTMaterials.Asbestos, 2)
                .outputItems(GTEItems.MICA_BASED_SHEET.asStack(2))
                .EUt(30)
                .duration(400)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("carbon_rotor"))
                .inputItems(new ItemStack(Blocks.CHAIN.asItem()))
                .inputItems(TagPrefix.rod, GTMaterials.Magnalium, 2)
                .inputItems(TagPrefix.bolt, GTMaterials.Magnalium, 8)
                .inputItems(GTItems.CARBON_FIBER_PLATE.asStack(18))
                .outputItems(GTEItems.CARBON_ROTOR.asItem())
                .EUt(120)
                .duration(200)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("logic_processor1"))
                .notConsumable(new ItemStack(AEItems.SILICON_PRESS.asItem()))
                .notConsumable(new ItemStack(AEItems.LOGIC_PROCESSOR_PRESS.asItem()))
                .inputItems(TagPrefix.dust, GTMaterials.Gold)
                .inputItems(TagPrefix.dust, GTMaterials.Silicon)
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .outputItems(new ItemStack(AEItems.LOGIC_PROCESSOR.asItem()))
                .EUt(480)
                .duration(20)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("logic_processor"))
                .notConsumable(new ItemStack(AEItems.SILICON_PRESS.asItem()))
                .notConsumable(new ItemStack(AEItems.LOGIC_PROCESSOR_PRESS.asItem()))
                .inputItems(TagPrefix.plate, GTMaterials.Gold)
                .inputItems(new ItemStack(AEItems.SILICON.asItem()))
                .inputItems(TagPrefix.plate, GTMaterials.Redstone)
                .outputItems(new ItemStack(AEItems.LOGIC_PROCESSOR.asItem()))
                .EUt(30)
                .duration(200)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("raw_imprinted_resonatic_circuit_board"))
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.SiliconNitrideCeramic)
                .inputItems(TagPrefix.dust, GTEMaterials.CircuitCompound, 4)
                .inputItems(TagPrefix.dust, GTEMaterials.MagnetoResonatic)
                .outputItems(GTEItems.RAW_IMPRINTED_RESONATIC_CIRCUIT_BOARD.asItem())
                .EUt(480)
                .duration(300)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("scintillator_crystal"))
                .inputItems(TagPrefix.plate, GTEMaterials.Vibranium)
                .inputItems(TagPrefix.dust, GTEMaterials.ThalliumThuliumDopedCaesiumIodide)
                .inputItems(TagPrefix.dust, GTEMaterials.PolycyclicAromaticMixture)
                .inputItems(TagPrefix.dust, GTEMaterials.CadmiumTungstate)
                .inputItems(TagPrefix.dust, GTEMaterials.BismuthGermanate)
                .inputItems(TagPrefix.plate, GTEMaterials.Mithril, 2)
                .outputItems(GTEItems.SCINTILLATOR_CRYSTAL.asItem())
                .EUt(1966080)
                .duration(280)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("engineering_processor1"))
                .notConsumable(new ItemStack(AEItems.SILICON_PRESS.asItem()))
                .notConsumable(new ItemStack(AEItems.ENGINEERING_PROCESSOR_PRESS.asItem()))
                .inputItems(TagPrefix.plate, GTMaterials.Diamond)
                .inputItems(new ItemStack(AEItems.SILICON.asItem()))
                .inputItems(TagPrefix.plate, GTMaterials.Redstone)
                .outputItems(new ItemStack(AEItems.ENGINEERING_PROCESSOR.asItem()))
                .EUt(30)
                .duration(200)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("reactor_fuel_rod"))
                .notConsumable(GTItems.SHAPE_EXTRUDER_CELL.asItem())
                .inputItems(TagPrefix.ingot, GTMaterials.SteelMagnetic)
                .outputItems(GTEItems.REACTOR_FUEL_ROD.asItem())
                .EUt(30)
                .duration(200)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("calculation_processor1"))
                .notConsumable(new ItemStack(AEItems.SILICON_PRESS.asItem()))
                .notConsumable(new ItemStack(AEItems.CALCULATION_PROCESSOR_PRESS.asItem()))
                .inputItems(TagPrefix.dust, GTMaterials.CertusQuartz)
                .inputItems(TagPrefix.dust, GTMaterials.Silicon)
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .outputItems(new ItemStack(AEItems.CALCULATION_PROCESSOR.asItem()))
                .EUt(480)
                .duration(20)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("grindball_soapstone"))
                .notConsumable(GTItems.SHAPE_MOLD_BALL.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Soapstone, 16)
                .inputItems(TagPrefix.ingot, GTMaterials.SolderingAlloy, 2)
                .outputItems(GTEItems.GRINDBALL_SOAPSTONE.asItem())
                .EUt(7680)
                .duration(800)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("cosmic_ram_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .inputItems(GTItems.RANDOM_ACCESS_MEMORY_WAFER.asItem())
                .inputItems(GTEItems.PREPARED_COSMIC_SOC_WAFER.asItem())
                .outputItems(GTEItems.COSMIC_RAM_WAFER.asItem())
                .EUt(31457280)
                .duration(550)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("wood_gear"))
                .inputItems(TagPrefix.plate, GTMaterials.Wood, 4)
                .notConsumable(GTItems.SHAPE_MOLD_GEAR.asItem())
                .outputItems(TagPrefix.gear, GTMaterials.Wood)
                .EUt(16)
                .duration(60)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("tungsten_carbide_reactor_fuel_rod"))
                .notConsumable(GTItems.SHAPE_EXTRUDER_CELL.asItem())
                .inputItems(TagPrefix.ingot, GTMaterials.NeodymiumMagnetic)
                .inputItems(TagPrefix.ingot, GTMaterials.TungstenCarbide)
                .outputItems(GTEItems.TUNGSTEN_CARBIDE_REACTOR_FUEL_ROD.asItem())
                .EUt(120)
                .duration(200)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("optical_soc_containment_housing"))
                .inputItems(GTItems.ELITE_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.foil, GTMaterials.Titanium)
                .inputItems(TagPrefix.foil, GTMaterials.YttriumBariumCuprate)
                .inputItems(TagPrefix.foil, GTMaterials.NickelZincFerrite)
                .inputItems(TagPrefix.foil, GTMaterials.UraniumRhodiumDinaquadide)
                .inputItems(TagPrefix.bolt, GTMaterials.Darmstadtium, 4)
                .outputItems(GTEItems.OPTICAL_SOC_CONTAINMENT_HOUSING.asItem())
                .EUt(122880)
                .duration(290)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("heavy_duty_plate_2"))
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_1.asItem())
                .inputItems(TagPrefix.plateDouble, GTMaterials.Titanium)
                .inputItems(TagPrefix.plateDouble, GTMaterials.DamascusSteel, 2)
                .outputItems(GTEItems.HEAVY_DUTY_PLATE_2.asItem())
                .EUt(480)
                .duration(200)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("calculation_processor"))
                .notConsumable(new ItemStack(AEItems.SILICON_PRESS.asItem()))
                .notConsumable(new ItemStack(AEItems.CALCULATION_PROCESSOR_PRESS.asItem()))
                .inputItems(TagPrefix.plate, GTMaterials.CertusQuartz)
                .inputItems(new ItemStack(AEItems.SILICON.asItem()))
                .inputItems(TagPrefix.plate, GTMaterials.Redstone)
                .outputItems(new ItemStack(AEItems.CALCULATION_PROCESSOR.asItem()))
                .EUt(30)
                .duration(200)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("engineering_processor"))
                .notConsumable(new ItemStack(AEItems.SILICON_PRESS.asItem()))
                .notConsumable(new ItemStack(AEItems.ENGINEERING_PROCESSOR_PRESS.asItem()))
                .inputItems(TagPrefix.dust, GTMaterials.Diamond)
                .inputItems(TagPrefix.dust, GTMaterials.Silicon)
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .outputItems(new ItemStack(AEItems.ENGINEERING_PROCESSOR.asItem()))
                .EUt(480)
                .duration(20)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("grindball_aluminium"))
                .notConsumable(GTItems.SHAPE_MOLD_BALL.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium, 16)
                .inputItems(TagPrefix.ingot, GTMaterials.SolderingAlloy, 2)
                .outputItems(GTEItems.GRINDBALL_ALUMINIUM.asItem())
                .EUt(7680)
                .duration(800)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("exotic_ram_wafer"))
                .inputItems(GTEItems.OPTICAL_RAM_WAFER.asItem())
                .inputItems(GTItems.NOR_MEMORY_CHIP_WAFER.asItem())
                .inputItems(GTItems.NAND_MEMORY_CHIP_WAFER.asItem())
                .inputItems(TagPrefix.plate, GTMaterials.Amethyst)
                .inputItems(TagPrefix.plate, GTMaterials.Technetium)
                .outputItems(GTEItems.EXOTIC_RAM_WAFER.asItem())
                .EUt(7864320)
                .duration(350)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("optical_ram_wafer"))
                .inputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_WAFER.asItem())
                .inputItems(GTItems.RANDOM_ACCESS_MEMORY_WAFER.asItem())
                .inputItems(GTEItems.PHOTON_CARRYING_WAFER.asItem())
                .outputItems(GTEItems.OPTICAL_RAM_WAFER.asItem())
                .EUt(1966080)
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("supracausal_ram_wafer"))
                .inputItems(GTEItems.COSMIC_RAM_WAFER.asItem())
                .inputItems(GTEItems.EXOTIC_RAM_WAFER.asItem())
                .inputItems(GTEItems.PELLET_ANTIMATTER.asItem())
                .inputItems(TagPrefix.foil, GTEMaterials.Legendarium)
                .inputItems(TagPrefix.plateDouble, GTEMaterials.Hikarium)
                .outputItems(GTEItems.SUPRACAUSAL_RAM_WAFER.asItem())
                .EUt(125829120)
                .duration(750)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder(GTECore.id("crystal_central_processing_unit"))
                .inputItems(GTItems.ENGRAVED_CRYSTAL_CHIP.asItem())
                .inputItems(GTEItems.DIAMOND_CRYSTAL_CIRCUIT.asItem())
                .inputItems(GTEItems.RUBY_CRYSTAL_CIRCUIT.asItem())
                .inputItems(GTEItems.EMERALD_CRYSTAL_CIRCUIT.asItem())
                .inputItems(GTEItems.SAPPHIRE_CRYSTAL_CIRCUIT.asItem())
                .inputItems(TagPrefix.plate, GTMaterials.Tantalum)
                .outputItems(GTItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.asItem())
                .EUt(10000)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }
}
