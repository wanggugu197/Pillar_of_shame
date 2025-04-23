package org.gte.gtecore.common.machine.multiblock.noenergy;

import org.gte.gtecore.api.machine.multiblock.NoEnergyMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEItems;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class AlgaeFarmMachine extends NoEnergyMultiblockMachine {

    private static final Fluid FERMENTEDBIOMASS = GTMaterials.FermentedBiomass.getFluid();

    private static final List<Item> ALGAES = List.of(
            GTEItems.BLUE_ALGAE.get(),
            GTEItems.BROWN_ALGAE.get(),
            GTEItems.GOLD_ALGAE.get(),
            GTEItems.GREEN_ALGAE.get(),
            GTEItems.RED_ALGAE.get());

    public AlgaeFarmMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    private GTRecipe getRecipe(ItemStack stack) {
        GTERecipeBuilder builder = GTERecipeBuilder.ofRaw().inputFluids(new FluidStack(Fluids.WATER, 100 * GTValues.RNG.nextInt(50) + 5000)).duration(200);
        builder.outputItems(stack);
        GTRecipe recipe = builder.buildRawRecipe();
        if (RecipeRunnerHelper.matchRecipe(this, recipe)) {
            return recipe;
        }
        return null;
    }

    @Nullable
    private GTRecipe getRecipe() {
        boolean raise = inputFluid(FERMENTEDBIOMASS, 10000);
        int amount = raise ? 10 : 1;
        amount = amount + GTValues.RNG.nextInt(9 * amount);
        AtomicReference<GTRecipe> recipe = new AtomicReference<>();
        int finalAmount = amount;
        forEachInputItems(stack -> {
            if (ALGAES.contains(stack.getItem())) {
                recipe.set(getRecipe(stack.copyWithCount(finalAmount * Math.max(1, stack.getCount() / 4))));
                return true;
            }
            return false;
        });
        if (recipe.get() == null) {
            recipe.set(getRecipe(new ItemStack(ALGAES.get(GTValues.RNG.nextInt(5)), amount)));
        }
        return recipe.get();
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }
}
