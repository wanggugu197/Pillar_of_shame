package org.gte.gtecore.api.playerskill.experiencelevel;

import org.gte.gtecore.api.playerskill.SkillType;
import org.gte.gtecore.api.playerskill.experiencelevel.special.LifeIntensityExperienceLevel;

import net.minecraft.world.entity.player.Player;

public abstract class NormalExperienceLevel extends BasicExperienceLevel {

    protected LifeIntensityExperienceLevel lifeIntensityExperienceLevel;

    @Override
    public void freshLevel(Player player) {
        while (experience >= getExperienceForNextLevel() && level < getMaxLevel()) {
            long experienceForNextLevel = getExperienceForNextLevel();
            experience -= experienceForNextLevel;
            whenLevelAdded(level, level + 1, experienceForNextLevel, player);
            level++;
        }
    }

    @Override
    public void addExperience(long amount, Player player) {
        if (this.skillType.getLevelStepPerVoltage() == 0) {
            return;
        } // 不可升级
        whenExperienceAdded(experience, experience + amount, player);
        experience += amount;
        freshLevel(player);
    }

    protected NormalExperienceLevel(LifeIntensityExperienceLevel _lifeIntensityExperienceLevel, SkillType skillType) {
        super(skillType);
        this.lifeIntensityExperienceLevel = _lifeIntensityExperienceLevel;
    }

    public long getMaxVoltage() {
        return lifeIntensityExperienceLevel.getVoltage();
    }

    @Override
    public long getMaxLevel() {
        return (lifeIntensityExperienceLevel.getVoltage() + 1) * skillType.getLevelStepPerVoltage();
    }
}
