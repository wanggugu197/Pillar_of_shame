package org.gte.gtecore.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IMachineLife;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.BlockItem;

import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.jei.IngredientIO;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;

import javax.annotation.ParametersAreNonnullByDefault;

@Getter
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class BlockBusPartMachine extends TieredIOPartMachine implements IMachineLife {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            BlockBusPartMachine.class, TieredIOPartMachine.MANAGED_FIELD_HOLDER);
    @Persisted
    private final NotifiableItemStackHandler inventory;

    public BlockBusPartMachine(IMachineBlockEntity holder) {
        super(holder, 6, IO.BOTH);
        inventory = createInventoryItemHandler();
    }

    private NotifiableItemStackHandler createInventoryItemHandler() {
        NotifiableItemStackHandler storage = new NotifiableItemStackHandler(this, 81, IO.NONE, IO.BOTH);
        storage.setFilter(i -> i.getItem() instanceof BlockItem);
        return storage;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void onMachineRemoved() {
        clearInventory(inventory.storage);
    }

    @Override
    public Widget createUIWidget() {
        int rowSize = 9;
        var group = new WidgetGroup(0, 0, 18 * rowSize + 16, 18 * rowSize + 16);
        var container = new WidgetGroup(4, 4, 18 * rowSize + 8, 18 * rowSize + 8);
        int index = 0;
        for (int y = 0; y < rowSize; y++) {
            for (int x = 0; x < rowSize; x++) {
                container.addWidget(
                        new SlotWidget(inventory.storage, index, 4 + x * 18, 4 + y * 18, true, io.support(IO.IN))
                                .setBackgroundTexture(GuiTextures.SLOT)
                                .setIngredientIO(io == IO.IN ? IngredientIO.INPUT : IngredientIO.OUTPUT));
                index++;
            }
        }

        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);

        return group;
    }

    @Override
    public boolean canShared() {
        return false;
    }
}
