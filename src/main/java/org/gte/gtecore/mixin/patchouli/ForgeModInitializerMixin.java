package org.gte.gtecore.mixin.patchouli;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import vazkii.patchouli.common.book.BookRegistry;
import vazkii.patchouli.common.handler.LecternEventHandler;
import vazkii.patchouli.forge.common.ForgeModInitializer;
import vazkii.patchouli.forge.network.ForgeNetworkHandler;

@Mixin(ForgeModInitializer.class)
public class ForgeModInitializerMixin {

    /**
     * @author .
     * @reason .
     */
    @SubscribeEvent
    @Overwrite(remap = false)
    public static void onInitialize(FMLCommonSetupEvent evt) {
        MinecraftForge.EVENT_BUS.addListener((PlayerInteractEvent.RightClickBlock e) -> {
            var result = LecternEventHandler.rightClick(e.getEntity(), e.getLevel(), e.getHand(), e.getHitVec());
            if (result.consumesAction()) {
                e.setCanceled(true);
                e.setCancellationResult(result);
            }
        });

        ForgeNetworkHandler.registerMessages();

        Thread thread = new Thread(BookRegistry.INSTANCE::init);
        thread.setDaemon(true);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }
}
