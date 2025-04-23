package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;

import static org.gte.gtecore.common.data.GTERecipeTypes.LATHE_RECIPES;

interface Lathe {

    static void init() {
        LATHE_RECIPES.recipeBuilder(GTECore.id("non_linear_optical_lens"))
                .inputItems(GTEItems.PERIODICALLY_POLED_LITHIUM_NIOBATE_BOULE.asItem())
                .outputItems(GTEItems.NON_LINEAR_OPTICAL_LENS.asItem())
                .EUt(1966080)
                .duration(360)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LATHE_RECIPES.recipeBuilder(GTECore.id("magmatter_rod"))
                .inputItems(TagPrefix.ingot, GTEMaterials.Magmatter)
                .outputItems(TagPrefix.rod, GTEMaterials.Magmatter)
                .outputItems(TagPrefix.dustSmall, GTEMaterials.Magmatter)
                .EUt(2013265920)
                .duration(200)
                .save();
    }
}
