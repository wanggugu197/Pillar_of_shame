package org.gte.gtecore.client;

import com.gregtechceu.gtceu.utils.input.KeyBind;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.gte.gtecore.common.CommonProxy;

@OnlyIn(Dist.CLIENT)
public final class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
        init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(ClientProxy::clientSetup);
    }

    private static void init() {
        KeyBind.init();
    }

    @SuppressWarnings("all")
    private static void clientSetup(FMLClientSetupEvent event) {
    }
}
