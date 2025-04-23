package org.gte.gtecore.api.playerskill.event.normal;

import net.minecraft.world.entity.player.Player;
import org.gte.gtecore.api.playerskill.event.SkillEvent;
import org.gte.gtecore.api.playerskill.experiencelevel.BasicExperienceLevel;

public class ExperienceAddedEvent extends SkillEvent {

    public final long preExperience;
    public final long postExperience;
    public final Player player;

    public ExperienceAddedEvent(BasicExperienceLevel experienceLevel, long preExperience, long postExperience, Player player) {
        super(experienceLevel);
        this.preExperience = preExperience;
        this.postExperience = postExperience;
        this.player = player;
    }
}
