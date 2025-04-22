package org.gte.gtecore.api.item.tool;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.component.IInteractionItem;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GrassHarvesterBehaviour extends TooltipBehavior implements IInteractionItem {

    public static final GrassHarvesterBehaviour INSTANCE = new GrassHarvesterBehaviour();
    private static final Map<Block, Map<Item, Float>> HARVESTABLE_BLOCKS = Map.of(
            Blocks.GRASS, Map.of(
                    Items.WHEAT_SEEDS, 0.9F,
                    Items.BEETROOT_SEEDS, 0.1F,
                    Items.MELON_SEEDS, 0.005F,
                    Items.PUMPKIN_SEEDS, 0.005F,
                    Items.POTATO, 0.005F,
                    Items.CARROT, 0.005F));

    public GrassHarvesterBehaviour() {
        super(lines -> {
            lines.add(Component.translatable("gtecore.behaviour.grass_harvest.description"));
            lines.add(Component.translatable("gtecore.behaviour.grass_harvest.description2"));
        });
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        ItemStack itemInHand = context.getItemInHand();
        List<ItemStack> bonus = new ArrayList<>(List.of());
        if (level instanceof ServerLevel serverLevel && player != null) {
            BlockPos clickedPos = context.getClickedPos();
            Block block = serverLevel.getBlockState(clickedPos).getBlock();
            boolean isMatch = false;
            var items = HARVESTABLE_BLOCKS.get(block);
            if (items != null) {
                isMatch = true;
                items.forEach((item, chance) -> {
                    if (GTValues.RNG.nextFloat() < chance) {
                        bonus.add(new ItemStack(item, (int) Math.max(1, chance * ((GTValues.RNG.nextInt(1, 3))))));
                    }
                });
            }
            if (isMatch) {
                // 掉落物
                bonus.forEach(itemStack -> Block.popResource(level, clickedPos, itemStack));
                // 消耗耐久
                itemInHand.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(context.getHand()));
                // 破坏方块
                level.destroyBlock(clickedPos, false);
                level.playSound(null, clickedPos, SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F + (GTValues.RNG.nextFloat() * 0.4F));
            } else {
                return InteractionResult.FAIL;
            }
        }

        return InteractionResult.SUCCESS;
    }
}
