package org.gte.gtecore.mixin.gtm.registry;

import org.gte.gtecore.api.registries.GTERegistration;
import org.gte.gtecore.common.data.GTECreativeModeTabs;

import com.gregtechceu.gtceu.common.data.GTFluids;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GTFluids.class)
public class GTFluidsMixin {

    @Inject(method = "init", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;creativeModeTab(Ljava/util/function/Supplier;)V"), remap = false)
    private static void setFluidCreativeModeTab(CallbackInfo ci) {
        GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_MATERIAL_FLUID);
    }
}
