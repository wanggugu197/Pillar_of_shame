package org.gte.gtecore.common.machine.multiblock.part.ae;

import org.gte.gtecore.api.machine.trait.NotifiableCatalystHandler;
import org.gte.gtecore.api.machine.trait.NotifiableNotConsumableItemHandler;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import org.jetbrains.annotations.NotNull;

public final class MECatalystPatternBufferPartMachine extends MEPatternBufferPartMachine {

    public MECatalystPatternBufferPartMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    @NotNull
    NotifiableNotConsumableItemHandler createShareInventory() {
        return new NotifiableCatalystHandler(this, 16, false);
    }
}
