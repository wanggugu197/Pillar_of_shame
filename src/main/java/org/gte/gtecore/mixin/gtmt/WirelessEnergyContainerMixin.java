package org.gte.gtecore.mixin.gtmt;

import org.gte.gtecore.common.wireless.ExtendWirelessEnergyContainer;

import com.hepdd.gtmthings.api.misc.WirelessEnergyContainer;
import com.hepdd.gtmthings.data.WirelessEnergySavaedData;
import com.hepdd.gtmthings.utils.TeamUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.UUID;

@Mixin(WirelessEnergyContainer.class)
public final class WirelessEnergyContainerMixin {

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public static WirelessEnergyContainer getOrCreateContainer(UUID uuid) {
        return WirelessEnergySavaedData.INSTANCE.containerMap.computeIfAbsent(TeamUtil.getTeamUUID(uuid), ExtendWirelessEnergyContainer::new);
    }
}
