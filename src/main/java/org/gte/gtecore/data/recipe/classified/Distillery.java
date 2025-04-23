package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.DISTILLERY_RECIPES;

interface Distillery {

    static void init() {
        DISTILLERY_RECIPES.recipeBuilder(GTECore.id("kerosene"))
                .inputItems(TagPrefix.dust, GTMaterials.Coke)
                .inputFluids(GTMaterials.CoalTar.getFluid(200))
                .outputItems(TagPrefix.dust, GTMaterials.DarkAsh)
                .outputFluids(GTEMaterials.Kerosene.getFluid(100))
                .EUt(120)
                .duration(30)
                .save();

        DISTILLERY_RECIPES.recipeBuilder(GTECore.id("enriched_dragon_breath"))
                .inputFluids(GTEMaterials.DragonBreath.getFluid(10))
                .outputFluids(GTEMaterials.EnrichedDragonBreath.getFluid(5))
                .EUt(120)
                .duration(100)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        DISTILLERY_RECIPES.recipeBuilder(GTECore.id("cyclopentadiene"))
                .circuitMeta(12)
                .inputFluids(GTMaterials.SeverelySteamCrackedNaphtha.getFluid(1000))
                .outputFluids(GTEMaterials.Cyclopentadiene.getFluid(150))
                .EUt(30)
                .duration(240)
                .save();

        DISTILLERY_RECIPES.recipeBuilder(GTECore.id("rp_1"))
                .circuitMeta(1)
                .inputFluids(GTEMaterials.Kerosene.getFluid(50))
                .outputFluids(GTEMaterials.Rp1.getFluid(25))
                .EUt(120)
                .duration(16)
                .save();

        DISTILLERY_RECIPES.recipeBuilder(GTECore.id("fluoro_benzene"))
                .inputFluids(GTEMaterials.BenzenediazoniumTetrafluoroborate.getFluid(1000))
                .outputFluids(GTEMaterials.FluoroBenzene.getFluid(1000))
                .EUt(122880)
                .duration(100)
                .save();

        DISTILLERY_RECIPES.recipeBuilder(GTECore.id("enriched_potassium_iodide_slurry"))
                .inputFluids(GTEMaterials.KelpSlurry.getFluid(1000))
                .outputFluids(GTEMaterials.EnrichedPotassiumIodideSlurry.getFluid(100))
                .EUt(30)
                .duration(200)
                .save();

        DISTILLERY_RECIPES.recipeBuilder(GTECore.id("poly_aluminium_chloride"))
                .outputItems(TagPrefix.dustTiny, GTMaterials.DarkAsh)
                .inputFluids(GTEMaterials.FlocculationWasteSolution.getFluid(1000))
                .outputFluids(GTEMaterials.PolyAluminiumChloride.getFluid(990))
                .EUt(120)
                .duration(400)
                .save();
    }
}
