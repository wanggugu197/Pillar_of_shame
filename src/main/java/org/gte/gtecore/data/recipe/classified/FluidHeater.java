package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraftforge.fluids.FluidStack;

import com.enderio.base.common.init.EIOFluids;

import static org.gte.gtecore.common.data.GTERecipeTypes.FLUID_HEATER_RECIPES;

interface FluidHeater {

    static void init() {
        FLUID_HEATER_RECIPES.recipeBuilder(GTECore.id("supercritical_carbon_dioxide"))
                .inputFluids(GTMaterials.CarbonDioxide.getFluid(1000))
                .outputFluids(GTEMaterials.SupercriticalCarbonDioxide.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save();

        FLUID_HEATER_RECIPES.recipeBuilder(GTECore.id("azafullerene"))
                .notConsumable(TagPrefix.dustTiny, GTMaterials.Rhenium, 36)
                .inputFluids(GTEMaterials.AminatedFullerene.getFluid(100))
                .outputFluids(GTEMaterials.Azafullerene.getFluid(100))
                .EUt(480)
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        FLUID_HEATER_RECIPES.recipeBuilder(GTECore.id("biohmediumsterilized"))
                .inputFluids(GTEMaterials.BiomediumRaw.getFluid(100))
                .outputFluids(GTEMaterials.BiohmediumSterilized.getFluid(100))
                .EUt(480)
                .duration(400)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        FLUID_HEATER_RECIPES.recipeBuilder(GTECore.id("bedrock_gas"))
                .inputFluids(GTEMaterials.CleanBedrockSolution.getFluid(1000))
                .outputFluids(GTEMaterials.BedrockGas.getFluid(1000))
                .EUt(31457280)
                .duration(100)
                .save();

        FLUID_HEATER_RECIPES.recipeBuilder(GTECore.id("heater_germanium_tetrachloride_solution"))
                .inputFluids(GTEMaterials.GermaniumTetrachlorideSolution.getFluid(1000))
                .outputFluids(GTEMaterials.GermaniumTetrachlorideSolution.getFluid(FluidStorageKeys.GAS, 1000))
                .EUt(30)
                .duration(20)
                .save();

        FLUID_HEATER_RECIPES.recipeBuilder(GTECore.id("fire_water"))
                .inputItems(TagPrefix.dustTiny, GTMaterials.Blaze)
                .inputFluids(new FluidStack(EIOFluids.HOOTCH.getSource(), 1000))
                .outputFluids(new FluidStack(EIOFluids.FIRE_WATER.getSource(), 1000))
                .EUt(120)
                .duration(40)
                .save();

        FLUID_HEATER_RECIPES.recipeBuilder(GTECore.id("cloud_seed"))
                .inputItems(GTEItems.GOLD_ALGAE.asStack(4))
                .inputFluids(GTEMaterials.CoolantLiquid.getFluid(1000))
                .outputFluids(new FluidStack(EIOFluids.CLOUD_SEED.getSource(), 1000))
                .EUt(30)
                .duration(300)
                .save();
    }
}
