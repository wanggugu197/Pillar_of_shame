package org.gte.gtecore.data;

import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.MAX;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.*;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.FRAME;

public class CraftingComponents {

    public static CraftingComponent BUFFER;
    public static CraftingComponent FLUID_REGULATOR;

    public static void init() {
        PUMP.add(14, GTEItems.MAX_ELECTRIC_PUMP.asStack());

        CONVEYOR.add(14, GTEItems.MAX_CONVEYOR_MODULE.asStack());

        MOTOR.add(14, GTEItems.MAX_ELECTRIC_MOTOR.asStack());

        PISTON.add(14, GTEItems.MAX_ELECTRIC_PISTON.asStack());

        EMITTER.add(14, GTEItems.MAX_EMITTER.asStack());

        SENSOR.add(14, GTEItems.MAX_SENSOR.asStack());

        FIELD_GENERATOR.add(14, GTEItems.MAX_FIELD_GENERATOR.asStack());

        ROBOT_ARM.add(14, GTEItems.MAX_ROBOT_ARM.asStack());

        GRINDER.add(5, GTItems.COMPONENT_GRINDER_DIAMOND.asStack())
                .add(6, GTItems.COMPONENT_GRINDER_DIAMOND.asStack())
                .add(7, GTItems.COMPONENT_GRINDER_TUNGSTEN.asStack())
                .add(8, GTItems.COMPONENT_GRINDER_TUNGSTEN.asStack())
                .add(9, GTItems.COMPONENT_GRINDER_TUNGSTEN.asStack())
                .add(10, GTItems.COMPONENT_GRINDER_TUNGSTEN.asStack())
                .add(11, GTItems.COMPONENT_GRINDER_TUNGSTEN.asStack())
                .add(12, GTEItems.BEDROCK_DRILL.asStack())
                .add(13, GTEItems.BEDROCK_DRILL.asStack());

        SAWBLADE.add(3, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.VanadiumSteel))
                .add(4, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.TungstenSteel))
                .add(5, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.TungstenSteel))
                .add(6, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.HSSE))
                .add(7, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.HSSE))
                .add(8, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.NaquadahAlloy))
                .add(9, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.NaquadahAlloy))
                .add(10, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.Duranium))
                .add(11, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.Duranium))
                .add(12, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.Neutronium))
                .add(13, new MaterialEntry(TagPrefix.toolHeadBuzzSaw, GTMaterials.Neutronium));

        WIRE_ELECTRIC.add(10, new MaterialEntry(TagPrefix.wireGtSingle, GTMaterials.Mendelevium))
                .add(11, new MaterialEntry(TagPrefix.wireGtSingle, GTMaterials.Mendelevium))
                .add(12, new MaterialEntry(TagPrefix.wireGtSingle, GTMaterials.Mendelevium))
                .add(13, new MaterialEntry(TagPrefix.wireGtSingle, GTEMaterials.Uruium))
                .add(14, new MaterialEntry(TagPrefix.wireGtSingle, GTEMaterials.Uruium));

        WIRE_QUAD.add(10, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.wireGtQuadruple, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.CosmicNeutronium));

        WIRE_OCT.add(10, new MaterialEntry(TagPrefix.wireGtOctal, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.wireGtOctal, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.wireGtOctal, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.wireGtOctal, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.wireGtOctal, GTEMaterials.CosmicNeutronium));

        WIRE_HEX.add(10, new MaterialEntry(TagPrefix.wireGtHex, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.wireGtHex, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.wireGtHex, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.wireGtHex, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.wireGtHex, GTEMaterials.CosmicNeutronium));

        CABLE.add(10, new MaterialEntry(TagPrefix.cableGtSingle, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.cableGtSingle, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.cableGtSingle, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.cableGtSingle, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium));

        CABLE_DOUBLE.add(10, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.cableGtDouble, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.CosmicNeutronium));

        CABLE_QUAD.add(10, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.cableGtDouble, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.CosmicNeutronium));

        WIRE_ELECTRIC.add(10, new MaterialEntry(TagPrefix.cableGtQuadruple, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.cableGtQuadruple, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.cableGtQuadruple, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.cableGtQuadruple, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.cableGtQuadruple, GTEMaterials.CosmicNeutronium));

        CABLE_OCT.add(10, new MaterialEntry(TagPrefix.cableGtOctal, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.cableGtOctal, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.cableGtOctal, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.cableGtOctal, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.cableGtOctal, GTEMaterials.CosmicNeutronium));

        CABLE_HEX.add(10, new MaterialEntry(TagPrefix.cableGtHex, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.cableGtHex, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.cableGtHex, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.cableGtHex, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.cableGtHex, GTEMaterials.CosmicNeutronium));

        CABLE_TIER_UP.add(9, new MaterialEntry(TagPrefix.cableGtSingle, GTEMaterials.Mithril))
                .add(10, new MaterialEntry(TagPrefix.cableGtSingle, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.cableGtSingle, GTEMaterials.Taranium))
                .add(12, new MaterialEntry(TagPrefix.cableGtSingle, GTEMaterials.CrystalMatrix))
                .add(13, new MaterialEntry(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium))
                .add(14, new MaterialEntry(TagPrefix.wireGtSingle, GTEMaterials.SpaceTime));

        CABLE_TIER_UP_DOUBLE.add(9, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.Mithril))
                .add(10, new MaterialEntry(TagPrefix.cableGtDouble, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.Taranium))
                .add(12, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.CrystalMatrix))
                .add(13, new MaterialEntry(TagPrefix.cableGtDouble, GTEMaterials.CosmicNeutronium))
                .add(14, new MaterialEntry(TagPrefix.wireGtDouble, GTEMaterials.SpaceTime));

        CABLE_TIER_UP_QUAD.add(9, new MaterialEntry(TagPrefix.cableGtQuadruple, GTEMaterials.Mithril))
                .add(10, new MaterialEntry(TagPrefix.cableGtQuadruple, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.cableGtQuadruple, GTEMaterials.Taranium))
                .add(12, new MaterialEntry(TagPrefix.cableGtQuadruple, GTEMaterials.CrystalMatrix))
                .add(13, new MaterialEntry(TagPrefix.cableGtQuadruple, GTEMaterials.CosmicNeutronium))
                .add(14, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.SpaceTime));

        CABLE_TIER_UP_OCT.add(9, new MaterialEntry(TagPrefix.cableGtOctal, GTEMaterials.Mithril))
                .add(10, new MaterialEntry(TagPrefix.cableGtOctal, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.cableGtOctal, GTEMaterials.Taranium))
                .add(12, new MaterialEntry(TagPrefix.cableGtOctal, GTEMaterials.CrystalMatrix))
                .add(13, new MaterialEntry(TagPrefix.cableGtOctal, GTEMaterials.CosmicNeutronium))
                .add(14, new MaterialEntry(TagPrefix.wireGtOctal, GTEMaterials.SpaceTime));

        CABLE_TIER_UP_HEX.add(9, new MaterialEntry(TagPrefix.cableGtHex, GTEMaterials.Mithril))
                .add(10, new MaterialEntry(TagPrefix.cableGtHex, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.cableGtHex, GTEMaterials.Taranium))
                .add(12, new MaterialEntry(TagPrefix.cableGtHex, GTEMaterials.CrystalMatrix))
                .add(13, new MaterialEntry(TagPrefix.cableGtHex, GTEMaterials.CosmicNeutronium))
                .add(14, new MaterialEntry(TagPrefix.wireGtHex, GTEMaterials.SpaceTime));

        PIPE_NORMAL.add(9, new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.Neutronium))
                .add(10, new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.pipeNormalFluid, GTEMaterials.Enderium))
                .add(12, new MaterialEntry(TagPrefix.pipeNormalFluid, GTEMaterials.Enderium))
                .add(13, new MaterialEntry(TagPrefix.pipeNormalFluid,
                        GTEMaterials.HeavyQuarkDegenerateMatter))
                .add(14, new MaterialEntry(TagPrefix.pipeNormalFluid,
                        GTEMaterials.HeavyQuarkDegenerateMatter));

        PIPE_LARGE.add(7, new MaterialEntry(TagPrefix.pipeLargeFluid, GTMaterials.Iridium))
                .add(9, new MaterialEntry(TagPrefix.pipeLargeFluid, GTMaterials.Neutronium))
                .add(10, new MaterialEntry(TagPrefix.pipeLargeFluid, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.pipeLargeFluid, GTEMaterials.Enderium))
                .add(12, new MaterialEntry(TagPrefix.pipeLargeFluid, GTEMaterials.Enderium))
                .add(13, new MaterialEntry(TagPrefix.pipeLargeFluid,
                        GTEMaterials.HeavyQuarkDegenerateMatter))
                .add(14, new MaterialEntry(TagPrefix.pipeLargeFluid,
                        GTEMaterials.HeavyQuarkDegenerateMatter));

        PIPE_NONUPLE.add(0, new MaterialEntry(TagPrefix.pipeNonupleFluid, GTMaterials.Bronze))
                .add(1, new MaterialEntry(TagPrefix.pipeNonupleFluid, GTMaterials.Bronze))
                .add(2, new MaterialEntry(TagPrefix.pipeNonupleFluid, GTMaterials.Steel))
                .add(3, new MaterialEntry(TagPrefix.pipeNonupleFluid, GTMaterials.StainlessSteel))
                .add(9, new MaterialEntry(TagPrefix.pipeNonupleFluid, GTMaterials.Neutronium))
                .add(10, new MaterialEntry(TagPrefix.pipeNonupleFluid, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.pipeNonupleFluid, GTEMaterials.Enderium))
                .add(12, new MaterialEntry(TagPrefix.pipeNonupleFluid, GTEMaterials.Enderium))
                .add(13, new MaterialEntry(TagPrefix.pipeNonupleFluid,
                        GTEMaterials.HeavyQuarkDegenerateMatter))
                .add(14, new MaterialEntry(TagPrefix.pipeNonupleFluid,
                        GTEMaterials.HeavyQuarkDegenerateMatter));

        GLASS.add(UHV, GTBlocks.FUSION_GLASS.asStack())
                .add(UEV, GTBlocks.FUSION_GLASS.asStack())
                .add(UIV, GTEBlocks.FORCE_FIELD_GLASS.asStack())
                .add(UXV, GTEBlocks.FORCE_FIELD_GLASS.asStack())
                .add(OpV, GTEBlocks.FORCE_FIELD_GLASS.asStack())
                .add(MAX, GTEBlocks.FORCE_FIELD_GLASS.asStack());

        PLATE.add(10, new MaterialEntry(TagPrefix.plate, GTEMaterials.Quantanium))
                .add(11, new MaterialEntry(TagPrefix.plate, GTEMaterials.Adamantium))
                .add(12, new MaterialEntry(TagPrefix.plate, GTEMaterials.Vibranium))
                .add(13, new MaterialEntry(TagPrefix.plate, GTEMaterials.Draconium))
                .add(14, new MaterialEntry(TagPrefix.plate, GTEMaterials.Chaos));

        HULL_PLATE.add(0, new MaterialEntry(TagPrefix.plate, GTMaterials.WroughtIron))
                .add(1, new MaterialEntry(TagPrefix.plate, GTMaterials.Polyethylene))
                .add(2, new MaterialEntry(TagPrefix.plate, GTMaterials.Polyethylene))
                .add(3, new MaterialEntry(TagPrefix.plate, GTMaterials.PolyvinylChloride))
                .add(4, new MaterialEntry(TagPrefix.plate, GTMaterials.PolyvinylChloride))
                .add(5, new MaterialEntry(TagPrefix.plate, GTMaterials.Polytetrafluoroethylene))
                .add(6, new MaterialEntry(TagPrefix.plate, GTMaterials.Polytetrafluoroethylene))
                .add(7, new MaterialEntry(TagPrefix.plate, GTMaterials.Polybenzimidazole))
                .add(8, new MaterialEntry(TagPrefix.plate, GTMaterials.Polybenzimidazole))
                .add(9, new MaterialEntry(TagPrefix.plate, GTEMaterials.Polyetheretherketone))
                .add(10, new MaterialEntry(TagPrefix.plate, GTEMaterials.Polyetheretherketone))
                .add(11, new MaterialEntry(TagPrefix.plate, GTEMaterials.Zylon))
                .add(12, new MaterialEntry(TagPrefix.plate, GTEMaterials.Zylon))
                .add(13, new MaterialEntry(TagPrefix.plate, GTEMaterials.FullerenePolymerMatrixPulp))
                .add(14, new MaterialEntry(TagPrefix.plate, GTEMaterials.Radox));

        ROTOR.add(9, new MaterialEntry(TagPrefix.rotor, GTMaterials.Neutronium))
                .add(10, new MaterialEntry(TagPrefix.rotor, GTEMaterials.Quantanium))
                .add(11, new MaterialEntry(TagPrefix.rotor, GTEMaterials.Adamantium))
                .add(12, new MaterialEntry(TagPrefix.rotor, GTEMaterials.Vibranium))
                .add(13, new MaterialEntry(TagPrefix.rotor, GTEMaterials.Draconium))
                .add(14, new MaterialEntry(TagPrefix.rotor, GTEMaterials.TranscendentMetal));

        COIL_HEATING.add(9, new MaterialEntry(TagPrefix.wireGtDouble, GTEMaterials.AbyssalAlloy))
                .add(10, new MaterialEntry(TagPrefix.wireGtDouble, GTEMaterials.TitanSteel))
                .add(11, new MaterialEntry(TagPrefix.wireGtDouble, GTEMaterials.Adamantine))
                .add(12, new MaterialEntry(TagPrefix.wireGtDouble,
                        GTEMaterials.NaquadriaticTaranium))
                .add(13, new MaterialEntry(TagPrefix.wireGtDouble, GTEMaterials.Starmetal))
                .add(14, new MaterialEntry(TagPrefix.wireGtDouble, GTEMaterials.Hypogen));

        COIL_HEATING_DOUBLE.add(9, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.AbyssalAlloy))
                .add(10, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.TitanSteel))
                .add(11, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.Adamantine))
                .add(12, new MaterialEntry(TagPrefix.wireGtQuadruple,
                        GTEMaterials.NaquadriaticTaranium))
                .add(13, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.Starmetal))
                .add(14, new MaterialEntry(TagPrefix.wireGtQuadruple, GTEMaterials.Hypogen));

        COIL_ELECTRIC.add(9, new MaterialEntry(TagPrefix.wireGtOctal, GTEMaterials.Mithril))
                .add(10, new MaterialEntry(TagPrefix.wireGtOctal, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.wireGtHex, GTEMaterials.Mithril))
                .add(12, new MaterialEntry(TagPrefix.wireGtHex, GTEMaterials.Mithril))
                .add(13, new MaterialEntry(TagPrefix.wireGtOctal, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.wireGtHex, GTEMaterials.CrystalMatrix));

        ROD_DISTILLATION.add(9, new MaterialEntry(TagPrefix.spring, GTMaterials.Europium))
                .add(10, new MaterialEntry(TagPrefix.spring, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.spring, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.spring, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.spring, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.spring, GTEMaterials.CosmicNeutronium));

        ROD_ELECTROMAGNETIC.add(5, new MaterialEntry(TagPrefix.rod, GTMaterials.VanadiumGallium))
                .add(6, new MaterialEntry(TagPrefix.rod, GTMaterials.VanadiumGallium))
                .add(7, new MaterialEntry(TagPrefix.rod, GTMaterials.NiobiumTitanium))
                .add(8, new MaterialEntry(TagPrefix.rod, GTMaterials.NiobiumTitanium))
                .add(9, new MaterialEntry(TagPrefix.rod, GTEMaterials.EnergeticNetherite))
                .add(10, new MaterialEntry(TagPrefix.rod, GTEMaterials.EnergeticNetherite))
                .add(11, new MaterialEntry(TagPrefix.rod, GTEMaterials.Mithril))
                .add(12, new MaterialEntry(TagPrefix.rod, GTEMaterials.Mithril))
                .add(13, new MaterialEntry(TagPrefix.rod, GTEMaterials.Echoite))
                .add(14, new MaterialEntry(TagPrefix.rod, GTEMaterials.Echoite));

        PIPE_REACTOR.add(9, new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.Polybenzimidazole))
                .add(10, new MaterialEntry(TagPrefix.pipeLargeFluid, GTMaterials.Polybenzimidazole))
                .add(11, new MaterialEntry(TagPrefix.pipeHugeFluid, GTMaterials.Polybenzimidazole))
                .add(12, new MaterialEntry(TagPrefix.pipeNormalFluid,
                        GTEMaterials.FullerenePolymerMatrixPulp))
                .add(13, new MaterialEntry(TagPrefix.pipeLargeFluid,
                        GTEMaterials.FullerenePolymerMatrixPulp))
                .add(14, new MaterialEntry(TagPrefix.pipeHugeFluid,
                        GTEMaterials.FullerenePolymerMatrixPulp));

        POWER_COMPONENT.add(10, GTEItems.NM_CHIP.asStack())
                .add(11, GTEItems.PM_CHIP.asStack())
                .add(12, GTEItems.PM_CHIP.asStack())
                .add(13, GTEItems.FM_CHIP.asStack())
                .add(14, GTEItems.FM_CHIP.asStack());

        VOLTAGE_COIL.add(9, GTEItems.UHV_VOLTAGE_COIL.asStack())
                .add(10, GTEItems.UEV_VOLTAGE_COIL.asStack())
                .add(11, GTEItems.UIV_VOLTAGE_COIL.asStack())
                .add(12, GTEItems.UXV_VOLTAGE_COIL.asStack())
                .add(13, GTEItems.OPV_VOLTAGE_COIL.asStack())
                .add(14, GTEItems.MAX_VOLTAGE_COIL.asStack());

        SPRING.add(10, new MaterialEntry(TagPrefix.spring, GTEMaterials.Mithril))
                .add(11, new MaterialEntry(TagPrefix.spring, GTMaterials.Neutronium))
                .add(12, new MaterialEntry(TagPrefix.spring, GTEMaterials.Taranium))
                .add(13, new MaterialEntry(TagPrefix.spring, GTEMaterials.CrystalMatrix))
                .add(14, new MaterialEntry(TagPrefix.spring, GTEMaterials.CosmicNeutronium));

        CRATE.add(9, GTMachines.SUPER_CHEST[2].asStack())
                .add(10, GTMachines.SUPER_CHEST[3].asStack())
                .add(11, GTMachines.SUPER_CHEST[4].asStack())
                .add(12, GTMachines.QUANTUM_CHEST[5].asStack())
                .add(13, GTMachines.QUANTUM_CHEST[6].asStack())
                .add(14, GTMachines.QUANTUM_CHEST[7].asStack());

        DRUM.add(9, GTMachines.SUPER_TANK[2].asStack())
                .add(10, GTMachines.SUPER_TANK[3].asStack())
                .add(11, GTMachines.SUPER_TANK[4].asStack())
                .add(12, GTMachines.QUANTUM_TANK[5].asStack())
                .add(13, GTMachines.QUANTUM_TANK[6].asStack())
                .add(14, GTMachines.QUANTUM_TANK[7].asStack());

        FRAME.add(9, new MaterialEntry(TagPrefix.frameGt, GTMaterials.Tritanium))
                .add(10, new MaterialEntry(TagPrefix.frameGt, GTMaterials.Neutronium))
                .add(11, new MaterialEntry(TagPrefix.frameGt, GTEMaterials.Quantanium))
                .add(12, new MaterialEntry(TagPrefix.frameGt, GTEMaterials.Adamantium))
                .add(13, new MaterialEntry(TagPrefix.frameGt, GTEMaterials.Draconium))
                .add(14, new MaterialEntry(TagPrefix.frameGt, GTEMaterials.Infinity));

        BUFFER = CraftingComponent.of("buffer", GTMachines.BUFFER[1].asStack())
                .add(1, GTMachines.BUFFER[1].asStack())
                .add(2, GTMachines.BUFFER[2].asStack())
                .add(3, GTMachines.BUFFER[3].asStack())
                .add(4, GTMachines.BUFFER[4].asStack())
                .add(5, GTMachines.BUFFER[5].asStack())
                .add(6, GTMachines.BUFFER[6].asStack())
                .add(7, GTMachines.BUFFER[7].asStack())
                .add(8, GTMachines.BUFFER[8].asStack())
                .add(9, GTMachines.BUFFER[9].asStack())
                .add(10, GTMachines.BUFFER[10].asStack())
                .add(11, GTMachines.BUFFER[11].asStack())
                .add(12, GTMachines.BUFFER[12].asStack())
                .add(13, GTMachines.BUFFER[13].asStack())
                .add(14, GTMachines.BUFFER[14].asStack());

        FLUID_REGULATOR = CraftingComponent.of("fluid_regulator", GTItems.FLUID_REGULATOR_LV.asStack())
                .add(1, GTItems.FLUID_REGULATOR_LV.asStack())
                .add(2, GTItems.FLUID_REGULATOR_MV.asStack())
                .add(3, GTItems.FLUID_REGULATOR_HV.asStack())
                .add(4, GTItems.FLUID_REGULATOR_EV.asStack())
                .add(5, GTItems.FLUID_REGULATOR_IV.asStack())
                .add(6, GTItems.FLUID_REGULATOR_LuV.asStack())
                .add(7, GTItems.FLUID_REGULATOR_ZPM.asStack())
                .add(8, GTItems.FLUID_REGULATOR_UV.asStack())
                .add(9, GTItems.FLUID_REGULATOR_UHV.asStack())
                .add(10, GTItems.FLUID_REGULATOR_UEV.asStack())
                .add(11, GTItems.FLUID_REGULATOR_UIV.asStack())
                .add(12, GTItems.FLUID_REGULATOR_UXV.asStack())
                .add(13, GTItems.FLUID_REGULATOR_OpV.asStack());
    }
}
