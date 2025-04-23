package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.ISOSTATIC_PRESSING_RECIPES;

interface IsostaticPressing {

    static void init() {
        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("barium_titanate_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.BariumTitanateCeramic, 9)
                .inputFluids(GTMaterials.Epoxy.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.BariumTitanateCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("tungsten_tetraboride_ceramics_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.TungstenTetraborideCeramics, 9)
                .inputFluids(GTMaterials.Nickel.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.TungstenTetraborideCeramics)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("silica_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.SilicaCeramic, 9)
                .inputFluids(GTMaterials.Epoxy.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.SilicaCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("hydroxyapatite_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.HydroxyapatiteCeramic, 9)
                .inputFluids(GTMaterials.Epoxy.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.HydroxyapatiteCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("tellurate_ceramics_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.TellurateCeramics, 9)
                .inputFluids(GTMaterials.Epoxy.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.TellurateCeramics)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("thulium_hexaboride_ceramics_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.ThuliumHexaborideCeramics, 9)
                .inputFluids(GTMaterials.Aluminium.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.ThuliumHexaborideCeramics)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("silicon_nitride_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.SiliconNitrideCeramic, 9)
                .inputFluids(GTEMaterials.PolyurethaneResin.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.SiliconNitrideCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("cobalt_oxide_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.CobaltOxideCeramic, 9)
                .inputFluids(GTMaterials.Glue.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.CobaltOxideCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("calcium_oxide_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.CalciumOxideCeramic, 9)
                .inputFluids(GTMaterials.Glue.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.CalciumOxideCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("lithium_oxide_ceramics_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.LithiumOxideCeramics, 9)
                .inputFluids(GTEMaterials.PhenolicResin.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.LithiumOxideCeramics)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("magnesium_oxide_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.MagnesiumOxideCeramic, 9)
                .inputFluids(GTMaterials.Glue.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.MagnesiumOxideCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("tricalcium_phosphate_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.TricalciumPhosphateCeramic, 9)
                .inputFluids(GTEMaterials.PhenolicResin.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.TricalciumPhosphateCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("titanium_nitride_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.TitaniumNitrideCeramic, 9)
                .inputFluids(GTMaterials.Epoxy.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.TitaniumNitrideCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("zirconia_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.ZirconiaCeramic, 9)
                .inputFluids(GTMaterials.Epoxy.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.ZirconiaCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("strontium_carbonate_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.StrontiumCarbonateCeramic, 9)
                .inputFluids(GTMaterials.Epoxy.getFluid(1000))
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.StrontiumCarbonateCeramic)
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("aluminaceramic_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.AluminaCeramic, 9)
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.AluminaCeramic)
                .inputFluids(GTMaterials.Glue.getFluid(1000))
                .EUt(500)
                .duration(200)
                .save();

        ISOSTATIC_PRESSING_RECIPES.recipeBuilder(GTECore.id("boroncarbideceramics_ceramic_rough_blank"))
                .inputItems(TagPrefix.dust, GTEMaterials.BoronCarbideCeramics, 9)
                .outputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.BoronCarbideCeramics)
                .inputFluids(GTMaterials.Epoxy.getFluid(1000))
                .EUt(500)
                .duration(200)
                .save();
    }
}
