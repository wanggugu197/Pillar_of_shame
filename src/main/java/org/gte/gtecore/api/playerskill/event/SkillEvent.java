package org.gte.gtecore.api.playerskill.event;

import org.gte.gtecore.api.playerskill.experiencelevel.BasicExperienceLevel;

public abstract class SkillEvent {

    public final BasicExperienceLevel experienceLevel;

    protected SkillEvent(BasicExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
