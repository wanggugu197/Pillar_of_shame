package org.gte.gtecore.common.data;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.network.FromClientMessage;
import org.gte.gtecore.common.network.FromServerMessage;

import dev.architectury.networking.simple.MessageType;
import dev.architectury.networking.simple.SimpleNetworkManager;

public interface GTENet {

    SimpleNetworkManager NET = SimpleNetworkManager.create(GTECore.MOD_ID);

    MessageType SEND_DATA_FROM_CLIENT = NET.registerC2S("from_client", FromClientMessage::new);
    MessageType SEND_DATA_FROM_SERVER = NET.registerS2C("from_server", FromServerMessage::new);

    static void init() {}
}
