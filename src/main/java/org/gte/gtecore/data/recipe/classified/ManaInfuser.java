package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.TagUtils;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.MANA_INFUSER_RECIPES;

interface ManaInfuser {

    static void init() {
        MANA_INFUSER_RECIPES.builder("livingwood_log")
                .inputItems(Items.OAK_LOG.asItem(), 16)
                .outputItems("botania:livingwood_log", 16)
                .duration(20)
                .MANAt(8)
                .save();

        MANA_INFUSER_RECIPES.builder("livingrock")
                .inputItems(TagPrefix.rock, GTMaterials.Stone, 16)
                .outputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .duration(20)
                .MANAt(8)
                .save();

        MANA_INFUSER_RECIPES.builder("mana_dust")
                .inputItems(TagUtils.createTGTag("dusts"))
                .outputItems(TagPrefix.dust, GTEMaterials.Mana)
                .duration(20)
                .MANAt(32)
                .save();

        MANA_INFUSER_RECIPES.builder("mana_string")
                .inputItems(Items.STRING)
                .outputItems("botania:mana_string")
                .duration(20)
                .MANAt(1)
                .save();

        MANA_INFUSER_RECIPES.builder("managlass")
                .inputItems(TagPrefix.block, GTMaterials.Glass)
                .outputItems(TagPrefix.block, GTEMaterials.ManaGlass)
                .duration(20)
                .MANAt(48)
                .save();

        MANA_INFUSER_RECIPES.builder("manasteel")
                .inputItems(TagPrefix.ingot, GTMaterials.Steel)
                .outputItems(TagPrefix.ingot, GTEMaterials.Manasteel)
                .duration(20)
                .MANAt(64)
                .save();

        MANA_INFUSER_RECIPES.builder("mana_pearl")
                .inputItems("torchmaster:frozen_pearl")
                .outputItems("botania:mana_pearl")
                .duration(20)
                .MANAt(64)
                .save();

        MANA_INFUSER_RECIPES.builder("mana_diamond")
                .inputItems(TagPrefix.gem, GTMaterials.Diamond)
                .outputItems(TagPrefix.gem, GTEMaterials.ManaDiamond)
                .duration(20)
                .MANAt(64)
                .save();

        MANA_INFUSER_RECIPES.builder("pulsatingalloy")
                .inputItems(GTETagPrefix.SUPERCONDUCTOR_BASE, GTEMaterials.PulsatingAlloy, 2)
                .outputItems(TagPrefix.wireGtSingle, GTEMaterials.PulsatingAlloy, 2)
                .duration(20)
                .MANAt(8)
                .save();

        MANA_INFUSER_RECIPES.builder("conductivealloy")
                .inputItems(GTETagPrefix.SUPERCONDUCTOR_BASE, GTEMaterials.ConductiveAlloy, 2)
                .outputItems(TagPrefix.wireGtSingle, GTEMaterials.ConductiveAlloy, 2)
                .duration(20)
                .MANAt(32)
                .save();

        MANA_INFUSER_RECIPES.builder("energeticalloy")
                .inputItems(GTETagPrefix.SUPERCONDUCTOR_BASE, GTEMaterials.EnergeticAlloy, 2)
                .outputItems(TagPrefix.wireGtSingle, GTEMaterials.EnergeticAlloy, 2)
                .duration(20)
                .MANAt(128)
                .save();

        MANA_INFUSER_RECIPES.builder("vibrantalloy")
                .inputItems(GTETagPrefix.SUPERCONDUCTOR_BASE, GTEMaterials.VibrantAlloy, 2)
                .outputItems(TagPrefix.wireGtSingle, GTEMaterials.VibrantAlloy, 2)
                .duration(20)
                .MANAt(512)
                .save();

        MANA_INFUSER_RECIPES.builder("endsteel")
                .inputItems(GTETagPrefix.SUPERCONDUCTOR_BASE, GTEMaterials.EndSteel, 2)
                .outputItems(TagPrefix.wireGtSingle, GTEMaterials.EndSteel, 2)
                .duration(20)
                .MANAt(2048)
                .save();

        MANA_INFUSER_RECIPES.builder("uranium_rhodium_dinaquadide")
                .inputItems(GTETagPrefix.SUPERCONDUCTOR_BASE, GTMaterials.UraniumRhodiumDinaquadide, 2)
                .outputItems(TagPrefix.wireGtSingle, GTMaterials.UraniumRhodiumDinaquadide, 2)
                .duration(20)
                .MANAt(2048)
                .save();
    }
}
