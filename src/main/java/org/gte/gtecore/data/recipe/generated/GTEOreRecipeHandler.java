package org.gte.gtecore.data.recipe.generated;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.config.GTEConfig;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.OreProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeCategories;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import com.mojang.datafixers.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.HIGH_SIFTER_OUTPUT;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;

public interface GTEOreRecipeHandler {

    private static boolean doesMaterialUseNormalFurnace(Material material) {
        return !material.hasProperty(PropertyKey.BLAST) && !material.hasFlag(MaterialFlags.NO_ORE_SMELTING);
    }

    static void run(Consumer<FinishedRecipe> provider, Material material) {
        OreProperty property = material.getProperty(PropertyKey.ORE);
        if (property == null) {
            return;
        }
        processOre(material, property, provider);
        processRawOre(material, property, provider);
        processCrushedOre(provider, property, material);
        processCrushedPurified(provider, property, material);
        processCrushedCentrifuged(provider, property, material);
        processDirtyDust(provider, property, material);
        processPureDust(provider, property, material);
    }

    private static void processOre(Material material, OreProperty property, Consumer<FinishedRecipe> provider) {
        if (!material.shouldGenerateRecipesFor(ore)) {
            return;
        }
        ItemStack crushedStack = ChemicalHelper.get(crushed, material);
        int oreMultiplier = property.getOreMultiplier();
        int oreTypeMultiplier = GTEConfig.INSTANCE.oreMultiplier;
        long mass = material.getMass();
        int dur = (int) Math.max(8, Math.sqrt(mass) * 2 * oreTypeMultiplier);
        crushedStack.setCount(Math.max(oreTypeMultiplier * oreMultiplier, 1));

        GTERecipeBuilder forge_builder = FORGE_HAMMER_RECIPES.recipeBuilder(material.getName() + "_ore_to_raw_ore")
                .inputItems(TagPrefix.ore.getItemTags(material)[0])
                .duration((dur << 2) / 5)
                .EUt(16);

        ItemStack outputStack = material.hasProperty(PropertyKey.GEM) && !gem.isIgnored(material) ?
                ChemicalHelper.get(gem, material, crushedStack.getCount()) : crushedStack;

        forge_builder.outputItems(outputStack);
        forge_builder.save();

        TagKey<Item> tag = TagPrefix.ore.getItemTags(material)[0];
        Material byproductMaterial = property.getOreByProduct(0, material);
        ItemStack byproductStack = ChemicalHelper.get(gem, byproductMaterial).isEmpty() ?
                ChemicalHelper.get(dust, byproductMaterial) : ChemicalHelper.get(gem, byproductMaterial);

        Material smeltingMaterial = property.getDirectSmeltResult().isNull() ? material : property.getDirectSmeltResult();

        if (!crushedStack.isEmpty()) {
            GTERecipeBuilder builder = CRUSHER_RECIPES
                    .recipeBuilder(GTECore.id(material.getName() + "_ore_to_raw_ore"))
                    .inputItems(tag)
                    .outputItems(crushedStack)
                    .chancedOutput(byproductStack, 1400, 850)
                    .EUt(30)
                    .duration(dur);

            for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                    builder.chancedOutput(ChemicalHelper.getGem(secondaryMaterial), 6700, 800);
                }
            }

            builder.save();

            int crushedAmount = crushedStack.getCount();

            GTERecipeBuilder opBuilder1 = INTEGRATED_ORE_PROCESSOR
                    .recipeBuilder(GTECore.id("processor_1_" + material.getName()))
                    .circuitMeta(1)
                    .inputItems(tag)
                    .outputItems(dust, getOutputMaterial(material), crushedAmount)
                    .chancedOutput(byproductStack, 1400, 850)
                    .chancedOutput(dust, byproductMaterial, property.getByProductMultiplier() * crushedAmount, 1400, 850)
                    .duration((int) (dur + (dur + (mass << 2)) * crushedAmount))
                    .EUt(30);

