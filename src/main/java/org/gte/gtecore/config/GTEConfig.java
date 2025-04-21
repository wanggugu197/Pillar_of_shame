package org.gte.gtecore.config;

import com.gregtechceu.gtceu.config.ConfigHolder;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;
import org.gte.gtecore.GTECore;

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
    }

    @Configurable
    @Configurable.Comment("Optional: Simple, Normal, Expert")
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
    public boolean enableAnimalsAreAfraidToEatTheirMeat = true;
    @Configurable
    @Configurable.Range(min = 1, max = 64)
    public int enableAnimalsAreAfraidToEatTheirMeatRange = 12;

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
