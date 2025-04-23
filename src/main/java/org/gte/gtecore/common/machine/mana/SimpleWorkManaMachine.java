package org.gte.gtecore.common.machine.mana;

import org.gte.gtecore.api.gui.OverclockConfigurator;
import org.gte.gtecore.api.machine.feature.IOverclockConfigMachine;
import org.gte.gtecore.api.machine.mana.feature.IManaEnergyMachine;
import org.gte.gtecore.api.machine.trait.IEnhancedRecipeLogic;
import org.gte.gtecore.common.data.GTERecipeModifiers;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeHandlerList;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleWorkManaMachine extends SimpleManaMachine implements IManaEnergyMachine, IOverclockConfigMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            SimpleWorkManaMachine.class, SimpleManaMachine.MANAGED_FIELD_HOLDER);

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Persisted
    private int ocLimit = 20;

    public SimpleWorkManaMachine(IMachineBlockEntity holder, int tier, Int2IntFunction tankScalingFunction, Object... args) {
        super(holder, tier, tankScalingFunction, args);
        addHandlerList(RecipeHandlerList.of(IO.IN, new ManaEnergyRecipeHandler(getTierMana(), getManaContainer())));
    }

    @Nullable
    @Override
    public GTRecipe doModifyRecipe(@NotNull GTRecipe recipe) {
        long eu = RecipeHelper.getInputEUt(recipe);
        if (eu > 0) {
            recipe = GTERecipeModifiers.externalEnergyOverclocking(this, recipe, eu, getTierMana(), true, 1, 1);
            return recipe;
        } else {
            return GTERecipeModifiers.manaOverclocking(this, recipe, getTierMana(), true, 1, 1);
        }
    }

    @Override
    public void attachConfigurators(@NotNull ConfiguratorPanel configuratorPanel) {
        super.attachConfigurators(configuratorPanel);
        configuratorPanel.attachConfigurators(new OverclockConfigurator(this));
    }

    @Override
    public void gTECore$setOCLimit(int number) {
        if (number != ocLimit) {
            if (getRecipeLogic().getLastRecipe() != null && getRecipeLogic() instanceof IEnhancedRecipeLogic recipeLogic) {
                recipeLogic.gtecore$setModifyRecipe();
            }
            ocLimit = number;
        }
    }

    @Override
    public int gTECore$getOCLimit() {
        return ocLimit;
    }
}
