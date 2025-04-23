package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.POLARIZER_RECIPES;

interface Polarizer {

    static void init() {
        POLARIZER_RECIPES.recipeBuilder(GTECore.id("attuned_tengam_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.PurifiedTengam)
                .outputItems(TagPrefix.dust, GTEMaterials.AttunedTengam)
                .EUt(125829120)
                .duration(400)
                .save();

        POLARIZER_RECIPES.recipeBuilder(GTECore.id("small_attuned_tengam_dust"))
                .inputItems(TagPrefix.dustSmall, GTEMaterials.PurifiedTengam)
                .outputItems(TagPrefix.dustSmall, GTEMaterials.AttunedTengam)
                .EUt(31457280)
                .duration(400)
                .save();

        POLARIZER_RECIPES.recipeBuilder(GTECore.id("triplet_neutronium_sphere"))
                .inputItems(GTEItems.NEUTRONIUM_SPHERE.asItem())
                .outputItems(GTEItems.TRIPLET_NEUTRONIUM_SPHERE.asItem())
                .EUt(5000000)
                .duration(200)
                .save();

        POLARIZER_RECIPES.recipeBuilder(GTECore.id("energetic_netherite"))
                .inputItems(Items.NETHERITE_BLOCK.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.EnergeticNetherite)
                .EUt(2097152)
                .duration(200)
                .save();

        POLARIZER_RECIPES.recipeBuilder(GTECore.id("energetic_netherite_a"))
                .inputItems(TagPrefix.ingot, GTMaterials.Netherite)
                .outputItems(TagPrefix.dust, GTEMaterials.EnergeticNetherite)
                .EUt(33554432)
                .duration(200)
                .save();

        POLARIZER_RECIPES.recipeBuilder(GTECore.id("energetic_netherite_b"))
                .inputItems(TagPrefix.dust, GTMaterials.Netherite)
                .outputItems(TagPrefix.dust, GTEMaterials.EnergeticNetherite)
                .EUt(134217728)
                .duration(20)
                .save();
    }
}
