package org.gte.gtecore.common.network;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.misc.PlanetManagement;
import org.gte.gtecore.client.ClientCache;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.integration.emi.EmiPersist;
import org.gte.gtecore.mixin.patchouli.BookContentResourceListenerLoaderAccessor;
import org.gte.gtecore.utils.ServerUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import dev.emi.emi.runtime.EmiPersistentData;
import org.jetbrains.annotations.Nullable;
import vazkii.patchouli.client.book.BookContentResourceListenerLoader;
import vazkii.patchouli.client.book.ClientBookRegistry;

public interface ServerMessage {

    static void sendData(MinecraftServer server, @Nullable ServerPlayer player, String channel, @Nullable CompoundTag data) {
        if (player != null) {
            new FromServerMessage(channel, data).sendTo(player);
        } else {
            new FromServerMessage(channel, data).sendToAll(server);
        }
    }

    static void disableDrift(ServerPlayer serverPlayer, boolean drift) {
        CompoundTag data = new CompoundTag();
        data.putBoolean("disableDrift", drift);
        sendData(serverPlayer.server, serverPlayer, "disableDrift", data);
    }

    static void planetUnlock(ServerPlayer serverPlayer, ResourceLocation planet) {
        CompoundTag data = new CompoundTag();
        data.putString("planet", planet.toString());
        sendData(serverPlayer.server, serverPlayer, "planetUnlock", data);
    }

    static void handle(String channel, @Nullable Player player, CompoundTag data) {
        if (player == null) return;
        switch (channel) {
            case "planetUnlock": {
                ResourceLocation planet = new ResourceLocation(data.getString("planet"));
                PlanetManagement.clientUnlock(planet);
                break;
            }
            case "disableDrift": {
                ClientCache.disableDrift = data.getBoolean("disableDrift");
                break;
            }
            case "loggedIn": {
                ClientCache.UNLOCKED_PLANET.clear();
                if (Minecraft.getInstance().level != null && !ClientCache.initializedBook) {
                    ClientCache.initializedBook = true;
                    Thread thread = new Thread(() -> {
                        ClientBookRegistry.INSTANCE.reload();
                        ((BookContentResourceListenerLoaderAccessor) BookContentResourceListenerLoader.INSTANCE).getData().clear();
                    });
                    thread.setDaemon(true);
                    thread.start();
                }
                ClientCache.SERVER_IDENTIFIER = data.getUUID(ServerUtils.IDENTIFIER_KEY);
                if (!GTEConfig.INSTANCE.emiGlobalFavorites && EmiPersist.needsRefresh) {
                    // emi has loaded before we receive SERVER_IDENTIFIER, reload it.
                    EmiPersistentData.load();
                    GTECore.LOGGER.warn("emi reloaded");
                    EmiPersist.needsRefresh = false;
                }
                break;
            }
        }
    }
}
