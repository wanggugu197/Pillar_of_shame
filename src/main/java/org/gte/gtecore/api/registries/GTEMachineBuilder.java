package org.gte.gtecore.api.registries;

import org.gte.gtecore.api.recipe.GTERecipeModifier;
import org.gte.gtecore.common.data.GTERecipeModifiers;
import org.gte.gtecore.data.lang.LangHandler;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.IMachineBlock;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.gui.editor.EditableMachineUI;
import com.gregtechceu.gtceu.api.item.MetaMachineItem;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.tterrag.registrate.Registrate;
import org.apache.commons.lang3.function.TriFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GTEMachineBuilder extends MachineBuilder<MachineDefinition> {

    public static final Map<String, LangHandler.ENCN> TOOLTIPS_MAP = GTCEu.isDataGen() ? new HashMap<>() : null;

    private int tooltipsIndex;

    GTEMachineBuilder(Registrate registrate, String name, Function<ResourceLocation, MachineDefinition> definition, Function<IMachineBlockEntity, MetaMachine> machine, BiFunction<BlockBehaviour.Properties, MachineDefinition, IMachineBlock> blockFactory, BiFunction<IMachineBlock, Item.Properties, MetaMachineItem> itemFactory, TriFunction<BlockEntityType<?>, BlockPos, BlockState, IMachineBlockEntity> blockEntityFactory) {
        super(registrate, name, definition, machine, blockFactory, itemFactory, blockEntityFactory);
    }

    @Override
    public GTEMachineBuilder langValue(String langValue) {
        return (GTEMachineBuilder) super.langValue(langValue);
    }

    @Override
    public GTEMachineBuilder tier(int tier) {
        return (GTEMachineBuilder) super.tier(tier);
    }

    @Override
    public GTEMachineBuilder editableUI(@Nullable EditableMachineUI editableUI) {
        return (GTEMachineBuilder) super.editableUI(editableUI);
    }

    @Override
    public GTEMachineBuilder noRecipeModifier() {
        return (GTEMachineBuilder) super.noRecipeModifier();
    }

    @Override
    public GTEMachineBuilder alwaysTryModifyRecipe(boolean alwaysTryModifyRecipe) {
        return (GTEMachineBuilder) super.alwaysTryModifyRecipe(alwaysTryModifyRecipe);
    }

    @Override
    public GTEMachineBuilder recipeType(GTRecipeType type) {
        return (GTEMachineBuilder) super.recipeType(type);
    }

    @Override
    public GTEMachineBuilder abilities(PartAbility... abilities) {
        return (GTEMachineBuilder) super.abilities(abilities);
    }

    @Override
    public GTEMachineBuilder tooltips(Component... components) {
        return (GTEMachineBuilder) super.tooltips(components);
    }

    @Override
    public GTEMachineBuilder renderer(@Nullable Supplier<IRenderer> renderer) {
        return (GTEMachineBuilder) super.renderer(renderer);
    }

    @Override
    public GTEMachineBuilder tieredHullRenderer(ResourceLocation model) {
        return (GTEMachineBuilder) super.tieredHullRenderer(model);
    }

    @Override
    public GTEMachineBuilder overlayTieredHullRenderer(String name) {
        return (GTEMachineBuilder) super.overlayTieredHullRenderer(name);
    }

    @Override
    public GTEMachineBuilder workableTieredHullRenderer(ResourceLocation workableModel) {
        return (GTEMachineBuilder) super.workableTieredHullRenderer(workableModel);
    }

    @Override
    public GTEMachineBuilder tooltipBuilder(BiConsumer<ItemStack, List<Component>> tooltipBuilder) {
        return (GTEMachineBuilder) super.tooltipBuilder(tooltipBuilder);
    }

    public GTEMachineBuilder recipeModifier(GTERecipeModifier recipeModifier) {
        alwaysTryModifyRecipe(true);
        return (GTEMachineBuilder) super.recipeModifier(recipeModifier);
    }

    public GTEMachineBuilder recipeModifiers(GTERecipeModifier... recipeModifiers) {
        alwaysTryModifyRecipe(true);
        return (GTEMachineBuilder) super.recipeModifiers(recipeModifiers);
    }

    public GTEMachineBuilder nonYAxisRotation() {
        return (GTEMachineBuilder) rotationState(RotationState.NON_Y_AXIS);
    }

    public GTEMachineBuilder allRotation() {
        return (GTEMachineBuilder) rotationState(RotationState.ALL);
    }

    public GTEMachineBuilder noneRotation() {
        return (GTEMachineBuilder) rotationState(RotationState.NONE);
    }

    public GTEMachineBuilder tooltipsKey(String key, Object... args) {
        return tooltips(Component.translatable(key, args));
    }

    public GTEMachineBuilder tooltipsText(String en, String cn, Object... args) {
        String key = "gtecore.machine." + name + ".tooltip." + tooltipsIndex;
        if (TOOLTIPS_MAP != null) TOOLTIPS_MAP.put(key, new LangHandler.ENCN(en, cn));
        tooltipsKey(key, args);
        tooltipsIndex++;
        return this;
    }

    public GTEMachineBuilder overclock() {
        return (GTEMachineBuilder) recipeModifier(GTERecipeModifiers.OVERCLOCKING, false);
    }

    public GTEMachineBuilder perfectOverclock() {
        return (GTEMachineBuilder) recipeModifier(GTERecipeModifiers.PERFECT_OVERCLOCKING, false);
    }
}
