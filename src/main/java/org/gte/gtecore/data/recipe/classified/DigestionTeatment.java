package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.*;

interface DigestionTeatment {

    static void init() {
        DIGESTION_TREATMENT_RECIPES.recipeBuilder(GTECore.id("rare_earth_oxide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumOxide, 3)
                .inputFluids(GTEMaterials.RareEarthChlorides.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.RareEarthOxide)
                .outputFluids(GTMaterials.SaltWater.getFluid(1000))
                .EUt(1920)
                .duration(800)
                .blastFurnaceTemp(2580)
                .save();

        DIGESTION_TREATMENT_RECIPES.recipeBuilder(GTECore.id("naquadah_contain_rare_earth_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.NaquadahContainRareEarthFluoride)
                .inputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.NaquadahContainRareEarth)
                .outputFluids(GTMaterials.HydrofluoricAcid.getFluid(2000))
                .EUt(491520)
                .duration(800)
                .blastFurnaceTemp(6800)
                .save();

        DIGESTION_TREATMENT_RECIPES.recipeBuilder(GTECore.id("rare_earth_metal_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.RareEarthOxide)
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.RareEarthMetal)
                .outputFluids(GTMaterials.Water.getFluid(500))
                .EUt(7680)
                .duration(400)
                .blastFurnaceTemp(1760)
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("enriched_naquadah_fuel"))
                .inputFluids(GTEMaterials.RadonCrackedEnrichedAquadah.getFluid(1000))
                .outputFluids(GTEMaterials.EnrichedNaquadahFuel.getFluid(800))
                .outputFluids(GTMaterials.NaquadriaWaste.getFluid(100))
                .outputFluids(GTMaterials.Radon.getFluid(200))
                .outputFluids(GTMaterials.Fluorine.getFluid(200))
                .EUt(30720)
                .duration(600)
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("naquadah_fuel"))
                .inputFluids(GTEMaterials.FluorineCrackedAquadah.getFluid(1000))
                .outputFluids(GTEMaterials.NaquadahFuel.getFluid(800))
                .outputFluids(GTMaterials.NitricAcid.getFluid(200))
                .outputFluids(GTMaterials.EnrichedNaquadahWaste.getFluid(100))
                .outputFluids(GTMaterials.Ammonia.getFluid(200))
                .outputFluids(GTMaterials.Fluorine.getFluid(200))
                .EUt(122880)
                .duration(600)
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("diphenylmethane_diisocyanate_dust"))
                .inputFluids(GTEMaterials.DiphenylmethanediisocyanateMixture.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.DiphenylmethaneDiisocyanate, 29)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(5000))
                .EUt(1920)
                .duration(700)
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("turpentine"))
                .inputFluids(GTEMaterials.SteamCrackedTurpentine.getFluid(1000))
                .outputFluids(GTEMaterials.Turpentine.getFluid(1000))
                .outputFluids(GTMaterials.Naphtha.getFluid(900))
                .EUt(1920)
                .duration(400)
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("rawradox"))
                .inputFluids(GTEMaterials.RawRadox.getFluid(5000))
                .outputItems(TagPrefix.dust, GTMaterials.Ash, 5)
                .outputFluids(GTMaterials.OilHeavy.getFluid(600))
                .outputFluids(GTMaterials.Oil.getFluid(300))
                .outputFluids(GTMaterials.Creosote.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1400))
                .outputFluids(GTMaterials.Bacteria.getFluid(50))
                .outputFluids(GTMaterials.FermentedBiomass.getFluid(50))
                .outputFluids(GTEMaterials.SuperHeavyRadox.getFluid(100))
                .outputFluids(GTEMaterials.HeavyRadox.getFluid(100))
                .outputFluids(GTEMaterials.DilutedXenoxene.getFluid(100))
                .outputFluids(GTEMaterials.LightRadox.getFluid(100))
                .outputFluids(GTEMaterials.SuperLightRadox.getFluid(100))
                .EUt(491520)
                .duration(800)
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("dilutedxenoxene"))
                .inputFluids(GTEMaterials.DilutedXenoxene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Ash)
                .outputFluids(GTEMaterials.Xenoxene.getFluid(250))
                .outputFluids(GTEMaterials.LightRadox.getFluid(300))
                .EUt(491520)
                .duration(200)
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("radox_gas"))
                .inputFluids(GTEMaterials.CrackedRadox.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Ash)
                .outputFluids(GTEMaterials.RadoxGas.getFluid(100))
                .outputFluids(GTEMaterials.LightRadox.getFluid(200))
                .EUt(491520)
                .duration(600)
                .save();
    }
}
