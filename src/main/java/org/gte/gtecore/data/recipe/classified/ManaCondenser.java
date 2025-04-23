package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.Items;

import static org.gte.gtecore.common.data.GTERecipeTypes.MANA_CONDENSER_RECIPES;

interface ManaCondenser {

    static void init() {
        MANA_CONDENSER_RECIPES.builder("terrasteel")
                .inputItems(TagPrefix.ingot, GTEMaterials.Manasteel)
                .inputItems("botania:mana_pearl")
                .inputItems(TagPrefix.gem, GTEMaterials.ManaDiamond)
                .outputItems(TagPrefix.ingot, GTEMaterials.Terrasteel, 3)
                .inputFluids(GTEMaterials.Terrasteel, 144)
                .MANAt(512)
                .duration(200)
                .save();

        MANA_CONDENSER_RECIPES.builder("gaiasteel")
                .inputItems(TagPrefix.dust, GTEMaterials.Gaia)
                .inputItems(TagPrefix.dust, GTEMaterials.OriginalBronze)
                .outputItems(TagPrefix.dust, GTEMaterials.Gaiasteel, 2)
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(2048)
                .save();

        MANA_CONDENSER_RECIPES.builder("enriched_naquadah_trinium_europium_duranide")
                .inputItems(GTETagPrefix.SUPERCONDUCTOR_BASE, GTMaterials.EnrichedNaquadahTriniumEuropiumDuranide, 4)
                .outputItems(TagPrefix.wireGtSingle, GTMaterials.EnrichedNaquadahTriniumEuropiumDuranide, 4)
                .inputFluids(GTEMaterials.Aether.getFluid(1000))
                .duration(80)
                .MANAt(2048)
                .save();

        MANA_CONDENSER_RECIPES.builder("ruthenium_trinium_americium_neutronate")
                .inputItems(GTETagPrefix.SUPERCONDUCTOR_BASE, GTMaterials.RutheniumTriniumAmericiumNeutronate, 4)
                .outputItems(TagPrefix.wireGtSingle, GTMaterials.RutheniumTriniumAmericiumNeutronate, 4)
                .inputFluids(GTEMaterials.Aether.getFluid(1000))
                .duration(80)
                .MANAt(8192)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_water")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:blue_petal")
                .inputItems(TagPrefix.dust, GTMaterials.Lapis)
                .outputItems("botania:rune_water")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_fire")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:orange_petal")
                .inputItems(TagPrefix.dust, GTMaterials.Copper)
                .outputItems("botania:rune_fire")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_air")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:light_blue_petal")
                .inputItems(TagPrefix.dust, GTMaterials.Diamond)
                .outputItems("botania:rune_air")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_earth")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:green_petal")
                .inputItems(TagPrefix.dust, GTMaterials.Emerald)
                .outputItems("botania:rune_earth")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_spring")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_water")
                .inputItems("botania:rune_fire")
                .outputItems("botania:rune_spring")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_summer")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_air")
                .inputItems("botania:rune_earth")
                .outputItems("botania:rune_summer")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_autumn")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_air")
                .inputItems("botania:rune_fire")
                .outputItems("botania:rune_autumn")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_winter")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_earth")
                .inputItems("botania:rune_water")
                .outputItems("botania:rune_winter")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_mana")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems(TagPrefix.gem, GTEMaterials.ManaDiamond, 2)
                .inputItems(TagPrefix.dust, GTEMaterials.Mana, 2)
                .outputItems("botania:rune_mana")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_lust")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_air")
                .inputItems("botania:rune_summer")
                .outputItems("botania:rune_lust")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_gluttony")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_winter")
                .inputItems("botania:rune_fire")
                .outputItems("botania:rune_gluttony")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_greed")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_water")
                .inputItems("botania:rune_spring")
                .outputItems("botania:rune_greed")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_sloth")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_air")
                .inputItems("botania:rune_autumn")
                .outputItems("botania:rune_sloth")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_wrath")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_earth")
                .inputItems("botania:rune_winter")
                .outputItems("botania:rune_wrath")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_envy")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_water")
                .inputItems("botania:rune_winter")
                .outputItems("botania:rune_envy")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("rune_pride")
                .inputItems(TagPrefix.block, GTEMaterials.Livingrock, 16)
                .inputItems("botania:rune_fire")
                .inputItems("botania:rune_summer")
                .outputItems("botania:rune_pride")
                .inputFluids(GTEMaterials.Elementium, 288)
                .duration(200)
                .MANAt(256)
                .save();

        MANA_CONDENSER_RECIPES.builder("black_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems(Items.SCULK_CATALYST.asItem())
                .outputItems("endrem:black_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("cold_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("ad_astra:ice_shard")
                .outputItems("endrem:cold_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("corrupted_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("enderio:plant_matter_brown")
                .outputItems("endrem:corrupted_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("lost_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("enderio:redstone_alloy_grinding_ball")
                .outputItems("endrem:lost_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("nether_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("botania:quartz_blaze")
                .outputItems("endrem:nether_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("old_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("botania:forest_eye")
                .outputItems("endrem:old_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("rogue_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("botania:redstone_root")
                .outputItems("endrem:rogue_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("cursed_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("botania:life_essence")
                .outputItems("endrem:cursed_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("guardian_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems(Items.PRISMARINE_CRYSTALS.asItem())
                .outputItems("endrem:guardian_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("magical_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("botania:mana_bottle")
                .outputItems("endrem:magical_eye")
                .duration(200)
                .MANAt(128)
                .save();

        MANA_CONDENSER_RECIPES.builder("wither_eye")
                .inputItems(GTItems.QUANTUM_EYE.asStack())
                .inputItems("enderio:withering_powder")
                .outputItems("endrem:wither_eye")
                .duration(200)
                .MANAt(128)
                .save();
    }
}
