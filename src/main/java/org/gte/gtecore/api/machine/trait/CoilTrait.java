package org.gte.gtecore.api.machine.trait;

import org.gte.gtecore.api.machine.feature.multiblock.ICoilMachine;
import org.gte.gtecore.api.machine.feature.multiblock.IMultiblockTraitHolder;
import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.api.recipe.IdleReason;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CoilTrait extends MultiblockTrait {

    @Getter
    private ICoilType coilType = CoilBlock.CoilType.CUPRONICKEL;
    @Getter
    private int temperature;
    private final boolean ebf;
    private final boolean check;

    public CoilTrait(ICoilMachine machine, boolean ebf, boolean check) {
        super((IMultiblockTraitHolder) machine);
        this.ebf = ebf;
        this.check = check;
    }

    @Override
    public boolean beforeWorking(@NotNull GTRecipe recipe) {
        if (check && temperature < recipe.data.getInt("ebf_temp")) {
            if (getMachine().getRecipeLogic() instanceof IEnhancedRecipeLogic enhancedRecipeLogic) {
                enhancedRecipeLogic.gTECore$setIdleReason(IdleReason.INSUFFICIENT_TEMPERATURE.reason());
            }
            return true;
        }
        return false;
    }

    @Override
    public GTRecipe modifyRecipe(@NotNull GTRecipe recipe) {
        if (check && temperature < recipe.data.getInt("ebf_temp")) {
            if (getMachine().getRecipeLogic() instanceof IEnhancedRecipeLogic enhancedRecipeLogic) {
                enhancedRecipeLogic.gTECore$setIdleReason(IdleReason.INSUFFICIENT_TEMPERATURE.reason());
            }
            return null;
        }
        return super.modifyRecipe(recipe);
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        textList.add(Component.translatable("gtceu.multiblock.blast_furnace.max_temperature", Component.translatable(FormattingUtil.formatNumbers(temperature) + "K").setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
    }

    @Override
    public void onStructureFormed() {
        if (getMachine().getMultiblockState().getMatchContext().get("CoilType") instanceof ICoilType coil) {
            coilType = coil;
        }
        temperature = coilType.getCoilTemperature() + (ebf ? 100 * Math.max(0, getMachine().getTier() - GTValues.MV) : 0);
    }

    @Override
    public ElectricMultiblockMachine getMachine() {
        return (ElectricMultiblockMachine) machine;
    }

    @Override
    public void onStructureInvalid() {
        coilType = CoilBlock.CoilType.CUPRONICKEL;
    }

    public int getCoilTier() {
        return coilType.getTier();
    }
}
