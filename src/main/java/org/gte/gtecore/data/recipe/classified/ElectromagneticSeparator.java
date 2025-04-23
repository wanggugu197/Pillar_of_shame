package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.ELECTROMAGNETIC_SEPARATOR_RECIPES;

interface ElectromagneticSeparator {

    static void init() {
        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder(GTECore.id("graphene_oxide_dust"))
                .inputItems(GTEItems.GRAPHENE_IRON_PLATE.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.GrapheneOxide, 9)
                .outputItems(TagPrefix.dust, GTMaterials.Iron)
                .EUt(30)
                .duration(120)
                .save();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder(GTECore.id("raw_tengam_dust"))
                .inputItems(TagPrefix.dustPure, GTEMaterials.Jasper)
                .outputItems(TagPrefix.dust, GTEMaterials.Jasper)
                .chancedOutput(TagPrefix.dust, GTEMaterials.RawTengam, 1000, 0)
                .chancedOutput(TagPrefix.dust, GTEMaterials.RawTengam, 500, 0)
                .EUt(24)
                .duration(200)
                .save();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder(GTECore.id("purified_tengam_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CleanRawTengam)
                .outputItems(TagPrefix.dust, GTEMaterials.PurifiedTengam)
                .chancedOutput(TagPrefix.dust, GTMaterials.NeodymiumMagnetic, 1000, 0)
                .chancedOutput(TagPrefix.dust, GTMaterials.SamariumMagnetic, 500, 0)
                .EUt(7864320)
                .duration(200)
                .save();
    }
}
