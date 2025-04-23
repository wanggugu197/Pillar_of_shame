package org.gte.gtecore.common.machine.multiblock.electric.voidseries;

import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.api.data.chemical.GTEChemicalHelper;
import org.gte.gtecore.api.machine.multiblock.StorageMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.ContentBuilder;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEOres;
import org.gte.gtecore.common.data.GTERecipeModifiers;
import org.gte.gtecore.common.item.DimensionDataItem;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DrillingFluid;
import static net.minecraft.network.chat.Component.translatable;

public final class VoidMinerMachine extends StorageMultiblockMachine {

    private static final GTRecipe RECIPE = GTERecipeBuilder.ofRaw()
            .inputFluids(DrillingFluid.getFluid(1000))
            .EUt(VA[GTValues.EV])
            .duration(20)
            .buildRawRecipe();

    private ResourceLocation dim;

    public VoidMinerMachine(IMachineBlockEntity holder) {
        super(holder, 1, i -> i.is(GTEItems.DIMENSION_DATA.get()) && i.hasTag());
    }

    @Override
    public void onMachineChanged() {
        dim = null;
        if (isEmpty()) return;
        dim = DimensionDataItem.getDimension(getStorageStack());
    }

    private GTRecipe getRecipe() {
        if (dim == null) return null;
        if (!isEmpty()) {
            if (RecipeRunnerHelper.matchRecipeInput(this, RECIPE)) {
                GTRecipe recipe = RECIPE.copy();
                recipe.tickInputs.put(EURecipeCapability.CAP, List.of(ContentBuilder.builderEU(GTValues.VA[getTier()])));
                recipe.outputs.put(ItemRecipeCapability.CAP, ContentBuilder.createList().items(getItems()).buildList());
                return GTERecipeModifiers.accurateParallel(this, recipe, 64);
            }
        }
        return null;
    }

    private ItemStack[] getItems() {
        ItemStack[] stacks = new ItemStack[4];
        for (int i = 0; i < 4; i++) {
            stacks[i] = new ItemStack(GTEChemicalHelper.getItem(TagPrefix.rawOre, GTEOres.selectMaterial(dim)), (int) Math.pow(getTier() - 3, Math.random() + 1));
        }
        return stacks;
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        onMachineChanged();
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        if (dim != null && isFormed() && !getStorageStack().isEmpty()) {
            textList.add(translatable("gtceu.multiblock.ore_rig.drilled_ores_list"));
            GTEOres.ALL_ORES.get(GTEDimensions.getDimensionKey(dim)).forEach((mat, i) -> textList.add(mat.getLocalizedName().append("x" + i)));
        }
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }
}
