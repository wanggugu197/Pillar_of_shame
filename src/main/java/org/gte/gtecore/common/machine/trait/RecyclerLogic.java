package org.gte.gtecore.common.machine.trait;

import org.gte.gtecore.api.machine.multiblock.CustomParallelMultiblockMachine;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTERecipeTypes;
import org.gte.gtecore.common.item.ItemMap;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.capability.recipe.IRecipeCapabilityHolder;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import org.jetbrains.annotations.Nullable;

public final class RecyclerLogic implements GTRecipeType.ICustomRecipeLogic {

    @Override
    public @Nullable GTRecipe createCustomRecipe(IRecipeCapabilityHolder holder) {
        if (holder instanceof CustomParallelMultiblockMachine parallelMultiblockMachine && MachineUtils.notConsumableItem(parallelMultiblockMachine, GTEItems.SCRAP_BOX.asStack())) {
            GTERecipeBuilder builder = GTERecipeBuilder.ofRaw().EUt(480);
            int parallel = MachineUtils.getItemAmount(parallelMultiblockMachine, GTEItems.SCRAP_BOX.get())[0];
            builder.duration(20 * parallel).inputItems(GTEItems.SCRAP_BOX.asStack(parallel));
            Object2IntMap<Item> map = new Object2IntOpenHashMap<>();
            for (int i = 0; i < parallel; i++) {
                ItemStack stack = ItemMap.getScrapItem();
                if (map.containsKey(stack.getItem())) {
                    map.put(stack.getItem(), map.getInt(stack.getItem()) + 1);
                } else {
                    map.put(stack.getItem(), 1);
                }
            }
            map.forEach(builder::outputItems);
            GTRecipe recipe = builder.buildRawRecipe();
            recipe.data.putBoolean("isCustom", true);
            return recipe;
        }
        return null;
    }

    @Override
    public void buildRepresentativeRecipes() {
        ItemStack stack = GTEItems.SCRAP.asStack();
        stack.setHoverName(Component.literal("Random item"));
        GTERecipeTypes.RECYCLER_RECIPES.addToMainCategory(GTERecipeTypes.RECYCLER_RECIPES
                .recipeBuilder("random")
                .inputItems(GTEItems.SCRAP_BOX.asStack())
                .outputItems(stack)
                .EUt(120)
                .duration(20)
                .buildRawRecipe());
    }
}
