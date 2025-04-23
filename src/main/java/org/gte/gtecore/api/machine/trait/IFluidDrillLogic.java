package org.gte.gtecore.api.machine.trait;

import org.gte.gtecore.api.machine.IIWirelessInteractorMachine;
import org.gte.gtecore.common.machine.multiblock.electric.voidseries.DrillingControlCenterMachine;
import org.gte.gtecore.utils.GTEUtils;

import com.gregtechceu.gtceu.api.machine.MetaMachine;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.Map;
import java.util.Set;

public interface IFluidDrillLogic extends IIWirelessInteractorMachine<DrillingControlCenterMachine> {

    MetaMachine getMachine();

    @Override
    default Level getLevel() {
        return getMachine().getLevel();
    }

    @Override
    default Map<ResourceLocation, Set<DrillingControlCenterMachine>> getMachineNet() {
        return DrillingControlCenterMachine.NETWORK;
    }

    @Override
    default boolean firstTestMachine(DrillingControlCenterMachine machine) {
        Level level = machine.getLevel();
        if (level == null) return false;
        return machine.isFormed() && machine.getRecipeLogic().isWorking() && GTEUtils.calculateDistance(machine.getPos(), getMachine().getPos()) < 16;
    }

    @Override
    default boolean testMachine(DrillingControlCenterMachine machine) {
        return machine.isFormed() && machine.getRecipeLogic().isWorking();
    }
}
