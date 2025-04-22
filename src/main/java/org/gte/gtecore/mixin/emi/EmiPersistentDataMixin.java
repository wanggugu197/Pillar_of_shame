package org.gte.gtecore.mixin.emi;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.client.ClientCache;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.integration.emi.EmiPersist;

import com.google.gson.*;
import com.llamalad7.mixinextras.sugar.Local;
import dev.emi.emi.runtime.EmiPersistentData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;

@Mixin(EmiPersistentData.class)
public class EmiPersistentDataMixin {

    private static final String FAVORITES_KEY = "favorites";

    private static FileReader openFileReader(File f) throws IOException {
        if (!f.exists()) {
            Files.createFile(f.toPath());
        }

        return new FileReader(f);
    }

    @Inject(method = "save", at = @At(value = "INVOKE", target = "Ldev/emi/emi/runtime/EmiSidebars;save(Lcom/google/gson/JsonObject;)V"), remap = false, cancellable = true)
    private static void save(CallbackInfo ci, @Local JsonObject json) throws IOException {
        var persist = EmiPersistentData.GSON.fromJson(openFileReader(EmiPersistentData.FILE), EmiPersist.class);
        if (persist == null) {
            persist = new EmiPersist();
        }
        if (!GTEConfig.INSTANCE.emiGlobalFavorites) {
            if (persist.byId == null) {
                persist.byId = new HashMap<>();
            }
            GTECore.LOGGER.info(persist.byId.toString());
            final var serverId = ClientCache.SERVER_IDENTIFIER;
            if (serverId == null) {
                GTECore.LOGGER.warn("server id unavaliable now, skippping emi saving");
                return;
            }
            GTECore.LOGGER.info(serverId);
            persist.byId.put(serverId, json);
            GTECore.LOGGER.info(persist);

        } else {
            persist.favorites = json.getAsJsonArray(FAVORITES_KEY);
        }
        FileWriter writer = new FileWriter(EmiPersistentData.FILE);
        EmiPersistentData.GSON.toJson(persist, writer);
        writer.close();
        ci.cancel();
    }

    @Inject(method = "load", at = @At(value = "INVOKE", target = "Ldev/emi/emi/runtime/EmiSidebars;load(Lcom/google/gson/JsonObject;)V"), remap = false, cancellable = true)
    private static void load(CallbackInfo ci) {
        ci.cancel();
    }

    private static JsonObject defaultData() {
        final var obj = new JsonObject();
        obj.add(FAVORITES_KEY, new JsonArray());
        return obj;
    }

    @Redirect(method = "load", at = @At(value = "INVOKE", target = "Lcom/google/gson/Gson;fromJson(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;"), remap = false)
    private static Object load_persist(Gson gson, Reader reader, Class<?> cls)
                                                                               throws JsonSyntaxException, JsonIOException {
        var persist = gson.fromJson(reader, EmiPersist.class);
        if (persist == null) {
            persist = new EmiPersist();
        }
        if (!GTEConfig.INSTANCE.emiGlobalFavorites && persist.byId != null) {
            GTECore.LOGGER.info(persist.byId.toString());
            final var serverId = ClientCache.SERVER_IDENTIFIER;
            if (serverId == null) {
                GTECore.LOGGER.warn("server id unavaliable now, returning empty emi persist data");
                EmiPersist.needsRefresh = true;
                return defaultData();
            }
            GTECore.LOGGER.info(serverId);
            return persist.byId.getOrDefault(serverId, defaultData());
        }
        final var res = defaultData();
        if (persist.favorites != null) {
            res.add(FAVORITES_KEY, persist.favorites);
        }

        return res;
    }
}
