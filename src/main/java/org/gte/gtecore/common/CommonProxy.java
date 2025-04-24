package org.gte.gtecore.common;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.entity.IEnhancedPlayer;
import org.gte.gtecore.common.data.*;
import org.gte.gtecore.common.forge.ExperienceEventHandler;
import org.gte.gtecore.common.forge.FoodHurtAnimalEventHandler;
import org.gte.gtecore.common.forge.ForgeCommonEvent;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.data.Data;
import org.gte.gtecore.integration.ae2.InfinityCellGuiHandler;
import org.gte.gtecore.integration.ae2.storage.InfinityCellHandler;
import org.gte.gtecore.integration.ftbquests.EMIRecipeModHelper;
import org.gte.gtecore.utils.register.ItemRegisterUtils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FusionReactorMachine;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import appeng.api.networking.pathing.ChannelMode;
import appeng.api.storage.StorageCells;
import appeng.core.AEConfig;
import com.hepdd.gtmthings.common.item.AdvancedTerminalBehavior;
import earth.terrarium.adastra.api.events.AdAstraEvents;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;

public class CommonProxy {

    public CommonProxy() {
        init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(eventBus);
        GTEFluids.FLUID_TYPE.register(eventBus);
        GTEFluids.FLUID.register(eventBus);
        GTEEffects.init(eventBus);
        eventBus.addListener(CommonProxy::commonSetup);
        eventBus.addListener(CommonProxy::addMaterials);
        eventBus.addListener(CommonProxy::registerMaterialRegistry);
        eventBus.addGenericListener(RecipeConditionType.class, CommonProxy::registerRecipeConditions);
        eventBus.addGenericListener(DimensionMarker.class, CommonProxy::registerDimensionMarkers);
        MinecraftForge.EVENT_BUS.register(ForgeCommonEvent.class);
        MinecraftForge.EVENT_BUS.register(FoodHurtAnimalEventHandler.class);
        MinecraftForge.EVENT_BUS.register(ExperienceEventHandler.class);
    }

    private static void init() {
        GTECreativeModeTabs.init();
        GTEConfig.init();
        GTEEntityTypes.init();
        GTENet.init();
        if (GTCEu.isDev() || GTCEu.isDataGen()) {
            GTEConfig.INSTANCE.dev = true;
            GTEConfig.INSTANCE.enablePrimitiveVoidOre = true;
        }
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ItemRegisterUtils::InitUpgrades);
        StorageCells.addCellHandler(InfinityCellHandler.INSTANCE);
        StorageCells.addCellGuiHandler(new InfinityCellGuiHandler());
        if (GTEConfig.getDifficulty() == 3) AEConfig.instance().setChannelModel(ChannelMode.DEFAULT);

        FusionReactorMachine.registerFusionTier(GTValues.UHV, " (MKIV)");
        FusionReactorMachine.registerFusionTier(GTValues.UEV, " (MKV)");

        AdAstraEvents.OxygenTickEvent.register(IEnhancedPlayer::spaceTick);
        AdAstraEvents.AcidRainTickEvent.register(IEnhancedPlayer::spaceTick);
        AdAstraEvents.TemperatureTickEvent.register(IEnhancedPlayer::spaceTick);
        AdAstraEvents.EntityGravityEvent.register(IEnhancedPlayer::gravity);

        AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("thread_hatch");
        AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("accelerate_hatch");
        AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("programmablec_hatch");
        AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("gravity_hatch");
        AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("vacuum_hatch");

        if (GTCEu.isProd() && GTCEu.Mods.isEMILoaded()) EMIRecipeModHelper.setRecipeModHelper();

        if (GTCEu.isClientSide()) {
            Thread thread = new Thread(Data::asyncInit, "GTECore Data");
            thread.setDaemon(true);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }
    }

    private static void addMaterials(MaterialEvent event) {
        GTEMaterials.init();
    }

    private static void registerMaterialRegistry(MaterialRegistryEvent event) {
        MaterialRegistryManager.getInstance().createRegistry(GTECore.MOD_ID);
    }

    private static void registerRecipeConditions(GTCEuAPI.RegisterEvent<ResourceLocation, RecipeConditionType<?>> event) {
        GTERecipeConditions.init();
    }

    private static void registerDimensionMarkers(GTCEuAPI.RegisterEvent<ResourceLocation, DimensionMarker> event) {
        GTEDimensionMarkers.init();
    }

    public static void afterStartup() {
        ModList.get().getAllScanData().clear();
        if (GTCEu.isProd()) {
            Configurator.setRootLevel(Level.INFO);
        } else {
            Configurator.setRootLevel(Level.DEBUG);
        }
    }
}
