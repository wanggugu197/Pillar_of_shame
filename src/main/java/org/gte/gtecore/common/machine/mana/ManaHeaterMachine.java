package org.gte.gtecore.common.machine.mana;

import org.gte.gtecore.api.machine.feature.IHeaterMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.data.GTERecipeTypes;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;

import net.minecraft.core.Direction;
import net.minecraftforge.fluids.FluidStack;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ManaHeaterMachine extends SimpleManaMachine implements IHeaterMachine {

    private static final FluidStack SALAMANDER = GTEMaterials.Salamander.getFluid(FluidStorageKeys.GAS, 10);

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            ManaHeaterMachine.class, SimpleManaMachine.MANAGED_FIELD_HOLDER);

    @Getter
    @Setter
    @Persisted
    private int temperature = 293;

    private TickableSubscription tickSubs;

    public ManaHeaterMachine(IMachineBlockEntity holder) {
        super(holder, 2, t -> 8000);
    }

    @Nullable
    private GTRecipe getRecipe() {
        if (temperature >= getMaxTemperature()) return null;
        GTRecipe recipe = GTERecipeBuilder.ofRaw().duration(20).MANAt(16).buildRawRecipe();
        if (RecipeRunnerHelper.matchTickRecipe(this, recipe)) {
            return recipe;
        }
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic() {
        return new CustomRecipeLogic(this, this::getRecipe);
    }

    @Override
    public @NotNull GTRecipeType getRecipeType() {
        return GTERecipeTypes.MANA_HEATER_RECIPES;
    }

    @Override
    public int getOutputSignal(@Nullable Direction side) {
        return getSignal(side);
    }

    @Override
    public boolean canConnectRedstone(@NotNull Direction side) {
        return true;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            tickSubs = subscribeServerTick(tickSubs, () -> {
                tickUpdate();
                getRecipeLogic().updateTickSubscription();
            });
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (tickSubs != null) {
            tickSubs.unsubscribe();
            tickSubs = null;
        }
    }

    @Override
    public boolean onWorking() {
        if (super.onWorking()) {
            if (getOffsetTimer() % 10 == 0 && getMaxTemperature() > temperature + 10) {
                raiseTemperature(MachineUtils.inputFluid(this, SALAMANDER) ? 10 : 2);
            }
            return true;
        }
        return false;
    }

    @Override
    public int getHeatCapacity() {
        return 8;
    }

    @Override
    public int getMaxTemperature() {
        return 2400;
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
