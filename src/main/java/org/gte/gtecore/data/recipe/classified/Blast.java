package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.BLAST_RECIPES;

interface Blast {

    static void init() {
        BLAST_RECIPES.builder("molten_stainless_steel")
                .inputItems(TagPrefix.dust, GTMaterials.StainlessSteel, 8)
                .inputFluids(GTMaterials.StainlessSteel, 1152)
                .outputFluids(GTMaterials.StainlessSteel.getFluid(FluidStorageKeys.MOLTEN, 2304))
                .EUt(120)
                .duration(480)
                .blastFurnaceTemp(2428)
                .circuitMeta(3)
                .save();

        BLAST_RECIPES.builder("molten_manganese_phosphide")
                .inputItems(TagPrefix.dust, GTMaterials.ManganesePhosphide, 8)
                .inputFluids(GTMaterials.ManganesePhosphide, 1152)
                .outputFluids(GTMaterials.ManganesePhosphide.getFluid(FluidStorageKeys.MOLTEN, 2304))
                .EUt(120)
                .duration(400)
                .blastFurnaceTemp(1200)
                .circuitMeta(3)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("alumina_ceramic"))
                .inputItems(GTETagPrefix.ROUGH_BLANK, GTEMaterials.AluminaCeramic)
                .outputItems(TagPrefix.block, GTEMaterials.AluminaCeramic)
                .inputFluids(GTMaterials.Nitrogen.getFluid(500))
                .EUt(120)
                .duration(600)
                .blastFurnaceTemp(2700)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("hot_draconium_ingot_1"))
                .inputItems(TagPrefix.dust, GTEMaterials.Draconium)
                .inputFluids(GTMaterials.CetaneBoostedDiesel.getFluid(2000))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Draconium)
                .EUt(125829120)
                .duration(800)
                .blastFurnaceTemp(21600)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("hot_draconium_ingot_3"))
                .inputItems(TagPrefix.dust, GTEMaterials.Draconium)
                .inputFluids(GTMaterials.HighOctaneGasoline.getFluid(500))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Draconium)
                .EUt(125829120)
                .duration(200)
                .blastFurnaceTemp(21600)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("hot_draconium_ingot_2"))
                .inputItems(TagPrefix.dust, GTEMaterials.Draconium)
                .inputFluids(GTMaterials.Gasoline.getFluid(1000))
                .outputItems(TagPrefix.ingotHot, GTEMaterials.Draconium)
                .EUt(125829120)
                .duration(400)
                .blastFurnaceTemp(21600)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("rutherfordium_neutronium_boule"))
                .inputItems(GTItems.NEUTRONIUM_BOULE.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Rutherfordium, 4)
                .inputFluids(GTMaterials.Radon.getFluid(8000))
                .outputItems(GTEItems.RUTHERFORDIUM_AMPROSIUM_BOULE.asItem())
                .EUt(30720)
                .duration(21000)
                .blastFurnaceTemp(8100)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("ostrum_ingot"))
                .inputItems(TagPrefix.dust, GTEMaterials.Ostrum)
                .inputItems(TagPrefix.dust, GTMaterials.TitaniumCarbide)
                .inputFluids(GTMaterials.SamariumIronArsenicOxide.getFluid(144))
                .outputItems(TagPrefix.ingot, GTEMaterials.Ostrum)
                .EUt(1920)
                .duration(2400)
                .blastFurnaceTemp(5200)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("shining_obsidian"))
                .inputItems(TagPrefix.rock, GTMaterials.Obsidian)
                .inputItems(TagPrefix.dust, GTEMaterials.VibrantAlloy)
                .inputFluids(GTMaterials.Glowstone.getFluid(576))
                .outputItems(GTEBlocks.SHINING_OBSIDIAN.asItem())
                .EUt(480)
                .duration(600)
                .blastFurnaceTemp(2600)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("calorite_ingot"))
                .inputItems(TagPrefix.ingot, GTMaterials.Naquadah)
                .inputItems(TagPrefix.dust, GTEMaterials.Calorite)
                .outputItems(TagPrefix.ingot, GTEMaterials.Calorite)
                .EUt(1920)
                .duration(3200)
                .blastFurnaceTemp(6100)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("giga_chad"))
                .inputItems(GTItems.FIELD_GENERATOR_UIV.asStack(64))
                .inputItems(GTItems.FIELD_GENERATOR_UXV.asStack(64))
                .inputItems(GTItems.FIELD_GENERATOR_OpV.asStack(64))
                .inputFluids(GTEMaterials.ExcitedDtec.getFluid(10000000))
                .outputItems(GTEItems.GIGA_CHAD.asItem())
                .EUt(2013265920)
                .duration(4000)
                .blastFurnaceTemp(36000)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("desh_ingot"))
                .inputItems(TagPrefix.dust, GTEMaterials.Desh)
                .inputItems(TagPrefix.dust, GTMaterials.Rhodium)
                .inputFluids(GTMaterials.BismuthBronze.getFluid(144))
                .outputItems(TagPrefix.ingot, GTEMaterials.Desh)
                .EUt(1920)
                .duration(1600)
                .blastFurnaceTemp(4300)
                .save();

        BLAST_RECIPES.recipeBuilder(GTECore.id("bedrock_smoke"))
                .inputItems(TagPrefix.dust, GTEMaterials.Bedrockium)
                .inputFluids(GTMaterials.Xenon.getFluid(100))
                .outputFluids(GTEMaterials.BedrockSmoke.getFluid(1000))
                .EUt(7864320)
                .duration(400)
                .blastFurnaceTemp(16200)
                .save();
    }
}
