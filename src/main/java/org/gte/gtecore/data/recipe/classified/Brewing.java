package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.BREWING_RECIPES;

interface Brewing {

    static void init() {
        BREWING_RECIPES.recipeBuilder(GTECore.id("dragon_blood"))
                .inputItems(GTEItems.DRAGON_CELLS.asItem())
                .inputFluids(GTMaterials.SterileGrowthMedium.getFluid(1000))
                .outputFluids(GTEMaterials.DragonBlood.getFluid(1000))
                .EUt(480)
                .duration(6000)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();
    }
}
