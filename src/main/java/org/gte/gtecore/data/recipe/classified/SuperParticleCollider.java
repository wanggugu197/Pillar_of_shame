package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.SUPER_PARTICLE_COLLIDER_RECIPES;

interface SuperParticleCollider {

    static void init() {
        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("antimatter"))
                .inputFluids(GTEMaterials.Antihydrogen.getFluid(2000))
                .inputFluids(GTEMaterials.Antineutron.getFluid(2000))
                .outputFluids(GTEMaterials.Antimatter.getFluid(100))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("antineutron"))
                .inputFluids(GTEMaterials.PositiveElectron.getFluid(100))
                .inputFluids(GTEMaterials.Antiproton.getFluid(100))
                .outputFluids(GTEMaterials.Antineutron.getFluid(2))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("roentgeniuma"))
                .inputFluids(GTMaterials.Meitnerium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Roentgenium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("positive_electron"))
                .inputFluids(GTMaterials.Phosphorus.getFluid(200))
                .inputFluids(GTMaterials.Lithium.getFluid(200))
                .outputFluids(GTEMaterials.PositiveElectron.getFluid(100))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("antiproton"))
                .inputFluids(GTEMaterials.LiquidHydrogen.getFluid(1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 200))
                .outputFluids(GTEMaterials.Antiproton.getFluid(100))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("nihoniuma"))
                .inputFluids(GTMaterials.Roentgenium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Nihonium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("einsteiniuma"))
                .inputFluids(GTMaterials.Curium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Einsteinium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("nobeliuma"))
                .inputFluids(GTMaterials.Fermium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Nobelium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("californiuma"))
                .inputFluids(GTMaterials.Berkelium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Californium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("plutoniuma"))
                .inputFluids(GTMaterials.Uranium238.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Plutonium239.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("berkeliuma"))
                .inputFluids(GTMaterials.Americium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Berkelium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("curiuma"))
                .inputFluids(GTMaterials.Plutonium239.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Curium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("neptuniuma"))
                .inputFluids(GTMaterials.Protactinium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Neptunium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("uraniuma"))
                .inputFluids(GTMaterials.Thorium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Uranium238.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("astatinea"))
                .inputFluids(GTMaterials.Bismuth.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Astatine.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("lawrenciuma"))
                .inputFluids(GTMaterials.Mendelevium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Lawrencium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("mendeleviuma"))
                .inputFluids(GTMaterials.Einsteinium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Mendelevium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("coperniciuma"))
                .inputFluids(GTMaterials.Darmstadtium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Copernicium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("bohriuma"))
                .inputFluids(GTMaterials.Dubnium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Bohrium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();

        SUPER_PARTICLE_COLLIDER_RECIPES.recipeBuilder(GTECore.id("fermiuma"))
                .inputFluids(GTMaterials.Californium.getFluid(4096))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 4096))
                .outputFluids(GTMaterials.Fermium.getFluid(4000))
                .EUt(491520)
                .duration(200)
                .save();
    }
}
