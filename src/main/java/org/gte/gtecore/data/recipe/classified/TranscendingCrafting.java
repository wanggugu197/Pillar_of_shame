package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import static org.gte.gtecore.common.data.GTERecipeTypes.TRANSCENDING_CRAFTING_RECIPES;

interface TranscendingCrafting {

    static void init() {
        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("draconium_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Netherrack)
                .inputItems(TagPrefix.dust, GTMaterials.Endstone)
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(1000))
                .inputFluids(GTEMaterials.DragonBreath.getFluid(10))
                .outputItems(GTEItems.DRACONIUM_DIRT.asItem())
                .EUt(7864320)
                .duration(400)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matternugget"))
                .inputItems(TagPrefix.nugget, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(16))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.nugget, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("small_magnetohydrodynamically_constrained_star_matter_dust"))
                .inputItems(TagPrefix.dustSmall, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(36))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.dustSmall, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("liquid_starlight"))
                .inputItems(new ItemStack(Blocks.BLUE_ICE.asItem(), 64))
                .inputItems(new ItemStack(Blocks.BLUE_ICE.asItem(), 64))
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.Starlight.getFluid(10000))
                .outputFluids(GTEMaterials.LiquidStarlight.getFluid(10000))
                .EUt(7864320)
                .duration(9600)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matteringot"))
                .inputItems(TagPrefix.ingot, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(144))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.ingot, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("cosmic_fabric"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.CosmicNeutronium)
                .inputItems(TagPrefix.foil, GTMaterials.Rubber)
                .inputItems(GTEItems.AMORPHOUS_MATTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(1000))
                .inputFluids(GTEMaterials.EnrichedXenoxene.getFluid(1000))
                .inputFluids(GTEMaterials.CosmicMesh.getFluid(FluidStorageKeys.LIQUID, 100))
                .outputItems(GTEItems.COSMIC_FABRIC.asItem())
                .EUt(503316480)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matterrod"))
                .inputItems(TagPrefix.rod, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(72))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.rod, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matterplate"))
                .inputItems(TagPrefix.plate, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(144))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.plate, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("echoite_plasma"))
                .inputItems(TagPrefix.gemExquisite, GTMaterials.EchoShard, 16)
                .inputItems(GTEItems.RHENIUM_PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(16000))
                .inputFluids(GTEMaterials.Enderium.getFluid(1152))
                .inputFluids(GTEMaterials.Infuscolium.getFluid(1152))
                .outputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .outputFluids(GTEMaterials.Echoite.getFluid(FluidStorageKeys.PLASMA, 2304))
                .EUt(31457280)
                .duration(400)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matterfoil"))
                .inputItems(TagPrefix.foil, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(36))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.foil, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("sculk_catalyst"))
                .inputItems(new ItemStack(Blocks.TERRACOTTA.asItem()))
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(1000))
                .inputFluids(GTMaterials.EchoShard.getFluid(100))
                .outputItems(new ItemStack(Blocks.SCULK_CATALYST.asItem()))
                .EUt(7864320)
                .duration(20)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matterframe"))
                .inputItems(TagPrefix.frameGt, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(288))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.frameGt, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magmatter_ingot"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .circuitMeta(1)
                .inputItems(TagPrefix.ingot, GTEMaterials.EnergeticNetherite)
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(100000))
                .inputFluids(GTEMaterials.Magmatter.getFluid(100))
                .outputItems(TagPrefix.ingot, GTEMaterials.Magmatter)
                .EUt(8053063680L)
                .duration(400)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matterblock"))
                .inputItems(TagPrefix.block, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(1296))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.block, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magmatter_ingot_d"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.Magmatter)
                .inputItems(TagPrefix.ingot, GTEMaterials.EnergeticNetherite)
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.Magmatter.getFluid(10))
                .outputItems(TagPrefix.ingot, GTEMaterials.Magmatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("magnetohydrodynamically_constrained_star_matterdust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(144))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("attuned_tengam_ingot"))
                .notConsumable(GTEItems.INGOT_FIELD_SHAPE.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.AttunedTengam)
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(1000))
                .outputItems(TagPrefix.ingot, GTEMaterials.AttunedTengam)
                .EUt(31457280)
                .duration(400)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("photocoated_hassium_boule"))
                .inputItems(GTEItems.HIGH_PURITY_SINGLE_CRYSTAL_SILICON.asItem())
                .inputItems(TagPrefix.ingot, GTMaterials.Hassium, 2)
                .inputItems(GTEItems.HASSIUM_SEED_CRYSTAL.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.WoodsGlass.getFluid(2304))
                .inputFluids(GTEMaterials.Photopolymer.getFluid(2000))
                .outputItems(GTEItems.PHOTOCOATED_HASSIUM_BOULE.asItem())
                .EUt(7864320)
                .duration(1000)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("bedrock_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CompressedStone, 64)
                .inputItems(TagPrefix.dust, GTEMaterials.CompressedStone, 64)
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(100000))
                .inputFluids(GTMaterials.Thulium.getFluid(9216))
                .inputFluids(GTMaterials.Copernicium.getFluid(9216))
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium)
                .EUt(31457280)
                .duration(1200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("dragon_stem_cells"))
                .inputItems(GTItems.STEM_CELLS.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(1000))
                .inputFluids(GTMaterials.Mutagen.getFluid(100))
                .inputFluids(GTEMaterials.EnrichedDragonBreath.getFluid(100))
                .outputItems(GTEItems.DRAGON_STEM_CELLS.asItem())
                .EUt(7864320)
                .duration(400)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("tiny_magnetohydrodynamically_constrained_star_matter_dust"))
                .inputItems(TagPrefix.dustTiny, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(16))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.dustTiny, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("dragon_breath"))
                .inputItems(new ItemStack(Items.GLASS_BOTTLE.asItem()))
                .inputItems(new ItemStack(Blocks.DRAGON_EGG.asItem()))
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(1000))
                .inputFluids(GTEMaterials.DragonBlood.getFluid(10))
                .outputItems(new ItemStack(Items.DRAGON_BREATH.asItem()))
                .EUt(31457280)
                .duration(80)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("double_magnetohydrodynamically_constrained_star_matter_plate"))
                .inputItems(TagPrefix.plateDouble, GTEMaterials.Eternity)
                .inputItems(GTEItems.SOLAR_LIGHT_SPLITTER.asItem())
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(10000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(288))
                .inputFluids(GTEMaterials.DimensionallyTranscendentResidue.getFluid(1000))
                .outputItems(TagPrefix.plateDouble, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .EUt(8053063680L)
                .duration(200)
                .save();

        TRANSCENDING_CRAFTING_RECIPES.recipeBuilder(GTECore.id("dust_blizz"))
                .inputItems(TagPrefix.dust, GTMaterials.Blaze)
                .inputItems(TagPrefix.dust, GTMaterials.AluminiumSulfite)
                .inputItems(new ItemStack(Items.SNOWBALL.asItem(), 16))
                .inputFluids(GTEMaterials.TranscendingMatter.getFluid(1000))
                .inputFluids(GTMaterials.Ice.getFluid(1000))
                .outputItems(GTEItems.DUST_BLIZZ.asStack(2))
                .EUt(7864320)
                .duration(200)
                .save();
    }
}
