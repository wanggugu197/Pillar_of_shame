package org.gte.gtecore.mixin.gtm.api.recipe;

import org.gte.gtecore.api.recipe.IGTRecipe;

import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.category.GTRecipeCategory;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;

@Mixin(GTRecipe.class)
public class GTRecipeMixin implements IGTRecipe {

    @Shadow(remap = false)
    public int parallels;

    @Unique
    private boolean gtecore$perfect;

    @Unique
    private IntSupplier gtecore$tierSupplier;

    @Unique
    private int gtecore$tier;

    @Inject(method = "<init>(Lcom/gregtechceu/gtceu/api/recipe/GTRecipeType;Lnet/minecraft/resources/ResourceLocation;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lnet/minecraft/nbt/CompoundTag;ILcom/gregtechceu/gtceu/api/recipe/category/GTRecipeCategory;)V", at = @At("TAIL"), remap = false)
    public void gtecore$init(GTRecipeType recipeType, ResourceLocation id, Map<RecipeCapability<?>, List<Content>> inputs, Map<RecipeCapability<?>, List<Content>> outputs, Map<RecipeCapability<?>, List<Content>> tickInputs, Map<RecipeCapability<?>, List<Content>> tickOutputs, Map inputChanceLogics, Map outputChanceLogics, Map tickInputChanceLogics, Map tickOutputChanceLogics, List conditions, List ingredientActions, CompoundTag data, int duration, GTRecipeCategory recipeCategory, CallbackInfo ci) {
        gtecore$tier = -1;
        gtecore$tierSupplier = () -> {
            long EUt = 0;
            var inputlist = tickInputs.get(EURecipeCapability.CAP);
            if (inputlist != null) {
                for (Content content : inputlist) {
                    EUt += EURecipeCapability.CAP.of(content.getContent());
                }
            }
            if (EUt == 0) {
                var outputlist = tickOutputs.get(EURecipeCapability.CAP);
                if (outputlist != null) {
                    for (Content content : outputlist) {
                        EUt += EURecipeCapability.CAP.of(content.getContent());
                    }
                }
            }
            if (parallels > 1) EUt /= parallels;
            return GTUtil.getTierByVoltage(EUt);
        };
    }

    @Inject(method = "copy(Lcom/gregtechceu/gtceu/api/recipe/content/ContentModifier;Z)Lcom/gregtechceu/gtceu/api/recipe/GTRecipe;", at = @At("RETURN"), remap = false)
    public void gtecore$copy(ContentModifier modifier, boolean modifyDuration, CallbackInfoReturnable<GTRecipe> cir) {
        if (gtecore$tierSupplier == null && cir.getReturnValue() instanceof IGTRecipe igtRecipe) {
            igtRecipe.gtecore$setTier(gtecore$tier);
            igtRecipe.gtecore$clean();
        }
    }

    @Override
    public boolean gtecore$perfect() {
        return gtecore$perfect;
    }

    @Override
    public void gtecore$setPerfect(boolean perfect) {
        gtecore$perfect = perfect;
    }

    @Override
    public int gtecore$getTier() {
        if (gtecore$tier < 0) {
            gtecore$tier = gtecore$tierSupplier.getAsInt();
            gtecore$tierSupplier = null;
        }
        return gtecore$tier;
    }

    @Override
    public void gtecore$setTier(int tier) {
        gtecore$tier = tier;
    }

    @Override
    public void gtecore$clean() {
        gtecore$tierSupplier = null;
    }
}
