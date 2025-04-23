package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.DISSOLUTION_TREATMENT_RECIPES;

interface DissolutionTreatment {

    static void init() {
        DISSOLUTION_TREATMENT_RECIPES.recipeBuilder(GTECore.id("rare_earth_hydroxides"))
                .inputItems(TagPrefix.dust, GTMaterials.RareEarth, 10)
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 30)
                .inputFluids(GTMaterials.PhosphoricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(9000))
                .outputFluids(GTEMaterials.RareEarthHydroxides.getFluid(10000))
                .EUt(480)
                .duration(800)
                .save();

        DISSOLUTION_TREATMENT_RECIPES.recipeBuilder(GTECore.id("rhenium_sulfuric_solution"))
                .inputFluids(GTEMaterials.MolybdenumFlue.getFluid(30000))
                .inputFluids(GTMaterials.Water.getFluid(2500))
                .outputFluids(GTEMaterials.RheniumSulfuricSolution.getFluid(30000))
                .EUt(1920)
                .duration(3000)
                .save();

        DISSOLUTION_TREATMENT_RECIPES.recipeBuilder(GTECore.id("bedrock_soot_solution"))
                .inputItems(TagPrefix.dust, GTMaterials.Naquadah, 10)
                .inputFluids(GTEMaterials.BedrockSmoke.getFluid(10000))
                .inputFluids(GTMaterials.DistilledWater.getFluid(10000))
                .outputFluids(GTEMaterials.BedrockSootSolution.getFluid(10000))
                .EUt(7680)
                .duration(4000)
                .save();

        DISSOLUTION_TREATMENT_RECIPES.recipeBuilder(GTECore.id("actinium_radium_hydroxide_solution"))
                .inputFluids(GTEMaterials.ActiniumRadiumHydroxideSolution.getFluid(10000))
                .inputFluids(GTMaterials.NitricAcid.getFluid(120000))
                .outputFluids(GTEMaterials.ActiniumRadiumNitrateSolution.getFluid(130000))
                .EUt(3840)
                .duration(2900)
                .save();
    }
}
