package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.api.GTEValues;
import org.gte.gtecore.api.machine.feature.IDroneInteractionMachine;
import org.gte.gtecore.api.machine.trait.IEnhancedRecipeLogic;
import org.gte.gtecore.api.misc.Drone;
import org.gte.gtecore.api.recipe.IdleReason;
import org.gte.gtecore.common.machine.multiblock.noenergy.DroneControlCenterMachine;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMaintenanceMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.machine.multiblock.part.MaintenanceHatchPartMachine;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MaintenanceHatchPartMachine.class)
public abstract class MaintenanceHatchPartMachineMixin extends TieredPartMachine implements IMaintenanceMachine, IDroneInteractionMachine {

    protected MaintenanceHatchPartMachineMixin(IMachineBlockEntity holder, int tier) {
        super(holder, tier);
    }

    @Shadow(remap = false)
    public abstract void fixAllMaintenanceProblems();

    @Unique
    private DroneControlCenterMachine gtecore$cache;

    @Unique
    @SuppressWarnings("all")
    public DroneControlCenterMachine getNetMachineCache() {
        return gtecore$cache;
    }

    @Unique
    @SuppressWarnings("all")
    public void setNetMachineCache(DroneControlCenterMachine cache) {
        gtecore$cache = cache;
    }

    @Override
    public void calculateMaintenance(IMaintenanceMachine maintenanceMachine, int duration) {
        if (maintenanceMachine.isFullAuto()) return;
        if (calculateTime((int) (duration * maintenanceMachine.getTimeMultiplier()))) {
            if (GTValues.RNG.nextFloat() - 0.5f >= 0) {
                causeRandomMaintenanceProblems();
                maintenanceMachine.setTaped(false);
            }
        }
    }

    @Override
    public GTRecipe modifyRecipe(GTRecipe recipe) {
        if (hasMaintenanceProblems()) {
            for (var c : getControllers()) {
                if (c instanceof IRecipeLogicMachine recipeLogicMachine && recipeLogicMachine.getRecipeLogic() instanceof IEnhancedRecipeLogic enhancedRecipeLogic) {
                    enhancedRecipeLogic.gTECore$setIdleReason(IdleReason.MAINTENANCE_BROKEN.reason());
                }
            }
            return null;
        }
        var durationMultiplier = getDurationMultiplier();
        if (durationMultiplier != 1) {
            recipe.duration = Math.max(1, (int) (recipe.duration * durationMultiplier));
        }
        return recipe;
    }

    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/common/machine/multiblock/part/MaintenanceHatchPartMachine;consumeDuctTape(Lnet/minecraftforge/items/IItemHandler;I)Z"), remap = false, cancellable = true)
    private void update(CallbackInfo ci) {
        DroneControlCenterMachine centerMachine = getNetMachine();
        if (centerMachine != null) {
            Drone drone = getFirstUsableDrone();
            if (drone != null && drone.start(10, getNumMaintenanceProblems() << 6, GTEValues.MAINTAINING)) {
                fixAllMaintenanceProblems();
                ci.cancel();
            }
        }
        if (hasMaintenanceProblems()) {
            for (var c : getControllers()) {
                if (c instanceof IRecipeLogicMachine machine) {
                    machine.getRecipeLogic().markLastRecipeDirty();
                }
            }
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        removeNetMachineCache();
    }
}
