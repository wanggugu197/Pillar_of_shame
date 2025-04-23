package org.gte.gtecore.common.machine.noenergy;

import org.gte.gtecore.api.machine.SimpleNoEnergyMachine;
import org.gte.gtecore.api.machine.feature.IHeaterMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.core.Direction;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HeaterMachine extends SimpleNoEnergyMachine implements IHeaterMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            HeaterMachine.class, SimpleNoEnergyMachine.MANAGED_FIELD_HOLDER);

    @Getter
    @Setter
    @Persisted
    private int temperature = 293;

    private TickableSubscription tickSubs;

    public HeaterMachine(IMachineBlockEntity holder) {
        super(holder, 0, i -> 8000);
    }

    @Override
    public int getOutputSignal(@Nullable Direction side) {
        return getSignal(side);
    }

    @Override
    public boolean canConnectRedstone(@NotNull Direction side) {
        return true;
    }

    @Override
    public @NotNull GTRecipeType getRecipeType() {
        return GTRecipeTypes.STEAM_BOILER_RECIPES;
    }

    @Override
    public void setWorkingEnabled(boolean isWorkingAllowed) {
        if (!isWorkingAllowed && getRecipeLogic().isWorking()) getRecipeLogic().interruptRecipe();
        super.setWorkingEnabled(isWorkingAllowed);
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
    public boolean onWorking() {
        if (super.onWorking()) {
            if (getOffsetTimer() % 10 == 0) raiseTemperature(1);
            return true;
        }
        return false;
    }

    @Override
    public int getHeatCapacity() {
        return 4;
    }

    @Override
    public int getMaxTemperature() {
        return 800;
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
