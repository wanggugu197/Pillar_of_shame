package org.gte.gtecore.api.recipe;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.capability.recipe.ManaRecipeCapability;
import org.gte.gtecore.mixin.gtm.api.recipe.GTRecipeTypeAccessor;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.*;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.gui.SteamTexture;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.chance.boost.ChanceBoostFunction;
import com.gregtechceu.gtceu.api.recipe.ui.GTRecipeTypeUI;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;

import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.function.*;

public class GTERecipeType extends GTRecipeType {

    Map<ResourceLocation, Boolean> filter;

    @Setter
    @Getter
    @Accessors(chain = true, fluent = true)
    private boolean noSearch;

    public GTERecipeType(ResourceLocation registryName, String group, RecipeType<?>... proxyRecipes) {
        super(registryName, group, proxyRecipes);
        setRecipeBuilder(new GTERecipeBuilder(registryName, this));
    }

    @Override
    public @NotNull Iterator<GTRecipe> searchRecipe(IRecipeCapabilityHolder holder, Predicate<GTRecipe> canHandle) {
        if (!holder.hasCapabilityProxies()) return Collections.emptyIterator();
        return new SearchRecipeIterator(holder, this, canHandle);
    }

    @Override
    public GTRecipe toGTrecipe(ResourceLocation id, Recipe<?> recipe) {
        var builder = recipeBuilder(id);
        for (var ingredient : recipe.getIngredients()) {
            builder.inputItems(ingredient);
        }
        builder.outputItems(recipe.getResultItem(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY)));
        if (recipe instanceof SmeltingRecipe smeltingRecipe) {
            builder.duration(smeltingRecipe.getCookingTime() / 4);
            builder.EUt(GTValues.VA[GTValues.LV]);
        }
        return builder.buildRawRecipe();
    }

    @Override
    public GTERecipeBuilder recipeBuilder(ResourceLocation id, Object... append) {
        GTERecipeBuilder builder;
        if (append.length > 0) {
            builder = getRecipeBuilder().copy(new ResourceLocation(id.getNamespace(), id.getPath() + Arrays.stream(append).map(Object::toString).map(FormattingUtil::toLowerCaseUnder).reduce("", (a, b) -> a + "_" + b)));
        } else {
            builder = getRecipeBuilder().copy(id);
        }
        if (filter != null && filter.containsKey(id)) {
            builder.deleted = true;
            filter.put(id, true);
        }
        return builder;
    }

    @Override
    public GTERecipeBuilder recipeBuilder(String id, Object... append) {
        return recipeBuilder(GTCEu.id(id), append);
    }

    @Override
    public GTERecipeBuilder recipeBuilder(MaterialEntry entry, Object... append) {
        return recipeBuilder(GTCEu.id(entry.tagPrefix() + (entry.material().isNull() ? "" : "_" + entry.material().getName())), append);
    }

    @Override
    public GTERecipeBuilder recipeBuilder(Supplier<? extends ItemLike> item, Object... append) {
        return recipeBuilder(item.get(), append);
    }

    @Override
    public GTERecipeBuilder recipeBuilder(ItemLike itemLike, Object... append) {
        return recipeBuilder(new ResourceLocation(itemLike.asItem().getDescriptionId()), append);
    }

    @Override
    public GTERecipeBuilder copyFrom(GTRecipeBuilder builder) {
        return getRecipeBuilder().copyFrom(builder);
    }

    @Override
    public GTERecipeType onRecipeBuild(BiConsumer<GTRecipeBuilder, Consumer<FinishedRecipe>> onBuild) {
        getRecipeBuilder().onSave(onBuild);
        return this;
    }

    @Override
    public GTERecipeType setMaxIOSize(int maxInputs, int maxOutputs, int maxFluidInputs, int maxFluidOutputs) {
        return setMaxSize(IO.IN, ItemRecipeCapability.CAP, maxInputs).setMaxSize(IO.IN, FluidRecipeCapability.CAP, maxFluidInputs).setMaxSize(IO.OUT, ItemRecipeCapability.CAP, maxOutputs).setMaxSize(IO.OUT, FluidRecipeCapability.CAP, maxFluidOutputs);
    }

    @Override
    public GTERecipeType setEUIO(IO io) {
        if (io.support(IO.IN)) {
            setMaxSize(IO.IN, EURecipeCapability.CAP, 1);
        }
        if (io.support(IO.OUT)) {
            setMaxSize(IO.OUT, EURecipeCapability.CAP, 1);
        }
        return this;
    }

    @Override
    public GTERecipeType setMaxSize(IO io, RecipeCapability<?> cap, int max) {
        if (io == IO.IN || io == IO.BOTH) {
            maxInputs.put(cap, max);
        }
        if (io == IO.OUT || io == IO.BOTH) {
            maxOutputs.put(cap, max);
        }
        return this;
    }

    @Override
    public GTERecipeType setSlotOverlay(boolean isOutput, boolean isFluid, IGuiTexture slotOverlay) {
        return (GTERecipeType) super.setSlotOverlay(isOutput, isFluid, slotOverlay);
    }

    @Override
    public GTERecipeType setSlotOverlay(boolean isOutput, boolean isFluid, boolean isLast, IGuiTexture slotOverlay) {
        return (GTERecipeType) super.setSlotOverlay(isOutput, isFluid, isLast, slotOverlay);
    }

    @Override
    public GTERecipeType setProgressBar(ResourceTexture progressBar, ProgressTexture.FillDirection moveType) {
        return (GTERecipeType) super.setProgressBar(progressBar, moveType);
    }

    @Override
    public GTERecipeType setSteamProgressBar(SteamTexture progressBar, ProgressTexture.FillDirection moveType) {
        return (GTERecipeType) super.setSteamProgressBar(progressBar, moveType);
    }

    @Override
    public GTERecipeType setUiBuilder(BiConsumer<GTRecipe, WidgetGroup> uiBuilder) {
        return (GTERecipeType) super.setUiBuilder(uiBuilder);
    }

    @Override
    public GTERecipeType setMaxTooltips(int maxTooltips) {
        return (GTERecipeType) super.setMaxTooltips(maxTooltips);
    }

    @Override
    public GTERecipeType setXEIVisible(boolean XEIVisible) {
        return (GTERecipeType) super.setXEIVisible(XEIVisible);
    }

    @Override
    public GTERecipeType addDataInfo(Function<CompoundTag, String> dataInfo) {
        this.dataInfos.add(dataInfo);
        return this;
    }

    @Override
    public GTERecipeType addCustomRecipeLogic(GTRecipeType.ICustomRecipeLogic recipeLogic) {
        return (GTERecipeType) super.addCustomRecipeLogic(recipeLogic);
    }

    @Override
    public GTERecipeType prepareBuilder(Consumer<GTRecipeBuilder> onPrepare) {
        return (GTERecipeType) super.prepareBuilder(onPrepare);
    }

    @Override
    public GTERecipeType setRecipeBuilder(final GTRecipeBuilder recipeBuilder) {
        return (GTERecipeType) super.setRecipeBuilder(recipeBuilder);
    }

    @Override
    public GTERecipeType setChanceFunction(final ChanceBoostFunction chanceFunction) {
        return (GTERecipeType) super.setChanceFunction(chanceFunction);
    }

    @Override
    public GTERecipeType setRecipeUI(final GTRecipeTypeUI recipeUI) {
        return (GTERecipeType) super.setRecipeUI(recipeUI);
    }

    @Override
    public GTERecipeType setSmallRecipeMap(final GTRecipeType smallRecipeMap) {
        return (GTERecipeType) super.setSmallRecipeMap(smallRecipeMap);
    }

    @Override
    public GTERecipeType getSmallRecipeMap() {
        return (GTERecipeType) super.getSmallRecipeMap();
    }

    @Override
    public GTERecipeType setIconSupplier(@Nullable final Supplier<ItemStack> iconSupplier) {
        return (GTERecipeType) super.setIconSupplier(iconSupplier);
    }

    @Override
    public GTERecipeType setSound(@Nullable final SoundEntry sound) {
        this.sound = sound;
        return this;
    }

    @Override
    public GTERecipeType setScanner(final boolean isScanner) {
        this.isScanner = isScanner;
        return this;
    }

    @Override
    public GTERecipeType setHasResearchSlot(final boolean hasResearchSlot) {
        this.hasResearchSlot = hasResearchSlot;
        return this;
    }

    @Override
    public GTERecipeType setOffsetVoltageText(final boolean offsetVoltageText) {
        return (GTERecipeType) super.setOffsetVoltageText(offsetVoltageText);
    }

    @Override
    public GTERecipeType setVoltageTextOffset(final int voltageTextOffset) {
        return (GTERecipeType) super.setVoltageTextOffset(voltageTextOffset);
    }

    public GTERecipeType setMANAIO(IO io) {
        if (io.support(IO.IN)) {
            setMaxSize(IO.IN, ManaRecipeCapability.CAP, 1);
        }
        if (io.support(IO.OUT)) {
            setMaxSize(IO.OUT, ManaRecipeCapability.CAP, 1);
        }
        return this;
    }

    public GTERecipeBuilder builder(String id, Object... append) {
        return recipeBuilder(GTECore.id(id), append);
    }

    public void addFilter(String id) {
        filter.put(GTCEu.id(id), false);
    }

    private GTERecipeBuilder getRecipeBuilder() {
        return (GTERecipeBuilder) ((GTRecipeTypeAccessor) this).getRecipeBuilder();
    }
}
