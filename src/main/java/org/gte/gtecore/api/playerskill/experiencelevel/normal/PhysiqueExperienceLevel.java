package org.gte.gtecore.api.playerskill.experiencelevel.normal;

import org.gte.gtecore.api.playerskill.SkillRegistry;
import org.gte.gtecore.api.playerskill.experiencelevel.NormalExperienceLevel;
import org.gte.gtecore.api.playerskill.experiencelevel.special.LifeIntensityExperienceLevel;

public class PhysiqueExperienceLevel extends NormalExperienceLevel {

    public PhysiqueExperienceLevel(LifeIntensityExperienceLevel _lifeIntensityExperienceLevel) {
        super(_lifeIntensityExperienceLevel, SkillRegistry.PHYSIQUE);
    }
}
