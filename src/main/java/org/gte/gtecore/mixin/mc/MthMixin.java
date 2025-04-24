package org.gte.gtecore.mixin.mc;

import org.gte.gtecore.utils.MathUtil;

import net.minecraft.util.Mth;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = Mth.class, priority = 0)
public class MthMixin {

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public static float sin(float value) {
        return MathUtil.sin(value);
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public static float cos(float value) {
        return MathUtil.cos(value);
    }
}
