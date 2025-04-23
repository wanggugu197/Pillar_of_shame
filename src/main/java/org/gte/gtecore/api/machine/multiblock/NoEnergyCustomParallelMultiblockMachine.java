package org.gte.gtecore.api.machine.multiblock;

import org.gte.gtecore.api.machine.feature.multiblock.IParallelMachine;
import org.gte.gtecore.api.machine.trait.CustomParallelTrait;
import org.gte.gtecore.api.recipe.ParallelConfigurator;

import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class NoEnergyCustomParallelMultiblockMachine extends NoEnergyMultiblockMachine implements IParallelMachine {

    public static Function<IMachineBlockEntity, NoEnergyCustomParallelMultiblockMachine> createParallel(ToIntFunction<NoEnergyCustomParallelMultiblockMachine> parallel, boolean defaultParallel) {
        return holder -> new NoEnergyCustomParallelMultiblockMachine(holder, defaultParallel, parallel);
    }

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            NoEnergyCustomParallelMultiblockMachine.class, NoEnergyMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Persisted
    private final CustomParallelTrait customParallelTrait;

    protected NoEnergyCustomParallelMultiblockMachine(IMachineBlockEntity holder, boolean defaultParallel, @NotNull ToIntFunction<NoEnergyCustomParallelMultiblockMachine> parallel) {
        super(holder);
        customParallelTrait = new CustomParallelTrait(this, defaultParallel, machine -> parallel.applyAsInt((NoEnergyCustomParallelMultiblockMachine) machine));
    }

    @Override
    public void attachConfigurators(@NotNull ConfiguratorPanel configuratorPanel) {
        super.attachConfigurators(configuratorPanel);
        configuratorPanel.attachConfigurators(new ParallelConfigurator(this));
    }

    @Override
    public int getMaxParallel() {
        return customParallelTrait.getMaxParallel();
    }

    @Override
    public int getParallel() {
        return customParallelTrait.getParallel();
    }

    @Override
    public void setParallel(int number) {
        customParallelTrait.setParallel(number);
    }
}
