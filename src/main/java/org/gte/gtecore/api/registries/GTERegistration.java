package org.gte.gtecore.api.registries;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.blockentity.ManaMachineBlockEntity;

import com.gregtechceu.gtceu.api.block.MetaMachineBlock;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.item.MetaMachineItem;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class GTERegistration extends GTRegistrate {

    public static final GTERegistration REGISTRATE = new GTERegistration();

    static {
        REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }

    private GTERegistration() {
        super(GTECore.MOD_ID);
    }

    public GTEMachineBuilder manaMachine(String name, Function<IMachineBlockEntity, MetaMachine> metaMachine) {
        return new GTEMachineBuilder(this, name, MachineDefinition::createDefinition, metaMachine, MetaMachineBlock::new, MetaMachineItem::new, ManaMachineBlockEntity::createBlockEntity);
    }

    @Override
    public @NotNull GTEMachineBuilder machine(@NotNull String name, @NotNull Function<IMachineBlockEntity, MetaMachine> metaMachine) {
        return new GTEMachineBuilder(this, name, MachineDefinition::createDefinition, metaMachine, MetaMachineBlock::new, MetaMachineItem::new, MetaMachineBlockEntity::createBlockEntity);
    }

    @Override
    public @NotNull MultiblockBuilder multiblock(@NotNull String name, @NotNull Function<IMachineBlockEntity, ? extends MultiblockControllerMachine> metaMachine) {
        return new MultiblockBuilder(this, name, metaMachine, MetaMachineBlock::new, MetaMachineItem::new, MetaMachineBlockEntity::createBlockEntity);
    }
}
