package org.gte.gtecore.common.machine.multiblock.electric;

import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;

import com.gregtechceu.gtceu.api.capability.GTCapabilityHelper;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.item.capability.ElectricItem;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.energy.IEnergyStorage;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public final class EnergyInjectorMachine extends ElectricMultiblockMachine {

    private ItemBusPartMachine busPartMachine;

    public EnergyInjectorMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void onPartScan(@NotNull IMultiPart part) {
        super.onPartScan(part);
        if (busPartMachine == null && part instanceof ItemBusPartMachine itemBusPartMachine) {
            IO io = itemBusPartMachine.getInventory().getHandlerIO();
            if (io == IO.IN || io == IO.BOTH) {
                busPartMachine = itemBusPartMachine;
            }
        }
    }

    @Nullable
    private GTRecipe getRecipe() {
        if (busPartMachine == null) return null;
        long eu = 0;
        Set<Integer> index = new IntOpenHashSet();
        GTERecipeBuilder builder = GTERecipeBuilder.ofRaw();
        NotifiableItemStackHandler inv = busPartMachine.getInventory();
        for (int i = 0; i < inv.getSize(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack.isEmpty()) continue;
            ItemStack output = stack.copy();
            int count = stack.getCount();
            if (GTCapabilityHelper.getElectricItem(output) instanceof ElectricItem electricItem && electricItem.getTier() <= getTier()) {
                long change = (electricItem.getMaxCharge() - electricItem.getCharge()) * count;
                if (change > 0) {
                    eu += change;
                    electricItem.setCharge(electricItem.getMaxCharge());
                    builder.outputItems(output);
                    index.add(i);
                }
            } else if (output.getDamageValue() > 0) {
                eu += (long) output.getDamageValue() << 7;
                output.setDamageValue(0);
                builder.outputItems(output);
                index.add(i);
            } else {
                IEnergyStorage energyStorage = GTCapabilityHelper.getForgeEnergyItem(output);
                if (energyStorage != null) {
                    int change = (energyStorage.getMaxEnergyStored() - energyStorage.getEnergyStored()) * count;
                    if (change > 0) {
                        eu += (long) Math.ceil((double) change / 64);
                        energyStorage.receiveEnergy(change, false);
                        builder.outputItems(output);
                        index.add(i);
                    }
                }
            }
        }
        if (eu > 0 && getOverclockVoltage() > 0) {
            GTRecipe recipe = builder.EUt(getOverclockVoltage()).duration((int) Math.ceil((double) eu / getOverclockVoltage())).buildRawRecipe();
            if (RecipeRunnerHelper.matchRecipeTickInput(this, recipe) && RecipeRunnerHelper.matchRecipeOutput(this, recipe)) {
                index.forEach(i -> inv.setStackInSlot(i, ItemStack.EMPTY));
                return recipe;
            }
        }
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }
}
