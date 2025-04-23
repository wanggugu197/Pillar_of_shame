package org.gte.gtecore.common.machine.multiblock.water;

import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class OzonationPurificationUnitMachine extends WaterPurificationUnitMachine implements IExplosionMachine {

    private static final Fluid Ozone = GTEMaterials.Ozone.getFluid();

    public OzonationPurificationUnitMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    long before() {
        eut = 0;
        int[] a = getFluidAmount(WaterPurificationPlantMachine.GradePurifiedWater1, Ozone);
        int ozoneCount = a[1];
        if (ozoneCount > 1024000) {
            inputFluid(Ozone, ozoneCount);
            doExplosion(10);
        }
        int inputCount = Math.min(getParallel(), Math.min(a[0], ozoneCount * 10000));
        int outputCount = inputCount * 9 / 10;
        GTERecipeBuilder builder = GTERecipeBuilder.ofRaw();
        builder.duration(WaterPurificationPlantMachine.DURATION).inputFluids(new FluidStack(Ozone, inputCount / 10000)).inputFluids(new FluidStack(WaterPurificationPlantMachine.GradePurifiedWater1, inputCount));
        if (Math.random() * 100 <= getChance(outputCount / 10, ozoneCount)) {
            builder.outputFluids(new FluidStack(WaterPurificationPlantMachine.GradePurifiedWater2, outputCount));
        } else {
            builder.outputFluids(new FluidStack(WaterPurificationPlantMachine.GradePurifiedWater1, outputCount));
        }
        recipe = builder.buildRawRecipe();
        if (RecipeRunnerHelper.matchRecipe(this, recipe)) {
            eut = inputCount;
        }
        return eut;
    }

    private int getChance(int count, long ozoneCount) {
        int a = Math.min(80, (int) (ozoneCount / 102400 << 3));
        if (inputFluid(WaterPurificationPlantMachine.GradePurifiedWater2, count / 4)) {
            return a + 20;
        } else if (inputFluid(WaterPurificationPlantMachine.GradePurifiedWater2, count)) {
            return a + 15;
        }
        return a;
    }
}
