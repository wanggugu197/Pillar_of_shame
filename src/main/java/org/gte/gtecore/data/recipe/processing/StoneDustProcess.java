package org.gte.gtecore.data.recipe.processing;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTEMaterials.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;

public interface StoneDustProcess {

    static void init() {
        MIXER_RECIPES.recipeBuilder(GTECore.id("dirty_hexafluorosilicic_acid_output"))
                .inputItems(dust, Stone, 24)
                .inputFluids(HydrofluoricAcid.getFluid(6000))
                .outputFluids(DirtyHexafluorosilicicAcid.getFluid(3000))
                .duration(40).EUt(VA[LV])
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("stone_dust_residue_output"))
                .inputFluids(DirtyHexafluorosilicicAcid.getFluid(3000))
                .outputFluids(DiluteHexafluorosilicicAcid.getFluid(3000))
                .outputItems(dust, StoneDustResidue, 12)
                .duration(40).EUt(VA[LV])
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("dilute_hexafluorosilicic_acid"))
                .inputFluids(DiluteHexafluorosilicicAcid.getFluid(3000))
                .outputFluids(Water.getFluid(2000))
                .outputFluids(FluorosilicicAcid.getFluid(1000))
                .duration(160).EUt(VA[MV])
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ammonium_fluoride_output"))
                .inputFluids(Water.getFluid(2000))
                .inputFluids(Ammonia.getFluid(6000))
                .inputFluids(FluorosilicicAcid.getFluid(1000))
                .outputItems(dust, SiliconDioxide, 3)
                .outputFluids(AmmoniumFluoride.getFluid(6000))
                .duration(320).EUt(VA[HV])
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("ammonium_bifluoride_output"))
                .inputFluids(AmmoniumFluoride.getFluid(2000))
                .outputItems(dust, AmmoniumBifluoride, 8)
                .outputFluids(Ammonia.getFluid(1000))
                .duration(340).EUt(VA[MV])
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("ammonium_bifluoride_soluition_output"))
                .inputFluids(Water.getFluid(1000))
                .inputItems(dust, AmmoniumBifluoride, 8)
                .outputFluids(AmmoniumBifluorideSolution.getFluid(2000))
                .duration(140).EUt(VA[LV])
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("ammonium_bifluoride_solution"))
                .inputFluids(AmmoniumBifluorideSolution.getFluid(2000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .duration(260).EUt(VA[MV])
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("uncommon_residues_output"))
                .inputFluids(SodiumHydroxideSolution.getFluid(1000))
                .inputItems(dust, StoneDustResidue, 24)
                .outputItems(dust, UncommonResidues, 1)
                .outputItems(dust, Magnetite, 1)
                .outputFluids(SodiumHydroxideSolution.getFluid(925))
                .outputFluids(RedMud.getFluid(75))
                .duration(40).EUt(VA[MV])
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("sodium_hydroxide_solution_output"))
                .circuitMeta(2)
                .inputItems(dust, SodiumHydroxide, 3)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(SodiumHydroxideSolution.getFluid(1000))
                .duration(60).EUt(VA[LV])
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("partially_oxidized_residues_output"))
                .inputItems(dust, UncommonResidues, 1)
                .inputFluids(DioxygenDifluoride.getFluid(1000))
                .outputItems(dust, PartiallyOxidizedResidues, 1)
                .duration(80).EUt(VA[MV])
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("neutralised_red_mud_output"))
                .inputFluids(RedMud.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(4000))
                .outputFluids(NeutralisedRedMud.getFluid(2000))
                .duration(100).EUt(VA[MV])
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("red_slurry_output"))
                .inputFluids(NeutralisedRedMud.getFluid(2000))
                .outputFluids(RedSlurry.getFluid(1000))
                .outputFluids(FerricReeChloride.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(4000))
                .duration(100).EUt(VA[MV])
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("titanyl_sulfate_output"))
                .inputFluids(SulfuricAcid.getFluid(2000))
                .inputFluids(RedSlurry.getFluid(2000))
                .outputFluids(TitanylSulfate.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .duration(160).EUt(VA[MV])
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("titanyl_sulfate"))
                .inputFluids(HydrochloricAcid.getFluid(4000))
                .inputFluids(TitanylSulfate.getFluid(1000))
                .outputFluids(TitaniumTetrachloride.getFluid(1000))
                .outputFluids(SulfuricAcid.getFluid(1000))
                .duration(160).EUt(960)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("ferric_ree_chloride"))
                .inputFluids(FerricReeChloride.getFluid(2000))
                .outputFluids(RareEarthChlorides.getFluid(1000))
                .outputFluids(Iron3Chloride.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .duration(320).EUt(VA[HV])
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dioxygen_difluoride_output"))
                .notConsumable(GTEItems.MICROFOCUS_X_RAY_TUBE)
                .inputFluids(Oxygen.getFluid(2000))
                .inputFluids(Fluorine.getFluid(2000))
                .outputFluids(DioxygenDifluoride.getFluid(1000))
                .duration(80).EUt(200)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("oxidized_residues_output"))
                .inputFluids(OxidizedResidualSolution.getFluid(2000))
                .outputItems(dust, OxidizedResidues, 1)
                .outputItems(dust, HeavyOxidizedResidues, 1)
                .duration(80).EUt(3000)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("metallic_residues_output"))
                .inputItems(dust, OxidizedResidues, 10)
                .inputFluids(Hydrogen.getFluid(60000))
                .outputItems(dust, MetallicResidues, 1)
                .outputFluids(DiluteHydrofluoricAcid.getFluid(40000))
                .duration(1600).EUt(VA[EV])
                .blastFurnaceTemp(3500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("heavy_metallic_residues_output"))
                .inputItems(dust, HeavyOxidizedResidues, 10)
                .inputFluids(Hydrogen.getFluid(60000))
                .outputItems(dust, HeavyMetallicResidues, 1)
                .outputFluids(DiluteHydrofluoricAcid.getFluid(40000))
                .duration(1600).EUt(VA[EV])
                .blastFurnaceTemp(3500)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("ultraacidic_residue_solution_output"))
                .inputFluids(HeliumIIIHydride.getFluid(1000))
                .inputItems(dust, CleanInertResidues, 1)
                .outputFluids(UltraacidicResidueSolution.getFluid(1000))
                .duration(160).EUt(VA[EV])
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("helium_iii_hydride_output"))
                .inputFluids(TritiumHydride.getFluid(10000))
                .outputFluids(HeliumIIIHydride.getFluid(100))
                .outputFluids(TritiumHydride.getFluid(9900))
                .duration(800).EUt(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tritium_hydride_output"))
                .inputFluids(Hydrogen.getFluid(1000))
                .inputFluids(Tritium.getFluid(1000))
                .outputFluids(TritiumHydride.getFluid(1000))
                .duration(160).EUt(VA[EV])
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("xenic_acid_output"))
                .inputFluids(Xenon.getFluid(1000))
                .inputFluids(Oxygen.getFluid(FluidStorageKeys.LIQUID, 4000))
                .inputFluids(UltraacidicResidueSolution.getFluid(2000))
                .outputFluids(XenicAcid.getFluid(1000))
                .outputFluids(DustyLiquidHeliumIII.getFluid(2000))
                .duration(120).EUt(VA[EV])
                .save();

        ELECTROLYZER_RECIPES.recipeBuilder(GTECore.id("ozone_output_1"))
                .inputFluids(XenicAcid.getFluid(2000))
                .outputFluids(Xenon.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Ozone.getFluid(1000))
                .outputFluids(HydrogenPeroxide.getFluid(1000))
                .outputFluids(Oxygen.getFluid(2000))
                .duration(120).EUt(VA[HV])
                .save();

        DISTILLATION_RECIPES.recipeBuilder(GTECore.id("hydrofluoric_acid_output"))
                .inputFluids(DiluteHydrofluoricAcid.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(1000))
                .duration(80).EUt(200)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("metallic_residues_input"))
                .notConsumable(GTEItems.SEPARATION_ELECTROMAGNET)
                .inputItems(dust, MetallicResidues, 10)
                .outputItems(dust, DiamagneticResidues, 3)
                .outputItems(dust, ParamagneticResidues, 3)
                .outputItems(dust, FerromagneticResidues, 3)
                .outputItems(dust, UncommonResidues, 1)
                .duration(80).EUt(VA[IV])
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("heavy_metallic_residues_input"))
                .notConsumable(GTEItems.SEPARATION_ELECTROMAGNET)
                .inputItems(dust, HeavyMetallicResidues, 10)
                .outputItems(dust, HeavyDiamagneticResidues, 3)
                .outputItems(dust, HeavyParamagneticResidues, 3)
                .outputItems(dust, HeavyFerromagneticResidues, 3)
                .outputItems(dust, ExoticHeavyResidues, 1)
                .duration(80).EUt(VA[IV])
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("diamagnetic_residues_input"))
                .inputItems(dust, DiamagneticResidues, 6)
                .chancedOutput(dust, Calcium, 1, 2500, 0)
                .chancedOutput(dust, Zinc, 1, 2500, 0)
                .chancedOutput(dust, Copper, 1, 2500, 0)
                .chancedOutput(dust, Gallium, 1, 2500, 0)
                .chancedOutput(dust, Beryllium, 1, 2500, 0)
                .chancedOutput(dust, Tin, 1, 2500, 0)
                .duration(100).EUt(3000)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("paramagnetic_residues_input"))
                .inputItems(dust, ParamagneticResidues, 6)
                .chancedOutput(dust, Sodium, 1, 2500, 0)
                .chancedOutput(dust, Potassium, 1, 2500, 0)
                .chancedOutput(dust, Magnesium, 1, 2500, 0)
                .chancedOutput(dust, Titanium, 1, 2500, 0)
                .chancedOutput(dust, Vanadium, 1, 2500, 0)
                .chancedOutput(dust, Manganese, 1, 2500, 0)
                .duration(100).EUt(3000)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("ferromagnetic_residues_input"))
                .inputItems(dust, FerromagneticResidues, 6)
                .chancedOutput(dust, Iron, 1, 2500, 0)
                .chancedOutput(dust, Nickel, 1, 2500, 0)
                .chancedOutput(dust, Cobalt, 1, 2500, 0)
                .duration(100).EUt(3000)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("heavy_diamagnetic_residues_input"))
                .inputItems(dust, HeavyDiamagneticResidues, 6)
                .chancedOutput(dust, Lead, 1, 2500, 0)
                .chancedOutput(dust, Cadmium, 1, 2500, 0)
                .chancedOutput(dust, Indium, 1, 2500, 0)
                .chancedOutput(dust, Gold, 1, 2500, 0)
                .chancedOutput(dust, Bismuth, 1, 2500, 0)
                .outputFluids(Mercury.getFluid(36))
                .duration(120).EUt(3000)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("heavy_paramagnetic_residues_input"))
                .inputItems(dust, HeavyParamagneticResidues, 6)
                .chancedOutput(dust, Thorium, 1, 2500, 0)
                .chancedOutput(dust, Uranium235, 1, 2500, 0)
                .chancedOutput(dust, Tungsten, 1, 2500, 0)
                .chancedOutput(dust, Hafnium, 1, 2500, 0)
                .chancedOutput(dust, Tantalum, 1, 2500, 0)
                .chancedOutput(dust, Thallium, 1, 2500, 0)
                .duration(120).EUt(3000)
                .save();

        CENTRIFUGE_RECIPES.recipeBuilder(GTECore.id("heavy_ferromagnetic_residues_input"))
                .inputItems(dust, HeavyFerromagneticResidues, 6)
                .chancedOutput(dust, Dysprosium, 1, 2500, 0)
                .duration(120).EUt(3000)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("exotic_heavy_residues_input"))
                .inputItems(dust, ExoticHeavyResidues, 16)
                .inputItems(dust, SodiumHydroxide, 3)
                .inputItems(GTEItems.PROTONATED_FULLERENE_SIEVING_MATRIX)
                .inputFluids(Water.getFluid(2000))
                .outputItems(GTEItems.SATURATED_FULLERENE_SIEVING_MATRIX)
                .outputFluids(SodiumHydroxideSolution.getFluid(1000))
                .duration(40).EUt(VA[UHV])
                .save();

        ARC_GENERATOR_RECIPES.recipeBuilder(GTECore.id("nitrogen_pentoxide"))
                .inputFluids(Oxygen.getFluid(6000))
                .outputFluids(Ozone.getFluid(2000))
                .duration(120).EUt(VA[HV])
                .save();
    }
}
