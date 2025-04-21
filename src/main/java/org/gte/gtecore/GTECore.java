package org.gte.gtecore;

import org.gte.gtecore.client.ClientProxy;
import org.gte.gtecore.common.CommonProxy;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GTECore.MOD_ID)
public class GTECore {

    public static final String MOD_ID = "gtecore";
    public static final String NAME = "GTE Core";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public GTECore() {
        DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    }
}
