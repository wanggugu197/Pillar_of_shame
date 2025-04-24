package org.gte.gtecore.mixin.eio;

import org.gte.gtecore.config.GTEConfig;

import net.minecraftforge.fluids.capability.IFluidHandler;

import com.enderio.api.conduit.ticker.CapabilityAwareConduitTicker;
import com.enderio.conduits.common.conduit.type.fluid.FluidConduitData;
import com.enderio.conduits.common.conduit.type.fluid.FluidConduitTicker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidConduitTicker.class)
public class FluidConduitTickerMixin {

    @Inject(method = "getScaledFluidRate", at = @At("RETURN"), remap = false, cancellable = true)
    private void getScaledFluidRate(CapabilityAwareConduitTicker<FluidConduitData, IFluidHandler>.CapabilityConnection extractingConnection, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(cir.getReturnValueI() * GTEConfig.INSTANCE.eioFluidRate);
    }
}
