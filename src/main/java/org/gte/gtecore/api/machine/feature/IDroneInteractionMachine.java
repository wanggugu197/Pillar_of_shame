package org.gte.gtecore.api.machine.feature;

import com.gregtechceu.gtceu.api.machine.feature.IMachineFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.gte.gtecore.api.machine.IIWirelessInteractorMachine;
import org.gte.gtecore.api.misc.Drone;
import org.gte.gtecore.common.machine.multiblock.noenergy.DroneControlCenterMachine;
import org.gte.gtecore.utils.GTEUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public interface IDroneInteractionMachine extends IIWirelessInteractorMachine<DroneControlCenterMachine>, IMachineFeature {

    @Override
    default Map<ResourceLocation, Set<DroneControlCenterMachine>> getMachineNet() {
        return DroneControlCenterMachine.NETWORK;
    }

    @Override
    default boolean firstTestMachine(DroneControlCenterMachine machine) {
        Level level = machine.getLevel();
        if (level == null) return false;
        return machine.isFormed() && machine.getRecipeLogic().isWorking() && GTEUtils.calculateDistance(machine.getPos(), self().getPos()) < 256;
    }

    @Override
    default boolean testMachine(DroneControlCenterMachine machine) {
        return machine.isFormed() && machine.getRecipeLogic().isWorking();
    }

    @Nullable
    default Drone getFirstUsableDrone() {
        DroneControlCenterMachine centerMachine = getNetMachine();
        if (centerMachine != null) {
            return centerMachine.getFirstUsableDrone(self().getPos());
        }
        return null;
    }
}
