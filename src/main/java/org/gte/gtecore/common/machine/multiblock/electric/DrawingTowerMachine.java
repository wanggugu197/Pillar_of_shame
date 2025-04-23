package org.gte.gtecore.common.machine.multiblock.electric;

import org.gte.gtecore.api.machine.multiblock.CoilMultiblockMachine;
import org.gte.gtecore.common.data.GTERecipeModifiers;
import org.gte.gtecore.common.machine.multiblock.part.SpoolHatchPartMachine;
import org.gte.gtecore.utils.FunctionContainer;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.transfer.item.CustomItemStackHandler;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class DrawingTowerMachine extends CoilMultiblockMachine {

    private SpoolHatchPartMachine spoolHatchPartMachine;

    private int height;

    private double reduction = 1;

    private int parallels = 1;

    public DrawingTowerMachine(IMachineBlockEntity holder) {
        super(holder, false, false);
    }

    @Override
    public void onPartScan(IMultiPart part) {
        super.onPartScan(part);
        if (spoolHatchPartMachine == null && part instanceof SpoolHatchPartMachine spoolHatchPart) {
            spoolHatchPartMachine = spoolHatchPart;
        }
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        FunctionContainer<Integer, ?> container = getMultiblockState().getMatchContext().get("laminated_glass");
        if (container != null) {
            height = container.getValue();
        }
        reduction = Math.max(0.00001, 2 / Math.pow(1.2, ((height / 8D) * ((gte$getTemperature() - 5000D) / 900D))));
        parallels = (gte$getTemperature() <= 10000) ? 1 : (int) Math.round(Math.log(gte$getTemperature() - 9600) / Math.log(1.08) - 84);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        height = 0;
        spoolHatchPartMachine = null;
    }

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        if (spoolHatchPartMachine == null) return null;
        CustomItemStackHandler storage = spoolHatchPartMachine.getInventory().storage;
        ItemStack item = storage.getStackInSlot(0);
        int tier = getItemTier(item);

        // Check if the item is a valid spool and matches the required tier in the recipe
        if (tier == recipe.data.getInt("spool")) {
            // Decrease the item count instead of increasing damage
            if (item.getCount() > 1) {
                item.shrink(1); // Reduce the stack size by one
                storage.setStackInSlot(0, item);
            } else {
                storage.setStackInSlot(0, ItemStack.EMPTY); // Remove the item if only one left
            }
            recipe.duration = (int) (recipe.duration * reduction);
            return GTERecipeModifiers.accurateParallel(this, recipe, parallels);
        }
        return null;
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        textList.add(Component.translatable("gtecore.machine.height", height));
        textList.add(Component.translatable("gtecore.machine.duration_multiplier.tooltip", reduction));
        textList.add(Component.translatable("gtecore.machine.parallel", parallels));
    }

    private static int getItemTier(ItemStack item) {
        if (item.isEmpty()) {
            return 0;
        }
        return SpoolHatchPartMachine.SPOOL.getOrDefault(item.getItem(), 0);
    }
}
