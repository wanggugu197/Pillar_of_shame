package org.gte.gtecore.common.machine.multiblock.electric;

import org.gte.gtecore.api.machine.multiblock.CustomParallelMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTERecipeModifiers;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.item.IntCircuitBehaviour;

import net.minecraft.world.item.Item;

import com.periut.chisel.block.ChiselGroupLookup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ChiselMachine extends CustomParallelMultiblockMachine {

    public ChiselMachine(IMachineBlockEntity holder) {
        super(holder, false, m -> 1 << (2 * (m.getTier() - 1)));
    }

    @Nullable
    private GTRecipe getRecipe() {
        AtomicInteger c = new AtomicInteger();
        AtomicReference<Item> item = new AtomicReference<>();
        forEachInputItems(itemStack -> {
            if (itemStack.is(GTItems.PROGRAMMED_CIRCUIT.get())) {
                c.addAndGet(IntCircuitBehaviour.getCircuitConfiguration(itemStack));
            } else {
                item.set(itemStack.getItem());
            }
            return false;
        });
        if (c.get() > 0 && item.get() != null) {
            List<Item> list = ChiselGroupLookup.getBlocksInGroup(item.get());
            if (list.isEmpty()) return null;
            Item output = list.get(c.get() - 1);
            if (output == null) return null;
            GTERecipeBuilder builder = GTERecipeBuilder.ofRaw().duration(20).EUt(30);
            builder.inputItems(item.get());
            builder.outputItems(output);
            GTRecipe recipe = builder.buildRawRecipe();
            recipe = GTERecipeModifiers.accurateParallel(this, recipe, getParallel());
            if (recipe != null && RecipeRunnerHelper.matchRecipe(this, recipe) && RecipeRunnerHelper.matchTickRecipe(this, recipe)) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }
}
