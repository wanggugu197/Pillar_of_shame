package org.gte.gtecore.common.machine.mana;

import org.gte.gtecore.api.machine.feature.IReceiveHeatMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AlchemyCauldron extends SimpleManaMachine implements IReceiveHeatMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            AlchemyCauldron.class, SimpleManaMachine.MANAGED_FIELD_HOLDER);

    @Getter
    @Setter
    @Persisted
    private int temperature = 293;

    private TickableSubscription tickSubs;

    public AlchemyCauldron(IMachineBlockEntity holder) {
        super(holder, 1, t -> 16000);
    }

    @Nullable
    @Override
    public GTRecipe doModifyRecipe(@NotNull GTRecipe recipe) {
        int temperature = recipe.data.getInt("temperature");
        if (temperature > 0 && temperature > this.temperature) return null;
        return super.doModifyRecipe(recipe);
    }

    @Override
    public boolean onWorking() {
        if (super.onWorking()) {
            if (getOffsetTimer() % 20 == 0) return reduceTemperature(1) == 1;
            return true;
        }
        return false;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            tickSubs = subscribeServerTick(tickSubs, this::tickUpdate);
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (tickSubs != null) {
            tickSubs.unsubscribe();
            tickSubs = null;
        }
    }

    @Override
    public int getHeatCapacity() {
        return 24;
    }

    @Override
    public int getMaxTemperature() {
        return 1600;
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
