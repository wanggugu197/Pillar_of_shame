package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.EXTRUDER_RECIPES;

interface Extruder {

    static void init() {
        EXTRUDER_RECIPES.recipeBuilder(GTECore.id("special_ceramics"))
                .inputItems(TagPrefix.dust, GTEMaterials.SpecialCeramics, 2)
                .notConsumable(GTItems.SHAPE_EXTRUDER_PLATE.asItem())
                .outputItems(GTEItems.SPECIAL_CERAMICS.asItem())
                .EUt(480)
                .duration(20)
                .save();
    }
}
