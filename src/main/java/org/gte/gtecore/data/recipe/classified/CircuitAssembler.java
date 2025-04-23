package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import com.enderio.base.common.init.EIOItems;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.foil;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.CIRCUIT_ASSEMBLER_RECIPES;

interface CircuitAssembler {

    static void init() {
        int outputAmount = ConfigHolder.INSTANCE.recipes.harderCircuitRecipes ? 1 : 2;
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_uiv"))
                .inputItems(GTEItems.SMD_DIODE_SUPRACAUSAL.asStack(16))
                .inputItems(GTEItems.SMD_CAPACITOR_SUPRACAUSAL.asStack(16))
                .inputItems(GTEItems.SMD_TRANSISTOR_SUPRACAUSAL.asStack(16))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(8))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.UEV].get())
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(432))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.UIV].asStack(outputAmount << 1))
                .EUt(125829120)
                .duration(790)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_uhv"))
                .inputItems(GTEItems.SMD_DIODE_EXOTIC.asStack(16))
                .inputItems(GTEItems.SMD_CAPACITOR_EXOTIC.asStack(16))
                .inputItems(GTEItems.SMD_TRANSISTOR_EXOTIC.asStack(16))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(8))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.UV].get())
                .inputFluids(GTEMaterials.MutatedLivingSolder.getFluid(432))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.UHV].asStack(outputAmount << 1))
                .EUt(7864320)
                .duration(750)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_ulv"))
                .inputItems(GTItems.BATTERY_ULV_TANTALUM.asStack(4))
                .inputItems(GTItems.RESISTOR.asStack(4))
                .inputItems(GTItems.INDUCTOR.asStack(4))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.gem, GTEMaterials.MagnetoResonatic)
                .inputItems(GTItems.VACUUM_TUBE.asItem())
                .inputFluids(GTMaterials.Tin.getFluid(144))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.ULV].asStack(outputAmount << 1))
                .EUt(30)
                .duration(50)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_uev"))
                .inputItems(GTEItems.SMD_DIODE_COSMIC.asStack(16))
                .inputItems(GTEItems.SMD_CAPACITOR_COSMIC.asStack(16))
                .inputItems(GTEItems.SMD_TRANSISTOR_COSMIC.asStack(16))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(8))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.UHV].get())
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(288))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.UEV].asStack(outputAmount << 1))
                .EUt(31457280)
                .duration(770)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_zpm"))
                .inputItems(GTEItems.SMD_DIODE_BIOWARE.asStack(16))
                .inputItems(GTEItems.SMD_CAPACITOR_BIOWARE.asStack(16))
                .inputItems(GTEItems.SMD_TRANSISTOR_BIOWARE.asStack(16))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(8))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.LuV].get())
                .inputFluids(GTEMaterials.MutatedLivingSolder.getFluid(144))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.ZPM].asStack(outputAmount << 1))
                .EUt(491520)
                .duration(710)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("exotic_processor"))
                .inputItems(GTEItems.EXOTIC_PROCESSING_CORE.asItem())
                .inputItems(GTEItems.EXOTIC_RAM_CHIP.asStack(4))
                .inputItems(GTItems.HIGHLY_ADVANCED_SOC.asItem())
                .inputItems(GTEItems.SMD_CAPACITOR_EXOTIC.asStack(8))
                .inputItems(GTEItems.SMD_TRANSISTOR_EXOTIC.asStack(8))
                .inputItems(TagPrefix.wireFine, GTEMaterials.Cinobite, 16)
                .inputFluids(GTEMaterials.MutatedLivingSolder.getFluid(432))
                .outputItems(GTEItems.EXOTIC_PROCESSOR.asStack(outputAmount))
                .EUt(7864320)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("bioware_processor"))
                .inputItems(GTEItems.BIOWARE_PROCESSING_CORE.asItem())
                .inputItems(GTItems.NEURO_PROCESSOR.asStack())
                .inputItems(GTItems.HIGHLY_ADVANCED_SOC.asItem())
                .inputItems(GTEItems.SMD_CAPACITOR_BIOWARE.asStack(8))
                .inputItems(GTEItems.SMD_TRANSISTOR_BIOWARE.asStack(8))
                .inputItems(TagPrefix.wireFine, GTMaterials.Naquadah, 16)
                .inputFluids(GTEMaterials.MutatedLivingSolder.getFluid(144))
                .outputItems(GTEItems.BIOWARE_PROCESSOR.asItem())
                .EUt(491520)
                .duration(200)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_luv"))
                .inputItems(GTItems.ADVANCED_SMD_DIODE.asStack(8))
                .inputItems(GTItems.ADVANCED_SMD_CAPACITOR.asStack(8))
                .inputItems(GTItems.ADVANCED_SMD_TRANSISTOR.asStack(8))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(4))
                .inputItems(TagPrefix.gemFlawless, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.IV].get())
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.LuV].asStack(outputAmount << 1))
                .EUt(122880)
                .duration(570)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("supracausal_processor"))
                .inputItems(GTEItems.SUPRACAUSAL_PROCESSING_CORE.asItem())
                .inputItems(GTEItems.SUPRACAUSAL_RAM_CHIP.asStack(4))
                .inputItems(GTEItems.COSMIC_PROCESSING_UNIT_CORE.asStack(16))
                .inputItems(GTEItems.MICROWORMHOLE_GENERATOR.asItem())
                .inputItems(GTEItems.MANIFOLD_OSCILLATORY_POWER_CELL.asItem())
                .inputItems(TagPrefix.plate, GTEMaterials.CrystalMatrix)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(432))
                .outputItems(GTEItems.SUPRACAUSAL_PROCESSOR.asStack(outputAmount))
                .EUt(125829120)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_mv"))
                .inputItems(GTItems.DIODE.asStack(8))
                .inputItems(GTItems.CAPACITOR.asStack(8))
                .inputItems(GTItems.TRANSISTOR.asStack(8))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.gem, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.LV].get())
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.MV].asStack(outputAmount << 1))
                .EUt(480)
                .duration(150)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_lv"))
                .inputItems(GTItems.DIODE.asStack(4))
                .inputItems(GTItems.CAPACITOR.asStack(4))
                .inputItems(GTItems.TRANSISTOR.asStack(4))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.gem, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.ULV].get())
                .inputFluids(GTMaterials.Tin.getFluid(144))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.LV].asStack(outputAmount << 1))
                .EUt(120)
                .duration(90)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_uv"))
                .inputItems(GTEItems.SMD_DIODE_OPTICAL.asStack(16))
                .inputItems(GTEItems.SMD_CAPACITOR_OPTICAL.asStack(16))
                .inputItems(GTEItems.SMD_TRANSISTOR_OPTICAL.asStack(16))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(8))
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.ZPM].get())
                .inputFluids(GTEMaterials.MutatedLivingSolder.getFluid(288))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.UV].asStack(outputAmount << 1))
                .EUt(1966080)
                .duration(730)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_ev"))
                .inputItems(GTItems.SMD_DIODE.asStack(8))
                .inputItems(GTItems.SMD_CAPACITOR.asStack(8))
                .inputItems(GTItems.SMD_TRANSISTOR.asStack(8))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(4))
                .inputItems(TagPrefix.gemFlawless, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.HV].get())
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.EV].asStack(outputAmount << 1))
                .EUt(7680)
                .duration(330)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_iv"))
                .inputItems(GTItems.ADVANCED_SMD_DIODE.asStack(4))
                .inputItems(GTItems.ADVANCED_SMD_CAPACITOR.asStack(4))
                .inputItems(GTItems.ADVANCED_SMD_TRANSISTOR.asStack(4))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(4))
                .inputItems(TagPrefix.gemFlawless, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.EV].get())
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.IV].asStack(outputAmount << 1))
                .EUt(30720)
                .duration(450)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_circuit_hv"))
                .inputItems(GTItems.SMD_DIODE.asStack(4))
                .inputItems(GTItems.SMD_CAPACITOR.asStack(4))
                .inputItems(GTItems.SMD_TRANSISTOR.asStack(4))
                .inputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asStack(2))
                .inputItems(TagPrefix.gemFlawless, GTEMaterials.MagnetoResonatic)
                .inputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.MV].get())
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                .outputItems(GTEItems.MAGNETO_RESONATIC_CIRCUIT[GTValues.HV].asStack(outputAmount << 1))
                .EUt(1920)
                .duration(230)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hui_circuit_1"))
                .inputItems(GTItems.EXTREME_CIRCUIT_BOARD.asItem())
                .inputItems(TagPrefix.plate, GTMaterials.GarnetYellow, 16)
                .inputItems(GTItems.SYSTEM_ON_CHIP.asStack(8))
                .inputItems(GTItems.NOR_MEMORY_CHIP.asStack(32))
                .inputItems(TagPrefix.wireGtSingle, GTMaterials.Aluminium, 8)
                .inputItems(EIOItems.GUARDIAN_DIODE.asItem())
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                .outputItems(GTEItems.HUI_CIRCUIT_1.asItem())
                .EUt(7680)
                .duration(320)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("bioware_circuit_board"))
                .inputItems(GTItems.WETWARE_BOARD.asStack(32))
                .inputItems(GTEItems.ELECTRICALY_WIRED_PETRI_DISH.asStack(8))
                .inputItems(GTItems.ELECTRIC_PUMP_UV.asItem())
                .inputItems(GTItems.SENSOR_LuV.asStack(2))
                .inputItems(CustomTags.LuV_CIRCUITS)
                .inputItems(TagPrefix.foil, GTMaterials.VanadiumGallium, 32)
                .inputFluids(GTEMaterials.BiohmediumSterilized.getFluid(1000))
                .outputItems(GTEItems.BIOWARE_CIRCUIT_BOARD.asStack(32))
                .EUt(122880)
                .duration(2400)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("cosmic_processor"))
                .inputItems(GTEItems.COSMIC_PROCESSING_CORE.asItem())
                .inputItems(GTEItems.COSMIC_RAM_CHIP.asStack(4))
                .inputItems(GTItems.HIGHLY_ADVANCED_SOC.asItem())
                .inputItems(GTEItems.SMD_CAPACITOR_COSMIC.asStack(16))
                .inputItems(GTEItems.SMD_TRANSISTOR_COSMIC.asStack(16))
                .inputItems(TagPrefix.wireFine, GTEMaterials.Cinobite, 16)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(288))
                .outputItems(GTEItems.COSMIC_PROCESSOR.asStack(outputAmount))
                .EUt(31457280)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("optical_processor"))
                .inputItems(GTEItems.OPTICAL_PROCESSING_CORE.asItem())
                .inputItems(GTEItems.OPTICAL_RAM_CHIP.asStack(4))
                .inputItems(GTItems.HIGHLY_ADVANCED_SOC.asItem())
                .inputItems(GTEItems.SMD_CAPACITOR_OPTICAL.asStack(8))
                .inputItems(GTEItems.SMD_TRANSISTOR_OPTICAL.asStack(8))
                .inputItems(TagPrefix.wireFine, GTMaterials.Dubnium, 16)
                .inputFluids(GTEMaterials.MutatedLivingSolder.getFluid(288))
                .outputItems(GTEItems.OPTICAL_PROCESSOR.asStack(outputAmount))
                .EUt(1966080)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("planet_data_chip"))
                .inputItems(GTItems.TOOL_DATA_STICK.asStack(2))
                .inputItems(GTItems.NOR_MEMORY_CHIP.asStack(16))
                .inputItems(GTItems.SIMPLE_SYSTEM_ON_CHIP.asStack(12))
                .inputItems(TagPrefix.screw, GTMaterials.BlueAlloy, 32)
                .inputItems(TagPrefix.wireFine, GTMaterials.Cupronickel, 32)
                .inputItems(TagPrefix.plate, GTMaterials.StainlessSteel, 4)
                .outputItems(GTEItems.PLANET_DATA_CHIP.asItem())
                .EUt(120)
                .duration(400)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.builder("integrated_circuit_hv").EUt(VA[LV]).duration(600)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.AluminaCeramic, 1)
                .inputItems(INTEGRATED_CIRCUIT_MV, 2)
                .inputItems(INTEGRATED_LOGIC_CIRCUIT, 2)
                .inputItems(RANDOM_ACCESS_MEMORY, 2)
                .inputItems(CustomTags.TRANSISTORS, 4)
                .inputItems(screw, AnnealedCopper, 8)
                .outputItems(INTEGRATED_CIRCUIT_HV)
                .solderMultiplier(2)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.builder("electronic_circuit_lv").EUt(16).duration(200)
                .inputItems(BASIC_CIRCUIT_BOARD)
                .inputItems(CustomTags.RESISTORS, 2)
                .inputItems(wireGtSingle, RedAlloy, 2)
                .inputItems(CustomTags.ULV_CIRCUITS, 2)
                .outputItems(ELECTRONIC_CIRCUIT_LV, outputAmount << 1)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.builder("processor_assembly_hv")
                .EUt(VA[MV]).duration(200)
                .inputItems(PLASTIC_CIRCUIT_BOARD)
                .inputItems(PROCESSOR_MV, 2)
                .inputItems(CustomTags.INDUCTORS, 4)
                .inputItems(CustomTags.CAPACITORS, 8)
                .inputItems(RANDOM_ACCESS_MEMORY, 4)
                .inputItems(wireFine, RedAlloy, 8)
                .outputItems(PROCESSOR_ASSEMBLY_HV, outputAmount << 1)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.builder("wetware_processor_luv_soc").EUt(150000).duration(100)
                .inputItems(GTItems.WETWARE_CIRCUIT_BOARD)
                .inputItems(GTEItems.WETWARE_SOC)
                .inputItems(wireFine, YttriumBariumCuprate, 8)
                .inputItems(bolt, Naquadah, 8)
                .outputItems(WETWARE_PROCESSOR_LuV, outputAmount << 1)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        CIRCUIT_ASSEMBLER_RECIPES.builder("wetware_board").duration(1200).EUt(VA[LuV])
                .inputItems(MULTILAYER_FIBER_BOARD, 16)
                .inputItems(GTEItems.STERILIZED_PETRI_DISH)
                .inputItems(ELECTRIC_PUMP_LuV)
                .inputItems(SENSOR_IV)
                .inputItems(CustomTags.IV_CIRCUITS)
                .inputItems(foil, NiobiumTitanium, 16)
                .inputFluids(GTEMaterials.Indalloy140.getFluid(2304))
                .outputItems(WETWARE_BOARD, 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }
}
