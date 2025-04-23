package org.gte.gtecore.common.machine.multiblock.part.ae.slots;

import appeng.api.networking.IManagedGridNode;
import appeng.api.networking.security.IActionSource;

public interface NetworkSlotMachine {

    boolean isOnline();

    IManagedGridNode getMainNode();

    IActionSource getActionSource();
}
