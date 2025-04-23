package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.RegistriesUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.PACKER_RECIPES;

interface Packer {

    static void init() {
        PACKER_RECIPES.recipeBuilder(GTECore.id("zero_point_module"))
                .inputItems(GTEItems.ZERO_POINT_MODULE_FRAGMENTS.asStack(64))
                .outputItems(GTItems.ZERO_POINT_MODULE.asItem())
                .EUt(120)
                .duration(2000)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("scrap_box"))
                .inputItems(GTEItems.SCRAP.asStack(9))
                .outputItems(GTEItems.SCRAP_BOX.asItem())
                .EUt(12)
                .duration(200)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("tiny_degenerate_rhenium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.DegenerateRhenium)
                .outputItems(TagPrefix.dustTiny, GTEMaterials.DegenerateRhenium, 9)
                .EUt(1920)
                .duration(20)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_max"))
                .inputItems(CustomTags.MAX_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.MAX].get())
                .EUt(7)
                .duration(32768)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_luv"))
                .inputItems(CustomTags.LuV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.LuV].get())
                .EUt(7)
                .duration(128)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_opv"))
                .inputItems(CustomTags.OpV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.OpV].get())
                .EUt(7)
                .duration(16384)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_uxv"))
                .inputItems(CustomTags.UXV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.UXV].get())
                .EUt(7)
                .duration(8192)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_ulv"))
                .inputItems(CustomTags.ULV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.ULV].get())
                .EUt(7)
                .duration(2)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_uev"))
                .inputItems(CustomTags.UEV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.UEV].get())
                .EUt(7)
                .duration(2048)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_uhv"))
                .inputItems(CustomTags.UHV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.UHV].get())
                .EUt(7)
                .duration(1024)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_uiv"))
                .inputItems(CustomTags.UIV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.UIV].get())
                .EUt(7)
                .duration(4096)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_mv"))
                .inputItems(CustomTags.MV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.MV].get())
                .EUt(7)
                .duration(8)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_lv"))
                .inputItems(CustomTags.LV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.LV].get())
                .EUt(7)
                .duration(4)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_uv"))
                .inputItems(CustomTags.UV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.UV].get())
                .EUt(7)
                .duration(512)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_hv"))
                .inputItems(CustomTags.HV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.HV].get())
                .EUt(7)
                .duration(16)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_iv"))
                .inputItems(CustomTags.IV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.IV].get())
                .EUt(7)
                .duration(64)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_ev"))
                .inputItems(CustomTags.EV_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.EV].get())
                .EUt(7)
                .duration(32)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("universal_circuit_zpm"))
                .inputItems(CustomTags.ZPM_CIRCUITS)
                .outputItems(GTEItems.UNIVERSAL_CIRCUIT[GTValues.ZPM].get())
                .EUt(7)
                .duration(256)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("magmatter_dust"))
                .inputItems(GTETagPrefix.NANITES, GTEMaterials.TranscendentMetal)
                .inputItems(TagPrefix.dustSmall, GTEMaterials.Magmatter, 4)
                .outputItems(GTETagPrefix.CONTAMINABLE_NANITES, GTEMaterials.TranscendentMetal)
                .outputItems(TagPrefix.dust, GTEMaterials.Magmatter)
                .EUt(30)
                .duration(20)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("carrot_crate"))
                .inputItems(new ItemStack(Items.CARROT.asItem(), 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:carrot_crate"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("potato_crate"))
                .inputItems(new ItemStack(Items.POTATO.asItem(), 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:potato_crate"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("beetroot_crate"))
                .inputItems(new ItemStack(Items.BEETROOT.asItem(), 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:beetroot_crate"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("cabbage_crate"))
                .inputItems(RegistriesUtils.getItemStack("farmersdelight:cabbage", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:cabbage_crate"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("tomato_crate"))
                .inputItems(RegistriesUtils.getItemStack("farmersdelight:tomato", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:tomato_crate"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("onion_crate"))
                .inputItems(RegistriesUtils.getItemStack("farmersdelight:onion", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:onion_crate"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("rice_bale"))
                .inputItems(RegistriesUtils.getItemStack("farmersdelight:rice_panicle", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:rice_bale"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("rice_bag"))
                .inputItems(RegistriesUtils.getItemStack("farmersdelight:rice", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:rice_bag"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("straw_bale"))
                .inputItems(RegistriesUtils.getItemStack("farmersdelight:straw", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersdelight:straw_bale"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("green_tea_leaves_sack"))
                .inputItems(RegistriesUtils.getItemStack("farmersrespite:green_tea_leaves", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersrespite:green_tea_leaves_sack"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("yellow_tea_leaves_sack"))
                .inputItems(RegistriesUtils.getItemStack("farmersrespite:yellow_tea_leaves", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersrespite:yellow_tea_leaves_sack"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("black_tea_leaves_sack"))
                .inputItems(RegistriesUtils.getItemStack("farmersrespite:black_tea_leaves", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersrespite:black_tea_leaves_sack"))
                .EUt(12)
                .duration(10)
                .save();

        PACKER_RECIPES.recipeBuilder(GTECore.id("coffee_beans_sack"))
                .inputItems(RegistriesUtils.getItemStack("farmersrespite:coffee_beans", 9))
                .outputItems(RegistriesUtils.getItemStack("farmersrespite:coffee_beans_sack"))
                .EUt(12)
                .duration(10)
                .save();
    }
}
