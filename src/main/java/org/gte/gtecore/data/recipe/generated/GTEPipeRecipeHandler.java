package org.gte.gtecore.data.recipe.generated;

import org.gte.gtecore.api.data.tag.GTETagPrefix;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.NO_SMASHING;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Iron;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;
import static org.gte.gtecore.utils.GTEUtils.getVoltageMultiplier;

public class GTEPipeRecipeHandler {

    static void run(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {
        if (material.hasProperty(PropertyKey.FLUID_PIPE)) {
            processPipeTiny(provider, material);
            processPipeSmall(provider, pipeSmallFluid, material);
            processPipeNormal(provider, pipeNormalFluid, material);
            processPipeLarge(provider, pipeLargeFluid, material);
            processPipeHuge(provider, pipeHugeFluid, material);
            processPipeQuadruple(provider, material);
            processPipeNonuple(provider, material);
        } else if (material.hasProperty(PropertyKey.ITEM_PIPE)) {
            processPipeSmall(provider, pipeSmallItem, material);
            processPipeNormal(provider, pipeNormalItem, material);
            processPipeLarge(provider, pipeLargeItem, material);
            processPipeHuge(provider, pipeHugeItem, material);
            processRestrictivePipe(provider, pipeSmallRestrictive, pipeSmallItem, material);
            processRestrictivePipe(provider, pipeNormalRestrictive, pipeNormalItem, material);
            processRestrictivePipe(provider, pipeLargeRestrictive, pipeLargeItem, material);
            processRestrictivePipe(provider, pipeHugeRestrictive, pipeHugeItem, material);
        }
    }

    private static void processRestrictivePipe(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull TagPrefix unrestrictive, @NotNull Material material) {
        ItemStack pipeStack = ChemicalHelper.get(prefix, material);
        if (pipeStack.isEmpty()) return;
        ItemStack unrestrictiveStack = ChemicalHelper.get(unrestrictive, material);
        if (pipeStack.isEmpty()) return;
        LASER_WELDER_RECIPES.recipeBuilder("assemble_" + material.getName() + "_" + prefix.name)
                .inputItems(unrestrictiveStack)
                .inputItems(ring, Iron, 2)
                .outputItems(pipeStack)
                .duration(20)
                .EUt(VA[LV])
                .save();

        VanillaRecipeHelper.addShapedRecipe(provider,
                FormattingUtil.toLowerCaseUnder(prefix + "_" + material.getName()),
                pipeStack, "PR", "Rh",
                'P', unrestrictiveStack, 'R', ChemicalHelper.get(ring, Iron));
    }

    private static void processPipeTiny(@NotNull Consumer<FinishedRecipe> provider,
                                        @NotNull Material material) {
        ItemStack pipeStack = ChemicalHelper.get(TagPrefix.pipeTinyFluid, material);
        if (pipeStack.isEmpty()) return;

        if (material.hasProperty(PropertyKey.WOOD)) return;
        EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_tiny_pipe")
                .inputItems(ingot, material, 1)
                .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_TINY)
                .outputItems(pipeStack.copyWithCount(2))
                .duration((int) (material.getMass()))
                .EUt((long) getVoltageMultiplier(material) << 2)
                .save();

        if (material.hasFlag(NO_SMASHING)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_tiny_pipe_dust")
                    .inputItems(dust, material, 1)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_TINY)
                    .outputItems(pipeStack.copyWithCount(2))
                    .duration((int) (material.getMass()))
                    .EUt((long) getVoltageMultiplier(material) << 2)
                    .save();
        } else if (material.getMass() < 240 && material.getBlastTemperature() < 3600) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("tiny_%s_pipe", material.getName()),
                    pipeStack.copyWithCount(2), " s ", "hXw",
                    'X', new MaterialEntry(GTETagPrefix.CURVED_PLATE, material));
        }
    }

    private static void processPipeSmall(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {
        ItemStack pipeStack = ChemicalHelper.get(prefix, material);
        if (pipeStack.isEmpty()) return;

        if (material.hasProperty(PropertyKey.WOOD)) return;
        EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_small_pipe")
                .inputItems(ingot, material, 1)
                .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_SMALL)
                .outputItems(pipeStack)
                .duration((int) (material.getMass()))
                .EUt((long) getVoltageMultiplier(material) << 2)
                .save();

        if (material.hasFlag(NO_SMASHING)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_small_pipe_dust")
                    .inputItems(dust, material, 1)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_SMALL)
                    .outputItems(pipeStack)
                    .duration((int) (material.getMass()))
                    .EUt((long) getVoltageMultiplier(material) << 2)
                    .save();
        } else if (material.getMass() < 240 && material.getBlastTemperature() < 3600) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("small_%s_pipe", material.getName()),
                    pipeStack, "wXh",
                    'X', new MaterialEntry(GTETagPrefix.CURVED_PLATE, material));
        }
    }

    private static void processPipeNormal(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {
        ItemStack pipeStack = ChemicalHelper.get(prefix, material);
        if (pipeStack.isEmpty()) return;

        if (material.hasProperty(PropertyKey.WOOD)) return;
        EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_pipe")
                .inputItems(ingot, material, 3)
                .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_NORMAL)
                .outputItems(pipeStack)
                .duration((int) material.getMass() * 3)
                .EUt((long) getVoltageMultiplier(material) << 2)
                .save();

        if (material.hasFlag(NO_SMASHING)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_pipe_dust")
                    .inputItems(dust, material, 3)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_NORMAL)
                    .outputItems(pipeStack)
                    .duration((int) material.getMass() * 3)
                    .EUt((long) getVoltageMultiplier(material) << 2)
                    .save();
        } else if (material.getMass() < 240 && material.getBlastTemperature() < 3600) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("medium_%s_pipe", material.getName()),
                    pipeStack, "XXX", "w h",
                    'X', new MaterialEntry(GTETagPrefix.CURVED_PLATE, material));
        }
    }

    private static void processPipeLarge(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {
        ItemStack pipeStack = ChemicalHelper.get(prefix, material);
        if (pipeStack.isEmpty()) return;

        if (material.hasProperty(PropertyKey.WOOD)) return;
        EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_large_pipe")
                .inputItems(ingot, material, 6)
                .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_LARGE)
                .outputItems(pipeStack)
                .duration((int) material.getMass() * 6)
                .EUt((long) getVoltageMultiplier(material) << 2)
                .save();

        if (material.hasFlag(NO_SMASHING)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_large_pipe_dust")
                    .inputItems(dust, material, 6)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_LARGE)
                    .outputItems(pipeStack)
                    .duration((int) material.getMass() * 6)
                    .EUt((long) getVoltageMultiplier(material) << 2)
                    .save();
        } else if (material.getMass() < 240 && material.getBlastTemperature() < 3600) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("large_%s_pipe", material.getName()),
                    pipeStack, "XXX", "w h", "XXX",
                    'X', new MaterialEntry(GTETagPrefix.CURVED_PLATE, material));
        }
    }

    private static void processPipeHuge(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {
        ItemStack pipeStack = ChemicalHelper.get(prefix, material);
        if (pipeStack.isEmpty()) return;

        if (material.hasProperty(PropertyKey.WOOD)) return;
        EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_huge_pipe")
                .inputItems(ingot, material, 12)
                .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_HUGE)
                .outputItems(pipeStack)
                .duration((int) material.getMass() * 24)
                .EUt((long) getVoltageMultiplier(material) << 2)
                .save();

        if (material.hasFlag(NO_SMASHING)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_huge_pipe_dust")
                    .inputItems(dust, material, 12)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_PIPE_HUGE)
                    .outputItems(pipeStack)
                    .duration((int) material.getMass() * 24)
                    .EUt((long) getVoltageMultiplier(material) << 2)
                    .save();
        } else if (plateDouble.doGenerateItem(material) && material.getMass() < 240 && material.getBlastTemperature() < 3600) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("huge_%s_pipe", material.getName()),
                    pipeStack, "XXX", "w h", "XXX",
                    'X', new MaterialEntry(plateDouble, material));
        }
    }

    private static void processPipeQuadruple(@NotNull Consumer<FinishedRecipe> provider,
                                             @NotNull Material material) {
        ItemStack quadPipe = ChemicalHelper.get(TagPrefix.pipeQuadrupleFluid, material);
        if (quadPipe.isEmpty()) return;

        if (material.hasProperty(PropertyKey.WOOD)) return;
        ItemStack smallPipe = ChemicalHelper.get(pipeSmallFluid, material, 4);

        PACKER_RECIPES.recipeBuilder("package_" + material.getName() + "_quadruple_pipe")
                .inputItems(smallPipe)
                .circuitMeta(4)
                .outputItems(quadPipe)
                .duration(30)
                .EUt(VA[ULV])
                .save();
    }

    private static void processPipeNonuple(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {
        ItemStack nonuplePipe = ChemicalHelper.get(TagPrefix.pipeNonupleFluid, material);
        if (nonuplePipe.isEmpty()) return;
        if (material.hasProperty(PropertyKey.WOOD)) return;
        ItemStack smallPipe = ChemicalHelper.get(pipeSmallFluid, material, 9);

        PACKER_RECIPES.recipeBuilder("package_" + material.getName() + "_nonuple_pipe")
                .inputItems(smallPipe)
                .circuitMeta(9)
                .outputItems(nonuplePipe)
                .duration(40)
                .EUt(VA[ULV])
                .save();
    }
}
