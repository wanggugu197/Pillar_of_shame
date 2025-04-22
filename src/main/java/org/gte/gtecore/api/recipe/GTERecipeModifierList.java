package org.gte.gtecore.api.recipe;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GTERecipeModifierList implements GTERecipeModifier {

    private final RecipeModifier[] modifiers;

    public GTERecipeModifierList(RecipeModifier... modifiers) {
        this.modifiers = modifiers;
    }

    public GTERecipeModifierList(GTERecipeModifier... modifiers) {
        this.modifiers = modifiers;
    }

    @Override
    public @Nullable GTRecipe applyModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        for (RecipeModifier modifier : modifiers) {
            recipe = modifier.applyModifier(machine, recipe);
            if (recipe == null) return null;
        }
        return recipe;
    }
}
