package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import static org.gte.gtecore.common.data.GTERecipeTypes.NEUTRON_ACTIVATOR_RECIPES;

interface NeutronActivator {

    static void init() {
        NEUTRON_ACTIVATOR_RECIPES.recipeBuilder(GTECore.id("oganesson"))
                .inputFluids(GTEMaterials.MetastableOganesson.getFluid(1000))
                .outputFluids(GTMaterials.Oganesson.getFluid(1000))
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .addData("ev_min", 720)
                .addData("ev_max", 800)
                .addData("evt", 1200)
                .save();

        NEUTRON_ACTIVATOR_RECIPES.recipeBuilder(GTECore.id("quantanium"))
                .inputItems(GTItems.QUANTUM_STAR.asStack(4))
                .inputItems(GTItems.QUANTUM_EYE.asStack(8))
                .inputItems(TagPrefix.dust, GTEMaterials.Mithril, 16)
                .inputItems(TagPrefix.dust, GTMaterials.Gadolinium, 16)
                .inputItems(TagPrefix.gemExquisite, GTEMaterials.Fluix, 16)
                .inputItems(TagPrefix.dust, GTEMaterials.EnergeticNetherite, 64)
                .inputFluids(GTMaterials.Neon.getFluid(10000))
                .outputFluids(GTEMaterials.Quantanium.getFluid(10000))
                .duration(1200)
                .addData("ev_min", 1020)
                .addData("ev_max", 1200)
                .addData("evt", 3840)
                .save();

        NEUTRON_ACTIVATOR_RECIPES.recipeBuilder(GTECore.id("draconium_dust"))
                .notConsumable(TagPrefix.plate, GTEMaterials.DegenerateRhenium)
                .inputItems(new ItemStack(Blocks.DRAGON_EGG.asItem()))
                .inputFluids(GTEMaterials.UuAmplifier.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.EnderEye, 8)
                .outputItems(TagPrefix.dust, GTMaterials.EnderPearl, 4)
                .chancedOutput(GTEItems.DRACONIUM_DIRT.asStack(), 4000, 0)
                .duration(800)
                .addData("ev_min", 800)
                .addData("ev_max", 900)
                .addData("evt", 5760)
                .save();

        NEUTRON_ACTIVATOR_RECIPES.recipeBuilder(GTECore.id("hassium"))
                .inputFluids(GTEMaterials.MetastableHassium.getFluid(FluidStorageKeys.LIQUID, 1000))
                .outputFluids(GTMaterials.Hassium.getFluid(1000))
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .addData("ev_min", 340)
                .addData("ev_max", 380)
                .addData("evt", 480)
                .save();

        NEUTRON_ACTIVATOR_RECIPES.recipeBuilder(GTECore.id("netherite"))
                .inputItems(new ItemStack(Items.NETHERITE_SCRAP.asItem(), 4))
                .outputItems(TagPrefix.dust, GTMaterials.Netherite)
                .inputFluids(GTMaterials.Gold.getFluid(576))
                .duration(600)
                .addData("ev_min", 100)
                .addData("ev_max", 1200)
                .addData("evt", 300)
                .save();

        NEUTRON_ACTIVATOR_RECIPES.recipeBuilder(GTECore.id("netherite_a"))
                .inputItems(Items.ANCIENT_DEBRIS.asItem())
                .outputItems(TagPrefix.dust, GTMaterials.Netherite)
                .duration(400)
                .addData("ev_min", 1100)
                .addData("ev_max", 1200)
                .addData("evt", GTValues.VH[GTValues.OpV])
                .save();
    }
}
