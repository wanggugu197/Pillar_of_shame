package org.gte.gtecore.common.machine.multiblock.electric.nano;

import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class NanitesModuleMachine extends ElectricMultiblockMachine {

    NanitesIntegratedMachine nanitesIntegratedMachine;

    public NanitesModuleMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public GTRecipe fullModifyRecipe(@NotNull GTRecipe recipe) {
        NanitesIntegratedMachine.trimRecipe(recipe, nanitesIntegratedMachine.chance);
        return super.fullModifyRecipe(recipe);
    }

    @Override
    public boolean beforeWorking(GTRecipe recipe) {
        if (effective() || recipe.data.getInt("ebf_temp") > nanitesIntegratedMachine.gte$getTemperature() || recipe.data.getInt("module") != NanitesIntegratedMachine.MODULE_MAP.get(getDefinition())) return false;
        return super.beforeWorking(recipe);
    }

    private boolean effective() {
        return nanitesIntegratedMachine != null && nanitesIntegratedMachine.isFormed();
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        if (effective()) {
            textList.add(Component.translatable("tooltip.emi.chance.consume", 100 - nanitesIntegratedMachine.chance));
            textList.add(Component.translatable("gtceu.multiblock.blast_furnace.max_temperature", Component.translatable(FormattingUtil.formatNumbers(nanitesIntegratedMachine.gte$getTemperature()) + "K").setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
        }
    }
}
