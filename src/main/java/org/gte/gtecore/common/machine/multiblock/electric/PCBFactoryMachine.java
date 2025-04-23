package org.gte.gtecore.common.machine.multiblock.electric;

import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.machine.multiblock.StorageMultiblockMachine;
import org.gte.gtecore.common.data.GTERecipeModifiers;
import org.gte.gtecore.utils.ItemUtils;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class PCBFactoryMachine extends StorageMultiblockMachine {

    public PCBFactoryMachine(IMachineBlockEntity holder) {
        super(holder, 64, i -> ChemicalHelper.getPrefix(i.getItem()) == GTETagPrefix.NANITES);
    }

    private double reductionEUt = 1, reductionDuration = 1;

    private void getPCBReduction() {
        ItemStack itemStack = getStorageStack();
        String item = ItemUtils.getId(itemStack);
        if (Objects.equals(item, "gtocore:vibranium_nanites")) {
            reductionDuration = (double) (100 - itemStack.getCount()) / 100;
            reductionEUt = 0.25;
        } else if (Objects.equals(item, "gtceu:gold_nanites")) {
            reductionDuration = (100 - (itemStack.getCount() * 0.5)) / 100;
        }
    }

    @Nullable
    @Override
    protected GTRecipe getRealRecipe(@NotNull GTRecipe recipe) {
        getPCBReduction();
        return GTERecipeModifiers.overclocking(this, GTERecipeModifiers.hatchParallel(this, recipe), true, false, reductionEUt, reductionDuration);
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        if (getOffsetTimer() % 10 == 0) {
            getPCBReduction();
        }
        textList.add(Component.translatable("gtecore.machine.eut_multiplier.tooltip", reductionEUt));
        textList.add(Component.translatable("gtecore.machine.duration_multiplier.tooltip", reductionDuration));
    }
}
