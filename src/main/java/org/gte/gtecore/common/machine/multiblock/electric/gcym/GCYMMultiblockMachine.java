package org.gte.gtecore.common.machine.multiblock.electric.gcym;

import org.gte.gtecore.api.GTEValues;
import org.gte.gtecore.api.machine.feature.IUpgradeMachine;
import org.gte.gtecore.api.machine.multiblock.TierCasingMultiblockMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

public class GCYMMultiblockMachine extends TierCasingMultiblockMachine implements IUpgradeMachine {

    public GCYMMultiblockMachine(IMachineBlockEntity holder) {
        super(holder, GTEValues.INTEGRAL_FRAMEWORK_TIER);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        tier = Math.min(getCasingTier(GTEValues.INTEGRAL_FRAMEWORK_TIER), tier);
    }

    @Override
    @SuppressWarnings("all")
    public boolean gtecore$canUpgraded() {
        return true;
    }
}
