package org.gte.gtecore.common.machine.multiblock.generator;

import org.gte.gtecore.api.machine.feature.IExtendWirelessEnergyContainerHolder;
import org.gte.gtecore.api.machine.feature.IRecipeSearchMachine;
import org.gte.gtecore.api.machine.feature.multiblock.IArrayMachine;
import org.gte.gtecore.api.machine.multiblock.StorageMultiblockMachine;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTERecipeTypes;
import org.gte.gtecore.common.wireless.ExtendWirelessEnergyContainer;
import org.gte.gtecore.config.GTEConfig;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.item.MetaMachineItem;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;

import com.hepdd.gtmthings.api.misc.WirelessEnergyContainer;
import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.ComponentPanelWidget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class GeneratorArrayMachine extends StorageMultiblockMachine implements IArrayMachine, IExtendWirelessEnergyContainerHolder, IRecipeSearchMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            GeneratorArrayMachine.class, StorageMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Getter
    @Setter
    private WirelessEnergyContainer WirelessEnergyContainerCache;
    @Getter
    @Setter
    private MachineDefinition machineDefinitionCache;
    @Getter
    @Setter
    private GTRecipeType[] RecipeTypeCache;

    @Persisted
    private boolean isw;

    @Persisted
    private long eut;

    private static final Set<GTRecipeType> ELIGIBLE_RECIPE_TYPES = Set.of(
            GTRecipeTypes.STEAM_TURBINE_FUELS,
            GTRecipeTypes.GAS_TURBINE_FUELS,
            GTRecipeTypes.COMBUSTION_GENERATOR_FUELS,
            GTERecipeTypes.SEMI_FLUID_GENERATOR_FUELS,
            GTERecipeTypes.ROCKET_ENGINE_FUELS,
            GTERecipeTypes.NAQUADAH_REACTOR);

    private static boolean isEligibleRecipeType(GTRecipeType type) {
        return ELIGIBLE_RECIPE_TYPES.contains(type);
    }

    public GeneratorArrayMachine(IMachineBlockEntity holder) {
        super(holder, 4, GeneratorArrayMachine::filter);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private static boolean filter(ItemStack itemStack) {
        if (itemStack.getItem() instanceof MetaMachineItem metaMachineItem) {
            MachineDefinition definition = metaMachineItem.getDefinition();

            if (definition instanceof MultiblockMachineDefinition) {
                return false;
            }

            var recipeTypes = definition.getRecipeTypes();
            if (recipeTypes == null) {
                return false;
            }
            for (GTRecipeType type : recipeTypes) {
                if (isEligibleRecipeType(type)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public GTRecipeType[] getRecipeTypes() {
        return recipeTypes();
    }

    @NotNull
    @Override
    public GTRecipeType getRecipeType() {
        return recipeTypes()[getActiveRecipeType()];
    }

    @Override
    public void onMachineChanged() {
        onStorageChanged();
    }

    @Override
    public int getTier() {
        MachineDefinition definition = getMachineDefinition();
        int definitionTier = definition == null ? 0 : definition.getTier();
        if (isw) {
            return definitionTier;
        }
        return Math.min(definitionTier, tier);
    }

    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        if (getUUID() == null) {
            setOwnerUUID(player.getUUID());
        }
        return true;
    }

    @Override
    public boolean onWorking() {
        if (!super.onWorking()) return false;
        if (isw) {
            if (eut > 0) {
                ExtendWirelessEnergyContainer container = getWirelessEnergyContainer();
                if (container != null) {
                    int loss = container.getLoss();
                    container.setLoss(loss + 50);
                    container.addEnergy(eut, this);
                    container.setLoss(loss);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static int getAmperage(int tier) {
        if (tier > 0 && tier < 4) {
            return 2;
        }
        return 1;
    }

    public static int getEfficiency(GTRecipeType recipeType, int tier) {
        int base = 105 - 5 * tier;
        if (recipeType == GTRecipeTypes.STEAM_TURBINE_FUELS) {
            base = 135 - 35 * tier;
        }
        if (recipeType == GTERecipeTypes.NAQUADAH_REACTOR) {
            base = 100 + 50 * (tier - GTValues.IV);
        }
        if (recipeType == GTERecipeTypes.THERMAL_GENERATOR_FUELS) {
            base = 100 - 25 * tier;
        }
        return base + 30 - 15 * GTEConfig.getDifficulty();
    }

    @Override
    public boolean canVoidRecipeOutputs(RecipeCapability<?> capability) {
        return capability != EURecipeCapability.CAP;
    }

    @Nullable
    @Override
    protected GTRecipe getRealRecipe(GTRecipe recipe) {
        int a = machineStorage.storage.getStackInSlot(0).getCount();
        if (a > 0) {
            long EUt = RecipeHelper.getOutputEUt(recipe);
            if (EUt > 0) {
                recipe.outputs.clear();
                int maxParallel = (int) (getMultiply() * GTValues.V[getOverclockTier()] * a * getAmperage(getTier()) / EUt);
                int multipliers = 0;
                for (RecipeCapability<?> cap : recipe.inputs.keySet()) {
                    if (cap instanceof FluidRecipeCapability fluidRecipeCapability) {
                        int paralle = fluidRecipeCapability.getMaxParallelRatio(this, recipe, maxParallel);
                        if (multipliers > 0) {
                            multipliers = Math.min(multipliers, paralle);
                        } else {
                            multipliers = paralle;
                        }
                    }
                }
                GTRecipe paraRecipe = recipe.copy(ContentModifier.multiplier(multipliers), false);
                paraRecipe.duration = paraRecipe.duration * getEfficiency(getRecipeType(), getTier()) / 100;
                if (isw) {
                    paraRecipe.tickOutputs.remove(EURecipeCapability.CAP);
                    eut = EUt * multipliers;
                }
                return paraRecipe;
            }
        }
        return null;
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        textList.add(Component.translatable("gtecore.machine.generator_array.wireless").append(ComponentPanelWidget.withButton(Component.literal("[").append(isw ? Component.translatable("gtecore.machine.on") : Component.translatable("gtecore.machine.off")).append(Component.literal("]")), "wireless_switch")));
        if (isActive() && isw) {
            GTRecipe r = getRecipeLogic().getLastRecipe();
            if (r != null) {
                textList.add(Component.translatable("gtceu.multiblock.max_energy_per_tick", FormattingUtil.formatNumbers(eut), Component.literal(GTValues.VNF[GTUtil.getFloorTierByVoltage(eut)])));
            }
        }
    }

    @Override
    public void handleDisplayClick(String componentData, ClickData clickData) {
        if (!clickData.isRemote) {
            if ("wireless_switch".equals(componentData)) {
                isw = !isw;
                eut = 0;
                getRecipeLogic().markLastRecipeDirty();
            }
        }
    }

    @Override
    public Item getStorageItem() {
        return getStorageStack().getItem();
    }

    @Override
    public @Nullable UUID getUUID() {
        return getOwnerUUID();
    }

    @Override
    public boolean matchRecipe(GTRecipe recipe) {
        return RecipeRunnerHelper.matchRecipeInput(this, recipe);
    }

    @Override
    public boolean matchTickRecipe(GTRecipe recipe) {
        return isw || IRecipeSearchMachine.super.matchTickRecipe(recipe);
    }

    public static double getMultiply() {
        switch (GTEConfig.getDifficulty()) {
            case 1 -> {
                return 2;
            }
            case 2 -> {
                return 1.5;
            }
            case 3 -> {
                return 1.2;
            }
            default -> {
                return 0;
            }
        }
    }
}
