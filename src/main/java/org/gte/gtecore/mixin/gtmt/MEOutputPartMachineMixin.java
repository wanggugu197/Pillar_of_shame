package org.gte.gtecore.mixin.gtmt;

import org.gte.gtecore.api.machine.IMEHatchPart;
import org.gte.gtecore.api.machine.trait.InaccessibleInfiniteHandler;
import org.gte.gtecore.api.machine.trait.InaccessibleInfiniteTank;
import org.gte.gtecore.integration.ae2.KeyMap;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DualHatchPartMachine;
import com.gregtechceu.gtceu.integration.ae2.machine.feature.IGridConnectedMachine;
import com.gregtechceu.gtceu.integration.ae2.utils.KeyStorage;

import net.minecraft.core.Direction;

import appeng.api.networking.security.IActionSource;
import com.hepdd.gtmthings.common.block.machine.multiblock.part.appeng.MEOutputPartMachine;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.EnumSet;

@Mixin(MEOutputPartMachine.class)
public abstract class MEOutputPartMachineMixin extends DualHatchPartMachine implements IGridConnectedMachine, IMEHatchPart {

    @Shadow(remap = false)
    private KeyStorage internalBuffer;

    @Shadow(remap = false)
    private KeyStorage internalTankBuffer;

    @Shadow(remap = false)
    @Final
    protected IActionSource actionSource;

    protected MEOutputPartMachineMixin(IMachineBlockEntity holder, int tier, IO io, Object... args) {
        super(holder, tier, io, args);
    }

    @Override
    public IActionSource gtecore$getActionSource() {
        return actionSource;
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    protected boolean shouldSubscribe() {
        return false;
    }

    @Inject(method = "createInventory", at = @At("HEAD"), remap = false, cancellable = true)
    private void createInventory(Object[] args, CallbackInfoReturnable<NotifiableItemStackHandler> cir) {
        this.internalBuffer = new KeyMap();
        cir.setReturnValue(new InaccessibleInfiniteHandler((MEOutputPartMachine) (Object) this, (KeyMap) internalBuffer));
    }

    @Inject(method = "createTank", at = @At("HEAD"), remap = false, cancellable = true)
    private void createTank(int initialCapacity, int slots, Object[] args, CallbackInfoReturnable<NotifiableFluidTank> cir) {
        this.internalTankBuffer = new KeyMap();
        cir.setReturnValue(new InaccessibleInfiniteTank((MEOutputPartMachine) (Object) this, (KeyMap) internalTankBuffer));
    }

    @Inject(method = "onLoad", at = @At("TAIL"), remap = false)
    private void onLoad(CallbackInfo ci) {
        if (holder.self().getPersistentData().getBoolean("isAllFacing")) {
            getMainNode().setExposedOnSides(EnumSet.allOf(Direction.class));
        }
    }
}
