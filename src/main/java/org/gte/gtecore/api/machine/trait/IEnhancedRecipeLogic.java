package org.gte.gtecore.api.machine.trait;

import org.gte.gtecore.api.recipe.AsyncRecipeOutputTask;
import org.gte.gtecore.api.recipe.AsyncRecipeSearchTask;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfiguratorButton;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.utils.ItemStackHashStrategy;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;

import java.util.List;

public interface IEnhancedRecipeLogic {

    default RecipeLogic getLogic() {
        return (RecipeLogic) this;
    }

    default Object2LongOpenCustomHashMap<ItemStack> gtecore$getParallelItemMap() {
        return new Object2LongOpenCustomHashMap<>(ItemStackHashStrategy.comparingAllButCount());
    }

    default Object2LongOpenCustomHashMap<ItemStack> gtecore$getItemIngredientStacks() {
        return new Object2LongOpenCustomHashMap<>(ItemStackHashStrategy.comparingAllButCount());
    }

    default Object2LongOpenCustomHashMap<ItemStack> gtecore$getItemMap() {
        return new Object2LongOpenCustomHashMap<>(ItemStackHashStrategy.comparingAllButCount());
    }

    default Object2IntOpenHashMap<Ingredient> gtecore$getItemNotConsumableMap() {
        return new Object2IntOpenHashMap<>();
    }

    default Object2IntOpenHashMap<Ingredient> gtecore$getItemConsumableMap() {
        return new Object2IntOpenHashMap<>();
    }

    default Object2LongOpenHashMap<FluidStack> gtecore$getParallelFluidMap() {
        return new Object2LongOpenHashMap<>();
    }

    default Object2LongOpenHashMap<FluidStack> gtecore$getFluidIngredientStacks() {
        return new Object2LongOpenHashMap<>();
    }

    default Object2LongOpenHashMap<FluidStack> gtecore$getFluidMap() {
        return new Object2LongOpenHashMap<>();
    }

    default Object2IntOpenHashMap<FluidIngredient> gtecore$getFluidNotConsumableMap() {
        return new Object2IntOpenHashMap<>();
    }

    default Object2IntOpenHashMap<FluidIngredient> gtecore$getFluidConsumableMap() {
        return new Object2IntOpenHashMap<>();
    }

    default void gtecore$cleanParallelMap() {}

    default int gtecore$getlastParallel() {
        return 1;
    }

    default void gtecore$setModifyRecipe() {}

    default boolean gtecore$hasAsyncTask() {
        return false;
    }

    default AsyncRecipeSearchTask gtecore$createAsyncRecipeSearchTask() {
        return new AsyncRecipeSearchTask(getLogic());
    }

    default AsyncRecipeSearchTask gtecore$getAsyncRecipeSearchTask() {
        return null;
    }

    default AsyncRecipeOutputTask gtecore$getAsyncRecipeOutputTask() {
        return null;
    }

    default void gtecore$setAsyncRecipeSearchTask(AsyncRecipeSearchTask task) {}

    default void gtecore$setAsyncRecipeOutputTask(AsyncRecipeOutputTask task) {}

    default boolean canLockRecipe() {
        return getLogic().getClass() == RecipeLogic.class;
    }

    default boolean gTECore$isLockRecipe() {
        return false;
    }

    default void gTECore$setLockRecipe(boolean lockRecipe) {}

    default void gTECore$setIdleReason(Component reason) {}

    default Component gTECore$getIdleReason() {
        return null;
    }

    static void attachRecipeLockable(ConfiguratorPanel configuratorPanel, RecipeLogic logic) {
        if (logic instanceof IEnhancedRecipeLogic lockableRecipe && lockableRecipe.canLockRecipe()) {
            configuratorPanel.attachConfigurators(new IFancyConfiguratorButton.Toggle(
                    GuiTextures.BUTTON_PUBLIC_PRIVATE.getSubTexture(0, 0, 1, 0.5),
                    GuiTextures.BUTTON_PUBLIC_PRIVATE.getSubTexture(0, 0.5, 1, 0.5),
                    lockableRecipe::gTECore$isLockRecipe, (clickData, pressed) -> lockableRecipe.gTECore$setLockRecipe(pressed))
                    .setTooltipsSupplier(pressed -> List.of(Component.translatable("config.gtceu.option.recipes").append("[").append(Component.translatable(pressed ? "theoneprobe.ae2.locked" : "theoneprobe.ae2.unlocked").append("]")))));
        }
    }
}
