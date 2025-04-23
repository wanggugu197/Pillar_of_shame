package org.gte.gtecore.api.playerskill.data;

import org.gte.gtecore.api.playerskill.experiencelevel.BasicExperienceLevel;
import org.gte.gtecore.api.playerskill.experiencelevel.normal.PhysiqueExperienceLevel;
import org.gte.gtecore.api.playerskill.experiencelevel.normal.StrengthExperienceLevel;
import org.gte.gtecore.api.playerskill.experiencelevel.special.LifeIntensityExperienceLevel;
import org.gte.gtecore.api.playerskill.utils.UtilsData;

import net.minecraft.nbt.CompoundTag;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class PlayerData {

    private final UUID playerId;
    private final PhysiqueExperienceLevel physiqueExperienceLevel;
    private final StrengthExperienceLevel strengthExperienceLevel;
    private final LifeIntensityExperienceLevel lifeIntensityExperienceLevel;

    public PlayerData(UUID playerId) {
        this.playerId = playerId;
        this.lifeIntensityExperienceLevel = new LifeIntensityExperienceLevel();
        this.physiqueExperienceLevel = new PhysiqueExperienceLevel(lifeIntensityExperienceLevel);
        this.strengthExperienceLevel = new StrengthExperienceLevel(lifeIntensityExperienceLevel);
    }

    public List<BasicExperienceLevel> getExperienceLevelLists() {
        return List.of(lifeIntensityExperienceLevel, physiqueExperienceLevel, strengthExperienceLevel);
    }

    public void saveData(CompoundTag nbt) {
        UtilsData.saveExperienceToNbt(lifeIntensityExperienceLevel.skillType.getNbtKey(), lifeIntensityExperienceLevel, nbt);
        UtilsData.saveExperienceToNbt(physiqueExperienceLevel.skillType.getNbtKey(), physiqueExperienceLevel, nbt);
        UtilsData.saveExperienceToNbt(strengthExperienceLevel.skillType.getNbtKey(), strengthExperienceLevel, nbt);
    }

    public void loadData(CompoundTag nbt) {
        loadExperience(nbt, lifeIntensityExperienceLevel.skillType.getNbtKey(), lifeIntensityExperienceLevel);
        loadExperience(nbt, physiqueExperienceLevel.skillType.getNbtKey(), physiqueExperienceLevel);
        loadExperience(nbt, strengthExperienceLevel.skillType.getNbtKey(), strengthExperienceLevel);
    }

    private static void loadExperience(CompoundTag nbt, String nbtKey, BasicExperienceLevel experienceLevel) {
        if (nbt.contains(nbtKey)) {
            experienceLevel.loadData(nbt.getCompound(nbtKey));
        }
    }
}
