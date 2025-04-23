package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.ORE_WASHER_RECIPES;

interface OreWasher {

    static void init() {
        ORE_WASHER_RECIPES.recipeBuilder(GTECore.id("clean_inert_residues_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.InertResidues)
                .inputFluids(GTMaterials.AquaRegia.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.CleanInertResidues)
                .EUt(480)
                .duration(400)
                .save();

        ORE_WASHER_RECIPES.recipeBuilder(GTECore.id("clean_raw_tengam_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.RawTengam)
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.CleanRawTengam)
                .EUt(480)
                .duration(800)
                .save();
    }
}
