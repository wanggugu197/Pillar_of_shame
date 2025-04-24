package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.api.gui.OverclockConfigurator;
import org.gte.gtecore.api.machine.feature.IOverclockConfigMachine;
import org.gte.gtecore.api.machine.feature.IPowerAmplifierMachine;
import org.gte.gtecore.api.machine.feature.IUpgradeMachine;
import org.gte.gtecore.api.machine.feature.multiblock.ICheckPatternMachine;
import org.gte.gtecore.api.machine.trait.IEnhancedRecipeLogic;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IControllable;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfigurator;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfiguratorButton;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.misc.EnergyContainerList;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(WorkableElectricMultiblockMachine.class)
public abstract class WorkableElectricMultiblockMachineMixin extends WorkableMultiblockMachine implements IFancyUIMachine, IOverclockConfigMachine, ICheckPatternMachine, IUpgradeMachine, IPowerAmplifierMachine {

    @Unique
    private double gtecore$powerAmplifier = 1;

    @Unique
    private boolean gtecore$hasPowerAmplifier;

    @Unique
    private double gtecore$speed = 1;

    @Unique
    private double gtecore$energy = 1;

    @Unique
    private int gTECore$ocLimit = 20;

    @Shadow(remap = false)
    protected EnergyContainerList energyContainer;

    @Shadow(remap = false)
    public abstract boolean isGenerator();

    protected WorkableElectricMultiblockMachineMixin(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public boolean gtecore$hasButton() {
        return true;
    }

    @Override
    public void gTECore$setOCLimit(int number) {
        if (number != gTECore$ocLimit) {
            if (getRecipeLogic().getLastRecipe() != null && getRecipeLogic() instanceof IEnhancedRecipeLogic enhancedRecipeLogic) {
                enhancedRecipeLogic.gtecore$setModifyRecipe();
            }
            gTECore$ocLimit = number;
        }
    }

    @Override
    public int gTECore$getOCLimit() {
        return gTECore$ocLimit;
    }

    @Override
    public void saveCustomPersistedData(@NotNull CompoundTag tag, boolean forDrop) {
        super.saveCustomPersistedData(tag, forDrop);
        if (gtecore$canUpgraded()) {
            tag.putDouble("speed", gtecore$speed);
            tag.putDouble("energy", gtecore$energy);
        }
        if (isGenerator()) return;
        tag.putInt("ocLimit", gTECore$ocLimit);
    }

    @Override
    public void loadCustomPersistedData(@NotNull CompoundTag tag) {
        super.loadCustomPersistedData(tag);
        if (gtecore$canUpgraded()) {
            double speed = tag.getDouble("speed");
            if (speed != 0) {
                gtecore$speed = speed;
            }
            double energy = tag.getDouble("energy");
            if (energy != 0) {
                gtecore$energy = energy;
            }
        }
        if (isGenerator()) return;
        gTECore$ocLimit = tag.getInt("ocLimit");
    }

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        if (self() instanceof IControllable controllable) {
            configuratorPanel.attachConfigurators(new IFancyConfiguratorButton.Toggle(
                    GuiTextures.BUTTON_POWER.getSubTexture(0, 0, 1, 0.5),
                    GuiTextures.BUTTON_POWER.getSubTexture(0, 0.5, 1, 0.5),
                    controllable::isWorkingEnabled, (clickData, pressed) -> controllable.setWorkingEnabled(pressed))
                    .setTooltipsSupplier(pressed -> List.of(Component.translatable(pressed ? "behaviour.soft_hammer.enabled" : "behaviour.soft_hammer.disabled"))));
        }
        if (!isGenerator()) {
            configuratorPanel.attachConfigurators(new OverclockConfigurator(this));
        }
        for (Direction direction : Direction.values()) {
            if (self().getCoverContainer().hasCover(direction)) {
                IFancyConfigurator configurator = self().getCoverContainer().getCoverAtSide(direction).getConfigurator();
                if (configurator != null)
                    configuratorPanel.attachConfigurators(configurator);
            }
        }
        IEnhancedRecipeLogic.attachRecipeLockable(configuratorPanel, getRecipeLogic());
        ICheckPatternMachine.attachConfigurators(configuratorPanel, self());
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public void addDisplayText(List<Component> textList) {
        MachineUtils.addMachineText(textList, this, t -> {});
        for (IMultiPart part : getParts()) {
            part.addMultiText(textList);
        }
    }

    @Inject(method = "getMaxVoltage", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/misc/EnergyContainerList;getOutputVoltage()J"), remap = false, cancellable = true)
    private void getMaxVoltage(CallbackInfoReturnable<Long> cir) {
        long voltage = energyContainer.getOutputVoltage();
        long maxVoltage;
        if (energyContainer.getOutputAmperage() == 1) {
            maxVoltage = GTValues.VEX[GTUtil.getFloorTierByVoltage(voltage)];
        } else {
            maxVoltage = voltage;
        }
        cir.setReturnValue(maxVoltage);
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
    public boolean gtecore$canUpgraded() {
        return getDefinition() == GTMultiMachines.ELECTRIC_BLAST_FURNACE;
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
}
