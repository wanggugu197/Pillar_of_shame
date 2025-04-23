package org.gte.gtecore.common.machine.multiblock.water;

import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class FlocculationPurificationUnitMachine extends WaterPurificationUnitMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            FlocculationPurificationUnitMachine.class, WaterPurificationUnitMachine.MANAGED_FIELD_HOLDER);

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private static final Fluid PolyAluminiumChloride = GTEMaterials.PolyAluminiumChloride.getFluid();
    private static final Fluid FlocculationWasteSolution = GTEMaterials.FlocculationWasteSolution.getFluid();

    @Persisted
    private long chance;

    @Persisted
    private int inputCount;

    @Persisted
    private int outputCount;

    public FlocculationPurificationUnitMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        if (getRecipeLogic().isWorking()) {
            textList.add(Component.translatable("gui.enderio.sag_mill_chance", chance));
        }
    }

    @Override
    public boolean onWorking() {
        if (!super.onWorking()) return false;
        if (getOffsetTimer() % 20 == 0) {
            int amount = getFluidAmount(PolyAluminiumChloride)[0];
            if (inputFluid(PolyAluminiumChloride, amount)) {
                outputCount += amount;
                if (amount % 100000 == 0) {
                    if (chance < 100) chance += amount / 10000;
                } else {
                    chance = chance * (1L << (-10 * Math.abs((amount - 100000) / 100000)));
                }
            }
        }
        return true;
    }

    @Override
    public void onRecipeFinish() {
        super.onRecipeFinish();
        outputFluid(FlocculationWasteSolution, outputCount);
        if (Math.random() * 100 <= chance) outputFluid(WaterPurificationPlantMachine.GradePurifiedWater3, inputCount * 9 / 10);
    }

    @Override
    long before() {
        eut = 0;
        chance = 0;
        outputCount = 0;
        inputCount = Math.min(getParallel(), getFluidAmount(WaterPurificationPlantMachine.GradePurifiedWater2)[0]);
        recipe = GTERecipeBuilder.ofRaw().duration(WaterPurificationPlantMachine.DURATION).inputFluids(new FluidStack(WaterPurificationPlantMachine.GradePurifiedWater2, inputCount)).buildRawRecipe();
        if (RecipeRunnerHelper.matchRecipe(this, recipe)) {
            eut = (long) inputCount << 1;
        }
        return eut;
    }
}
