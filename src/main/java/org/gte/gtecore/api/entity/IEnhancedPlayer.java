package org.gte.gtecore.api.entity;

import org.gte.gtecore.common.item.armor.SpaceArmorComponentItem;
import org.gte.gtecore.utils.ItemUtils;

import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public interface IEnhancedPlayer {

    boolean gTECore$canFly();

    boolean gTECore$isSpaceState();

    boolean gTECore$isWardenState();

    boolean gTECore$isDisableDrift();

    boolean gTECore$isAmprosium();

    void gtecore$setDrift(boolean drift);

    static boolean spaceTick(ServerLevel level, LivingEntity entity) {
        if (entity instanceof IEnhancedPlayer player) {
            if (player.gTECore$isSpaceState()) return false;
            var chestplate = ((Player) entity).getInventory().getArmor(2);
            if (chestplate.getItem() instanceof SpaceArmorComponentItem && SpaceArmorComponentItem.hasOxygen(entity)) {
                for (var a : entity.getArmorSlots()) {
                    if (a.getItem() instanceof ArmorComponentItem item && (ItemUtils.getIdLocation(item).getPath().contains("nanomuscle") || ItemUtils.getIdLocation(item).getPath().contains("quarktech"))) continue;
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    static float gravity(Entity entity, float gravity) {
        if (entity instanceof IEnhancedPlayer player && player.gTECore$isAmprosium()) {
            return 0;
        }
        return gravity;
    }
}
