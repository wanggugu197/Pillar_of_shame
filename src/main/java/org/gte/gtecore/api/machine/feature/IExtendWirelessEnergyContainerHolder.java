package org.gte.gtecore.api.machine.feature;

import org.gte.gtecore.common.wireless.ExtendWirelessEnergyContainer;

import com.hepdd.gtmthings.api.machine.IWirelessEnergyContainerHolder;
import com.hepdd.gtmthings.api.misc.WirelessEnergyContainer;

import javax.annotation.Nullable;

public interface IExtendWirelessEnergyContainerHolder extends IWirelessEnergyContainerHolder {

    @Override
    @Nullable
    default ExtendWirelessEnergyContainer getWirelessEnergyContainer() {
        if (getUUID() != null && getWirelessEnergyContainerCache() == null) {
            WirelessEnergyContainer container = WirelessEnergyContainer.getOrCreateContainer(getUUID());
            setWirelessEnergyContainerCache(container);
        }
        return (ExtendWirelessEnergyContainer) getWirelessEnergyContainerCache();
    }
}
