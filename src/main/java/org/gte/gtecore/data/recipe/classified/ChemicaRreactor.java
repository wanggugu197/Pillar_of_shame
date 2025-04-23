package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.foil;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;

interface ChemicaRreactor {

    static void init() {
        CHEMICAL_RECIPES.builder("sodium_fluoride_dust")
                .inputItems(TagPrefix.dust, GTMaterials.Sodium)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 2)
                .inputFluids(GTMaterials.HydrofluoricAcid, 1000)
                .outputFluids(GTMaterials.Hydrogen, 1000)
                .circuitMeta(2)
                .EUt(30)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.builder("iron_sulfate")
                .inputItems(TagPrefix.dust, GTMaterials.Iron)
                .outputItems(TagPrefix.dust, GTEMaterials.IronSulfate, 6)
                .inputFluids(GTMaterials.SulfuricAcid, 1000)
                .outputFluids(GTMaterials.Hydrogen, 2000)
                .circuitMeta(4)
                .EUt(30)
                .duration(250)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("betaionone"))
                .inputFluids(GTMaterials.Acetone.getFluid(1000))
                .inputFluids(GTEMaterials.Citral.getFluid(1000))
                .outputFluids(GTEMaterials.BetaIonone.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(250)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("citral"))
                .inputItems(TagPrefix.dust, GTEMaterials.BetaPinene, 26)
                .inputFluids(GTMaterials.Oxygen.getFluid(2000))
                .inputFluids(GTMaterials.Isoprene.getFluid(2000))
                .outputFluids(GTEMaterials.Citral.getFluid(2000))
                .EUt(480)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("beta_pinene"))
                .outputItems(TagPrefix.dust, GTEMaterials.BetaPinene, 26)
                .inputFluids(GTEMaterials.Turpentine.getFluid(1000))
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .outputFluids(GTMaterials.DilutedSulfuricAcid.getFluid(1000))
                .EUt(480)
                .duration(110)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("propargyl_chloride"))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.PropargylAlcohol.getFluid(1000))
                .outputFluids(GTEMaterials.PropargylChloride.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("propargyl_alcohol"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Copper)
                .inputFluids(GTEMaterials.Acetylene.getFluid(1000))
                .inputFluids(GTMaterials.Formaldehyde.getFluid(1000))
                .outputFluids(GTEMaterials.PropargylAlcohol.getFluid(1000))
                .EUt(120)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("propadiene"))
                .inputFluids(GTMaterials.Butene.getFluid(1000))
                .inputFluids(GTMaterials.Propene.getFluid(1000))
                .outputFluids(GTMaterials.Butane.getFluid(1000))
                .outputFluids(GTEMaterials.Propadiene.getFluid(1000))
                .EUt(480)
                .duration(240)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("copper_nitrate"))
                .inputItems(TagPrefix.dust, GTMaterials.Copper)
                .outputItems(TagPrefix.dust, GTEMaterials.CopperNitrate, 9)
                .inputFluids(GTMaterials.NitricAcid.getFluid(2000))
                .EUt(120)
                .duration(240)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("barium_nitrate"))
                .inputItems(TagPrefix.dust, GTMaterials.BariumSulfide, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.BariumNitrate, 9)
                .inputFluids(GTMaterials.NitricAcid.getFluid(2000))
                .EUt(120)
                .duration(240)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("yttrium_nitrate"))
                .inputItems(TagPrefix.dust, GTEMaterials.YttriumOxide, 5)
                .outputItems(TagPrefix.dust, GTEMaterials.YttriumNitrate, 26)
                .inputFluids(GTMaterials.NitricAcid.getFluid(6000))
                .EUt(120)
                .duration(240)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("yttrium_oxide"))
                .inputItems(TagPrefix.dust, GTMaterials.Yttrium, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.YttriumOxide, 5)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .outputFluids(GTMaterials.HydrogenSulfide.getFluid(1000))
                .outputFluids(GTMaterials.Oxygen.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("phenolic_board"))
                .inputItems(TagPrefix.plate, TreatedWood)
                .inputItems(TagPrefix.foil, GTMaterials.Lead, 4)
                .outputItems(GTItems.PHENOLIC_BOARD.asItem())
                .inputFluids(GTEMaterials.PhenolicResin.getFluid(144))
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(250))
                .EUt(30)
                .duration(300)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("coated_board"))
                .inputItems(TagPrefix.plate, GTMaterials.Wood)
                .inputItems(GTItems.STICKY_RESIN.asStack(2))
                .outputItems(GTItems.COATED_BOARD.asItem())
                .inputFluids(GTMaterials.Oxygen.getFluid(100))
                .EUt(7)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("phenolic_resin"))
                .notConsumable(TagPrefix.dust, GTMaterials.SodiumHydroxide)
                .inputFluids(GTMaterials.Phenol.getFluid(1000))
                .inputFluids(GTMaterials.Formaldehyde.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputFluids(GTEMaterials.PhenolicResin.getFluid(1000))
                .EUt(30)
                .duration(240)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sapphire_sodium_aluminate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sapphire, 5)
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumAluminate, 8)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(100)
                .heat(650)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("greensapphire_sodium_aluminate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.GreenSapphire, 5)
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumAluminate, 8)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(100)
                .heat(650)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("aluminium_trifluoride"))
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium)
                .outputItems(TagPrefix.dust, GTEMaterials.AluminiumTrifluoride, 4)
                .inputFluids(GTMaterials.Fluorine.getFluid(3000))
                .circuitMeta(6)
                .EUt(120)
                .duration(400)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("gold_cyanide"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium)
                .inputFluids(GTEMaterials.GoldCyanide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Gold)
                .outputFluids(GTEMaterials.SodiumCyanide.getFluid(1000))
                .EUt(1920)
                .duration(140)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("gold_depleted_molybdenite_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Molybdenite, 3)
                .inputFluids(GTEMaterials.SodiumCyanide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.GoldDepletedMolybdenite, 3)
                .outputFluids(GTEMaterials.GoldCyanide.getFluid(1000))
                .EUt(7680)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("formaldehyde"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Silver)
                .inputFluids(GTMaterials.Methanol.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputFluids(GTMaterials.Formaldehyde.getFluid(1000))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("formaldehyde_a"))
                .notConsumable(GTETagPrefix.dust, GTMaterials.Silver)
                .inputFluids(GTMaterials.Methanol.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputFluids(GTMaterials.Formaldehyde.getFluid(500))
                .EUt(30)
                .duration(300)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("bismuth_tellurite_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Bismuth, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Tellurium, 3)
                .outputItems(TagPrefix.dust, GTEMaterials.BismuthTellurite, 5)
                .EUt(120)
                .duration(760)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ammonium_perrhenate"))
                .inputFluids(GTEMaterials.RheniumSulfuricSolution.getFluid(1000))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .outputFluids(GTEMaterials.AmmoniumPerrhenate.getFluid(1000))
                .outputFluids(GTMaterials.HydrogenSulfide.getFluid(1000))
                .EUt(480)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("phosgene"))
                .inputFluids(GTMaterials.CarbonMonoxide.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputFluids(GTEMaterials.Phosgene.getFluid(1000))
                .EUt(1920)
                .duration(400)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("thallium_chloride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Thallium)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.ThalliumChloride, 2)
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("silver_oxide_dust"))
                .notConsumable(TagPrefix.dust, GTMaterials.SodiumHydroxide)
                .inputItems(TagPrefix.dust, GTEMaterials.SilverChloride, 4)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SilverOxide, 3)
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(2000))
                .EUt(30)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("potassium_bromide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Potassium)
                .inputFluids(GTMaterials.Bromine.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PotassiumBromide, 2)
                .EUt(120)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("potassium_bisulfite_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.PotassiumCarbonate, 6)
                .inputFluids(GTMaterials.SulfurDioxide.getFluid(2000))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PotassiumBisulfite, 12)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(1000))
                .EUt(480)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("aniline"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Zinc)
                .inputFluids(GTMaterials.Nitrobenzene.getFluid(1000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(3000))
                .outputFluids(GTEMaterials.Aniline.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(1920)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_perchlorate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumChlorate, 5)
                .inputFluids(GTMaterials.HydrogenPeroxide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumPerchlorate, 6)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(480)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dimethyl_sulfide"))
                .inputFluids(GTMaterials.Methanol.getFluid(2000))
                .inputFluids(GTMaterials.HydrogenSulfide.getFluid(1000))
                .outputFluids(GTEMaterials.DimethylSulfide.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(1920)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("nitrosonium_tetrafluoroborate_dust"))
                .inputFluids(GTEMaterials.BoronFluoride.getFluid(2000))
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(2000))
                .inputFluids(GTMaterials.DinitrogenTetroxide.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.NitrosoniumTetrafluoroborate, 7)
                .outputFluids(GTMaterials.NitricAcid.getFluid(1000))
                .EUt(120)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("trimethylchlorosilane"))
                .inputFluids(GTMaterials.Methane.getFluid(1000))
                .inputFluids(GTMaterials.Dimethyldichlorosilane.getFluid(1000))
                .outputFluids(GTEMaterials.Trimethylchlorosilane.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .EUt(1920)
                .duration(110)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("nitrogen_pentoxide"))
                .inputFluids(GTEMaterials.Ozone.getFluid(1000))
                .inputFluids(GTMaterials.NitrogenDioxide.getFluid(6000))
                .outputFluids(GTEMaterials.NitrogenPentoxide.getFluid(3000))
                .EUt(480)
                .duration(240)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("butyl_lithium"))
                .inputItems(TagPrefix.dust, GTMaterials.Lithium)
                .inputFluids(GTMaterials.Butane.getFluid(1000))
                .outputFluids(GTEMaterials.ButylLithium.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(480)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("potassium_fluoride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Potassium)
                .inputFluids(GTMaterials.Fluorine.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PotassiumFluoride, 2)
                .EUt(30)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hexanitrohexaaxaisowurtzitane_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CrudeHexanitrohexaaxaisowurtzitane, 36)
                .inputItems(TagPrefix.dust, GTEMaterials.SilicaGel, 3)
                .inputFluids(GTEMaterials.Ethylenediamine.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Hexanitrohexaaxaisowurtzitane, 36)
                .EUt(1920)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dmap_dust"))
                .inputFluids(GTEMaterials.Pyridine.getFluid(1000))
                .inputFluids(GTMaterials.Dimethylamine.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.DMAP)
                .outputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .EUt(7680)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("nitrous_acid"))
                .inputItems(TagPrefix.dust, GTMaterials.SodiumNitrite, 4)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.SodiumBisulfate, 7)
                .outputFluids(GTEMaterials.NitrousAcid.getFluid(1000))
                .EUt(30)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("fluorite_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Calcium)
                .inputFluids(GTMaterials.Fluorine.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.Fluorite, 3)
                .EUt(30)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("lithium_aluminium_hydride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumAluminiumHydride, 6)
                .inputItems(TagPrefix.dust, GTMaterials.LithiumChloride, 2)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.LithiumAluminiumHydride, 6)
                .outputFluids(GTMaterials.SaltWater.getFluid(1000))
                .EUt(480)
                .duration(320)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ammonium_nitrate_solution"))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTMaterials.NitricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.AmmoniumNitrateSolution.getFluid(1000))
                .EUt(120)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("nitrated_triniite_compound_solution"))
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 36)
                .inputFluids(GTEMaterials.NitratedTriniiteCompoundSolution.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.ActiniumTriniumHydroxides, 29)
                .outputItems(TagPrefix.dust, GTMaterials.SodiumSulfide, 12)
                .outputFluids(GTEMaterials.ResidualTriniiteSolution.getFluid(2000))
                .EUt(480)
                .duration(190)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ammonium_chloride_dust"))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.AmmoniumChloride, 6)
                .EUt(30)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("germanium_dioxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Germanium)
                .inputFluids(GTMaterials.Oxygen.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.GermaniumDioxide, 3)
                .EUt(120)
                .duration(400)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_hypochlorite_dust"))
                .circuitMeta(1)
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 6)
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumHypochlorite, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("zirconiu_hafnium_oxychloride"))
                .inputFluids(GTEMaterials.ZirconiumHafniumChloride.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTEMaterials.ZirconiumHafniumOxychloride.getFluid(1000))
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(2000))
                .EUt(480)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hexamethylenetetramine_dust"))
                .circuitMeta(1)
                .inputFluids(GTMaterials.Formaldehyde.getFluid(4000))
                .inputFluids(GTMaterials.Ammonia.getFluid(6000))
                .outputItems(TagPrefix.dust, GTEMaterials.Hexamethylenetetramine, 22)
                .outputFluids(GTMaterials.Water.getFluid(6000))
                .EUt(30)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("fluoroboric_acide"))
                .inputFluids(GTEMaterials.BoricAcid.getFluid(1000))
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(4000))
                .outputFluids(GTEMaterials.FluoroboricAcid.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(13000))
                .EUt(120)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("titanium_tetrafluoride"))
                .inputFluids(GTMaterials.TitaniumTetrachloride.getFluid(1000))
                .inputFluids(GTMaterials.Fluorine.getFluid(4000))
                .outputFluids(GTMaterials.Chlorine.getFluid(4000))
                .outputFluids(GTEMaterials.TitaniumTetrafluoride.getFluid(1000))
                .EUt(1920)
                .duration(800)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("isochloropropane"))
                .inputFluids(GTMaterials.Propane.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputFluids(GTEMaterials.Isochloropropane.getFluid(1000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .EUt(30)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("potash_dust"))
                .circuitMeta(1)
                .inputItems(TagPrefix.dust, GTMaterials.Potassium, 2)
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Potash, 3)
                .EUt(7)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("pyromellitic_dianhydride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Durene, 24)
                .inputFluids(GTMaterials.Oxygen.getFluid(12000))
                .outputItems(TagPrefix.dust, GTEMaterials.PyromelliticDianhydride, 18)
                .outputFluids(GTMaterials.Water.getFluid(6000))
                .EUt(120)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("uranium_sulfate_waste_solution"))
                .inputItems(TagPrefix.dustImpure, GTMaterials.Uraninite)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Uraninite)
                .outputFluids(GTEMaterials.UraniumSulfateWasteSolution.getFluid(1000))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("quantum_dots"))
                .inputItems(TagPrefix.dust, GTMaterials.Selenium)
                .inputItems(TagPrefix.dust, GTMaterials.Cadmium)
                .inputFluids(GTEMaterials.StearicAcid.getFluid(1000))
                .inputFluids(GTEMaterials.Tricotylphosphine.getFluid(1000))
                .outputFluids(GTEMaterials.QuantumDots.getFluid(1000))
                .EUt(5000000)
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("benzyl_chloride"))
                .notConsumable(GTItems.BLACKLIGHT.asItem())
                .inputFluids(GTMaterials.Toluene.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputFluids(GTEMaterials.BenzylChloride.getFluid(1000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hafnium_chloride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.HafniumOxide, 3)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon)
                .inputFluids(GTMaterials.Chlorine.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.HafniumChloride, 5)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(1000))
                .EUt(120)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("acetylene"))
                .inputItems(TagPrefix.dust, GTEMaterials.CalciumCarbide, 3)
                .inputFluids(GTMaterials.Water.getFluid(2000))
                .outputItems(TagPrefix.dust, GTMaterials.CalciumHydroxide, 5)
                .outputFluids(GTEMaterials.Acetylene.getFluid(1000))
                .EUt(7)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dibromomethylbenzene"))
                .inputFluids(GTMaterials.Bromine.getFluid(2000))
                .inputFluids(GTMaterials.Toluene.getFluid(1000))
                .outputFluids(GTEMaterials.Dibromomethylbenzene.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .EUt(30)
                .duration(600)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tungsten_trioxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.TungstenCarbide, 2)
                .inputFluids(GTMaterials.Oxygen.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.TungstenTrioxide, 4)
                .outputFluids(GTMaterials.CarbonMonoxide.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("lithium_thiinediselenide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Selenium, 2)
                .inputFluids(GTEMaterials.Bromodihydrothiine.getFluid(1000))
                .inputFluids(GTEMaterials.ButylLithium.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.LithiumThiinediselenide, 14)
                .outputFluids(GTEMaterials.Bromobutane.getFluid(2000))
                .EUt(30720)
                .duration(290)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethylamine"))
                .notConsumable(TagPrefix.dust, GTEMaterials.SodiumAzanide)
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTMaterials.Ethylene.getFluid(1000))
                .outputFluids(GTEMaterials.Ethylamine.getFluid(1000))
                .EUt(480)
                .duration(130)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dibismuthhydroborat_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Bismuth, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Boron)
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.DibismuthHydroborate, 4)
                .EUt(90)
                .duration(590)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_cyanide"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium, 2)
                .inputFluids(GTMaterials.HydrogenCyanide.getFluid(2000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputFluids(GTEMaterials.SodiumCyanide.getFluid(2000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(1920)
                .duration(12)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("boron_fluoride"))
                .inputItems(TagPrefix.dust, GTEMaterials.BoronTrioxide, 5)
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(6000))
                .outputFluids(GTEMaterials.BoronFluoride.getFluid(2000))
                .EUt(480)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("zirconium_hafnium_chloride"))
                .inputItems(TagPrefix.dust, GTEMaterials.Zircon, 6)
                .inputFluids(GTMaterials.Chlorine.getFluid(8000))
                .outputFluids(GTEMaterials.ZirconiumHafniumChloride.getFluid(1000))
                .outputFluids(GTEMaterials.ZirconChlorinatingResidue.getFluid(1000))
                .EUt(120)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("benzenediazonium_tetrafluoroborate"))
                .inputItems(TagPrefix.dust, GTMaterials.SodiumNitrite, 4)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.FluoroboricAcid.getFluid(2000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .outputFluids(GTEMaterials.BenzenediazoniumTetrafluoroborate.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(30720)
                .duration(130)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("californium_cyclopentadienide"))
                .inputItems(TagPrefix.dust, GTEMaterials.CaliforniumTrichloride, 4)
                .inputFluids(GTEMaterials.LithiumCyclopentadienide.getFluid(3000))
                .outputFluids(GTEMaterials.CaliforniumCyclopentadienide.getFluid(1000))
                .EUt(2000000)
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("succinic_anhydride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SuccinicAcid, 14)
                .inputFluids(GTMaterials.AceticAnhydride.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SuccinicAnhydride, 11)
                .outputFluids(GTMaterials.AceticAcid.getFluid(2000))
                .EUt(7680)
                .duration(20)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tetrahydrofuran"))
                .inputFluids(GTMaterials.Hydrogen.getFluid(4000))
                .inputFluids(GTMaterials.Formaldehyde.getFluid(2000))
                .inputFluids(GTEMaterials.Acetylene.getFluid(1000))
                .outputFluids(GTEMaterials.Tetrahydrofuran.getFluid(1000))
                .EUt(7680)
                .duration(75)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_hydroxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 2)
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(30)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("fluorotoluene"))
                .notConsumable(GTItems.BLACKLIGHT.asItem())
                .inputFluids(GTMaterials.FluoroantimonicAcid.getFluid(1000))
                .inputFluids(GTMaterials.Methane.getFluid(1000))
                .inputFluids(GTEMaterials.FluoroBenzene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.AntimonyTrifluoride, 4)
                .outputFluids(GTEMaterials.Fluorotoluene.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(4000))
                .EUt(480)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("antimony_trifluoride_dust_a"))
                .inputItems(TagPrefix.dust, GTEMaterials.AntimonyTrichloride, 4)
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(3000))
                .outputItems(TagPrefix.dust, GTMaterials.AntimonyTrifluoride, 4)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(3000))
                .EUt(480)
                .duration(210)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hydrobromic_acid"))
                .inputFluids(GTMaterials.Bromine.getFluid(1000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .outputFluids(GTEMaterials.HydrobromicAcid.getFluid(1000))
                .EUt(480)
                .duration(300)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("acrylic_acid"))
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 3)
                .inputFluids(GTMaterials.AllylChloride.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .outputFluids(GTEMaterials.AcrylicAcid.getFluid(1000))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("n_hydroxysuccinimide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium, 6)
                .inputItems(TagPrefix.dust, GTEMaterials.SuccinicAnhydride, 66)
                .inputFluids(GTMaterials.Methanol.getFluid(40000))
                .inputFluids(GTMaterials.Toluene.getFluid(6000))
                .inputFluids(GTEMaterials.HydroxylamineHydrochloride.getFluid(6000))
                .outputItems(TagPrefix.dust, GTEMaterials.NHydroxysuccinimide, 13)
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 12)
                .outputFluids(GTMaterials.Water.getFluid(6000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(6000))
                .EUt(1920)
                .duration(220)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("caesium_iodide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Caesium)
                .inputItems(TagPrefix.dust, GTMaterials.Iodine)
                .outputItems(TagPrefix.dust, GTEMaterials.CaesiumIodide, 2)
                .EUt(30)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethyleneglycol"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.EthyleneOxide.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTEMaterials.EthyleneGlycol.getFluid(1000))
                .EUt(480)
                .duration(300)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("butane_1_4_diol"))
                .inputItems(GTETagPrefix.CATALYST, GTEMaterials.MolybdenumTrioxide)
                .inputItems(TagPrefix.dust, GTEMaterials.TelluriumOxide, 3)
                .inputFluids(GTMaterials.Butane.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Tellurium)
                .outputFluids(GTEMaterials.Butane14Diol.getFluid(1000))
                .EUt(1920)
                .duration(20)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("thionyl_chloride"))
                .inputItems(TagPrefix.dust, GTMaterials.Sulfur)
                .inputFluids(GTMaterials.SulfurTrioxide.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputFluids(GTEMaterials.ThionylChloride.getFluid(1000))
                .outputFluids(GTMaterials.SulfurDioxide.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("bromo_succinimide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Succinimide, 12)
                .inputFluids(GTMaterials.Bromine.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.BromoSuccinamide, 12)
                .outputFluids(GTEMaterials.HydrobromicAcid.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("perfluorobenzene"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Rhenium)
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumFluoride, 12)
                .inputFluids(GTMaterials.Benzene.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(6000))
                .outputItems(TagPrefix.dust, GTMaterials.RockSalt, 12)
                .outputFluids(GTEMaterials.Perfluorobenzene.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(6000))
                .EUt(120)
                .duration(185)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_nitrite_dust"))
                .inputItems(GTETagPrefix.CATALYST, GTEMaterials.CoAcAbCatalyst)
                .inputFluids(GTEMaterials.SodiumNitrateSolution.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.SodiumNitrite, 4)
                .outputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(30)
                .duration(300)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("antimony_pentafluoride"))
                .inputItems(TagPrefix.dust, GTMaterials.AntimonyTrifluoride, 4)
                .inputFluids(GTMaterials.Fluorine.getFluid(2000))
                .outputFluids(GTEMaterials.AntimonyPentafluoride.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("rhenium_dust"))
                .inputFluids(GTEMaterials.AmmoniumPerrhenate.getFluid(1000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(7000))
                .outputItems(TagPrefix.dust, GTMaterials.Rhenium)
                .outputFluids(GTMaterials.Ammonia.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(4000))
                .EUt(1920)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethyl_acrylate"))
                .inputFluids(GTEMaterials.AcrylicAcid.getFluid(1000))
                .inputFluids(GTMaterials.Ethanol.getFluid(1000))
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.EthylAcrylate.getFluid(1000))
                .outputFluids(GTMaterials.DilutedSulfuricAcid.getFluid(1000))
                .EUt(120)
                .duration(600)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("iodine_monochloride"))
                .inputItems(TagPrefix.dust, GTMaterials.Iodine)
                .inputFluids(GTMaterials.Chlorine.getFluid(1000))
                .outputFluids(GTEMaterials.IodineMonochloride.getFluid(1000))
                .EUt(120)
                .duration(260)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("methylamine"))
                .circuitMeta(1)
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTMaterials.Methanol.getFluid(1000))
                .outputFluids(GTEMaterials.Methylamine.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(1920)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_toluenesulfonate"))
                .inputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Toluene.getFluid(1000))
                .outputFluids(GTEMaterials.SodiumToluenesulfonate.getFluid(1000))
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(1000))
                .EUt(950)
                .duration(220)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("acetyl_chloride"))
                .inputFluids(GTMaterials.Ethenone.getFluid(1000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.AcetylChloride.getFluid(1000))
                .EUt(120)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("potassium_hydroxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Potassium)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.PotassiumHydroxide, 2)
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(30)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("silver_tetrafluoroborate"))
                .inputItems(TagPrefix.dust, GTMaterials.Silver, 6)
                .inputFluids(GTEMaterials.BoronFluoride.getFluid(2000))
                .inputFluids(GTMaterials.Oxygen.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.BoronTrioxide, 5)
                .outputFluids(GTEMaterials.SilverTetrafluoroborate.getFluid(6000))
                .EUt(122880)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dichloromethane"))
                .inputFluids(GTMaterials.Chloromethane.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputFluids(GTEMaterials.Dichloromethane.getFluid(1000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .EUt(30)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("acrylonitrile"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Platinum)
                .inputFluids(GTMaterials.Oxygen.getFluid(3000))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTMaterials.Propene.getFluid(1000))
                .outputFluids(GTEMaterials.Acrylonitrile.getFluid(2000))
                .outputFluids(GTMaterials.Water.getFluid(3000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tetraethylammonium_bromide"))
                .inputFluids(GTMaterials.Ethylene.getFluid(4000))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTEMaterials.HydrobromicAcid.getFluid(1000))
                .outputFluids(GTEMaterials.TetraethylammoniumBromide.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("actinium_oxalate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Actinium)
                .inputFluids(GTEMaterials.OxalicAcid.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.ActiniumOxalate, 13)
                .EUt(1920)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("n_difluorophenylpyrrole"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.PhosphorusPentoxide)
                .inputFluids(GTEMaterials.Succinaldehyde.getFluid(1000))
                .inputFluids(GTEMaterials.Difluoroaniline.getFluid(1000))
                .outputFluids(GTEMaterials.NDifluorophenylpyrrole.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(480)
                .duration(180)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("aluminium_hydride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium)
                .inputFluids(GTMaterials.Hydrogen.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.AluminiumHydride, 4)
                .EUt(30)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("borane_dimethyl_sulfide"))
                .inputFluids(GTEMaterials.Diborane.getFluid(1000))
                .inputFluids(GTEMaterials.DimethylSulfide.getFluid(2000))
                .outputFluids(GTEMaterials.BoraneDimethylSulfide.getFluid(2000))
                .EUt(125)
                .duration(165)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("highly_reflective_mirror"))
                .inputItems(TagPrefix.plate, GTMaterials.Germanium)
                .inputFluids(GTMaterials.HydrogenSulfide.getFluid(1000))
                .inputFluids(GTMaterials.Zinc.getFluid(144))
                .outputItems(GTEItems.HIGHLY_REFLECTIVE_MIRROR.asItem())
                .EUt(710000)
                .duration(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hydroiodic_acid"))
                .inputItems(TagPrefix.dust, GTMaterials.Iodine, 4)
                .inputFluids(GTEMaterials.Monomethylhydrazine.getFluid(1000))
                .outputFluids(GTMaterials.Nitrogen.getFluid(2000))
                .outputFluids(GTEMaterials.HydroiodicAcid.getFluid(4000))
                .EUt(500)
                .duration(210)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("soap_2"))
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 3)
                .inputFluids(GTMaterials.Steam.getFluid(2000))
                .inputFluids(GTMaterials.SeedOil.getFluid(100))
                .outputFluids(GTEMaterials.Soap.getFluid(1000))
                .EUt(2000)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("soap_1"))
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 3)
                .inputFluids(GTMaterials.Steam.getFluid(2000))
                .inputFluids(GTMaterials.FishOil.getFluid(100))
                .outputFluids(GTEMaterials.Soap.getFluid(1000))
                .EUt(2000)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tert_butanol"))
                .notConsumable(TagPrefix.dust, GTMaterials.MagnesiumChloride)
                .inputItems(TagPrefix.dust, GTEMaterials.ZeoliteSievingPellets)
                .inputFluids(GTMaterials.Methane.getFluid(1000))
                .inputFluids(GTMaterials.Acetone.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.WetZeoliteSievingPellets)
                .outputFluids(GTEMaterials.TertButanol.getFluid(1000))
                .EUt(120)
                .duration(126)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_oxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium, 2)
                .circuitMeta(1)
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumOxide, 3)
                .EUt(7)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("titanium_50_tetrachloride"))
                .inputFluids(GTEMaterials.Titanium50Tetrafluoride.getFluid(1000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .outputFluids(GTMaterials.HydrofluoricAcid.getFluid(4000))
                .outputFluids(GTEMaterials.Titanium50Tetrachloride.getFluid(1000))
                .EUt(480)
                .duration(400)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("crude_hexanitrohexaaxaisowurtzitane_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Tetraacetyldinitrosohexaazaisowurtzitane, 46)
                .inputItems(TagPrefix.dust, GTEMaterials.NitroniumTetrafluoroborate, 48)
                .inputFluids(GTMaterials.Water.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.CrudeHexanitrohexaaxaisowurtzitane, 36)
                .outputItems(TagPrefix.dust, GTEMaterials.NitrosoniumTetrafluoroborate, 14)
                .outputFluids(GTEMaterials.FluoroboricAcid.getFluid(4000))
                .outputFluids(GTMaterials.AceticAcid.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("prasiolite_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Silicon, 5)
                .inputItems(TagPrefix.dust, GTMaterials.Iron)
                .inputFluids(GTMaterials.Oxygen.getFluid(10000))
                .outputItems(TagPrefix.dust, GTEMaterials.Prasiolite)
                .EUt(480)
                .duration(270)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ditertbutyl_dicarbonate_dust"))
                .notConsumableFluid(GTEMaterials.SodiumToluenesulfonate.getFluid(1000))
                .inputFluids(GTEMaterials.TertButanol.getFluid(2000))
                .inputFluids(GTMaterials.CarbonDioxide.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.DitertbutylDicarbonate, 33)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(480)
                .duration(260)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("potassium_hydroxylaminedisulfonate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumBisulfite, 12)
                .inputFluids(GTEMaterials.NitrousAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PotassiumHydroxylaminedisulfonate, 13)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethylanthrahydroquinone"))
                .inputFluids(GTEMaterials.Ethylanthraquinone.getFluid(1000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .outputFluids(GTEMaterials.Ethylanthrahydroquinone.getFluid(1000))
                .EUt(30)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethylene_oxide"))
                .circuitMeta(4)
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .inputFluids(GTMaterials.Ethylene.getFluid(1000))
                .outputFluids(GTEMaterials.EthyleneOxide.getFluid(1000))
                .EUt(480)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("silver_nitrate_dust_chemical_compound"))
                .inputItems(TagPrefix.dust, GTEMaterials.SilverOxide, 3)
                .inputFluids(GTMaterials.NitricAcid.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.SilverNitrate, 10)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(125)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hydroxylammonium_sulfate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumHydroxylaminedisulfonate, 26)
                .inputFluids(GTMaterials.Water.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.HydroxylammoniumSulfate, 17)
                .outputItems(TagPrefix.dust, GTMaterials.PotassiumSulfate, 14)
                .outputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("diborane"))
                .inputItems(TagPrefix.dust, GTEMaterials.LithiumAluminiumHydride, 18)
                .inputFluids(GTEMaterials.BoronFluoride.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.LithiumAluminiumFluoride, 18)
                .outputFluids(GTEMaterials.Diborane.getFluid(2000))
                .EUt(30)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("fuming_nitric_acid"))
                .inputFluids(GTMaterials.NitrogenDioxide.getFluid(1000))
                .inputFluids(GTMaterials.NitricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.FumingNitricAcid.getFluid(1000))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethylanthraquinone"))
                .inputItems(TagPrefix.dust, GTEMaterials.PhthalicAnhydride, 15)
                .inputFluids(GTMaterials.Ethylbenzene.getFluid(1000))
                .outputFluids(GTEMaterials.Ethylanthraquinone.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(480)
                .duration(800)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("succinic_acid_dust"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.RhodiumPlatedPalladium)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .inputFluids(GTEMaterials.MaleicAnhydride.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.SuccinicAcid, 14)
                .EUt(1920)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("lithium_chloride_dust"))
                .circuitMeta(1)
                .inputItems(TagPrefix.dust, GTMaterials.Lithium)
                .inputFluids(GTMaterials.Chlorine.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.LithiumChloride, 2)
                .EUt(120)
                .duration(125)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("carbon_tetrachloride"))
                .circuitMeta(4)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon)
                .inputFluids(GTMaterials.Chlorine.getFluid(4000))
                .outputFluids(GTEMaterials.CarbonTetrachloride.getFluid(1000))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dimethylnaphthalene"))
                .inputFluids(GTMaterials.Methanol.getFluid(2000))
                .inputFluids(GTMaterials.Naphthalene.getFluid(1000))
                .outputFluids(GTEMaterials.Dimethylnaphthalene.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("titanium_tetrachloride_1"))
                .inputItems(TagPrefix.dust, GTMaterials.Titanium)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(4000))
                .outputFluids(GTMaterials.TitaniumTetrachloride.getFluid(1000))
                .EUt(480)
                .duration(400)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_ethylxanthate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylate, 9)
                .inputFluids(GTMaterials.Ethanol.getFluid(1000))
                .inputFluids(GTEMaterials.CarbonDisulfide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumEthylxanthate, 12)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(480)
                .duration(40)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("succinimidyl_acetate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.NHydroxysuccinimide, 13)
                .inputFluids(GTMaterials.AceticAnhydride.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SuccinamidylAcetate, 18)
                .outputFluids(GTMaterials.AceticAcid.getFluid(1000))
                .EUt(7680)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_hydride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium)
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumHydride, 2)
                .EUt(30)
                .duration(140)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("boron_francium_carbide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.FranciumCarbide, 8)
                .inputItems(TagPrefix.dust, GTEMaterials.BoronCarbide, 7)
                .outputItems(TagPrefix.dust, GTEMaterials.BoronFranciumCarbide, 15)
                .EUt(7680)
                .duration(900)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("p_nitroaniline"))
                .notConsumableFluid(GTMaterials.AceticAnhydride.getFluid(1000))
                .inputFluids(GTEMaterials.Aniline.getFluid(1000))
                .inputFluids(GTMaterials.NitrationMixture.getFluid(2000))
                .outputFluids(GTEMaterials.PNitroaniline.getFluid(1000))
                .outputFluids(GTMaterials.DilutedSulfuricAcid.getFluid(1000))
                .EUt(1920)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("attuned_tengam_ingot"))
                .inputItems(TagPrefix.dust, GTEMaterials.AttunedTengam)
                .inputItems(TagPrefix.dust, GTMaterials.SamariumMagnetic)
                .inputFluids(GTEMaterials.Infuscolium.getFluid(FluidStorageKeys.PLASMA, 144))
                .inputFluids(GTMaterials.Nitrogen.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(TagPrefix.ingot, GTEMaterials.AttunedTengam)
                .EUt(7864320)
                .duration(1600)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("rare_earth_chlorides"))
                .inputFluids(GTEMaterials.RareEarthHydroxides.getFluid(1000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 3)
                .outputFluids(GTEMaterials.RareEarthChlorides.getFluid(1000))
                .EUt(30)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethanolamine"))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTEMaterials.EthyleneOxide.getFluid(1000))
                .outputFluids(GTEMaterials.Ethanolamine.getFluid(1000))
                .EUt(7680)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("aluminium_trifluoride_dust_a"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 6)
                .inputItems(TagPrefix.dust, GTEMaterials.AluminiumTrifluoride, 4)
                .outputFluids(GTEMaterials.SodiumHexafluoroaluminate.getFluid(1000))
                .EUt(120)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("oxydianiline"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Tin)
                .inputFluids(GTEMaterials.Aniline.getFluid(2000))
                .inputFluids(GTMaterials.Phenol.getFluid(1000))
                .outputFluids(GTEMaterials.Oxydianiline.getFluid(1000))
                .outputFluids(GTMaterials.Methane.getFluid(2000))
                .EUt(120)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("maleic_anhydride"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Bismuth)
                .inputFluids(GTMaterials.Oxygen.getFluid(7000))
                .inputFluids(GTMaterials.Butane.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(4000))
                .outputFluids(GTEMaterials.MaleicAnhydride.getFluid(1000))
                .EUt(480)
                .duration(280)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("molybdenum_concentrate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.GoldDepletedMolybdenite, 3)
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(250))
                .outputItems(TagPrefix.dust, GTEMaterials.MolybdenumConcentrate, 4)
                .EUt(1920)
                .duration(10)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tungsten_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.TungstenTrioxide, 4)
                .inputFluids(GTMaterials.Hydrogen.getFluid(6000))
                .outputItems(TagPrefix.dust, GTMaterials.Tungsten)
                .outputFluids(GTMaterials.Water.getFluid(3000))
                .EUt(120)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("lithium_cyclopentadienide"))
                .inputFluids(GTEMaterials.ButylLithium.getFluid(1000))
                .inputFluids(GTEMaterials.Dimethoxyethane.getFluid(500))
                .inputFluids(GTEMaterials.Cyclopentadiene.getFluid(1000))
                .outputFluids(GTEMaterials.LithiumCyclopentadienide.getFluid(1000))
                .outputFluids(GTMaterials.Butane.getFluid(1000))
                .EUt(10000)
                .duration(460)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("barium_chloride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Barium, 6)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.BariumChloride, 3)
                .outputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .EUt(120)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("durene_dust"))
                .inputFluids(GTMaterials.Chloromethane.getFluid(2000))
                .inputFluids(GTMaterials.Dimethylbenzene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Durene, 24)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .EUt(120)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethylenediamine"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Palladium)
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTEMaterials.Ethanolamine.getFluid(1000))
                .outputFluids(GTEMaterials.Ethylenediamine.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(180)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("boric_acide"))
                .inputItems(TagPrefix.dust, GTMaterials.Borax, 23)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 4)
                .outputFluids(GTEMaterials.BoricAcid.getFluid(4000))
                .outputFluids(GTMaterials.Water.getFluid(5000))
                .EUt(120)
                .duration(150)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_thiocyanate"))
                .inputItems(TagPrefix.dust, GTMaterials.Sulfur)
                .inputFluids(GTEMaterials.SodiumCyanide.getFluid(1000))
                .outputFluids(GTEMaterials.SodiumThiocyanate.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("terephthalicacid"))
                .notConsumable(TagPrefix.dust, GTMaterials.Cadmium)
                .notConsumable(TagPrefix.dust, GTMaterials.SodiumBisulfate)
                .notConsumableFluid(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTMaterials.PhthalicAcid.getFluid(1000))
                .outputFluids(GTEMaterials.TerephthalicAcid.getFluid(1000))
                .EUt(480)
                .duration(800)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("silver_chloride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Silver)
                .inputFluids(GTMaterials.Chlorine.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SilverChloride, 2)
                .EUt(120)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("pyridine"))
                .inputFluids(GTMaterials.Formaldehyde.getFluid(2000))
                .inputFluids(GTEMaterials.Acetaldehyde.getFluid(1000))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .outputFluids(GTEMaterials.Pyridine.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .EUt(1920)
                .duration(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("germanium_tetrachloride_solution"))
                .inputItems(TagPrefix.dust, GTEMaterials.GermaniumAsh, 2)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .outputFluids(GTEMaterials.GermaniumTetrachlorideSolution.getFluid(1000))
                .EUt(120)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hydrogen_peroxide"))
                .notConsumableFluid(GTEMaterials.Anthracene.getFluid(1000))
                .inputFluids(GTEMaterials.Ethylanthrahydroquinone.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(2000))
                .outputFluids(GTMaterials.HydrogenPeroxide.getFluid(1000))
                .outputFluids(GTEMaterials.Ethylanthraquinone.getFluid(1000))
                .EUt(480)
                .duration(600)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("krypton_difluoride"))
                .notConsumable(GTItems.BLACKLIGHT.asItem())
                .inputFluids(GTMaterials.Fluorine.getFluid(2000))
                .inputFluids(GTMaterials.Krypton.getFluid(1000))
                .outputFluids(GTEMaterials.KryptonDifluoride.getFluid(1000))
                .EUt(480)
                .duration(190)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_azanide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium)
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumAzanide, 4)
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(120)
                .duration(110)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("cyclooctadiene"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Nickel)
                .inputFluids(GTMaterials.Butadiene.getFluid(2000))
                .outputFluids(GTEMaterials.Cyclooctadiene.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("phosphorus_trichloride"))
                .inputItems(TagPrefix.dust, GTMaterials.Phosphorus)
                .inputFluids(GTMaterials.Chlorine.getFluid(3000))
                .outputFluids(GTEMaterials.PhosphorusTrichloride.getFluid(1000))
                .EUt(30)
                .duration(60)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dimethylterephthalate"))
                .inputFluids(GTEMaterials.TerephthalicAcid.getFluid(1000))
                .inputFluids(GTMaterials.Methanol.getFluid(2000))
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(2000))
                .outputFluids(GTEMaterials.DimethylTerephthalate.getFluid(1000))
                .outputFluids(GTMaterials.DilutedSulfuricAcid.getFluid(2000))
                .EUt(480)
                .duration(210)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dimethylether"))
                .notConsumable(TagPrefix.dust, GTMaterials.SiliconDioxide)
                .inputFluids(GTMaterials.Methanol.getFluid(2000))
                .outputFluids(GTEMaterials.Dimethylether.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(8000)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("nmethylpyrolidone"))
                .inputFluids(GTEMaterials.GammaButyrolactone.getFluid(1000))
                .inputFluids(GTEMaterials.Methylamine.getFluid(1000))
                .outputFluids(GTEMaterials.NMPyrolidone.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(7680)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hexabenzylhexaazaisowurtzitane_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Acetonitrile, 6)
                .inputFluids(GTEMaterials.Benzylamine.getFluid(6000))
                .inputFluids(GTEMaterials.Glyoxal.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.Hexabenzylhexaazaisowurtzitane, 102)
                .EUt(7680)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dichlorodicyanobenzoquinone_1"))
                .inputFluids(GTMaterials.HydrogenPeroxide.getFluid(1000))
                .inputFluids(GTEMaterials.Dichlorodicyanohydroquinone.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .outputFluids(GTEMaterials.Dichlorodicyanobenzoquinone.getFluid(1000))
                .EUt(480)
                .duration(250)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("trifluoroacetic_phosphate_ester_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylate, 9)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.EthyleneSulfide.getFluid(1000))
                .inputFluids(GTEMaterials.EthylTrifluoroacetate.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.TrifluoroaceticPhosphateEster, 4)
                .outputFluids(GTMaterials.Ethanol.getFluid(2000))
                .EUt(1920)
                .duration(220)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("selenium_oxide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SeleniumOxide, 3)
                .inputFluids(GTMaterials.SulfurDioxide.getFluid(2000))
                .outputItems(TagPrefix.dust, GTMaterials.Selenium)
                .outputFluids(GTMaterials.SulfurTrioxide.getFluid(2000))
                .EUt(120)
                .duration(260)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("isopropyl_alcohol"))
                .notConsumable(TagPrefix.dust, GTMaterials.Tungstate)
                .notConsumable(TagPrefix.dust, GTEMaterials.SodiumSeaborgate)
                .inputFluids(GTMaterials.Propene.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTEMaterials.IsopropylAlcohol.getFluid(1000))
                .EUt(480)
                .duration(400)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("calcium_chloride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Calcium)
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputItems(TagPrefix.dust, GTMaterials.CalciumChloride, 3)
                .EUt(30)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("nitronium_tetrafluoroborate_dust"))
                .inputFluids(GTEMaterials.BoronFluoride.getFluid(1000))
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(1000))
                .inputFluids(GTMaterials.NitricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.NitroniumTetrafluoroborate, 8)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(1920)
                .duration(40)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethylene_sulfide"))
                .inputItems(TagPrefix.dust, GTEMaterials.PhosphorusPentasulfide, 7)
                .inputFluids(GTEMaterials.AcetylChloride.getFluid(5000))
                .inputFluids(GTEMaterials.Succinaldehyde.getFluid(5000))
                .outputItems(TagPrefix.dust, GTMaterials.PhosphorusPentoxide, 7)
                .outputFluids(GTEMaterials.EthyleneSulfide.getFluid(5000))
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(10000))
                .EUt(480)
                .duration(210)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("potassium_ethylxanthate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylate, 3)
                .inputFluids(GTEMaterials.CarbonDisulfide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylxanthate, 12)
                .EUt(480)
                .duration(40)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tricotylphosphine"))
                .inputItems(TagPrefix.dust, GTMaterials.Phosphorus)
                .inputFluids(GTMaterials.Octane.getFluid(3000))
                .outputFluids(GTEMaterials.Tricotylphosphine.getFluid(1000))
                .EUt(2000)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("difluoroaniline"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 8)
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .inputFluids(GTMaterials.Dichlorobenzene.getFluid(1000))
                .inputFluids(GTMaterials.Nitrogen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 8)
                .outputFluids(GTEMaterials.Difluoroaniline.getFluid(2000))
                .EUt(7680)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_tetrafluoroborate_dust"))
                .circuitMeta(2)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumTetrafluoroborate, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 2)
                .outputFluids(GTEMaterials.BoronFluoride.getFluid(1000))
                .EUt(125)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("iodine_containing_slurry"))
                .inputFluids(GTMaterials.Chlorine.getFluid(1000))
                .inputFluids(GTEMaterials.EnrichedPotassiumIodideSlurry.getFluid(1000))
                .outputFluids(GTEMaterials.IodineContainingSlurry.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("deglycerated_soap"))
                .inputItems(TagPrefix.dust, GTMaterials.Salt)
                .inputFluids(GTEMaterials.Soap.getFluid(1000))
                .outputFluids(GTEMaterials.DeglyceratedSoap.getFluid(800))
                .outputFluids(GTMaterials.Glycerol.getFluid(200))
                .EUt(2000)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ferrocene"))
                .inputItems(TagPrefix.dust, GTEMaterials.ZeoliteSievingPellets)
                .inputFluids(GTMaterials.Iron2Chloride.getFluid(1000))
                .inputFluids(GTEMaterials.Cyclopentadiene.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.WetZeoliteSievingPellets)
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(2000))
                .outputFluids(GTEMaterials.Ferrocene.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("acetaldehyde"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.OsmiumTetroxide)
                .inputFluids(GTMaterials.Acetone.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputFluids(GTMaterials.Formaldehyde.getFluid(1000))
                .outputFluids(GTEMaterials.Acetaldehyde.getFluid(1000))
                .EUt(480)
                .duration(320)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("gammabutyrolactone"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Copper)
                .inputFluids(GTEMaterials.Butane14Diol.getFluid(1000))
                .outputFluids(GTEMaterials.GammaButyrolactone.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(4000))
                .EUt(1920)
                .duration(80)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_borohydride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumHydride, 8)
                .notConsumableFluid(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Ethanol.getFluid(3000))
                .inputFluids(GTEMaterials.BoricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumBorohydride, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumEthylate, 27)
                .outputFluids(GTMaterials.Water.getFluid(3000))
                .EUt(480)
                .duration(120)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("succinimide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SuccinicAcid, 14)
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Succinimide, 12)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("francium_carbide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Francium, 2)
                .inputFluids(GTEMaterials.Acetylene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.FranciumCarbide, 4)
                .outputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .EUt(480)
                .duration(260)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("trimethylsilane"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumHydride, 2)
                .inputFluids(GTEMaterials.Trimethylchlorosilane.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .outputFluids(GTEMaterials.Trimethylsilane.getFluid(1000))
                .EUt(1920)
                .duration(190)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hmxexplosive_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Hexamethylenetetramine, 22)
                .notConsumableFluid(GTMaterials.AceticAnhydride.getFluid(1000))
                .inputFluids(GTEMaterials.FumingNitricAcid.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.HmxExplosive)
                .EUt(1024)
                .duration(20)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("phenylsodium"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium, 2)
                .inputFluids(GTEMaterials.FluoroBenzene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 2)
                .outputFluids(GTEMaterials.Phenylsodium.getFluid(1000))
                .EUt(480)
                .duration(210)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_azide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumAzanide, 8)
                .inputFluids(GTMaterials.NitrogenDioxide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumAzide, 4)
                .outputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 3)
                .outputFluids(GTMaterials.Ammonia.getFluid(1000))
                .EUt(480)
                .duration(170)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dimethoxyethane"))
                .inputFluids(GTEMaterials.Dimethylether.getFluid(1000))
                .inputFluids(GTEMaterials.EthyleneOxide.getFluid(1000))
                .outputFluids(GTEMaterials.Dimethoxyethane.getFluid(1000))
                .EUt(2000)
                .duration(160)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("aluminium_chloride"))
                .circuitMeta(1)
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium)
                .inputFluids(GTMaterials.Chlorine.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.AluminiumChloride, 4)
                .EUt(120)
                .duration(300)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dibenzyltetraacetylhexaazaisowurtzitane_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SuccinamidylAcetate, 72)
                .inputItems(TagPrefix.dust, GTEMaterials.Hexabenzylhexaazaisowurtzitane, 102)
                .notConsumableFluid(GTEMaterials.HydrobromicAcid.getFluid(10000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(8000))
                .outputItems(TagPrefix.dust, GTEMaterials.Dibenzyltetraacetylhexaazaisowurtzitane, 70)
                .outputFluids(GTMaterials.Toluene.getFluid(6000))
                .EUt(122880)
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tetracene_dust"))
                .notConsumable(GTItems.BLACKLIGHT.asItem())
                .inputFluids(GTEMaterials.IsopropylAlcohol.getFluid(1000))
                .inputFluids(GTEMaterials.Dichlorodicyanobenzoquinone.getFluid(2000))
                .inputFluids(GTEMaterials.Dihydroiodotetracene.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.Tetracene, 60)
                .outputItems(TagPrefix.dust, GTMaterials.Iodine, 2)
                .outputFluids(GTEMaterials.Dichlorodicyanohydroquinone.getFluid(2000))
                .outputFluids(GTMaterials.Acetone.getFluid(1000))
                .EUt(491520)
                .duration(260)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("californium_trichloride_dust"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Ferrosilite)
                .inputItems(TagPrefix.dust, GTMaterials.Californium)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(6000))
                .outputItems(TagPrefix.dust, GTEMaterials.CaliforniumTrichloride, 4)
                .outputFluids(GTMaterials.Hydrogen.getFluid(3000))
                .EUt(7680)
                .duration(150)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("zirconium_oxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.AmmoniumChloride, 36)
                .inputItems(TagPrefix.dust, GTMaterials.PotassiumHydroxide, 9)
                .inputItems(TagPrefix.dust, GTMaterials.Hematite, 10)
                .inputFluids(GTEMaterials.ZirconiumHafniumOxychloride.getFluid(3000))
                .inputFluids(GTMaterials.SulfurTrioxide.getFluid(3000))
                .inputFluids(GTMaterials.HydrogenPeroxide.getFluid(6000))
                .outputItems(TagPrefix.dust, GTMaterials.PotassiumSulfate, 21)
                .outputItems(TagPrefix.dust, GTEMaterials.ZirconiumOxide, 3)
                .chancedOutput(TagPrefix.dust, GTEMaterials.HafniumOxide, 3, 8000, 0)
                .outputFluids(GTMaterials.Ammonia.getFluid(6000))
                .outputFluids(GTMaterials.Iron3Chloride.getFluid(4000))
                .EUt(1920)
                .duration(100)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("mutated_living_solder"))
                .notConsumable(GTItems.GRAVI_STAR.asItem())
                .inputItems(GTEItems.BIOLOGICAL_CELLS.asStack(16))
                .inputItems(GTItems.QUANTUM_STAR.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 2000))
                .inputFluids(GTMaterials.Oxygen.getFluid(FluidStorageKeys.PLASMA, 2000))
                .inputFluids(GTMaterials.Tin.getFluid(2000))
                .inputFluids(GTMaterials.Carbon.getFluid(2000))
                .inputFluids(GTMaterials.Beryllium.getFluid(2000))
                .outputItems(TagPrefix.dustTiny, GTMaterials.NetherStar, 4)
                .outputFluids(GTEMaterials.MutatedLivingSolder.getFluid(2000))
                .EUt(491520)
                .duration(1200)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("rhenium_hassium_thallium_isophtaloylbisdiethylthiourea_hexaf_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ThalliumChloride, 2)
                .inputItems(TagPrefix.dust, GTEMaterials.HassiumChloride, 5)
                .inputItems(TagPrefix.dust, GTEMaterials.RheniumChloride, 6)
                .inputFluids(GTEMaterials.HexafluorophosphoricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.IsophthaloylBis.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexaf, 125)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(7000))
                .outputFluids(GTMaterials.Chlorine.getFluid(3000))
                .EUt(31457280)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("aluminium_sulfite_dust"))
                .circuitMeta(24)
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium, 2)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(3000))
                .outputItems(TagPrefix.dust, GTMaterials.AluminiumSulfite, 14)
                .outputFluids(GTMaterials.Water.getFluid(3000))
                .EUt(30720)
                .duration(400)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tertbuthylcarbonylazide"))
                .inputItems(TagPrefix.dust, GTEMaterials.DitertbutylDicarbonate, 33)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumAzide, 8)
                .inputItems(TagPrefix.dust, GTMaterials.Potassium, 2)
                .outputItems(TagPrefix.dust, GTMaterials.Sodium, 2)
                .outputItems(TagPrefix.dust, GTMaterials.Potash, 6)
                .outputFluids(GTEMaterials.Tertbuthylcarbonylazide.getFluid(2000))
                .EUt(480)
                .duration(110)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("pentaerythritol_dust"))
                .notConsumable(TagPrefix.dust, GTMaterials.SodiumHydroxide)
                .inputFluids(GTMaterials.Formaldehyde.getFluid(4000))
                .inputFluids(GTEMaterials.Acetaldehyde.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Pentaerythritol, 21)
                .outputFluids(GTMaterials.CarbonMonoxide.getFluid(1000))
                .EUt(1920)
                .duration(1200)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("succinaldehyde"))
                .inputItems(TagPrefix.dust, GTEMaterials.SuccinicAcid, 14)
                .inputItems(TagPrefix.dust, GTEMaterials.LithiumAluminiumHydride, 4)
                .outputItems(TagPrefix.dust, GTMaterials.Lithium)
                .outputItems(TagPrefix.dust, GTMaterials.Aluminium)
                .outputFluids(GTEMaterials.Succinaldehyde.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(1920)
                .duration(600)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dichlorocyclooctadieneplatinium_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Platinum)
                .inputItems(TagPrefix.dust, GTMaterials.Potassium, 2)
                .inputFluids(GTMaterials.NitricAcid.getFluid(4000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .inputFluids(GTEMaterials.Cyclooctadiene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Dichlorocyclooctadieneplatinum, 23)
                .outputItems(TagPrefix.dust, GTMaterials.RockSalt, 4)
                .EUt(491520)
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("lithium_niobate_nanoparticles_dust"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Hafnium)
                .inputItems(TagPrefix.dust, GTMaterials.Lithium, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Niobium)
                .inputFluids(GTMaterials.Oxygen.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.LithiumNiobateNanoparticles, 6)
                .EUt(1966080)
                .duration(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("unfolded_fullerene_dust"))
                .inputItems(GTETagPrefix.CATALYST, GTEMaterials.TiAlChloride)
                .inputItems(TagPrefix.dust, GTEMaterials.BenzophenanthrenylAcetonitrile, 102)
                .outputItems(TagPrefix.dust, GTEMaterials.UnfoldedFullerene)
                .EUt(7680)
                .duration(250)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("trimethyltin_chloride"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Magnesium)
                .inputItems(TagPrefix.dust, GTMaterials.Tin)
                .inputFluids(GTMaterials.Methane.getFluid(3000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputFluids(GTEMaterials.TrimethylTinChloride.getFluid(1000))
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(2000))
                .EUt(30720)
                .duration(320)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("liquidcrystalkevlar"))
                .inputItems(TagPrefix.dust, GTMaterials.CalciumChloride)
                .inputItems(TagPrefix.dust, GTEMaterials.TerephthaloylChloride, 9)
                .inputItems(TagPrefix.dust, GTEMaterials.PPhenylenediamine, 9)
                .inputFluids(GTEMaterials.NMPyrolidone.getFluid(1000))
                .outputFluids(GTEMaterials.LiquidCrystalKevlar.getFluid(9000))
                .EUt(524288)
                .duration(160)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("toluene_diisocyanate"))
                .inputFluids(GTMaterials.NitricAcid.getFluid(2000))
                .inputFluids(GTEMaterials.Phosgene.getFluid(2000))
                .inputFluids(GTMaterials.Toluene.getFluid(1000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .outputFluids(GTEMaterials.TolueneDiisocyanate.getFluid(2000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .outputFluids(GTMaterials.Water.getFluid(6000))
                .EUt(480)
                .duration(130)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("vibranium_unstable"))
                .inputItems(TagPrefix.dust, GTEMaterials.Adamantine, 2)
                .inputFluids(GTEMaterials.BedrockGas.getFluid(1000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.IridiumChloride, 4)
                .outputFluids(GTEMaterials.VibraniumUnstable.getFluid(500))
                .outputFluids(GTEMaterials.RareEarthChlorides.getFluid(1000))
                .EUt(7864320)
                .duration(200)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("fluorocarborane_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CesiumCarborane, 50)
                .inputItems(TagPrefix.dust, GTEMaterials.SilverNitrate, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Iodine, 2)
                .inputFluids(GTEMaterials.Trimethylsilane.getFluid(1000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Fluorine.getFluid(44000))
                .outputItems(TagPrefix.dust, GTEMaterials.Fluorocarborane, 50)
                .outputItems(TagPrefix.dust, GTEMaterials.CaesiumNitrate, 10)
                .outputItems(TagPrefix.dust, GTEMaterials.SilverIodide, 4)
                .outputFluids(GTMaterials.HydrofluoricAcid.getFluid(22000))
                .outputFluids(GTEMaterials.Trimethylchlorosilane.getFluid(1000))
                .EUt(1920)
                .duration(320)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("ethyl_trifluoroacetate"))
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(3000))
                .inputFluids(GTEMaterials.AcetylChloride.getFluid(1000))
                .inputFluids(GTMaterials.Ethanol.getFluid(1000))
                .outputFluids(GTEMaterials.EthylTrifluoroacetate.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(6000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .EUt(480)
                .duration(230)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("decaborane_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumBorohydride, 51)
                .inputFluids(GTEMaterials.BoronTrifluorideAcetate.getFluid(10000))
                .inputFluids(GTMaterials.HydrogenPeroxide.getFluid(2000))
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Decaborane, 24)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumFluoride, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumTetrafluoroborate, 45)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(20000))
                .outputFluids(GTEMaterials.DiethylEther.getFluid(10000))
                .EUt(1920)
                .duration(380)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dibromoacrolein"))
                .inputFluids(GTMaterials.FormicAcid.getFluid(2000))
                .inputFluids(GTMaterials.Water.getFluid(2000))
                .inputFluids(GTMaterials.Bromine.getFluid(2000))
                .outputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 12)
                .outputFluids(GTEMaterials.Dibromoacrolein.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .EUt(7680)
                .duration(360)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("aminated_fullerene"))
                .inputItems(TagPrefix.dust, GTEMaterials.Fullerene)
                .inputFluids(GTMaterials.CarbonMonoxide.getFluid(4000))
                .inputFluids(GTMaterials.Water.getFluid(8000))
                .inputFluids(GTEMaterials.Tertbuthylcarbonylazide.getFluid(4000))
                .outputFluids(GTEMaterials.AminatedFullerene.getFluid(1000))
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(8000))
                .outputFluids(GTEMaterials.TertButanol.getFluid(4000))
                .EUt(30720)
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("cesium_carborane_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CesiumCarboranePrecursor, 38)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumHydride, 2)
                .notConsumableFluid(GTEMaterials.Tetrahydrofuran.getFluid(1000))
                .inputFluids(GTEMaterials.BoraneDimethylSulfide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.CesiumCarborane, 25)
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .outputFluids(GTEMaterials.Trimethylamine.getFluid(1000))
                .outputFluids(GTMaterials.HydrogenSulfide.getFluid(1000))
                .outputFluids(GTMaterials.Methane.getFluid(2000))
                .EUt(480)
                .duration(260)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("bromodihydrothiine"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumThiosulfate, 14)
                .inputFluids(GTMaterials.Ethane.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(1000))
                .inputFluids(GTEMaterials.Dibromoacrolein.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 4)
                .outputItems(TagPrefix.dust, GTMaterials.SodiumBisulfate, 14)
                .outputFluids(GTEMaterials.Bromodihydrothiine.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(7680)
                .duration(400)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("diiodobiphenyl_dust"))
                .notConsumable(GTItems.BLACKLIGHT.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Iodine, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Biphenyl, 22)
                .outputItems(TagPrefix.dust, GTEMaterials.Diiodobiphenyl, 22)
                .outputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .EUt(122880)
                .duration(200)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("terephthaloyl_chloride_dust"))
                .inputFluids(GTEMaterials.ThionylChloride.getFluid(20000))
                .inputFluids(GTEMaterials.DimethylTerephthalate.getFluid(5000))
                .inputFluids(GTMaterials.CarbonDioxide.getFluid(6000))
                .outputItems(TagPrefix.dust, GTEMaterials.TerephthaloylChloride, 64)
                .outputItems(TagPrefix.dust, GTEMaterials.TerephthaloylChloride, 48)
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(20000))
                .outputFluids(GTMaterials.SulfurDioxide.getFluid(20000))
                .EUt(1920)
                .duration(240)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dichlorodicyanobenzoquinone"))
                .inputFluids(GTMaterials.HydrogenCyanide.getFluid(2000))
                .inputFluids(GTMaterials.Chlorine.getFluid(10000))
                .inputFluids(GTMaterials.Phenol.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(8000))
                .outputFluids(GTEMaterials.Dichlorodicyanobenzoquinone.getFluid(1000))
                .EUt(30720)
                .duration(250)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dihydroiodotetracene"))
                .inputItems(GTETagPrefix.CATALYST, GTEMaterials.RhodiumRheniumNaquadahCatalyst)
                .inputItems(TagPrefix.dust, GTEMaterials.BromoSuccinamide, 12)
                .inputFluids(GTEMaterials.IodineMonochloride.getFluid(1000))
                .inputFluids(GTEMaterials.AcetylatingReagent.getFluid(1000))
                .inputFluids(GTEMaterials.Dimethylnaphthalene.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.MagnesiumChlorideBromide, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.Succinimide, 12)
                .outputFluids(GTEMaterials.Dihydroiodotetracene.getFluid(1000))
                .outputFluids(GTEMaterials.Trimethylchlorosilane.getFluid(1000))
                .outputFluids(GTEMaterials.HydrobromicAcid.getFluid(1000))
                .EUt(122880)
                .duration(350)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("phenylpentanoic_acid"))
                .notConsumableFluid(GTEMaterials.TrimethylTinChloride.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(2000))
                .inputFluids(GTEMaterials.HydroiodicAcid.getFluid(1000))
                .inputFluids(GTEMaterials.Acrylonitrile.getFluid(1000))
                .inputFluids(GTMaterials.Styrene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.AluminiumHydride, 4)
                .outputItems(TagPrefix.dust, GTEMaterials.LithiumIodide, 2)
                .outputFluids(GTEMaterials.PhenylPentanoicAcid.getFluid(1000))
                .outputFluids(GTMaterials.Ammonia.getFluid(1000))
                .EUt(8000000)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("saturated_fullerene_sieving_matrix"))
                .inputItems(GTEItems.SATURATED_FULLERENE_SIEVING_MATRIX.asItem())
                .inputFluids(GTEMaterials.KryptonDifluoride.getFluid(16000))
                .inputFluids(GTMaterials.FluoroantimonicAcid.getFluid(8000))
                .outputItems(TagPrefix.dust, GTMaterials.AntimonyTrifluoride, 32)
                .outputItems(TagPrefix.dust, GTEMaterials.Fluorocarborane, 50)
                .outputItems(TagPrefix.dust, GTEMaterials.Fullerene)
                .outputFluids(GTMaterials.Krypton.getFluid(16000))
                .outputFluids(GTEMaterials.HeavilyFluorinatedTriniumSolution.getFluid(8000))
                .EUt(122880)
                .duration(180)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("dinitrodipropanyloxybenzene"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumOxide, 3)
                .inputFluids(GTMaterials.AceticAnhydride.getFluid(1000))
                .inputFluids(GTEMaterials.Isochloropropane.getFluid(1000))
                .inputFluids(GTEMaterials.Resorcinol.getFluid(1000))
                .inputFluids(GTMaterials.Propene.getFluid(1000))
                .inputFluids(GTMaterials.NitricAcid.getFluid(2000))
                .outputFluids(GTEMaterials.Dinitrodipropanyloxybenzene.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .outputFluids(GTMaterials.AceticAcid.getFluid(2000))
                .EUt(7680)
                .duration(50)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hydrazine"))
                .inputFluids(GTMaterials.HydrogenPeroxide.getFluid(1000))
                .inputFluids(GTMaterials.Ammonia.getFluid(2000))
                .outputFluids(GTEMaterials.Hydrazine.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(30)
                .duration(320)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("adamantine_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.AdamantineCompounds, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Mirabilite, 17)
                .inputFluids(GTMaterials.NitrationMixture.getFluid(1000))
                .inputFluids(GTMaterials.AquaRegia.getFluid(2000))
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(100))
                .outputItems(TagPrefix.dust, GTEMaterials.Adamantine)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumNitrate, 5)
                .outputItems(TagPrefix.dust, GTMaterials.SodiumBisulfate, 7)
                .outputFluids(GTEMaterials.RareEarthChlorides.getFluid(1000))
                .EUt(7864320)
                .duration(400)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("pcbs"))
                .inputItems(TagPrefix.dust, GTEMaterials.Fullerene, 8)
                .inputItems(GTETagPrefix.CATALYST, GTEMaterials.DMAP)
                .inputFluids(GTEMaterials.PhenylPentanoicAcid.getFluid(8000))
                .inputFluids(GTEMaterials.Dichloromethane.getFluid(8000))
                .inputFluids(GTMaterials.Styrene.getFluid(7000))
                .inputFluids(GTMaterials.Chlorobenzene.getFluid(8000))
                .inputFluids(GTEMaterials.DimethylSulfide.getFluid(8000))
                .outputFluids(GTMaterials.Toluene.getFluid(8000))
                .outputFluids(GTMaterials.HydrogenSulfide.getFluid(8000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(24000))
                .outputFluids(GTEMaterials.PCBs.getFluid(8000))
                .EUt(31457280)
                .duration(80)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("benzylamine"))
                .inputItems(TagPrefix.dust, GTEMaterials.Hexamethylenetetramine, 22)
                .inputFluids(GTMaterials.Water.getFluid(6000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .inputFluids(GTEMaterials.BenzylChloride.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.AmmoniumChloride, 18)
                .outputFluids(GTEMaterials.Benzylamine.getFluid(1000))
                .outputFluids(GTMaterials.Formaldehyde.getFluid(6000))
                .EUt(7680)
                .duration(200)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("glyoxal"))
                .inputFluids(GTEMaterials.Acetaldehyde.getFluid(2000))
                .inputFluids(GTMaterials.NitricAcid.getFluid(2000))
                .outputFluids(GTMaterials.Water.getFluid(3000))
                .outputFluids(GTEMaterials.Glyoxal.getFluid(2000))
                .outputFluids(GTMaterials.NitrogenDioxide.getFluid(1000))
                .EUt(60)
                .duration(120)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("benzophenanthrenylacetonitrile_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Methylbenzophenanthrene, 33)
                .inputItems(TagPrefix.dust, GTEMaterials.BromoSuccinamide, 12)
                .inputItems(TagPrefix.dust, GTMaterials.PotassiumCyanide, 3)
                .outputItems(TagPrefix.dust, GTEMaterials.BenzophenanthrenylAcetonitrile, 34)
                .outputItems(TagPrefix.dust, GTEMaterials.Succinimide, 12)
                .outputItems(TagPrefix.dust, GTEMaterials.PotassiumBromide, 2)
                .EUt(1920)
                .duration(100)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("cesium_carborane_precursor_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Decaborane, 24)
                .inputItems(TagPrefix.dust, GTEMaterials.CaesiumHydroxide, 3)
                .notConsumableFluid(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Methanol.getFluid(3000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .inputFluids(GTEMaterials.SodiumCyanide.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.CesiumCarboranePrecursor, 38)
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .outputFluids(GTMaterials.Water.getFluid(4000))
                .EUt(480)
                .duration(240)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sodium_seaborgate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Seaborgium)
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 6)
                .inputFluids(GTMaterials.Fluorine.getFluid(6000))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumSeaborgate, 7)
                .outputFluids(GTMaterials.HydrofluoricAcid.getFluid(6000))
                .EUt(1966080)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("phenylenedioxydiacetic_acid"))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .inputFluids(GTMaterials.HydrogenPeroxide.getFluid(1000))
                .inputFluids(GTMaterials.Phenol.getFluid(1000))
                .inputFluids(GTMaterials.Ethenone.getFluid(2000))
                .inputFluids(GTMaterials.Chlorine.getFluid(4000))
                .outputFluids(GTEMaterials.PhenylenedioxydiaceticAcid.getFluid(1000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .EUt(122880)
                .duration(320)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hydroquinone"))
                .circuitMeta(2)
                .inputFluids(GTMaterials.Benzene.getFluid(2000))
                .inputFluids(GTMaterials.Oxygen.getFluid(5000))
                .inputFluids(GTMaterials.Propene.getFluid(1000))
                .outputFluids(GTEMaterials.Hydroquinone.getFluid(1000))
                .outputFluids(GTEMaterials.Resorcinol.getFluid(1000))
                .outputFluids(GTMaterials.Acetone.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("p_phenylenediamine_dust"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Palladium)
                .inputFluids(GTMaterials.NitrogenDioxide.getFluid(100))
                .inputFluids(GTMaterials.Hydrogen.getFluid(6000))
                .inputFluids(GTEMaterials.PNitroaniline.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PPhenylenediamine, 16)
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(122880)
                .duration(60)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("acetonitrile_dust"))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTMaterials.CarbonMonoxide.getFluid(2000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.Acetonitrile, 6)
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(1966080)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("terephthalaldehyde_dust"))
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.Dibromomethylbenzene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Terephthalaldehyde, 16)
                .outputFluids(GTMaterials.Bromine.getFluid(2000))
                .outputFluids(GTMaterials.HydrogenSulfide.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTMaterials.Oxygen.getFluid(1000))
                .EUt(7680)
                .duration(50)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("diphenylmethanediisocyanatemixture"))
                .inputFluids(GTEMaterials.DiaminodiphenylmethanMixture.getFluid(1000))
                .inputFluids(GTEMaterials.Phosgene.getFluid(2000))
                .outputFluids(GTEMaterials.DiphenylmethanediisocyanateMixture.getFluid(1000))
                .EUt(7680)
                .duration(600)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("barium_sulfide_dust"))
                .circuitMeta(24)
                .inputItems(TagPrefix.dust, GTMaterials.Barite, 6)
                .inputFluids(GTMaterials.Hydrogen.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.BariumSulfide, 2)
                .outputFluids(GTMaterials.Water.getFluid(4000))
                .EUt(30720)
                .duration(400)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("silver_perchlorate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SilverOxide, 3)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumPerchlorate, 12)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SilverPerchlorate, 12)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumOxide, 3)
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(1000))
                .EUt(480)
                .duration(350)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hydroxylamine_hydrochloride"))
                .inputItems(TagPrefix.dust, GTEMaterials.HydroxylammoniumSulfate, 17)
                .inputItems(TagPrefix.dust, GTEMaterials.BariumChloride, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Barite, 6)
                .outputFluids(GTEMaterials.HydroxylamineHydrochloride.getFluid(2000))
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("diethylthiourea"))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .inputFluids(GTEMaterials.Ethylamine.getFluid(2000))
                .inputFluids(GTEMaterials.SodiumThiocyanate.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .outputFluids(GTEMaterials.Diethylthiourea.getFluid(1000))
                .outputFluids(GTMaterials.Ammonia.getFluid(1000))
                .EUt(30720)
                .duration(210)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("acetylating_reagent"))
                .inputItems(TagPrefix.dust, GTMaterials.MagnesiumChloride, 6)
                .inputFluids(GTMaterials.Bromine.getFluid(2000))
                .inputFluids(GTEMaterials.Trimethylchlorosilane.getFluid(1000))
                .inputFluids(GTEMaterials.Acetylene.getFluid(3000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(3000))
                .outputFluids(GTMaterials.Chlorine.getFluid(2000))
                .outputFluids(GTEMaterials.AcetylatingReagent.getFluid(1000))
                .EUt(480)
                .duration(350)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("siliconoil"))
                .inputFluids(GTEMaterials.EthyleneOxide.getFluid(1000))
                .inputFluids(GTMaterials.Dimethyldichlorosilane.getFluid(4000))
                .inputFluids(GTMaterials.DistilledWater.getFluid(5000))
                .outputFluids(GTEMaterials.SiliconOil.getFluid(5000))
                .EUt(480)
                .duration(1000)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("cosmic_computing_mixture"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Vibranium)
                .inputFluids(GTEMaterials.Gluons.getFluid(1000))
                .inputFluids(GTEMaterials.HeavyQuarks.getFluid(1000))
                .inputFluids(GTEMaterials.HeavyLeptonMixture.getFluid(1000))
                .outputFluids(GTEMaterials.CosmicComputingMixture.getFluid(3000))
                .EUt(24000000)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("cycloparaphenylene"))
                .inputItems(TagPrefix.dust, GTEMaterials.Dichlorocyclooctadieneplatinum, 23)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 8)
                .inputItems(TagPrefix.dust, GTEMaterials.Diiodobiphenyl, 4)
                .inputFluids(GTEMaterials.TrimethylTinChloride.getFluid(4000))
                .inputFluids(GTEMaterials.SilverTetrafluoroborate.getFluid(6000))
                .outputItems(TagPrefix.dust, GTMaterials.PlatinumRaw, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Silver, 6)
                .outputFluids(GTEMaterials.Cycloparaphenylene.getFluid(10000))
                .outputFluids(GTEMaterials.BoronFluoride.getFluid(2000))
                .outputFluids(GTEMaterials.OneOctene.getFluid(3000))
                .outputFluids(GTMaterials.HydrofluoricAcid.getFluid(6000))
                .EUt(1966080)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("bismuth_nitrate_solution"))
                .inputItems(TagPrefix.dust, GTMaterials.Bismuth)
                .inputFluids(GTMaterials.NitricAcid.getFluid(6000))
                .outputFluids(GTEMaterials.BismuthNitrateSolution.getFluid(1000))
                .outputFluids(GTMaterials.NitrogenDioxide.getFluid(3000))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(30)
                .duration(350)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("methylbenzophenanthrene_dust"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Iodine)
                .inputFluids(GTMaterials.Naphthalene.getFluid(1000))
                .inputFluids(GTMaterials.Formaldehyde.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .inputFluids(GTMaterials.Ethylbenzene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Methylbenzophenanthrene, 33)
                .EUt(1920)
                .duration(600)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("hexafluorophosphoric_acid"))
                .inputFluids(GTEMaterials.AntimonyPentafluoride.getFluid(1000))
                .inputFluids(GTEMaterials.PhosphorusTrichloride.getFluid(1000))
                .inputFluids(GTMaterials.HydrofluoricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.AntimonyTrichloride, 4)
                .outputFluids(GTEMaterials.HexafluorophosphoricAcid.getFluid(1000))
                .EUt(30720)
                .duration(280)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("difluorobenzophenone_dust"))
                .inputItems(GTETagPrefix.CATALYST, GTEMaterials.ZnFeAlClCatalyst)
                .inputFluids(GTEMaterials.Fluorotoluene.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(6000))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .inputFluids(GTEMaterials.FluoroBenzene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Difluorobenzophenone, 24)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(6000))
                .EUt(1920)
                .duration(100)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("palladium_fullerene_matrix_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Sarcosine, 13)
                .inputItems(TagPrefix.dust, GTEMaterials.Fullerene)
                .inputItems(TagPrefix.dust, GTMaterials.Palladium)
                .inputFluids(GTEMaterials.Ferrocene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PalladiumFullereneMatrix)
                .EUt(31457280)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("glycerol_a"))
                .circuitMeta(1)
                .notConsumable(TagPrefix.dust, GTMaterials.SodaAsh)
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 3)
                .notConsumableFluid(GTMaterials.CarbonDioxide.getFluid(10000))
                .inputFluids(GTMaterials.Epichlorohydrin.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(2000))
                .outputFluids(GTMaterials.Glycerol.getFluid(1000))
                .outputFluids(GTMaterials.SaltWater.getFluid(1000))
                .EUt(7680)
                .duration(150)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("cyclopentadienyl_titanium_trichloride_dust"))
                .inputFluids(GTMaterials.TitaniumTetrachloride.getFluid(1000))
                .inputFluids(GTEMaterials.Propadiene.getFluid(2000))
                .inputFluids(GTEMaterials.Acetylene.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.CyclopentadienylTitaniumTrichloride, 23)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .EUt(7680)
                .duration(780)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("cosmic_superconductor"))
                .inputItems(TagPrefix.dust, GTEMaterials.RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexaf, 125)
                .inputItems(TagPrefix.dust, GTEMaterials.ActiniumSuperhydride, 39)
                .inputItems(TagPrefix.dust, GTEMaterials.ChargedCaesiumCeriumCobaltIndium, 14)
                .inputFluids(GTEMaterials.LightQuarks.getFluid(10000))
                .inputFluids(GTEMaterials.FreeAlphaGas.getFluid(1000))
                .outputFluids(GTEMaterials.CosmicSuperconductor.getFluid(10000))
                .EUt(125829120)
                .duration(600)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("stellar_energy_rocket_fuel"))
                .inputItems(TagPrefix.dust, GTMaterials.NaquadahEnriched)
                .inputItems(TagPrefix.dust, GTEMaterials.HmxExplosive, 2)
                .inputFluids(GTEMaterials.RocketFuelCn3h7o3.getFluid(2000))
                .inputFluids(GTEMaterials.ExplosiveHydrazine.getFluid(3000))
                .inputFluids(GTMaterials.Nitrobenzene.getFluid(8000))
                .inputFluids(GTMaterials.DinitrogenTetroxide.getFluid(6000))
                .inputFluids(GTEMaterials.Kerosene.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Naquadah)
                .outputFluids(GTEMaterials.StellarEnergyRocketFuel.getFluid(5000))
                .EUt(122880)
                .duration(120)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("charged_lepton_trap_crystal"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Starmetal)
                .inputItems(GTEItems.LEPTON_TRAP_CRYSTAL.asItem())
                .inputItems(TagPrefix.dustSmall, GTEMaterials.Vibranium, 2)
                .inputFluids(GTEMaterials.FreeElectronGas.getFluid(1000))
                .inputFluids(GTEMaterials.HeavyLeptonMixture.getFluid(1000))
                .outputItems(GTEItems.CHARGED_LEPTON_TRAP_CRYSTAL.asItem())
                .EUt(491520)
                .duration(240)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("potassium_ethylate_dust"))
                .circuitMeta(2)
                .inputItems(TagPrefix.dust, GTMaterials.Potash, 3)
                .inputItems(TagPrefix.dust, GTMaterials.Quicklime, 5)
                .inputFluids(GTMaterials.CarbonDioxide.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(5000))
                .outputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylate, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.HighPurityCalciumCarbonate, 5)
                .EUt(120)
                .duration(100)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("photopolymer"))
                .inputItems(TagPrefix.dust, GTEMaterials.CyclopentadienylTitaniumTrichloride, 69)
                .inputItems(TagPrefix.dust, GTMaterials.Ice, 42)
                .inputItems(TagPrefix.dust, GTEMaterials.SilverPerchlorate, 12)
                .inputFluids(GTEMaterials.Phenylsodium.getFluid(8000))
                .inputFluids(GTEMaterials.SilverTetrafluoroborate.getFluid(2000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .inputFluids(GTEMaterials.NDifluorophenylpyrrole.getFluid(6000))
                .inputFluids(GTEMaterials.TetraethylammoniumBromide.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.SilverChloride, 8)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumBromide, 4)
                .outputFluids(GTMaterials.SaltWater.getFluid(6000))
                .outputFluids(GTEMaterials.Photopolymer.getFluid(8000))
                .EUt(30720)
                .duration(340)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("titanium_trifluoride_dust"))
                .circuitMeta(24)
                .inputItems(TagPrefix.dust, GTMaterials.Titanium)
                .inputFluids(GTMaterials.Fluorine.getFluid(3000))
                .outputItems(TagPrefix.dust, GTMaterials.TitaniumTrifluoride, 4)
                .EUt(30720)
                .duration(600)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("diaminodiphenylmethanmixture"))
                .inputFluids(GTMaterials.Formaldehyde.getFluid(1000))
                .inputFluids(GTEMaterials.Aniline.getFluid(2000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.DiaminodiphenylmethanMixture.getFluid(1000))
                .EUt(7680)
                .duration(320)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("tetraacetyldinitrosohexaazaisowurtzitane_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Dibenzyltetraacetylhexaazaisowurtzitane, 70)
                .inputItems(TagPrefix.dust, GTEMaterials.NitrosoniumTetrafluoroborate, 42)
                .inputFluids(GTMaterials.Water.getFluid(14000))
                .outputItems(TagPrefix.dust, GTEMaterials.Tetraacetyldinitrosohexaazaisowurtzitane, 46)
                .outputFluids(GTMaterials.HydrofluoricAcid.getFluid(24000))
                .outputFluids(GTEMaterials.BoricAcid.getFluid(6000))
                .outputFluids(GTMaterials.NitricOxide.getFluid(4000))
                .outputFluids(GTEMaterials.Benzaldehyde.getFluid(2000))
                .EUt(7680)
                .duration(140)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("optical_wafer"))
                .inputItems(TagPrefix.dust, GTEMaterials.FranciumCaesiumCadmiumBromide, 2)
                .inputItems(GTEItems.PHOTON_CARRYING_WAFER.asItem())
                .inputItems(GTETagPrefix.NANITES, GTMaterials.Glowstone)
                .inputFluids(GTEMaterials.SeaborgiumDopedNanotubes.getFluid(144))
                .inputFluids(GTEMaterials.CarbonNanotubes.getFluid(144))
                .outputItems(GTEItems.OPTICAL_WAFER.asItem())
                .EUt(1966080)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("sarcosine_dust"))
                .inputFluids(GTMaterials.AceticAcid.getFluid(1000))
                .inputFluids(GTMaterials.Chlorine.getFluid(2000))
                .inputFluids(GTMaterials.Methanol.getFluid(1000))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Sarcosine, 13)
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(3000))
                .EUt(7680)
                .duration(200)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("isophthaloylbis"))
                .inputFluids(GTEMaterials.PhenylenedioxydiaceticAcid.getFluid(1000))
                .inputFluids(GTEMaterials.ThionylChloride.getFluid(2000))
                .inputFluids(GTEMaterials.Diethylthiourea.getFluid(2000))
                .outputFluids(GTEMaterials.IsophthaloylBis.getFluid(1000))
                .outputFluids(GTMaterials.SulfurDioxide.getFluid(2000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .EUt(122880)
                .duration(250)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("trichloroflerane"))
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Ferrosilite)
                .inputItems(TagPrefix.dust, GTMaterials.Flerovium)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(3000))
                .outputFluids(GTEMaterials.Trichloroflerane.getFluid(1000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(3000))
                .EUt(7680)
                .duration(150)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("photoresist"))
                .inputFluids(GTEMaterials.EthylAcrylate.getFluid(1000))
                .inputFluids(GTMaterials.Styrene.getFluid(1000))
                .inputFluids(GTMaterials.TitaniumTetrachloride.getFluid(100))
                .outputFluids(GTEMaterials.Photoresist.getFluid(1000))
                .EUt(1920)
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("iridium_chloride_dust"))
                .circuitMeta(24)
                .inputItems(TagPrefix.dust, GTMaterials.Iridium)
                .inputFluids(GTMaterials.Chlorine.getFluid(3000))
                .outputItems(TagPrefix.dust, GTMaterials.IridiumChloride, 4)
                .EUt(30720)
                .duration(800)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("co_ac_ab_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Charcoal, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Cobalt)
                .inputItems(TagPrefix.plate, GTMaterials.Polybenzimidazole)
                .inputFluids(GTMaterials.Steam.getFluid(1000))
                .inputFluids(GTEMaterials.Acetylene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.CoAcAbCatalyst)
                .outputFluids(GTMaterials.Hydrogen.getFluid(4000))
                .outputFluids(GTMaterials.CarbonMonoxide.getFluid(1000))
                .EUt(1966080)
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("barium_titanate_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.TitaniumDioxide, 3)
                .inputItems(TagPrefix.dust, GTEMaterials.BariumHydroxide, 5)
                .circuitMeta(5)
                .outputItems(TagPrefix.dust, GTEMaterials.BariumTitanateCeramic)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(240)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("barium_hydroxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Barium)
                .inputFluids(GTMaterials.Water.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.BariumHydroxide, 5)
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("titanium_dioxide_dust"))
                .circuitMeta(5)
                .inputFluids(GTMaterials.TitaniumTetrachloride.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.TitaniumDioxide, 3)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .EUt(240)
                .duration(100)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("undried_hydroxyapatite_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Apatite, 4)
                .inputItems(TagPrefix.dust, GTEMaterials.HighPurityCalciumCarbonate)
                .circuitMeta(5)
                .inputFluids(GTMaterials.Steam.getFluid(10000))
                .outputItems(TagPrefix.dust, GTEMaterials.UndriedHydroxyapatite)
                .EUt(480)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("cobalt_oxide_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Cobalt)
                .circuitMeta(5)
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.CobaltOxideCeramic)
                .EUt(480)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("magnesium_chloride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Magnesium)
                .circuitMeta(5)
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .outputFluids(Hydrogen.getFluid(2000))
                .outputItems(TagPrefix.dust, GTMaterials.MagnesiumChloride, 3)
                .EUt(480)
                .duration(100)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("strontium_carbonate_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.StrontiumSulfate, 6)
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Hafnium)
                .inputFluids(GTMaterials.CarbonDioxide.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.StrontiumCarbonateCeramic)
                .outputFluids(GTMaterials.DilutedSulfuricAcid.getFluid(1000))
                .EUt(120)
                .duration(260)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("strontium_sulfate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Strontium)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.StrontiumSulfate, 6)
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(1920)
                .duration(50)
                .save();

        CHEMICAL_RECIPES.recipeBuilder(GTECore.id("silica_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Naquadah)
                .inputItems(TagPrefix.dustTiny, GTMaterials.NaquadahEnriched)
                .inputFluids(GTMaterials.HydrogenPeroxide.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.SilicaCeramic)
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(120)
                .duration(260)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("advanced_circuit_board_persulfate")).duration(900).EUt(VA[LV])
                .inputItems(EPOXY_BOARD)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.BariumTitanateCeramic, 3)
                .inputItems(foil, Electrum, 8)
                .inputFluids(SodiumPersulfate.getFluid(1000))
                .outputItems(ADVANCED_CIRCUIT_BOARD)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("advanced_circuit_board_iron3")).duration(900).EUt(VA[LV])
                .inputItems(EPOXY_BOARD)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.BariumTitanateCeramic, 3)
                .inputItems(foil, Electrum, 8)
                .inputFluids(Iron3Chloride.getFluid(500))
                .outputItems(ADVANCED_CIRCUIT_BOARD)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder("extreme_circuit_board_persulfate").duration(1200).EUt(VA[LV])
                .inputItems(FIBER_BOARD)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.TungstenTetraborideCeramics, 4)
                .inputItems(foil, AnnealedCopper, 12)
                .inputFluids(SodiumPersulfate.getFluid(2000))
                .outputItems(EXTREME_CIRCUIT_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder("extreme_circuit_board_iron3").duration(1200).EUt(VA[LV])
                .inputItems(FIBER_BOARD)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.TungstenTetraborideCeramics, 4)
                .inputItems(foil, AnnealedCopper, 12)
                .inputFluids(Iron3Chloride.getFluid(1000))
                .outputItems(EXTREME_CIRCUIT_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder("elite_circuit_board_persulfate").duration(1500).EUt(VA[MV])
                .inputItems(MULTILAYER_FIBER_BOARD)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.SilicaCeramic, 4)
                .inputItems(foil, Platinum, 8)
                .inputFluids(SodiumPersulfate.getFluid(4000))
                .outputItems(ELITE_CIRCUIT_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder("elite_circuit_board_iron3").duration(1500).EUt(VA[MV])
                .inputItems(MULTILAYER_FIBER_BOARD)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.SilicaCeramic, 4)
                .inputItems(foil, Platinum, 8)
                .inputFluids(Iron3Chloride.getFluid(2000))
                .outputItems(ELITE_CIRCUIT_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder("wetware_circuit_board_persulfate").duration(1800).EUt(VA[HV])
                .inputItems(WETWARE_BOARD)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.HydroxyapatiteCeramic, 4)
                .inputItems(foil, NiobiumTitanium, 32)
                .inputFluids(SodiumPersulfate.getFluid(10000))
                .outputItems(WETWARE_CIRCUIT_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder("wetware_circuit_board_iron3").duration(1800).EUt(VA[HV])
                .inputItems(WETWARE_BOARD)
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.HydroxyapatiteCeramic, 4)
                .inputItems(foil, NiobiumTitanium, 32)
                .inputFluids(Iron3Chloride.getFluid(5000))
                .outputItems(WETWARE_CIRCUIT_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("bioware_printed_circuit_board"))
                .inputItems(GTEItems.BIOWARE_CIRCUIT_BOARD.asItem())
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.TellurateCeramics, 4)
                .inputItems(TagPrefix.foil, GTMaterials.VanadiumGallium, 32)
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(10000))
                .outputItems(GTEItems.BIOWARE_PRINTED_CIRCUIT_BOARD.asItem())
                .EUt(1920)
                .duration(2100)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("bioware_printed_circuit_board1"))
                .inputItems(GTEItems.BIOWARE_CIRCUIT_BOARD.asItem())
                .inputItems(GTETagPrefix.FLAKES, GTEMaterials.TellurateCeramics, 4)
                .inputItems(TagPrefix.foil, GTMaterials.VanadiumGallium, 32)
                .inputFluids(GTMaterials.SodiumPersulfate.getFluid(20000))
                .outputItems(GTEItems.BIOWARE_PRINTED_CIRCUIT_BOARD.asItem())
                .EUt(1920)
                .duration(2100)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("citric_acid"))
                .inputItems(TagPrefix.dustTiny, GTMaterials.PotassiumDichromate)
                .outputItems(TagPrefix.dust, GTMaterials.AmmoniumChloride, 18)
                .inputFluids(GTMaterials.HypochlorousAcid.getFluid(1000))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(2000))
                .inputFluids(GTMaterials.Glycerol.getFluid(1000))
                .inputFluids(GTMaterials.Water.getFluid(3000))
                .inputFluids(GTMaterials.HydrogenCyanide.getFluid(3000))
                .outputFluids(GTEMaterials.CitricAcid.getFluid(1000))
                .circuitMeta(4)
                .EUt(1920)
                .duration(240)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("well_mixed_ybcoxides"))
                .inputItems(TagPrefix.dust, GTEMaterials.CopperNitrate, 27)
                .inputItems(TagPrefix.dust, GTEMaterials.BariumNitrate, 18)
                .inputItems(TagPrefix.dust, GTEMaterials.YttriumNitrate, 13)
                .outputItems(TagPrefix.dust, GTEMaterials.WellMixedYbcOxides, 12)
                .inputFluids(GTEMaterials.CitricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Ammonia.getFluid(2000))
                .outputFluids(GTMaterials.NitrogenDioxide.getFluid(15000))
                .outputFluids(GTMaterials.CarbonMonoxide.getFluid(6000))
                .outputFluids(GTMaterials.Water.getFluid(4000))
                .outputFluids(GTMaterials.Hydrogen.getFluid(6000))
                .EUt(1920)
                .duration(260)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("b27supplement"))
                .inputFluids(GTEMaterials.Catalase.getFluid(1000))
                .inputFluids(GTEMaterials.LinoleicAcid.getFluid(1000))
                .inputFluids(GTEMaterials.Biotin.getFluid(1000))
                .inputFluids(GTEMaterials.Ethanolamine.getFluid(1000))
                .inputFluids(GTEMaterials.VitaminA.getFluid(1000))
                .outputFluids(GTEMaterials.B27Supplement.getFluid(5000))
                .EUt(7680)
                .duration(150)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTECore.id("vitamina"))
                .inputFluids(GTEMaterials.PropargylChloride.getFluid(5000))
                .inputFluids(GTEMaterials.BetaIonone.getFluid(25000))
                .outputFluids(GTEMaterials.VitaminA.getFluid(17000))
                .outputFluids(GTMaterials.Oxygen.getFluid(8000))
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(5000))
                .EUt(480)
                .duration(150)
                .save();

        LARGE_CHEMICAL_RECIPES.builder("pedot")
                .inputItems(GTETagPrefix.CATALYST, GTEMaterials.IronSulfate)
                .outputItems(TagPrefix.dust, GTEMaterials.Pedot)
                .notConsumableFluid(GTMaterials.SodiumPersulfate, 1000)
                .inputFluids(GTEMaterials.Ethylenedioxythiophene, 1000)
                .inputFluids(GTMaterials.SulfuricAcid, 1000)
                .inputFluids(GTMaterials.Styrene, 1000)
                .outputFluids(GTMaterials.DilutedSulfuricAcid, 1000)
                .EUt(1920)
                .duration(320)
                .save();

        LARGE_CHEMICAL_RECIPES.builder("dietoxythiophene")
                .inputItems(GTETagPrefix.CATALYST, GTMaterials.Zinc)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylate, 18)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumBromide, 8)
                .inputFluids(GTEMaterials.Perbromothiophene, 1000)
                .inputFluids(GTMaterials.AceticAcid, 1000)
                .inputFluids(GTMaterials.Water, 1000)
                .outputFluids(GTEMaterials.Dietoxythiophene, 1000)
                .outputFluids(GTEMaterials.HydrobromicAcid, 2000)
                .outputFluids(GTMaterials.CarbonDioxide, 1000)
                .EUt(480)
                .duration(80)
                .save();

        LARGE_CHEMICAL_RECIPES.builder("perbromothiophene")
                .inputItems(TagPrefix.dust, GTEMaterials.SuccinicAcid, 14)
                .inputFluids(GTMaterials.HydrogenSulfide, 1000)
                .inputFluids(GTMaterials.Bromine, 1000)
                .outputFluids(GTEMaterials.Perbromothiophene, 1000)
                .outputFluids(GTMaterials.Water, 4000)
                .EUt(1920)
                .duration(140)
                .save();

        LARGE_CHEMICAL_RECIPES.builder("ethylenedioxythiophene")
                .notConsumable(GTItems.GELLED_TOLUENE.asStack())
                .inputFluids(GTEMaterials.Dietoxythiophene, 1000)
                .inputFluids(GTEMaterials.EthyleneGlycol, 1000)
                .outputFluids(GTEMaterials.Ethylenedioxythiophene, 1000)
                .outputFluids(GTMaterials.Ethanol, 1000)
                .EUt(120)
                .duration(140)
                .save();
    }
}
