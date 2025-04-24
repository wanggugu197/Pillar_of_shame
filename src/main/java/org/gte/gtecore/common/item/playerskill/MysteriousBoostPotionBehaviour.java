package org.gte.gtecore.common.item.playerskill;

import com.gregtechceu.gtceu.api.item.component.IInteractionItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.gte.gtecore.common.data.GTEEffects;
import org.gte.gtecore.utils.StringUtils;

public class MysteriousBoostPotionBehaviour implements IInteractionItem {

    private final int tier;

    public MysteriousBoostPotionBehaviour(int tier) {
        this.tier = tier;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Item item, Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide()) {
            ItemStack itemInHand = player.getItemInHand(usedHand);
            player.addEffect(new MobEffectInstance(GTEEffects.MYSTERIOUS_BOOST.get(), 20 * 60 * (5 + tier), tier));
            itemInHand.shrink(1);
            player.sendSystemMessage(Component.literal(StringUtils.full_color(Component.translatable("gtocore.player_exp_status.mysterious_boost_potion.success").getString())));
        }
        return IInteractionItem.super.use(item, level, player, usedHand);
    }
}
