package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import static org.gte.gtecore.common.data.GTERecipeTypes.BEDROCK_DRILLING_RIG_RECIPES;

interface BedrockDrillingRig {

    static void init() {
        BEDROCK_DRILLING_RIG_RECIPES.recipeBuilder(GTECore.id("bedrock_dust_4"))
                .chancedInput(GTEItems.BEDROCK_DRILL.asStack(256), 10, 0)
                .circuitMeta(5)
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium, 256)
                .EUt(7864320)
                .duration(3200)
                .save();

        BEDROCK_DRILLING_RIG_RECIPES.recipeBuilder(GTECore.id("bedrock_dust_3"))
                .chancedInput(GTEItems.BEDROCK_DRILL.asStack(64), 10, 0)
                .circuitMeta(4)
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium, 64)
                .EUt(7864320)
                .duration(1600)
                .save();

        BEDROCK_DRILLING_RIG_RECIPES.recipeBuilder(GTECore.id("bedrock_dust_6"))
                .chancedInput(GTEItems.BEDROCK_DRILL.asStack(4096), 10, 0)
                .circuitMeta(7)
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium, 4096)
                .EUt(7864320)
                .duration(12800)
                .save();

        BEDROCK_DRILLING_RIG_RECIPES.recipeBuilder(GTECore.id("bedrock_dust_5"))
                .chancedInput(GTEItems.BEDROCK_DRILL.asStack(1024), 10, 0)
                .circuitMeta(6)
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium, 1024)
                .EUt(7864320)
                .duration(6400)
                .save();

        BEDROCK_DRILLING_RIG_RECIPES.recipeBuilder(GTECore.id("bedrock_dust_0"))
                .chancedInput(GTEItems.BEDROCK_DRILL.asStack(), 10, 0)
                .circuitMeta(1)
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium)
                .EUt(7864320)
                .duration(200)
                .save();

        BEDROCK_DRILLING_RIG_RECIPES.recipeBuilder(GTECore.id("bedrock_dust_2"))
                .chancedInput(GTEItems.BEDROCK_DRILL.asStack(16), 10, 0)
                .circuitMeta(3)
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium, 16)
                .EUt(7864320)
                .duration(800)
                .save();

        BEDROCK_DRILLING_RIG_RECIPES.recipeBuilder(GTECore.id("bedrock_dust_1"))
                .chancedInput(GTEItems.BEDROCK_DRILL.asStack(4), 10, 0)
                .circuitMeta(2)
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium, 4)
                .EUt(7864320)
                .duration(400)
                .save();

        BEDROCK_DRILLING_RIG_RECIPES.recipeBuilder(GTECore.id("bedrock_dust_7"))
                .chancedInput(GTEItems.BEDROCK_DRILL.asStack(16384), 10, 0)
                .circuitMeta(8)
                .outputItems(TagPrefix.dust, GTEMaterials.Bedrockium, 16384)
                .EUt(7864320)
                .duration(25600)
                .save();
    }
}
