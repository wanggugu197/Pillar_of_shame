package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.machines.MultiBlockG;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.SCANNER_RECIPES;

interface Scanner {

    static void init() {
        SCANNER_RECIPES.recipeBuilder(GTECore.id("nether_reactor_core"))
                .notConsumable(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.THE_NETHER))
                .inputItems(MultiBlockG.ANCIENT_REACTOR_CORE.getItem())
                .inputFluids(GTMaterials.Wax.getFluid(2304))
                .outputItems(MultiBlockG.NETHER_REACTOR_CORE.getItem())
                .EUt(120)
                .duration(1200)
                .save();

        SCANNER_RECIPES.recipeBuilder(GTECore.id("planet_data_chip"))
                .notConsumable(GTEItems.PLANET_DATA_CHIP.get())
                .EUt(120)
                .duration(600)
                .save();
    }
}
