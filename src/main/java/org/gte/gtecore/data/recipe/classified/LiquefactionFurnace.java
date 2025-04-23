package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEFluids;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import net.minecraftforge.fluids.FluidStack;

import static org.gte.gtecore.common.data.GTERecipeTypes.LIQUEFACTION_FURNACE_RECIPES;

interface LiquefactionFurnace {

    static void init() {
        LIQUEFACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("gelid_cryotheum"))
                .inputItems(GTEItems.DUST_CRYOTHEUM.asItem())
                .outputFluids(new FluidStack(GTEFluids.GELID_CRYOTHEUM.get(), 144))
                .EUt(491520)
                .duration(80)
                .blastFurnaceTemp(300)
                .save();

        LIQUEFACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("antimatter"))
                .inputItems(GTEItems.PELLET_ANTIMATTER.asItem())
                .outputFluids(GTEMaterials.Antimatter.getFluid(1000))
                .EUt(480)
                .duration(2000)
                .blastFurnaceTemp(19999)
                .save();
    }
}
