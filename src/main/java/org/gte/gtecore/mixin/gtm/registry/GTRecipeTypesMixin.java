package org.gte.gtecore.mixin.gtm.registry;

import org.gte.gtecore.common.data.GTERecipeTypes;
import org.gte.gtecore.utils.register.RecipeTypeRegisterUtils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.recipe.*;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GCYMRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

import com.hepdd.gtmthings.data.GTMTRecipeTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GTRecipeTypes.class)
public final class GTRecipeTypesMixin {

    @Inject(method = "register", at = @At("HEAD"), remap = false, cancellable = true)
    private static void register(String name, String group, RecipeType<?>[] proxyRecipes, CallbackInfoReturnable<GTRecipeType> cir) {
        cir.setReturnValue(RecipeTypeRegisterUtils.register(name, group, proxyRecipes));
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public static void init() {
        GCYMRecipeTypes.init();
        GTERecipeTypes.init();
        GTMTRecipeTypes.init();
        GTRegistries.RECIPE_TYPES.freeze();
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, GTCEu.id("crafting_facade_cover"),
                FacadeCoverRecipe.SERIALIZER);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, GTCEu.id("crafting_shaped_strict"),
                StrictShapedRecipe.SERIALIZER);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, GTCEu.id("crafting_shaped_energy_transfer"),
                ShapedEnergyTransferRecipe.SERIALIZER);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, GTCEu.id("crafting_tool_head_replace"),
                ToolHeadReplaceRecipe.SERIALIZER);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, GTCEu.id("crafting_shaped_fluid_container"),
                ShapedFluidContainerRecipe.SERIALIZER);
    }
}
