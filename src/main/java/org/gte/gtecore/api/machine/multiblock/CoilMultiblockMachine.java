package org.gte.gtecore.api.machine.multiblock;

import org.gte.gtecore.api.machine.feature.multiblock.ICoilMachine;
import org.gte.gtecore.api.machine.trait.CoilTrait;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import java.util.function.Function;

public class CoilMultiblockMachine extends ElectricMultiblockMachine implements ICoilMachine {

    public static Function<IMachineBlockEntity, CoilMultiblockMachine> createCoilMachine(boolean ebf, boolean check) {
        return h -> new CoilMultiblockMachine(h, ebf, check);
    }

    private final CoilTrait coilTrait;

    protected CoilMultiblockMachine(IMachineBlockEntity holder, boolean ebf, boolean check) {
        super(holder);
        coilTrait = new CoilTrait(this, ebf, check);
    }

    @Override
    public int gte$getTemperature() {
        return coilTrait.getTemperature();
    }

    @Override
    public int getCoilTier() {
        return coilTrait.getCoilTier();
    }

    @Override
    public ICoilType getCoilType() {
        return coilTrait.getCoilType();
    }
}
