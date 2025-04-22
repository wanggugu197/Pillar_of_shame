package org.gte.gtecore.api.machine.trait;

import org.gte.gtecore.api.recipe.RecipeRunnerHelper;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import java.util.function.Supplier;

public class CustomRecipeLogic extends RecipeLogic implements IEnhancedRecipeLogic {

    private final Supplier<GTRecipe> recipeSupplier;

    private final boolean tryLast;

    public CustomRecipeLogic(IRecipeLogicMachine machine, Supplier<GTRecipe> recipeSupplier) {
        this(machine, recipeSupplier, false);
    }

    public CustomRecipeLogic(IRecipeLogicMachine machine, Supplier<GTRecipe> recipeSupplier, boolean tryLast) {
        super(machine);
        this.recipeSupplier = recipeSupplier;
        this.tryLast = tryLast;
    }

    @Override
    public void findAndHandleRecipe() {
        lastRecipe = null;
        if (machine.hasCapabilityProxies()) {
            GTRecipe match = recipeSupplier.get();
            if (match != null) {
                setupRecipe(match);
            }
        }
    }

    @Override
    public void onRecipeFinish() {
        machine.afterWorking();
        if (lastRecipe != null) {
            handleRecipeIO(lastRecipe, IO.OUT);
        }
        if (suspendAfterFinish) {
            setStatus(Status.SUSPEND);
            suspendAfterFinish = false;
        } else {
            if (!recipeDirty && tryLast && RecipeRunnerHelper.check(machine, lastRecipe)) {
                setupRecipe(lastRecipe);
                return;
            } else {
                recipeDirty = false;
                GTRecipe match = recipeSupplier.get();
                if (match != null) {
                    setupRecipe(match);
                    return;
                }
            }
            setStatus(Status.IDLE);
        }
        progress = 0;
        duration = 0;
        isActive = false;
    }
}
