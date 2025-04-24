package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.common.data.GTEItems;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DataAccessHatchMachine;

import net.minecraft.world.item.Item;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(DataAccessHatchMachine.class)
public class DataAccessHatchMachineMixin extends TieredPartMachine {

    @Unique
    private static final Map<Item, Integer> gtecore$DATA = Map.of(
            GTEItems.NEURAL_MATRIX.asItem(), GTValues.UHV,
            GTEItems.ATOMIC_ARCHIVES.asItem(), GTValues.UIV,
            GTEItems.OBSIDIAN_MATRIX.asItem(), GTValues.UXV,
            GTEItems.MICROCOSM.asItem(), GTValues.OpV);

    @Shadow(remap = false)
    @Final
    public NotifiableItemStackHandler importItems;

    public DataAccessHatchMachineMixin(IMachineBlockEntity holder, int tier) {
        super(holder, tier);
    }

    @Inject(method = "<init>", at = @At("TAIL"), remap = false)
    private void init(IMachineBlockEntity holder, int tier, boolean isCreative, CallbackInfo ci) {
        importItems.setFilter(i -> gtecore$DATA.getOrDefault(i.getItem(), 0) <= tier);
    }

    @Inject(method = "getInventorySize", at = @At("TAIL"), remap = false, cancellable = true)
    private void getInventorySize(CallbackInfoReturnable<Integer> cir) {
        switch (getTier()) {
            case GTValues.UHV: {
                cir.setReturnValue(25);
                break;
            }
            case GTValues.UIV: {
                cir.setReturnValue(36);
                break;
            }
            case GTValues.OpV: {
                cir.setReturnValue(49);
                break;
            }
        }
    }
}
