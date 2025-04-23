package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;

import appeng.core.definitions.AEItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.MASS_FABRICATOR_RECIPES;

interface MassFabricator {

    static void init() {
        MASS_FABRICATOR_RECIPES.recipeBuilder(GTECore.id("uu_matter"))
                .inputItems(new ItemStack(AEItems.MATTER_BALL.asItem()))
                .inputFluids(GTEMaterials.UuAmplifier.getFluid(10))
                .outputFluids(GTMaterials.UUMatter.getFluid(10))
                .EUt(31457280)
                .duration(20)
                .save();

        MASS_FABRICATOR_RECIPES.recipeBuilder(GTECore.id("quasifissioning_plasma"))
                .inputItems(TagPrefix.ingot, GTMaterials.Uranium238)
                .inputFluids(GTMaterials.Uranium238.getFluid(144))
                .outputFluids(GTEMaterials.Quasifissioning.getFluid(FluidStorageKeys.PLASMA, 144))
                .EUt(7864320)
                .duration(200)
                .save();
    }
}
