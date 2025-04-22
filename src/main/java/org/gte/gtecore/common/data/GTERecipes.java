package org.gte.gtecore.common.data;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.GTERecipeType;

import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.item.armor.PowerlessJetpack;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import dev.emi.emi.api.recipe.EmiRecipe;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class GTERecipes {

    private GTERecipes() {}

    public static boolean cache;

    public static Map<RecipeType<?>, Map<ResourceLocation, Recipe<?>>> RECIPES_CACHE;
    public static Map<ResourceLocation, Recipe<?>> BYNAME_CACHE;

    public static Map<GTRecipeType, Widget> EMI_RECIPE_WIDGETS;

    public static ImmutableSet<EmiRecipe> EMI_RECIPES;

    public static Set<ResourceLocation> SHAPED_FILTER_RECIPES;

    public static Set<ResourceLocation> SHAPELESS_FILTER_RECIPES;

    public static final Set<Recipe<?>> KJS_RECIPE = new LinkedHashSet<>();

    public static final Set<GTRecipe> KJS_GT_RECIPE = new LinkedHashSet<>();

    public static Recipe<?> fromJson(ResourceLocation recipeId, JsonObject json, net.minecraftforge.common.crafting.conditions.ICondition.IContext context) {
        String s = GsonHelper.getAsString(json, "type");
        RecipeSerializer<?> recipeSerializer = BuiltInRegistries.RECIPE_SERIALIZER.get(new ResourceLocation(s));
        if (recipeSerializer == null) return null;
        return recipeSerializer.fromJson(recipeId, json, context);
    }

    public static void initLookup(Map<ResourceLocation, Recipe<?>> recipes) {
        cache = true;
        Thread thread = new Thread(() -> {
            long time = System.currentTimeMillis();
            PowerlessJetpack.FUELS.clear();
            GTRegistries.RECIPE_TYPES.forEach(t -> t.getLookup().removeAllRecipes());
            GTERecipeBuilder.RECIPE_MAP.values().forEach(r -> {
                if (r.recipeType instanceof GTERecipeType type && !type.noSearch()) {
                    type.getLookup().addRecipe(r);
                }
            });
            recipes.forEach((k, v) -> GTRecipeTypes.FURNACE_RECIPES.getLookup().addRecipe(GTRecipeTypes.FURNACE_RECIPES.toGTrecipe(k, v)));
            GTECore.LOGGER.info("InitLookup took {}ms", System.currentTimeMillis() - time);
        });
        thread.setDaemon(true);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }
}
