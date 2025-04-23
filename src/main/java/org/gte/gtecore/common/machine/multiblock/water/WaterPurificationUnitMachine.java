package org.gte.gtecore.common.machine.multiblock.water;

import org.gte.gtecore.api.machine.IIWirelessInteractorMachine;
import org.gte.gtecore.api.machine.multiblock.NoEnergyCustomParallelMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.utils.GTEUtils;

import com.gregtechceu.gtceu.api.machine.ConditionalSubscriptionHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

@MethodsReturnNonnullByDefault
abstract class WaterPurificationUnitMachine extends NoEnergyCustomParallelMultiblockMachine implements IIWirelessInteractorMachine<WaterPurificationPlantMachine> {

    static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            WaterPurificationUnitMachine.class, NoEnergyCustomParallelMultiblockMachine.MANAGED_FIELD_HOLDER);

    abstract long before();

    @Getter
    @Setter
    private WaterPurificationPlantMachine netMachineCache;

    GTRecipe recipe;

    @Persisted
    long eut;

    private final ConditionalSubscriptionHandler tickSubs;

    WaterPurificationUnitMachine(IMachineBlockEntity holder) {
        super(holder, false, m -> Integer.MAX_VALUE);
        tickSubs = new ConditionalSubscriptionHandler(this, this::tickUpdate, this::isFormed);
    }

    private void tickUpdate() {
        if (getOffsetTimer() % 80 == 0) {
            getNetMachine();
            tickSubs.updateSubscription();
        }
    }

    void setWorking(boolean isWorkingAllowed) {
        super.setWorkingEnabled(isWorkingAllowed);
    }

    @Override
    public Map<ResourceLocation, Set<WaterPurificationPlantMachine>> getMachineNet() {
        return WaterPurificationPlantMachine.NETWORK;
    }

    @Override
    public boolean firstTestMachine(WaterPurificationPlantMachine machine) {
        Level level = machine.getLevel();
        if (level != null && machine.isFormed() && GTEUtils.calculateDistance(machine.getPos(), getPos()) < 32) {
            machine.waterPurificationUnitMachineMap.put(this, getRecipeLogic().isWorking());
            return true;
        }
        return false;
    }

    @Override
    public boolean testMachine(WaterPurificationPlantMachine machine) {
        return machine.isFormed();
    }

    @Override
    public void removeNetMachineCache() {
        if (netMachineCache != null) {
            netMachineCache.waterPurificationUnitMachineMap.remove(this);
            setNetMachineCache(null);
        }
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        if (!isRemote()) {
            getNetMachine();
            tickSubs.initialize(getLevel());
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        removeNetMachineCache();
    }

    @Override
    public void onUnload() {
        super.onUnload();
        removeNetMachineCache();
    }

    @Override
    public SoundEntry getSound() {
        return GTSoundEntries.COOLING;
    }

    @Override
    public void setWorkingEnabled(boolean isWorkingAllowed) {}

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, () -> null);
    }
}
