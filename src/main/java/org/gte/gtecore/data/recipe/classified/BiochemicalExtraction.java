package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.data.tag.Tags;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.BIOCHEMICAL_EXTRACTION_RECIPES;

interface BiochemicalExtraction {

    static void init() {
        BIOCHEMICAL_EXTRACTION_RECIPES.recipeBuilder(GTECore.id("cow_spawn_egg"))
                .notConsumable(Items.COW_SPAWN_EGG.asItem())
                .outputFluids(GTMaterials.Milk.getFluid(1000))
                .EUt(2)
                .duration(200)
                .save();

        BIOCHEMICAL_EXTRACTION_RECIPES.recipeBuilder(GTECore.id("cerebrum"))
                .notConsumable(Tags.HUMAN_EGG)
                .outputItems(GTEItems.CEREBRUM)
                .duration(200)
                .EUt(30)
                .save();

        BIOCHEMICAL_EXTRACTION_RECIPES.recipeBuilder(GTECore.id("mycgene"))
                .notConsumable("ad_astra:pygro_spawn_egg")
                .inputFluids(GTEMaterials.RapidlyReplicatingAnimalCells.getFluid(1000))
                .outputFluids(GTEMaterials.MycGene.getFluid(100))
                .EUt(480)
                .duration(200)
                .save();

        BIOCHEMICAL_EXTRACTION_RECIPES.recipeBuilder(GTECore.id("oct4gene"))
                .notConsumable("ad_astra:pygro_brute_spawn_egg")
                .inputFluids(GTEMaterials.RapidlyReplicatingAnimalCells.getFluid(1000))
                .outputFluids(GTEMaterials.Oct4Gene.getFluid(100))
                .EUt(480)
                .duration(200)
                .save();

        BIOCHEMICAL_EXTRACTION_RECIPES.recipeBuilder(GTECore.id("sox2gene"))
                .notConsumable("ad_astra:mogler_spawn_egg")
                .inputFluids(GTEMaterials.RapidlyReplicatingAnimalCells.getFluid(1000))
                .outputFluids(GTEMaterials.Sox2Gene.getFluid(100))
                .EUt(480)
                .duration(200)
                .save();

        BIOCHEMICAL_EXTRACTION_RECIPES.recipeBuilder(GTECore.id("kfl4gene"))
                .notConsumable("ad_astra:sulfur_creeper_spawn_egg")
                .inputFluids(GTEMaterials.RapidlyReplicatingAnimalCells.getFluid(1000))
                .outputFluids(GTEMaterials.Kfl4Gene.getFluid(100))
                .EUt(480)
                .duration(200)
                .save();
    }
}
