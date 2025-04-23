package org.gte.gtecore.common.data;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.pipelike.cable.Insulation;

import net.minecraft.world.item.CreativeModeTab;

import com.tterrag.registrate.util.entry.RegistryEntry;

import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;

public interface GTECreativeModeTabs {

    RegistryEntry<CreativeModeTab> GTE_ITEM = REGISTRATE
            .defaultCreativeTab("item", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("item", REGISTRATE))
                    .title(REGISTRATE.addLang("itemGroup", GTECore.id("item"), GTECore.NAME + " | Item"))
                    .icon(GTEItems.MEGA_MAX_BATTERY::asStack)
                    .build())
            .register();

    RegistryEntry<CreativeModeTab> GTE_BLOCK = REGISTRATE
            .defaultCreativeTab("block", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("block", REGISTRATE))
                    .title(REGISTRATE.addLang("itemGroup", GTECore.id("block"), GTECore.NAME + " | Block"))
                    .icon(GTEBlocks.IRIDIUM_CASING::asStack)
                    .withTabsBefore(GTE_ITEM.getKey())
                    .build())
            .register();

    RegistryEntry<CreativeModeTab> GTE_MACHINE = REGISTRATE
            .defaultCreativeTab("machine", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machine", REGISTRATE))
                    .title(REGISTRATE.addLang("itemGroup", GTECore.id("machine"), GTECore.NAME + " | Machine"))
                    .icon(GTEMachines.ARC_GENERATOR[1]::asStack)
                    .withTabsBefore(GTE_BLOCK.getKey())
                    .build())
            .register();

    RegistryEntry<CreativeModeTab> GTE_MATERIAL_BLOCK = REGISTRATE
            .defaultCreativeTab("material_block", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("material_block", REGISTRATE))
                    .title(REGISTRATE.addLang("itemGroup", GTECore.id("material_block"), GTECore.NAME + " | Material Block"))
                    .icon(() -> ChemicalHelper.get(TagPrefix.block, GTEMaterials.Hypogen))
                    .withTabsBefore(GTE_MACHINE.getKey())
                    .build())
            .register();

    RegistryEntry<CreativeModeTab> GTE_MATERIAL_ITEM = REGISTRATE
            .defaultCreativeTab("material_item", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("material_item", REGISTRATE))
                    .title(REGISTRATE.addLang("itemGroup", GTECore.id("material_item"), GTECore.NAME + " | Material Item"))
                    .icon(() -> ChemicalHelper.get(TagPrefix.ingot, GTEMaterials.Hypogen))
                    .withTabsBefore(GTE_MATERIAL_BLOCK.getKey())
                    .build())
            .register();

    RegistryEntry<CreativeModeTab> GTE_MATERIAL_PIPE = REGISTRATE
            .defaultCreativeTab("material_pipe", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("material_pipe", REGISTRATE))
                    .title(REGISTRATE.addLang("itemGroup", GTECore.id("material_pipe"), GTECore.NAME + " | Material Pipe"))
                    .icon(() -> ChemicalHelper.get(Insulation.WIRE_QUADRUPLE.tagPrefix, GTEMaterials.Hypogen))
                    .withTabsBefore(GTE_MATERIAL_ITEM.getKey())
                    .build())
            .register();

    RegistryEntry<CreativeModeTab> GTE_MATERIAL_FLUID = REGISTRATE
            .defaultCreativeTab("material_fluid", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("material_fluid", REGISTRATE))
                    .title(REGISTRATE.addLang("itemGroup", GTECore.id("material_fluid"), GTECore.NAME + " | Material Fluid"))
                    .icon(() -> GTItems.FLUID_CELL_LARGE_TUNGSTEN_STEEL.asStack())
                    .withTabsBefore(GTE_MATERIAL_PIPE.getKey())
                    .build())
            .register();

    static void init() {}
}
