package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.DEHYDRATOR_RECIPES;

interface Dehydrator {

    static void init() {
        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("sodiumhydroxidesolution"))
                .outputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 3)
                .inputFluids(GTEMaterials.SodiumHydroxideSolution.getFluid(1000))
                .EUt(30)
                .duration(140)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("er_lu_oxides_solution"))
                .inputFluids(GTEMaterials.ErLuOxidesSolution.getFluid(4000))
                .chancedOutput(TagPrefix.dust, GTEMaterials.ErbiumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.ThuliumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.YtterbiumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.LutetiumOxide, 5, 4300, 275)
                .EUt(480)
                .duration(220)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("tb_ho_oxides_solution"))
                .inputFluids(GTEMaterials.TbHoOxidesSolution.getFluid(4000))
                .chancedOutput(TagPrefix.dust, GTEMaterials.YttriumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.TerbiumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.DysprosiumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.HolmiumOxide, 5, 4300, 275)
                .EUt(480)
                .duration(220)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("silica_gel_dust"))
                .inputFluids(GTEMaterials.SilicaGelBase.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SilicaGel, 3)
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .EUt(480)
                .duration(130)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("boron_trioxide_dust"))
                .inputFluids(GTEMaterials.BoricAcid.getFluid(2000))
                .outputItems(TagPrefix.dust, GTEMaterials.BoronTrioxide, 5)
                .EUt(480)
                .duration(400)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("residual_triniite_solution"))
                .inputFluids(GTEMaterials.ResidualTriniiteSolution.getFluid(2000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumNitrate, 20)
                .chancedOutput(TagPrefix.dust, GTMaterials.Naquadria, 2, 4800, 0)
                .chancedOutput(TagPrefix.dust, GTMaterials.NaquadahEnriched, 5200, 0)
                .EUt(7680)
                .duration(190)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("monomethylhydrazine"))
                .inputItems(TagPrefix.dust, GTMaterials.Carbon)
                .inputFluids(GTEMaterials.Hydrazine.getFluid(1000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .outputFluids(GTEMaterials.Monomethylhydrazine.getFluid(1000))
                .EUt(240)
                .duration(240)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("la_nd_oxides_solution"))
                .inputFluids(GTEMaterials.LaNdOxidesSolution.getFluid(4000))
                .chancedOutput(TagPrefix.dust, GTEMaterials.LanthanumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.CeriumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.PraseodymiumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.NeodymiumOxide, 5, 4300, 275)
                .EUt(480)
                .duration(220)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("zeolite_sieving_pellets_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.WetZeoliteSievingPellets)
                .outputItems(TagPrefix.dust, GTEMaterials.ZeoliteSievingPellets)
                .EUt(120)
                .duration(50)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("polyimide"))
                .inputFluids(GTEMaterials.Paa.getFluid(144))
                .outputFluids(GTEMaterials.Polyimide.getFluid(144))
                .EUt(30)
                .duration(270)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("germanium_dioxide_dust"))
                .inputFluids(GTEMaterials.GermaniumTetrachlorideSolution.getFluid(1000))
                .inputFluids(GTMaterials.Hydrogen.getFluid(4000))
                .outputItems(TagPrefix.dust, GTEMaterials.GermaniumDioxide, 3)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(4000))
                .EUt(30)
                .duration(800)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("tungsten_trioxide_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.TungsticAcid, 7)
                .outputItems(TagPrefix.dust, GTEMaterials.TungstenTrioxide, 4)
                .EUt(120)
                .duration(150)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("graphene_iron_plate"))
                .notConsumable(TagPrefix.rodLong, GTMaterials.YttriumBariumCuprate)
                .inputItems(TagPrefix.dust, GTMaterials.Sodium, 3)
                .inputFluids(GTEMaterials.GlucoseIronSolution.getFluid(1000))
                .outputItems(GTEItems.GRAPHENE_IRON_PLATE.asItem())
                .outputItems(TagPrefix.gem, GTMaterials.Salt, 6)
                .EUt(120)
                .duration(40)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("stearic_acid"))
                .inputFluids(GTEMaterials.DeglyceratedSoap.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt)
                .outputFluids(GTEMaterials.StearicAcid.getFluid(800))
                .EUt(2000)
                .duration(160)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("sm_gd_oxides_solution"))
                .inputFluids(GTEMaterials.SmGdOxidesSolution.getFluid(4000))
                .chancedOutput(TagPrefix.dust, GTEMaterials.ScandiumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.SamariumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.EuropiumOxide, 5, 4300, 275)
                .chancedOutput(TagPrefix.dust, GTEMaterials.GadoliniumOxide, 5, 4300, 275)
                .EUt(480)
                .duration(220)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("salt_dust"))
                .inputFluids(GTMaterials.SaltWater.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Salt, 2)
                .EUt(30)
                .duration(160)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("phthalic_anhydride_dust"))
                .inputFluids(GTMaterials.PhthalicAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PhthalicAnhydride, 15)
                .EUt(480)
                .duration(400)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("diethyl_ether"))
                .circuitMeta(1)
                .notConsumableFluid(GTMaterials.SulfuricAcid.getFluid(1000))
                .inputFluids(GTMaterials.Ethanol.getFluid(2000))
                .outputFluids(GTEMaterials.DiethylEther.getFluid(1000))
                .EUt(750)
                .duration(120)
                .save();

        DEHYDRATOR_RECIPES.recipeBuilder(GTECore.id("hydroxyapatite_ceramic_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.UndriedHydroxyapatite)
                .outputItems(TagPrefix.dust, GTEMaterials.HydroxyapatiteCeramic)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .EUt(120)
                .duration(10)
                .save();
    }
}
