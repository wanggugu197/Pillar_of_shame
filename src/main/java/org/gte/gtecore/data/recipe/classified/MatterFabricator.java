package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import net.minecraft.world.item.ItemStack;

import appeng.core.definitions.AEItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.MATTER_FABRICATOR_RECIPES;

interface MatterFabricator {

    static void init() {
        MATTER_FABRICATOR_RECIPES.recipeBuilder(GTECore.id("uu_amplifier"))
                .inputItems(GTEItems.SCRAP.asItem())
                .circuitMeta(1)
                .outputFluids(GTEMaterials.UuAmplifier.getFluid(1))
                .EUt(491520)
                .duration(200)
                .save();

        MATTER_FABRICATOR_RECIPES.recipeBuilder(GTECore.id("uu_amplifier_1"))
                .inputItems(GTEItems.SCRAP.asItem())
                .circuitMeta(2)
                .outputItems(new ItemStack(AEItems.MATTER_BALL.asItem(), 64))
                .EUt(491520)
                .duration(1)
                .save();

        MATTER_FABRICATOR_RECIPES.recipeBuilder(GTECore.id("uu_amplifier_2"))
                .inputItems(GTEItems.SCRAP_BOX.asItem())
                .circuitMeta(2)
                .outputItems(new ItemStack(AEItems.MATTER_BALL.asItem(), 576))
                .EUt(1966080)
                .duration(1)
                .save();

        MATTER_FABRICATOR_RECIPES.recipeBuilder(GTECore.id("uu_amplifier_a"))
                .inputItems(GTEItems.SCRAP_BOX.asItem())
                .circuitMeta(1)
                .outputFluids(GTEMaterials.UuAmplifier.getFluid(9))
                .EUt(1966080)
                .duration(200)
                .save();
    }
}
