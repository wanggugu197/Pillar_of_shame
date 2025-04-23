package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.PHYSICAL_VAPOR_DEPOSITION_RECIPES;

interface PhysicalVaporDeposition {

    static void init() {
        PHYSICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("highly_insulating_foil"))
                .inputItems(TagPrefix.foil, GTEMaterials.Polyetheretherketone)
                .inputFluids(GTEMaterials.Azafullerene.getFluid(10))
                .outputItems(GTEItems.HIGHLY_INSULATING_FOIL.asItem())
                .EUt(7680)
                .duration(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        PHYSICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("cosmic_soc_wafer"))
                .inputItems(GTEItems.PREPARED_COSMIC_SOC_WAFER.asItem())
                .inputFluids(GTMaterials.Argon.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.SIMPLE_COSMIC_SOC_WAFER.asItem())
                .EUt(7864320)
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        PHYSICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("fullerene_polymer_matrix_soft_tubing"))
                .inputItems(TagPrefix.wireFine, GTEMaterials.Polyetheretherketone)
                .inputFluids(GTEMaterials.FullerenePolymerMatrixPulp.getFluid(18))
                .outputItems(GTEItems.FULLERENE_POLYMER_MATRIX_SOFT_TUBING.asItem())
                .EUt(100)
                .duration(80)
                .save();

        PHYSICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("electron_permeable_neutronium_coated_glass"))
                .inputItems(GTEBlocks.AMPROSIUM_BOROSILICATE_GLASS.asItem())
                .inputFluids(GTMaterials.Sulfur.getFluid(FluidStorageKeys.PLASMA, 288))
                .outputItems(GTEBlocks.ELECTRON_PERMEABLE_AMPROSIUM_COATED_GLASS.asItem())
                .EUt(122880)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        PHYSICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("non_photonic_matter_exclusion_glass"))
                .inputItems(GTEBlocks.QUARKS_BOROSILICATE_GLASS.asItem())
                .inputFluids(GTEMaterials.Legendarium.getFluid(FluidStorageKeys.PLASMA, 576))
                .outputItems(GTEBlocks.NON_PHOTONIC_MATTER_EXCLUSION_GLASS.asItem())
                .EUt(1966080)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        PHYSICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("omni_purpose_infinity_fused_glass"))
                .inputItems(GTEBlocks.TARANIUM_BOROSILICATE_GLASS.asItem())
                .inputFluids(GTEMaterials.QuarkGluon.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEBlocks.OMNI_PURPOSE_INFINITY_FUSED_GLASS.asItem())
                .EUt(491520)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }
}
