package org.gte.gtecore.data.recipe;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMachines;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.data.CraftingComponents;
import org.gte.gtecore.utils.RLUtils;
import org.gte.gtecore.utils.TagUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import com.hepdd.gtmthings.data.CustomItems;
import com.tterrag.registrate.util.entry.ItemEntry;

import java.util.List;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.lens;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.HULL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Diamond;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.*;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.PUMP;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;

interface HatchRecipe {

    static void init(Consumer<FinishedRecipe> provider) {
        MaterialEntry lensDiamond = new MaterialEntry(lens, Diamond);
        ItemStack activeTransformer = GTMultiMachines.ACTIVE_TRANSFORMER.asStack();
        ItemStack coverEnergyDetector = GTItems.COVER_ENERGY_DETECTOR_ADVANCED.asStack();

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("rotor_holder_uhv"), GTMachines.ROTOR_HOLDER[UHV].asStack(),
                "SGS", "GHG", "SGS", 'H', GTMachines.HULL[UHV].asStack(), 'G',
                new MaterialEntry(TagPrefix.gear, GTEMaterials.Orichalcum), 'S',
                new MaterialEntry(TagPrefix.gearSmall, GTMaterials.Neutronium));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("rotor_holder_uev"), GTMachines.ROTOR_HOLDER[UEV].asStack(),
                "SGS", "GHG", "SGS", 'H', GTMachines.HULL[UEV].asStack(), 'G',
                new MaterialEntry(TagPrefix.gear, GTEMaterials.AstralTitanium), 'S',
                new MaterialEntry(TagPrefix.gearSmall, GTEMaterials.Quantanium));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("rotor_holder_uiv"), GTMachines.ROTOR_HOLDER[UIV].asStack(),
                "SGS", "GHG", "SGS", 'H', GTMachines.HULL[UIV].asStack(), 'G',
                new MaterialEntry(TagPrefix.gear, GTEMaterials.CelestialTungsten), 'S',
                new MaterialEntry(TagPrefix.gearSmall, GTEMaterials.Infuscolium));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("rotor_holder_uxv"), GTMachines.ROTOR_HOLDER[UXV].asStack(),
                "SGS", "GHG", "SGS", 'H', GTMachines.HULL[UXV].asStack(), 'G',
                new MaterialEntry(TagPrefix.gear, GTEMaterials.Vibramantium), 'S',
                new MaterialEntry(TagPrefix.gearSmall, GTEMaterials.HastelloyK243));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("rotor_holder_opv"), GTMachines.ROTOR_HOLDER[OpV].asStack(),
                "SGS", "GHG", "SGS", 'H', GTMachines.HULL[OpV].asStack(), 'G',
                new MaterialEntry(TagPrefix.gear, GTEMaterials.HexaphaseCopper), 'S',
                new MaterialEntry(TagPrefix.gearSmall, GTEMaterials.TranscendentMetal));
        VanillaRecipeHelper.addShapedRecipe(provider, GTECore.id("primitive_blast_furnace_hatch"), GTEMachines.PRIMITIVE_BLAST_FURNACE_HATCH.asStack(),
                "ABA",
                'B', GTBlocks.CASING_PRIMITIVE_BRICKS.asStack(), 'A', TagUtils.createTag(RLUtils.forge("chests")));

        for (int tier : tiersBetween(LV, MAX)) {
            ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("dual_import_bus_" + VN[tier].toLowerCase()))
                    .inputItems(FRAME.get(tier))
                    .inputItems(ITEM_IMPORT_BUS[tier].getItem())
                    .inputItems(FLUID_IMPORT_HATCH[tier].getItem())
                    .inputItems(CraftingComponents.BUFFER.get(tier))
                    .inputItems(PIPE_NONUPLE.get(tier))
                    .inputItems(GLASS.get(tier))
                    .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                    .outputItems(DUAL_IMPORT_HATCH[tier].getItem())
                    .duration(300)
                    .EUt(VA[tier])
                    .save();

            ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("dual_export_bus_" + VN[tier].toLowerCase()))
                    .inputItems(FRAME.get(tier))
                    .inputItems(ITEM_EXPORT_BUS[tier].getItem())
                    .inputItems(FLUID_EXPORT_HATCH[tier].getItem())
                    .inputItems(CraftingComponents.BUFFER.get(tier))
                    .inputItems(PIPE_NONUPLE.get(tier))
                    .inputItems(GLASS.get(tier))
                    .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                    .outputItems(DUAL_EXPORT_HATCH[tier].getItem())
                    .duration(300)
                    .EUt(VA[tier])
                    .save();
        }

        for (int tier = LV; tier < LuV; tier++) {
            String tierName = VN[tier].toLowerCase();
            MachineDefinition inputBuffer = DUAL_IMPORT_HATCH[tier];
            MachineDefinition outputBuffer = DUAL_EXPORT_HATCH[tier];
            VanillaRecipeHelper.addShapedRecipe(provider, GTECore.id("dual_hatch_output_to_input_" + tierName), inputBuffer.asStack(), "d", "B", 'B', outputBuffer.getItem());
            VanillaRecipeHelper.addShapedRecipe(provider, GTECore.id("dual_hatch_input_to_output_" + tierName), outputBuffer.asStack(), "d", "B", 'B', inputBuffer.getItem());
        }

        Material[] multiHatchMaterials = {
                GTMaterials.Neutronium, GTEMaterials.Enderium, GTEMaterials.Enderium,
                GTEMaterials.HeavyQuarkDegenerateMatter,
                GTEMaterials.HeavyQuarkDegenerateMatter,
        };
        for (int i = 0; i < multiHatchMaterials.length; i++) {
            var tier = GTMachineUtils.MULTI_HATCH_TIERS[i + 6];
            var tierName = VN[tier].toLowerCase();

            var material = multiHatchMaterials[i];

            var importHatch = GTMachines.FLUID_IMPORT_HATCH[tier];
            var exportHatch = GTMachines.FLUID_EXPORT_HATCH[tier];

            var importHatch4x = GTMachines.FLUID_IMPORT_HATCH_4X[tier];
            var exportHatch4x = GTMachines.FLUID_EXPORT_HATCH_4X[tier];
            var importHatch9x = GTMachines.FLUID_IMPORT_HATCH_9X[tier];
            var exportHatch9x = GTMachines.FLUID_EXPORT_HATCH_9X[tier];

            VanillaRecipeHelper.addShapedRecipe(
                    provider, true, GTECore.id("fluid_import_hatch_4x_" + tierName),
                    importHatch4x.asStack(), "P", "M",
                    'M', importHatch.asStack(),
                    'P', new MaterialEntry(TagPrefix.pipeQuadrupleFluid, material));
            VanillaRecipeHelper.addShapedRecipe(
                    provider, true, GTECore.id("fluid_export_hatch_4x_" + tierName),
                    exportHatch4x.asStack(), "M", "P",
                    'M', exportHatch.asStack(),
                    'P', new MaterialEntry(TagPrefix.pipeQuadrupleFluid, material));
            VanillaRecipeHelper.addShapedRecipe(
                    provider, true, GTECore.id("fluid_import_hatch_9x_" + tierName),
                    importHatch9x.asStack(), "P", "M",
                    'M', importHatch.asStack(),
                    'P', new MaterialEntry(TagPrefix.pipeNonupleFluid, material));
            VanillaRecipeHelper.addShapedRecipe(
                    provider, true, GTECore.id("fluid_export_hatch_9x_" + tierName),
                    exportHatch9x.asStack(), "M", "P",
                    'M', exportHatch.asStack(),
                    'P', new MaterialEntry(TagPrefix.pipeNonupleFluid, material));
        }

        for (int tier = 1; tier < 4; tier++) {
            var hatch = GTEMachines.ENERGY_INPUT_HATCH_4A[tier];

            ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_4a_" + VN[tier].toLowerCase())
                    .inputItems(GTMachines.ENERGY_INPUT_HATCH[tier])
                    .inputItems(WIRE_QUAD.get(tier), 2)
                    .inputItems(PLATE.get(tier), 2)
                    .outputItems(hatch)
                    .duration(100).EUt(VA[tier]).save();
        }

        for (int tier = 1; tier < 4; tier++) {
            MachineDefinition hatch = GTEMachines.ENERGY_INPUT_HATCH_16A[tier];
            MachineDefinition transformer;
            transformer = GTMachines.TRANSFORMER[tier];
            ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("energy_hatch_16a_" + VN[tier].toLowerCase()))
                    .inputItems(transformer)
                    .inputItems(GTEMachines.ENERGY_INPUT_HATCH_4A[tier])
                    .inputItems(WIRE_OCT.get(tier), 2)
                    .inputItems(PLATE.get(tier), 4)
                    .outputItems(hatch)
                    .duration(200).EUt(VA[tier]).save();
        }

        for (int tier = 1; tier < 4; tier++) {
            var hatch = GTEMachines.ENERGY_OUTPUT_HATCH_4A[tier];
            ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("dynamo_hatch_4a_" + VN[tier].toLowerCase()))
                    .inputItems(GTMachines.ENERGY_OUTPUT_HATCH[tier])
                    .inputItems(WIRE_QUAD.get(tier), 2)
                    .inputItems(PLATE.get(tier), 2)
                    .outputItems(hatch)
                    .duration(100)
                    .EUt(VA[tier])
                    .save();
        }

        for (int tier = 1; tier < 4; tier++) {
            MachineDefinition hatch = GTEMachines.ENERGY_OUTPUT_HATCH_16A[tier];

            MachineDefinition transformer;
            transformer = GTMachines.TRANSFORMER[tier];

            ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("dynamo_hatch_16a_" + VN[tier].toLowerCase()))
                    .inputItems(transformer)
                    .inputItems(GTEMachines.ENERGY_OUTPUT_HATCH_4A[tier])
                    .inputItems(WIRE_OCT.get(tier), 2)
                    .inputItems(PLATE.get(tier), 4)
                    .outputItems(hatch)
                    .duration(200).EUt(VA[tier]).save();
        }

        List<ItemEntry<ComponentItem>> WIRELESS_ENERGY_RECEIVE_COVER = List.of(
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_LV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_MV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_HV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_EV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_IV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_LUV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_ZPM,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UHV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UEV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UIV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UXV,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_OPV,
                GTEItems.WIRELESS_ENERGY_RECEIVE_COVER_MAX);

        List<ItemEntry<ComponentItem>> WIRELESS_ENERGY_RECEIVE_COVER_4A = List.of(
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_LV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_MV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_HV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_EV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_IV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_LUV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_ZPM_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UHV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UEV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UIV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_UXV_4A,
                CustomItems.WIRELESS_ENERGY_RECEIVE_COVER_OPV_4A,
                GTEItems.WIRELESS_ENERGY_RECEIVE_COVER_MAX_4A);

        for (int tier : tiersBetween(LV, MAX)) {
            String tierName = VN[tier].toLowerCase();
            ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("programmablec_hatch_" + tierName + "_4a"))
                    .inputItems(GTMachines.DUAL_IMPORT_HATCH[tier].getItem())
                    .inputItems(CustomItems.VIRTUAL_ITEM_PROVIDER.asItem())
                    .inputItems((ItemStack) ROBOT_ARM.get(tier))
                    .inputItems((ItemStack) CONVEYOR.get(tier))
                    .inputItems(CustomTags.CIRCUITS_ARRAY[tier], 4)
                    .inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
                    .outputItems(GTEMachines.PROGRAMMABLEC_HATCH[tier].getItem())
                    .duration(400)
                    .EUt(GTValues.VA[tier])
                    .save();

            LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName))
                    .inputItems(GTMachines.ENERGY_INPUT_HATCH[tier].getItem())
                    .inputItems(WIRELESS_ENERGY_RECEIVE_COVER.get(tier - 1).asItem())
                    .inputItems(coverEnergyDetector)
                    .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_2[tier].getItem())
                    .duration(200)
                    .EUt(VA[tier])
                    .save();

            LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName))
                    .inputItems(GTMachines.ENERGY_OUTPUT_HATCH[tier].getItem())
                    .inputItems(WIRELESS_ENERGY_RECEIVE_COVER.get(tier - 1).asItem())
                    .inputItems(coverEnergyDetector)
                    .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_2[tier].getItem())
                    .duration(200)
                    .EUt(VA[tier])
                    .save();

            LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_4a"))
                    .inputItems(tier > HV ? GTMachines.ENERGY_INPUT_HATCH_4A[tier].asStack() : GTEMachines.ENERGY_INPUT_HATCH_4A[tier].getItem())
                    .inputItems(WIRELESS_ENERGY_RECEIVE_COVER.get(tier - 1).asStack(2))
                    .inputItems(coverEnergyDetector)
                    .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_4[tier].getItem())
                    .duration(200)
                    .EUt(VA[tier])
                    .save();

            LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_16a"))
                    .inputItems(tier > HV ? GTMachines.ENERGY_INPUT_HATCH_16A[tier].asStack() : GTEMachines.ENERGY_INPUT_HATCH_16A[tier].getItem())
                    .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asItem())
                    .inputItems(coverEnergyDetector)
                    .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_16[tier].getItem())
                    .duration(200)
                    .EUt(VA[tier])
                    .save();

            LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_4a"))
                    .inputItems(tier > HV ? GTMachines.ENERGY_OUTPUT_HATCH_4A[tier].asStack() : GTEMachines.ENERGY_OUTPUT_HATCH_4A[tier].getItem())
                    .inputItems(WIRELESS_ENERGY_RECEIVE_COVER.get(tier - 1).asStack(2))
                    .inputItems(coverEnergyDetector)
                    .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_4[tier].getItem())
                    .duration(200)
                    .EUt(VA[tier])
                    .save();

            LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_16a"))
                    .inputItems(tier > HV ? GTMachines.ENERGY_OUTPUT_HATCH_16A[tier].asStack() : GTEMachines.ENERGY_OUTPUT_HATCH_16A[tier].getItem())
                    .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asItem())
                    .inputItems(coverEnergyDetector)
                    .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_16[tier].getItem())
                    .duration(200)
                    .EUt(VA[tier])
                    .save();

            if (tier > HV) {
                LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_64a"))
                        .inputItems(GTMachines.SUBSTATION_ENERGY_INPUT_HATCH[tier].getItem())
                        .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(2))
                        .inputItems(coverEnergyDetector)
                        .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_64[tier].getItem())
                        .duration(200)
                        .EUt(VA[tier])
                        .save();

                LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_64a"))
                        .inputItems(GTMachines.SUBSTATION_ENERGY_OUTPUT_HATCH[tier].getItem())
                        .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(2))
                        .inputItems(coverEnergyDetector)
                        .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_64[tier].getItem())
                        .duration(200)
                        .EUt(VA[tier])
                        .save();

                if (tier > EV) {
                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_256a"))
                            .inputItems(GTMachines.LASER_INPUT_HATCH_256[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(2))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_256[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_1024a"))
                            .inputItems(GTMachines.LASER_INPUT_HATCH_1024[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(4))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_1024[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_4096a"))
                            .inputItems(GTMachines.LASER_INPUT_HATCH_4096[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(8))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_4096[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_16384a"))
                            .inputItems(GTEMachines.LASER_INPUT_HATCH_16384[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(12))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_16384[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_65536a"))
                            .inputItems(GTEMachines.LASER_INPUT_HATCH_65536[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(16))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_65536[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_262144a"))
                            .inputItems(GTEMachines.LASER_INPUT_HATCH_262144[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(24))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_262144[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_1048576a"))
                            .inputItems(GTEMachines.LASER_INPUT_HATCH_1048576[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(32))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_1048576[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_input_hatch_" + tierName + "_4194304a"))
                            .inputItems(GTEMachines.LASER_INPUT_HATCH_4194304[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(64))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_INPUT_HATCH_4194304[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_256a"))
                            .inputItems(GTMachines.LASER_OUTPUT_HATCH_256[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(2))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_256[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_1024a"))
                            .inputItems(GTMachines.LASER_OUTPUT_HATCH_1024[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(4))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_1024[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_4096a"))
                            .inputItems(GTMachines.LASER_OUTPUT_HATCH_4096[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(8))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_4096[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_16384a"))
                            .inputItems(GTEMachines.LASER_OUTPUT_HATCH_16384[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(12))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_16384[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_65536a"))
                            .inputItems(GTEMachines.LASER_OUTPUT_HATCH_65536[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(16))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_65536[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_262144a"))
                            .inputItems(GTEMachines.LASER_OUTPUT_HATCH_262144[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(24))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_262144[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_1048576a"))
                            .inputItems(GTEMachines.LASER_OUTPUT_HATCH_1048576[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(32))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_1048576[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("wireless_energy_output_hatch_" + tierName + "_4194304a"))
                            .inputItems(GTEMachines.LASER_OUTPUT_HATCH_4194304[tier].getItem())
                            .inputItems(WIRELESS_ENERGY_RECEIVE_COVER_4A.get(tier - 1).asStack(64))
                            .inputItems(activeTransformer)
                            .outputItems(GTEMachines.WIRELESS_OUTPUT_HATCH_4194304[tier].getItem())
                            .duration(200)
                            .EUt(VA[tier])
                            .save();

                    Item sensor = ((ItemStack) SENSOR.get(tier)).getItem();
                    Item emitter = ((ItemStack) EMITTER.get(tier)).getItem();
                    Item pump = ((ItemStack) PUMP.get(tier)).getItem();
                    MaterialEntry cable = (MaterialEntry) CABLE_OCT.get(tier);

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "16384_i"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 8)
                            .inputItems(sensor, 8)
                            .inputItems(pump, 8)
                            .inputItems(cable, 4)
                            .circuitMeta(4)
                            .outputItems(GTEMachines.LASER_INPUT_HATCH_16384[tier].getItem())
                            .duration(2400)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "65536_i"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 16)
                            .inputItems(sensor, 16)
                            .inputItems(pump, 16)
                            .inputItems(cable, 8)
                            .circuitMeta(5)
                            .outputItems(GTEMachines.LASER_INPUT_HATCH_65536[tier].getItem())
                            .duration(3200)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "262144_i"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 32)
                            .inputItems(sensor, 32)
                            .inputItems(pump, 32)
                            .inputItems(cable, 16)
                            .circuitMeta(6)
                            .outputItems(GTEMachines.LASER_INPUT_HATCH_262144[tier].getItem())
                            .duration(4800)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "1048576_i"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 64)
                            .inputItems(sensor, 64)
                            .inputItems(pump, 64)
                            .inputItems(cable, 32)
                            .circuitMeta(7)
                            .outputItems(GTEMachines.LASER_INPUT_HATCH_1048576[tier].getItem())
                            .duration(6400)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "4194304_i"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 128)
                            .inputItems(sensor, 128)
                            .inputItems(pump, 128)
                            .inputItems(cable, 64)
                            .circuitMeta(8)
                            .outputItems(GTEMachines.LASER_INPUT_HATCH_4194304[tier].getItem())
                            .duration(9600)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "16384_o"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 8)
                            .inputItems(emitter, 8)
                            .inputItems(pump, 8)
                            .inputItems(cable, 4)
                            .circuitMeta(4)
                            .outputItems(GTEMachines.LASER_OUTPUT_HATCH_16384[tier].getItem())
                            .duration(2400)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "65536_o"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 16)
                            .inputItems(emitter, 16)
                            .inputItems(pump, 16)
                            .inputItems(cable, 8)
                            .circuitMeta(5)
                            .outputItems(GTEMachines.LASER_OUTPUT_HATCH_65536[tier].getItem())
                            .duration(3200)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "262144_o"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 32)
                            .inputItems(emitter, 32)
                            .inputItems(pump, 32)
                            .inputItems(cable, 16)
                            .circuitMeta(6)
                            .outputItems(GTEMachines.LASER_OUTPUT_HATCH_262144[tier].getItem())
                            .duration(4800)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "1048576_o"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 64)
                            .inputItems(emitter, 64)
                            .inputItems(pump, 64)
                            .inputItems(cable, 32)
                            .circuitMeta(7)
                            .outputItems(GTEMachines.LASER_OUTPUT_HATCH_1048576[tier].getItem())
                            .duration(6400)
                            .EUt(VA[tier])
                            .save();

                    ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(tierName + "4194304_o"))
                            .inputItems(HULL[tier])
                            .inputItems(lensDiamond, 128)
                            .inputItems(emitter, 128)
                            .inputItems(pump, 128)
                            .inputItems(cable, 64)
                            .circuitMeta(8)
                            .outputItems(GTEMachines.LASER_OUTPUT_HATCH_4194304[tier].getItem())
                            .duration(9600)
                            .EUt(VA[tier])
                            .save();
                }
            }
        }
    }
}
