package org.gte.gtecore.api.machine.feature.multiblock;

import it.unimi.dsi.fastutil.objects.Object2IntMap;

public interface ITierCasingMachine {

    Object2IntMap<String> getCasingTiers();

    default int getCasingTier(String type) {
        return getCasingTiers().getInt(type);
    }
}
