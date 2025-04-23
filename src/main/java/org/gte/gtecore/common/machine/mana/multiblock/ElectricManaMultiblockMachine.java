package org.gte.gtecore.common.machine.mana.multiblock;

import org.gte.gtecore.api.capability.ManaContainerList;
import org.gte.gtecore.api.machine.mana.feature.IManaMultiblock;
import org.gte.gtecore.api.machine.mana.trait.ManaTrait;
import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import org.jetbrains.annotations.NotNull;

public class ElectricManaMultiblockMachine extends ElectricMultiblockMachine implements IManaMultiblock {

    private final ManaTrait manaTrait;

    public ElectricManaMultiblockMachine(IMachineBlockEntity holder) {
        super(holder);
        this.manaTrait = new ManaTrait(this);
    }

    @Override
    public boolean regressWhenWaiting() {
        return false;
    }

    @Override
    public @NotNull ManaContainerList getManaContainer() {
        return manaTrait.getManaContainers();
    }

    @Override
    public boolean isGeneratorMana() {
        return true;
    }
}
