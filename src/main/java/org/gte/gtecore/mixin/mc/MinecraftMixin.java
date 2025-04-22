package org.gte.gtecore.mixin.mc;

import org.gte.gtecore.config.GTEConfig;

import net.minecraft.client.Minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Minecraft.class, priority = 0)
public class MinecraftMixin {

    @Inject(method = "createTitle", at = @At("HEAD"), cancellable = true)
    private void createTitle(CallbackInfoReturnable<String> ci) {
        if (GTEConfig.INSTANCE != null) {
            ci.setReturnValue("GregTech Engineering [" + (GTEConfig.INSTANCE.dev ? "Dev" : GTEConfig.INSTANCE.gameDifficulty) + " Mode]");
        } else {
            ci.setReturnValue("GregTech Engineering");
        }
    }
}
