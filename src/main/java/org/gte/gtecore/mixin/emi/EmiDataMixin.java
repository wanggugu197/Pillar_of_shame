package org.gte.gtecore.mixin.emi;

import dev.emi.emi.data.EmiData;
import dev.emi.emi.data.EmiResourceReloadListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.function.Consumer;

@Mixin(EmiData.class)
public final class EmiDataMixin {

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public static void init(Consumer<EmiResourceReloadListener> register) {}
}
