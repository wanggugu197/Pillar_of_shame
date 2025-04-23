package org.gte.gtecore.common.machine.multiblock.part;

import org.gte.gtecore.api.machine.part.ItemHatchPartMachine;
import org.gte.gtecore.common.machine.multiblock.electric.processing.ProcessingArrayMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;

import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;

public final class MachineAccessInterfacePartMachine extends ItemHatchPartMachine {

    public MachineAccessInterfacePartMachine(IMachineBlockEntity holder) {
        super(holder, 64, null);
    }

    @Override
    public @NotNull NotifiableItemStackHandler getInventory() {
        if (!getControllers().isEmpty() && getControllers().first() instanceof ProcessingArrayMachine arrayMachine) {
            return arrayMachine.getInventory();
        }
        return inventory;
    }

    @Override
    protected boolean storageFilter(@NotNull ItemStack itemStack) {
        return false;
    }
}
