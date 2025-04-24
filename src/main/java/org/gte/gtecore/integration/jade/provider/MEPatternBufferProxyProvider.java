package org.gte.gtecore.integration.jade.provider;

import org.gte.gtecore.common.machine.multiblock.part.ae.MEPatternBufferPartMachine;
import org.gte.gtecore.common.machine.multiblock.part.ae.MEPatternBufferProxyPartMachine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.client.util.TooltipHelper;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public class MEPatternBufferProxyProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getBlockEntity() instanceof IMachineBlockEntity blockEntity) {
            if (blockEntity.getMetaMachine() instanceof MEPatternBufferProxyPartMachine) {
                CompoundTag serverData = blockAccessor.getServerData();
                if (!serverData.getBoolean("formed")) return;
                if (!serverData.getBoolean("bound")) {
                    iTooltip.add(Component.translatable("gtceu.top.buffer_not_bound").withStyle(ChatFormatting.RED));
                    return;
                }

                int[] pos = serverData.getIntArray("pos");
                iTooltip.add(Component.translatable("gtceu.top.buffer_bound_pos", pos[0], pos[1], pos[2])
                        .withStyle(TooltipHelper.RAINBOW_HSL_SLOW));

                com.gregtechceu.gtceu.integration.jade.provider.MEPatternBufferProvider.readBufferTag(iTooltip, serverData);
            }
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        if (blockAccessor.getBlockEntity() instanceof IMachineBlockEntity blockEntity) {
            if (blockEntity.getMetaMachine() instanceof MEPatternBufferProxyPartMachine proxy) {
                if (!proxy.isFormed()) {
                    compoundTag.putBoolean("formed", false);
                    return;
                }
                compoundTag.putBoolean("formed", true);
                var buffer = proxy.getBuffer();
                if (buffer == null) {
                    compoundTag.putBoolean("bound", false);
                    return;
                }
                compoundTag.putBoolean("bound", true);

                var pos = buffer.getPos();
                compoundTag.putIntArray("pos", new int[] { pos.getX(), pos.getY(), pos.getZ() });
                writeBufferTag(compoundTag, buffer);
            }
        }
    }

    private static void writeBufferTag(CompoundTag compoundTag, MEPatternBufferPartMachine buffer) {
        var merged = buffer.mergeInternalSlots();
        var items = merged.items();
        var fluids = merged.fluids();

        ListTag itemsTag = new ListTag();
        for (var entry : items.object2LongEntrySet()) {
            var ct = entry.getKey().serializeNBT();
            ct.putLong("real", entry.getLongValue());
            itemsTag.add(ct);
        }
        if (!itemsTag.isEmpty()) compoundTag.put("items", itemsTag);

        ListTag fluidsTag = new ListTag();
        for (var entry : fluids.object2LongEntrySet()) {
            var ct = entry.getKey().writeToNBT(new CompoundTag());
            ct.putLong("real", entry.getLongValue());
            fluidsTag.add(ct);
        }
        if (!fluidsTag.isEmpty()) compoundTag.put("fluids", fluidsTag);
    }

    @Override
    public ResourceLocation getUid() {
        return GTCEu.id("me_pattern_buffer_proxy");
    }
}
