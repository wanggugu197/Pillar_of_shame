package org.gte.gtecore.common.machine.mana.multiblock;

import org.gte.gtecore.api.capability.ManaContainerList;
import org.gte.gtecore.api.machine.mana.feature.IManaMultiblock;
import org.gte.gtecore.api.machine.mana.trait.ManaTrait;
import org.gte.gtecore.api.machine.multiblock.NoEnergyMultiblockMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import org.jetbrains.annotations.NotNull;

public class ManaMultiblockMachine extends NoEnergyMultiblockMachine implements IManaMultiblock {

    private final ManaTrait manaTrait;

    public ManaMultiblockMachine(IMachineBlockEntity holder) {
        super(holder);
        this.manaTrait = new ManaTrait(this);
    }

    @Override
    public @NotNull ManaContainerList getManaContainer() {
        return manaTrait.getManaContainers();
    }

    @Override
    public boolean isGeneratorMana() {
        return false;
    }
}
