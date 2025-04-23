package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.recipe.condition.RestrictedMachineCondition;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;

import committee.nova.mods.avaritia.init.registry.ModItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.ARC_FURNACE_RECIPES;

interface ArcFurnace {

    static void init() {
        ARC_FURNACE_RECIPES.recipeBuilder(GTECore.id("warped_ender_pearl"))
                .inputItems("torchmaster:frozen_pearl")
                .inputFluids(GTMaterials.Blaze.getFluid(576))
                .outputItems(GTEItems.WARPED_ENDER_PEARL.asItem())
                .outputFluids(new FluidStack(Fluids.WATER, 500))
                .EUt(480)
                .duration(200)
                .save();

        ARC_FURNACE_RECIPES.recipeBuilder(GTECore.id("anthracene"))
                .inputItems(TagPrefix.gem, GTMaterials.Coke)
                .inputFluids(GTMaterials.Oxygen.getFluid(400))
                .outputFluids(GTEMaterials.Anthracene.getFluid(100))
                .EUt(120)
                .duration(400)
                .save();

        ARC_FURNACE_RECIPES.recipeBuilder(GTECore.id("germanium_ash_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.GermaniumContainingPrecipitate, 2)
                .inputFluids(GTMaterials.Oxygen.getFluid(120))
                .outputItems(TagPrefix.dust, GTEMaterials.GermaniumAsh)
                .EUt(30)
                .duration(120)
                .save();

        ARC_FURNACE_RECIPES.recipeBuilder(GTECore.id("cosmic_singularity"))
                .inputItems(ModItems.eternal_singularity.get())
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(9216))
                .outputItems(GTEItems.COSMIC_SINGULARITY.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.Shirabon, 64)
                .outputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .EUt(2013265920)
                .duration(800)
                .addCondition(new RestrictedMachineCondition(GTECore.id("magnetic_energy_reaction_furnace")))
                .save();

        ARC_FURNACE_RECIPES.recipeBuilder(GTECore.id("yttrium_barium_cuprate"))
                .inputItems(TagPrefix.dust, GTEMaterials.WellMixedYbcOxides, 12)
                .outputItems(TagPrefix.ingotHot, GTMaterials.YttriumBariumCuprate, 13)
                .inputFluids(GTMaterials.Oxygen.getFluid(1000))
                .EUt(1920)
                .duration(2580)
                .save();
    }
}
