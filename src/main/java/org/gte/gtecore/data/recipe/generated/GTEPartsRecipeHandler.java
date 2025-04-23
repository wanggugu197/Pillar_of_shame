package org.gte.gtecore.data.recipe.generated;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.chemical.material.GTEMaterial;
import org.gte.gtecore.api.data.chemical.material.info.GTEMaterialFlags;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.GTEUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.item.TurbineRotorBehaviour;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DistilledWater;
import static org.gte.gtecore.api.data.tag.GTETagPrefix.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;

public interface GTEPartsRecipeHandler {

    static void run(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {
        if (GTEUtils.isGeneration(rod, material)) {
            processStick(material, provider);
            if (GTEUtils.isGeneration(rodLong, material)) {
                processLongStick(material, provider);
            }
        }
        if (GTEUtils.isGeneration(plate, material)) {
            processPlate(material, provider);
            processPlateDouble(material, provider);
            processPlateDense(material, provider);
        }

        if (GTEUtils.isGeneration(turbineBlade, material)) {
            processTurbine(material, provider);
        }
        if (GTEUtils.isGeneration(rotor, material)) {
            processRotor(material, provider);
        }
        if (GTEUtils.isGeneration(bolt, material)) {
            processBolt(material, provider);
            processScrew(material, provider);
        }
        if (GTEUtils.isGeneration(wireFine, material)) {
            processFineWire(material, provider);
        }
        if (GTEUtils.isGeneration(foil, material)) {
            processFoil(material, provider);
        }
        if (GTEUtils.isGeneration(lens, material)) {
            processLens(material, provider);
        }
        if (GTEUtils.isGeneration(gear, material)) {
            processGear(gear, material, provider);
        }
        if (GTEUtils.isGeneration(gearSmall, material)) {
            processGear(gearSmall, material, provider);
        }
        if (GTEUtils.isGeneration(ring, material)) {
            processRing(material, provider);
        }
        if (GTEUtils.isGeneration(springSmall, material)) {
            processSpringSmall(material, provider);
        }
        if (GTEUtils.isGeneration(spring, material)) {
            processSpring(material, provider);
        }
        if (GTEUtils.isGeneration(round, material)) {
            processRound(material, provider);
        }
        if (GTEUtils.isGeneration(NANITES, material)) {
            processManoswarm(material, provider);
        }
        if (GTEUtils.isGeneration(CURVED_PLATE, material)) {
            processcurvedPlate(material, provider);
        }
        if (material.hasFlag(GTEMaterialFlags.GENERATE_COMPONENT)) {
            processMotorEnclosure(material, provider);
            processPumpBarrel(material, provider);
            processPistonHousing(material, provider);
            processEmitterBases(material, provider);
            processSensorCasing(material, provider);
            processFieldGeneratorCasing(material, provider);
        }
        if (GTEUtils.isGeneration(CATALYST, material)) {
            processCatalyst(material, provider);
        }
        if (GTEUtils.isGeneration(ROUGH_BLANK, material)) {
            processroughBlank(material, provider);
        }
        if (GTEUtils.isGeneration(ARTIFICIAL_GEM, material)) {
            processCrystallization(material);
        }
    }

    private static void processScrew(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack screwStack = ChemicalHelper.get(TagPrefix.screw, material);
        if (screwStack.isEmpty()) return;
        int mass = (int) material.getMass();
        ItemStack stack = ChemicalHelper.get(bolt, material);
        LATHE_RECIPES.recipeBuilder("lathe_" + material.getName() + "_bolt_to_screw")
                .inputItems(stack)
                .outputItems(screwStack)
                .duration(Math.max(1, mass / 8))
                .EUt(4)
                .save();

        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("screw_%s", material.getName()), screwStack, "fX", "X ", 'X', stack);
    }

