package org.gte.gtecore.common.machine.multiblock.electric;

import org.gte.gtecore.api.machine.multiblock.StorageMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.machine.multiblock.part.BlockBusPartMachine;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.transfer.item.CustomItemStackHandler;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BlockConversionRoomMachine extends StorageMultiblockMachine {

    private static final List<int[]> poses1 = new ArrayList<>();
    private static final List<int[]> poses2 = new ArrayList<>();
    public static final Map<Block, Block> COV_RECIPE;

    static {
        for (int i = -2; i <= 2; i++) {
            for (int j = -1; j >= -5; j--) {
                for (int k = -2; k <= 2; k++) {
                    poses1.add(new int[] { i, j, k });
                }
            }
        }
        for (int i = -4; i <= 4; i++) {
            for (int j = -1; j >= -7; j--) {
                for (int k = -4; k <= 4; k++) {
                    poses2.add(new int[] { i, j, k });
                }
            }
        }
        ImmutableMap.Builder<Block, Block> covRecipe = ImmutableMap.builder();
        covRecipe.put(Blocks.BONE_BLOCK, GTEBlocks.ESSENCE_BLOCK.get());
        covRecipe.put(Blocks.OAK_LOG, Blocks.CRIMSON_STEM);
        covRecipe.put(Blocks.BIRCH_LOG, Blocks.WARPED_STEM);
        covRecipe.put(ChemicalHelper.getBlock(TagPrefix.block, GTMaterials.Calcium), Blocks.BONE_BLOCK);
        covRecipe.put(Blocks.MOSS_BLOCK, Blocks.SCULK);
        covRecipe.put(Blocks.GRASS_BLOCK, Blocks.MOSS_BLOCK);
        covRecipe.put(GTEBlocks.INFUSED_OBSIDIAN.get(), GTEBlocks.DRACONIUM_BLOCK_CHARGED.get());
        // covRecipe.put(ModBlocks.ORGANIC_COMPOST.get(), ModBlocks.RICH_SOIL.get());
        COV_RECIPE = covRecipe.build();
    }

    private final int am;
    private final List<int[]> poses;

    private BlockBusPartMachine blockBusPartMachine;

    public BlockConversionRoomMachine(IMachineBlockEntity holder, boolean isLarge) {
        super(holder, 1, i -> i.getItem() == GTEItems.CONVERSION_SIMULATE_CARD.get());
        am = isLarge ? 64 : 4;
        poses = isLarge ? poses2 : poses1;
    }

    @Override
    public void onPartScan(@NotNull IMultiPart part) {
        super.onPartScan(part);
        if (part instanceof BlockBusPartMachine busPartMachine) {
            blockBusPartMachine = busPartMachine;
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        blockBusPartMachine = null;
    }

    @Override
    public boolean onWorking() {
        if (!super.onWorking()) return false;
        if (getOffsetTimer() % 20 == 0) {
            int amount = getTier() * am - 7;
            if (blockBusPartMachine != null && getStorageStack().getItem() == GTEItems.CONVERSION_SIMULATE_CARD.get()) {
                CustomItemStackHandler stackTransfer = blockBusPartMachine.getInventory().storage;
                int a = amount;
                for (int i = 0; a > 0 && i < stackTransfer.getSlots(); i++) {
                    ItemStack itemStack = stackTransfer.getStackInSlot(i);
                    if (itemStack.getItem() instanceof BlockItem blockItem && COV_RECIPE.containsKey(blockItem.getBlock())) {
                        int count = itemStack.getCount();
                        a -= count;
                        stackTransfer.setStackInSlot(i, new ItemStack(COV_RECIPE.get(blockItem.getBlock()).asItem(), count));
                    }
                }
            } else {
                Level level = getLevel();
                if (level != null) {
                    int[] pos = {};
                    for (int i = 0; i < amount; i++) {
                        int[] pos_0 = poses.get((int) (Math.random() * poses.size()));
                        if (pos_0 != pos) {
                            pos = pos_0;
                            BlockPos blockPos = getPos().offset(pos[0], pos[1], pos[2]);
                            Block block = level.getBlockState(blockPos).getBlock();
                            if (COV_RECIPE.containsKey(block)) {
                                level.setBlockAndUpdate(blockPos, COV_RECIPE.get(block).defaultBlockState());
                            }
                        } else {
                            i--;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        textList.add(Component.translatable("gtecore.machine.block_conversion_room.am", (getTier() * am - 7)));
    }

    @Nullable
    private GTRecipe getRecipe() {
        GTRecipe recipe = GTERecipeBuilder.ofRaw().duration(400).EUt(getOverclockVoltage()).buildRawRecipe();
        if (RecipeRunnerHelper.matchRecipeTickInput(this, recipe)) return recipe;
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe, true);
    }
}
