package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.TagUtils;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import static org.gte.gtecore.common.data.GTERecipeTypes.LOOM_RECIPES;

interface Loom {

    static void init() {
        LOOM_RECIPES.recipeBuilder(GTECore.id("string"))
                .inputItems(GTEItems.PLANT_FIBER.asStack(4))
                .outputItems(new ItemStack(Blocks.TRIPWIRE.asItem()))
                .EUt(120)
                .duration(200)
                .save();

        LOOM_RECIPES.recipeBuilder(GTECore.id("plant_fiber"))
                .inputItems(GTItems.PLANT_BALL.asItem())
                .outputItems(GTEItems.PLANT_FIBER.asStack(2))
                .EUt(7)
                .duration(200)
                .save();

        LOOM_RECIPES.recipeBuilder(GTECore.id("gold_algae_fiber"))
                .inputItems(GTEItems.GOLD_ALGAE.asStack(3))
                .outputItems(GTEItems.GOLD_ALGAE_FIBER.asItem())
                .EUt(30)
                .duration(240)
                .save();

        LOOM_RECIPES.recipeBuilder(GTECore.id("green_algae_fiber"))
                .inputItems(GTEItems.GREEN_ALGAE.asStack(3))
                .outputItems(GTEItems.GREEN_ALGAE_FIBER.asItem())
                .EUt(30)
                .duration(240)
                .save();

        LOOM_RECIPES.recipeBuilder(GTECore.id("red_algae_fiber"))
                .inputItems(GTEItems.RED_ALGAE.asStack(3))
                .outputItems(GTEItems.RED_ALGAE_FIBER.asItem())
                .EUt(30)
                .duration(240)
                .save();

        LOOM_RECIPES.recipeBuilder(GTECore.id("algae_plant_fiber"))
                .inputItems(TagUtils.createTag(GTECore.id("algae_fiber")))
                .outputItems(GTEItems.PLANT_FIBER.asItem())
                .EUt(30)
                .duration(20)
                .save();

        LOOM_RECIPES.recipeBuilder(GTECore.id("woven_kevlar"))
                .inputItems(GTEItems.KEVLAR_FIBER.asStack(8))
                .outputItems(GTEItems.WOVEN_KEVLAR.asStack())
                .EUt(120)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        LOOM_RECIPES.recipeBuilder(GTECore.id("nanotube_spool"))
                .inputItems(TagPrefix.wireFine, GTEMaterials.CarbonNanotubes, 16)
                .outputItems(GTEItems.NANOTUBE_SPOOL.asItem())
                .EUt(7680)
                .duration(200)
                .save();

        LOOM_RECIPES.builder("fluix_covered_dense_cable")
                .inputItems("ae2:fluix_covered_cable", 4)
                .outputItems("ae2:fluix_covered_dense_cable")
                .EUt(32)
                .duration(5)
                .save();

        LOOM_RECIPES.builder("fluix_smart_dense_cable")
                .inputItems("ae2:fluix_smart_cable", 4)
                .outputItems("ae2:fluix_smart_dense_cable")
                .EUt(32)
                .duration(5)
                .save();
    }
}
