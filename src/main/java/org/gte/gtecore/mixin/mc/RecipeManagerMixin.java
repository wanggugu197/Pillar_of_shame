package org.gte.gtecore.mixin.mc;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTERecipes;
import org.gte.gtecore.mixin.placebo.RecipeHelperAccessor;

import com.gregtechceu.gtceu.data.pack.GTDynamicDataPack;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = RecipeManager.class, priority = 0)
public abstract class RecipeManagerMixin {

    @Shadow
    private Map<RecipeType<?>, Map<ResourceLocation, Recipe<?>>> recipes;

    @Shadow
    private boolean hasErrors;

    @Shadow
    private Map<ResourceLocation, Recipe<?>> byName;

    @Shadow(remap = false)
    @Final
    private ICondition.IContext context;

    @Inject(method = "apply(Ljava/util/Map; Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"), cancellable = true)
    private void apply(Map<ResourceLocation, JsonElement> object, ResourceManager resourceManager, ProfilerFiller profiler, CallbackInfo ci) {
        ci.cancel();
        if (GTERecipes.cache) {
            this.recipes = GTERecipes.RECIPES_CACHE;
            this.byName = GTERecipes.BYNAME_CACHE;
        } else {
            long time = System.currentTimeMillis();
            this.hasErrors = false;
            Map<RecipeType<?>, Map<ResourceLocation, Recipe<?>>> map1 = new Object2ObjectOpenHashMap<>();
            Map<ResourceLocation, Recipe<?>> map2 = new Object2ObjectOpenHashMap<>(16384);
            for (Map.Entry<ResourceLocation, JsonElement> entry : object.entrySet()) {
                ResourceLocation resourcelocation = entry.getKey();
                if (resourcelocation.getPath().isEmpty() || resourcelocation.getPath().charAt(0) == '_') continue;
                try {
                    if (entry.getValue().isJsonObject() && !CraftingHelper.processConditions(entry.getValue().getAsJsonObject(), "conditions", this.context)) continue;
                    Recipe<?> recipe = GTERecipes.fromJson(resourcelocation, GsonHelper.convertToJsonObject(entry.getValue(), "top element"), this.context);
                    if (recipe == null) continue;
                    map1.computeIfAbsent(recipe.getType(), (p_44075_) -> new Object2ObjectOpenHashMap<>(64, Object2ObjectOpenHashMap.VERY_FAST_LOAD_FACTOR)).put(resourcelocation, recipe);
                    map2.put(resourcelocation, recipe);
                } catch (IllegalArgumentException | JsonParseException ignored) {}
            }
            this.recipes = map1;
            this.byName = map2;
            RecipeHelperAccessor.addRecipes((RecipeManager) (Object) this);
            recipes.replaceAll((k, v) -> ImmutableMap.copyOf(v));
            recipes = ImmutableMap.copyOf(recipes);
            this.byName = ImmutableMap.copyOf(byName);
            GTERecipes.RECIPES_CACHE = this.recipes;
            GTERecipes.BYNAME_CACHE = this.byName;
            GTECore.LOGGER.info("Loaded {} recipes, took {}ms", GTERecipes.BYNAME_CACHE.size(), System.currentTimeMillis() - time);
            GTDynamicDataPack.clearServer();
            RecipeHelperAccessor.getProviders().clear();
            GTERecipes.initLookup(recipes.get(RecipeType.SMELTING));
        }
    }
}
