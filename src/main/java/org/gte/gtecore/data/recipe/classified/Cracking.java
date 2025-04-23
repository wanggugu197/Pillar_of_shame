package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.CRACKING_RECIPES;

interface Cracking {

    static void init() {
        CRACKING_RECIPES.recipeBuilder(GTECore.id("radon_cracked_enriched_aquadah"))
                .circuitMeta(1)
                .inputFluids(GTMaterials.EnrichedNaquadahSolution.getFluid(1000))
                .inputFluids(GTMaterials.Radon.getFluid(1000))
                .outputFluids(GTEMaterials.RadonCrackedEnrichedAquadah.getFluid(1000))
                .EUt(1966080)
                .duration(160)
                .save();

        CRACKING_RECIPES.recipeBuilder(GTECore.id("steam_cracked_turpentine"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.LeachedTurpentine.getFluid(1000))
                .inputFluids(GTMaterials.Steam.getFluid(1000))
                .outputFluids(GTEMaterials.SteamCrackedTurpentine.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save();

        CRACKING_RECIPES.recipeBuilder(GTECore.id("crackedradox"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.SuperLightRadox.getFluid(100))
                .inputFluids(GTMaterials.Silver.getFluid(FluidStorageKeys.PLASMA, 10))
                .outputFluids(GTEMaterials.CrackedRadox.getFluid(100))
                .EUt(491520)
                .duration(300)
                .save();

        CRACKING_RECIPES.recipeBuilder(GTECore.id("lightradox"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.HeavyRadox.getFluid(100))
                .inputFluids(GTMaterials.Silver.getFluid(FluidStorageKeys.PLASMA, 10))
                .outputFluids(GTEMaterials.LightRadox.getFluid(20))
                .EUt(491520)
                .duration(200)
                .save();

        CRACKING_RECIPES.recipeBuilder(GTECore.id("superlightradox"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.LightRadox.getFluid(100))
                .inputFluids(GTMaterials.Silver.getFluid(FluidStorageKeys.PLASMA, 10))
                .outputFluids(GTEMaterials.SuperLightRadox.getFluid(50))
                .EUt(491520)
                .duration(300)
                .save();

        CRACKING_RECIPES.recipeBuilder(GTECore.id("fluorine_cracked_aquadah"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.NaquadahSolution.getFluid(1000))
                .inputFluids(GTMaterials.Fluorine.getFluid(1000))
                .outputFluids(GTEMaterials.FluorineCrackedAquadah.getFluid(1000))
                .EUt(491520)
                .duration(120)
                .save();
    }
}
