package org.gte.gtecore.common.machine.multiblock.electric.voidseries;

import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.api.machine.multiblock.StorageMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.ContentBuilder;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEBedrockFluids;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.item.DimensionDataItem;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.network.chat.Component;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.common.data.GTItems.PROGRAMMED_CIRCUIT;
import static net.minecraft.network.chat.Component.translatable;

public final class VoidFluidDrillingRigMachine extends StorageMultiblockMachine {

    private static final GTRecipe RECIPE = GTERecipeBuilder.ofRaw()
            .notConsumable(PROGRAMMED_CIRCUIT.get())
            .EUt(VA[GTValues.LuV])
            .duration(20)
            .buildRawRecipe();

    private int c;
    private List<FluidStack> fluidStacks;

    public VoidFluidDrillingRigMachine(IMachineBlockEntity holder) {
        super(holder, 1, i -> i.is(GTEItems.DIMENSION_DATA.get()) && i.hasTag());
    }

    @Override
    public void onMachineChanged() {
        fluidStacks = GTEBedrockFluids.ALL_BEDROCK_FLUID.get(GTEDimensions.getDimensionKey(DimensionDataItem.getDimension(getStorageStack())));
        c = checkingCircuit(false);
    }

    private GTRecipe getRecipe() {
        if (fluidStacks == null) return null;
        if (!isEmpty()) {
            if (RecipeRunnerHelper.matchRecipeInput(this, RECIPE)) {
                GTRecipe recipe = RECIPE.copy();
                recipe.tickInputs.put(EURecipeCapability.CAP, List.of(ContentBuilder.builderEU(getOverclockVoltage())));
                FluidStack fluidStack = fluidStacks.get(c).copy();
                fluidStack.setAmount(fluidStack.getAmount() * (1 << Math.max(0, getTier() - 6)));
                recipe.outputs.put(FluidRecipeCapability.CAP, List.of(ContentBuilder.create().fluid(fluidStack).builder()));
                return recipe;
            }
        }
        return null;
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        onMachineChanged();
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        if (fluidStacks != null && isFormed() && !getStorageStack().isEmpty()) {
            textList.add(translatable("gui.ae2.Fluids").append(":"));
            fluidStacks.forEach(f -> textList.add(f.getFluid().getFluidType().getDescription().copy().append("x" + f.getAmount())));
        }
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }
}
