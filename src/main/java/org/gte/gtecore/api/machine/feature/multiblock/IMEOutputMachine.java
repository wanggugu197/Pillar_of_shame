package org.gte.gtecore.api.machine.feature.multiblock;

import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import org.jetbrains.annotations.NotNull;

public interface IMEOutputMachine {

    default boolean gTECore$DualMEOutput(@NotNull GTRecipe recipe) {
        return false;
    }

    default boolean gTECore$DualMEOutput(boolean hasItem, boolean hasFluid) {
        return false;
    }
}
