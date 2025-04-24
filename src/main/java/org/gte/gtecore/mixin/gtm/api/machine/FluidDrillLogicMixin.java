package org.gte.gtecore.mixin.gtm.api.machine;

import org.gte.gtecore.api.machine.trait.IFluidDrillLogic;
import org.gte.gtecore.common.machine.multiblock.electric.voidseries.DrillingControlCenterMachine;

import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.FluidVeinWorldEntry;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.common.machine.trait.FluidDrillLogic;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidDrillLogic.class)
public class FluidDrillLogicMixin extends RecipeLogic implements IFluidDrillLogic {

    @Unique
    private DrillingControlCenterMachine gtecore$cache;

    public FluidDrillLogicMixin(IRecipeLogicMachine machine) {
        super(machine);
    }

    @Inject(method = "getFluidToProduce(Lcom/gregtechceu/gtceu/api/data/worldgen/bedrockfluid/FluidVeinWorldEntry;)I", at = @At("RETURN"), remap = false, cancellable = true)
    private void getFluidToProduce(FluidVeinWorldEntry entry, CallbackInfoReturnable<Integer> cir) {
        DrillingControlCenterMachine machine = getNetMachine();
        if (machine != null) cir.setReturnValue((int) (cir.getReturnValue() * machine.getMultiplier()));
    }

    @Override
    @SuppressWarnings("all")
    public DrillingControlCenterMachine getNetMachineCache() {
        return gtecore$cache;
    }

    @Override
    @SuppressWarnings("all")
    public void setNetMachineCache(DrillingControlCenterMachine cache) {
        this.gtecore$cache = cache;
    }

    @Override
    public void onMachineUnLoad() {
        super.onMachineUnLoad();
        removeNetMachineCache();
    }
}
