package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.DESULFURIZER_RECIPES;

interface Desulfurizer {

    static void init() {
        DESULFURIZER_RECIPES.recipeBuilder(GTECore.id("naphtha"))
                .inputFluids(GTMaterials.SulfuricNaphtha.getFluid(12000))
                .outputItems(TagPrefix.dust, GTMaterials.Sulfur)
                .outputFluids(GTMaterials.Naphtha.getFluid(12000))
                .EUt(30)
                .duration(120)
                .save();

        DESULFURIZER_RECIPES.recipeBuilder(GTECore.id("light_fuel"))
                .inputFluids(GTMaterials.SulfuricLightFuel.getFluid(12000))
                .outputItems(TagPrefix.dust, GTMaterials.Sulfur)
                .outputFluids(GTMaterials.LightFuel.getFluid(12000))
                .EUt(30)
                .duration(120)
                .save();

        DESULFURIZER_RECIPES.recipeBuilder(GTECore.id("heavy_fuel"))
                .inputFluids(GTMaterials.SulfuricHeavyFuel.getFluid(12000))
                .outputItems(TagPrefix.dust, GTMaterials.Sulfur)
                .outputFluids(GTMaterials.HeavyFuel.getFluid(12000))
                .EUt(30)
                .duration(120)
                .save();

        DESULFURIZER_RECIPES.recipeBuilder(GTECore.id("gas"))
                .inputFluids(GTMaterials.SulfuricGas.getFluid(12000))
                .outputItems(TagPrefix.dust, GTMaterials.Sulfur)
                .outputFluids(GTMaterials.RefineryGas.getFluid(12000))
                .EUt(30)
                .duration(120)
                .save();
    }
}
