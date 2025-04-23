package org.gte.gtecore.common.machine.multiblock.electric.bioengineering;

import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.common.machine.trait.RadioactivityTrait;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import org.jetbrains.annotations.NotNull;

public final class BiochemicalReactionRoomMachine extends ElectricMultiblockMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            BiochemicalReactionRoomMachine.class, ElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Persisted
    private final RadioactivityTrait radioactivityTrait;

    public BiochemicalReactionRoomMachine(IMachineBlockEntity holder) {
        super(holder);
        radioactivityTrait = new RadioactivityTrait(this);
    }
}
