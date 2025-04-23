package org.gte.gtecore.common.data;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.utils.RLUtils;

import com.kyanite.deeperdarker.DeeperDarker;

import static com.gregtechceu.gtceu.common.data.GTDimensionMarkers.createAndRegister;

public interface GTEDimensionMarkers {

    static void init() {
        createAndRegister(GTEDimensions.MOON,
                1, RLUtils.ad("moon_stone"), "dimension.ad_astra.moon");
        createAndRegister(GTEDimensions.MARS,
                2, RLUtils.ad("mars_stone"), "dimension.ad_astra.mars");
        createAndRegister(GTEDimensions.VENUS,
                3, RLUtils.ad("venus_stone"), "dimension.ad_astra.venus");
        createAndRegister(GTEDimensions.MERCURY,
                3, RLUtils.ad("mercury_stone"), "dimension.ad_astra.mercury");
        createAndRegister(GTEDimensions.GLACIO,
                7, RLUtils.ad("glacio_stone"), "dimension.ad_astra.glacio");
        createAndRegister(GTEDimensions.ANCIENT_WORLD,
                0, GTECore.id("reactor_core"), "biome.gtocore.ancient_world_biome");
        createAndRegister(GTEDimensions.TITAN,
                6, GTECore.id("titan_stone"), "biome.gtocore.titan_biome");
        createAndRegister(GTEDimensions.PLUTO,
                6, GTECore.id("pluto_stone"), "biome.gtocore.pluto_biome");
        createAndRegister(GTEDimensions.IO,
                5, GTECore.id("io_stone"), "biome.gtocore.io_biome");
        createAndRegister(GTEDimensions.GANYMEDE,
                5, GTECore.id("ganymede_stone"), "biome.gtocore.ganymede_biome");
        createAndRegister(GTEDimensions.ENCELADUS,
                6, GTECore.id("enceladus_stone"), "biome.gtocore.enceladus_biome");
        createAndRegister(GTEDimensions.CERES,
                4, GTECore.id("ceres_stone"), "biome.gtocore.ceres_biome");
        createAndRegister(GTEDimensions.BARNARDA_C,
                8, GTECore.id("barnarda_c_log"), "biome.gtocore.barnarda_c_biome");
        createAndRegister(GTEDimensions.OTHERSIDE,
                9, DeeperDarker.rl("sculk_stone"), "Otherside");
        createAndRegister(GTEDimensions.CREATE,
                10, GTECore.id("dimension_creation_casing"), "biome.gtocore.create");
        createAndRegister(GTEDimensions.VOID,
                0, RLUtils.mc("obsidian"), "biome.gtocore.void");
        createAndRegister(GTEDimensions.FLAT,
                0, RLUtils.mc("crying_obsidian"), "biome.gtocore.flat");
    }
}
