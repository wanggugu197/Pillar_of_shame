package org.gte.gtecore.common.machine.multiblock.part;

import org.gte.gtecore.api.machine.trait.WirelessEnergyContainerTrait;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IInteractedMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineLife;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.common.data.GTItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import com.hepdd.gtmthings.api.capability.IBindable;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

import static com.hepdd.gtmthings.utils.TeamUtil.GetName;

public final class WirelessEnergyHatchPartMachine extends TieredIOPartMachine implements IMachineLife, IInteractedMachine, IBindable {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            WirelessEnergyHatchPartMachine.class, TieredIOPartMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    @DescSynced
    private final WirelessEnergyContainerTrait energyContainer;

    private final int amperage;

    public WirelessEnergyHatchPartMachine(IMachineBlockEntity holder, int tier, IO io, int amperage) {
        super(holder, tier, io);
        this.amperage = amperage;
        this.energyContainer = createEnergyContainer();
    }

    private WirelessEnergyContainerTrait createEnergyContainer() {
        WirelessEnergyContainerTrait container;
        if (this.io == IO.OUT) {
            container = WirelessEnergyContainerTrait.emitterContainer(this, getHatchEnergyCapacity(tier, amperage), GTValues.V[tier], amperage);
            container.setCapabilityValidator(s -> s == null || s == this.getFrontFacing());
        } else {
            container = WirelessEnergyContainerTrait.receiverContainer(this, getHatchEnergyCapacity(tier, amperage), GTValues.V[tier], amperage);
            container.setCapabilityValidator(s -> s == null || s == this.getFrontFacing());
        }
        return container;
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        return false;
    }

    @Override
    public int tintColor(int index) {
        if (index == 2) {
            return GTValues.VC[getTier()];
        }
        return super.tintColor(index);
    }

    @Override
    public InteractionResult onUse(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getItemInHand(hand).is(GTItems.TOOL_DATA_STICK.asItem())) {
            setOwnerUUID(player.getUUID());
            if (isRemote()) {
                player.sendSystemMessage(Component.translatable("gtmthings.machine.wireless_energy_hatch.tooltip.bind", GetName(player)));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean onLeftClick(Player player, Level world, InteractionHand hand, BlockPos pos, Direction direction) {
        if (player.getItemInHand(hand).is(GTItems.TOOL_DATA_STICK.asItem())) {
            setOwnerUUID(null);
            if (isRemote()) {
                player.sendSystemMessage(Component.translatable("gtmthings.machine.wireless_energy_hatch.tooltip.unbind"));
            }
            return true;
        }
        return false;
    }

    @Override
    public void onMachinePlaced(@Nullable LivingEntity player, ItemStack stack) {
        if (player != null) {
            setOwnerUUID(player.getUUID());
        }
    }

    @Override
    public @Nullable UUID getUUID() {
        return energyContainer.getUUID();
    }

    public static long getHatchEnergyCapacity(int tier, int amperage) {
        return GTValues.V[tier] * 128L * amperage;
    }
}
