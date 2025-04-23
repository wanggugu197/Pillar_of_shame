package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.common.data.GTEItems;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.WORLD_DATA_SCANNER_RECIPES;

interface WorldDataScanner {

    static void init() {
        WORLD_DATA_SCANNER_RECIPES.recipeBuilder(GTECore.id("end_data"))
                .inputItems(GTItems.TOOL_DATA_STICK.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Endstone, 64)
                .inputFluids(GTMaterials.PCBCoolant.getFluid(1000))
                .inputFluids(GTMaterials.EnderAir.getFluid(64000))
                .outputItems(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.THE_END))
                .EUt(480)
                .duration(4000)
                .dimension(GTEDimensions.VOID)
                .save();

        WORLD_DATA_SCANNER_RECIPES.recipeBuilder(GTECore.id("nether_data"))
                .inputItems(GTItems.TOOL_DATA_STICK.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Netherrack, 64)
                .inputFluids(GTMaterials.PCBCoolant.getFluid(1000))
                .inputFluids(GTMaterials.NetherAir.getFluid(64000))
                .outputItems(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.THE_NETHER))
                .EUt(120)
                .duration(4000)
                .dimension(GTEDimensions.FLAT)
                .save();

        WORLD_DATA_SCANNER_RECIPES.recipeBuilder(GTECore.id("otherside_data"))
                .inputItems(GTItems.TOOL_DATA_STICK.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.EchoShard, 64)
                .inputFluids(GTMaterials.PCBCoolant.getFluid(64000))
                .outputItems(GTEItems.DIMENSION_DATA.get().getDimensionData(GTEDimensions.OTHERSIDE))
                .EUt(122880)
                .duration(4000)
                .dimension(GTEDimensions.OTHERSIDE)
                .save();
    }
}
