package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.recipe.condition.GravityCondition;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.BIOCHEMICAL_REACTION_RECIPES;

interface BiochemicaReaction {

    static void init() {
        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("pygro_spawn_egg"))
                .inputItems(Items.PIGLIN_SPAWN_EGG.asItem())
                .inputItems(GTEItems.GLACIO_SPIRIT.asItem())
                .outputItems("ad_astra:pygro_spawn_egg")
                .inputFluids(GTMaterials.Mutagen.getFluid(1000))
                .EUt(7680)
                .duration(1600)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("pygro_brute_spawn_egg"))
                .inputItems(Items.PIGLIN_BRUTE_SPAWN_EGG.asItem())
                .inputItems(GTEItems.GLACIO_SPIRIT.asItem())
                .outputItems("ad_astra:pygro_brute_spawn_egg")
                .inputFluids(GTMaterials.Mutagen.getFluid(1000))
                .EUt(7680)
                .duration(1600)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("mogler_spawn_egg"))
                .inputItems(Items.HOGLIN_SPAWN_EGG.asItem())
                .inputItems(GTEItems.GLACIO_SPIRIT.asItem())
                .outputItems("ad_astra:mogler_spawn_egg")
                .inputFluids(GTMaterials.Mutagen.getFluid(1000))
                .EUt(7680)
                .duration(1600)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("sulfur_creeper_spawn_egg"))
                .inputItems(Items.CREEPER_SPAWN_EGG.asItem())
                .inputItems(GTEItems.GLACIO_SPIRIT.asItem())
                .outputItems("ad_astra:sulfur_creeper_spawn_egg")
                .inputFluids(GTMaterials.Mutagen.getFluid(1000))
                .EUt(7680)
                .duration(1600)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.builder("succinic_acid_dust")
                .inputItems(TagPrefix.dust, GTMaterials.Sugar, 24)
                .inputItems(TagPrefix.dust, GTEMaterials.EschericiaColi)
                .outputItems(TagPrefix.dust, GTEMaterials.SuccinicAcid, 14)
                .EUt(480)
                .duration(200)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("succinic_anhydride"))
                .inputItems(TagPrefix.dust, GTEMaterials.Succinimide, 12)
                .inputItems(TagPrefix.dust, GTEMaterials.BrevibacteriumFlavium)
                .outputItems(TagPrefix.dust, GTEMaterials.SuccinicAnhydride, 11)
                .outputFluids(GTMaterials.Ammonia.getFluid(1000))
                .EUt(7680)
                .duration(50)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("shewanella_petri_dish"))
                .inputItems(GTEItems.GREEN_ALGAE_FIBER.asItem())
                .inputItems(GTEItems.PREPARATION_PETRI_DISH.asItem())
                .outputItems(GTEItems.SHEWANELLA_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(2400)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("brevibacterium_petri_dish"))
                .inputItems("farmersdelight:rich_soil")
                .inputItems(GTEItems.PREPARATION_PETRI_DISH.asItem())
                .outputItems(GTEItems.BREVIBACTERIUM_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(2400)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("cupriavidus_petri_dish"))
                .inputItems(Items.COARSE_DIRT.asItem())
                .inputItems(GTEItems.PREPARATION_PETRI_DISH.asItem())
                .outputItems(GTEItems.CUPRIAVIDUS_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(2400)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("eschericia_petri_dish"))
                .inputItems("farmersdelight:minced_beef")
                .inputItems(GTEItems.PREPARATION_PETRI_DISH.asItem())
                .outputItems(GTEItems.ESCHERICIA_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(2400)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("bifidobacteriumm_petri_dish"))
                .inputItems(GTEItems.PREPARATION_PETRI_DISH.asItem())
                .outputItems(GTEItems.BIFIDOBACTERIUMM_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .inputFluids(GTMaterials.Milk.getFluid(1000))
                .EUt(30720)
                .duration(2400)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("streptococcus_petri_dish"))
                .inputItems(Items.ROTTEN_FLESH.asItem())
                .inputItems(GTEItems.PREPARATION_PETRI_DISH.asItem())
                .outputItems(GTEItems.STREPTOCOCCUS_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(2400)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("brevibacterium"))
                .inputItems(GTEItems.BREVIBACTERIUM_PETRI_DISH.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.BrevibacteriumFlavium)
                .outputItems(GTEItems.CONTAMINATED_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("bifidobacteriumm"))
                .inputItems(GTEItems.BIFIDOBACTERIUMM_PETRI_DISH.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.BifidobacteriumBreve)
                .outputItems(GTEItems.CONTAMINATED_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("eschericia"))
                .inputItems(GTEItems.ESCHERICIA_PETRI_DISH.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.EschericiaColi)
                .outputItems(GTEItems.CONTAMINATED_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("streptococcus"))
                .inputItems(GTEItems.STREPTOCOCCUS_PETRI_DISH.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.StreptococcusPyogenes)
                .outputItems(GTEItems.CONTAMINATED_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("cupriavidus"))
                .inputItems(GTEItems.CUPRIAVIDUS_PETRI_DISH.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.CupriavidusNecator)
                .outputItems(GTEItems.CONTAMINATED_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("shewanella"))
                .inputItems(GTEItems.SHEWANELLA_PETRI_DISH.asItem())
                .outputItems(TagPrefix.dust, GTEMaterials.Shewanella)
                .outputItems(GTEItems.CONTAMINATED_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("linoleic_acid"))
                .inputItems(TagPrefix.dust, GTEMaterials.Yeast, 6)
                .inputFluids(GTMaterials.Biomass.getFluid(1000))
                .outputFluids(GTEMaterials.LinoleicAcid.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("chitosan"))
                .inputItems(TagPrefix.dust, GTEMaterials.BifidobacteriumBreve, 8)
                .inputFluids(GTEMaterials.Chitin.getFluid(1000))
                .outputFluids(GTEMaterials.Chitosan.getFluid(1000))
                .EUt(1920)
                .duration(100)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("pluripotency_induction_gene_plasmids"))
                .inputItems(TagPrefix.dust, GTEMaterials.EschericiaColi, 8)
                .inputFluids(GTEMaterials.Cas9Protein.getFluid(1000))
                .inputFluids(GTEMaterials.MycGene.getFluid(1000))
                .inputFluids(GTEMaterials.Oct4Gene.getFluid(1000))
                .inputFluids(GTEMaterials.Sox2Gene.getFluid(1000))
                .inputFluids(GTEMaterials.Kfl4Gene.getFluid(1000))
                .outputFluids(GTEMaterials.PluripotencyInductionGenePlasmids.getFluid(1000))
                .EUt(1920)
                .duration(50)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("cas9_protein"))
                .inputItems(TagPrefix.dust, GTEMaterials.StreptococcusPyogenes, 12)
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .outputFluids(GTEMaterials.Cas9Protein.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("biotin"))
                .inputItems(TagPrefix.dust, GTEMaterials.CupriavidusNecator, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Sugar, 2)
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .inputFluids(GTMaterials.Nitrogen.getFluid(1000))
                .outputFluids(GTEMaterials.Biotin.getFluid(1000))
                .EUt(7680)
                .duration(40)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("clear_ammonia_solution"))
                .inputItems(TagPrefix.dust, GTEMaterials.BrevibacteriumFlavium, 4)
                .inputItems(TagPrefix.dust, GTMaterials.Sugar, 4)
                .outputItems(TagPrefix.dust, GTEMaterials.Glutamine, 40)
                .inputFluids(GTEMaterials.ClearAmmoniaSolution.getFluid(1000))
                .EUt(7680)
                .duration(500)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("raw_growth_medium"))
                .inputItems(TagPrefix.dust, GTEMaterials.Glutamine, 20)
                .inputFluids(GTEMaterials.BasicFibroblastGrowthFactor.getFluid(1000))
                .inputFluids(GTEMaterials.AmmoniumNitrateSolution.getFluid(1000))
                .inputFluids(GTEMaterials.B27Supplement.getFluid(1000))
                .inputFluids(GTEMaterials.EpidermalGrowthFactor.getFluid(1000))
                .outputFluids(GTMaterials.RawGrowthMedium.getFluid(4000))
                .EUt(480)
                .duration(500)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("unknownnutrientagar"))
                .inputItems(TagPrefix.dust, GTMaterials.Salt, 16)
                .inputItems(TagPrefix.dust, GTMaterials.Meat, 16)
                .inputItems(TagPrefix.dust, GTMaterials.Agar, 16)
                .inputFluids(GTEMaterials.UnknowWater.getFluid(4000))
                .inputFluids(GTMaterials.PhthalicAcid.getFluid(4000))
                .outputFluids(GTEMaterials.UnknownNutrientAgar.getFluid(8000))
                .EUt(1920)
                .duration(400)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("rawgrowthmedium"))
                .inputItems(TagPrefix.dust, GTEMaterials.Glutamine, 20)
                .inputFluids(GTEMaterials.BiomediumRaw.getFluid(1000))
                .inputFluids(GTMaterials.Mutagen.getFluid(1000))
                .inputFluids(GTMaterials.Biomass.getFluid(100000))
                .outputFluids(GTMaterials.RawGrowthMedium.getFluid(100000))
                .EUt(8388608)
                .duration(20)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("biomediumraw"))
                .inputItems(GTItems.STEM_CELLS.asStack(64))
                .inputItems(GTEItems.TCETIESEAWEEDEXTRACT.asStack(16))
                .inputItems(TagPrefix.dust, GTMaterials.Tritanium)
                .inputFluids(GTMaterials.RawGrowthMedium.getFluid(1000))
                .outputFluids(GTEMaterials.BiomediumRaw.getFluid(1000))
                .EUt(1920)
                .duration(1200)
                .addCondition(new GravityCondition(true))
                .addData("radioactivity", 120)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("stem_cells"))
                .circuitMeta(1)
                .inputItems(GTEItems.STERILIZED_PETRI_DISH.asItem())
                .outputItems(GTItems.STEM_CELLS.asStack())
                .outputItems(GTEItems.CONTAMINATED_PETRI_DISH.asItem())
                .inputFluids(GTEMaterials.PluripotencyInductionGeneTherapyFluid.getFluid(1000))
                .inputFluids(GTEMaterials.AnimalCells.getFluid(1000))
                .inputFluids(GTMaterials.SterileGrowthMedium.getFluid(1000))
                .EUt(30720)
                .duration(1000)
                .addData("radioactivity", 10)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("biological_cells"))
                .inputItems(GTEItems.STERILIZED_PETRI_DISH.asItem())
                .inputItems(GTItems.STEM_CELLS.asStack(1))
                .inputItems(TagPrefix.dust, GTMaterials.NaquadahEnriched)
                .inputFluids(GTEMaterials.BiohmediumSterilized.getFluid(1000))
                .inputFluids(GTMaterials.Mutagen.getFluid(1000))
                .outputItems(GTEItems.BIOLOGICAL_CELLS.asStack(1))
                .outputItems(GTEItems.CONTAMINATED_PETRI_DISH.asItem())
                .EUt(122880)
                .duration(400)
                .addData("radioactivity", 60)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("dragon_cells"))
                .inputItems(GTEItems.DRAGON_STEM_CELLS.asStack(1))
                .inputItems(TagPrefix.dust, GTMaterials.Naquadria, 16)
                .inputFluids(GTEMaterials.BiohmediumSterilized.getFluid(10000))
                .inputFluids(GTMaterials.Mutagen.getFluid(10000))
                .outputItems(GTEItems.DRAGON_CELLS.asStack(1))
                .EUt(491520)
                .duration(800)
                .addData("radioactivity", 560)
                .save();

        BIOCHEMICAL_REACTION_RECIPES.recipeBuilder(GTECore.id("rapidly_replicating_animal_cells"))
                .circuitMeta(2)
                .inputFluids(GTEMaterials.AnimalCells.getFluid(1000))
                .outputFluids(GTEMaterials.RapidlyReplicatingAnimalCells.getFluid(1000))
                .EUt(7680)
                .duration(500)
                .addData("radioactivity", 240)
                .save();
    }
}
