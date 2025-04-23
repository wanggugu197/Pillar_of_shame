package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTEMaterials.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.POLYMERIZATION_REACTOR_RECIPES;

interface PolymerizationReactor {

    static void init() {
        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("epoxy_from_bisphenol_a")
                .inputItems(dust, SodiumHydroxide, 3)
                .inputFluids(Epichlorohydrin.getFluid(1000))
                .inputFluids(BisphenolA.getFluid(1000))
                .outputFluids(Epoxy.getFluid(1000))
                .outputFluids(SaltWater.getFluid(1000))
                .duration(200).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder(GTECore.id("make_p507_2"))
                .inputItems(dust, Sodium, 2)
                .inputFluids(EthylHexanol.getFluid(2000))
                .inputFluids(PhosphoricAcid.getFluid(2000))
                .inputFluids(Ethanol.getFluid(2000))
                .outputFluids(P507.getFluid(1000))
                .duration(1200)
                .EUt(1920)
                .save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder(GTECore.id("pre_zylon_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Terephthalaldehyde, 16)
                .inputFluids(GTEMaterials.Dinitrodipropanyloxybenzene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PreZylon)
                .outputFluids(GTMaterials.Oxygen.getFluid(6000))
                .EUt(7864320)
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder(GTECore.id("polyetheretherketone"))
                .inputItems(TagPrefix.dust, GTEMaterials.Difluorobenzophenone, 24)
                .inputItems(TagPrefix.dust, GTMaterials.SodaAsh, 6)
                .inputFluids(GTEMaterials.Hydroquinone.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 4)
                .outputFluids(GTEMaterials.Polyetheretherketone.getFluid(2592))
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(1000))
                .EUt(122880)
                .duration(250)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder(GTECore.id("polyurethaneresin"))
                .inputItems(TagPrefix.dust, GTEMaterials.Pentaerythritol)
                .inputItems(TagPrefix.dust, GTEMaterials.DiphenylmethaneDiisocyanate, 5)
                .inputFluids(GTEMaterials.EthyleneGlycol.getFluid(4000))
                .inputFluids(GTEMaterials.SiliconOil.getFluid(1000))
                .outputFluids(GTEMaterials.PolyurethaneResin.getFluid(1000))
                .EUt(7680)
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder(GTECore.id("polyurethane"))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .inputFluids(GTEMaterials.EthyleneGlycol.getFluid(4000))
                .inputFluids(GTEMaterials.TolueneDiisocyanate.getFluid(1000))
                .outputFluids(GTEMaterials.Polyurethane.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(7000))
                .EUt(480)
                .duration(110)
                .save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder(GTECore.id("paa"))
                .inputItems(TagPrefix.dust, GTEMaterials.PyromelliticDianhydride, 18)
                .inputFluids(GTEMaterials.Oxydianiline.getFluid(1000))
                .outputFluids(GTEMaterials.Paa.getFluid(1000))
                .EUt(122880)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polyphenylene_sulfide_from_oxygen")
                .inputItems(dust, SodiumSulfide, 3)
                .inputFluids(Dichlorobenzene.getFluid(1000))
                .inputFluids(Oxygen.getFluid(8000))
                .outputItems(dust, Salt, 4)
                .outputFluids(PolyphenyleneSulfide.getFluid(1500))
                .duration(240).EUt(360).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polybenzimidazole").EUt(VA[IV]).duration(100)
                .inputFluids(Diaminobenzidine.getFluid(1000))
                .inputFluids(DiphenylIsophtalate.getFluid(1000))
                .outputFluids(Phenol.getFluid(1000))
                .outputFluids(Polybenzimidazole.getFluid(1008))
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polycaprolactam").EUt(VA[MV]).duration(450)
                .inputItems(dust, Caprolactam, 1)
                .inputFluids(Nitrogen.getFluid(1000))
                .outputItems(ingot, Polycaprolactam, 1)
                .save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polyvinyl_butyral")
                .inputFluids(Butyraldehyde.getFluid(250))
                .inputFluids(PolyvinylAcetate.getFluid(L))
                .outputFluids(PolyvinylButyral.getFluid(L))
                .duration(400).EUt(VA[HV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("raw_sbr_from_oxygen")
                .circuitMeta(3)
                .inputFluids(Butadiene.getFluid(3000))
                .inputFluids(Styrene.getFluid(1000))
                .inputFluids(Oxygen.getFluid(15000))
                .outputItems(dust, RawStyreneButadieneRubber, 41)
                .duration(480).EUt(240).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("pva_from_oxygen")
                .circuitMeta(1)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(VinylAcetate.getFluid(L))
                .outputFluids(PolyvinylAcetate.getFluid(216))
                .duration(160).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("pva_from_tetrachloride_oxygen")
                .circuitMeta(2)
                .inputFluids(Oxygen.getFluid(7500))
                .inputFluids(VinylAcetate.getFluid(2160))
                .inputFluids(TitaniumTetrachloride.getFluid(100))
                .outputFluids(PolyvinylAcetate.getFluid(4320))
                .duration(800).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polyethylene_from_oxygen")
                .circuitMeta(1)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(Ethylene.getFluid(L))
                .outputFluids(Polyethylene.getFluid(216))
                .duration(160).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polyethylene_from_tetrachloride_oxygen")
                .circuitMeta(2)
                .inputFluids(Oxygen.getFluid(7500))
                .inputFluids(Ethylene.getFluid(2160))
                .inputFluids(TitaniumTetrachloride.getFluid(100))
                .outputFluids(Polyethylene.getFluid(4320))
                .duration(800).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polyvinyl_chloride_from_oxygen")
                .circuitMeta(1)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(VinylChloride.getFluid(L))
                .outputFluids(PolyvinylChloride.getFluid(216))
                .duration(160).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polyvinyl_chloride_from_tetrachloride_oxygen")
                .circuitMeta(2)
                .inputFluids(Oxygen.getFluid(7500))
                .inputFluids(VinylChloride.getFluid(2160))
                .inputFluids(TitaniumTetrachloride.getFluid(100))
                .outputFluids(PolyvinylChloride.getFluid(4320))
                .duration(800).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("ptfe_from_oxygen")
                .circuitMeta(1)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(Tetrafluoroethylene.getFluid(L))
                .outputFluids(Polytetrafluoroethylene.getFluid(216))
                .duration(160).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("ptfe_from_tetrachloride_oxygen")
                .circuitMeta(2)
                .inputFluids(Oxygen.getFluid(7500))
                .inputFluids(Tetrafluoroethylene.getFluid(2160))
                .inputFluids(TitaniumTetrachloride.getFluid(100))
                .outputFluids(Polytetrafluoroethylene.getFluid(4320))
                .duration(800).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("styrene_from_oxygen")
                .circuitMeta(1)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(Styrene.getFluid(L))
                .outputFluids(Polystyrene.getFluid(216))
                .duration(160).EUt(VA[LV]).save();

        POLYMERIZATION_REACTOR_RECIPES.recipeBuilder("polyethylene_from_tetrachloride_oxygen")
                .circuitMeta(2)
                .inputFluids(Oxygen.getFluid(7500))
                .inputFluids(Styrene.getFluid(2160))
                .inputFluids(TitaniumTetrachloride.getFluid(100))
                .outputFluids(Polystyrene.getFluid(4320))
                .duration(800).EUt(VA[LV]).save();
    }
}
