package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.api.machine.feature.IPerformanceDisplayMachine;
import org.gte.gtecore.common.machine.noenergy.PerformanceMonitorMachine;

import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.integration.ae2.machine.feature.IGridConnectedMachine;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import com.mojang.datafixers.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.EnumSet;
import java.util.Set;

@Mixin(MetaMachine.class)
public abstract class MetaMachineMixin implements IPerformanceDisplayMachine {

    @Unique
    private long gTECore$lastExecutionTime;

    @Unique
    private int gTECore$averageTickTime;

    @Unique
    private long gTECore$totaTtickCount;

    @Unique
    private boolean gtecore$observe;

    @Shadow(remap = false)
    public abstract boolean isRemote();

    @Shadow(remap = false)
    @Final
    public IMachineBlockEntity holder;

    @Shadow(remap = false)
    protected abstract void executeTick();

    @Shadow(remap = false)
    public abstract @Nullable Level getLevel();

    @Shadow(remap = false)
    public abstract BlockPos getPos();

    @Shadow(remap = false)
    public abstract BlockState getBlockState();

    @Shadow(remap = false)
    public abstract long getOffsetTimer();

    @Override
    public int gtecore$getTickTime() {
        return gTECore$averageTickTime;
    }

    @Override
    public void gtecore$observe() {
        gtecore$observe = true;
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public final void serverTick() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - gTECore$lastExecutionTime < 40) {
            return;
        }
        gTECore$lastExecutionTime = currentTime;
        boolean observe = PerformanceMonitorMachine.observe || gtecore$observe;
        if (observe) currentTime = System.nanoTime();
        executeTick();
        if (observe) {
            gTECore$totaTtickCount += System.nanoTime() - currentTime;
            if (getOffsetTimer() % 40 == 0) {
                gtecore$observe = false;
                gTECore$averageTickTime = (int) (gTECore$totaTtickCount / 40000);
                gTECore$totaTtickCount = 0;
            }
            if (PerformanceMonitorMachine.observe) PerformanceMonitorMachine.PERFORMANCE_MAP.put((MetaMachine) (Object) this, gTECore$averageTickTime);
        }
    }

    @Inject(method = "onToolClick", at = @At("RETURN"), remap = false, cancellable = true)
    private void onToolClick(Set<@NotNull GTToolType> toolType, ItemStack itemStack, UseOnContext context, CallbackInfoReturnable<Pair<GTToolType, InteractionResult>> cir) {
        if (cir.getReturnValue().getSecond() == InteractionResult.PASS && toolType.contains(GTToolType.WIRE_CUTTER)) {
            Player player = context.getPlayer();
            if (player == null) return;
            if (holder.getMetaMachine() instanceof IGridConnectedMachine gridConnectedMachine) {
                cir.setReturnValue(Pair.of(GTToolType.WIRE_CUTTER, gteCore$onWireCutterClick(player, context.getHand(), gridConnectedMachine)));
            }
        }
    }

    @Inject(method = "shouldRenderGrid", at = @At("HEAD"), remap = false, cancellable = true)
    private void shouldRenderGrid(Player player, BlockPos pos, BlockState state, ItemStack held, Set<GTToolType> toolTypes, CallbackInfoReturnable<Boolean> cir) {
        if (toolTypes.contains(GTToolType.WIRE_CUTTER)) {
            MetaMachine metaMachine = holder.getMetaMachine();
            if (metaMachine instanceof IGridConnectedMachine) cir.setReturnValue(true);
        }
    }

    @Unique
    private InteractionResult gteCore$onWireCutterClick(Player playerIn, InteractionHand hand, IGridConnectedMachine machine) {
        playerIn.swing(hand);
        if (holder.self().getPersistentData().getBoolean("isAllFacing")) {
            machine.getMainNode().setExposedOnSides(EnumSet.of(((MetaMachine) machine).getFrontFacing()));
            if (isRemote()) {
                playerIn.displayClientMessage(Component.translatable("gtecore.me_front"), true);
            }
            holder.self().getPersistentData().putBoolean("isAllFacing", false);
        } else {
            machine.getMainNode().setExposedOnSides(EnumSet.allOf(Direction.class));
            if (isRemote()) {
                playerIn.displayClientMessage(Component.translatable("gtecore.me_any"), true);
            }
            holder.self().getPersistentData().putBoolean("isAllFacing", true);
        }
        return InteractionResult.CONSUME;
    }
}
