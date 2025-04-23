package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTItems.QUBIT_CENTRAL_PROCESSING_UNIT_WAFER;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Radon;
import static org.gte.gtecore.common.data.GTERecipeTypes.CHEMICAL_VAPOR_DEPOSITION_RECIPES;

interface ChemicalVaporDepositio {

    static void init() {
        CHEMICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("carbon_nanotubes_ingot"))
                .circuitMeta(1)
                .notConsumable(TagPrefix.plate, GTMaterials.Rhenium)
                .inputFluids(GTMaterials.Methane.getFluid(800))
                .inputFluids(GTEMaterials.Cycloparaphenylene.getFluid(200))
                .outputItems(TagPrefix.dust, GTEMaterials.CarbonNanotubes)
                .EUt(320000)
                .duration(290)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("fullerene_doped_nanotubes"))
                .inputItems(TagPrefix.dust, GTEMaterials.Fullerene)
                .notConsumable(TagPrefix.plate, GTMaterials.Rhenium)
                .inputFluids(GTMaterials.Methane.getFluid(14400))
                .inputFluids(GTEMaterials.Cycloparaphenylene.getFluid(3600))
                .outputFluids(GTEMaterials.FullereneDopedNanotubes.getFluid(18000))
                .EUt(320000)
                .duration(290)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("neutronium_doped_nanotubes"))
                .inputItems(TagPrefix.dust, GTEMaterials.Neutron)
                .notConsumable(TagPrefix.plate, GTMaterials.Rhenium)
                .inputFluids(GTMaterials.Methane.getFluid(800))
                .inputFluids(GTEMaterials.Cycloparaphenylene.getFluid(200))
                .outputFluids(GTEMaterials.NeutroniumDopedNanotubes.getFluid(200))
                .EUt(491520)
                .duration(500)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("seaborgium_doped_nanotubes"))
                .inputItems(TagPrefix.dust, GTMaterials.Seaborgium)
                .notConsumable(TagPrefix.plate, GTMaterials.Rhenium)
                .inputFluids(GTMaterials.Methane.getFluid(800))
                .inputFluids(GTEMaterials.Cycloparaphenylene.getFluid(200))
                .outputFluids(GTEMaterials.SeaborgiumDopedNanotubes.getFluid(144))
                .EUt(320000)
                .duration(390)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder(GTECore.id("graphene"))
                .notConsumable(TagPrefix.plate, GTMaterials.Nickel)
                .inputItems(TagPrefix.dust, GTEMaterials.GrapheneOxide, 3)
                .outputItems(TagPrefix.foil, GTMaterials.Graphene, 8)
                .inputFluids(GTMaterials.Methane.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(7680)
                .duration(120)
                .save();

        CHEMICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder("nano_cpu_wafer")
                .inputItems(CENTRAL_PROCESSING_UNIT_WAFER)
                .inputItems(CARBON_FIBERS, 16)
                .inputFluids(Glowstone.getFluid(576))
                .outputItems(NANO_CENTRAL_PROCESSING_UNIT_WAFER)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(1200).EUt(VA[EV]).save();

        CHEMICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder("qbit_cpu_wafer_quantum_eye")
                .inputItems(NANO_CENTRAL_PROCESSING_UNIT_WAFER)
                .inputItems(QUANTUM_EYE, 2)
                .inputFluids(GalliumArsenide.getFluid(288))
                .outputItems(QUBIT_CENTRAL_PROCESSING_UNIT_WAFER)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(900).EUt(VA[EV]).save();

        CHEMICAL_VAPOR_DEPOSITION_RECIPES.recipeBuilder("qbit_cpu_wafer_radon")
                .inputItems(NANO_CENTRAL_PROCESSING_UNIT_WAFER)
                .inputItems(dust, IndiumGalliumPhosphide)
                .inputFluids(Radon.getFluid(50))
                .outputItems(QUBIT_CENTRAL_PROCESSING_UNIT_WAFER)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(1200).EUt(VA[EV]).save();
    }
}
