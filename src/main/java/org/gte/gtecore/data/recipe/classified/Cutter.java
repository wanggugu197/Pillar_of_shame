package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.StringUtils;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import javax.annotation.Nullable;

import static org.gte.gtecore.common.data.GTERecipeTypes.CUTTER_RECIPES;

interface Cutter {

    static void init() {
        CUTTER_RECIPES.recipeBuilder(GTECore.id("exotic_ram_chip"))
                .inputItems(GTEItems.EXOTIC_RAM_WAFER.asItem())
                .inputFluids(GTEMaterials.ExtremeTemperatureWater.getFluid(480))
                .outputItems(GTEItems.EXOTIC_RAM_CHIP.asStack(32))
                .EUt(524288)
                .duration(900)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("bioware_chip"))
                .inputItems(GTEItems.BIOWARE_BOULE.asItem())
                .inputFluids(GTEMaterials.ExtremeTemperatureWater.getFluid(300))
                .outputItems(GTEItems.BIOWARE_CHIP.asStack(16))
                .outputItems(GTEItems.BIOLOGICAL_CELLS.asStack(8))
                .EUt(491520)
                .duration(600)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("fm_chip"))
                .inputItems(GTEItems.FM_WAFER.asItem())
                .inputFluids(GTEMaterials.ExtremeTemperatureWater.getFluid(1440))
                .outputItems(GTEItems.FM_CHIP.asStack(2))
                .EUt(524288)
                .duration(2700)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("cosmic_soc"))
                .inputItems(GTEItems.SIMPLE_COSMIC_SOC_WAFER.asItem())
                .inputFluids(GTEMaterials.DegassedWater.getFluid(450))
                .outputItems(GTEItems.SIMPLE_COSMIC_SOC.asStack(8))
                .EUt(7864320)
                .duration(900)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("pm_chip"))
                .inputItems(GTEItems.PM_WAFER.asItem())
                .inputFluids(GTEMaterials.PHNeutralWater.getFluid(900))
                .outputItems(GTEItems.PM_CHIP.asStack(4))
                .EUt(122880)
                .duration(1800)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("nm_chip"))
                .inputItems(GTEItems.NM_WAFER.asItem())
                .inputFluids(GTEMaterials.FlocculentWater.getFluid(900))
                .outputItems(GTEItems.NM_CHIP.asStack(4))
                .EUt(30720)
                .duration(1800)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("photocoated_hassium_wafer"))
                .inputItems(GTEItems.PHOTOCOATED_HASSIUM_BOULE.asItem())
                .inputFluids(GTEMaterials.BaryonicPerfectionWater.getFluid(140))
                .outputItems(GTEItems.PHOTOCOATED_HASSIUM_WAFER.asStack(4))
                .EUt(31457280)
                .duration(280)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("cosmic_ram_chip"))
                .inputItems(GTEItems.COSMIC_RAM_WAFER.asItem())
                .inputFluids(GTEMaterials.ElectricEquilibriumWater.getFluid(480))
                .outputItems(GTEItems.COSMIC_RAM_CHIP.asStack(32))
                .EUt(2097152)
                .duration(900)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("rutherfordium_neutronium_wafer"))
                .inputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_BOULE.asItem())
                .inputFluids(GTEMaterials.FlocculentWater.getFluid(1600))
                .outputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_WAFER.asStack(64))
                .outputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_WAFER.asStack(32))
                .EUt(30720)
                .duration(3200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("supracausal_ram_chip"))
                .inputItems(GTEItems.SUPRACAUSAL_RAM_WAFER.asItem())
                .inputFluids(GTEMaterials.DegassedWater.getFluid(480))
                .outputItems(GTEItems.SUPRACAUSAL_RAM_CHIP.asStack(4))
                .EUt(8388608)
                .duration(900)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("taranium_wafer"))
                .inputItems(GTEItems.TARANIUM_BOULE.asItem())
                .inputFluids(GTEMaterials.PHNeutralWater.getFluid(1600))
                .outputItems(GTEItems.TARANIUM_WAFER.asStack(64))
                .outputItems(GTEItems.TARANIUM_WAFER.asStack(64))
                .EUt(122880)
                .duration(3200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("optical_slice"))
                .inputItems(GTEItems.OPTICAL_WAFER.asItem())
                .inputFluids(GTEMaterials.ElectricEquilibriumWater.getFluid(280))
                .outputItems(GTEItems.OPTICAL_SLICE.asStack(16))
                .EUt(1966080)
                .duration(560)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("exotic_chip"))
                .inputItems(GTEItems.EXOTIC_WAFER.asItem())
                .inputFluids(GTEMaterials.ElectricEquilibriumWater.getFluid(450))
                .outputItems(GTEItems.EXOTIC_CHIP.asStack(4))
                .EUt(1966080)
                .duration(900)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("optical_ram_chip"))
                .inputItems(GTEItems.OPTICAL_RAM_WAFER.asItem())
                .inputFluids(GTEMaterials.PHNeutralWater.getFluid(450))
                .outputItems(GTEItems.OPTICAL_RAM_CHIP.asStack(32))
                .EUt(122880)
                .duration(900)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("silicon_crystal_seed"))
                .inputItems(TagPrefix.block, GTMaterials.Silicon)
                .outputItems(GTETagPrefix.CRYSTAL_SEED, GTMaterials.Silicon, 16)
                .inputFluids(GTMaterials.DistilledWater.getFluid(10000))
                .EUt(120)
                .duration(2600)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("electronicgradesilicon_crystal_seed"))
                .inputItems(TagPrefix.block, GTEMaterials.ElectronicGradeSilicon)
                .outputItems(GTETagPrefix.CRYSTAL_SEED, GTEMaterials.ElectronicGradeSilicon, 16)
                .inputFluids(GTEMaterials.OzoneWater.getFluid(10000))
                .EUt(480)
                .duration(4800)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id("ultrahighpuritysilicon_crystal_seed"))
                .inputItems(TagPrefix.block, GTEMaterials.UltraHighPuritySilicon)
                .outputItems(GTETagPrefix.CRYSTAL_SEED, GTEMaterials.UltraHighPuritySilicon, 16)
                .inputFluids(GTEMaterials.PHNeutralWater.getFluid(10000))
                .EUt(1920)
                .duration(6000)
                .save();

        add("minecraft:beef", "farmersdelight:minced_beef", 2, null, 1);
        add("farmersdelight:ham", "minecraft:porkchop", 2, "minecraft:bone", 1);
        add("minecraft:cake", "farmersdelight:cake_slice", 7, null, 1);
        add("minecraft:cooked_mutton", "farmersdelight:cooked_mutton_chops", 2, null, 1);
        add("minecraft:salmon", "farmersdelight:salmon_slice", 2, "minecraft:bone_meal", 1);
        add("farmersdelight:smoked_ham", "minecraft:cooked_porkchop", 2, "minecraft:bone", 1);
        add("farmersdelight:sweet_berry_cheesecake", "farmersdelight:sweet_berry_cheesecake_slice", 4, null, 1);
        add("minecraft:chicken", "farmersdelight:chicken_cuts", 2, "minecraft:bone_meal", 1);
        add("minecraft:cooked_cod", "farmersdelight:cooked_cod_slice", 2, "minecraft:bone_meal", 1);
        add("gtceu:dough", "farmersdelight:raw_pasta", 1, null, 1);
        add("farmersdelight:rice_panicle", "farmersdelight:rice", 1, "farmersdelight:straw", 1);
        add("farmersdelight:kelp_roll", "farmersdelight:kelp_roll_slice", 3, null, 1);
        add("minecraft:rose_bush", "farmersrespite:rose_hips", 2, null, 1);
        add("minecraft:pumpkin", "farmersdelight:pumpkin_slice", 4, null, 1);
        add("farmersrespite:coffee_cake", "farmersrespite:coffee_cake_slice", 7, null, 1);
        add("minecraft:mutton", "farmersdelight:mutton_chops", 2, null, 1);
        add("farmersrespite:coffee_berries", "farmersrespite:coffee_beans", 1, null, 1);
        add("farmersdelight:chocolate_pie", "farmersdelight:chocolate_pie_slice", 4, null, 1);
        add("minecraft:cooked_salmon", "farmersdelight:cooked_salmon_slice", 2, "minecraft:bone_meal", 1);
        add("minecraft:porkchop", "farmersdelight:bacon", 2, null, 1);
        add("farmersdelight:cabbage", "farmersdelight:cabbage_leaf", 2, null, 1);
        add("farmersrespite:rose_hip_pie", "farmersrespite:rose_hip_pie_slice", 4, null, 1);
        add("farmersdelight:apple_pie", "farmersdelight:apple_pie_slice", 4, null, 1);
        add("minecraft:cod", "farmersdelight:cod_slice", 2, "minecraft:bone_meal", 1);
        add("minecraft:cooked_chicken", "farmersdelight:cooked_chicken_cuts", 2, "minecraft:bone_meal", 1);
    }

    private static void add(String input, String output1, int c1, @Nullable String output2, int c2) {
        GTERecipeBuilder builder = CUTTER_RECIPES.recipeBuilder(GTECore.id(StringUtils.decompose(output1)[1]))
                .inputItems(input)
                .outputItems(output1, c1)
                .EUt(8)
                .duration(20);

        if (output2 != null) {
            builder.outputItems(output2, c2);
        }
        builder.save();
    }
}
