package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.FORGE_HAMMER_RECIPES;

interface ForgeHammer {

    static void init() {
        FORGE_HAMMER_RECIPES.recipeBuilder(GTECore.id("prismarine_crystals"))
                .inputItems(new ItemStack(Items.PRISMARINE_SHARD.asItem()))
                .outputItems(new ItemStack(Items.PRISMARINE_CRYSTALS.asItem()))
                .EUt(16)
                .duration(20)
                .save();

        FORGE_HAMMER_RECIPES.recipeBuilder(GTECore.id("long_magmatter_rod"))
                .inputItems(TagPrefix.rod, GTEMaterials.Magmatter, 2)
                .outputItems(TagPrefix.rodLong, GTEMaterials.Magmatter)
                .EUt(2013265920)
                .duration(300)
                .save();

        FORGE_HAMMER_RECIPES.recipeBuilder(GTECore.id("special_ceramics_dust"))
                .inputItems(TagPrefix.block, GTEMaterials.TitaniumNitrideCeramic)
                .outputItems(TagPrefix.dust, GTEMaterials.SpecialCeramics, 4)
                .EUt(7680)
                .duration(400)
                .save();

        FORGE_HAMMER_RECIPES.recipeBuilder(GTECore.id("wrought_iron"))
                .inputItems(GTEItems.HOT_IRON_INGOT.asItem())
                .outputItems(TagPrefix.ingot, GTMaterials.WroughtIron)
                .EUt(16)
                .duration(200)
                .save();

        FORGE_HAMMER_RECIPES.recipeBuilder(GTECore.id("diamond_lattice"))
                .inputItems("avaritia:diamond_lattice_block")
                .outputItems("avaritia:diamond_lattice", 9)
                .EUt(1920)
                .duration(200)
                .save();
    }
}
