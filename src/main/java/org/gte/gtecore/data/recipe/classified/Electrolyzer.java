package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.ELECTROLYZER_RECIPES;

interface Electrolyzer {

    static void init() {
        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("radium_nitrate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.RadiumNitrate, 9)
                .outputItems(TagPrefix.dust, GTMaterials.Radium)
                .outputFluids(GTMaterials.Nitrogen.getFluid(2000))
                .outputFluids(GTMaterials.Oxygen.getFluid(6000))
                .EUt(500)
                .duration(160)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("trinium_tetrafluoride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.TriniumTetrafluoride, 5)
                .inputFluids(GTEMaterials.MoltenCalciumSalts.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Trinium)
                .outputItems(TagPrefix.dust, GTMaterials.Calcium, 2)
                .outputFluids(GTMaterials.Fluorine.getFluid(6000))
                .EUt(1920)
                .duration(200)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("sodium_chlorate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumHypochlorite, 9)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumChlorate, 5)
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 4)
                .EUt(120)
                .duration(210)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("actinium_nitrate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ActiniumNitrate, 13)
                .outputItems(TagPrefix.dust, GTMaterials.Actinium)
                .outputFluids(GTMaterials.Nitrogen.getFluid(3000))
                .outputFluids(GTMaterials.Oxygen.getFluid(9000))
                .EUt(500)
                .duration(210)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("purified_xenoxene"))
                .inputItems(TagPrefix.dust, GTEMaterials.XenoxeneCrystal, 4)
                .inputFluids(GTMaterials.Oil.getFluid(1000))
                .outputFluids(GTEMaterials.PurifiedXenoxene.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(30720)
                .duration(900)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("caesium_nitrate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CaesiumNitrate, 5)
                .outputItems(TagPrefix.dust, GTMaterials.Caesium)
                .outputFluids(GTMaterials.Nitrogen.getFluid(1000))
                .outputFluids(GTMaterials.Oxygen.getFluid(3000))
                .EUt(30)
                .duration(170)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("lithium_aluminium_fluoride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.LithiumAluminiumFluoride, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.AluminiumTrifluoride, 4)
                .outputItems(TagPrefix.dust, GTEMaterials.LithiumFluoride, 2)
                .EUt(120)
                .duration(250)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("trinium_compound_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.TriniumCompound, 14)
                .outputItems(TagPrefix.dust, GTMaterials.Trinium, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Actinium, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Selenium, 4)
                .outputItems(TagPrefix.dust, GTMaterials.Astatine, 4)
                .EUt(31457280)
                .duration(560)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("sodium_hexafluoroaluminate"))
                .inputItems(TagPrefix.dust, GTEMaterials.Alumina, 10)
                .inputFluids(GTEMaterials.SodiumHexafluoroaluminate.getFluid(1000))
                .outputItems(GTEItems.RAW_ALUMINUM, 4)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.AluminiumTrifluoride, 4)
                .outputFluids(GTMaterials.Oxygen.getFluid(6000))
                .EUt(120)
                .duration(160)
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("trimethylamine"))
                .inputFluids(GTEMaterials.Trimethylamine.getFluid(13000))
                .outputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputFluids(GTMaterials.Hydrogen.getFluid(9000))
                .outputFluids(GTMaterials.Nitrogen.getFluid(1000))
                .EUt(125)
                .duration(140)
                .save();
    }
}
