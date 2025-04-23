package org.gte.gtecore.common.machine.multiblock.water;

import org.gte.gtecore.api.machine.multiblock.NoEnergyMultiblockMachine;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.machine.multiblock.part.IndicatorHatchPartMachine;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fluids.FluidStack;

import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class ResidualDecontaminantDegasserPurificationUnitMachine extends WaterPurificationUnitMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            ResidualDecontaminantDegasserPurificationUnitMachine.class, NoEnergyMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private static final List<FluidStack> FLUIDS = List.of(
            GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 10000),
            GTMaterials.Helium.getFluid(10000),
            GTMaterials.SamariumIronArsenicOxide.getFluid(1000),
            GTMaterials.Neon.getFluid(8000),
            GTMaterials.IndiumTinBariumTitaniumCuprate.getFluid(1000),
            GTMaterials.Argon.getFluid(6000),
            GTMaterials.UraniumRhodiumDinaquadide.getFluid(1000),
            GTMaterials.Krypton.getFluid(4000),
            GTMaterials.EnrichedNaquadahTriniumEuropiumDuranide.getFluid(1000),
            GTMaterials.Xenon.getFluid(2000),
            GTMaterials.RutheniumTriniumAmericiumNeutronate.getFluid(1000),
            GTMaterials.Neutronium.getFluid(2000));

    @Persisted
    private int inputCount;

    @Persisted
    private boolean successful;

    @Persisted
    private boolean failed;

    @Persisted
    @DescSynced
    private FluidStack fluidStack;

    private IndicatorHatchPartMachine indicatorHatchPartMachine;

    public ResidualDecontaminantDegasserPurificationUnitMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        if (getRecipeLogic().isWorking()) {
            textList.add(Component.translatable("gtecore.machine.residual_decontaminant_degasser_purification_unit.fluids", fluidStack.getDisplayName()));
            textList.add(Component.translatable("gui.enderio.sag_mill_chance", (successful && !failed) ? 100 : 0));
        }
    }

    @Override
    public void onPartScan(IMultiPart part) {
        super.onPartScan(part);
        if (indicatorHatchPartMachine == null && part instanceof IndicatorHatchPartMachine indicatorHatch) {
            indicatorHatchPartMachine = indicatorHatch;
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        indicatorHatchPartMachine = null;
    }

    @Override
    public boolean onWorking() {
        if (!super.onWorking()) return false;
        if (getOffsetTimer() % 20 == 0) {
            forEachInputFluids(stack -> {
                if (stack.getAmount() > 0) {
                    if (!fluidStack.isEmpty() && fluidStack.getFluid() == stack.getFluid() && fluidStack.getAmount() <= stack.getAmount()) {
                        successful = true;
                    } else {
                        failed = true;
                    }
                    inputFluid(stack);
                }
                return false;
            });
        }
        return true;
    }

    @Override
    public void afterWorking() {
        super.afterWorking();
        indicatorHatchPartMachine.setRedstoneSignalOutput(0);
    }

    @Override
    public void onRecipeFinish() {
        super.onRecipeFinish();
        if (successful && !failed) outputFluid(WaterPurificationPlantMachine.GradePurifiedWater7, inputCount * 9 / 10);
    }

    @Override
    long before() {
        eut = 0;
        successful = false;
        failed = false;
        inputCount = Math.min(getParallel(), getFluidAmount(WaterPurificationPlantMachine.GradePurifiedWater6)[0]);
        recipe = GTERecipeBuilder.ofRaw().duration(WaterPurificationPlantMachine.DURATION).inputFluids(new FluidStack(WaterPurificationPlantMachine.GradePurifiedWater6, inputCount)).buildRawRecipe();
        if (RecipeRunnerHelper.matchRecipe(this, recipe)) {
            indicatorHatchPartMachine.setRedstoneSignalOutput((int) (Math.random() * 15));
            if (indicatorHatchPartMachine.getRedstoneSignalOutput() == 13 || indicatorHatchPartMachine.getRedstoneSignalOutput() == 15) {
                fluidStack = FLUIDS.get(11);
            } else if (indicatorHatchPartMachine.getRedstoneSignalOutput() == 12 || indicatorHatchPartMachine.getRedstoneSignalOutput() == 14) {
                fluidStack = FluidStack.EMPTY;
            } else {
                fluidStack = FLUIDS.get(indicatorHatchPartMachine.getRedstoneSignalOutput());
            }
            eut = (long) inputCount << 5;
        }
        return eut;
    }
}
