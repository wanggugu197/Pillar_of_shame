package org.gte.gtecore.api.machine.feature.multiblock;

public interface IParallelMachine {

    int getMaxParallel();

    default int getParallel() {
        return getMaxParallel();
    }

    default void setParallel(int number) {}
}
