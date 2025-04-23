package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.REACTION_FURNACE_RECIPES;

interface ReactionFurnace {

    private static void registerBlastFurnaceMetallurgyRecipes() {
        createSulfurDioxideRecipe(Stibnite, AntimonyTrioxide, 1500);
        createSulfurDioxideRecipe(Sphalerite, Zincite, 1000);
        createSulfurDioxideRecipe(Pyrite, Hematite, 2000);
        createSulfurDioxideRecipe(Pentlandite, Garnierite, 1000);

        REACTION_FURNACE_RECIPES.recipeBuilder("tetrahedrite_metallurgy").duration(120).EUt(VA[MV]).blastFurnaceTemp(1200)
                .inputItems(dust, Tetrahedrite)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, CupricOxide)
                .outputItems(dustTiny, AntimonyTrioxide, 3)
                .outputFluids(SulfurDioxide.getFluid(2000))
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder("cobaltite_metallurgy").duration(120).EUt(VA[MV]).blastFurnaceTemp(1200)
                .inputItems(dust, Cobaltite)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, CobaltOxide)
                .outputItems(dust, ArsenicTrioxide)
                .outputFluids(SulfurDioxide.getFluid(1000))
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder("galena_metallurgy").duration(120).EUt(VA[MV]).blastFurnaceTemp(1200)
                .inputItems(dust, Galena)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, Massicot)
                .outputItems(nugget, Silver, 6)
                .outputFluids(SulfurDioxide.getFluid(1000))
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder("chalcopyrite_metallurgy").duration(120).EUt(VA[MV]).blastFurnaceTemp(1200)
                .inputItems(dust, Chalcopyrite)
                .inputItems(dust, SiliconDioxide)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, CupricOxide)
                .outputItems(dust, Ferrosilite)
                .outputFluids(SulfurDioxide.getFluid(2000))
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder("blast_silicon_dioxide").duration(240).EUt(VA[MV]).blastFurnaceTemp(2273)
                .inputItems(dust, SiliconDioxide, 3)
                .inputItems(dust, Carbon, 2)
                .outputItems(ingotHot, Silicon)
                .chancedOutput(dust, Ash, "1/9", 0)
                .outputFluids(CarbonMonoxide.getFluid(2000))
                .save();
    }

    private static void createSulfurDioxideRecipe(Material inputMaterial,
                                                  Material outputMaterial, int sulfurDioxideAmount) {
        REACTION_FURNACE_RECIPES.recipeBuilder(inputMaterial.getName() + "_metallurgy").duration(120).EUt(VA[MV])
                .blastFurnaceTemp(1200)
                .inputItems(dust, inputMaterial)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, outputMaterial)
                .chancedOutput(dust, Ash, "1/9", 0)
                .outputFluids(SulfurDioxide.getFluid(sulfurDioxideAmount))
                .save();
    }

    private static void registerBlastFurnaceRecipes() {
        REACTION_FURNACE_RECIPES.recipeBuilder("aluminium_from_ruby_dust").duration(400).EUt(100).inputItems(dust, Ruby)
                .outputItems(nugget, Aluminium, 3).chancedOutput(dust, Ash, "1/9", 0).blastFurnaceTemp(1200)
                .save();
        REACTION_FURNACE_RECIPES.recipeBuilder("aluminium_from_ruby_gem").duration(320).EUt(100).inputItems(gem, Ruby)
                .outputItems(nugget, Aluminium, 3).chancedOutput(dust, Ash, "1/9", 0).blastFurnaceTemp(1200)
                .save();
        REACTION_FURNACE_RECIPES.recipeBuilder("aluminium_from_green_sapphire_dust").duration(400).EUt(100)
                .inputItems(dust, GreenSapphire).outputItems(nugget, Aluminium, 3).chancedOutput(dust, Ash, "1/9", 0)
                .blastFurnaceTemp(1200).save();
        REACTION_FURNACE_RECIPES.recipeBuilder("aluminium_from_green_sapphire_gem").duration(320).EUt(100)
                .inputItems(gem, GreenSapphire).outputItems(nugget, Aluminium, 3).chancedOutput(dust, Ash, "1/9", 0)
                .blastFurnaceTemp(1200).save();
        REACTION_FURNACE_RECIPES.recipeBuilder("aluminium_from_sapphire_dust").duration(400).EUt(100).inputItems(dust, Sapphire)
                .outputItems(nugget, Aluminium, 3).blastFurnaceTemp(1200).save();
        REACTION_FURNACE_RECIPES.recipeBuilder("aluminium_from_sapphire_gem").duration(320).EUt(100).inputItems(gem, Sapphire)
                .outputItems(nugget, Aluminium, 3).blastFurnaceTemp(1200).save();
        REACTION_FURNACE_RECIPES.recipeBuilder("titanium_from_tetrachloride").duration(600).EUt(VA[HV])
                .inputItems(dust, Magnesium, 2).inputFluids(TitaniumTetrachloride.getFluid(1000))
                .outputItems(ingotHot, Titanium).outputItems(dust, MagnesiumChloride, 6)
                .blastFurnaceTemp(Titanium.getBlastTemperature() + 200).save();

        REACTION_FURNACE_RECIPES.recipeBuilder("rutile_from_ilmenite")
                .inputItems(dust, Ilmenite, 10)
                .inputItems(dust, Carbon, 4)
                .outputItems(ingot, WroughtIron, 2)
                .outputItems(dust, Rutile, 4)
                .outputFluids(CarbonDioxide.getFluid(2000))
                .blastFurnaceTemp(1700)
                .duration(1600).EUt(VA[HV]).save();

        registerBlastFurnaceMetallurgyRecipes();
    }

    static void init() {
        registerBlastFurnaceRecipes();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("sodium_aluminate"))
                .inputItems(TagPrefix.dust, GTMaterials.Bauxite, 5)
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumAluminate, 8)
                .EUt(120)
                .duration(120)
                .blastFurnaceTemp(700)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("actinium_hydride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ActiniumOxalate, 13)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumHydride, 6)
                .inputItems(TagPrefix.dust, GTMaterials.Sodium)
                .inputFluids(GTEMaterials.CarbonTetrachloride.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.ActiniumHydride, 4)
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 8)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(5000))
                .EUt(122880)
                .duration(400)
                .blastFurnaceTemp(10700)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("europium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.EuropiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Europium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("strontium_europium_aluminate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Europium)
                .inputItems(TagPrefix.dust, GTMaterials.Strontium)
                .inputFluids(GTMaterials.Oxygen.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.StrontiumEuropiumAluminate, 8)
                .EUt(120)
                .duration(340)
                .blastFurnaceTemp(1200)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("hafnium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.HafniumChloride, 5)
                .inputItems(TagPrefix.dust, GTMaterials.Magnesium, 2)
                .outputItems(TagPrefix.dust, GTMaterials.Hafnium)
                .outputItems(TagPrefix.dust, GTMaterials.MagnesiumChloride, 6)
                .EUt(120)
                .duration(300)
                .blastFurnaceTemp(3400)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("boron_carbide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .inputItems(TagPrefix.dust, GTMaterials.Boron, 4)
                .outputItems(TagPrefix.dust, GTEMaterials.BoronCarbide, 7)
                .EUt(120)
                .duration(550)
                .blastFurnaceTemp(4000)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("rhenium_chloride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Rhenium)
                .inputFluids(GTMaterials.Chlorine.getFluid(5000))
                .outputItems(TagPrefix.dust, GTEMaterials.RheniumChloride, 6)
                .EUt(120)
                .duration(930)
                .blastFurnaceTemp(12500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("yttrium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.YttriumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Yttrium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("gadolinium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.GadoliniumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Gadolinium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("hassium_chloride_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Hassium)
                .inputFluids(GTMaterials.Chlorine.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.HassiumChloride, 5)
                .EUt(120)
                .duration(930)
                .blastFurnaceTemp(12000)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("cubic_zirconia_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Zirconium)
                .inputFluids(GTMaterials.Oxygen.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.CubicZirconia, 3)
                .EUt(480)
                .duration(360)
                .blastFurnaceTemp(2600)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("borocarbide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.BoronFranciumCarbide, 15)
                .inputItems(TagPrefix.dust, GTEMaterials.MixedAstatideSalts, 14)
                .outputItems(TagPrefix.dust, GTEMaterials.Borocarbide, 29)
                .EUt(120)
                .duration(15000)
                .blastFurnaceTemp(11300)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("cadmium_sulfide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Cadmium)
                .inputItems(TagPrefix.dust, GTMaterials.Sulfur)
                .outputItems(TagPrefix.dust, GTEMaterials.CadmiumSulfide, 2)
                .EUt(30)
                .duration(400)
                .blastFurnaceTemp(1200)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("lanthanum_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.LanthanumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Lanthanum, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("sodium_thiosulfate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 18)
                .inputItems(TagPrefix.dust, GTMaterials.Sulfur, 4)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumThiosulfate, 7)
                .outputItems(TagPrefix.dust, GTMaterials.SodiumSulfide, 6)
                .outputFluids(GTMaterials.Steam.getFluid(3000))
                .EUt(120)
                .duration(210)
                .blastFurnaceTemp(4500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("iridium_dioxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.IridiumMetalResidue, 6)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumChlorate, 5)
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.IridiumDioxide, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .chancedOutput(TagPrefix.dust, GTMaterials.PlatinumSludgeResidue, 8000, 0)
                .outputFluids(GTMaterials.DilutedHydrochloricAcid.getFluid(1000))
                .EUt(120)
                .duration(200)
                .blastFurnaceTemp(790)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("dysprosium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.DysprosiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Dysprosium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("erbium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ErbiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Erbium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("dust_cryotheum"))
                .inputItems(GTEItems.DUST_BLIZZ.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.Enderium)
                .outputItems(GTEItems.DUST_CRYOTHEUM.asStack(2))
                .EUt(7864320)
                .duration(160)
                .blastFurnaceTemp(8300)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("silver_iodide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SilverIodide, 4)
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SilverOxide, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Iodine, 2)
                .EUt(125)
                .duration(210)
                .blastFurnaceTemp(1100)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("germanium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.GermaniumDioxide, 3)
                .inputFluids(GTMaterials.Hydrogen.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Germanium)
                .EUt(120)
                .duration(200)
                .blastFurnaceTemp(680)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("calcium_carbide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Quicklime, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.CalciumCarbide)
                .outputFluids(GTMaterials.Oxygen.getFluid(1000))
                .EUt(120)
                .duration(100)
                .blastFurnaceTemp(800)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("phosphorus_pentasulfide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sulfur, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Phosphorus, 4)
                .outputItems(TagPrefix.dust, GTEMaterials.PhosphorusPentasulfide, 14)
                .EUt(480)
                .duration(190)
                .blastFurnaceTemp(900)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("thallium_thulium_doped_caesium_iodide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CaesiumIodide)
                .inputItems(TagPrefix.dustSmall, GTMaterials.Thulium)
                .inputItems(TagPrefix.dustSmall, GTMaterials.Thallium)
                .outputItems(TagPrefix.dust, GTEMaterials.ThalliumThuliumDopedCaesiumIodide)
                .EUt(120)
                .duration(260)
                .blastFurnaceTemp(2853)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("blaze_casing"))
                .inputItems(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.asItem())
                .inputItems(TagPrefix.foil, GTMaterials.Tin, 32)
                .inputFluids(GTMaterials.Blaze.getFluid(1440))
                .inputFluids(GTMaterials.GalliumArsenide.getFluid(576))
                .inputFluids(GTMaterials.VanadiumGallium.getFluid(288))
                .outputItems(GTEBlocks.BLAZE_CASING.asItem())
                .EUt(1920)
                .duration(900)
                .blastFurnaceTemp(4500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("ytterbium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.YtterbiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Ytterbium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("aerographene"))
                .inputItems(TagPrefix.dust, GTEMaterials.DryGrapheneGel)
                .inputFluids(GTEMaterials.SupercriticalCarbonDioxide.getFluid(1000))
                .outputItems(GTEItems.AEROGRAPHENE.asItem())
                .EUt(120)
                .duration(400)
                .blastFurnaceTemp(5000)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("zylon_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PreZylon)
                .outputItems(TagPrefix.dust, GTEMaterials.Zylon)
                .outputFluids(GTMaterials.Propane.getFluid(2000))
                .EUt(120)
                .duration(16000)
                .blastFurnaceTemp(10000)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("promethium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PromethiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Promethium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("molybdenum_flue"))
                .inputItems(TagPrefix.dust, GTEMaterials.MolybdenumConcentrate, 4)
                .inputFluids(GTMaterials.Oxygen.getFluid(7250))
                .outputItems(TagPrefix.dust, GTEMaterials.MolybdenumTrioxide, 4)
                .outputFluids(GTEMaterials.MolybdenumFlue.getFluid(3000))
                .EUt(120)
                .duration(340)
                .blastFurnaceTemp(2400)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("lutetium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.LutetiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Lutetium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("cadmium_tungstate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.TungstenTrioxide, 4)
                .inputItems(TagPrefix.dust, GTEMaterials.CadmiumSulfide, 2)
                .inputFluids(GTMaterials.Oxygen.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.CadmiumTungstate, 6)
                .outputFluids(GTMaterials.SulfurDioxide.getFluid(1000))
                .EUt(120)
                .duration(320)
                .blastFurnaceTemp(2800)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("bismuth_germanate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.GermaniumDioxide, 3)
                .inputFluids(GTEMaterials.BismuthNitrateSolution.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.BismuthGermanate, 33)
                .outputFluids(GTMaterials.NitrogenDioxide.getFluid(12000))
                .EUt(5000000)
                .duration(80)
                .blastFurnaceTemp(7600)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("scandium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ScandiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Scandium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("terbium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.TerbiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Terbium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("bisethylenedithiotetraselenafulvalene_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.LithiumThiinediselenide, 28)
                .inputItems(TagPrefix.dust, GTEMaterials.CyclopentadienylTitaniumTrichloride)
                .inputFluids(GTMaterials.Tetrafluoroethylene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.LithiumFluoride, 8)
                .outputItems(TagPrefix.dust, GTEMaterials.Bisethylenedithiotetraselenafulvalene, 26)
                .EUt(120)
                .duration(7680)
                .blastFurnaceTemp(4600)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("holmium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.HolmiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Holmium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("trinium_compound_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CrystallineNitricAcid, 40)
                .inputItems(TagPrefix.dust, GTEMaterials.TriniumCompound, 16)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumPerchlorate, 6)
                .inputFluids(GTMaterials.SulfurDioxide.getFluid(8000))
                .outputItems(TagPrefix.dust, GTMaterials.Astatine, 8)
                .outputItems(TagPrefix.dust, GTEMaterials.SeleniumOxide, 24)
                .outputFluids(GTEMaterials.NitratedTriniiteCompoundSolution.getFluid(4000))
                .EUt(122880)
                .duration(265)
                .blastFurnaceTemp(9400)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("dragon_strength_tritanium_casing"))
                .inputItems(GTEBlocks.EXTREME_STRENGTH_TRITANIUM_CASING.asStack(16))
                .inputItems(GTEBlocks.DRACONIUM_BLOCK_CHARGED.asStack(16))
                .outputItems(GTEBlocks.DRAGON_STRENGTH_TRITANIUM_CASING.asItem())
                .EUt(7864320)
                .duration(2000)
                .blastFurnaceTemp(8000)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("bisethylenedithiotetraselenafulvalene_perrhenate_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Bisethylenedithiotetraselenafulvalene, 26)
                .inputFluids(GTEMaterials.AmmoniumPerrhenate.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.BisethylenedithiotetraselenafulvalenePerrhenate, 31)
                .outputFluids(GTMaterials.Ammonia.getFluid(1000))
                .EUt(120)
                .duration(9840)
                .blastFurnaceTemp(5000)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("cerium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CeriumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Cerium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("thulium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ThuliumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Thulium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("zeolite_sieving_pellets_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SilicaAluminaGel)
                .inputItems(TagPrefix.dust, GTMaterials.Zeolite)
                .outputItems(TagPrefix.dust, GTEMaterials.ZeoliteSievingPellets)
                .EUt(120)
                .duration(400)
                .blastFurnaceTemp(4500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("francium_caesium_cadmium_bromide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Cadmium, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Francium)
                .inputItems(TagPrefix.dust, GTMaterials.Caesium)
                .inputFluids(GTMaterials.Bromine.getFluid(6000))
                .outputItems(TagPrefix.dust, GTEMaterials.FranciumCaesiumCadmiumBromide, 10)
                .EUt(120)
                .duration(250)
                .blastFurnaceTemp(2200)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("samarium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SamariumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Samarium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("tellurium_oxide_dust"))
                .circuitMeta(2)
                .inputItems(TagPrefix.dust, GTMaterials.Tellurium)
                .inputFluids(GTMaterials.Oxygen.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.TelluriumOxide, 3)
                .EUt(128)
                .duration(100)
                .blastFurnaceTemp(1760)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("hot_titanium_50_ingot"))
                .inputItems(TagPrefix.dust, GTMaterials.Magnesium, 2)
                .inputFluids(GTEMaterials.Titanium50Tetrachloride.getFluid(1000))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Titanium50)
                .outputItems(TagPrefix.dust, GTMaterials.MagnesiumChloride, 6)
                .EUt(480)
                .duration(600)
                .blastFurnaceTemp(2142)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("fissioned_uranium_235_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Uranium235)
                .inputItems(TagPrefix.dustTiny, GTMaterials.Neutronium)
                .outputItems(TagPrefix.dust, GTEMaterials.FissionedUranium235)
                .EUt(1920)
                .duration(800)
                .blastFurnaceTemp(3860)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("neodymium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.NeodymiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Neodymium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("praseodymium_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PraseodymiumOxide, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Praseodymium, 4)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(200)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("infused_obsidian"))
                .inputItems(GTEBlocks.ENDER_OBSIDIAN.asItem())
                .inputItems(GTEItems.DRACONIUM_DIRT.asItem())
                .outputItems(GTEBlocks.INFUSED_OBSIDIAN.asItem())
                .EUt(7864320)
                .duration(200)
                .blastFurnaceTemp(11200)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("alumina_ceramic_dust"))
                .circuitMeta(2)
                .inputItems(TagPrefix.dust, GTEMaterials.AluminiumHydroxide, 14)
                .outputItems(TagPrefix.dust, GTEMaterials.Alumina, 5)
                .outputFluids(Steam.getFluid(10000))
                .EUt(120)
                .duration(100)
                .blastFurnaceTemp(2600)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("tungsten_tetraboride_ceramics_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.TungstenBoronMixture)
                .outputItems(TagPrefix.dust, GTEMaterials.TungstenTetraborideCeramics)
                .EUt(480)
                .duration(100)
                .blastFurnaceTemp(3475)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("tellurate_ceramics_dust"))
                .circuitMeta(3)
                .inputItems(TagPrefix.dust, GTMaterials.Tellurium)
                .inputFluids(GTMaterials.Oxygen.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.TellurateCeramics)
                .EUt(480)
                .duration(5)
                .blastFurnaceTemp(8600)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("thulium_hexaboride_ceramics_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Thulium)
                .inputItems(TagPrefix.dust, GTMaterials.Boron, 6)
                .inputFluids(GTMaterials.Argon.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.ThuliumHexaborideCeramics)
                .EUt(960)
                .duration(5)
                .blastFurnaceTemp(2775)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("silicon_nitride_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Silicon, 3)
                .circuitMeta(5)
                .inputFluids(GTMaterials.Nitrogen.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.SiliconNitrideCeramic)
                .EUt(240)
                .duration(5)
                .blastFurnaceTemp(4500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("lithium_oxide_ceramics_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Lithium, 2)
                .circuitMeta(5)
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.LithiumOxideCeramics, 2)
                .EUt(240)
                .duration(5)
                .blastFurnaceTemp(2500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("titanium_nitride_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Titanium, 2)
                .inputFluids(GTMaterials.Nitrogen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.TitaniumNitrideCeramic, 2)
                .EUt(480)
                .duration(5)
                .blastFurnaceTemp(3400)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("zirconia_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Zircon, 6)
                .outputItems(TagPrefix.dust, GTEMaterials.ZirconiaCeramic)
                .outputItems(TagPrefix.dust, GTMaterials.SiliconDioxide, 3)
                .EUt(960)
                .duration(5)
                .blastFurnaceTemp(6500)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("carbon_dioxide"))
                .inputItems(TagPrefix.dust, GTMaterials.Magnesite, 5)
                .outputItems(TagPrefix.dust, GTMaterials.Magnesia, 2)
                .outputFluids(GTMaterials.CarbonDioxide.getFluid(1000))
                .EUt(30)
                .duration(240)
                .blastFurnaceTemp(1255)
                .save();

        REACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("poly_aluminium_chloride"))
                .circuitMeta(1)
                .inputItems(TagPrefix.dust, GTEMaterials.AluminiumChloride, 4)
                .inputItems(TagPrefix.dust, GTEMaterials.AluminiumHydroxide, 7)
                .outputFluids(GTEMaterials.PolyAluminiumChloride.getFluid(1000))
                .EUt(480)
                .duration(360)
                .blastFurnaceTemp(2145)
                .save();
    }
}
