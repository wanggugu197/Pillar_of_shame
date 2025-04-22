package org.gte.gtecore.api.machine.feature;

import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;

public interface IPowerAmplifierMachine extends IRecipeLogicMachine {

    double gtecore$getPowerAmplifier();

    void gtecore$setPowerAmplifier(double powerAmplifier);

    boolean gtecore$noPowerAmplifier();

    void gtecore$setHasPowerAmplifier(boolean hasPowerAmplifier);
}
