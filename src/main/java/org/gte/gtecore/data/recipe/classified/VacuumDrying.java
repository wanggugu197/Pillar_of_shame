package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.VACUUM_DRYING_RECIPES;

interface VacuumDrying {

    static void init() {
        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("grossular_front_pro"))
                .inputFluids(GTEMaterials.GrossularFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Calcium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Calcium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Aluminium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Aluminium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Tungsten, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Thallium, 16)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(30720)
                .duration(2400)
                .blastFurnaceTemp(5500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("sphalerite_front_pro"))
                .inputFluids(GTEMaterials.SphaleriteFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Zinc, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Zinc, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Iron, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Iron, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Indium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Gallium, 64)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(30720)
                .duration(2400)
                .blastFurnaceTemp(5500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("chalcopyrite_front_pro"))
                .inputFluids(GTEMaterials.ChalcopyriteFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Copper, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Copper, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Iron, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Iron, 48)
                .outputItems(TagPrefix.dust, GTMaterials.Cadmium, 48)
                .outputItems(TagPrefix.dust, GTMaterials.Indium, 32)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(7680)
                .duration(2400)
                .blastFurnaceTemp(4500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("nickel_front_pro"))
                .inputFluids(GTEMaterials.NickelFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Nickel, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Nickel, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Cobalt, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Cobalt, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Iron, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Rhodium, 32)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(7680)
                .duration(2400)
                .blastFurnaceTemp(4500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("pyrope_front_pro"))
                .inputFluids(GTEMaterials.PyropeFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Magnesium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Magnesium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Aluminium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Manganese, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Boron, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Silicon, 48)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(1920)
                .duration(2400)
                .blastFurnaceTemp(3500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("platinum_front_pro"))
                .inputFluids(GTEMaterials.PlatinumFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Platinum, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Nickel, 48)
                .outputItems(TagPrefix.dust, GTMaterials.Iridium, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Osmium, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Palladium, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Cobalt, 32)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(30720)
                .duration(2400)
                .blastFurnaceTemp(5500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("redstone_front_pro"))
                .inputFluids(GTEMaterials.RedstoneFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Redstone, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Redstone, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Manganese, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Manganese, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Yttrium, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Ytterbium, 16)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(7680)
                .duration(2400)
                .blastFurnaceTemp(4500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("almandine_front_pro"))
                .inputFluids(GTEMaterials.AlmandineFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Aluminium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Aluminium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Manganese, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Manganese, 24)
                .outputItems(TagPrefix.dust, GTMaterials.Yttrium, 24)
                .outputItems(TagPrefix.dust, GTMaterials.Ytterbium, 16)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(7680)
                .duration(2400)
                .blastFurnaceTemp(5500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("monazite_front_pro"))
                .inputFluids(GTEMaterials.MonaziteFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Erbium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Neodymium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Thorium, 48)
                .outputItems(TagPrefix.dust, GTMaterials.Lanthanum, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Lutetium, 16)
                .outputItems(TagPrefix.dust, GTMaterials.Europium, 8)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(122880)
                .duration(2400)
                .blastFurnaceTemp(5500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("spessartine_front_pro"))
                .inputFluids(GTEMaterials.SpessartineFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Manganese, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Manganese, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Aluminium, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Aluminium, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Palladium, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Strontium, 16)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(30720)
                .duration(2400)
                .blastFurnaceTemp(5500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("pentlandite_front_pro"))
                .inputFluids(GTEMaterials.PentlanditeFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.Iron, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Iron, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Nickel, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Nickel, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Bismuth, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Ruthenium, 48)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(30720)
                .duration(2400)
                .blastFurnaceTemp(5500)
                .save();

        VACUUM_DRYING_RECIPES.recipeBuilder(GTECore.id("enriched_naquadah_front_pro"))
                .inputFluids(GTEMaterials.EnrichedNaquadahFront.getFluid(4000))
                .outputItems(TagPrefix.dust, GTMaterials.NaquadahEnriched, 64)
                .outputItems(TagPrefix.dust, GTMaterials.NaquadahEnriched, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Naquadah, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Naquadah, 32)
                .outputItems(TagPrefix.dust, GTMaterials.Naquadria, 64)
                .outputItems(TagPrefix.dust, GTMaterials.Trinium, 32)
                .outputFluids(GTEMaterials.RedMud.getFluid(200))
                .outputFluids(GTMaterials.Water.getFluid(2000))
                .EUt(491520)
                .duration(2400)
                .blastFurnaceTemp(9500)
                .save();
    }
}
