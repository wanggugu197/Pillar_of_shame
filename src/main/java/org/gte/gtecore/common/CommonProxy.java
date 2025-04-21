package org.gte.gtecore.common;

import appeng.api.networking.pathing.ChannelMode;
import appeng.api.storage.StorageCells;
import appeng.core.AEConfig;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.common.data.GTDimensionMarkers;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeConditions;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FusionReactorMachine;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;
import com.hepdd.gtmthings.common.item.AdvancedTerminalBehavior;
import earth.terrarium.adastra.api.events.AdAstraEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.gte.gtecore.GTECore;
import org.gte.gtecore.config.GTEConfig;

public class CommonProxy {

    public CommonProxy() {
        init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    private static void init() {
        if (GTCEu.isDev() || GTCEu.isDataGen()) {
            GTEConfig.INSTANCE.dev = true;
            GTEConfig.INSTANCE.enablePrimitiveVoidOre = true;
        }
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
    }

    private static void addMaterials(MaterialEvent event) {
    }

    private static void registerMaterialRegistry(MaterialRegistryEvent event) {
        MaterialRegistryManager.getInstance().createRegistry(GTECore.MOD_ID);
    }

    private static void registerRecipeConditions(GTCEuAPI.RegisterEvent<ResourceLocation, RecipeConditionType<?>> event) {
    }

    private static void registerDimensionMarkers(GTCEuAPI.RegisterEvent<ResourceLocation, DimensionMarker> event) {
    }
}
