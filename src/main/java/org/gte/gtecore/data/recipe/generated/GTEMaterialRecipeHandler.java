package org.gte.gtecore.data.recipe.generated;

import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.utils.GTEUtils;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeCategories;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;

public interface GTEMaterialRecipeHandler {

    List<TagPrefix> GEM_ORDER = Arrays.asList(gem, gemFlawless, gemExquisite);

    static void run(Consumer<FinishedRecipe> provider, Material material) {
        if (GTEUtils.isGeneration(ingot, material)) {
            processIngot(material, provider);
            processNugget(material, provider);
        }

        if (GTEUtils.isGeneration(block, material)) {
            processBlock(material, provider);
        }
        if (GTEUtils.isGeneration(frameGt, material)) {
            processFrame(material, provider);
        }

        processDust(material, provider);
        if (GTEUtils.isGeneration(dustSmall, material)) {
            processSmallDust(material, provider);
        }
        if (GTEUtils.isGeneration(dustTiny, material)) {
            processTinyDust(material, provider);
        }

        if (material.shouldGenerateRecipesFor(gemExquisite)) {
            for (TagPrefix orePrefix : Arrays.asList(gem, gemFlawless, gemExquisite)) {
                processGemConversion(orePrefix, material, provider);
            }
        }
    }

    private static void processIngot(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(ingot, material);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        if (material.hasFlag(MORTAR_GRINDABLE)) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("mortar_grind_%s", material.getName()),
                    ChemicalHelper.get(dust, material), "X", "m", 'X', stack);
        }

        if (material.hasFlag(GENERATE_ROD)) {
            if (mass < 240 && material.getBlastTemperature() < 3600)
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("stick_%s", material.getName()),
                        ChemicalHelper.get(rod, material),
                        "f ", " X",
                        'X', stack);

            if (!material.hasFlag(NO_WORKING)) {
                EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_to_rod")
                        .inputItems(stack)
                        .notConsumable(GTItems.SHAPE_EXTRUDER_ROD)
                        .outputItems(rod, material, 2)
                        .duration(mass << 1)
                        .EUt(6L * GTEUtils.getVoltageMultiplier(material))
                        .save();
            }
        }

        if (material.hasFluid()) {
            FLUID_SOLIDFICATION_RECIPES.recipeBuilder("solidify_" + material.getName() + "_to_ingot")
                    .notConsumable(GTItems.SHAPE_MOLD_INGOT)
                    .inputFluids(material.getFluid(L))
                    .outputItems(stack)
                    .duration(mass).EUt(VA[ULV])
                    .save();
        }

        if (material.hasFlag(NO_SMASHING)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_to_ingot")
                    .inputItems(dust, material)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_INGOT)
                    .outputItems(stack)
                    .duration(mass)
                    .EUt(4L * GTEUtils.getVoltageMultiplier(material))
                    .save();
        }

        ALLOY_SMELTER_RECIPES.recipeBuilder("alloy_smelt_" + material.getName() + "_to_nugget")
                .EUt(VA[ULV]).duration(mass)
                .inputItems(stack)
                .notConsumable(GTItems.SHAPE_MOLD_NUGGET)
                .outputItems(nugget, material, 9)
                .category(GTRecipeCategories.INGOT_MOLDING)
                .save();

        if (!ChemicalHelper.get(block, material).isEmpty()) {
            int amount = (int) (block.getMaterialAmount(material) / M);
            ALLOY_SMELTER_RECIPES.recipeBuilder("alloy_smelt_" + material.getName() + "_to_ingot")
                    .EUt(16).duration(Math.max(1, mass * amount / 4))
                    .inputItems(block, material)
                    .notConsumable(GTItems.SHAPE_MOLD_INGOT)
                    .outputItems(stack.copyWithCount(amount))
                    .category(GTRecipeCategories.INGOT_MOLDING)
                    .save();

            COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_to_block")
                    .EUt(VA[ULV]).duration(Math.max(1, mass * amount / 2))
                    .inputItems(stack.copyWithCount(amount))
                    .outputItems(block, material)
                    .save();
        }

        if (material.hasFlag(GENERATE_PLATE) && !material.hasFlag(NO_WORKING)) {

            if (!material.hasFlag(NO_SMASHING)) {
                ItemStack plateStack = ChemicalHelper.get(plate, material);
                if (!plateStack.isEmpty()) {
                    ROLLING_RECIPES.recipeBuilder("rolling_" + material.getName() + "_to_plate")
                            .inputItems(stack)
                            .outputItems(plateStack)
                            .EUt(24).duration(mass)
                            .circuitMeta(1)
                            .save();

                    FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + material.getName() + "_to_plate")
                            .inputItems(stack.copyWithCount(3))
                            .outputItems(plateStack.copyWithCount(2))
                            .EUt(16).duration(Math.max(1, mass / 2))
                            .save();
                    if (mass < 240 && material.getBlastTemperature() < 3600)
                        VanillaRecipeHelper.addShapedRecipe(provider, String.format("plate_%s", material.getName()),
                                plateStack, "h", "I", "I", 'I', stack);
                }
            }

            int voltageMultiplier = GTEUtils.getVoltageMultiplier(material) << 3;
            if (!ChemicalHelper.get(plate, material).isEmpty()) {
                EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_to_plate")
                        .inputItems(stack)
                        .notConsumable(GTItems.SHAPE_EXTRUDER_PLATE)
                        .outputItems(plate, material)
                        .duration(mass << 1)
                        .EUt(voltageMultiplier)
                        .save();

                if (material.hasFlag(NO_SMASHING)) {
                    EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_dust_to_plate")
                            .inputItems(dust, material)
                            .notConsumable(GTItems.SHAPE_EXTRUDER_PLATE)
                            .outputItems(plate, material)
                            .duration(mass)
                            .EUt(voltageMultiplier)
                            .save();
                }
            }
        }
    }

    private static void processNugget(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack nuggetStack = ChemicalHelper.get(nugget, material, 9);
        if (nuggetStack.isEmpty()) return;
        if (material.hasProperty(PropertyKey.INGOT)) {
            ItemStack ingotStack = ChemicalHelper.get(ingot, material.hasFlag(IS_MAGNETIC) ? material.getProperty(PropertyKey.INGOT).getMacerateInto() : material);

            COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_nugget_to_ingot")
                    .inputItems(nuggetStack)
                    .outputItems(ingotStack)
                    .EUt(VA[ULV]).duration((int) material.getMass()).save();

            ALLOY_SMELTER_RECIPES.recipeBuilder("alloy_smelt_" + material.getName() + "_nugget_to_ingot")
                    .EUt(VA[ULV]).duration((int) material.getMass())
                    .inputItems(nuggetStack)
                    .notConsumable(GTItems.SHAPE_MOLD_INGOT)
                    .outputItems(ingotStack)
                    .category(GTRecipeCategories.INGOT_MOLDING)
                    .save();

            if (material.hasFluid()) {
                FLUID_SOLIDFICATION_RECIPES.recipeBuilder("solidify_" + material.getName() + "_to_nugget")
                        .notConsumable(GTItems.SHAPE_MOLD_NUGGET)
                        .inputFluids(material.getFluid(L))
                        .outputItems(nuggetStack)
                        .duration((int) material.getMass())
                        .EUt(VA[ULV])
                        .save();
            }
        }
    }

    private static void processBlock(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack blockStack = ChemicalHelper.get(TagPrefix.block, material);
        if (blockStack.isEmpty()) return;
        int mass = (int) material.getMass();
        int amount = (int) (block.getMaterialAmount(material) / M);
        if (material.hasFluid()) {
            FLUID_SOLIDFICATION_RECIPES.recipeBuilder("solidify_" + material.getName() + "_block")
                    .notConsumable(GTItems.SHAPE_MOLD_BLOCK)
                    .inputFluids(material.getFluid(amount * L))
                    .outputItems(blockStack)
                    .duration(mass * amount).EUt(VA[ULV])
                    .save();
        }

        if (material.hasFlag(NO_SMASHING) && material.hasFlag(GENERATE_PLATE)) {
            ItemStack plateStack = ChemicalHelper.get(plate, material);
            if (!plateStack.isEmpty()) {
                CUTTER_RECIPES.recipeBuilder("cut_" + material.getName() + "_block_to_plate")
                        .inputItems(blockStack)
                        .outputItems(plateStack.copyWithCount(amount))
                        .duration(mass << 3).EUt(VA[LV])
                        .save();
            }
        }

        if (!material.hasFlag(EXCLUDE_BLOCK_CRAFTING_RECIPES)) {
            if (material.hasProperty(PropertyKey.INGOT)) {
                EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_block")
                        .inputItems(ingot, material, amount)
                        .notConsumable(GTItems.SHAPE_EXTRUDER_BLOCK)
                        .outputItems(blockStack)
                        .duration(mass << 1).EUt(8L * GTEUtils.getVoltageMultiplier(material))
                        .save();

            } else if (material.hasProperty(PropertyKey.GEM)) {
                COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_gem_to_block")
                        .inputItems(gem, material, amount)
                        .outputItems(blockStack)
                        .duration(Math.max(1, mass * amount / 4)).EUt(VA[ULV]).save();

                FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + material.getName() + "_block_to_gem")
                        .inputItems(blockStack)
                        .outputItems(gem, material, amount)
                        .duration(100).EUt(24).save();
            }
        }
    }

    private static void processFrame(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(frameGt, material);
        if (stack.isEmpty()) return;
        boolean isWoodenFrame = material.hasProperty(PropertyKey.WOOD);
        if (material.getMass() < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("frame_%s", material.getName()),
                    stack.copyWithCount(2), "SSS", isWoodenFrame ? "SsS" : "SwS", "SSS",
                    'S', new MaterialEntry(rod, material));

        ASSEMBLER_RECIPES.recipeBuilder("assemble_" + material.getName() + "_frame")
                .inputItems(rod, material, 4)
                .circuitMeta(4)
                .outputItems(stack)
                .EUt(VA[ULV]).duration(64)
                .save();
    }

    private static void processGemConversion(TagPrefix gemPrefix, Material material, Consumer<FinishedRecipe> provider) {
        if (material.hasFlag(MORTAR_GRINDABLE)) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("gem_to_dust_%s_%s", material.getName(), FormattingUtil.toLowerCaseUnder(gemPrefix.name)), ChemicalHelper.getDust(material, gemPrefix.getMaterialAmount(material)), "X", "m", 'X', new MaterialEntry(gemPrefix, material));
        }

        TagPrefix prevPrefix = GTUtil.getItem(GEM_ORDER, GEM_ORDER.indexOf(gemPrefix) - 1, null);
        ItemStack prevStack = prevPrefix == null ? ItemStack.EMPTY : ChemicalHelper.get(prevPrefix, material, 2);
        if (!prevStack.isEmpty() && prevPrefix != null) {
            CUTTER_RECIPES.recipeBuilder("cut_" + material.getName() + "_" + FormattingUtil.toLowerCaseUnder(gemPrefix.name) + "_to_" + FormattingUtil.toLowerCaseUnder(prevPrefix.name))
                    .inputItems(gemPrefix, material)
                    .outputItems(prevStack)
                    .duration(20)
                    .EUt(16)
                    .save();

            LASER_ENGRAVER_RECIPES.recipeBuilder("engrave_" + material.getName() + "_" + FormattingUtil.toLowerCaseUnder(gemPrefix.name) + "_to_" + FormattingUtil.toLowerCaseUnder(prevPrefix.name))
                    .inputItems(prevStack)
                    .notConsumable(lens, MarkerMaterials.Color.White)
                    .inputFluids(DistilledWater.getFluid(10))
                    .outputItems(gemPrefix, material)
                    .duration(300)
                    .EUt(240)
                    .save();
        }
    }

    private static void processDust(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack dustStack = ChemicalHelper.get(TagPrefix.dust, material);
        if (dustStack.isEmpty()) return;
        String id = "%s_%s_".formatted(FormattingUtil.toLowerCaseUnder(TagPrefix.dust.name),
                material.getName().toLowerCase(Locale.ROOT));
        OreProperty oreProperty = material.hasProperty(PropertyKey.ORE) ? material.getProperty(PropertyKey.ORE) : null;
        if (material.hasProperty(PropertyKey.GEM)) {
            ItemStack gemStack = ChemicalHelper.get(gem, material);

            if (material.hasFlag(CRYSTALLIZABLE)) {
                AUTOCLAVE_RECIPES.recipeBuilder("autoclave_" + id + "_water")
                        .inputItems(dustStack)
                        .inputFluids(GTMaterials.Water.getFluid(250))
                        .chancedOutput(gemStack, 7000, 1000)
                        .duration(1200).EUt(24)
                        .save();

                AUTOCLAVE_RECIPES.recipeBuilder("autoclave_" + id + "_distilled")
                        .inputItems(dustStack)
                        .inputFluids(DistilledWater.getFluid(50))
                        .outputItems(gemStack)
                        .duration(600).EUt(24)
                        .save();
            }

            if (!material.hasFlag(EXPLOSIVE) && !material.hasFlag(FLAMMABLE)) {
                ItemStack dustStack4 = dustStack.copyWithCount(4);
                ItemStack gemStack3 = gemStack.copyWithCount(3);
                IMPLOSION_RECIPES.recipeBuilder("implode_" + id + "_powderbarrel")
                        .inputItems(dustStack4)
                        .outputItems(gemStack3)
                        .chancedOutput(dust, GTMaterials.DarkAsh, 2500, 0)
                        .explosivesType(new ItemStack(GTBlocks.POWDERBARREL, 8))
                        .save();

                IMPLOSION_RECIPES.recipeBuilder("implode_" + id + "_tnt")
                        .inputItems(dustStack4)
                        .outputItems(gemStack3)
                        .chancedOutput(dust, GTMaterials.DarkAsh, 2500, 0)
                        .explosivesAmount(4)
                        .save();

                IMPLOSION_RECIPES.recipeBuilder("implode_" + id + "_dynamite")
                        .inputItems(dustStack4)
                        .outputItems(gemStack3)
                        .chancedOutput(dust, GTMaterials.DarkAsh, 2500, 0)
                        .explosivesType(GTItems.DYNAMITE.asStack(2))
                        .save();

                IMPLOSION_RECIPES.recipeBuilder("implode_" + id + "_itnt")
                        .inputItems(dustStack4)
                        .outputItems(gemStack3)
                        .chancedOutput(dust, GTMaterials.DarkAsh, 2500, 0)
                        .explosivesType(new ItemStack(GTBlocks.INDUSTRIAL_TNT))
                        .save();

                ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder("electric_implode_" + id)
                        .inputItems(dustStack4)
                        .outputItems(gemStack3)
                        .save();
            }

            if (oreProperty != null) {
                Material smeltingResult = oreProperty.getDirectSmeltResult();
                if (!smeltingResult.isNull()) {
                    VanillaRecipeHelper.addSmeltingRecipe(provider, id + "_ingot",
                            dustStack, ChemicalHelper.get(ingot, smeltingResult));
                }
            }

        } else if (material.hasProperty(PropertyKey.INGOT)) {
            if (!material.hasAnyOfFlags(FLAMMABLE, NO_SMELTING)) {

                boolean hasHotIngot = ingotHot.doGenerateItem(material);
                ItemStack ingotStack = ChemicalHelper.get(hasHotIngot ? ingotHot : ingot, material);
                if (ingotStack.isEmpty() && oreProperty != null) {
                    Material smeltingResult = oreProperty.getDirectSmeltResult();
                    if (smeltingResult.isNull()) {
                        ingotStack = ChemicalHelper.get(ingot, smeltingResult);
                    }
                }
                int blastTemp = material.getBlastTemperature();

                if (blastTemp <= 0) {
                    // smelting magnetic dusts is handled elsewhere
                    if (!material.hasFlag(IS_MAGNETIC)) {
                        // do not register inputs by ore dict here. Let other mods register their own dust -> ingots
                        VanillaRecipeHelper.addSmeltingRecipe(provider, id + "_demagnetize_from_dust",
                                dustStack, ingotStack);
                    }
                } else {
                    IngotProperty ingotProperty = material.getProperty(PropertyKey.INGOT);
                    BlastProperty blastProperty = material.getProperty(PropertyKey.BLAST);

                    processEBFRecipe(material, blastProperty, ingotStack, provider);

                    if (!ingotProperty.getMagneticMaterial().isNull()) {
                        processEBFRecipe(ingotProperty.getMagneticMaterial(), blastProperty, ingotStack, provider);
                    }
                }
            }
        } else {
            if (material.hasFlag(GENERATE_PLATE) && !material.hasFlag(EXCLUDE_PLATE_COMPRESSOR_RECIPE)) {
                COMPRESSOR_RECIPES.recipeBuilder("compress_plate_" + id)
                        .inputItems(dustStack)
                        .outputItems(plate, material)
                        .EUt(VA[ULV])
                        .duration((int) material.getMass())
                        .save();
            }

            // Some Ores with Direct Smelting Results have neither ingot nor gem properties
            if (oreProperty != null) {
                Material smeltingResult = oreProperty.getDirectSmeltResult();
                if (smeltingResult.isNull()) {
                    ItemStack ingotStack = ChemicalHelper.get(ingot, smeltingResult);
                    if (!ingotStack.isEmpty()) {
                        VanillaRecipeHelper.addSmeltingRecipe(provider, id + "_dust_to_ingot", dustStack, ingotStack);
                    }
                }
            }
        }
    }

    private static void processSmallDust(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack1 = ChemicalHelper.get(TagPrefix.dustSmall, material, 4);
        if (stack1.isEmpty()) return;
        ItemStack stack2 = ChemicalHelper.get(dust, material);
        PACKER_RECIPES.recipeBuilder("package_" + material.getName() + "_small_dust")
                .inputItems(stack1)
                .outputItems(stack2)
                .save();

        UNPACKER_RECIPES.recipeBuilder("unpackage_" + material.getName() + "_small_dust")
                .inputItems(stack2)
                .circuitMeta(1)
                .outputItems(stack1)
                .save();
    }

    private static void processTinyDust(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack1 = ChemicalHelper.get(TagPrefix.dustTiny, material, 9);
        if (stack1.isEmpty()) return;
        ItemStack stack2 = ChemicalHelper.get(dust, material);
        PACKER_RECIPES.recipeBuilder("package_" + material.getName() + "_tiny_dust")
                .inputItems(stack1)
                .outputItems(stack2)
                .save();

        UNPACKER_RECIPES.recipeBuilder("unpackage_" + material.getName() + "_tiny_dust")
                .inputItems(stack2)
                .circuitMeta(2)
                .outputItems(stack1)
                .save();
    }

    private static void processEBFRecipe(Material material, BlastProperty property, ItemStack output,
                                         Consumer<FinishedRecipe> provider) {
        int blastTemp = property.getBlastTemperature();
        BlastProperty.GasTier gasTier = property.getGasTier();
        int duration = property.getDurationOverride();
        if (duration <= 0) {
            duration = Math.max(1, (int) (material.getMass() * blastTemp / 50L));
        }
        int EUt = property.getEUtOverride();
        if (EUt <= 0) EUt = VA[MV];

        GTERecipeBuilder blastBuilder = BLAST_RECIPES.recipeBuilder("blast_" + material.getName())
                .inputItems(dust, material)
                .outputItems(output)
                .blastFurnaceTemp(blastTemp)
                .EUt(EUt);

        if (gasTier != null) {
            FluidIngredient gas = property.getGasTier().getFluid();

            blastBuilder.copy("blast_" + material.getName())
                    .circuitMeta(1)
                    .duration(duration)
                    .save();

            blastBuilder.copy("blast_" + material.getName() + "_gas")
                    .circuitMeta(2)
                    .inputFluids(gas)
                    .duration((int) (duration * 0.67))
                    .save();
        } else {
            blastBuilder.duration(duration);
            if (material == Silicon) {
                blastBuilder.circuitMeta(1);
            }
            blastBuilder.save();
        }

        // Add Vacuum Freezer recipe if required.
        if (ingotHot.doGenerateItem(material)) {
            int vacuumEUt = property.getVacuumEUtOverride() != -1 ? property.getVacuumEUtOverride() : VA[MV];
            int vacuumDuration = property.getVacuumDurationOverride() != -1 ? property.getVacuumDurationOverride() :
                    (int) material.getMass() * 3;
            if (blastTemp < 5000) {
                VACUUM_RECIPES.recipeBuilder("cool_hot_" + material.getName() + "_ingot")
                        .inputItems(ingotHot, material)
                        .outputItems(ingot, material)
                        .duration(vacuumDuration)
                        .EUt(vacuumEUt)
                        .save();
            } else {
                VACUUM_RECIPES.recipeBuilder("cool_hot_" + material.getName() + "_ingot")
                        .inputItems(ingotHot, material)
                        .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID, 500))
                        .outputItems(ingot, material)
                        .outputFluids(Helium.getFluid(250))
                        .duration(vacuumDuration)
                        .EUt(vacuumEUt)
                        .save();
            }
        }

        AlloyBlastProperty alloyBlastProperty = material.getProperty(PropertyKey.ALLOY_BLAST);
        if (alloyBlastProperty != null) {
            alloyBlastProperty.getRecipeProducer().produce(material, property, provider);
        }
    }
}
