package org.gte.gtecore.common.machine.multiblock.electric.smelter;

import org.gte.gtecore.api.machine.multiblock.CoilMultiblockMachine;
import org.gte.gtecore.common.data.GTERecipeTypes;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class DimensionallyTranscendentPlasmaForgeMachine extends CoilMultiblockMachine {

    public DimensionallyTranscendentPlasmaForgeMachine(IMachineBlockEntity holder) {
        super(holder, false, false);
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (recipe == null) return false;
        if (gte$getTemperature() == 273) {
            if (getRecipeType() != GTERecipeTypes.STELLAR_FORGE_RECIPES) {
                return false;
            } else if (recipe.data.getInt("ebf_temp") > 32000) {
                return false;
            }
        } else if (recipe.data.getInt("ebf_temp") > gte$getTemperature()) {
            return false;
        }
        return super.beforeWorking(recipe);
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        textList.add(Component.translatable("gtceu.multiblock.blast_furnace.max_temperature", Component.literal(FormattingUtil.formatNumbers((gte$getTemperature() == 273 ? 32000 : gte$getTemperature())) + "K").withStyle(ChatFormatting.BLUE)));
        if (getRecipeType() == GTERecipeTypes.STELLAR_FORGE_RECIPES && gte$getTemperature() != 273) {
            textList.add(Component.translatable("gtecore.machine.dimensionally_transcendent_plasma_forge.coil").withStyle(ChatFormatting.RED));
        }
    }
}
