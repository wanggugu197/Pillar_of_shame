package org.gte.gtecore.api.machine.feature.multiblock;

import com.gregtechceu.gtceu.api.block.ICoilType;

public interface ICoilMachine {

    int gte$getTemperature();

    int getCoilTier();

    ICoilType getCoilType();
}
