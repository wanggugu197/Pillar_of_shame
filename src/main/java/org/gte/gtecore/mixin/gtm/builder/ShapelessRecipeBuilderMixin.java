package org.gte.gtecore.mixin.gtm.builder;

import org.gte.gtecore.common.data.GTERecipes;

import com.gregtechceu.gtceu.data.recipe.builder.ShapelessRecipeBuilder;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ShapelessRecipeBuilder.class)
public abstract class ShapelessRecipeBuilderMixin {

    @Shadow(remap = false)
    protected ResourceLocation id;

    @Shadow(remap = false)
    protected abstract ResourceLocation defaultId();

    @Inject(method = "save", at = @At("HEAD"), remap = false, cancellable = true)
    private void save(Consumer<FinishedRecipe> consumer, CallbackInfo ci) {
        var ID = id == null ? defaultId() : id;
        if (GTERecipes.SHAPELESS_FILTER_RECIPES != null && GTERecipes.SHAPELESS_FILTER_RECIPES.contains(ID)) ci.cancel();
    }
}
