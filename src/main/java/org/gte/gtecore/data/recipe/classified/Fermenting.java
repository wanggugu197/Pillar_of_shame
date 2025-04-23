package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidStack;

import com.enderio.base.common.init.EIOFluids;

import static org.gte.gtecore.common.data.GTERecipeTypes.FERMENTING_RECIPES;

interface Fermenting {

    static void init() {
        FERMENTING_RECIPES.recipeBuilder(GTECore.id("taranium_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.ActivatedCarbon)
                .inputFluids(GTEMaterials.TaraniumRichLiquidHelium4.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Taranium)
                .EUt(2)
                .duration(200000)
                .save();

        FERMENTING_RECIPES.recipeBuilder(GTECore.id("poisonous_potato"))
                .inputItems(new ItemStack(Blocks.POTATOES.asItem()))
                .outputItems(new ItemStack(Items.POISONOUS_POTATO.asItem()))
                .EUt(30)
                .duration(400)
                .save();

        FERMENTING_RECIPES.recipeBuilder(GTECore.id("rotten_flesh"))
                .inputItems(TagPrefix.dust, GTMaterials.Meat)
                .outputItems(new ItemStack(Items.ROTTEN_FLESH.asItem()))
                .EUt(30)
                .duration(400)
                .save();

        FERMENTING_RECIPES.recipeBuilder(GTECore.id("nutrient_distillation"))
                .inputItems(GTItems.DOUGH.get())
                .inputFluids(GTMaterials.FermentedBiomass.getFluid(1000))
                .outputFluids(new FluidStack(EIOFluids.NUTRIENT_DISTILLATION.getSource(), 1000))
                .EUt(30)
                .duration(400)
                .save();

        FERMENTING_RECIPES.recipeBuilder(GTECore.id("cloud_seed_concentrated"))
                .inputItems(GTEItems.ESSENCE.asItem())
                .inputFluids(new FluidStack(EIOFluids.CLOUD_SEED.getSource(), 1000))
                .outputFluids(new FluidStack(EIOFluids.CLOUD_SEED_CONCENTRATED.getSource(), 1000))
                .EUt(480)
                .duration(400)
                .save();

        FERMENTING_RECIPES.recipeBuilder(GTECore.id("hootch"))
                .inputItems(GTEItems.RED_ALGAE.asStack(4))
                .inputFluids(GTMaterials.Biomass.getFluid(1000))
                .outputFluids(new FluidStack(EIOFluids.HOOTCH.getSource(), 1000))
                .EUt(120)
                .duration(400)
                .save();

        FERMENTING_RECIPES.recipeBuilder(GTECore.id("vapor_of_levity"))
                .inputItems(GTEItems.BLUE_ALGAE.asStack(4))
                .inputFluids(new FluidStack(EIOFluids.DEW_OF_THE_VOID.getSource(), 1000))
                .outputFluids(new FluidStack(EIOFluids.VAPOR_OF_LEVITY.getSource(), 1000))
                .EUt(120)
                .duration(40)
                .save();
    }
}
