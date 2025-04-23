package org.gte.gtecore.api.machine.mana.feature;

import org.gte.gtecore.common.wireless.WirelessManaContainer;

import com.hepdd.gtmthings.api.capability.IBindable;

import javax.annotation.Nullable;

public interface IWirelessManaContainerHolder extends IBindable {

    void setWirelessManaContainerCache(WirelessManaContainer var1);

    WirelessManaContainer getWirelessManaContainerCache();

    @Nullable
    default WirelessManaContainer getWirelessManaContainer() {
        if (this.getUUID() != null && this.getWirelessManaContainerCache() == null) {
            WirelessManaContainer container = WirelessManaContainer.getOrCreateContainer(this.getUUID());
            this.setWirelessManaContainerCache(container);
        }

        return this.getWirelessManaContainerCache();
    }
}
