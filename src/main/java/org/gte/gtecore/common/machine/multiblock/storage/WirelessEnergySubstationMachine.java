package org.gte.gtecore.common.machine.multiblock.storage;

import org.gte.gtecore.api.GTEValues;
import org.gte.gtecore.api.machine.feature.IExtendWirelessEnergyContainerHolder;
import org.gte.gtecore.api.machine.feature.multiblock.ITierCasingMachine;
import org.gte.gtecore.api.machine.multiblock.NoRecipeLogicMultiblockMachine;
import org.gte.gtecore.api.machine.trait.TierCasingTrait;
import org.gte.gtecore.common.block.WirelessEnergyUnitBlock;
import org.gte.gtecore.common.wireless.ExtendWirelessEnergyContainer;
import org.gte.gtecore.utils.FunctionContainer;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IEnergyInfoProvider;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IMachineLife;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import com.hepdd.gtmthings.api.misc.WirelessEnergyContainer;
import com.hepdd.gtmthings.utils.TeamUtil;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class WirelessEnergySubstationMachine extends NoRecipeLogicMultiblockMachine implements IMachineLife, IExtendWirelessEnergyContainerHolder, ITierCasingMachine, IEnergyInfoProvider {

    @Getter
    @Setter
    private WirelessEnergyContainer WirelessEnergyContainerCache;

    private final TierCasingTrait tierCasingTrait;

    public WirelessEnergySubstationMachine(IMachineBlockEntity holder) {
        super(holder);
        tierCasingTrait = new TierCasingTrait(this, GTEValues.GLASS_TIER);
    }

    private void loadContainer() {
        if (isRemote()) return;
        Level level = getLevel();
        if (level == null) return;
        ExtendWirelessEnergyContainer container = getWirelessEnergyContainer();
        if (container == null) return;
        int tier = getCasingTier(GTEValues.GLASS_TIER);
        FunctionContainer<ArrayList<WirelessEnergyUnitBlock>, ?> functionContainer = getMultiblockState().getMatchContext().get("wirelessEnergyUnit");
        int loss = 0;
        int i = 0;
        BigInteger capacity = BigInteger.ZERO;
        if (functionContainer != null) {
            ArrayList<WirelessEnergyUnitBlock> blocks = functionContainer.getValue();
            for (WirelessEnergyUnitBlock block : blocks) {
                if (block.getTier() <= tier) {
                    i++;
                    capacity = capacity.add(block.getCapacity());
                    loss += block.getLoss();
                }
            }
            blocks.clear();
        }
        container.setLoss(i == 0 ? 0 : loss / i);
        container.setCapacity(capacity.multiply(BigInteger.valueOf(Math.max(1, i / 2))));
        container.getDimension().put(level.dimension().location(), 15);
    }

    private void unloadContainer() {
        if (isRemote()) return;
        Level level = getLevel();
        if (level == null) return;
        ExtendWirelessEnergyContainer container = getWirelessEnergyContainer();
        if (container == null) return;
        container.setCapacity(BigInteger.ZERO);
        container.setLoss(0);
        container.getDimension().put(level.dimension().location(), 0);
    }

    @Override
    public void setWorkingEnabled(boolean isWorkingAllowed) {
        if (isWorkingAllowed && isFormed()) {
            loadContainer();
        } else {
            unloadContainer();
        }
        super.setWorkingEnabled(isWorkingAllowed);
    }

    @Override
    public void onMachinePlaced(@Nullable LivingEntity player, ItemStack stack) {
        if (player != null) {
            setOwnerUUID(player.getUUID());
        }
    }

    @Override
    public void onStructureInvalid() {
        unloadContainer();
        super.onStructureInvalid();
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        loadContainer();
    }

    @Override
    public void onUnload() {
        unloadContainer();
        super.onUnload();
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        if (this.getUUID() == null) return;
        ExtendWirelessEnergyContainer container = getWirelessEnergyContainer();
        if (container == null) return;
        textList.add(Component.translatable("gtmthings.machine.wireless_energy_monitor.tooltip.0", TeamUtil.GetName(getLevel(), this.getUUID())).withStyle(ChatFormatting.AQUA));
        textList.add(Component.translatable("gtmthings.machine.wireless_energy_monitor.tooltip.1", FormattingUtil.formatNumbers(container.getStorage()) + " / " + FormattingUtil.formatNumbers(container.getCapacity())).withStyle(ChatFormatting.GRAY));
        textList.add(Component.translatable("gtmthings.machine.wireless_energy_monitor.tooltip.2", FormattingUtil.formatNumbers(container.getRate()), container.getRate() / GTValues.VEX[GTUtil.getFloorTierByVoltage(container.getRate())], Component.literal(GTValues.VNF[GTUtil.getFloorTierByVoltage(container.getRate())])).withStyle(ChatFormatting.GRAY));
        textList.add(Component.translatable("gtceu.machine.fluid_drilling_rig.depletion", (double) container.getLoss() / 10));
    }

    @Override
    public Object2IntMap<String> getCasingTiers() {
        return tierCasingTrait.getCasingTiers();
    }

    @Override
    public EnergyInfo getEnergyInfo() {
        var container = getWirelessEnergyContainer();
        if (container == null) {
            return new EnergyInfo(BigInteger.ZERO, BigInteger.ZERO);
        } else {
            return new EnergyInfo(container.getCapacity(), container.getStorage());
        }
    }

    @Override
    public boolean supportsBigIntEnergyValues() {
        return true;
    }

    @Override
    public @Nullable UUID getUUID() {
        return getOwnerUUID();
    }
}