    private static void processFoil(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(TagPrefix.foil, material, 4);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        ItemStack stack1 = ChemicalHelper.get(TagPrefix.plate, material);
        if (!material.hasFlag(NO_SMASHING) && mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("foil_%s", material.getName()),
                    stack.copyWithCount(2), "hP ", 'P', stack1);

        CLUSTER_RECIPES.recipeBuilder("bend_" + material.getName() + "_plate_to_foil")
                .inputItems(stack1)
                .outputItems(stack)
                .duration(mass)
                .EUt(24)
                .save();

        if (material.hasFlag(NO_SMASHING)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_foil")
                    .inputItems(ingot, material)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_FOIL)
                    .outputItems(stack)
                    .duration(mass)
                    .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
                    .save();
        }
    }

    private static void processLens(@NotNull Material material, @NotNull Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(lens, material);
        if (stack.isEmpty()) return;
        LATHE_RECIPES.recipeBuilder("lathe_" + material.getName() + "_plate_to_lens")
                .inputItems(plate, material)
                .outputItems(stack)
                .outputItems(dustSmall, material)
                .duration(1200).EUt(120).save();

        if (!ChemicalHelper.get(gemExquisite, material).isEmpty()) {
            LATHE_RECIPES.recipeBuilder("lathe_" + material.getName() + "_gem_to_lens")
                    .inputItems(gemExquisite, material)
                    .outputItems(stack)
                    .outputItems(dust, material, 2)
                    .duration(2400).EUt(30).save();
        }
    }

    private static void processFineWire(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack fineWireStack = ChemicalHelper.get(TagPrefix.wireFine, material);
        if (fineWireStack.isEmpty()) return;
        int mass = (int) material.getMass();
        if (!ChemicalHelper.get(foil, material).isEmpty() && mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapelessRecipe(provider, String.format("fine_wire_%s", material.getName()),
                    fineWireStack, 'x', new MaterialEntry(foil, material));
        int voltageMultiplier = GTEUtils.getVoltageMultiplier(material);
        if (material.hasProperty(PropertyKey.WIRE)) {
            WIREMILL_RECIPES.recipeBuilder("mill_" + material.getName() + "_wire_to_fine_wire")
                    .inputItems(wireGtSingle, material)
                    .outputItems(fineWireStack.copyWithCount(4))
                    .duration(mass * 3 / 2)
                    .EUt(voltageMultiplier)
                    .save();
        } else {
            WIREMILL_RECIPES.recipeBuilder("mill_" + material.getName() + "ingot_to_fine_wire")
                    .inputItems(ingot, material)
                    .outputItems(fineWireStack.copyWithCount(8))
                    .duration(mass * 3)
                    .EUt(voltageMultiplier)
                    .save();
        }
    }

    private static void processGear(TagPrefix gearPrefix, Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(gearPrefix, material);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        if (gearPrefix == gear && material.hasProperty(PropertyKey.INGOT)) {
            int voltageMultiplier = GTEUtils.getVoltageMultiplier(material);
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_gear")
                    .inputItems(ingot, material, 4)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_GEAR)
                    .outputItems(gearPrefix, material)
                    .duration(mass * 5)
                    .EUt(8L * voltageMultiplier)
                    .save();

            if (material.hasFlag(NO_SMASHING)) {
                EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_dust_to_gear")
                        .inputItems(dust, material, 4)
                        .notConsumable(GTItems.SHAPE_EXTRUDER_GEAR)
                        .outputItems(gearPrefix, material)
                        .duration(mass * 5)
                        .EUt(8L * voltageMultiplier)
                        .save();
            }
        }

        if (material.hasFluid()) {
            boolean isSmall = gearPrefix == gearSmall;
            FLUID_SOLIDFICATION_RECIPES.recipeBuilder("solidify_" + material.getName() + "_" + gearPrefix.name)
                    .notConsumable(isSmall ? GTItems.SHAPE_MOLD_GEAR_SMALL : GTItems.SHAPE_MOLD_GEAR)
                    .inputFluids(material.getFluid(L * (isSmall ? 1 : 4)))
                    .outputItems(stack)
                    .duration(mass * (isSmall ? 2 : 8))
                    .EUt(VA[LV])
                    .save();
        }

        if (material.hasFlag(GENERATE_PLATE) && material.hasFlag(GENERATE_ROD)) {
            if (gearPrefix == gearSmall) {
                if (mass < 240 && material.getBlastTemperature() < 3600)
                    VanillaRecipeHelper.addShapedRecipe(provider, String.format("small_gear_%s", material.getName()),
                            ChemicalHelper.get(gearSmall, material),
                            " R ", "hPx", " R ", 'R', new MaterialEntry(rod, material), 'P',
                            new MaterialEntry(plate, material));

                EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_small_gear")
                        .inputItems(ingot, material)
                        .notConsumable(GTItems.SHAPE_EXTRUDER_GEAR_SMALL)
                        .outputItems(stack)
                        .duration(mass)
                        .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
                        .save();

                if (material.hasFlag(NO_SMASHING)) {
                    EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_dust_to_small_gear")
                            .inputItems(dust, material)
                            .notConsumable(GTItems.SHAPE_EXTRUDER_GEAR_SMALL)
                            .outputItems(stack)
                            .duration(mass)
                            .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
                            .save();
                }
            } else if (mass < 240 && material.getBlastTemperature() < 3600) {
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("gear_%s", material.getName()), stack,
                        "RPR", "PwP", "RPR",
                        'P', new MaterialEntry(plate, material),
                        'R', new MaterialEntry(rod, material));
            }
        }
    }

    private static void processPlate(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(plate, material);
        if (stack.isEmpty()) return;
        if (material.hasFluid()) {
            FluidStack fluidStack = material.getProperty(PropertyKey.FLUID).solidifiesFrom(L);
            if (!fluidStack.isEmpty()) {
                FLUID_SOLIDFICATION_RECIPES.recipeBuilder("solidify_" + material.getName() + "_to_plate")
                        .notConsumable(GTItems.SHAPE_MOLD_PLATE)
                        .inputFluids(fluidStack)
                        .outputItems(stack)
                        .duration((int) material.getMass())
                        .EUt(VA[ULV])
                        .save();
            }
        }
    }

    private static void processPlateDouble(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(TagPrefix.plateDouble, material);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        if (!material.hasFlag(NO_SMASHING) && mass < 240 && material.getBlastTemperature() < 3600) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("plate_double_%s", material.getName()),
                    stack, "h", "P", "P", 'P', new MaterialEntry(plate, material));
        }

        ROLLING_RECIPES.recipeBuilder("bend_" + material.getName() + "_plate_to_double_plate")
                .EUt(96).duration(mass << 1)
                .inputItems(ingot, material, 2)
                .outputItems(stack)
                .circuitMeta(2)
                .save();
    }

    private static void processPlateDense(Material material, Consumer<FinishedRecipe> provider) {
        if (!material.hasFlag(MaterialFlags.GENERATE_DENSE)) return;
        ItemStack stack = ChemicalHelper.get(TagPrefix.plateDense, material);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        if (material.hasProperty(PropertyKey.INGOT)) {
            ROLLING_RECIPES.recipeBuilder("rolling_" + material.getName() + "_block_to_dense_plate")
                    .inputItems(block, material)
                    .outputItems(stack)
                    .duration(mass * 11)
                    .circuitMeta(3)
                    .EUt(96)
                    .save();
        } else {
            ROLLING_RECIPES.recipeBuilder("rolling_" + material.getName() + "_plate_to_dense_plate")
                    .inputItems(plate, material, 9)
                    .outputItems(stack)
                    .duration(mass * 11)
                    .circuitMeta(3)
                    .EUt(96)
                    .save();
        }
    }

    private static void processRing(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(TagPrefix.ring, material, 4);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_ring")
                .inputItems(ingot, material)
                .notConsumable(GTItems.SHAPE_EXTRUDER_RING)
                .outputItems(stack)
                .duration(mass << 1)
                .EUt(6L * GTEUtils.getVoltageMultiplier(material))
                .save();

        if (material.hasFlag(GENERATE_ROD)) {
            BENDER_RECIPES.recipeBuilder("bender_" + material.getName() + "_rod_to_ring")
                    .inputItems(rod, material)
                    .outputItems(stack.copyWithCount(2))
                    .duration(mass)
                    .EUt(16)
                    .circuitMeta(2)
                    .save();
        }

        if (!material.hasFlag(NO_SMASHING)) {
            if (mass < 240 && material.getBlastTemperature() < 3600)
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("ring_%s", material.getName()),
                        stack.copyWithCount(1),
                        "h ", " X",
                        'X', new MaterialEntry(rod, material));
        } else {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_dust_to_ring")
                    .inputItems(dust, material)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_RING)
                    .outputItems(stack)
                    .duration(mass << 1)
                    .EUt(6L * GTEUtils.getVoltageMultiplier(material))
                    .save();
        }
    }

    private static void processSpringSmall(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack springstack = ChemicalHelper.get(TagPrefix.springSmall, material);
        if (springstack.isEmpty()) return;
        int mass = (int) material.getMass();
        ItemStack stack = ChemicalHelper.get(rod, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("spring_small_%s", material.getName()),
                    springstack,
                    " s ", "fRx", 'R', stack);

        BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_rod_to_small_spring")
                .duration(Math.max(1, mass / 2)).EUt(VA[ULV])
                .inputItems(stack)
                .outputItems(springstack.copyWithCount(2))
                .circuitMeta(1)
                .save();
    }

    private static void processSpring(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack springstack = ChemicalHelper.get(TagPrefix.spring, material);
        if (springstack.isEmpty()) return;
        int mass = (int) material.getMass();
        ItemStack stack = ChemicalHelper.get(rodLong, material);
        BENDER_RECIPES.recipeBuilder(material.getName() + "_long_rod_to_spring")
                .inputItems(stack)
                .outputItems(springstack)
                .circuitMeta(1)
                .duration(mass)
                .EUt(16)
                .save();

        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("spring_%s", material.getName()),
                    springstack, " s ", "fRx", " R ", 'R', stack);
    }

    private static void processRotor(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(TagPrefix.rotor, material);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        ItemStack curvedPlateStack = ChemicalHelper.get(GTETagPrefix.CURVED_PLATE, material);
        ItemStack ringStack = ChemicalHelper.get(ring, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("rotor_%s", material.getName()), stack,
                    "ChC", "SRf", "CdC",
                    'C', curvedPlateStack,
                    'S', new MaterialEntry(screw, material),
                    'R', ringStack);

        if (material.hasFluid()) {
            FLUID_SOLIDFICATION_RECIPES.recipeBuilder("solidify_" + material.getName() + "_to_rotor")
                    .notConsumable(GTItems.SHAPE_MOLD_ROTOR)
                    .inputFluids(material.getFluid(L * 5))
                    .outputItems(stack)
                    .duration(mass * 6)
                    .EUt(VA[LV])
                    .save();
        }

        EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_rotor")
                .inputItems(ingot, material, 5)
                .notConsumable(GTItems.SHAPE_EXTRUDER_ROTOR)
                .outputItems(stack)
                .duration(mass << 2)
                .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
                .save();

        LASER_WELDER_RECIPES.recipeBuilder(material.getName() + "_to_rotor")
                .inputItems(curvedPlateStack.copyWithCount(4))
                .inputItems(ringStack)
                .circuitMeta(1)
                .outputItems(stack)
                .duration(mass)
                .EUt(30)
                .save();

        if (material.hasFlag(NO_SMASHING)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_dust_to_rotor")
                    .inputItems(dust, material, 5)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_ROTOR)
                    .outputItems(stack)
                    .duration(mass << 2)
                    .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
                    .save();
        }
    }

    private static void processBolt(@NotNull Material material, @NotNull Consumer<FinishedRecipe> provider) {
        if (!material.shouldGenerateRecipesFor(bolt)) {
            return;
        }

        ItemStack boltStack = ChemicalHelper.get(bolt,
                material.hasFlag(IS_MAGNETIC) && material.hasProperty(PropertyKey.INGOT) ?
                        material.getProperty(PropertyKey.INGOT).getMacerateInto() : material,
                8);
        ItemStack ingotStack = ChemicalHelper.get(ingot, material);

        CUTTER_RECIPES.recipeBuilder("cut_" + material.getName() + "_screw_to_bolt")
                .inputItems(screw, material)
                .outputItems(boltStack.copyWithCount(1))
                .duration(20)
                .EUt(24)
                .save();

        if (!boltStack.isEmpty() && !ingotStack.isEmpty()) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_bolt")
                    .inputItems(ingot, material)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_BOLT)
                    .outputItems(boltStack)
                    .duration(15)
                    .EUt((long) GTEUtils.getVoltageMultiplier(material) << 2)
                    .save();

            if (material.hasFlag(NO_SMASHING)) {
                EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_dust_to_bolt")
                        .inputItems(dust, material)
                        .notConsumable(GTItems.SHAPE_EXTRUDER_BOLT)
                        .outputItems(boltStack)
                        .duration(15)
                        .EUt((long) GTEUtils.getVoltageMultiplier(material) << 2)
                        .save();
            }
        }
    }

    private static void processStick(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(rod, material);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        if (material.hasProperty(PropertyKey.GEM) || material.hasProperty(PropertyKey.INGOT)) {
            LATHE_RECIPES.recipeBuilder("lathe_" + material.getName() + "_to_rod")
                    .inputItems(material.hasProperty(PropertyKey.GEM) ? gem : ingot, material)
                    .outputItems(stack.copyWithCount(2))
                    .duration(mass << 1)
                    .EUt(GTEUtils.getVoltageMultiplier(material)).save();
        }

        if (material.hasFlag(GENERATE_BOLT_SCREW)) {
            ItemStack boltStack = ChemicalHelper.get(bolt, material, 4);
            CUTTER_RECIPES.recipeBuilder("cut_" + material.getName() + "_rod_to_bolt")
                    .inputItems(stack)
                    .outputItems(boltStack)
                    .duration(mass << 1)
                    .EUt(4)
                    .save();

            if (mass < 240 && material.getBlastTemperature() < 3600)
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("bolt_saw_%s", material.getName()), boltStack.copyWithCount(2), "s ", " X", 'X', stack);
        }
    }

    private static void processLongStick(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(TagPrefix.rodLong, material);
        if (stack.isEmpty()) return;
        ItemStack stickStack = ChemicalHelper.get(rod, material, 2);
        int mass = (int) material.getMass();
        GTERecipeBuilder builder = CUTTER_RECIPES.recipeBuilder("cut_" + material.getName() + "_long_rod_to_rod")
                .inputItems(stack)
                .duration(mass).EUt(4);
        if (ConfigHolder.INSTANCE.recipes.harderRods) {
            builder.outputItems(stickStack.copyWithCount(1));
            builder.outputItems(dustSmall, material, 2);
        } else {
            builder.outputItems(stickStack);
        }
        builder.save();

        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("stick_long_%s", material.getName()), stickStack, "s", "X", 'X', stack);

        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("stick_long_stick_%s", material.getName()), stack, "ShS", 'S', stickStack.copyWithCount(1));

        LASER_WELDER_RECIPES.recipeBuilder(material.getName() + "_rod_to_long_rod")
                .inputItems(stickStack)
                .circuitMeta(2)
                .outputItems(stack)
                .duration(mass)
                .EUt(16)
                .save();

        if (material.hasProperty(PropertyKey.INGOT)) {
            EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_long_rod")
                    .inputItems(ingot, material)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_ROD_LONG)
                    .outputItems(stack)
                    .duration(mass)
                    .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
                    .save();

            if (material.hasFlag(NO_SMASHING)) {
                EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_dust_to_long_rod")
                        .inputItems(dust, material)
                        .notConsumable(GTItems.SHAPE_EXTRUDER_ROD_LONG)
                        .outputItems(stack)
                        .duration(mass)
                        .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
                        .save();
            }
        }
    }

    private static void processTurbine(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(turbineBlade, material);
        if (stack.isEmpty()) return;
        ItemStack rotorStack = GTItems.TURBINE_ROTOR.asStack();
        int mass = (int) material.getMass();
        // noinspection ConstantConditions
        TurbineRotorBehaviour.getBehaviour(rotorStack).setPartMaterial(rotorStack, material);

        ASSEMBLER_RECIPES.recipeBuilder("assemble_" + material.getName() + "_turbine_blade")
                .inputItems(stack.copyWithCount(8))
                .inputItems(rodLong, GTMaterials.Magnalium)
                .outputItems(rotorStack)
                .duration(200)
                .EUt(400)
                .save();

        FORMING_PRESS_RECIPES.recipeBuilder("press_" + material.getName() + "_turbine_rotor")
                .inputItems(plateDouble, material, 5)
                .inputItems(screw, material, 2)
                .outputItems(stack)
                .duration(mass << 4)
                .EUt((long) GTEUtils.getVoltageMultiplier(material) << 2)
                .save();
    }

    private static void processRound(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack1 = ChemicalHelper.get(round, material);
        if (stack1.isEmpty()) return;
        ItemStack stack = ChemicalHelper.get(nugget, material);
        if (!material.hasFlag(NO_SMASHING) && material.getMass() < 222 && material.getBlastTemperature() < 6000) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("round_%s", material.getName()),
                    stack1, "fN", "Nh", 'N', stack);

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("round_from_ingot_%s", material.getName()),
                    stack1.copyWithCount(4), "fIh", 'I', new MaterialEntry(ingot, material));
        }

        LATHE_RECIPES.recipeBuilder("lathe_" + material.getName() + "_nugget_to_round")
                .EUt(GTEUtils.getVoltageMultiplier(material)).duration(Math.min(1, (int) material.getMass() / 9))
                .inputItems(stack)
                .outputItems(stack1)
                .save();
    }

    private static void processManoswarm(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(NANITES, material);
        if (stack.isEmpty()) return;
        CHEMICAL_BATH_RECIPES.recipeBuilder(material.getName() + "_nano_bath")
                .inputFluids(GTEMaterials.PiranhaSolution.getFluid((int) (10000 * Math.sqrt((double) material.getMass() / GTEMaterials.Eternity.getMass()))))
                .inputItems(CONTAMINABLE_NANITES, material)
                .outputItems(stack)
                .duration((int) material.getMass() << 4)
                .EUt(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }

    private static void processcurvedPlate(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(CURVED_PLATE, material);
        if (stack.isEmpty()) return;
        int mass = (int) material.getMass();
        ItemStack plateStack = ChemicalHelper.get(plate, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("curved_plate_%s", material.getName()),
                    stack, "hI", " h", 'I', plateStack);

        BENDER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_curved_plate"))
                .inputItems(plateStack)
                .outputItems(stack)
                .circuitMeta(1)
                .duration(mass)
                .EUt(16)
                .save();
    }

    private static void processMotorEnclosure(Material material, Consumer<FinishedRecipe> provider) {
        int mass = (int) material.getMass();
        ItemStack motorEnclosureStack = ChemicalHelper.get(MOTOR_ENCLOSURE, material);
        ItemStack curvedPlateStack = ChemicalHelper.get(CURVED_PLATE, material);
        ItemStack ringStack = ChemicalHelper.get(ring, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("motor_enclosure_%s", material.getName()),
                    motorEnclosureStack, "SwS", "IRI", " h ", 'I', curvedPlateStack, 'S', new MaterialEntry(screw, material), 'R', ringStack);

        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_motor_enclosure"))
                .inputItems(curvedPlateStack.copyWithCount(2))
                .inputItems(ringStack)
                .outputItems(motorEnclosureStack)
                .circuitMeta(3)
                .duration(mass)
                .EUt(30)
                .save();

        ItemStack data = GTEItems.DATA_DISC.get().getDisc(motorEnclosureStack);

        SCANNER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_motor_enclosure"))
                .inputItems(GTEItems.DATA_DISC.asItem())
                .inputItems(motorEnclosureStack)
                .outputItems(data)
                .EUt((long) GTEUtils.getVoltageMultiplier(material) << 4)
                .duration(mass)
                .save();

        THREE_DIMENSIONAL_PRINTER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_motor_enclosure"))
                .notConsumable(data)
                .inputFluids(material.getFluid(GTValues.L << 1))
                .outputItems(motorEnclosureStack)
                .duration(mass << 1)
                .EUt(16)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }

    private static void processPumpBarrel(Material material, Consumer<FinishedRecipe> provider) {
        int mass = (int) material.getMass();
        ItemStack pumpBarrelStack = ChemicalHelper.get(PUMP_BARREL, material);
        ItemStack curvedPlateStack = ChemicalHelper.get(CURVED_PLATE, material);
        ItemStack ringStack = ChemicalHelper.get(ring, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("pump_barrel_%s", material.getName()),
                    pumpBarrelStack, "wIw", "ShS", "RIR", 'I', curvedPlateStack, 'R', ringStack, 'S', new MaterialEntry(screw, material));

        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_pump_barrel"))
                .inputItems(curvedPlateStack.copyWithCount(2))
                .inputItems(ringStack.copyWithCount(2))
                .circuitMeta(4)
                .outputItems(pumpBarrelStack)
                .duration(mass)
                .EUt(30)
                .save();

        ItemStack data = GTEItems.DATA_DISC.get().getDisc(pumpBarrelStack);

        SCANNER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_pump_barrel"))
                .inputItems(GTEItems.DATA_DISC.asItem())
                .inputItems(pumpBarrelStack)
                .outputItems(data)
                .EUt((long) GTEUtils.getVoltageMultiplier(material) << 4)
                .duration(mass)
                .save();

        THREE_DIMENSIONAL_PRINTER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_pump_barrel"))
                .notConsumable(data)
                .inputFluids(material.getFluid(GTValues.L * 5 / 2))
                .outputItems(pumpBarrelStack)
                .duration(mass * 5 / 2)
                .EUt(16)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }

    private static void processPistonHousing(Material material, Consumer<FinishedRecipe> provider) {
        int mass = (int) material.getMass();
        ItemStack pistonHousingStack = ChemicalHelper.get(PISTON_HOUSING, material);
        ItemStack curvedPlateStack = ChemicalHelper.get(CURVED_PLATE, material);
        ItemStack plateStack = ChemicalHelper.get(plate, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("piston_housing_%s", material.getName()),
                    pistonHousingStack, "IhI", "SPS", "whw", 'I', curvedPlateStack, 'P', plateStack, 'S', new MaterialEntry(screw, material));

        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_piston_housing"))
                .inputItems(curvedPlateStack.copyWithCount(2))
                .inputItems(plateStack)
                .circuitMeta(5)
                .outputItems(pistonHousingStack)
                .duration(mass)
                .EUt(30)
                .save();

        ItemStack data = GTEItems.DATA_DISC.get().getDisc(pistonHousingStack);

        SCANNER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_piston_housing"))
                .inputItems(GTEItems.DATA_DISC.asItem())
                .inputItems(pistonHousingStack)
                .outputItems(data)
                .EUt((long) GTEUtils.getVoltageMultiplier(material) << 4)
                .duration(mass)
                .save();

        THREE_DIMENSIONAL_PRINTER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_piston_housing"))
                .notConsumable(data)
                .inputFluids(material.getFluid(GTValues.L * 3))
                .outputItems(pistonHousingStack)
                .duration(mass * 3)
                .EUt(16)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }

    private static void processEmitterBases(Material material, Consumer<FinishedRecipe> provider) {
        int mass = (int) material.getMass();
        ItemStack emitterBasesStack = ChemicalHelper.get(EMITTER_BASES, material);
        ItemStack curvedPlateStack = ChemicalHelper.get(CURVED_PLATE, material);
        ItemStack plateStack = ChemicalHelper.get(plate, material);
        ItemStack rodStack = ChemicalHelper.get(rod, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("emitter_base_%s", material.getName()),
                    emitterBasesStack, "SwS", "IPI", "RhR", 'I', curvedPlateStack, 'P', plateStack, 'R', rodStack, 'S', new MaterialEntry(screw, material));

        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_emitter_base"))
                .inputItems(curvedPlateStack.copyWithCount(2))
                .inputItems(rodStack.copyWithCount(2))
                .inputItems(plateStack)
                .outputItems(emitterBasesStack)
                .duration(mass)
                .EUt(30)
                .save();

        ItemStack data = GTEItems.DATA_DISC.get().getDisc(emitterBasesStack);

        SCANNER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_emitter_base"))
                .inputItems(GTEItems.DATA_DISC.asItem())
                .inputItems(emitterBasesStack)
                .outputItems(data)
                .EUt((long) GTEUtils.getVoltageMultiplier(material) << 4)
                .duration(mass)
                .save();

        THREE_DIMENSIONAL_PRINTER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_emitter_base"))
                .notConsumable(data)
                .inputFluids(material.getFluid(GTValues.L << 2))
                .outputItems(emitterBasesStack)
                .duration(mass << 2)
                .EUt(16)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }

    private static void processSensorCasing(Material material, Consumer<FinishedRecipe> provider) {
        int mass = (int) material.getMass();
        ItemStack sensorCasingStack = ChemicalHelper.get(SENSOR_CASING, material);
        ItemStack curvedPlateStack = ChemicalHelper.get(CURVED_PLATE, material);
        ItemStack rodStack = ChemicalHelper.get(rod, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("sensor_casing_%s", material.getName()),
                    sensorCasingStack, "wIh", "IRI", "SIS", 'I', curvedPlateStack, 'R', rodStack, 'S', new MaterialEntry(screw, material));

        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_sensor_casing"))
                .inputItems(curvedPlateStack.copyWithCount(4))
                .inputItems(rodStack.copyWithCount(1))
                .circuitMeta(6)
                .outputItems(sensorCasingStack)
                .duration(mass)
                .EUt(30)
                .save();

        ItemStack data = GTEItems.DATA_DISC.get().getDisc(sensorCasingStack);

        SCANNER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_sensor_casing"))
                .inputItems(GTEItems.DATA_DISC.asItem())
                .inputItems(sensorCasingStack)
                .outputItems(data)
                .EUt((long) GTEUtils.getVoltageMultiplier(material) << 4)
                .duration(mass)
                .save();

        THREE_DIMENSIONAL_PRINTER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_sensor_casing"))
                .notConsumable(data)
                .inputFluids(material.getFluid(GTValues.L * 9 / 2))
                .outputItems(sensorCasingStack)
                .duration(mass * 9 / 2)
                .EUt(16)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }

    private static void processFieldGeneratorCasing(Material material, Consumer<FinishedRecipe> provider) {
        int mass = (int) material.getMass();
        ItemStack fieldGeneratorCasingStack = ChemicalHelper.get(FIELD_GENERATOR_CASING, material);
        ItemStack curvedPlateStack = ChemicalHelper.get(CURVED_PLATE, material);
        ItemStack plateStack = ChemicalHelper.get(plate, material);
        if (mass < 240 && material.getBlastTemperature() < 3600)
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("field_generator_casing_%s", material.getName()),
                    fieldGeneratorCasingStack, "IPI", "PwP", "IPI", 'I', curvedPlateStack, 'P', plateStack);

        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_field_generator_casing"))
                .inputItems(curvedPlateStack.copyWithCount(4))
                .inputItems(plateStack.copyWithCount(4))
                .circuitMeta(7)
                .outputItems(fieldGeneratorCasingStack)
                .duration(mass)
                .EUt(30)
                .save();

        ItemStack data = GTEItems.DATA_DISC.get().getDisc(fieldGeneratorCasingStack);

        SCANNER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_field_generator_casing"))
                .inputItems(GTEItems.DATA_DISC.asItem())
                .inputItems(fieldGeneratorCasingStack)
                .outputItems(data)
                .EUt((long) GTEUtils.getVoltageMultiplier(material) << 4)
                .duration(mass)
                .save();

        THREE_DIMENSIONAL_PRINTER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_field_generator_casing"))
                .notConsumable(data)
                .inputFluids(material.getFluid(GTValues.L << 3))
                .outputItems(fieldGeneratorCasingStack)
                .duration(mass << 3)
                .EUt(16)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }

    private static void processCatalyst(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(CATALYST, material);
        if (stack.isEmpty()) return;
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_catalyst"))
                .inputItems(GTEItems.CATALYST_BASE.asItem())
                .inputItems(dust, material, 16)
                .outputItems(stack)
                .duration((int) material.getMass() << 2)
                .EUt(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }

    private static void processroughBlank(Material material, Consumer<FinishedRecipe> provider) {
        ItemStack stack = ChemicalHelper.get(ROUGH_BLANK, material);
        if (stack.isEmpty()) return;
        ItemStack stack1 = ChemicalHelper.get(block, material);
        ItemStack stack2 = ChemicalHelper.get(BRICK, material);
        SINTERING_FURNACE_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_rough_blank"))
                .inputItems(stack)
                .outputItems(stack1)
                .duration(400)
                .EUt(120)
                .blastFurnaceTemp(((GTEMaterial) material).gtecore$temp())
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_brick"))
                .inputItems(stack1)
                .outputItems(stack2.copyWithCount(9))
                .duration(300)
                .EUt(120)
                .save();

        CUTTER_RECIPES.recipeBuilder(GTECore.id(material.getName() + "_flakes"))
                .inputItems(stack2)
                .outputItems(FLAKES, material, 4)
                .duration(200)
                .EUt(30)
                .save();
    }

    private static void processCrystallization(Material material) {
        ItemStack stack = ChemicalHelper.get(CRYSTAL_SEED, material, 2);
        ItemStack stack1 = ChemicalHelper.get(gemExquisite, material);
        if (stack1.isEmpty()) return;
        CUTTER_RECIPES.recipeBuilder(GTECore.id("%s_gem".formatted(material.getName())))
                .inputItems(ARTIFICIAL_GEM, material)
                .outputItems(stack1)
                .outputItems(stack)
                .duration((int) (material.getMass() << 1))
                .EUt(16)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("%s_seed".formatted(material.getName())))
                .inputItems(stack1)
                .inputFluids(DistilledWater.getFluid(800))
                .outputItems(stack)
                .duration((int) (material.getMass() << 2))
                .EUt(7)
                .save();
    }
}