            for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                    opBuilder1.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                }
            }

            if (byproductMaterial.hasProperty(PropertyKey.DUST)) {
                opBuilder1.chancedOutput(dust, byproductMaterial, crushedAmount, "1/9", 0);
            }
            opBuilder1.save();

            // 2 破碎-洗矿-热离-研磨
            Material byproductMaterial1 = property.getOreByProduct(1, material);
            ItemStack byproductStack2 = ChemicalHelper.get(dust, property.getOreByProduct(2, material), crushedAmount);
            ItemStack crushedCentrifugedStack = ChemicalHelper.get(crushedRefined, material);

            if (!crushedCentrifugedStack.isEmpty()) {
                GTERecipeBuilder opBuilder2 = INTEGRATED_ORE_PROCESSOR
                        .recipeBuilder(GTECore.id("processor_2_" + material.getName()))
                        .circuitMeta(2)
                        .inputItems(tag)
                        .inputFluids(DistilledWater.getFluid(100 * crushedAmount))
                        .outputItems(dust, getOutputMaterial(material), crushedAmount)
                        .chancedOutput(byproductStack, 1400, 850)
                        .chancedOutput(dust, byproductMaterial, crushedAmount, "1/3", 0)
                        .outputItems(dust, Stone, crushedAmount)
                        .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/3", 0)
                        .chancedOutput(byproductStack2, 1400, 850)
                        .duration(dur + (200 + 200 + dur) * crushedAmount)
                        .EUt(30);
                for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                    if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                        opBuilder2.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                    }
                }
                opBuilder2.save();
            }

            // 3 破碎-洗矿-研磨-离心
            ItemStack byproductStack1 = ChemicalHelper.get(dust, byproductMaterial1, crushedAmount);
            GTERecipeBuilder opBuilder3 = INTEGRATED_ORE_PROCESSOR
                    .recipeBuilder(GTECore.id("rocessor_3_" + material.getName()))
                    .circuitMeta(3)
                    .inputItems(tag)
                    .inputFluids(DistilledWater.getFluid(100 * crushedAmount))
                    .outputItems(dust, getOutputMaterial(material), crushedAmount)
                    .chancedOutput(byproductStack, 1400, 850)
                    .chancedOutput(dust, byproductMaterial, crushedAmount, "1/3", 0)
                    .outputItems(dust, Stone, crushedAmount)
                    .chancedOutput(byproductStack1, 1400, 850)
                    .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                    .duration(dur + (200 + dur + 16) * crushedAmount)
                    .EUt(30);
            for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                    opBuilder3.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                }
            }
            opBuilder3.save();

            // 4 破碎-洗矿-筛选-离心
            if (material.hasProperty(PropertyKey.GEM)) {
                ItemStack exquisiteStack = ChemicalHelper.get(gemExquisite, material);
                ItemStack flawlessStack = ChemicalHelper.get(gemFlawless, material);
                ItemStack gemStack = ChemicalHelper.get(gem, material);
                if (material.hasFlag(HIGH_SIFTER_OUTPUT)) {
                    GTERecipeBuilder opBuilder4 = INTEGRATED_ORE_PROCESSOR
                            .recipeBuilder(GTECore.id("processor_4_" + material.getName()))
                            .circuitMeta(4)
                            .inputItems(tag)
                            .inputFluids(DistilledWater.getFluid(100 * crushedAmount))
                            .outputItems(dust, getOutputMaterial(material), crushedAmount)
                            .chancedOutput(byproductStack, 1400, 850)
                            .chancedOutput(dust, byproductMaterial, crushedAmount, "1/3", 0)
                            .outputItems(dust, Stone, crushedAmount)
                            .chancedOutput(exquisiteStack, 500, 150)
                            .chancedOutput(flawlessStack, 1500, 200)
                            .chancedOutput(gemStack, 5000, 1000)
                            .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                            .duration(dur + (200 + 210 + 16) * crushedAmount)
                            .EUt(30);
                    for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                        if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                            opBuilder4.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                        }
                    }
                    opBuilder4.save();
                } else {
                    GTERecipeBuilder opBuilder4 = INTEGRATED_ORE_PROCESSOR
                            .recipeBuilder(GTECore.id("processor_4_" + material.getName()))
                            .circuitMeta(4)
                            .inputItems(tag)
                            .inputFluids(DistilledWater.getFluid(100 * crushedAmount))
                            .outputItems(dust, getOutputMaterial(material), crushedAmount)
                            .chancedOutput(byproductStack, 1400, 850)
                            .chancedOutput(dust, byproductMaterial, crushedAmount, "1/3", 0)
                            .outputItems(dust, Stone, crushedAmount)
                            .chancedOutput(exquisiteStack, 300, 100)
                            .chancedOutput(flawlessStack, 1000, 150)
                            .chancedOutput(gemStack, 3500, 500)
                            .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                            .duration(dur + (200 + 210 + 16) * crushedAmount)
                            .EUt(30);
                    for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                        if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                            opBuilder4.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                        }
                    }
                    opBuilder4.save();
                }
            }

            if (!property.getWashedIn().getFirst().isNull()) {
                Material washingByproduct = property.getOreByProduct(3, material);
                Pair<Material, Integer> washedInTuple = property.getWashedIn();
                // 5 破碎-浸洗-热离-研磨
                if (!crushedCentrifugedStack.isEmpty()) {
                    GTERecipeBuilder opBuilder5 = INTEGRATED_ORE_PROCESSOR
                            .recipeBuilder(GTECore.id("processor_5_" + material.getName()))
                            .circuitMeta(5)
                            .inputItems(tag)
                            .inputFluids(washedInTuple.getFirst().getFluid(washedInTuple.getSecond() * crushedAmount))
                            .outputItems(dust, getOutputMaterial(material), crushedAmount)
                            .chancedOutput(byproductStack, 1400, 850)
                            .chancedOutput(dust, washingByproduct, property.getByProductMultiplier() * crushedAmount, 7000, 580)
                            .chancedOutput(dust, Stone, crushedAmount, 4000, 650)
                            .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/3", 0)
                            .chancedOutput(byproductStack2, 1400, 850)
                            .duration(dur + (200 + 200 + dur) * crushedAmount)
                            .EUt(30);
                    for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                        if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                            opBuilder5.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                        }
                    }
                    opBuilder5.save();
                }

                // 6 破碎-浸洗-研磨-离心
                GTERecipeBuilder opBuilder6 = INTEGRATED_ORE_PROCESSOR
                        .recipeBuilder(GTECore.id("processor_6_" + material.getName()))
                        .circuitMeta(6)
                        .inputItems(tag)
                        .inputFluids(washedInTuple.getFirst().getFluid(washedInTuple.getSecond() * crushedAmount))
                        .outputItems(dust, getOutputMaterial(material), crushedAmount)
                        .chancedOutput(byproductStack, 1400, 850)
                        .chancedOutput(dust, washingByproduct, property.getByProductMultiplier() * crushedAmount, 7000, 580)
                        .chancedOutput(dust, Stone, crushedAmount, 4000, 650)
                        .chancedOutput(byproductStack1, 1400, 850)
                        .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                        .duration(dur + (200 + dur + 16) * crushedAmount)
                        .EUt(30);
                for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                    if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                        opBuilder6.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                    }
                }
                opBuilder6.save();

                // 7 破碎-浸洗-筛选-离心
                if (material.hasProperty(PropertyKey.GEM)) {
                    ItemStack exquisiteStack = ChemicalHelper.get(gemExquisite, material);
                    ItemStack flawlessStack = ChemicalHelper.get(gemFlawless, material);
                    ItemStack gemStack = ChemicalHelper.get(gem, material);
                    if (material.hasFlag(HIGH_SIFTER_OUTPUT)) {
                        GTERecipeBuilder opBuilder7 = INTEGRATED_ORE_PROCESSOR
                                .recipeBuilder(GTECore.id("processor_7_" + material.getName()))
                                .circuitMeta(7)
                                .inputItems(tag)
                                .inputFluids(washedInTuple.getFirst().getFluid(washedInTuple.getSecond() * crushedAmount))
                                .outputItems(dust, getOutputMaterial(material), crushedAmount)
                                .chancedOutput(byproductStack, 1400, 850)
                                .chancedOutput(dust, washingByproduct, property.getByProductMultiplier() * crushedAmount, 7000, 580)
                                .chancedOutput(dust, Stone, crushedAmount, 4000, 650)
                                .chancedOutput(exquisiteStack, 500, 150)
                                .chancedOutput(flawlessStack, 1500, 200)
                                .chancedOutput(gemStack, 5000, 1000)
                                .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                                .duration(dur + (200 + 210 + 16) * crushedAmount)
                                .EUt(30);
                        for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                            if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                                opBuilder7.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                            }
                        }
                        opBuilder7.save();
                    } else {
                        GTERecipeBuilder opBuilder7 = INTEGRATED_ORE_PROCESSOR
                                .recipeBuilder(GTECore.id("processor_7_" + material.getName()))
                                .circuitMeta(7)
                                .inputItems(tag)
                                .inputFluids(washedInTuple.getFirst().getFluid(washedInTuple.getSecond() * crushedAmount))
                                .outputItems(dust, getOutputMaterial(material), crushedAmount)
                                .chancedOutput(byproductStack, 1400, 850)
                                .chancedOutput(dust, washingByproduct, property.getByProductMultiplier() * crushedAmount, 7000, 580)
                                .chancedOutput(dust, Stone, crushedAmount, 4000, 650)
                                .chancedOutput(exquisiteStack, 300, 100)
                                .chancedOutput(flawlessStack, 1000, 150)
                                .chancedOutput(gemStack, 3500, 500)
                                .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                                .duration(dur + (200 + 210 + 16) * crushedAmount)
                                .EUt(30);
                        for (MaterialStack secondaryMaterial : TagPrefix.ore.secondaryMaterials()) {
                            if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                                opBuilder7.chancedOutput(ChemicalHelper.getGem(secondaryMaterial).copyWithCount(crushedAmount), 6700, 800);
                            }
                        }
                        opBuilder7.save();
                    }
                }
            }

            ItemStack ingotStack = material.hasProperty(PropertyKey.INGOT) ? ChemicalHelper.get(ingot, smeltingMaterial) :
                    material.hasProperty(PropertyKey.GEM) ? ChemicalHelper.get(gem, smeltingMaterial) :
                            ChemicalHelper.get(dust, smeltingMaterial);

            ingotStack.setCount(crushedStack.getCount());

            if (!ingotStack.isEmpty() && doesMaterialUseNormalFurnace(smeltingMaterial) && !TagPrefix.ore.isIgnored(material)) {
                float xp = Math.round(((1 + oreTypeMultiplier * 0.5f) * 0.5f - 0.05f) * 10.0f) / 10.0f;
                VanillaRecipeHelper.addSmeltingRecipe(provider, material.getName(), tag, ingotStack, xp);
                VanillaRecipeHelper.addBlastingRecipe(provider, material.getName(), tag, ingotStack, xp);
            }
        }
    }

    private static void processRawOre(Material material, OreProperty property, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(TagPrefix.rawOre, material);
        if (stack.isEmpty()) return;
        int oreTypeMultiplier = GTEConfig.INSTANCE.oreMultiplier;
        long mass = material.getMass();
        int dur = (int) Math.max(6, Math.sqrt(mass) * oreTypeMultiplier * 2 / 3);
        ItemStack crushedStack = ChemicalHelper.get(crushed, material, Math.max(1, property.getOreMultiplier() * oreTypeMultiplier / 2));
        Material smeltingMaterial = property.getDirectSmeltResult().isNull() ? material : property.getDirectSmeltResult();
        ItemStack ingotStack = material.hasProperty(PropertyKey.INGOT) ? ChemicalHelper.get(ingot, smeltingMaterial, property.getOreMultiplier()) :
                material.hasProperty(PropertyKey.GEM) ? ChemicalHelper.get(gem, smeltingMaterial, property.getOreMultiplier()) :
                        ChemicalHelper.get(dust, smeltingMaterial, property.getOreMultiplier());

        if (crushedStack.isEmpty()) return;

        GTERecipeBuilder builder = FORGE_HAMMER_RECIPES.recipeBuilder(TagPrefix.rawOre.name + "_" + material.getName() + "_to_crushed_ore")
                .inputItems(stack)
                .duration((dur << 2) / 5).EUt(16);

        builder.outputItems(material.hasProperty(PropertyKey.GEM) && !gem.isIgnored(material) ? ChemicalHelper.get(gem, material, crushedStack.getCount()) : crushedStack);
        builder.save();

        GTERecipeBuilder builder2 = CRUSHER_RECIPES.recipeBuilder(TagPrefix.rawOre.name + "_" + material.getName() + "_ore_to_crushed_ore")
                .inputItems(stack)
                .outputItems(crushedStack)
                .EUt(30).duration(dur);

        Material byproductMaterial = property.getOreByProduct(0, material);
        ItemStack byproductStack = ChemicalHelper.get(gem, byproductMaterial);
        if (byproductStack.isEmpty()) byproductStack = ChemicalHelper.get(dust, byproductMaterial);
        builder2.chancedOutput(byproductStack, 1000, 300);

        for (MaterialStack secondaryMaterial : ore.secondaryMaterials()) {
            if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                ItemStack dustStack = ChemicalHelper.getGem(secondaryMaterial);
                builder2.chancedOutput(dustStack, 500, 100);
                break;
            }
        }
        builder2.save();

        int crushedAmount = crushedStack.getCount();

        // 1 破碎-研磨-离心
        GTERecipeBuilder opBuilder1 = INTEGRATED_ORE_PROCESSOR.recipeBuilder(GTECore.id("raw_processor_1_" + material.getName()))
                .circuitMeta(1)
                .inputItems(stack)
                .outputItems(dust, getOutputMaterial(material), crushedAmount)
                .chancedOutput(byproductStack, 1000, 300)
                .duration((int) (dur + (dur + (mass << 2)) * crushedAmount))
                .EUt(30);

        if (byproductMaterial.hasProperty(PropertyKey.DUST)) {
            opBuilder1.chancedOutput(dust, byproductMaterial, crushedAmount, "1/9", 0);
        }
        opBuilder1.save();

        // 2 破碎-洗矿-热离-研磨
        Material byproductMaterial1 = property.getOreByProduct(1, material);
        ItemStack byproductStack2 = ChemicalHelper.get(dust, property.getOreByProduct(2, material), crushedAmount);
        ItemStack crushedCentrifugedStack = ChemicalHelper.get(crushedRefined, material);
        if (!crushedCentrifugedStack.isEmpty()) {
            GTERecipeBuilder opBuilder2 = INTEGRATED_ORE_PROCESSOR.recipeBuilder(GTECore.id("raw_processor_2_" + material.getName()))
                    .circuitMeta(2)
                    .inputItems(stack)
                    .inputFluids(DistilledWater.getFluid(100 * crushedAmount))
                    .outputItems(dust, getOutputMaterial(material), crushedAmount)
                    .chancedOutput(byproductStack, 1000, 300)
                    .chancedOutput(dust, byproductMaterial, crushedAmount, "1/3", 0)
                    .outputItems(dust, Stone, crushedAmount)
                    .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/3", 0)
                    .chancedOutput(byproductStack2, 1400, 850)
                    .duration(dur + (200 + 200 + dur) * crushedAmount)
                    .EUt(30);
            opBuilder2.save();
        }

        // 3 破碎-洗矿-研磨-离心
        ItemStack byproductStack1 = ChemicalHelper.get(dust, byproductMaterial1, crushedAmount);
        GTERecipeBuilder opBuilder3 = INTEGRATED_ORE_PROCESSOR.recipeBuilder(GTECore.id("raw_processor_3_" + material.getName()))
                .circuitMeta(3)
                .inputItems(stack)
                .inputFluids(DistilledWater.getFluid(100 * crushedAmount))
                .outputItems(dust, getOutputMaterial(material), crushedAmount)
                .chancedOutput(byproductStack, 1000, 300)
                .chancedOutput(dust, byproductMaterial, crushedAmount, "1/3", 0)
                .outputItems(dust, Stone, crushedAmount)
                .chancedOutput(byproductStack1, 1400, 850)
                .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                .duration(dur + (200 + dur + 16) * crushedAmount)
                .EUt(30);

        for (MaterialStack secondaryMaterial : ore.secondaryMaterials()) {
            if (secondaryMaterial.material().hasProperty(PropertyKey.DUST)) {
                ItemStack dustStack = ChemicalHelper.getGem(secondaryMaterial);
                opBuilder3.chancedOutput(dustStack, 500, 100);
                break;
            }
        }
        opBuilder3.save();

        // 4 破碎-洗矿-筛选-离心
        if (material.hasProperty(PropertyKey.GEM)) {
            ItemStack exquisiteStack = ChemicalHelper.get(gemExquisite, material);
            ItemStack flawlessStack = ChemicalHelper.get(gemFlawless, material);
            ItemStack gemStack = ChemicalHelper.get(gem, material);
            GTERecipeBuilder opBuilder4 = INTEGRATED_ORE_PROCESSOR.recipeBuilder(GTECore.id("raw_processor_4_" + material.getName()))
                    .circuitMeta(4)
                    .inputItems(stack)
                    .inputFluids(DistilledWater.getFluid(100 * crushedAmount))
                    .outputItems(dust, getOutputMaterial(material), crushedAmount)
                    .chancedOutput(byproductStack, 1000, 300)
                    .chancedOutput(dust, byproductMaterial, crushedAmount, "1/3", 0)
                    .outputItems(dust, Stone, crushedAmount)
                    .chancedOutput(exquisiteStack, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 500 : 300, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 150 : 100)
                    .chancedOutput(flawlessStack, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 1500 : 1000, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 200 : 150)
                    .chancedOutput(gemStack, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 5000 : 3500, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 1000 : 500)
                    .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                    .duration(dur + (200 + 210 + 16) * crushedAmount)
                    .EUt(30);
            opBuilder4.save();
        }

        if (!property.getWashedIn().getFirst().isNull()) {
            Material washingByproduct = property.getOreByProduct(3, material);
            Pair<Material, Integer> washedInTuple = property.getWashedIn();

            // 5 破碎-浸洗-热离-研磨
            if (!crushedCentrifugedStack.isEmpty()) {
                GTERecipeBuilder opBuilder5 = INTEGRATED_ORE_PROCESSOR.recipeBuilder(GTECore.id("raw_processor_5_" + material.getName()))
                        .circuitMeta(5)
                        .inputItems(stack)
                        .inputFluids(washedInTuple.getFirst().getFluid(washedInTuple.getSecond() * crushedAmount))
                        .outputItems(dust, getOutputMaterial(material), crushedAmount)
                        .chancedOutput(byproductStack, 1000, 300)
                        .chancedOutput(dust, washingByproduct, property.getByProductMultiplier() * crushedAmount, 7000, 580)
                        .chancedOutput(dust, Stone, crushedAmount, 4000, 650)
                        .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/3", 0)
                        .chancedOutput(byproductStack2, 1400, 850)
                        .duration(dur + (200 + 200 + dur) * crushedAmount)
                        .EUt(30);
                opBuilder5.save();
            }

            // 6 破碎-浸洗-研磨-离心
            GTERecipeBuilder opBuilder6 = INTEGRATED_ORE_PROCESSOR.recipeBuilder(GTECore.id("raw_processor_6_" + material.getName()))
                    .circuitMeta(6)
                    .inputItems(stack)
                    .inputFluids(washedInTuple.getFirst().getFluid(washedInTuple.getSecond() * crushedAmount))
                    .outputItems(dust, getOutputMaterial(material), crushedAmount)
                    .chancedOutput(byproductStack, 1000, 300)
                    .chancedOutput(dust, washingByproduct, property.getByProductMultiplier() * crushedAmount, 7000, 580)
                    .chancedOutput(dust, Stone, crushedAmount, 4000, 650)
                    .chancedOutput(byproductStack1, 1400, 850)
                    .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                    .duration(dur + (200 + dur + 16) * crushedAmount)
                    .EUt(30);
            opBuilder6.save();

            // 7 破碎-浸洗-筛选-离心
            if (material.hasProperty(PropertyKey.GEM)) {
                ItemStack exquisiteStack = ChemicalHelper.get(gemExquisite, material);
                ItemStack flawlessStack = ChemicalHelper.get(gemFlawless, material);
                ItemStack gemStack = ChemicalHelper.get(gem, material);
                GTERecipeBuilder opBuilder7 = INTEGRATED_ORE_PROCESSOR.recipeBuilder(GTECore.id("raw_processor_7_" + material.getName()))
                        .circuitMeta(7)
                        .inputItems(stack)
                        .inputFluids(washedInTuple.getFirst().getFluid(washedInTuple.getSecond() * crushedAmount))
                        .outputItems(dust, getOutputMaterial(material), crushedAmount)
                        .chancedOutput(byproductStack, 1000, 300)
                        .chancedOutput(dust, washingByproduct, property.getByProductMultiplier() * crushedAmount, 7000, 580)
                        .chancedOutput(dust, Stone, crushedAmount, 4000, 650)
                        .chancedOutput(exquisiteStack, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 500 : 300, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 150 : 100)
                        .chancedOutput(flawlessStack, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 1500 : 1000, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 200 : 150)
                        .chancedOutput(gemStack, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 5000 : 3500, material.hasFlag(HIGH_SIFTER_OUTPUT) ? 1000 : 500)
                        .chancedOutput(dust, byproductMaterial1, crushedAmount, "1/9", 0)
                        .duration(dur + (200 + 210 + 16) * crushedAmount)
                        .EUt(30);
                opBuilder7.save();
            }
        }

        if (!ingotStack.isEmpty() && doesMaterialUseNormalFurnace(smeltingMaterial) && !TagPrefix.rawOre.isIgnored(material)) {
            float xp = Math.round(((1 + property.getOreMultiplier() * 0.33f) / 3) * 10.0f) / 10.0f;
            VanillaRecipeHelper.addSmeltingRecipe(provider, TagPrefix.rawOre.name + "_" + material.getName(), stack, ingotStack, xp);
            VanillaRecipeHelper.addBlastingRecipe(provider, TagPrefix.rawOre.name + "_" + material.getName(), Ingredient.of(stack), ingotStack, xp);
        }

        COMPRESSOR_RECIPES.recipeBuilder(material.getName() + "to_ore_block")
                .inputItems(stack.copyWithCount(9))
                .outputItems(rawOreBlock, material)
                .duration(300).EUt(2).save();

        FORGE_HAMMER_RECIPES.recipeBuilder(material.getName() + "to_raw_ore")
                .inputItems(rawOreBlock, material)
                .outputItems(stack.copyWithCount(9))
                .duration(300).EUt(2).save();
    }

    private static void processCrushedOre(@NotNull Consumer<FinishedRecipe> provider, @NotNull OreProperty property,
                                          @NotNull Material material) {
        ItemStack stack = ChemicalHelper.get(crushed, material);
        if (stack.isEmpty()) return;
        ItemStack impureDustStack = ChemicalHelper.get(dustImpure, material);
        Material byproductMaterial = property.getOreByProduct(0, material);

        FORGE_HAMMER_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_impure_dust")
                .inputItems(stack)
                .outputItems(impureDustStack)
                .duration(10).EUt(16)
                .category(GTRecipeCategories.ORE_FORGING)
                .save();

        MACERATOR_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_impure_dust")
                .inputItems(stack)
                .outputItems(impureDustStack)
                .duration(400).EUt(2)
                .chancedOutput(dust, byproductMaterial, property.getByProductMultiplier(), 1400,
                        850)
                .category(GTRecipeCategories.ORE_CRUSHING)
                .save();

        ItemStack crushedPurifiedOre = GTUtil.copyFirst(
                ChemicalHelper.get(crushedPurified, material),
                ChemicalHelper.get(dust, getOutputMaterial(material)));
        ItemStack crushedCentrifugedOre = GTUtil.copyFirst(
                ChemicalHelper.get(crushedRefined, material),
                ChemicalHelper.get(dust, getOutputMaterial(material)));

        ORE_WASHER_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_purified_ore_fast")
                .inputItems(stack)
                .circuitMeta(2)
                .inputFluids(Water.getFluid(100))
                .outputItems(crushedPurifiedOre)
                .duration(8).EUt(4).save();

        ORE_WASHER_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_purified_ore")
                .inputItems(stack)
                .inputFluids(Water.getFluid(1000))
                .circuitMeta(1)
                .outputItems(crushedPurifiedOre)
                .chancedOutput(TagPrefix.dust, byproductMaterial, "1/3", 0)
                .outputItems(TagPrefix.dust, GTMaterials.Stone)
                .save();

        ORE_WASHER_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_purified_ore_distilled")
                .inputItems(stack)
                .inputFluids(DistilledWater.getFluid(100))
                .outputItems(crushedPurifiedOre)
                .chancedOutput(TagPrefix.dust, byproductMaterial, "1/3", 0)
                .outputItems(TagPrefix.dust, GTMaterials.Stone)
                .duration(200)
                .save();

        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_refined_ore")
                .inputItems(stack)
                .outputItems(crushedCentrifugedOre)
                .chancedOutput(TagPrefix.dust, property.getOreByProduct(1, material), property.getByProductMultiplier(),
                        "1/3", 0)
                .outputItems(TagPrefix.dust, GTMaterials.Stone)
                .save();

        if (!property.getWashedIn().getFirst().isNull()) {
            Material washingByproduct = property.getOreByProduct(3, material);
            Pair<Material, Integer> washedInTuple = property.getWashedIn();
            CHEMICAL_BATH_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_purified_ore")
                    .inputItems(stack)
                    .inputFluids(washedInTuple.getFirst().getFluid(washedInTuple.getSecond()))
                    .outputItems(crushedPurifiedOre)
                    .chancedOutput(dust, washingByproduct, property.getByProductMultiplier(), 7000, 580)
                    .chancedOutput(dust, Stone, 4000, 650)
                    .duration(200).EUt(VA[LV])
                    .category(GTRecipeCategories.ORE_BATHING)
                    .save();
        }

        processMetalSmelting(provider, property, crushed, material);
    }

    private static void processCrushedCentrifuged(@NotNull Consumer<FinishedRecipe> provider,
                                                  @NotNull OreProperty property, @NotNull Material material) {
        ItemStack stack = ChemicalHelper.get(crushedRefined, material);
        if (stack.isEmpty()) return;

        ItemStack dustStack = ChemicalHelper.get(dust, getOutputMaterial(material));
        ItemStack byproductStack = ChemicalHelper.get(dust, property.getOreByProduct(2, material), 1);

        FORGE_HAMMER_RECIPES.recipeBuilder(material.getName() + "_refined_ore_to_dust")
                .inputItems(stack)
                .outputItems(dustStack)
                .duration(10).EUt(16)
                .category(GTRecipeCategories.ORE_FORGING)
                .save();

        MACERATOR_RECIPES.recipeBuilder(material.getName() + "_refined_ore_to_dust")
                .inputItems(stack)
                .outputItems(dustStack)
                .chancedOutput(byproductStack, 1400, 850)
                .duration(400).EUt(2)
                .category(GTRecipeCategories.ORE_CRUSHING)
                .save();

        processMetalSmelting(provider, property, crushedRefined, material);
    }

    private static void processCrushedPurified(@NotNull Consumer<FinishedRecipe> provider,
                                               @NotNull OreProperty property,
                                               @NotNull Material material) {
        ItemStack stack = ChemicalHelper.get(crushedPurified, material);
        if (stack.isEmpty()) return;

        ItemStack crushedCentrifugedStack = ChemicalHelper.get(crushedRefined, material);
        ItemStack dustStack = ChemicalHelper.get(dustPure, material);
        Material byproductMaterial = property.getOreByProduct(1, material);
        ItemStack byproductStack = ChemicalHelper.get(dust, byproductMaterial);

        FORGE_HAMMER_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_dust")
                .inputItems(stack)
                .outputItems(dustStack)
                .duration(10)
                .EUt(16)
                .category(GTRecipeCategories.ORE_FORGING)
                .save();

        MACERATOR_RECIPES.recipeBuilder(material.getName() + "_crushed_ore_to_dust")
                .inputItems(stack)
                .outputItems(dustStack)
                .chancedOutput(byproductStack, 1400, 850)
                .duration(400).EUt(2)
                .category(GTRecipeCategories.ORE_CRUSHING)
                .save();

        if (!crushedCentrifugedStack.isEmpty()) {
            THERMAL_CENTRIFUGE_RECIPES
                    .recipeBuilder(material.getName() + "_purified_ore_to_refined_ore")
                    .inputItems(stack)
                    .outputItems(crushedCentrifugedStack)
                    .chancedOutput(TagPrefix.dust, byproductMaterial, "1/3", 0)
                    .save();
        }

        if (material.hasProperty(PropertyKey.GEM)) {
            ItemStack exquisiteStack = ChemicalHelper.get(gemExquisite, material);
            ItemStack flawlessStack = ChemicalHelper.get(gemFlawless, material);
            ItemStack gemStack = ChemicalHelper.get(gem, material);
            ItemStack flawedStack = ChemicalHelper.get(gemFlawed, material);
            ItemStack chippedStack = ChemicalHelper.get(gemChipped, material);

            if (material.hasFlag(HIGH_SIFTER_OUTPUT)) {
                GTERecipeBuilder builder = SIFTER_RECIPES
                        .recipeBuilder(material.getName() + "_purified_ore_to_gems")
                        .inputItems(stack)
                        .chancedOutput(exquisiteStack, 500, 150)
                        .chancedOutput(flawlessStack, 1500, 200)
                        .chancedOutput(gemStack, 5000, 1000)
                        .chancedOutput(dustStack, 2500, 500)
                        .duration(400).EUt(16);

                if (!flawedStack.isEmpty())
                    builder.chancedOutput(flawedStack, 2000, 500);
                if (!chippedStack.isEmpty())
                    builder.chancedOutput(chippedStack, 3000, 350);

                builder.save();
            } else {
                GTERecipeBuilder builder = SIFTER_RECIPES
                        .recipeBuilder(material.getName() + "_purified_ore_to_gems")
                        .inputItems(stack)
                        .chancedOutput(exquisiteStack, 300, 100)
                        .chancedOutput(flawlessStack, 1000, 150)
                        .chancedOutput(gemStack, 3500, 500)
                        .chancedOutput(dustStack, 5000, 750)
                        .duration(400).EUt(16);

                if (!flawedStack.isEmpty())
                    builder.chancedOutput(flawedStack, 2500, 300);
                if (!chippedStack.isEmpty())
                    builder.chancedOutput(chippedStack, 3500, 400);

                builder.save();
            }
        }
        processMetalSmelting(provider, property, crushedPurified, material);
    }

    private static void processDirtyDust(@NotNull Consumer<FinishedRecipe> provider, @NotNull OreProperty property,
                                         @NotNull Material material) {
        ItemStack stack = ChemicalHelper.get(dustImpure, material);
        if (stack.isEmpty()) return;

        ItemStack dustStack = ChemicalHelper.get(dust, getOutputMaterial(material));
        Material byproduct = property.getOreByProduct(0, material);

        GTERecipeBuilder builder = CENTRIFUGE_RECIPES
                .recipeBuilder(material.getName() + "_dirty_dust_to_dust")
                .inputItems(stack)
                .outputItems(dustStack)
                .duration((int) (material.getMass() << 2)).EUt(24);

        if (byproduct.hasProperty(PropertyKey.DUST)) {
            builder.chancedOutput(TagPrefix.dust, byproduct, "1/9", 0);
        } else {
            builder.outputFluids(byproduct.getFluid(L / 9));
        }

        builder.save();

        ORE_WASHER_RECIPES.recipeBuilder(material.getName() + "_dirty_dust_to_dust")
                .inputItems(stack)
                .circuitMeta(2)
                .inputFluids(Water.getFluid(100))
                .outputItems(dustStack)
                .duration(8).EUt(4).save();

        // dust gains same amount of material as normal dust
        processMetalSmelting(provider, property, dustImpure, material);
    }

    private static void processPureDust(@NotNull Consumer<FinishedRecipe> provider, @NotNull OreProperty property,
                                        @NotNull Material material) {
        ItemStack stack = ChemicalHelper.get(dustPure, material);
        if (stack.isEmpty()) return;

        Material byproductMaterial = property.getOreByProduct(1, material);
        ItemStack dustStack = ChemicalHelper.get(dust, getOutputMaterial(material));

        if (property.getSeparatedInto() != null && !property.getSeparatedInto().isEmpty()) {
            List<Material> separatedMaterial = property.getSeparatedInto();
            TagPrefix prefix = (separatedMaterial.get(separatedMaterial.size() - 1).getBlastTemperature() == 0 &&
                    separatedMaterial.get(separatedMaterial.size() - 1).hasProperty(PropertyKey.INGOT)) ? nugget : dust;

            ItemStack separatedStack2 = ChemicalHelper.get(prefix, separatedMaterial.get(separatedMaterial.size() - 1),
                    prefix == nugget ? 2 : 1);

            ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder(material.getName() + "_pure_dust_to_dust")
                    .inputItems(stack)
                    .outputItems(dustStack)
                    .chancedOutput(TagPrefix.dust, separatedMaterial.get(0), 1000, 250)
                    .chancedOutput(separatedStack2, prefix == TagPrefix.dust ? 500 : 2000,
                            prefix == TagPrefix.dust ? 150 : 600)
                    .duration(200).EUt(24)
                    .save();
        }

        CENTRIFUGE_RECIPES.recipeBuilder(material.getName() + "_pure_dust_to_dust")
                .inputItems(stack)
                .outputItems(dustStack)
                .chancedOutput(TagPrefix.dust, byproductMaterial, "1/9", 0)
                .duration(100)
                .EUt(5)
                .save();

        ORE_WASHER_RECIPES.recipeBuilder(material.getName() + "_pure_dust_to_dust")
                .inputItems(stack)
                .circuitMeta(2)
                .inputFluids(Water.getFluid(100))
                .outputItems(dustStack)
                .duration(8).EUt(4).save();

        processMetalSmelting(provider, property, dustPure, material);
    }

    private static void processMetalSmelting(@NotNull Consumer<FinishedRecipe> provider, @NotNull OreProperty property,
                                             @NotNull TagPrefix prefix, @NotNull Material material) {
        Material smeltingResult = property.getDirectSmeltResult().isNull() ? material : property.getDirectSmeltResult();
        if (smeltingResult.hasProperty(PropertyKey.INGOT)) {
            ItemStack ingotStack = ChemicalHelper.get(ingot, smeltingResult);
            if (!ingotStack.isEmpty() && doesMaterialUseNormalFurnace(smeltingResult) && !prefix.isIgnored(material)) {
                VanillaRecipeHelper.addSmeltingRecipe(provider, prefix.name + "_" + material.getName(), ChemicalHelper.getTag(prefix, material), ingotStack, 0.5f);
            }
        }
    }

    static Material getOutputMaterial(Material material) {
        if (material == Naquadah) {
            return GTEMaterials.NaquadahOxideMixture;
        } else if (material == Platinum) {
            return GTEMaterials.PlatinumMetal;
        } else if (material == Palladium) {
            return GTEMaterials.PalladiumMetal;
        }
        return material;
    }
}
