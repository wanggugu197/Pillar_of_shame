package org.gte.gtecore.api.playerskill.eventhandler.normal;

import net.minecraft.network.chat.Component;
import org.gte.gtecore.api.playerskill.event.SkillEvent;
import org.gte.gtecore.api.playerskill.event.normal.ExperienceAddedEvent;
import org.gte.gtecore.api.playerskill.eventhandler.SkillEventHandler;

public class ExperienceAddedSendMessageHandler extends SkillEventHandler {

    public void handleEvent(SkillEvent event) {
        if (event instanceof ExperienceAddedEvent experienceAddedEvent) {
            Component message = Component.translatable("gtecore.player_exp_status.get_experience",
                    (experienceAddedEvent.postExperience - experienceAddedEvent.preExperience),
                    event.experienceLevel.getName()).withStyle(event.experienceLevel.getNameColor());
            experienceAddedEvent.player.sendSystemMessage(message);
        }
    }
}
