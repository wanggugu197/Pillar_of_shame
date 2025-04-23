package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;

import appeng.core.definitions.AEItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.ULTIMATE_MATERIAL_FORGE_RECIPES;

interface UltimateMaterialForge {

    static void init() {
        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("void_matter"))
                .inputItems(GTEItems.OMNI_MATTER.asItem())
                .inputItems(GTEItems.PELLET_ANTIMATTER.asItem())
                .inputFluids(GTMaterials.UUMatter.getFluid(2000))
                .inputFluids(GTEMaterials.Gluons.getFluid(1000))
                .outputItems(GTEItems.VOID_MATTER.asItem())
                .chancedOutput(GTEItems.CORPOREAL_MATTER.asStack(), 2000, 0)
                .EUt(2013265920)
                .duration(400)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("temporal_matter"))
                .notConsumable(GTEItems.QUANTUM_ANOMALY.asItem())
                .inputItems(GTEItems.KINETIC_MATTER.asItem())
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .inputFluids(GTEMaterials.AwakenedDraconium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.TEMPORAL_MATTER.asItem())
                .chancedOutput(GTEItems.OMNI_MATTER.asStack(), 500, 0)
                .EUt(2013265920)
                .duration(600)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("corporeal_matter"))
                .inputItems(GTEItems.PROTO_MATTER.asItem())
                .inputItems(TagPrefix.block, GTMaterials.Iron)
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .inputFluids(GTMaterials.Nihonium.getFluid(100))
                .outputItems(GTEItems.CORPOREAL_MATTER.asItem())
                .chancedOutput(TagPrefix.nugget, GTEMaterials.HeavyQuarkDegenerateMatter, 500, 0)
                .EUt(503316480)
                .duration(800)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("proto_matter"))
                .inputItems(GTEItems.TRIPLET_NEUTRONIUM_SPHERE.asItem())
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .outputItems(GTEItems.PROTO_MATTER.asItem())
                .chancedOutput(TagPrefix.ingot, GTEMaterials.Neutron, 6000, 0)
                .EUt(503316480)
                .duration(1600)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("dark_matter"))
                .inputItems(GTEItems.TEMPORAL_MATTER.asItem())
                .inputItems(GTEItems.VOID_MATTER.asItem())
                .inputFluids(GTMaterials.UUMatter.getFluid(3000))
                .inputFluids(GTEMaterials.DimensionallyTranscendentCrudeCatalyst.getFluid(1000))
                .outputItems(GTEItems.DARK_MATTER.asItem())
                .chancedOutput(GTEItems.KINETIC_MATTER.asStack(), 1000, 0)
                .EUt(2013265920)
                .duration(1200)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("kinetic_matter"))
                .inputItems(GTEItems.CORPOREAL_MATTER.asItem())
                .inputItems(TagPrefix.block, GTMaterials.Tritanium)
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .inputFluids(GTMaterials.Naquadria.getFluid(1000))
                .outputItems(GTEItems.KINETIC_MATTER.asItem())
                .chancedOutput(GTEItems.AMORPHOUS_MATTER.asStack(), 200, 0)
                .EUt(503316480)
                .duration(600)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("amorphous_matter"))
                .inputItems(GTEItems.CORPOREAL_MATTER.asItem())
                .inputItems(TagPrefix.block, GTEMaterials.CarbonNanotubes)
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .inputFluids(GTEMaterials.Legendarium.getFluid(1000))
                .outputItems(GTEItems.AMORPHOUS_MATTER.asItem())
                .chancedOutput(GTEItems.ESSENTIA_MATTER.asStack(), 100, 0)
                .EUt(503316480)
                .duration(800)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("pellet_antimatter"))
                .inputItems(new ItemStack(AEItems.MATTER_BALL.asItem(), 64))
                .inputItems(TagPrefix.nugget, GTEMaterials.Neutron)
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .inputFluids(GTEMaterials.Antihydrogen.getFluid(10))
                .outputItems(GTEItems.PELLET_ANTIMATTER.asItem())
                .chancedOutput(GTEItems.VOID_MATTER.asStack(), 100, 0)
                .EUt(125829120)
                .duration(2000)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("essentia_matter"))
                .inputItems(GTEItems.AMORPHOUS_MATTER.asItem())
                .inputItems(TagPrefix.block, GTEMaterials.HeavyQuarkDegenerateMatter)
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .inputFluids(GTEMaterials.QuantumChromoDynamicallyConfinedMatter.getFluid(1000))
                .outputItems(GTEItems.ESSENTIA_MATTER.asItem())
                .chancedOutput(GTEItems.DARK_MATTER.asStack(), 100, 0)
                .EUt(503316480)
                .duration(1200)
                .save();

        ULTIMATE_MATERIAL_FORGE_RECIPES.recipeBuilder(GTECore.id("omni_matter"))
                .inputItems(GTEItems.ESSENTIA_MATTER.asItem())
                .inputItems(GTEItems.KINETIC_MATTER.asItem())
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .inputFluids(GTEMaterials.DenseNeutron.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.OMNI_MATTER.asItem())
                .chancedOutput(TagPrefix.dustTiny, GTEMaterials.CosmicNeutronium, 1000, 0)
                .EUt(2013265920)
                .duration(800)
                .save();
    }
}
