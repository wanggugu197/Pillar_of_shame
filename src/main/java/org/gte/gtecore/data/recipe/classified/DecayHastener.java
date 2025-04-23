package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.DECAY_HASTENER_RECIPES;

interface DecayHastener {

    static void init() {
        DECAY_HASTENER_RECIPES.recipeBuilder(GTECore.id("polonium_dust"))
                .inputFluids(GTMaterials.Bismuth.getFluid(144))
                .outputItems(TagPrefix.dust, GTMaterials.Polonium)
                .EUt(480)
                .duration(8000)
                .save();

        DECAY_HASTENER_RECIPES.recipeBuilder(GTECore.id("rutherfordium_dust"))
                .inputFluids(GTMaterials.Seaborgium.getFluid(144))
                .outputItems(TagPrefix.dust, GTMaterials.Rutherfordium)
                .EUt(480)
                .duration(4000)
                .save();

        DECAY_HASTENER_RECIPES.recipeBuilder(GTECore.id("flyb_plasma"))
                .inputFluids(GTEMaterials.Quasifissioning.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(GTEMaterials.Flyb.getFluid(FluidStorageKeys.PLASMA, 1000))
                .EUt(122880)
                .duration(160)
                .save();

        DECAY_HASTENER_RECIPES.recipeBuilder(GTECore.id("rutherfordium_dust1"))
                .inputFluids(GTMaterials.Actinium.getFluid(144))
                .outputItems(TagPrefix.dust, GTMaterials.Rutherfordium)
                .EUt(480)
                .duration(8000)
                .save();

        DECAY_HASTENER_RECIPES.recipeBuilder(GTECore.id("hafnium"))
                .inputFluids(GTEMaterials.Ytterbium178.getFluid(144))
                .outputFluids(GTMaterials.Hafnium.getFluid(144))
                .EUt(30720)
                .duration(120)
                .save();

        DECAY_HASTENER_RECIPES.recipeBuilder(GTECore.id("copper76_dust"))
                .inputFluids(GTMaterials.Copper.getFluid(144))
                .outputItems(TagPrefix.dust, GTEMaterials.Copper76)
                .EUt(1920)
                .duration(4000)
                .save();

        DECAY_HASTENER_RECIPES.recipeBuilder(GTECore.id("actinium_dust"))
                .inputFluids(GTMaterials.Radium.getFluid(144))
                .outputItems(TagPrefix.dust, GTMaterials.Actinium)
                .EUt(480)
                .duration(2000)
                .save();

        DECAY_HASTENER_RECIPES.recipeBuilder(GTECore.id("meitnerium_dust"))
                .inputFluids(GTMaterials.Hassium.getFluid(144))
                .outputItems(TagPrefix.dust, GTMaterials.Meitnerium)
                .EUt(480)
                .duration(8000)
                .save();
    }
}
