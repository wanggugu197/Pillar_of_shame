package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeCategories;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import com.enderio.base.common.init.EIOItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.ALLOY_SMELTER_RECIPES;

interface AlloySmelter {

    static void init() {
        ALLOY_SMELTER_RECIPES.builder("mica_insulator_sheet")
                .inputItems(GTEItems.MICA_BASED_SHEET.asStack(5))
                .inputItems(TagPrefix.dust, GTMaterials.SiliconDioxide, 3)
                .outputItems(GTEItems.MICA_INSULATOR_SHEET.asStack(5))
                .EUt(30)
                .duration(400)
                .save();

        ALLOY_SMELTER_RECIPES.recipeBuilder(GTECore.id("vibrant_gear"))
                .inputItems(EIOItems.GEAR_ENERGIZED.asItem())
                .inputItems(TagPrefix.ingot, GTEMaterials.VibrantAlloy, 4)
                .outputItems(EIOItems.GEAR_VIBRANT.asItem())
                .EUt(16)
                .duration(160)
                .save();

        ALLOY_SMELTER_RECIPES.recipeBuilder(GTECore.id("infinity_gear"))
                .inputItems(TagPrefix.gear, GTMaterials.Iron)
                .inputItems(EIOItems.GRAINS_OF_INFINITY.asStack(2))
                .outputItems(EIOItems.GEAR_IRON.asItem())
                .EUt(16)
                .duration(80)
                .save();

        ALLOY_SMELTER_RECIPES.recipeBuilder(GTECore.id("soularium_ingot"))
                .inputItems(TagPrefix.ingot, GTMaterials.Gold)
                .inputItems(new ItemStack(Blocks.SOUL_SAND.asItem()))
                .outputItems(TagPrefix.ingot, GTEMaterials.Soularium)
                .EUt(16)
                .duration(200)
                .save();

        ALLOY_SMELTER_RECIPES.recipeBuilder(GTECore.id("dark_bimetal_gear"))
                .inputItems(EIOItems.GEAR_IRON.asItem())
                .inputItems(TagPrefix.ingot, GTEMaterials.DarkSteel, 4)
                .outputItems(EIOItems.GEAR_DARK_STEEL.asItem())
                .EUt(16)
                .duration(160)
                .save();

        ALLOY_SMELTER_RECIPES.recipeBuilder(GTECore.id("netherite_ingot"))
                .inputItems(new ItemStack(Blocks.NETHERITE_BLOCK.asItem()))
                .notConsumable(GTItems.SHAPE_MOLD_INGOT.asItem())
                .outputItems(TagPrefix.ingot, GTMaterials.Netherite, 9)
                .EUt(7)
                .duration(1188)
                .category(GTRecipeCategories.INGOT_MOLDING)
                .save();

        ALLOY_SMELTER_RECIPES.recipeBuilder(GTECore.id("energetic_gear"))
                .inputItems(EIOItems.GEAR_IRON.asItem())
                .inputItems(TagPrefix.ingot, GTEMaterials.EnergeticAlloy, 4)
                .outputItems(EIOItems.GEAR_ENERGIZED.asItem())
                .EUt(16)
                .duration(120)
                .save();
    }
}
