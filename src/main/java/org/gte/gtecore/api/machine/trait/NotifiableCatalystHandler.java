package org.gte.gtecore.api.machine.trait;

import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.recipe.FastSizedIngredient;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.utils.ItemUtils;

import com.gregtechceu.gtceu.api.capability.IControllable;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class NotifiableCatalystHandler extends NotifiableNotConsumableItemHandler {

    private final boolean damage;

    public NotifiableCatalystHandler(MetaMachine machine, int slots, boolean damage) {
        super(machine, slots, IO.BOTH);
        this.damage = damage;
        setFilter(i -> ChemicalHelper.getPrefix(i.getItem()) == GTETagPrefix.CATALYST || i.is(GTEItems.CATALYST_BASE.get()));
    }

    @Override
    public @NotNull List<Object> getContents() {
        List stacks = new ArrayList<>();
        if (machine instanceof IControllable controllable && controllable.isWorkingEnabled()) {
            for (int i = 0; i < getSlots(); ++i) {
                ItemStack stack = getStackInSlot(i);
                if (!stack.isEmpty()) {
                    Item item = stack.getItem();
                    int damage = 10000 - stack.getDamageValue();
                    stacks.add(new ItemStack(item, damage * damage));
                }
            }
        }
        return stacks;
    }

    @Override
    public double getTotalContentAmount() {
        long amount = 0;
        if (machine instanceof IControllable controllable && controllable.isWorkingEnabled()) {
            for (int i = 0; i < getSlots(); ++i) {
                ItemStack stack = getStackInSlot(i);
                if (!stack.isEmpty()) {
                    long damage = 10000 - stack.getDamageValue();
                    amount += damage * damage;
                }
            }
        }
        return amount;
    }

    @Override
    public void importFromNearby(@NotNull Direction... facings) {}

    @Override
    @Nullable
    public List<Ingredient> handleRecipeInner(IO io, GTRecipe recipe, List<Ingredient> left, boolean simulate) {
        if (io == IO.IN && machine instanceof IControllable controllable && controllable.isWorkingEnabled()) {
            left = new ObjectArrayList<>(left);
            for (var it = left.listIterator(); it.hasNext();) {
                var ingredient = it.next();
                if (ingredient.isEmpty()) {
                    it.remove();
                    continue;
                }
                var items = ItemUtils.getInnerIngredient(ingredient).getItems();
                if (items.length == 0 || items[0].isEmpty()) {
                    it.remove();
                    continue;
                }
                int count;
                if (ingredient instanceof FastSizedIngredient si) count = si.getAmount();
                else count = items[0].getCount();
                for (int slot = 0; slot < storage.getSlots(); ++slot) {
                    ItemStack stored = storage.getStackInSlot(slot);
                    if (items[0].is(stored.getItem())) {
                        int damageValue = stored.getDamageValue();
                        if (damageValue > 9999) {
                            storage.setStackInSlot(slot, GTEItems.CATALYST_BASE.asStack());
                            continue;
                        }
                        int amount = Math.min((int) Math.ceil(Math.sqrt(count)), 10000 - damageValue);
                        if (!simulate && damage) stored.setDamageValue(damageValue + amount);
                        count = count - amount * amount;
                        if (count < 1) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return left.isEmpty() ? null : left;
    }
}
