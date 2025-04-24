package org.gte.gtecore.mixin.gtm.registry;

import org.gte.gtecore.common.block.BlockMap;
import org.gte.gtecore.common.data.*;
import org.gte.gtecore.common.data.machines.GCYMMachines;
import org.gte.gtecore.common.data.machines.GTMachineModify;

import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.machines.*;

import com.hepdd.gtmthings.data.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;

@Mixin(GTMachines.class)
public final class GTMachinesMixin {

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public static void init() {
        REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_MACHINE);
        BlockMap.init();
        GTMultiMachines.init();
        GTResearchMachines.init();
        GTAEMachines.init();
        GTMachineModify.init();
        GCYMMachines.init();
        CreativeModeTabs.init();
        CreativeMachines.init();
        WirelessMachines.init();
        CustomMachines.init();
        GTEMachines.init();
        GTRegistries.MACHINES.freeze();
    }
}
