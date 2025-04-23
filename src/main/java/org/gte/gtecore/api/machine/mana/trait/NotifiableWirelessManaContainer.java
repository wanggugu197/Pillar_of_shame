package org.gte.gtecore.api.machine.mana.trait;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import lombok.Getter;
import lombok.Setter;
import org.gte.gtecore.api.machine.mana.feature.IWirelessManaContainerHolder;
import org.gte.gtecore.common.wireless.WirelessManaContainer;

import javax.annotation.Nullable;
import java.math.BigInteger;
import java.util.UUID;

@Setter
@Getter
public final class NotifiableWirelessManaContainer extends NotifiableManaContainer implements IWirelessManaContainerHolder {

    private WirelessManaContainer WirelessManaContainerCache;

    public NotifiableWirelessManaContainer(MetaMachine machine, IO io, long maxMana) {
        super(machine, io, maxMana);
    }

    @Override
    protected void updateTick() {
        if (!getMachine().isRemote() && getMachine().getOffsetTimer() % 10 == 0) {
            WirelessManaContainer container = getWirelessManaContainer();
            if (container != null) {
                long stored = getCurrentMana();
                if (getHandlerIO() == IO.IN) {
                    long canInput = Math.min(getMaxMana() - stored, container.getStorage().longValue());
                    if (canInput > 0) {
                        container.setStorage(container.getStorage().subtract(BigInteger.valueOf(canInput)));
                        setCurrentMana(stored + canInput);
                    }
                } else {
                    if (stored > 0) {
                        container.setStorage(container.getStorage().add(BigInteger.valueOf(stored)));
                        setCurrentMana(0);
                    }
                }
            }
        }
    }

    @Override
    public @Nullable UUID getUUID() {
        return getMachine().getOwnerUUID();
    }

    @Override
    public boolean acceptDistributor() {
        return false;
    }
}
