package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.FLOTATING_BENEFICIATION_RECIPES;

interface FlotatingBeneficiation {

    static void init() {
        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("pyrope_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Pyrope, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(8000))
                .outputFluids(GTEMaterials.PyropeFront.getFluid(1000))
                .EUt(7680)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("redstone_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Redstone, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(13000))
                .outputFluids(GTEMaterials.RedstoneFront.getFluid(1000))
                .EUt(7680)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("chalcopyrite_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Chalcopyrite, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(12000))
                .outputFluids(GTEMaterials.ChalcopyriteFront.getFluid(1000))
                .EUt(7680)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("monazite_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Monazite, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(30000))
                .outputFluids(GTEMaterials.MonaziteFront.getFluid(1000))
                .EUt(30720)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("enriched_naquadah_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylxanthate, 64)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.NaquadahEnriched, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(280000))
                .outputFluids(GTEMaterials.EnrichedNaquadahFront.getFluid(1000))
                .EUt(491520)
                .duration(2400)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("grossular_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Grossular, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(28000))
                .outputFluids(GTEMaterials.GrossularFront.getFluid(1000))
                .EUt(30720)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("nickel_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Nickel, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(25000))
                .outputFluids(GTEMaterials.NickelFront.getFluid(1000))
                .EUt(7680)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("almandine_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Almandine, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(18000))
                .outputFluids(GTEMaterials.AlmandineFront.getFluid(1000))
                .EUt(7680)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("platinum_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Platinum, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(35000))
                .outputFluids(GTEMaterials.PlatinumFront.getFluid(1000))
                .EUt(30720)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("pentlandite_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Pentlandite, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(14000))
                .outputFluids(GTEMaterials.PentlanditeFront.getFluid(1000))
                .EUt(30720)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("spessartine_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.PotassiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Spessartine, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(35000))
                .outputFluids(GTEMaterials.SpessartineFront.getFluid(1000))
                .EUt(30720)
                .duration(4800)
                .save();

        FLOTATING_BENEFICIATION_RECIPES.recipeBuilder(GTECore.id("sphalerite_front"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumEthylxanthate, 32)
                .inputItems(GTETagPrefix.MILLED, GTMaterials.Sphalerite, 64)
                .inputFluids(GTEMaterials.Turpentine.getFluid(14000))
                .outputFluids(GTEMaterials.SphaleriteFront.getFluid(1000))
                .EUt(30720)
                .duration(4800)
                .save();
    }
}
