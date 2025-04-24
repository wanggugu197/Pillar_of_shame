package org.gte.gtecore.mixin.gtmt;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;

import com.hepdd.gtmthings.data.CustomMachines;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.BiFunction;

@Mixin(CustomMachines.class)
public class CustomMachinesMixin {

    @Inject(method = "registerTieredMachines", at = @At("HEAD"), remap = false, cancellable = true)
    private static void registerTieredMachines(String name, BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory, BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder, int[] tiers, CallbackInfoReturnable<MachineDefinition[]> cir) {
        switch (name) {
            case "programmablec_hatch", "huge_item_import_bus", "huge_item_export_bus", "huge_dual_hatch":
                cir.setReturnValue(new MachineDefinition[0]);
                break;
        }
    }
}
