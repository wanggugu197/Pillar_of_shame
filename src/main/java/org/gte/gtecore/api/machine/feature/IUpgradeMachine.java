package org.gte.gtecore.api.machine.feature;

public interface IUpgradeMachine {

    default void gtecore$setSpeed(double speed) {}

    default void gtecore$setEnergy(double energy) {}

    default double gtecore$getSpeed() {
        return 1;
    }

    default double gtecore$getEnergy() {
        return 1;
    }

    default boolean gtecore$canUpgraded() {
        return true;
    }
}
