package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import com.enderio.base.common.init.EIOItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.MOLECULAR_TRANSFORMER_RECIPES;

interface MolecularTransformer {

    static void init() {
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("diamond"))
                .inputItems(TagPrefix.gem, GTMaterials.Coal, 4)
                .outputItems(TagPrefix.gem, GTMaterials.Diamond)
                .EUt(7680)
                .duration(120)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("damascus_steel_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Steel)
                .outputItems(TagPrefix.dust, GTMaterials.DamascusSteel)
                .EUt(480)
                .duration(20)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("wrought_iron_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Iron)
                .outputItems(TagPrefix.dust, GTMaterials.WroughtIron)
                .EUt(120)
                .duration(20)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("bone"))
                .inputItems(TagPrefix.dust, GTMaterials.Bone, 6)
                .outputItems(TagPrefix.rod, GTMaterials.Bone)
                .EUt(30)
                .duration(40)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("nether_star"))
                .inputItems(new ItemStack(Blocks.WITHER_SKELETON_SKULL.asItem(), 2))
                .outputItems(TagPrefix.gem, GTMaterials.NetherStar)
                .EUt(1920)
                .duration(800)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("small_sunnarium_dust"))
                .inputItems(EIOItems.CLAYED_GLOWSTONE.asItem())
                .outputItems(TagPrefix.dustSmall, GTEMaterials.Sunnarium)
                .EUt(524288)
                .duration(1600)
                .daytime()
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("steel_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.WroughtIron)
                .outputItems(TagPrefix.dust, GTMaterials.Steel)
                .EUt(480)
                .duration(80)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("coal"))
                .inputItems(TagPrefix.gem, GTMaterials.Charcoal)
                .outputItems(TagPrefix.gem, GTMaterials.Coal)
                .EUt(120)
                .duration(200)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("quartzite_certus_quartz_crystal"))
                .inputItems(TagPrefix.gem, GTMaterials.Quartzite)
                .outputItems(TagPrefix.gem, GTMaterials.CertusQuartz)
                .EUt(120)
                .duration(160)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("powdered_coal"))
                .inputItems(TagPrefix.dust, GTMaterials.Carbon, 2)
                .outputItems(TagPrefix.dust, GTMaterials.Coal)
                .EUt(120)
                .duration(200)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("activated_carbon_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Coal)
                .outputItems(TagPrefix.dust, GTMaterials.ActivatedCarbon)
                .EUt(122880)
                .duration(20)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("energy_crystal"))
                .inputItems(TagPrefix.gemExquisite, GTMaterials.Ruby)
                .outputItems(GTItems.ENERGIUM_CRYSTAL.asStack(2))
                .EUt(524288)
                .duration(200)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("quartz_certus_quartz_crystal"))
                .inputItems(TagPrefix.gem, GTMaterials.NetherQuartz)
                .outputItems(TagPrefix.gem, GTMaterials.CertusQuartz)
                .EUt(120)
                .duration(160)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("lapotron_gem"))
                .inputItems(TagPrefix.gemExquisite, GTMaterials.Sodalite)
                .outputItems(TagPrefix.gem, GTMaterials.Lapotron)
                .EUt(524288)
                .duration(800)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("small_bone_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Calcium)
                .outputItems(TagPrefix.dust, GTMaterials.Bone)
                .EUt(30)
                .duration(80)
                .save();

        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder(GTECore.id("graphene"))
                .inputItems(TagPrefix.dust, GTMaterials.Graphite)
                .outputItems(TagPrefix.dust, GTMaterials.Graphene)
                .EUt(524288)
                .duration(180)
                .save();
    }
}
