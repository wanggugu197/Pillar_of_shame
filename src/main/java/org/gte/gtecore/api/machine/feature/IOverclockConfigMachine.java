package org.gte.gtecore.api.machine.feature;

public interface IOverclockConfigMachine {

    default int gTECore$getOCLimit() {
        return 20;
    }

    default void gTECore$setOCLimit(int number) {}
}
