package org.gte.gtecore.api.playerskill.utils;

import net.minecraft.server.TickTask;
import net.minecraft.world.entity.player.Player;
import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.playerskill.SkillRegistry;
import org.gte.gtecore.api.playerskill.data.ExperienceSystemManager;
import org.gte.gtecore.api.playerskill.data.PlayerData;
import org.gte.gtecore.api.playerskill.experiencelevel.BasicExperienceLevel;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UtilsAttribute {

    public static void applyModifiers(Player player, BasicExperienceLevel expLevel) {
        removeAllGTOCoreExpModifiers(player);
        expLevel.getAttributeModifiers().forEach(attribute -> Optional.ofNullable(player.getAttribute(attribute.attribute()))
                .ifPresent(attr -> {
                    try {
                        attr.addPermanentModifier(attribute.getModifier(expLevel));
                    } catch (Exception e) {
                        System.err.println("Error applying modifier: " + e.getMessage());
                    }
                }));
    }

    public static void removeAllGTOCoreExpModifiers(Player player) {
        for (var instance : player.getAttributes().getSyncableAttributes()) {
            SkillRegistry.SKILL_UUID.forEach(instance::removeModifier);
        }
    }

    public static void freshApplyModifiers(Player player) {
        if (ExperienceSystemManager.INSTANCE == null || !ExperienceSystemManager.INSTANCE.isEnabled()) {
            return;
        }
        GTECore.LOGGER.info("Fresh apply modifiers for player: {}", player.getName().getString());
        UUID playerId = player.getUUID();
        PlayerData playerData = ExperienceSystemManager.INSTANCE.getPlayerData(playerId);
        playerData.getExperienceLevelLists().forEach(level -> UtilsAttribute.applyModifiers(player, level));
    }

    public static void freshDelayApplyModifier(Player player) {
        Objects.requireNonNull(player.level().getServer()).tell(new TickTask(1, () -> UtilsAttribute.freshApplyModifiers(player)));
    }
}
