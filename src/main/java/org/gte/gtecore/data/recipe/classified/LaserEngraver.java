package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.RegistriesUtils;

import com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import committee.nova.mods.avaritia.init.registry.ModItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.LASER_ENGRAVER_RECIPES;

interface LaserEngraver {

    static void init() {
        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("advanced_soc_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Purple)
                .outputItems(GTItems.ADVANCED_SYSTEM_ON_CHIP_WAFER.asStack(8))
                .EUt(122880)
                .duration(125)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("soc_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Yellow)
                .outputItems(GTItems.SYSTEM_ON_CHIP_WAFER.asStack(32))
                .EUt(122880)
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("ilc_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Red)
                .outputItems(GTItems.INTEGRATED_LOGIC_CIRCUIT_WAFER.asStack(64))
                .EUt(122880)
                .duration(13)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("ulpic_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Blue)
                .outputItems(GTItems.ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER.asStack(64))
                .EUt(122880)
                .duration(13)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("lanthanum_embedded_fullerene_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.LanthanumFullereneMix, 2)
                .notConsumable(TagPrefix.lens, GTMaterials.Sapphire)
                .inputFluids(GTMaterials.Nitrogen.getFluid(10000))
                .outputItems(TagPrefix.dust, GTEMaterials.LanthanumEmbeddedFullerene, 2)
                .outputFluids(GTMaterials.Ammonia.getFluid(10000))
                .EUt(1966080)
                .duration(320)
                .addData("special", true)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("lpic_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Orange)
                .outputItems(GTItems.LOW_POWER_INTEGRATED_CIRCUIT_WAFER.asStack(64))
                .EUt(122880)
                .duration(13)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("nor_memory_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Pink)
                .outputItems(GTItems.NOR_MEMORY_CHIP_WAFER.asStack(32))
                .EUt(122880)
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("cpu_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.LightBlue)
                .outputItems(GTItems.CENTRAL_PROCESSING_UNIT_WAFER.asStack(64))
                .EUt(122880)
                .duration(13)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("fullerene_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.UnfoldedFullerene)
                .notConsumable(TagPrefix.lens, GTMaterials.Ruby)
                .inputFluids(GTMaterials.Nitrogen.getFluid(10000))
                .outputItems(TagPrefix.dust, GTEMaterials.Fullerene)
                .outputFluids(GTMaterials.Ammonia.getFluid(10000))
                .EUt(2000000)
                .duration(400)
                .addData("special", true)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("nand_memory_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Gray)
                .outputItems(GTItems.NAND_MEMORY_CHIP_WAFER.asStack(32))
                .EUt(122880)
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("highly_advanced_soc_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Black)
                .outputItems(GTItems.HIGHLY_ADVANCED_SOC_WAFER.asStack(4))
                .EUt(122880)
                .duration(225)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("ram_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Green)
                .outputItems(GTItems.RANDOM_ACCESS_MEMORY_WAFER.asStack(64))
                .EUt(122880)
                .duration(13)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("mpic_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Brown)
                .outputItems(GTItems.POWER_INTEGRATED_CIRCUIT_WAFER.asStack(32))
                .EUt(122880)
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("diffractor_grating_mirror"))
                .inputItems(GTEItems.PHOTOCOATED_HASSIUM_WAFER.asItem())
                .notConsumable(GTEItems.GRATING_LITHOGRAPHY_MASK.asItem())
                .outputItems(GTEItems.DIFFRACTOR_GRATING_MIRROR.asItem())
                .EUt(31457280)
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("singularity"))
                .inputItems(TagPrefix.block, GTEMaterials.Magmatter, 16)
                .inputItems(RegistriesUtils.getItemStack("avaritia:singularity", 1, "{Id:\"avaritia:spacetime\"}"))
                .outputItems(ModItems.singularity.get())
                .EUt(527765581332480L)
                .duration(1600)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("exotic_wafer"))
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Magenta)
                .inputItems(GTItems.HIGHLY_ADVANCED_SOC_WAFER.asItem())
                .outputItems(GTEItems.EXOTIC_WAFER.asItem())
                .EUt(1966080)
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("simple_soc_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Cyan)
                .outputItems(GTItems.SIMPLE_SYSTEM_ON_CHIP_WAFER.asStack(64))
                .EUt(122880)
                .duration(13)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("diamond_crystal_circuit"))
                .inputItems(GTETagPrefix.ARTIFICIAL_GEM, GTMaterials.Diamond)
                .notConsumable(TagPrefix.lens, GTEMaterials.ElfGlass)
                .outputItems(GTEItems.DIAMOND_CRYSTAL_CIRCUIT.asStack(8))
                .inputFluids(GTMaterials.DistilledWater.getFluid(800))
                .EUt(1920)
                .duration(800)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("emerald_crystal_circuit"))
                .inputItems(GTETagPrefix.ARTIFICIAL_GEM, GTMaterials.Emerald)
                .notConsumable(TagPrefix.lens, GTEMaterials.ElfGlass)
                .outputItems(GTEItems.EMERALD_CRYSTAL_CIRCUIT.asStack(8))
                .inputFluids(GTMaterials.DistilledWater.getFluid(800))
                .EUt(1920)
                .duration(800)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("ruby_crystal_circuit"))
                .inputItems(GTETagPrefix.ARTIFICIAL_GEM, GTMaterials.Ruby)
                .notConsumable(TagPrefix.lens, GTEMaterials.ElfGlass)
                .outputItems(GTEItems.RUBY_CRYSTAL_CIRCUIT.asStack(8))
                .inputFluids(GTMaterials.DistilledWater.getFluid(800))
                .EUt(1920)
                .duration(800)
                .save();

        LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("sapphire_crystal_circuit"))
                .inputItems(GTETagPrefix.ARTIFICIAL_GEM, GTMaterials.Sapphire)
                .notConsumable(TagPrefix.lens, GTEMaterials.ElfGlass)
                .outputItems(GTEItems.SAPPHIRE_CRYSTAL_CIRCUIT.asStack(8))
                .inputFluids(GTMaterials.DistilledWater.getFluid(800))
                .EUt(1920)
                .duration(800)
                .save();
    }
}
