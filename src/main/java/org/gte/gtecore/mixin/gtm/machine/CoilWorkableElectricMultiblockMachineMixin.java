package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.api.machine.feature.multiblock.ICoilMachine;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CoilWorkableElectricMultiblockMachine.class)
public abstract class CoilWorkableElectricMultiblockMachineMixin extends WorkableElectricMultiblockMachine implements ICoilMachine {

    @Override
    @Shadow(remap = false)
    public abstract ICoilType getCoilType();

    protected CoilWorkableElectricMultiblockMachineMixin(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public int gte$getTemperature() {
        return getCoilType().getCoilTemperature();
    }
}
