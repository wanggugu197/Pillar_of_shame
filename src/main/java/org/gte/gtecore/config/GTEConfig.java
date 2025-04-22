package org.gte.gtecore.config;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.config.ConfigHolder;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = GTECore.MOD_ID)
public class GTEConfig {

    public static GTEConfig INSTANCE;

    private static int difficulty = 0;

    public static int getDifficulty() {
        if (difficulty == 0) {
            difficulty = switch (GTEConfig.INSTANCE.gameDifficulty) {
                case "Simple" -> 1;
                case "Normal" -> 2;
                case "Expert" -> 3;
                default -> throw new IllegalStateException("Unexpected value: " + GTEConfig.INSTANCE.gameDifficulty);
            };
        }
        return difficulty;
    }

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = Configuration.registerConfig(GTEConfig.class, ConfigFormats.yaml()).getConfigInstance();
        }
        ConfigHolder.init();

        int difficulty = getDifficulty();

        int boilerFactor = 8 >> difficulty;

        ConfigHolder.INSTANCE.gameplay.hazardsEnabled = false;
        ConfigHolder.INSTANCE.gameplay.universalHazards = false;
        ConfigHolder.INSTANCE.gameplay.environmentalHazards = false;
        ConfigHolder.INSTANCE.gameplay.environmentalHazardDecayRate = 0.001f;

        ConfigHolder.INSTANCE.dev.debug = GTEConfig.INSTANCE.dev;
    }

    @Configurable
    @Configurable.Comment("是否关闭飞行惯性")
    public boolean disableDrift = true;
    @Configurable
    @Configurable.Comment("旅行权杖最小CD")
    @Configurable.Range(min = 1)
    public int travelStaffCD = 2;
    @Configurable
    @Configurable.Comment("难度: Simple, Normal, Expert")
    public String gameDifficulty = "Normal";
    @Configurable
    @Configurable.Comment("Prevent cheating")
    public boolean selfRestraint;
    @Configurable
    @Configurable.Comment("Enabled, no mining required")
    public boolean enablePrimitiveVoidOre;
    @Configurable
    @Configurable.Comment("Remove unnecessary loading")
    public boolean fastMultiBlockPage = true;
    @Configurable
    @Configurable.Comment("GT BlockEntity synchronization of client and server data")
    @Configurable.Range(min = 1, max = 40)
    public int synchronousInterval = 10;
    @Configurable
    @Configurable.Comment("The interval increases gradually when the machine cannot find a recipe; this is the maximum interval.")
    @Configurable.Range(min = 1, max = 200)
    public int recipeMaxCheckInterval = 40;
    @Configurable
    @Configurable.Comment("After enabling, the recipe search runs in an independent thread and will not affect the TPS.")
    public boolean asyncRecipeSearch = true;
    @Configurable
    @Configurable.Comment("After enabling, the recipe output runs in an independent thread and will not affect the TPS.")
    public boolean asyncRecipeOutput = true;
    @Configurable
    @Configurable.Comment("Ore product multiplier")
    @Configurable.Range(min = 1, max = 64)
    public int oreMultiplier = 4;
    @Configurable
    @Configurable.Range(min = 1, max = 1024)
    public int eioFluidRate = 16;
    @Configurable
    public String[] breakBlocksBlackList = { "ae2:cable_bus" };

    @Configurable
    @Configurable.Comment("Check for conflicts between recipes")
    public boolean recipeCheck;
    @Configurable
    @Configurable.Comment("Dev Mode")
    public boolean dev;

    @Configurable
    @Configurable.Comment("When disabled, the emi favorites in different saves will be independent from each other")
    public boolean emiGlobalFavorites = true;
}
