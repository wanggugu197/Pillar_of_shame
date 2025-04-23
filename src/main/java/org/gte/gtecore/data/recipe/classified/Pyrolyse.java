package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.PYROLYSE_RECIPES;

interface Pyrolyse {

    static void init() {
        PYROLYSE_RECIPES.recipeBuilder(GTECore.id("rawradox1"))
                .inputItems(GTEBlocks.VARIATION_WOOD.asStack(16))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.EnrichedXenoxene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Ash)
                .outputFluids(GTEMaterials.RawRadox.getFluid(10000))
                .EUt(7864320)
                .duration(600)
                .save();

        PYROLYSE_RECIPES.recipeBuilder(GTECore.id("rawradox"))
                .inputItems(GTEBlocks.VARIATION_WOOD.asStack(16))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Xenoxene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Ash)
                .outputFluids(GTEMaterials.RawRadox.getFluid(1000))
                .EUt(491520)
                .duration(900)
                .save();
    }
}
