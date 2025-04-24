package org.gte.gtecore.common.machine.multiblock.electric;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.item.ItemStackSet;
import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTERecipeModifiers;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FishingGroundMachine extends ElectricMultiblockMachine {

    private static final ItemStack FISHING_ROD = new ItemStack(Items.FISHING_ROD);

    private FishingHook fishingHook;

    public FishingGroundMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Nullable
    private GTRecipe getRecipe() {
        GTRecipe recipe = null;
        int mode = checkingCircuit(false);
        if (mode > 0) {
            GTERecipeBuilder builder = GTERecipeBuilder.ofRaw().duration(20).EUt(480);
            if (getLevel() instanceof ServerLevel level) {
                LootTable lootTable = level.getServer().getLootData().getLootTable(switch (mode) {
                    case 2 -> BuiltInLootTables.FISHING_FISH;
                    case 3 -> BuiltInLootTables.FISHING_JUNK;
                    case 4 -> BuiltInLootTables.FISHING_TREASURE;
                    default -> BuiltInLootTables.FISHING;
                });
                if (fishingHook == null) fishingHook = new MyFishingHook(level);
                LootParams lootContext = new LootParams.Builder(level)
                        .withOptionalParameter(LootContextParams.THIS_ENTITY, fishingHook)
                        .withParameter(LootContextParams.TOOL, FISHING_ROD)
                        .withParameter(LootContextParams.ORIGIN, new Vec3(getPos().getX(), getPos().getY(), getPos().getZ()))
                        .create(LootContextParamSets.FISHING);
                ItemStackSet itemStacks = new ItemStackSet();
                recipe = GTERecipeModifiers.accurateParallel(this, builder.copy(GTECore.id("test")).outputItems(Items.STICK).buildRawRecipe(), MachineUtils.getHatchParallel(this));
                builder.EUt(RecipeHelper.getInputEUt(recipe));
                for (int i = 0; i < recipe.parallels; i++) {
                    itemStacks.addAll(lootTable.getRandomItems(lootContext));
                }
                itemStacks.forEach(builder::outputItems);
                recipe = builder.buildRawRecipe();
            }
        } else {
            GTRecipe match = getRecipeType().getLookup().findRecipe(this);
            if (match != null) {
                recipe = fullModifyRecipe(match.copy());
            }
        }
        if (recipe != null && RecipeRunnerHelper.matchRecipe(this, recipe) && RecipeRunnerHelper.matchTickRecipe(this, recipe)) {
            return recipe;
        }
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }

    private static class MyFishingHook extends FishingHook {

        MyFishingHook(ServerLevel level) {
            super(EntityType.FISHING_BOBBER, level);
        }

        @Override
        public boolean isOpenWaterFishing() {
            return true;
        }
    }
}
