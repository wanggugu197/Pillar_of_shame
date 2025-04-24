package org.gte.gtecore.mixin.mc;

import org.gte.gtecore.common.data.GTELoots;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.storage.loot.LootDataId;
import net.minecraft.world.level.storage.loot.LootDataManager;
import net.minecraft.world.level.storage.loot.LootDataType;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.datafixers.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(value = LootDataManager.class, priority = 0)
public class LootDataManagerMixin {

    @Shadow
    private Multimap<LootDataType<?>, ResourceLocation> typeKeys;

    @Shadow
    private Map<LootDataId<?>, ?> elements;

    @Inject(method = "scheduleElementParse", at = @At("HEAD"), cancellable = true)
    private static <T> void scheduleElementParse(LootDataType<T> lootDataType, ResourceManager resourceManager, Executor backgroundExecutor, Map<LootDataType<?>, Map<ResourceLocation, ?>> elementCollector, CallbackInfoReturnable<CompletableFuture<?>> cir) {
        if (GTELoots.cache) cir.setReturnValue(CompletableFuture.runAsync(() -> {}, backgroundExecutor));
    }

    @Inject(method = "apply", at = @At("HEAD"), cancellable = true)
    private void apply(Map<LootDataType<?>, Map<ResourceLocation, ?>> collectedElements, CallbackInfo ci) {
        ci.cancel();
        if (!GTELoots.cache) {
            GTELoots.cache = true;
            Pair<ImmutableMap<LootDataId<?>, ?>, ImmutableMultimap<LootDataType<?>, ResourceLocation>> pair = GTELoots.apply(collectedElements);
            GTELoots.ELEMENTS_CACHE = pair.getFirst();
            GTELoots.TYPEKEYS_CACHE = pair.getSecond();
        }
        elements = GTELoots.ELEMENTS_CACHE;
        typeKeys = GTELoots.TYPEKEYS_CACHE;
    }
}
