package org.gte.gtecore.api.machine.multiblock;

import org.gte.gtecore.api.machine.feature.multiblock.ICoilMachine;
import org.gte.gtecore.api.machine.trait.CoilTrait;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;

import java.util.function.Function;
import java.util.function.ToIntFunction;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CoilCrossRecipeMultiblockMachine extends CrossRecipeMultiblockMachine implements ICoilMachine {

    public static CrossRecipeMultiblockMachine createCoilParallel(IMachineBlockEntity holder) {
        return createCoilParallel(holder, false);
    }

    public static CrossRecipeMultiblockMachine createInfiniteCoilParallel(IMachineBlockEntity holder) {
        return createCoilParallel(holder, true);
    }

    private static CrossRecipeMultiblockMachine createCoilParallel(IMachineBlockEntity holder, boolean infinite) {
        return new CoilCrossRecipeMultiblockMachine(holder, infinite, false, false, false, m -> m.isFormed() ? Math.min(2147483647, 1 << (int) (m.gte$getTemperature() / 1200.0D)) : 0);
    }

    public static Function<IMachineBlockEntity, CrossRecipeMultiblockMachine> createHatchParallel(boolean ebf) {
        return holder -> new CoilCrossRecipeMultiblockMachine(holder, false, true, ebf, true, MachineUtils::getHatchParallel);
    }

    private final CoilTrait coilTrait;

    protected CoilCrossRecipeMultiblockMachine(IMachineBlockEntity holder, boolean infinite, boolean isHatchParallel, boolean ebf, boolean check, ToIntFunction<CoilCrossRecipeMultiblockMachine> parallel) {
        super(holder, infinite, isHatchParallel, machine -> parallel.applyAsInt((CoilCrossRecipeMultiblockMachine) machine));
        coilTrait = new CoilTrait(this, ebf, check);
    }

    @Override
    public int gte$getTemperature() {
        return coilTrait.getTemperature();
    }

    @Override
    public int getCoilTier() {
        return coilTrait.getCoilTier();
    }

    @Override
    public ICoilType getCoilType() {
        return coilTrait.getCoilType();
    }
}
