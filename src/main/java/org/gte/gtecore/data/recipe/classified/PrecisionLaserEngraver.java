package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.PRECISION_LASER_ENGRAVER_RECIPES;

interface PrecisionLaserEngraver {

    static void init() {
        PRECISION_LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("high_precision_crystal_soc"))
                .inputItems(GTItems.CRYSTAL_SYSTEM_ON_CHIP.asItem())
                .notConsumable(GTEItems.LITHOGRAPHY_MASK.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Yellow)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Lime)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.LightBlue)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Cyan)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Purple)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Black)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Blue)
                .inputFluids(GTEMaterials.EuvPhotoresist.getFluid(1000))
                .outputItems(GTEItems.HIGH_PRECISION_CRYSTAL_SOC.asItem())
                .EUt(7864320)
                .duration(2400)
                .save();

        PRECISION_LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("pm_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(GTEItems.LITHOGRAPHY_MASK.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Blue)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Brown)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Orange)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Red)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Lime)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Pink)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Gray)
                .inputFluids(GTEMaterials.EuvPhotoresist.getFluid(1000))
                .outputItems(GTEItems.PM_WAFER.asItem())
                .EUt(1966080)
                .duration(1800)
                .save();

        PRECISION_LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("fm_wafer"))
                .inputItems(GTEItems.PM_WAFER.asItem())
                .notConsumable(GTEItems.GRATING_LITHOGRAPHY_MASK.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Blue)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Brown)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Orange)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Red)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Lime)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Pink)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Gray)
                .inputFluids(GTEMaterials.GammaRaysPhotoresist.getFluid(1000))
                .outputItems(GTEItems.FM_WAFER.asItem())
                .EUt(7864320)
                .duration(2800)
                .save();

        PRECISION_LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("nm_wafer"))
                .inputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_WAFER.asItem())
                .notConsumable(GTEItems.LITHOGRAPHY_MASK.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Blue)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Brown)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Orange)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Red)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Lime)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Pink)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Gray)
                .inputFluids(GTEMaterials.Photoresist.getFluid(1000))
                .outputItems(GTEItems.NM_WAFER.asItem())
                .EUt(491520)
                .duration(900)
                .save();

        PRECISION_LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("raw_photon_carrying_wafer"))
                .inputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_WAFER.asItem())
                .notConsumable(GTEItems.LITHOGRAPHY_MASK.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.LightGray)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Purple)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Yellow)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Magenta)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Orange)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.LightBlue)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Pink)
                .inputFluids(GTEMaterials.Photoresist.getFluid(1000))
                .outputItems(GTEItems.RAW_PHOTON_CARRYING_WAFER.asItem())
                .EUt(1966080)
                .duration(600)
                .save();

        PRECISION_LASER_ENGRAVER_RECIPES.recipeBuilder(GTECore.id("prepared_cosmic_soc_wafer"))
                .inputItems(GTEItems.TARANIUM_WAFER.asItem())
                .notConsumable(GTEItems.LITHOGRAPHY_MASK.asItem())
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Yellow)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Lime)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.LightBlue)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Cyan)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Purple)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Black)
                .notConsumable(TagPrefix.lens, MarkerMaterials.Color.Blue)
                .inputFluids(GTEMaterials.GammaRaysPhotoresist.getFluid(1000))
                .outputItems(GTEItems.PREPARED_COSMIC_SOC_WAFER.asItem())
                .EUt(31457280)
                .duration(4800)
                .save();
    }
}
