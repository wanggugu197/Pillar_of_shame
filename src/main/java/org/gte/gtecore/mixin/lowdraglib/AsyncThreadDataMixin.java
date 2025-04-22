package org.gte.gtecore.mixin.lowdraglib;

import org.gte.gtecore.config.GTEConfig;

import com.lowdragmc.lowdraglib.async.AsyncThreadData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AsyncThreadData.class)
public class AsyncThreadDataMixin {

    @ModifyArg(method = "createExecutorService", at = @At(value = "INVOKE", target = "Ljava/util/concurrent/ScheduledExecutorService;scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;"), index = 2, remap = false)
    private long modifyDelay(long delay) {
        return 50L * GTEConfig.INSTANCE.synchronousInterval;
    }
}
