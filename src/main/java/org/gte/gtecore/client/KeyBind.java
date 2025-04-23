package org.gte.gtecore.client;

import com.mojang.blaze3d.platform.InputConstants;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.minecraft.client.KeyMapping;
import org.gte.gtecore.common.network.ClientMessage;

final class KeyBind {

    private static final KeyMapping flyingspeedKey = new KeyMap("key.gtecore.flyingspeed", InputConstants.KEY_X, 0);
    private static final KeyMapping nightvisionKey = new KeyMap("key.gtecore.nightvision", InputConstants.KEY_Z, 1);
    private static final KeyMapping vajraKey = new KeyMap("key.gtecore.vajra", InputConstants.KEY_J, 2);
    private static final KeyMapping driftKey = new KeyMap("key.gtecore.drift", InputConstants.KEY_I, 3);

    public static void init() {
        KeyMappingRegistry.register(flyingspeedKey);
        KeyMappingRegistry.register(nightvisionKey);
        KeyMappingRegistry.register(vajraKey);
        KeyMappingRegistry.register(driftKey);
    }

    private static class KeyMap extends KeyMapping {

        private boolean isDownOld;
        private final int type;

        KeyMap(String name, int keyCode, int type) {
            super(name, keyCode, "key.keybinding.gtecore");
            this.type = type;
        }

        @Override
        public void setDown(boolean isDown) {
            super.setDown(isDown);
            if (isDownOld != isDown && isDown && ClientUtil.getPlayer() != null) {
                ClientMessage.sendData(String.valueOf(type), null);
            }
            isDownOld = isDown;
        }
    }
}
