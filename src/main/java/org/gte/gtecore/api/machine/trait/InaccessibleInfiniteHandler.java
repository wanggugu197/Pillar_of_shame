package org.gte.gtecore.api.machine.trait;

import org.gte.gtecore.api.machine.IMEHatchPart;
import org.gte.gtecore.api.recipe.FastSizedIngredient;
import org.gte.gtecore.integration.ae2.KeyMap;
import org.gte.gtecore.utils.ItemUtils;

import com.gregtechceu.gtceu.api.capability.IControllable;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.transfer.item.CustomItemStackHandler;
import com.gregtechceu.gtceu.integration.ae2.machine.feature.IGridConnectedMachine;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import appeng.api.networking.IGrid;
import appeng.api.stacks.AEItemKey;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public final class InaccessibleInfiniteHandler extends NotifiableItemStackHandler {

    private final ItemStackHandlerDelegate delegate;

    private TickableSubscription updateSubs;

    public InaccessibleInfiniteHandler(MetaMachine holder, KeyMap internalBuffer) {
        super(holder, 1, IO.OUT, IO.NONE, i -> new ItemStackHandlerDelegate(internalBuffer));
        internalBuffer.setOnContentsChanged(null);
        delegate = ((ItemStackHandlerDelegate) storage);
    }

    @Override
    public void onMachineLoad() {
        super.onMachineLoad();
        updateSubs = getMachine().subscribeServerTick(updateSubs, this::updateTick);
    }

    @Override
    public void onMachineUnLoad() {
        super.onMachineUnLoad();
        if (updateSubs != null) {
            updateSubs.unsubscribe();
            updateSubs = null;
        }
    }

    private void updateTick() {
        if (machine instanceof IControllable controllable && !controllable.isWorkingEnabled()) return;
        if (machine instanceof IGridConnectedMachine connectedMachine && connectedMachine.isOnline() && connectedMachine.shouldSyncME() && connectedMachine.updateMEStatus()) {
            IGrid grid = connectedMachine.getMainNode().getGrid();
            if (delegate.internalBuffer.getLock().tryLock()) {
                try {
                    if (grid != null && !delegate.internalBuffer.isEmpty()) {
                        delegate.internalBuffer.insertInventory(grid.getStorageService().getInventory(), ((IMEHatchPart) machine).gtecore$getActionSource());
                    }
                } finally {
                    delegate.internalBuffer.getLock().unlock();
                }
            }
        }
    }

    @Override
    public List<Ingredient> handleRecipeInner(IO io, GTRecipe recipe, List<Ingredient> left, boolean simulate) {
        if (io == IO.OUT) {
            if (simulate) return null;
            for (Object ingredient : left) {
                if (((Ingredient) ingredient).isEmpty()) continue;
                ItemStack item;
                int count;
                if (ingredient instanceof FastSizedIngredient sizedIngredient) {
                    item = ItemUtils.getFirstSized(sizedIngredient);
                    count = sizedIngredient.getAmount();
                } else {
                    item = ItemUtils.getFirst((Ingredient) ingredient);
                    count = item.getCount();
                }
                if (item.isEmpty()) continue;
                delegate.insertItem(item, count);
            }
            return null;
        }
        return left;
    }

    @Override
    public List<Ingredient> handleRecipe(IO io, GTRecipe recipe, List<?> left, boolean simulate) {
        return handleRecipeInner(io, recipe, (List<Ingredient>) left, simulate);
    }

    @Override
    public @NotNull List<Object> getContents() {
        return Collections.emptyList();
    }

    @Override
    public double getTotalContentAmount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    private static class ItemStackHandlerDelegate extends CustomItemStackHandler {

        private final KeyMap internalBuffer;

        private ItemStackHandlerDelegate(KeyMap internalBuffer) {
            super();
            this.internalBuffer = internalBuffer;
        }

        private void insertItem(ItemStack stack, int count) {
            var key = AEItemKey.of(stack);
            internalBuffer.getLock().lock();
            try {
                long oldValue = internalBuffer.storage.getOrDefault(key, 0);
                long changeValue = Math.min(Long.MAX_VALUE - oldValue, count);
                internalBuffer.storage.put(key, oldValue + changeValue);
            } finally {
                internalBuffer.getLock().unlock();
            }
        }

        @Override
        public int getSlots() {
            return Short.MAX_VALUE;
        }

        @Override
        public int getSlotLimit(int slot) {
            return Integer.MAX_VALUE;
        }

        @Override
        public @NotNull ItemStack getStackInSlot(int slot) {
            return ItemStack.EMPTY;
        }

        @Override
        public void setStackInSlot(int slot, @NotNull ItemStack stack) {}

        @Override
        public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            var key = AEItemKey.of(stack);
            int count = stack.getCount();
            internalBuffer.getLock().lock();
            try {
                long oldValue = internalBuffer.storage.getOrDefault(key, 0);
                long changeValue = Math.min(Long.MAX_VALUE - oldValue, count);
                if (changeValue > 0) {
                    if (!simulate) {
                        internalBuffer.storage.put(key, oldValue + changeValue);
                        internalBuffer.onChanged();
                    }
                    return stack.copyWithCount((int) (count - changeValue));
                } else {
                    return ItemStack.EMPTY;
                }
            } finally {
                internalBuffer.getLock().unlock();
            }
        }
    }

    @Override
    public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
        return ItemStack.EMPTY;
    }
}
