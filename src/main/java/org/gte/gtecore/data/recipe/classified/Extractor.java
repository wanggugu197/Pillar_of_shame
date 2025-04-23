package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.recipe.condition.GravityCondition;
import org.gte.gtecore.utils.RLUtils;
import org.gte.gtecore.utils.TagUtils;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidStack;

import com.enderio.base.common.init.EIOFluids;
import dev.shadowsoffire.apotheosis.ench.Ench;

import static org.gte.gtecore.common.data.GTERecipeTypes.EXTRACTOR_RECIPES;

interface Extractor {

    static void init() {
        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("tannic"))
                .inputItems(new ItemStack(Blocks.NETHER_WART_BLOCK.asItem()))
                .outputFluids(GTEMaterials.Tannic.getFluid(50))
                .EUt(30)
                .duration(200)
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("xpjuice"))
                .inputItems(TagPrefix.block, GTMaterials.Sculk)
                .outputFluids(new FluidStack(EIOFluids.XP_JUICE.get().getSource(), 100))
                .EUt(120)
                .duration(20)
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("milk"))
                .inputItems(new ItemStack(Items.MILK_BUCKET.asItem()))
                .outputItems(new ItemStack(Items.BUCKET.asItem()))
                .outputFluids(GTMaterials.Milk.getFluid(1000))
                .EUt(16)
                .duration(60)
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("tcetieseaweedextract"))
                .inputItems(GTEItems.TCETIEDANDELIONS.asStack(64))
                .outputItems(GTEItems.TCETIESEAWEEDEXTRACT.asItem())
                .EUt(16)
                .duration(200)
                .addCondition(new GravityCondition(false))
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("bones"))
                .inputItems(new ItemStack(Blocks.DIRT.asItem()))
                .chancedOutput(TagPrefix.rod, GTMaterials.Bone, 25, 0)
                .EUt(16)
                .duration(100)
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("dragon_breath"))
                .inputItems(Ench.Items.INFUSED_BREATH.get(), 3)
                .outputItems(new ItemStack(Items.GLASS_BOTTLE.asItem()))
                .outputFluids(GTEMaterials.DragonBreath.getFluid(1000))
                .EUt(30)
                .duration(200)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("tin"))
                .inputItems(TagPrefix.dust, GTMaterials.Tin)
                .outputFluids(GTMaterials.Tin.getFluid(144))
                .duration(240)
                .EUt(30)
                .heat(600)
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("algae"))
                .inputItems(TagUtils.createTag(GTECore.id("algae")))
                .outputItems(TagPrefix.dust, GTEMaterials.AlgaeExtract)
                .duration(120)
                .EUt(30)
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("liquid_sunshine"))
                .inputItems(TagPrefix.dust, GTMaterials.Glowstone)
                .outputFluids(new FluidStack(EIOFluids.LIQUID_SUNSHINE.getSource(), 100))
                .EUt(120)
                .duration(400)
                .daytime()
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("blood"))
                .inputItems(TagPrefix.dust, GTMaterials.Meat)
                .outputFluids(GTEMaterials.Blood.getFluid(100))
                .EUt(120)
                .duration(50)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        EXTRACTOR_RECIPES.recipeBuilder(GTECore.id("chitin"))
                .inputItems(TagUtils.createTag(RLUtils.forge("mushrooms")))
                .outputFluids(GTEMaterials.Chitin.getFluid(100))
                .EUt(30)
                .duration(100)
                .save();
    }
}
