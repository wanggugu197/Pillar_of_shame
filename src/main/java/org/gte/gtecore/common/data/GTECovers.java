package org.gte.gtecore.common.data;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.cover.*;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.client.renderer.cover.*;
import com.gregtechceu.gtceu.common.cover.ConveyorCover;
import com.gregtechceu.gtceu.common.cover.PumpCover;
import com.gregtechceu.gtceu.common.cover.RobotArmCover;
import com.gregtechceu.gtceu.common.data.GTCovers;

import com.hepdd.gtmthings.GTMThings;
import com.hepdd.gtmthings.common.cover.WirelessEnergyReceiveCover;

import java.util.Locale;

public interface GTECovers {

    ICoverRenderer POWER_AMPLIFIER = new SimpleCoverRenderer(GTECore.id("gui/overclock_config"));

    CoverDefinition[] POWER_AMPLIFIERS = GTCovers.registerTiered("power_amplifier", PowerAmplifierCover::new, tier -> POWER_AMPLIFIER, GTValues.tiersBetween(GTValues.LV, GTValues.EV));

    CoverDefinition AIR_VENT = GTCovers.register("air_vent", AirVentCover::new, new SimpleCoverRenderer(GTECore.id("block/machines/vacuum_pump/overlay_top")));

    CoverDefinition STEAM_PUMP = GTCovers.register("steam_pump", SteamPumpCover::new, PumpCoverRenderer.INSTANCE);

    CoverDefinition ELECTRIC_PUMP_ULV = GTCovers.register(
            "pump.ulv", ULVPumpCover::new, PumpCoverRenderer.INSTANCE);

    CoverDefinition FLUID_REGULATOR_ULV = GTCovers.register(
            "fluid_regulator.ulv", FluidRegulatorCover::new, PumpCoverRenderer.INSTANCE);

    CoverDefinition CONVEYOR_MODULE_ULV = GTCovers.register(
            "conveyor.ulv",
            (def, coverable, side) -> new ConveyorCover(def, coverable, side, GTValues.ULV),
            ConveyorCoverRenderer.INSTANCE);

    CoverDefinition ROBOT_ARM_ULV = GTCovers.register(
            "robot_arm.ulv",
            (def, coverable, side) -> new RobotArmCover(def, coverable, side, GTValues.ULV),
            RobotArmCoverRenderer.INSTANCE);

    CoverDefinition ELECTRIC_PUMP_MAX = GTCovers.register(
            "pump.max",
            (def, coverable, side) -> new PumpCover(def, coverable, side, GTValues.MAX),
            PumpCoverRenderer.INSTANCE);

    CoverDefinition CONVEYOR_MODULE_MAX = GTCovers.register(
            "conveyor.max",
            (def, coverable, side) -> new ConveyorCover(def, coverable, side, GTValues.MAX),
            ConveyorCoverRenderer.INSTANCE);

    CoverDefinition ROBOT_ARM_MAX = GTCovers.register(
            "robot_arm.max",
            (def, coverable, side) -> new RobotArmCover(def, coverable, side, GTValues.MAX),
            RobotArmCoverRenderer.INSTANCE);

    CoverDefinition MAX_WIRELESS_ENERGY_RECEIVE = registerTieredWirelessCover(
            "wireless_energy_receive", 1);

    CoverDefinition MAX_WIRELESS_ENERGY_RECEIVE_4A = registerTieredWirelessCover(
            "4a_wireless_energy_receive", 4);

    private static CoverDefinition registerTieredWirelessCover(String id, int amperage) {
        String name = id + "." + GTValues.VN[GTValues.MAX].toLowerCase(Locale.ROOT);
        return GTCovers.register(name, (holder, coverable, side) -> new WirelessEnergyReceiveCover(holder, coverable, side, GTValues.MAX, amperage),
                new SimpleCoverRenderer(GTMThings.id("block/cover/overlay_" + (amperage == 1 ? "" : "4a_") + "wireless_energy_receive")));
    }

    static void init() {}
}
