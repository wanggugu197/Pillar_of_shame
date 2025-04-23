package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.SPACE_PROBE_SURFACE_RECEPTION_RECIPES;

interface SpaceProbeSurfaceReception {

    static void init() {
        SPACE_PROBE_SURFACE_RECEPTION_RECIPES.recipeBuilder(GTECore.id("heavy_lepton_mixture1"))
                .notConsumable(GTEItems.SPACE_PROBE_MK1.asItem())
                .circuitMeta(1)
                .outputFluids(GTEMaterials.HeavyLeptonMixture.getFluid(100))
                .EUt(31457280)
                .duration(200)
                .save();

        SPACE_PROBE_SURFACE_RECEPTION_RECIPES.recipeBuilder(GTECore.id("heavy_lepton_mixture2"))
                .notConsumable(GTEItems.SPACE_PROBE_MK2.asItem())
                .circuitMeta(1)
                .outputFluids(GTEMaterials.HeavyLeptonMixture.getFluid(1000))
                .EUt(125829120)
                .duration(200)
                .save();

        SPACE_PROBE_SURFACE_RECEPTION_RECIPES.recipeBuilder(GTECore.id("heavy_lepton_mixture3"))
                .notConsumable(GTEItems.SPACE_PROBE_MK3.asItem())
                .circuitMeta(1)
                .outputFluids(GTEMaterials.HeavyLeptonMixture.getFluid(10000))
                .EUt(503316480)
                .duration(200)
                .save();

        SPACE_PROBE_SURFACE_RECEPTION_RECIPES.recipeBuilder(GTECore.id("cosmic_element3"))
                .notConsumable(GTEItems.SPACE_PROBE_MK3.asItem())
                .circuitMeta(3)
                .outputFluids(GTEMaterials.CosmicElement.getFluid(10000))
                .EUt(503316480)
                .duration(200)
                .save();

        SPACE_PROBE_SURFACE_RECEPTION_RECIPES.recipeBuilder(GTECore.id("starlight3"))
                .notConsumable(GTEItems.SPACE_PROBE_MK3.asItem())
                .circuitMeta(2)
                .outputFluids(GTEMaterials.Starlight.getFluid(10000))
                .EUt(503316480)
                .duration(200)
                .save();

        SPACE_PROBE_SURFACE_RECEPTION_RECIPES.recipeBuilder(GTECore.id("starlight2"))
                .notConsumable(GTEItems.SPACE_PROBE_MK2.asItem())
                .circuitMeta(2)
                .outputFluids(GTEMaterials.Starlight.getFluid(1000))
                .EUt(125829120)
                .duration(200)
                .save();
    }
}
