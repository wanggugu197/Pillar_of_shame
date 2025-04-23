package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES;

interface DimensionalFocusEngravingArray {

    static void init() {
        DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES.recipeBuilder(GTECore.id("pm_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Magenta)
                .inputFluids(GTEMaterials.EuvPhotoresist.getFluid(100))
                .outputItems(GTEItems.PM_WAFER.asItem())
                .EUt(1966080)
                .duration(1800)
                .scannerResearch(b -> b.researchStack(GTEItems.PM_WAFER.asStack())
                        .dataStack(GTEItems.OPTICAL_DATA_STICK.asStack())
                        .EUt(1966080).duration(2400))
                .save();

        DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES.recipeBuilder(GTECore.id("raw_photon_carrying_wafer"))
                .inputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Yellow)
                .inputFluids(GTEMaterials.Photoresist.getFluid(100))
                .outputItems(GTEItems.RAW_PHOTON_CARRYING_WAFER.asItem())
                .EUt(1966080)
                .duration(600)
                .scannerResearch(b -> b.researchStack(GTEItems.RAW_PHOTON_CARRYING_WAFER.asStack())
                        .dataStack(GTEItems.OPTICAL_DATA_STICK.asStack())
                        .EUt(1966080).duration(2400))
                .save();

        DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES.recipeBuilder(GTECore.id("high_precision_crystal_soc"))
                .inputItems(GTItems.CRYSTAL_SYSTEM_ON_CHIP.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Lime)
                .inputFluids(GTEMaterials.EuvPhotoresist.getFluid(100))
                .outputItems(GTEItems.HIGH_PRECISION_CRYSTAL_SOC.asItem())
                .EUt(7864320)
                .duration(2400)
                .scannerResearch(b -> b.researchStack(GTEItems.HIGH_PRECISION_CRYSTAL_SOC.asStack())
                        .dataStack(GTEItems.OPTICAL_DATA_STICK.asStack())
                        .EUt(7864320).duration(2400))
                .save();

        DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES.recipeBuilder(GTECore.id("prepared_cosmic_soc_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.LightBlue)
                .inputFluids(GTEMaterials.GammaRaysPhotoresist.getFluid(100))
                .outputItems(GTEItems.PREPARED_COSMIC_SOC_WAFER.asItem())
                .EUt(31457280)
                .duration(4800)
                .scannerResearch(b -> b.researchStack(GTEItems.PREPARED_COSMIC_SOC_WAFER.asStack())
                        .dataStack(GTEItems.OPTICAL_DATA_STICK.asStack())
                        .EUt(31457280).duration(2400))
                .save();

        DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES.recipeBuilder(GTECore.id("nm_wafer"))
                .inputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Blue)
                .inputFluids(GTEMaterials.Photoresist.getFluid(100))
                .outputItems(GTEItems.NM_WAFER.asItem())
                .EUt(491520)
                .duration(900)
                .scannerResearch(b -> b.researchStack(GTEItems.NM_WAFER.asStack())
                        .dataStack(GTEItems.OPTICAL_DATA_STICK.asStack())
                        .EUt(491520).duration(2400))
                .save();

        DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES.recipeBuilder(GTECore.id("fm_wafer"))
                .inputItems(GTEItems.PM_WAFER.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Orange)
                .inputFluids(GTEMaterials.GammaRaysPhotoresist.getFluid(100))
                .outputItems(GTEItems.FM_WAFER.asItem())
                .EUt(7864320)
                .duration(2700)
                .scannerResearch(b -> b.researchStack(GTEItems.FM_WAFER.asStack())
                        .dataStack(GTEItems.OPTICAL_DATA_STICK.asStack())
                        .EUt(7864320).duration(2400))
                .save();
    }
}
