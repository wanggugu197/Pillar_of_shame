package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.api.machine.feature.IPowerAmplifierMachine;
import org.gte.gtecore.api.machine.feature.IUpgradeMachine;
import org.gte.gtecore.api.machine.trait.IEnhancedRecipeLogic;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyTooltip;
import com.gregtechceu.gtceu.api.gui.fancy.TooltipsPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.WorkableTieredMachine;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;

import net.minecraft.nbt.CompoundTag;

import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SimpleTieredMachine.class)
public class SimpleTieredMachineMixin extends WorkableTieredMachine implements IUpgradeMachine, IPowerAmplifierMachine, IFancyUIMachine {

    @Unique
    private double gtecore$speed = 1;

    @Unique
    private double gtecore$energy = 1;

    @Unique
    private double gtecore$powerAmplifier = 1;

    @Unique
    private boolean gtecore$hasPowerAmplifier;

    public SimpleTieredMachineMixin(IMachineBlockEntity holder, int tier, Int2IntFunction tankScalingFunction, Object... args) {
        super(holder, tier, tankScalingFunction, args);
    }

    @Override
    public boolean alwaysTryModifyRecipe() {
        return false;
    }

    @Inject(method = "attachConfigurators", at = @At(value = "TAIL"), remap = false)
    private void attachConfigurators(ConfiguratorPanel configuratorPanel, CallbackInfo ci) {
        IEnhancedRecipeLogic.attachRecipeLockable(configuratorPanel, getRecipeLogic());
    }

    @Override
    public void saveCustomPersistedData(@NotNull CompoundTag tag, boolean forDrop) {
        super.saveCustomPersistedData(tag, forDrop);
        tag.putDouble("speed", gtecore$speed);
        tag.putDouble("energy", gtecore$energy);
    }

    @Override
    public void loadCustomPersistedData(@NotNull CompoundTag tag) {
        super.loadCustomPersistedData(tag);
        double speed = tag.getDouble("speed");
        if (speed != 0) {
            gtecore$speed = speed;
        }
        double energy = tag.getDouble("energy");
        if (energy != 0) {
            gtecore$energy = energy;
        }
    }

    @Override
    public void gtecore$setSpeed(double speed) {
        this.gtecore$speed = speed;
        getRecipeLogic().markLastRecipeDirty();
    }

    @Override
    public void gtecore$setEnergy(double energy) {
        this.gtecore$energy = energy;
        getRecipeLogic().markLastRecipeDirty();
    }

    @Override
    public double gtecore$getSpeed() {
        return gtecore$speed;
    }

    @Override
    public double gtecore$getEnergy() {
        return gtecore$energy;
    }

    @Override
    public double gtecore$getPowerAmplifier() {
        return gtecore$powerAmplifier;
    }

    @Override
    public void gtecore$setPowerAmplifier(double powerAmplifier) {
        this.gtecore$powerAmplifier = powerAmplifier;
    }

    @Override
    public boolean gtecore$noPowerAmplifier() {
        return !gtecore$hasPowerAmplifier;
    }

    @Override
    public void gtecore$setHasPowerAmplifier(boolean hasPowerAmplifier) {
        this.gtecore$hasPowerAmplifier = hasPowerAmplifier;
    }

    @Override
    public void attachTooltips(TooltipsPanel tooltipsPanel) {
        tooltipsPanel.attachTooltips(this);
        getTraits().stream().filter(IFancyTooltip.class::isInstance).map(IFancyTooltip.class::cast).forEach(tooltipsPanel::attachTooltips);
        if (getRecipeLogic() instanceof IEnhancedRecipeLogic enhancedRecipeLogic) {
            tooltipsPanel.attachTooltips(new IFancyTooltip.Basic(() -> GuiTextures.INDICATOR_NO_STEAM.get(true), () -> List.of(enhancedRecipeLogic.gTECore$getIdleReason()), () -> getRecipeLogic().isIdle() && enhancedRecipeLogic.gTECore$getIdleReason() != null, () -> null));
        }
    }
}
