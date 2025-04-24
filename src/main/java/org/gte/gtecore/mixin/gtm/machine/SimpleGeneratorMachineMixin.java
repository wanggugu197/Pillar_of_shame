package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.common.machine.multiblock.generator.GeneratorArrayMachine;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.SimpleGeneratorMachine;
import com.gregtechceu.gtceu.api.machine.WorkableTieredMachine;

import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SimpleGeneratorMachine.class)
public class SimpleGeneratorMachineMixin extends WorkableTieredMachine {

    public SimpleGeneratorMachineMixin(IMachineBlockEntity holder, int tier, Int2IntFunction tankScalingFunction, Object... args) {
        super(holder, tier, tankScalingFunction, args);
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    protected long getMaxInputOutputAmperage() {
        return GeneratorArrayMachine.getAmperage(getTier());
    }

    @Override
    public long getOverclockVoltage() {
        return GTValues.V[getTier()] * getMaxInputOutputAmperage();
    }
}
