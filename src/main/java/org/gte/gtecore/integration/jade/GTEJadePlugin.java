package org.gte.gtecore.integration.jade;

import com.gregtechceu.gtceu.api.block.MetaMachineBlock;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.common.blockentity.FluidPipeBlockEntity;
import com.gregtechceu.gtceu.common.data.GTMaterialItems;
import com.gregtechceu.gtceu.integration.jade.provider.*;
import com.hepdd.gtmthings.integration.jade.provider.WirelessEnergyHatchProvider;
import com.hepdd.gtmthings.integration.jade.provider.WirelessOpticalComputationHatchProvider;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.gte.gtecore.api.blockentity.ManaMachineBlockEntity;
import org.gte.gtecore.integration.jade.provider.AccelerateBlockProvider;
import snownee.jade.addon.harvest.HarvestToolProvider;
import snownee.jade.addon.harvest.SimpleToolHandler;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;

import java.util.Objects;

public final class GTEJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(new UpgradeModuleProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new WirelessInteractorMachineProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new ElectricContainerBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new WorkableBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new ControllableBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new RecipeLogicProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new ParallelProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new RecipeOutputProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new MultiblockStructureProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new MaintenanceBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new ExhaustVentBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new SteamBoilerBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new AutoOutputBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new CableBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new MachineModeProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new StainedColorProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new TransformerBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new PrimitivePumpBlockProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new MEPatternBufferProxyProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new MEPatternBufferProvider(), MetaMachineBlockEntity.class);

        registration.registerItemStorage(GTItemStorageProvider.INSTANCE, MetaMachineBlockEntity.class);
        registration.registerFluidStorage(GTFluidStorageProvider.INSTANCE, MetaMachineBlockEntity.class);
        registration.registerFluidStorage(FluidPipeStorageProvider.INSTANCE, FluidPipeBlockEntity.class);

        registration.registerBlockDataProvider(new WirelessEnergyHatchProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new WirelessOpticalComputationHatchProvider(), MetaMachineBlockEntity.class);

        registration.registerBlockDataProvider(new TemperatureProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new VacuumTierProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new ManaContainerBlockProvider(), ManaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new TickTimeProvider(), MetaMachineBlockEntity.class);
        registration.registerBlockDataProvider(new AccelerateBlockProvider(), BlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(new UpgradeModuleProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new WirelessInteractorMachineProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new ElectricContainerBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new WorkableBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new ControllableBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new RecipeLogicProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new ParallelProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new RecipeOutputProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new MultiblockStructureProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new MaintenanceBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new ExhaustVentBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new SteamBoilerBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new AutoOutputBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new CableBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new MachineModeProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new StainedColorProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new TransformerBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new PrimitivePumpBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new MEPatternBufferProxyProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new MEPatternBufferProvider(), MetaMachineBlock.class);

        registration.registerItemStorageClient(GTItemStorageProvider.INSTANCE);
        registration.registerFluidStorageClient(GTFluidStorageProvider.INSTANCE);
        registration.registerFluidStorageClient(FluidPipeStorageProvider.INSTANCE);

        registration.registerBlockComponent(new WirelessEnergyHatchProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new WirelessOpticalComputationHatchProvider(), MetaMachineBlock.class);

        registration.registerBlockComponent(new TemperatureProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new VacuumTierProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new ManaContainerBlockProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new TickTimeProvider(), MetaMachineBlock.class);
        registration.registerBlockComponent(new AccelerateBlockProvider(), Block.class);
    }

    static {
        GTMaterialItems.TOOL_ITEMS.columnMap().forEach((type, map) -> {
            if (type.harvestTags.isEmpty() || type.harvestTags.get(0).location().getNamespace().equals("minecraft")) return;
            HarvestToolProvider.registerHandler(new SimpleToolHandler(type.name, type.harvestTags.get(0), map.values().stream().filter(Objects::nonNull).filter(ItemProviderEntry::isPresent).map(ItemProviderEntry::asItem).toArray(Item[]::new)));
        });
    }
}
