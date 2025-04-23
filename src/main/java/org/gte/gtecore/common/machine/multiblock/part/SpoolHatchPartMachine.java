package org.gte.gtecore.common.machine.multiblock.part;

import org.gte.gtecore.api.machine.part.ItemHatchPartMachine;
import org.gte.gtecore.common.data.GTEItems;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IInteractedMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import com.google.common.collect.ImmutableMap;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import java.util.List;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class SpoolHatchPartMachine extends ItemHatchPartMachine implements IInteractedMachine {

    public static final Map<Item, Integer> SPOOL;

    static {
        ImmutableMap.Builder<Item, Integer> spoolBuilder = ImmutableMap.builder();
        spoolBuilder.put(GTEItems.SPOOLS_MICRO.get(), 1);
        spoolBuilder.put(GTEItems.SPOOLS_SMALL.get(), 2);
        spoolBuilder.put(GTEItems.SPOOLS_MEDIUM.get(), 3);
        spoolBuilder.put(GTEItems.SPOOLS_LARGE.get(), 4);
        spoolBuilder.put(GTEItems.SPOOLS_JUMBO.get(), 5);
        SPOOL = spoolBuilder.build();
    }

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            SpoolHatchPartMachine.class, ItemHatchPartMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    private boolean isWorking;

    public SpoolHatchPartMachine(IMachineBlockEntity holder) {
        super(holder, 64, i -> SPOOL.containsKey(i.getItem()));
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public boolean beforeWorking(IWorkableMultiController controller) {
        isWorking = true;
        return super.beforeWorking(controller);
    }

    @Override
    public boolean afterWorking(IWorkableMultiController controller) {
        isWorking = false;
        return super.afterWorking(controller);
    }

    @Override
    public void onDrops(List<ItemStack> list) {
        if (isWorking) {
            super.onDrops(list);
        }
    }
}
