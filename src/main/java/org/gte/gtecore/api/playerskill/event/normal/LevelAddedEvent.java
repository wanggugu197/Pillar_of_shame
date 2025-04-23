package org.gte.gtecore.api.playerskill.event.normal;

import net.minecraft.world.entity.player.Player;
import org.gte.gtecore.api.playerskill.event.SkillEvent;
import org.gte.gtecore.api.playerskill.experiencelevel.BasicExperienceLevel;

public class LevelAddedEvent extends SkillEvent {

    public final long preLevel;
    public final long postLevel;
    public final long consumeExperience;
    public final Player player;

    public LevelAddedEvent(BasicExperienceLevel experienceLevel, long preLevel, long postLevel, long consumeExperience, Player player) {
        super(experienceLevel);
        this.preLevel = preLevel;
        this.postLevel = postLevel;
        this.consumeExperience = consumeExperience;
        this.player = player;
    }
}
