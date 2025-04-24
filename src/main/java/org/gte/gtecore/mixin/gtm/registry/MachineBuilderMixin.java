package org.gte.gtecore.mixin.gtm.registry;

import org.gte.gtecore.api.recipe.GTERecipeModifierList;

import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MachineBuilder.class)
public class MachineBuilderMixin {

    @Shadow(remap = false)
    private RecipeModifier recipeModifier;

    @Shadow(remap = false)
    private boolean alwaysTryModifyRecipe;

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public MachineBuilder recipeModifier(RecipeModifier recipeModifier) {
        this.recipeModifier = recipeModifier instanceof GTERecipeModifierList list ? list : new GTERecipeModifierList(recipeModifier);
        return (MachineBuilder) (Object) this;
    }

    @Inject(method = "recipeModifiers([Lcom/gregtechceu/gtceu/api/recipe/modifier/RecipeModifier;)Lcom/gregtechceu/gtceu/api/registry/registrate/MachineBuilder;", at = @At("HEAD"), remap = false, cancellable = true)
    private void injectRecipeModifiers(RecipeModifier[] recipeModifiers, CallbackInfoReturnable<MachineBuilder> cir) {
        this.recipeModifier = new GTERecipeModifierList(recipeModifiers);
        cir.setReturnValue((MachineBuilder) (Object) this);
    }

    @Inject(method = "recipeModifiers(Z[Lcom/gregtechceu/gtceu/api/recipe/modifier/RecipeModifier;)Lcom/gregtechceu/gtceu/api/registry/registrate/MachineBuilder;", at = @At("HEAD"), remap = false, cancellable = true)
    private void injectRecipeModifiers(boolean alwaysTryModifyRecipe, RecipeModifier[] recipeModifiers, CallbackInfoReturnable<MachineBuilder> cir) {
        this.recipeModifier = new GTERecipeModifierList(recipeModifiers);
        this.alwaysTryModifyRecipe = alwaysTryModifyRecipe;
        cir.setReturnValue((MachineBuilder) (Object) this);
    }
}
