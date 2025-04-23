package org.gte.gtecore.data.recipe;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMachines;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.data.machines.*;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import com.enderio.machines.common.init.MachineBlocks;
import org.apache.commons.lang3.ArrayUtils;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.*;
import static com.gregtechceu.gtceu.data.recipe.misc.MetaTileEntityLoader.registerMachineRecipe;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;

public interface MachineRecipe {

    static void init(Consumer<FinishedRecipe> provider) {
        HatchRecipe.init(provider);
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("evaporation_plant"),
                MultiBlockA.EVAPORATION_PLANT.asStack(), "CBC", "FMF", "CBC", 'M', GTMachines.HULL[HV].asStack(),
                'B', new MaterialEntry(TagPrefix.wireGtDouble, GTMaterials.Kanthal), 'C', CustomTags.HV_CIRCUITS,
                'F', GTItems.ELECTRIC_PUMP_HV);
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("casing_uev"), GTBlocks.MACHINE_CASING_UEV.asStack(),
                "PPP",
                "PwP", "PPP", 'P', new MaterialEntry(plate, GTEMaterials.Quantanium));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("casing_uiv"), GTBlocks.MACHINE_CASING_UIV.asStack(),
                "PPP",
                "PwP", "PPP", 'P', new MaterialEntry(plate, GTEMaterials.Adamantium));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("casing_uxv"), GTBlocks.MACHINE_CASING_UXV.asStack(),
                "PPP",
                "PwP", "PPP", 'P', new MaterialEntry(plate, GTEMaterials.Vibranium));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("casing_opv"), GTBlocks.MACHINE_CASING_OpV.asStack(),
                "PPP",
                "PwP", "PPP", 'P', new MaterialEntry(plate, GTEMaterials.Draconium));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("casing_max"), GTBlocks.MACHINE_CASING_MAX.asStack(),
                "PPP",
                "PwP", "PPP", 'P', new MaterialEntry(plate, GTEMaterials.Chaos));
        LASER_WELDER_RECIPES.recipeBuilder("casing_ulv").EUt(16).inputItems(plate, WroughtIron, 8)
                .outputItems(GTBlocks.MACHINE_CASING_ULV.asItem()).circuitMeta(8).duration(25).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_lv").EUt(16).inputItems(plate, Steel, 8)
                .outputItems(GTBlocks.MACHINE_CASING_LV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_mv").EUt(16).inputItems(plate, Aluminium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_MV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_hv").EUt(16).inputItems(plate, StainlessSteel, 8)
                .outputItems(GTBlocks.MACHINE_CASING_HV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_ev").EUt(16).inputItems(plate, Titanium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_EV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_iv").EUt(16).inputItems(plate, TungstenSteel, 8)
                .outputItems(GTBlocks.MACHINE_CASING_IV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_luv").EUt(16).inputItems(plate, RhodiumPlatedPalladium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_LuV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_zpm").EUt(16).inputItems(plate, NaquadahAlloy, 8)
                .outputItems(GTBlocks.MACHINE_CASING_ZPM.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_uv").EUt(16).inputItems(plate, Darmstadtium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_UV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder("casing_uhv").EUt(16).inputItems(plate, Neutronium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_UHV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("casing_uev")).EUt(16).inputItems(plate, GTEMaterials.Quantanium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_UEV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("casing_uiv")).EUt(16).inputItems(plate, GTEMaterials.Adamantium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_UIV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("casing_uxv")).EUt(16).inputItems(plate, GTEMaterials.Vibranium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_UXV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("casing_opv")).EUt(16).inputItems(plate, GTEMaterials.Draconium, 8)
                .outputItems(GTBlocks.MACHINE_CASING_OpV.asItem()).circuitMeta(8).duration(50).save();
        LASER_WELDER_RECIPES.recipeBuilder(GTECore.id("casing_max")).EUt(16).inputItems(plate, GTEMaterials.Chaos, 8)
                .outputItems(GTBlocks.MACHINE_CASING_MAX.asItem()).circuitMeta(8).duration(50).save();

        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_ulv")).duration(25).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_ULV.asItem()).inputItems(cableGtSingle, RedAlloy, 2)
                .inputFluids(Polyethylene.getFluid(L)).outputItems(GTMachines.HULL[0]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_lv")).duration(50).EUt(16).inputItems(GTBlocks.MACHINE_CASING_LV.asItem())
                .inputItems(cableGtSingle, Tin, 2).inputFluids(Polyethylene.getFluid(L))
                .outputItems(GTMachines.HULL[1]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_mv")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_MV.asItem()).inputItems(cableGtSingle, Copper, 2)
                .inputFluids(Polyethylene.getFluid(L)).outputItems(GTMachines.HULL[2]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_hv")).duration(50).EUt(16).inputItems(GTBlocks.MACHINE_CASING_HV.asItem())
                .inputItems(cableGtSingle, Gold, 2).inputFluids(PolyvinylChloride.getFluid(L))
                .outputItems(GTMachines.HULL[3]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_ev")).duration(50).EUt(16).inputItems(GTBlocks.MACHINE_CASING_EV.asItem())
                .inputItems(cableGtSingle, Aluminium, 2).inputFluids(PolyvinylChloride.getFluid(L))
                .outputItems(GTMachines.HULL[4]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_iv")).duration(50).EUt(16).inputItems(GTBlocks.MACHINE_CASING_IV.asItem())
                .inputItems(cableGtSingle, Platinum, 2).inputFluids(Polytetrafluoroethylene.getFluid(L))
                .outputItems(GTMachines.HULL[5]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_luv")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_LuV.asItem()).inputItems(cableGtSingle, NiobiumTitanium, 2)
                .inputFluids(Polytetrafluoroethylene.getFluid(L)).outputItems(GTMachines.HULL[6]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_zpm")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_ZPM.asItem()).inputItems(cableGtSingle, VanadiumGallium, 2)
                .inputFluids(Polybenzimidazole.getFluid(L)).outputItems(GTMachines.HULL[7]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_uv")).duration(50).EUt(16).inputItems(GTBlocks.MACHINE_CASING_UV.asItem())
                .inputItems(cableGtSingle, YttriumBariumCuprate, 2).inputFluids(Polybenzimidazole.getFluid(L))
                .outputItems(GTMachines.HULL[8]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_uhv")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_UHV.asItem())
                .inputItems(cableGtSingle, Europium, 2)
                .inputFluids(GTEMaterials.Polyetheretherketone.getFluid(L))
                .outputItems(GTMachines.HULL[9]).save();

        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_uev")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_UEV.asItem())
                .inputItems(cableGtSingle, GTEMaterials.Mithril, 2)
                .inputFluids(GTEMaterials.Polyetheretherketone.getFluid(L))
                .outputItems(GTMachines.HULL[10]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_uiv")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_UIV.asItem())
                .inputItems(cableGtSingle, Neutronium, 2)
                .inputFluids(GTEMaterials.Zylon.getFluid(L))
                .outputItems(GTMachines.HULL[11]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_uxv")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_UXV.asItem())
                .inputItems(cableGtSingle, GTEMaterials.Taranium, 2)
                .inputFluids(GTEMaterials.Zylon.getFluid(L))
                .outputItems(GTMachines.HULL[12]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_opv")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_OpV.asItem())
                .inputItems(cableGtSingle, GTEMaterials.CrystalMatrix, 2)
                .inputFluids(GTEMaterials.FullerenePolymerMatrixPulp.getFluid(L))
                .outputItems(GTMachines.HULL[13]).save();
        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("hull_max")).duration(50).EUt(16)
                .inputItems(GTBlocks.MACHINE_CASING_MAX.asItem())
                .inputItems(cableGtSingle, GTEMaterials.CosmicNeutronium, 2)
                .inputFluids(GTEMaterials.Radox.getFluid(L))
                .outputItems(GTMachines.HULL[14]).save();

        registerMachineRecipe(provider, ArrayUtils.subarray(GTMachines.TRANSFORMER, UHV, MAX),
                "WCC",
                "TH ", "WCC", 'W', POWER_COMPONENT, 'C', CABLE, 'T', CABLE_TIER_UP, 'H', HULL);
        registerMachineRecipe(provider,
                ArrayUtils.subarray(GTMachines.HI_AMP_TRANSFORMER_2A, UHV, MAX),
                "WCC", "TH ", "WCC",
                'W', POWER_COMPONENT, 'C', CABLE_DOUBLE, 'T', CABLE_TIER_UP_DOUBLE, 'H', HULL);
        registerMachineRecipe(provider,
                ArrayUtils.subarray(GTMachines.HI_AMP_TRANSFORMER_4A, UHV, MAX),
                "WCC", "TH ", "WCC",
                'W', POWER_COMPONENT, 'C', CABLE_QUAD, 'T', CABLE_TIER_UP_QUAD, 'H', HULL);
        registerMachineRecipe(provider, GTEMachines.DEHYDRATOR, "WCW", "AMA", "PRP", 'M', HULL, 'P', PLATE, 'C',
                CIRCUIT, 'W', WIRE_QUAD, 'R', ROBOT_ARM, 'A', CABLE_QUAD);
        registerMachineRecipe(provider, GTEMachines.ARC_GENERATOR, "WEW", "AMA", "WSW", 'M', HULL, 'E',
                EMITTER, 'W', WIRE_HEX, 'S', SENSOR, 'A', CABLE_TIER_UP);
        registerMachineRecipe(provider, GTEMachines.UNPACKER, "WCW", "VMR", "BCB", 'M', HULL, 'R', ROBOT_ARM, 'V',
                CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'B', Tags.Items.CHESTS_WOODEN);
        registerMachineRecipe(provider, GTEMachines.CLUSTER, "MMM", "CHC", "MMM", 'H', HULL, 'M', MOTOR, 'C', CIRCUIT);
        registerMachineRecipe(provider, GTEMachines.ROLLING, "EWE", "CMC", "PWP", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C',
                CIRCUIT, 'W', CABLE);
        registerMachineRecipe(provider, GTEMachines.LAMINATOR, "WPW", "CMC", "GGG", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W',
                CABLE, 'G', CONVEYOR);
        registerMachineRecipe(provider, GTEMachines.LOOM, "CWC", "EME", "EWE", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT,
                'W', CABLE);
        registerMachineRecipe(provider, GTEMachines.VACUUM_PUMP, "CLC", "LML", "PLP", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'L', PIPE_LARGE);
        registerMachineRecipe(provider, GTEMachines.LASER_WELDER, "WEW", "CMC", "PPP", 'M', HULL, 'P', PLATE, 'C', CIRCUIT, 'E', EMITTER, 'W', CABLE);
        registerMachineRecipe(provider, GTEMachines.WORLD_DATA_SCANNER, "CDC", "BAB", "CDC", 'A', HULL, 'B', CABLE, 'C', SENSOR, 'D', CIRCUIT);
        registerMachineRecipe(provider, GTEMachines.ACCELERATE_HATCH, "CFC", "FAF", "CFC", 'A', HULL, 'F', FIELD_GENERATOR, 'C', SENSOR);

        VanillaRecipeHelper.addShapedRecipe(provider, GTECore.id("lv_thermal_generator"), GTEMachines.THERMAL_GENERATOR[LV].asStack(), "ABA", "CDC", "EFE", 'B', GTItems.ELECTRIC_MOTOR_LV.asStack(), 'F', GTBlocks.FIREBOX_BRONZE.asStack(), 'D', GTMachines.HULL[LV].asStack(), 'C', CustomTags.LV_CIRCUITS, 'E', new MaterialEntry(TagPrefix.cableGtSingle, GTMaterials.Cobalt), 'A', new MaterialEntry(TagPrefix.plate, GTMaterials.Invar));
        VanillaRecipeHelper.addShapedRecipe(provider, GTECore.id("mv_thermal_generator"), GTEMachines.THERMAL_GENERATOR[MV].asStack(), "ABA", "CDC", "EFE", 'B', GTItems.ELECTRIC_MOTOR_MV.asStack(), 'F', GTBlocks.FIREBOX_STEEL.asStack(), 'D', GTMachines.HULL[MV].asStack(), 'C', CustomTags.MV_CIRCUITS, 'E', new MaterialEntry(TagPrefix.cableGtSingle, GTMaterials.AnnealedCopper), 'A', new MaterialEntry(TagPrefix.plate, GTEMaterials.DarkSteel));

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("thermal_generator"), GTEMachines.THERMAL_GENERATOR[0].asStack(),
                "PVP", "CMC", "WBW", 'M', GTMachines.HULL[0].asStack(), 'P', new MaterialEntry(plate, Steel), 'V',
                GTEItems.ULV_ELECTRIC_MOTOR.asStack(), 'C', CustomTags.ULV_CIRCUITS, 'W', new MaterialEntry(wireGtSingle, Lead), 'B', GTMachines.STEAM_SOLID_BOILER.first().getItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("ulv_wind_mill_turbine"), GTEMachines.WIND_MILL_TURBINE[0].asStack(),
                "RGR", "MHM", "WCW", 'H', GTEMachines.THERMAL_GENERATOR[0].asStack(), 'G', new MaterialEntry(gear, Bronze), 'R', new MaterialEntry(rod, WroughtIron),
                'C', CustomTags.ULV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, RedAlloy), 'M', new MaterialEntry(rod, IronMagnetic));

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("lv_wind_mill_turbine"), GTEMachines.WIND_MILL_TURBINE[1].asStack(),
                "RGR", "MHM", "WCW", 'H', GTMachines.HULL[1].asStack(), 'G', new MaterialEntry(gear, Steel), 'R', new MaterialEntry(rod, Invar),
                'C', CustomTags.LV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, Tin), 'M', GTItems.ELECTRIC_MOTOR_LV.asItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("mv_wind_mill_turbine"), GTEMachines.WIND_MILL_TURBINE[2].asStack(),
                "RGR", "MHM", "WCW", 'H', GTMachines.HULL[2].asStack(), 'G', new MaterialEntry(gear, Aluminium), 'R', new MaterialEntry(rod, VanadiumSteel),
                'C', CustomTags.MV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, Copper), 'M', GTItems.ELECTRIC_MOTOR_MV.asItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("hv_wind_mill_turbine"), GTEMachines.WIND_MILL_TURBINE[3].asStack(),
                "RGR", "MHM", "WCW", 'H', GTMachines.HULL[3].asStack(), 'G', new MaterialEntry(gear, StainlessSteel), 'R', new MaterialEntry(rod, BlackSteel),
                'C', CustomTags.HV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, Gold), 'M', GTItems.ELECTRIC_MOTOR_HV.asItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("ulv_loom"), GTEMachines.ULV_LOOM[0].asStack(),
                "CWC", "EME", "EWE", 'M', GTMachines.HULL[0].asStack(), 'E', GTEItems.ULV_ELECTRIC_MOTOR.asStack(), 'C', CustomTags.ULV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, RedAlloy));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("ulv_packer"), GTEMachines.ULV_PACKER[0].asStack(),
                "BCA", "RMV", "WCW", 'M', GTMachines.HULL[0].asStack(), 'R', GTItems.RESISTOR.asStack(), 'V', Tags.Items.CHESTS_WOODEN,
                'C', CustomTags.ULV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, RedAlloy), 'B', GTEItems.ULV_ROBOT_ARM.asStack(), 'A', GTEItems.ULV_CONVEYOR_MODULE.asItem());
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("ulv_unpacker"), GTEMachines.ULV_UNPACKER[0].asStack(),
                "WCW", "VMR", "ACB", 'M', GTMachines.HULL[0].asStack(), 'R', GTItems.RESISTOR.asStack(), 'V', Tags.Items.CHESTS_WOODEN,
                'C', CustomTags.ULV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, RedAlloy), 'B', GTEItems.ULV_ROBOT_ARM.asStack(), 'A', GTEItems.ULV_CONVEYOR_MODULE.asItem());
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("ulv_chemical_reactor"), GTEMachines.ULV_CHEMICAL_REACTOR[0].asStack(), "GRG", "WEW", "CMC", 'M', GTMachines.HULL[0].asStack(), 'R', new MaterialEntry(rotor, Tin), 'E',
                GTEItems.ULV_ELECTRIC_MOTOR.asStack(), 'C', CustomTags.ULV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, RedAlloy), 'G', Blocks.GLASS.asItem());
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("ulv_fluid_solidifier"), GTEMachines.ULV_FLUID_SOLIDIFIER[0].asStack(), "PGP", "WMW", "CBC", 'M', GTMachines.HULL[0].asStack(), 'P', GTEItems.ULV_ELECTRIC_PUMP.asStack(), 'C',
                CustomTags.ULV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, RedAlloy), 'G', Blocks.GLASS.asItem(), 'B', Tags.Items.CHESTS_WOODEN);
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("ulv_assembler"), GTEMachines.ULV_ASSEMBLER[0].asStack(), "ACA", "VMV", "WCW", 'M', GTMachines.HULL[0].asStack(), 'V', GTEItems.ULV_CONVEYOR_MODULE.asStack(), 'A',
                GTEItems.ULV_ROBOT_ARM.asStack(), 'C', CustomTags.ULV_CIRCUITS, 'W', new MaterialEntry(cableGtSingle, RedAlloy));

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("large_rolling"), MultiBlockB.LARGE_ROLLING.asStack(),
                "PKP", "BZB", "FKH", 'Z', CustomTags.IV_CIRCUITS, 'B', GTItems.ELECTRIC_MOTOR_IV.asStack(), 'P',
                GTItems.ELECTRIC_PISTON_IV.asStack(), 'H', GTEMachines.ROLLING[IV].asStack(),
                'F', GTEMachines.CLUSTER[IV].asStack(), 'K', new MaterialEntry(cableGtSingle, Platinum));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("large_bender"), MultiBlockB.LARGE_BENDER.asStack(),
                "PKP", "BZB", "HKH", 'Z', CustomTags.IV_CIRCUITS, 'H', GTItems.ELECTRIC_MOTOR_IV.asStack(), 'P',
                GTItems.ELECTRIC_PISTON_IV.asStack(), 'B', GTMachines.BENDER[IV].asStack(), 'K', new MaterialEntry(cableGtSingle, Platinum));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("large_forming"), MultiBlockB.LARGE_FORMING.asStack(),
                "PKP", "GZG", "HKH", 'Z', CustomTags.IV_CIRCUITS, 'P', GTItems.ELECTRIC_PISTON_IV.asStack(),
                'G', GTMachines.FORMING_PRESS[IV].asStack(), 'H', GTMachines.FORGE_HAMMER[IV].asStack(), 'K', new MaterialEntry(cableGtSingle, Platinum));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("large_crusher"), MultiBlockC.LARGE_CRUSHER.asStack(),
                "PKP", "GZG", "HKH", 'Z', CustomTags.IV_CIRCUITS, 'P', GTItems.ELECTRIC_PISTON_IV.asStack(),
                'G', GTMachines.MACERATOR[IV].asStack(), 'H', GTMachines.FORGE_HAMMER[IV].asStack(), 'K', new MaterialEntry(cableGtSingle, Platinum));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("large_laminator"), MultiBlockC.LARGE_LAMINATOR.asStack(), "RKR", "CXC",
                "MKM", 'C', CustomTags.IV_CIRCUITS, 'R', GTItems.ELECTRIC_PUMP_IV.asStack(), 'M', GTItems.CONVEYOR_MODULE_IV.asStack(), 'X',
                GTEMachines.LAMINATOR[IV].asStack(), 'K', new MaterialEntry(cableGtSingle, Platinum));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("large_laser_welder"), MultiBlockC.LARGE_LASER_WELDER.asStack(), "ICI",
                "EXE", "PKP", 'C', CustomTags.IV_CIRCUITS, 'P', new MaterialEntry(plateDouble, TantalumCarbide), 'I',
                GTItems.EMITTER_IV.asStack(), 'E', GTItems.CONVEYOR_MODULE_IV.asStack(), 'X', GTEMachines.LASER_WELDER[IV].asStack(), 'K',
                new MaterialEntry(cableGtSingle, Platinum));

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("generator_array"),
                GeneratorMultiblock.GENERATOR_ARRAY.asStack(),
                "ABA", "BCB", "ABA", 'A', new MaterialEntry(plate, Steel),
                'B', CustomTags.LV_CIRCUITS, 'C', GTItems.EMITTER_LV.asItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("hermetic_casing_uev"),
                GTEBlocks.HERMETIC_CASING_UEV.asStack(), "PPP", "PFP", "PPP", 'P',
                new MaterialEntry(plate, GTEMaterials.Quantanium), 'F',
                new MaterialEntry(pipeLargeFluid, Neutronium));

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("hermetic_casing_uiv"),
                GTEBlocks.HERMETIC_CASING_UIV.asStack(), "PPP", "PFP", "PPP", 'P',
                new MaterialEntry(plate, GTEMaterials.Adamantium), 'F',
                new MaterialEntry(pipeLargeFluid, Neutronium));

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("hermetic_casing_uxv"),
                GTEBlocks.HERMETIC_CASING_UXV.asStack(), "PPP", "PFP", "PPP", 'P',
                new MaterialEntry(plate, GTEMaterials.Vibranium), 'F',
                new MaterialEntry(pipeLargeFluid, GTEMaterials.Enderium));

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("hermetic_casing_opv"),
                GTEBlocks.HERMETIC_CASING_OpV.asStack(), "PPP", "PFP", "PPP", 'P',
                new MaterialEntry(plate, GTEMaterials.Draconium), 'F',
                new MaterialEntry(pipeLargeFluid,
                        GTEMaterials.HeavyQuarkDegenerateMatter));

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("quantum_tank_uev"),
                GTMachines.QUANTUM_TANK[UEV].asStack(),
                "CGC", "PHP", "CUC", 'C', CustomTags.UEV_CIRCUITS, 'P',
                new MaterialEntry(plate, GTEMaterials.Quantanium), 'U',
                GTItems.ELECTRIC_PUMP_UHV.asStack(),
                'G', GTItems.FIELD_GENERATOR_UV.asStack(), 'H',
                GTEBlocks.HERMETIC_CASING_UEV.asItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("quantum_tank_uiv"),
                GTMachines.QUANTUM_TANK[UIV].asStack(),
                "CGC", "PHP", "CUC", 'C', CustomTags.UIV_CIRCUITS, 'P',
                new MaterialEntry(plate, GTEMaterials.Adamantium), 'U',
                GTItems.ELECTRIC_PUMP_UEV.asStack(),
                'G', GTItems.FIELD_GENERATOR_UHV.asStack(), 'H',
                GTEBlocks.HERMETIC_CASING_UIV.asItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("quantum_tank_uxv"),
                GTMachines.QUANTUM_TANK[UXV].asStack(),
                "CGC", "PHP", "CUC", 'C', CustomTags.UXV_CIRCUITS, 'P',
                new MaterialEntry(plate, GTEMaterials.Vibranium), 'U',
                GTItems.ELECTRIC_PUMP_UIV.asStack(),
                'G', GTItems.FIELD_GENERATOR_UEV.asStack(), 'H',
                GTEBlocks.HERMETIC_CASING_UXV.asItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("quantum_tank_opv"),
                GTMachines.QUANTUM_TANK[OpV].asStack(),
                "CGC", "PHP", "CUC", 'C', CustomTags.OpV_CIRCUITS, 'P',
                new MaterialEntry(plate, GTEMaterials.Draconium), 'U',
                GTItems.ELECTRIC_PUMP_UXV.asStack(),
                'G', GTItems.FIELD_GENERATOR_UIV.asStack(), 'H',
                GTEBlocks.HERMETIC_CASING_OpV.asItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("quantum_chest_uev"),
                GTMachines.QUANTUM_CHEST[UEV].asStack(), "CPC", "PHP", "CFC", 'C',
                CustomTags.UEV_CIRCUITS, 'P',
                new MaterialEntry(plate, GTEMaterials.Quantanium), 'F',
                GTItems.FIELD_GENERATOR_UV.asStack(), 'H', GTMachines.HULL[10].getItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("quantum_chest_uiv"),
                GTMachines.QUANTUM_CHEST[UIV].asStack(), "CPC", "PHP", "CFC", 'C',
                CustomTags.UIV_CIRCUITS, 'P',
                new MaterialEntry(plate, GTEMaterials.Adamantium), 'F',
                GTItems.FIELD_GENERATOR_UHV.asStack(), 'H', GTMachines.HULL[11].getItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("quantum_chest_uxv"),
                GTMachines.QUANTUM_CHEST[UXV].asStack(), "CPC", "PHP", "CFC", 'C',
                CustomTags.UXV_CIRCUITS, 'P',
                new MaterialEntry(plate, GTEMaterials.Vibranium), 'F',
                GTItems.FIELD_GENERATOR_UEV.asStack(), 'H', GTMachines.HULL[12].getItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("quantum_chest_opv"),
                GTMachines.QUANTUM_CHEST[OpV].asStack(), "CPC", "PHP", "CFC", 'C',
                CustomTags.OpV_CIRCUITS, 'P',
                new MaterialEntry(plate, GTEMaterials.Draconium), 'F',
                GTItems.FIELD_GENERATOR_UIV.asStack(), 'H', GTMachines.HULL[13].getItem());

        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("large_block_conversion_room"),
                MultiBlockD.LARGE_BLOCK_CONVERSION_ROOM.asStack(), "SES", "EHE", "SES",
                'S', GTItems.SENSOR_UHV.asStack(), 'E', GTItems.EMITTER_UHV.asStack(), 'H',
                MultiBlockD.BLOCK_CONVERSION_ROOM.getItem());

        VanillaRecipeHelper.addShapedRecipe(provider, GTECore.id("hp_steam_vacuum_pump"), GTEMachines.STEAM_VACUUM_PUMP.right().asStack(), "ABA", "CDC", "ECE", 'B', new MaterialEntry(TagPrefix.pipeHugeFluid, GTMaterials.TinAlloy), 'D', GTEMachines.STEAM_VACUUM_PUMP.first().asStack(), 'C', new MaterialEntry(TagPrefix.pipeLargeFluid, GTMaterials.TinAlloy), 'E', new MaterialEntry(TagPrefix.plate, GTMaterials.WroughtIron), 'A', GTMachines.STEEL_DRUM.getItem());
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("steam_vacuum_pump"), GTEMachines.STEAM_VACUUM_PUMP.first().asStack(), "DSD",
                "SMS", "GSG", 'M', GTBlocks.BRONZE_BRICKS_HULL.asStack(), 'S', new MaterialEntry(pipeNormalFluid, Bronze), 'D', GTMachines.BRONZE_DRUM.asStack(), 'G', new MaterialEntry(gearSmall, Bronze));
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("steam_alloy_smelter_bronze"), GTMachines.STEAM_ALLOY_SMELTER.left().asStack(),
                "XXX", "FMF", "XXX", 'M', GTBlocks.BRONZE_BRICKS_HULL.asStack(), 'X', new MaterialEntry(TagPrefix.pipeSmallFluid, GTMaterials.Bronze), 'F', MachineBlocks.PRIMITIVE_ALLOY_SMELTER.asItem());

        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("infinity_fluid_drilling_rig"))
                .inputItems(GTMachines.HULL[UV])
                .inputItems(frameGt, Ruridit, 4)
                .inputItems(CustomTags.UV_CIRCUITS, 4)
                .inputItems(GTItems.ELECTRIC_MOTOR_UV, 4)
                .inputItems(GTItems.ELECTRIC_PUMP_UV, 4)
                .inputItems(gear, Neutronium, 4)
                .circuitMeta(2)
                .outputItems(MultiBlockD.INFINITY_FLUID_DRILLING_RIG)
                .duration(400).EUt(VA[UV]).save();

        ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("wood_distillation"))
                .inputItems(MultiBlockA.LARGE_PYROLYSE_OVEN.asStack(), 16)
                .inputItems(GCYMMachines.LARGE_DISTILLERY.asStack(), 16)
                .inputItems(CustomTags.ZPM_CIRCUITS, 64)
                .inputItems(GTItems.EMITTER_LuV.asStack(), 32)
                .inputItems(pipeHugeFluid, StainlessSteel, 64)
                .inputItems(GTItems.ELECTRIC_PUMP_IV.asStack(), 32)
                .inputItems(plate, WatertightSteel, 64)
                .inputItems(plateDouble, StainlessSteel, 64)
                .inputFluids(SolderingAlloy.getFluid(5184))
                .outputItems(MultiBlockB.WOOD_DISTILLATION)
                .duration(800).EUt(VA[ZPM])
                .save();
    }
}
