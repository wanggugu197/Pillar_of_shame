package org.gte.gtecore.api.blockentity;

import org.gte.gtecore.api.machine.mana.feature.IManaMachine;

import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vazkii.botania.api.BotaniaForgeCapabilities;

public final class ManaMachineBlockEntity extends MetaMachineBlockEntity {

    private ManaMachineBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public static ManaMachineBlockEntity createBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        return new ManaMachineBlockEntity(type, pos, blockState);
    }

    @Override
    @NotNull
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == BotaniaForgeCapabilities.MANA_RECEIVER) {
            return BotaniaForgeCapabilities.MANA_RECEIVER.orEmpty(cap, LazyOptional.of(() -> ((IManaMachine) getMetaMachine())));
        } else if (cap == BotaniaForgeCapabilities.SPARK_ATTACHABLE) {
            return BotaniaForgeCapabilities.SPARK_ATTACHABLE.orEmpty(cap, LazyOptional.of(() -> ((IManaMachine) getMetaMachine())));
        }
        return super.getCapability(cap, side);
    }
}
