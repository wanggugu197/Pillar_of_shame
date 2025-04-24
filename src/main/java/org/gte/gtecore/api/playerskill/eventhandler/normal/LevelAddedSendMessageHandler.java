package org.gte.gtecore.api.playerskill.eventhandler.normal;

import org.gte.gtecore.api.playerskill.SkillRegistry;
import org.gte.gtecore.api.playerskill.data.ExperienceSystemManager;
import org.gte.gtecore.api.playerskill.data.PlayerData;
import org.gte.gtecore.api.playerskill.event.SkillEvent;
import org.gte.gtecore.api.playerskill.event.normal.LevelAddedEvent;
import org.gte.gtecore.api.playerskill.eventhandler.SkillEventHandler;

import net.minecraft.network.chat.Component;

import java.util.Objects;

public class LevelAddedSendMessageHandler extends SkillEventHandler {

    @Override
    public void handleEvent(SkillEvent event) {
        if (event instanceof LevelAddedEvent levelAddedEvent) {
            Component message = Component.translatable("gtecore.player_exp_status.add_level",
                    event.experienceLevel.getName(),
                    levelAddedEvent.postLevel).withStyle(event.experienceLevel.getNameColor());
            levelAddedEvent.player.sendSystemMessage(message);
            if (Objects.equals(levelAddedEvent.experienceLevel.getSkillType(), SkillRegistry.LIFE_INTENSITY)) {
                PlayerData playerData = ExperienceSystemManager.INSTANCE.getPlayerData(levelAddedEvent.player.getUUID());
                playerData.getExperienceLevelLists().forEach(experienceLevel -> { experienceLevel.freshLevel(levelAddedEvent.player); });
            }
        }
    }
}
