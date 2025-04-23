package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.SIFTER_RECIPES;

interface Sifter {

    static void init() {
        SIFTER_RECIPES.recipeBuilder(GTECore.id("tricalcium_phosphate_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.TricalciumPhosphate, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.TricalciumPhosphateCeramic)
                .EUt(120)
                .duration(280)
                .save();

        SIFTER_RECIPES.recipeBuilder(GTECore.id("cobalt_oxide_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.CobaltOxide, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.CobaltOxideCeramic)
                .EUt(240)
                .duration(120)
                .save();

        SIFTER_RECIPES.recipeBuilder(GTECore.id("alumina_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Alumina, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.AluminaCeramic)
                .EUt(120)
                .duration(150)
                .save();

        SIFTER_RECIPES.recipeBuilder(GTECore.id("magnesium_oxide_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Magnesia, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.MagnesiumOxideCeramic)
                .EUt(240)
                .duration(140)
                .save();

        SIFTER_RECIPES.recipeBuilder(GTECore.id("boron_carbide_ceramics_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.BoronCarbide, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.BoronCarbideCeramics)
                .EUt(240)
                .duration(100)
                .save();

        SIFTER_RECIPES.recipeBuilder(GTECore.id("zirconia_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ZirconiumOxide, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.ZirconiaCeramic)
                .EUt(480)
                .duration(120)
                .save();
    }
}
