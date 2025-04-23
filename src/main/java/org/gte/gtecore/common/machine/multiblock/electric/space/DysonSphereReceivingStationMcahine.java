package org.gte.gtecore.common.machine.multiblock.electric.space;

import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEFluids;
import org.gte.gtecore.common.saved.DysonSphereSavaedData;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;

import it.unimi.dsi.fastutil.ints.IntIntImmutablePair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public final class DysonSphereReceivingStationMcahine extends ElectricMultiblockMachine {

    private ResourceKey<Level> dimension;

    public DysonSphereReceivingStationMcahine(IMachineBlockEntity holder) {
        super(holder);
    }

    private ResourceKey<Level> getDimension() {
        if (dimension == null) dimension = Objects.requireNonNull(getLevel()).dimension();
        return dimension;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        DysonSphereSavaedData.setDysonUse(getDimension(), true);
        return super.beforeWorking(recipe);
    }

    @Override
    public void afterWorking() {
        super.afterWorking();
        DysonSphereSavaedData.setDysonUse(getDimension(), false);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        DysonSphereSavaedData.setDysonUse(getDimension(), false);
    }

    @Nullable
    private GTRecipe getRecipe() {
        if (DysonSphereSavaedData.getDimensionUse(getDimension())) return null;
        IntIntImmutablePair pair = DysonSphereSavaedData.getDimensionData(getDimension());
        if (pair.leftInt() < 1) return null;
        if (GTValues.RNG.nextFloat() < 0.01F * (1 + (double) pair.leftInt() / 128)) {
            if (pair.rightInt() > 99) {
                int count = pair.leftInt() - 1;
                if (count < 1) {
                    DysonSphereSavaedData.setDysonData(getDimension(), 0, 0);
                    return null;
                }
                DysonSphereSavaedData.setDysonData(getDimension(), count, 0);
            } else {
                DysonSphereSavaedData.setDysonData(getDimension(), pair.leftInt(), pair.rightInt() + 1);
            }
        }
        Integer integer = GTEDimensions.ALL_GALAXY_DIM.get(getDimension().location());
        if (integer == null) return null;
        GTRecipe recipe = GTERecipeBuilder.ofRaw().duration(20)
                .CWUt(Math.max(1, pair.leftInt() * integer / 2))
                .EUt(-GTValues.V[GTValues.MAX] * pair.leftInt() * (50 - Math.max(0, pair.rightInt() - 60)) / 50)
                .inputFluids(new FluidStack(GTEFluids.GELID_CRYOTHEUM.get(), Math.max(1, (int) Math.sqrt(pair.leftInt()))))
                .buildRawRecipe();
        if (RecipeRunnerHelper.matchRecipe(this, recipe) && RecipeRunnerHelper.matchTickRecipe(this, recipe)) return recipe;
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        IntIntImmutablePair pair = DysonSphereSavaedData.getDimensionData(getDimension());
        textList.add(Component.translatable("gtecore.machine.dyson_sphere.number", pair.leftInt()));
        textList.add(Component.translatable("gtecore.machine.dyson_sphere.voltage", (pair.leftInt() > 0 ? getOverclockVoltage() : 0)));
        textList.add(Component.translatable("gtecore.machine.fission_reactor.damaged", pair.rightInt()).append("%"));
    }
}
