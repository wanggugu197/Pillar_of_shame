package org.gte.gtecore.common.machine.steam;

import org.gte.gtecore.api.machine.feature.IVacuumMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.steam.SimpleSteamMachine;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public final class SteamVacuumPumpMachine extends SimpleSteamMachine implements IVacuumMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            SteamVacuumPumpMachine.class, SimpleSteamMachine.MANAGED_FIELD_HOLDER);

    @Override
    @NotNull
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Persisted
    private int vacuumTier;

    private TickableSubscription tickSubs;

    public SteamVacuumPumpMachine(IMachineBlockEntity holder, boolean isHighPressure, Object... args) {
        super(holder, isHighPressure, args);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            tickSubs = subscribeServerTick(tickSubs, this::tick);
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

    private void tick() {
        if (getOffsetTimer() % 20 != 0) return;
        if (isHighPressure() && getRecipeLogic().getTotalContinuousRunningTime() > 1200) {
            vacuumTier = 2;
        } else if (getRecipeLogic().getTotalContinuousRunningTime() > (isHighPressure() ? 600 : 1200)) {
            vacuumTier = 1;
        } else {
            vacuumTier = 0;
        }
    }
}
