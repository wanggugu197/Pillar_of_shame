package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.api.machine.feature.multiblock.IDistinctRecipeHolder;
import org.gte.gtecore.api.machine.feature.multiblock.IEnhancedMultiblockMachine;
import org.gte.gtecore.api.machine.feature.multiblock.IMEOutputMachine;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeHandlerList;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.integration.ae2.machine.MEOutputBusPartMachine;
import com.gregtechceu.gtceu.integration.ae2.machine.MEOutputHatchPartMachine;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;

import com.hepdd.gtmthings.common.block.machine.multiblock.part.appeng.MEOutputPartMachine;
import com.llamalad7.mixinextras.sugar.Local;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(WorkableMultiblockMachine.class)
public abstract class WorkableMultiblockMachineMixin extends MultiblockControllerMachine implements IWorkableMultiController, IMEOutputMachine, IDistinctRecipeHolder {

    @Shadow(remap = false)
    @Final
    protected List<ISubscription> traitSubscriptions;

    @Getter
    @Setter
    @Unique
    @SuppressWarnings("all")
    private boolean distinctState;

    @Getter
    @Setter
    @Unique
    @SuppressWarnings("all")
    private ResourceLocation recipeId;

    @Getter
    @Setter
    @Unique
    @SuppressWarnings("all")
    private RecipeHandlerList currentDistinct;

    @Getter
    @Setter
    @Unique
    @SuppressWarnings("all")
    private List<RecipeHandlerList> distinct = List.of();

    @Getter
    @Setter
    @Unique
    @SuppressWarnings("all")
    private List<RecipeHandlerList> indistinct = List.of();

    @Unique
    private boolean gTECore$isItemOutput;

    @Unique
    private boolean gTECore$isFluidOutput;

    @Unique
    private boolean gTECore$isDualOutput;

    protected WorkableMultiblockMachineMixin(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public boolean canVoidRecipeOutputs(RecipeCapability<?> capability) {
        if (capability == ItemRecipeCapability.CAP && gTECore$isItemOutput) {
            return true;
        } else if (capability == FluidRecipeCapability.CAP && gTECore$isFluidOutput) {
            return true;
        }
        return self().getDefinition().getRecipeOutputLimits().containsKey(capability);
    }

    @Inject(method = "onStructureFormed", at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z", ordinal = 0), remap = false)
    private void onContentChanges(CallbackInfo ci, @Local RecipeHandlerList list) {
        traitSubscriptions.add(list.subscribe(() -> {
            if (this instanceof IEnhancedMultiblockMachine enhancedRecipeLogicMachine) {
                enhancedRecipeLogicMachine.onContentChanges(list);
            }
        }));
    }

    @Inject(method = "onStructureFormed", at = @At(value = "TAIL"), remap = false)
    private void onStructureFormed(CallbackInfo ci) {
        if (getLevel() instanceof ServerLevel level) {
            level.getServer().tell(new TickTask(1, this::arrangeDistinct));
        }
        getRecipeLogic().markLastRecipeDirty();
        for (IMultiPart part : getParts()) {
            if (this instanceof IEnhancedMultiblockMachine enhancedRecipeLogicMachine) {
                enhancedRecipeLogicMachine.onPartScan(part);
            }
            if (gTECore$isItemOutput && gTECore$isFluidOutput) {
                gTECore$isDualOutput = true;
                continue;
            }
            if (part instanceof MEOutputPartMachine) {
                gTECore$isItemOutput = true;
                gTECore$isFluidOutput = true;
                gTECore$isDualOutput = true;
            } else if (part instanceof MEOutputBusPartMachine) {
                gTECore$isItemOutput = true;
            } else if (part instanceof MEOutputHatchPartMachine) {
                gTECore$isFluidOutput = true;
            }
        }
    }

    @Inject(method = "onStructureInvalid", at = @At(value = "TAIL"), remap = false)
    private void onStructureInvalid(CallbackInfo ci) {
        gTECore$isItemOutput = false;
        gTECore$isFluidOutput = false;
        gTECore$isDualOutput = false;
    }

    @Override
    public boolean gTECore$DualMEOutput(@NotNull GTRecipe recipe) {
        if (gTECore$isDualOutput) return true;
        if (gTECore$isItemOutput || recipe.outputs.getOrDefault(ItemRecipeCapability.CAP, List.of()).isEmpty()) {
            return gTECore$isFluidOutput || recipe.outputs.getOrDefault(FluidRecipeCapability.CAP, List.of()).isEmpty();
        }
        return false;
    }

    @Override
    public boolean gTECore$DualMEOutput(boolean hasItem, boolean hasFluid) {
        if (gTECore$isDualOutput) return true;
        if (gTECore$isItemOutput || hasItem) {
            return gTECore$isFluidOutput || hasFluid;
        }
        return false;
    }

    @Override
    public boolean alwaysTryModifyRecipe() {
        return getDefinition().isAlwaysTryModifyRecipe();
    }

    @Override
    public boolean regressWhenWaiting() {
        return !getDefinition().isGenerator();
    }
}
