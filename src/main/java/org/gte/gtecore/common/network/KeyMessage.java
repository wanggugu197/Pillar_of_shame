package org.gte.gtecore.common.network;

import org.gte.gtecore.api.entity.IEnhancedPlayer;

import com.gregtechceu.gtceu.api.item.IGTTool;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

interface KeyMessage {

    static void pressAction(ServerPlayer player, String type) {
        Level level = player.level();
        if (!level.hasChunkAt(player.blockPosition())) {
            return;
        }
        switch (type) {
            case "0":
                handleFlightSpeed(player);
                break;
            case "1":
                toggleNightVision(player);
                break;
            case "2":
                upgradeToolSpeed(player);
                break;
            case "3":
                drift(player);
                break;
        }
    }

    private static void handleFlightSpeed(Player player) {
        float speed;
        String armorSlots = player.getArmorSlots().toString();
        if (armorSlots.contains("warden_")) {
            speed = 0.2F;
        } else if (armorSlots.contains("infinity_")) {
            speed = 0.3F;
        } else {
            return;
        }
        CompoundTag data = player.getPersistentData();
        int speedFactor = data.getInt("fly_speed");
        if (player.isShiftKeyDown()) {
            player.getAbilities().setFlyingSpeed(0.05F);
            player.onUpdateAbilities();
            player.displayClientMessage(Component.translatable("gtecore.fly_speed_reset"), true);
            data.putInt("fly_speed", 1);
        } else {
            float currentSpeed = player.getAbilities().getFlyingSpeed();
            if (currentSpeed < speed) {
                player.getAbilities().setFlyingSpeed(0.05F * speedFactor);
                player.onUpdateAbilities();
                data.putInt("fly_speed", speedFactor + 1);
                player.displayClientMessage(Component.translatable("gtecore.fly_speed", (speedFactor + 1)), true);
            } else {
                player.displayClientMessage(Component.translatable("gtecore.reach_limit"), true);
            }
        }
    }

    private static void toggleNightVision(Player player) {
        if (((IEnhancedPlayer) player).gTECore$canFly()) {
            CompoundTag data = player.getPersistentData();
            boolean nightVisionEnabled = data.getBoolean("night_vision");
            data.putBoolean("night_vision", !nightVisionEnabled);

            if (nightVisionEnabled) {
                player.removeEffect(MobEffects.NIGHT_VISION);
                player.displayClientMessage(Component.translatable("metaarmor.message.nightvision.disabled"), true);
            } else {
                player.displayClientMessage(Component.translatable("metaarmor.message.nightvision.enabled"), true);
            }
        }
    }

    private static void upgradeToolSpeed(Player player) {
        ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (itemStack.getItem() instanceof IGTTool gtTool && gtTool.getToolType().name.contains("_vajra")) {
            int value = player.isShiftKeyDown() ? 10 : 1;
            float speed = itemStack.getOrCreateTag().getCompound("GT.Tool").getFloat("ToolSpeed");
            float newSpeed = adjustToolSpeed(speed, value, (int) gtTool.getMaterialToolSpeed(itemStack));
            itemStack.getOrCreateTag().getCompound("GT.Tool").putFloat("ToolSpeed", newSpeed);
            player.displayClientMessage(Component.translatable("jade.horseStat.speed", newSpeed), true);
        }
    }

    private static float adjustToolSpeed(float speed, int value, int max) {
        if (speed < max) {
            if (speed < 100) {
                return speed + value;
            } else {
                return speed + value * 10;
            }
        } else {
            return 10;
        }
    }

    private static void drift(ServerPlayer player) {
        if (player instanceof IEnhancedPlayer enhancedPlayer) {
            boolean disableDrift = !enhancedPlayer.gTECore$isDisableDrift();
            enhancedPlayer.gtecore$setDrift(disableDrift);
            if (disableDrift) {
                player.displayClientMessage(Component.translatable("key.gtecore.drift").append(": ").append(Component.translatable("gtecore.machine.off")), true);
            } else {
                player.displayClientMessage(Component.translatable("key.gtecore.drift").append(": ").append(Component.translatable("gtecore.machine.on")), true);
            }
        }
    }
}
