package org.gte.gtecore.mixin.gtm.api;

import com.gregtechceu.gtceu.api.addon.AddonFinder;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockore.BedrockOreDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.capability.recipe.GTERecipeCapabilities;
import org.gte.gtecore.api.data.GTEWorldGenLayers;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.registries.GTERegistration;
import org.gte.gtecore.common.data.*;
import org.gte.gtecore.data.Datagen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(AddonFinder.class)
public final class AddonFinderMixin {

    @Shadow(remap = false)
    protected static List<IGTAddon> cache;

    @Inject(method = "getAddons", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/addon/AddonFinder;getInstances(Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/List;"), remap = false, cancellable = true)
    private static void getAddons(CallbackInfoReturnable<List<IGTAddon>> cir) {
        cache = List.of(gtecore$GTADDON);
        cir.setReturnValue(cache);
    }

    @Inject(method = "getAddon", at = @At("RETURN"), remap = false, cancellable = true)
    private static void getAddon(String modId, CallbackInfoReturnable<IGTAddon> cir) {
        cir.setReturnValue(modId.equals(GTECore.MOD_ID) ? gtecore$GTADDON : null);
    }

    @Unique
    private static final IGTAddon gtecore$GTADDON = new IGTAddon() {

        @Override
        public String addonModId() {
            return GTECore.MOD_ID;
        }

        @Override
        public GTRegistrate getRegistrate() {
            return GTERegistration.REGISTRATE;
        }

        @Override
        public boolean requiresHighTier() {
            return true;
        }

        @Override
        public void initializeAddon() {
            Datagen.init();
        }

        @Override
        public void registerSounds() {
            GTESoundEntries.init();
        }

        @Override
        public void registerCovers() {
            GTECovers.init();
            GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_BLOCK);
            GTEBlocks.init();
            GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_ITEM);
            GTEItems.init();
        }

        @Override
        public void registerElements() {
            GTEElements.init();
        }

        @Override
        public void registerTagPrefixes() {
            GTETagPrefix.init();
        }

        @Override
        public void registerFluidVeins() {
            GTEBedrockFluids.init();
        }

        @Override
        public void registerBedrockOreVeins() {
            GTEOres.BEDROCK_ORES_DEFINITION.forEach(GTRegistries.BEDROCK_ORE_DEFINITIONS::registerOrOverride);
            GTEOres.BEDROCK_ORES.forEach((id, bedrockOre) -> {
                BedrockOreDefinition definition = BedrockOreDefinition.builder(id).size(9).dimensions(bedrockOre.dimensions()).weight(bedrockOre.weight()).materials(bedrockOre.materials()).yield(2, 8).depletedYield(1).depletionAmount(1).depletionChance(100).register();
                GTEOres.BEDROCK_ORES_DEFINITION.put(id, definition);
            });
            GTEOres.BEDROCK_ORES.clear();
        }

        @Override
        public void registerOreVeins() {
            GTEOres.init();
        }

        @Override
        public void registerWorldgenLayers() {
            GTEWorldGenLayers.init();
        }

        @Override
        public void registerRecipeCapabilities() {
            GTERecipeCapabilities.init();
        }
    };
}
