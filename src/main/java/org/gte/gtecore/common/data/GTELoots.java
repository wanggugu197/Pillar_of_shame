package org.gte.gtecore.common.data;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTMaterialBlocks;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.core.mixins.BlockBehaviourAccessor;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.mojang.datafixers.util.Pair;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.shadowsoffire.placebo.loot.LootSystem;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

import java.util.Map;
import java.util.Set;

public final class GTELoots {

    private GTELoots() {}

    public static Set<Object> BLOCKS = new ObjectOpenHashSet<>();

    public static boolean cache;

    public static ImmutableMap<LootDataId<?>, ?> ELEMENTS_CACHE;

    public static ImmutableMultimap<LootDataType<?>, ResourceLocation> TYPEKEYS_CACHE;

    public static void removal(Set<ResourceLocation> filters) {
        filters.add(new ResourceLocation("expatternprovider", "blocks/ex_emc_interface"));
        filters.add(new ResourceLocation("farmersrespite", "blocks/kettle"));
    }

    public static Pair<ImmutableMap<LootDataId<?>, ?>, ImmutableMultimap<LootDataType<?>, ResourceLocation>> apply(Map<LootDataType<?>, Map<ResourceLocation, ?>> collectedElements) {
        Map<ResourceLocation, LootTable> lootTables = (Map<ResourceLocation, LootTable>) collectedElements.get(LootDataType.TABLE);
        generateGTDynamicLoot(lootTables);
        ImmutableMap.Builder<LootDataId<?>, Object> builder = ImmutableMap.builder();
        ImmutableMultimap.Builder<LootDataType<?>, ResourceLocation> builder1 = ImmutableMultimap.builder();
        collectedElements.forEach((p_279449_, p_279262_) -> p_279262_.forEach((p_279130_, p_279313_) -> {
            builder.put(new LootDataId<>(p_279449_, p_279130_), p_279313_);
            builder1.put(p_279449_, p_279130_);
        }));
        LootSystem.PLACEBO_TABLES.forEach((key, val) -> {
            builder.put(key, val);
            builder1.put(LootDataType.TABLE, key.location());
        });
        LootSystem.PLACEBO_TABLES.clear();
        builder.put(LootDataManager.EMPTY_LOOT_TABLE_KEY, LootTable.EMPTY);
        return Pair.of(builder.build(), builder1.build());
    }

    private static final VanillaBlockLoot BLOCK_LOOT = new VanillaBlockLoot();

    private static void generateGTDynamicLoot(Map<ResourceLocation, LootTable> lootTables) {
        GTMaterialBlocks.MATERIAL_BLOCKS.rowMap().forEach((prefix, map) -> {
            if (TagPrefix.ORES.containsKey(prefix)) {
                final TagPrefix.OreType type = TagPrefix.ORES.get(prefix);
                map.forEach((material, blockEntry) -> {
                    ResourceLocation lootTableId = new ResourceLocation(blockEntry.getId().getNamespace(),
                            "blocks/" + blockEntry.getId().getPath());
                    Block block = blockEntry.get();

                    if (!type.shouldDropAsItem() && !ConfigHolder.INSTANCE.worldgen.allUniqueStoneTypes) {
                        TagPrefix orePrefix = type.isDoubleDrops() ? TagPrefix.oreNetherrack : TagPrefix.ore;
                        block = ChemicalHelper.getBlock(orePrefix, material);
                    }

                    ItemStack dropItem = ChemicalHelper.get(TagPrefix.rawOre, material);
                    if (dropItem.isEmpty()) dropItem = ChemicalHelper.get(TagPrefix.gem, material);
                    if (dropItem.isEmpty()) dropItem = ChemicalHelper.get(TagPrefix.dust, material);
                    int oreMultiplier = type.isDoubleDrops() ? 2 : 1;

                    LootTable.Builder builder = BlockLootSubProvider.createSilkTouchDispatchTable(block,
                            BLOCK_LOOT.applyExplosionDecay(block,
                                    LootItem.lootTableItem(dropItem.getItem())
                                            .apply(SetItemCountFunction
                                                    .setCount(ConstantValue.exactly(oreMultiplier)))
                                            .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));

                    LootPool.Builder pool = LootPool.lootPool();
                    boolean isEmpty = true;
                    for (MaterialStack secondaryMaterial : prefix.secondaryMaterials()) {
                        if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                            ItemStack dustStack = ChemicalHelper.getGem(secondaryMaterial);
                            pool.add(LootItem.lootTableItem(dustStack.getItem())
                                    .when(BlockLootSubProvider.HAS_NO_SILK_TOUCH)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                    .apply(LimitCount.limitCount(IntRange.range(0, 2)))
                                    .apply(ApplyExplosionDecay.explosionDecay()));
                            isEmpty = false;
                        }
                    }
                    if (!isEmpty) {
                        builder.withPool(pool);
                    }
                    lootTables.put(lootTableId, builder.setParamSet(LootContextParamSets.BLOCK).build());
                    ((BlockBehaviourAccessor) blockEntry.get()).setDrops(lootTableId);
                });
            } else {
                addMaterialBlockLootTables(lootTables, map);
            }
        });
        GTMaterialBlocks.CABLE_BLOCKS.rowMap().forEach((prefix, map) -> addMaterialBlockLootTables(lootTables, map));
        GTMaterialBlocks.FLUID_PIPE_BLOCKS.rowMap().forEach((prefix, map) -> addMaterialBlockLootTables(lootTables, map));
        GTMaterialBlocks.ITEM_PIPE_BLOCKS.rowMap().forEach((prefix, map) -> addMaterialBlockLootTables(lootTables, map));
        GTMaterialBlocks.SURFACE_ROCK_BLOCKS.forEach((material, blockEntry) -> {
            ResourceLocation lootTableId = new ResourceLocation(blockEntry.getId().getNamespace(),
                    "blocks/" + blockEntry.getId().getPath());
            LootTable.Builder builder = BLOCK_LOOT
                    .createSingleItemTable(ChemicalHelper.get(TagPrefix.dustTiny, material).getItem(),
                            UniformGenerator.between(3, 5))
                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE));
            lootTables.put(lootTableId, builder.setParamSet(LootContextParamSets.BLOCK).build());
            ((BlockBehaviourAccessor) blockEntry.get()).setDrops(lootTableId);
        });
        GTRegistries.MACHINES.forEach(machine -> {
            Block block = machine.getBlock();
            ResourceLocation id = machine.getId();
            ResourceLocation lootTableId = new ResourceLocation(id.getNamespace(), "blocks/" + id.getPath());
            ((BlockBehaviourAccessor) block).setDrops(lootTableId);
            lootTables.put(lootTableId,
                    BLOCK_LOOT.createSingleItemTable(block).setParamSet(LootContextParamSets.BLOCK).build());
        });
    }

    private static void addMaterialBlockLootTables(Map<ResourceLocation, LootTable> lootTables, Map<Material, ? extends BlockEntry<? extends Block>> map) {
        map.forEach((material, blockEntry) -> {
            ResourceLocation lootTableId = new ResourceLocation(blockEntry.getId().getNamespace(), "blocks/" + blockEntry.getId().getPath());
            ((BlockBehaviourAccessor) blockEntry.get()).setDrops(lootTableId);
            lootTables.put(lootTableId, BLOCK_LOOT.createSingleItemTable(blockEntry.get()).setParamSet(LootContextParamSets.BLOCK).build());
        });
    }
}
