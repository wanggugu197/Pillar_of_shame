package org.gte.gtecore.common.machine.multiblock.electric.space;

import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.common.saved.DysonSphereSavaedData;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import it.unimi.dsi.fastutil.ints.IntIntImmutablePair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public final class DysonSphereLaunchSiloMachine extends ElectricMultiblockMachine {

    private ResourceKey<Level> dimension;

    public DysonSphereLaunchSiloMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    private ResourceKey<Level> getDimension() {
        if (dimension == null) dimension = Objects.requireNonNull(getLevel()).dimension();
        return dimension;
    }

    @Override
    protected GTRecipe getRealRecipe(@NotNull GTRecipe recipe) {
        Integer integer = GTEDimensions.ALL_GALAXY_DIM.get(getDimension().location());
        if (integer != null) recipe.duration = recipe.duration * integer / 4;
        return recipe;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        return GTEDimensions.ALL_PLANET.containsKey(getDimension().location()) && super.beforeWorking(recipe);
    }

    @Override
    public void onRecipeFinish() {
        super.onRecipeFinish();
        IntIntImmutablePair pair = DysonSphereSavaedData.getDimensionData(getDimension());
        if (pair.leftInt() < 10000) {
            if (pair.rightInt() > 60) {
                DysonSphereSavaedData.setDysonData(getDimension(), pair.leftInt(), 0);
            } else {
                DysonSphereSavaedData.setDysonData(getDimension(), pair.leftInt() + 1, pair.rightInt());
            }
        }
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        if (DysonSphereSavaedData.getDimensionUse(getDimension())) textList.add(Component.translatable("gtceu.multiblock.large_miner.working"));
    }
}
