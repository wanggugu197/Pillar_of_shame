package org.gte.gtecore.mixin.gtm.api.machine;

import org.gte.gtecore.api.machine.feature.multiblock.IDistinctRecipeHolder;
import org.gte.gtecore.api.machine.feature.multiblock.IEnhancedMultiblockMachine;
import org.gte.gtecore.api.machine.feature.multiblock.IMEOutputMachine;
import org.gte.gtecore.api.machine.trait.IEnhancedRecipeLogic;
import org.gte.gtecore.api.recipe.AsyncRecipeOutputTask;
import org.gte.gtecore.api.recipe.AsyncRecipeSearchTask;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTERecipeModifiers;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.MachineTrait;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.ActionResult;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.api.sound.SoundEntry;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidStack;

import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Mixin(value = RecipeLogic.class, remap = false)
public abstract class RecipeLogicMixin extends MachineTrait implements IEnhancedRecipeLogic {

    @Unique
    private Object2LongOpenCustomHashMap<ItemStack> gtecore$parallelItemMap;

    @Unique
    private Object2LongOpenCustomHashMap<ItemStack> gtecore$itemMap;

    @Unique
    private Object2LongOpenCustomHashMap<ItemStack> gtecore$itemIngredientStacks;

    @Unique
    private Object2IntOpenHashMap<Ingredient> gtecore$itemNotConsumableMap;

    @Unique
    private Object2IntOpenHashMap<Ingredient> gtecore$itemConsumableMap;

    @Unique
    private Object2LongOpenHashMap<FluidStack> gtecore$parallelFluidMap;

    @Unique
    private Object2LongOpenHashMap<FluidStack> gtecore$fluidIngredientStacks;

    @Unique
    private Object2LongOpenHashMap<FluidStack> gtecore$fluidMap;

    @Unique
    private Object2IntOpenHashMap<FluidIngredient> gtecore$fluidNotConsumableMap;

    @Unique
    private Object2IntOpenHashMap<FluidIngredient> gtecore$fluidConsumableMap;

    @Unique
    private int gtecore$lastParallel;

    @Unique
    private boolean gtecore$modifyRecipe;

    @Unique
    private AsyncRecipeSearchTask gtecore$asyncRecipeSearchTask;

    @Unique
    private AsyncRecipeOutputTask gtecore$asyncRecipeOutputTask;

    @Unique
    @Persisted(key = "lockRecipe")
    private boolean gTECore$lockRecipe;

    @Unique
    @Persisted(key = "originRecipe")
    private GTRecipe gTECore$originRecipe;

    @Unique
    private int gtecore$interval = 5;

    @Unique
    @DescSynced
    private Component gtecore$reason;

    @Shadow
    @Nullable
    protected GTRecipe lastRecipe;

    protected RecipeLogicMixin(MetaMachine machine) {
        super(machine);
    }

    @Shadow
    public abstract void setStatus(RecipeLogic.Status status);

    @Shadow
    @Final
    public IRecipeLogicMachine machine;

    @Shadow
    public abstract void interruptRecipe();

    @Shadow
    protected int progress;

    @Shadow
    protected long totalContinuousRunningTime;

    @Shadow
    public abstract void setWaiting(@Nullable Component reason);

    @Shadow
    public abstract boolean isWaiting();

    @Shadow
    public abstract RecipeLogic.Status getStatus();

    @Shadow
    public abstract boolean isSuspend();

    @Shadow
    public abstract boolean isIdle();

    @Shadow
    protected int duration;

    @Shadow
    protected TickableSubscription subscription;

    @Shadow
    @Nullable
    protected GTRecipe lastOriginRecipe;

    @Shadow
    protected boolean recipeDirty;

    @Shadow
    protected abstract void regressRecipe();

    @Shadow
    public abstract Iterator<GTRecipe> searchRecipe();

    @Shadow
    protected abstract void handleSearchingRecipes(Iterator<GTRecipe> matches);

    @Shadow
    protected int consecutiveRecipes;

    @Shadow
    @Final
    protected Map<RecipeCapability<?>, Object2IntMap<?>> chanceCaches;

    @Shadow
    public abstract void markLastRecipeDirty();

    @Shadow
    protected boolean suspendAfterFinish;

    @Shadow
    protected boolean isActive;

    @Shadow
    public abstract boolean isActive();

    @Shadow
    public abstract void updateTickSubscription();

    @Shadow
    public List<GTRecipe> lastFailedMatches;

    @Unique
    private void gTECore$unsubscribe() {
        if (subscription != null) {
            subscription.unsubscribe();
            subscription = null;
        }
    }

    @Unique
    private boolean gTECore$successfullyRecipe(GTRecipe originrecipe) {
        if (lastRecipe != null && getStatus() == RecipeLogic.Status.WORKING) {
            lastOriginRecipe = originrecipe;
            lastFailedMatches = null;
            gtecore$interval = 5;
            if (gTECore$lockRecipe) gTECore$originRecipe = originrecipe;
            return true;
        }
        return false;
    }

    @Override
    public Object2LongOpenCustomHashMap<ItemStack> gtecore$getParallelItemMap() {
        if (gtecore$parallelItemMap == null) {
            gtecore$parallelItemMap = IEnhancedRecipeLogic.super.gtecore$getParallelItemMap();
        } else {
            gtecore$parallelItemMap.clear();
        }
        return gtecore$parallelItemMap;
    }

    @Override
    public Object2LongOpenCustomHashMap<ItemStack> gtecore$getItemMap() {
        if (gtecore$itemMap == null) {
            gtecore$itemMap = IEnhancedRecipeLogic.super.gtecore$getItemMap();
        } else {
            gtecore$itemMap.clear();
        }
        return gtecore$itemMap;
    }

    @Override
    public Object2LongOpenCustomHashMap<ItemStack> gtecore$getItemIngredientStacks() {
        if (gtecore$itemIngredientStacks == null) {
            gtecore$itemIngredientStacks = IEnhancedRecipeLogic.super.gtecore$getItemIngredientStacks();
        } else {
            gtecore$itemIngredientStacks.clear();
        }
        return gtecore$itemIngredientStacks;
    }

    @Override
    public Object2IntOpenHashMap<Ingredient> gtecore$getItemNotConsumableMap() {
        if (gtecore$itemNotConsumableMap == null) {
            gtecore$itemNotConsumableMap = IEnhancedRecipeLogic.super.gtecore$getItemNotConsumableMap();
        } else {
            gtecore$itemNotConsumableMap.clear();
        }
        return gtecore$itemNotConsumableMap;
    }

    @Override
    public Object2IntOpenHashMap<Ingredient> gtecore$getItemConsumableMap() {
        if (gtecore$itemConsumableMap == null) {
            gtecore$itemConsumableMap = IEnhancedRecipeLogic.super.gtecore$getItemConsumableMap();
        } else {
            gtecore$itemConsumableMap.clear();
        }
        return gtecore$itemConsumableMap;
    }

    @Override
    public Object2LongOpenHashMap<FluidStack> gtecore$getParallelFluidMap() {
        if (gtecore$parallelFluidMap == null) {
            gtecore$parallelFluidMap = IEnhancedRecipeLogic.super.gtecore$getParallelFluidMap();
        } else {
            gtecore$parallelFluidMap.clear();
        }
        return gtecore$parallelFluidMap;
    }

    @Override
    public Object2LongOpenHashMap<FluidStack> gtecore$getFluidMap() {
        if (gtecore$fluidMap == null) {
            gtecore$fluidMap = IEnhancedRecipeLogic.super.gtecore$getFluidMap();
        } else {
            gtecore$fluidMap.clear();
        }
        return gtecore$fluidMap;
    }

    @Override
    public Object2LongOpenHashMap<FluidStack> gtecore$getFluidIngredientStacks() {
        if (gtecore$fluidIngredientStacks == null) {
            gtecore$fluidIngredientStacks = IEnhancedRecipeLogic.super.gtecore$getFluidIngredientStacks();
        } else {
            gtecore$fluidIngredientStacks.clear();
        }
        return gtecore$fluidIngredientStacks;
    }

    @Override
    public Object2IntOpenHashMap<FluidIngredient> gtecore$getFluidNotConsumableMap() {
        if (gtecore$fluidNotConsumableMap == null) {
            gtecore$fluidNotConsumableMap = IEnhancedRecipeLogic.super.gtecore$getFluidNotConsumableMap();
        } else {
            gtecore$fluidNotConsumableMap.clear();
        }
        return gtecore$fluidNotConsumableMap;
    }

    @Override
    public Object2IntOpenHashMap<FluidIngredient> gtecore$getFluidConsumableMap() {
        if (gtecore$fluidConsumableMap == null) {
            gtecore$fluidConsumableMap = IEnhancedRecipeLogic.super.gtecore$getFluidConsumableMap();
        } else {
            gtecore$fluidConsumableMap.clear();
        }
        return gtecore$fluidConsumableMap;
    }

    @Override
    public void gtecore$cleanParallelMap() {
        if (gtecore$parallelItemMap != null) gtecore$parallelItemMap.clear();
        if (gtecore$itemIngredientStacks != null) gtecore$itemIngredientStacks.clear();
        if (gtecore$itemNotConsumableMap != null) gtecore$itemNotConsumableMap.clear();
        if (gtecore$itemConsumableMap != null) gtecore$itemConsumableMap.clear();
        if (gtecore$parallelFluidMap != null) gtecore$parallelFluidMap.clear();
        if (gtecore$fluidIngredientStacks != null) gtecore$fluidIngredientStacks.clear();
        if (gtecore$fluidNotConsumableMap != null) gtecore$fluidNotConsumableMap.clear();
        if (gtecore$fluidConsumableMap != null) gtecore$fluidConsumableMap.clear();
    }

    @Override
    public int gtecore$getlastParallel() {
        return gtecore$lastParallel;
    }

    @Override
    public void gtecore$setModifyRecipe() {
        gtecore$modifyRecipe = true;
    }

    @Override
    public boolean gtecore$hasAsyncTask() {
        return gtecore$asyncRecipeSearchTask != null && gtecore$asyncRecipeSearchTask.isHasTask();
    }

    @Override
    public void gtecore$setAsyncRecipeSearchTask(AsyncRecipeSearchTask task) {
        gtecore$asyncRecipeSearchTask = task;
    }

    @Override
    public AsyncRecipeSearchTask gtecore$getAsyncRecipeSearchTask() {
        return gtecore$asyncRecipeSearchTask;
    }

    @Override
    public void gtecore$setAsyncRecipeOutputTask(AsyncRecipeOutputTask task) {
        gtecore$asyncRecipeOutputTask = task;
    }

    @Override
    public AsyncRecipeOutputTask gtecore$getAsyncRecipeOutputTask() {
        return gtecore$asyncRecipeOutputTask;
    }

    @Override
    public void onMachineUnLoad() {
        AsyncRecipeSearchTask.removeAsyncLogic(getLogic());
        AsyncRecipeOutputTask.removeAsyncLogic(getLogic());
    }

    @Override
    public void gTECore$setLockRecipe(boolean look) {
        gTECore$lockRecipe = look;
        gTECore$originRecipe = null;
        updateTickSubscription();
    }

    @Override
    public boolean gTECore$isLockRecipe() {
        return gTECore$lockRecipe;
    }

    @Override
    public void gTECore$setIdleReason(Component reason) {
        this.gtecore$reason = reason;
    }

    @Override
    public Component gTECore$getIdleReason() {
        return gtecore$reason;
    }

    @OnlyIn(Dist.CLIENT)
    @Redirect(method = "updateSound", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/recipe/GTRecipeType;getSound()Lcom/gregtechceu/gtceu/api/sound/SoundEntry;"), remap = false)
    private SoundEntry updateSound(GTRecipeType instance) {
        SoundEntry sound = null;
        if (machine instanceof IEnhancedMultiblockMachine enhancedRecipeLogicMachine) {
            sound = enhancedRecipeLogicMachine.getSound();
        }
        if (sound == null) sound = instance.getSound();
        return sound;
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public void serverTick() {
        if (isSuspend()) {
            gTECore$unsubscribe();
        } else {
            if (!isIdle() && lastRecipe != null) {
                if (progress < duration) {
                    handleRecipeWorking();
                } else {
                    if (machine instanceof IEnhancedMultiblockMachine enhancedRecipeLogicMachine) {
                        enhancedRecipeLogicMachine.onRecipeFinish();
                    }
                    onRecipeFinish();
                }
            } else if (lastRecipe != null) {
                findAndHandleRecipe();
            } else if (gtecore$hasAsyncTask() || getMachine().getOffsetTimer() % gtecore$interval == 0) {
                boolean hasResult = false;
                if (gtecore$hasAsyncTask() && gtecore$asyncRecipeSearchTask.getResult() != null) {
                    AsyncRecipeSearchTask.Result result = gtecore$asyncRecipeSearchTask.getResult();
                    if (result.recipe() != null && RecipeRunnerHelper.checkConditions(machine, result.modified())) {
                        setupRecipe(result.modified());
                        if (gTECore$successfullyRecipe(result.recipe())) {
                            recipeDirty = false;
                        }
                    }
                    hasResult = true;
                    gtecore$asyncRecipeSearchTask.clean();
                }
                if (lastFailedMatches != null) {
                    for (GTRecipe match : lastFailedMatches) {
                        if (checkMatchedRecipeAvailable(match)) {
                            recipeDirty = false;
                            return;
                        }
                    }
                }
                if (!hasResult) findAndHandleRecipe();
                if (!gtecore$hasAsyncTask() && lastRecipe == null && isIdle() && !machine.keepSubscribing() && !recipeDirty) {
                    if (gtecore$interval < GTEConfig.INSTANCE.recipeMaxCheckInterval) {
                        gtecore$interval <<= 1;
                    }
                    gTECore$unsubscribe();
                }
            }
        }
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public void setupRecipe(GTRecipe recipe) {
        if (!machine.beforeWorking(recipe)) {
            setStatus(RecipeLogic.Status.IDLE);
            consecutiveRecipes = 0;
            progress = 0;
            duration = 0;
            isActive = false;
            return;
        }
        if (handleRecipeIO(recipe, IO.IN).isSuccess()) {
            if (lastRecipe != null && !recipe.equals(lastRecipe)) {
                chanceCaches.clear();
            }
            recipeDirty = false;
            lastRecipe = recipe;
            setStatus(RecipeLogic.Status.WORKING);
            progress = 0;
            duration = recipe.duration;
            isActive = true;
        } else {
            setStatus(RecipeLogic.Status.IDLE);
            consecutiveRecipes = 0;
            progress = 0;
            duration = 0;
            isActive = false;
        }
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public boolean checkMatchedRecipeAvailable(GTRecipe match) {
        GTRecipe modified = machine.fullModifyRecipe(match.copy());
        if (modified != null) {
            if (RecipeRunnerHelper.check(machine, modified)) {
                setupRecipe(modified);
            }
            return gTECore$successfullyRecipe(match);
        }
        return false;
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public void findAndHandleRecipe() {
        if (!recipeDirty && RecipeRunnerHelper.check(machine, lastRecipe)) {
            GTRecipe recipe = lastRecipe;
            lastRecipe = null;
            lastOriginRecipe = null;
            setupRecipe(recipe);
        } else {
            lastRecipe = null;
            if (gTECore$lockRecipe && gTECore$originRecipe != null) {
                lastOriginRecipe = gTECore$originRecipe;
                GTRecipe modified = machine.fullModifyRecipe(lastOriginRecipe.copy());
                if (RecipeRunnerHelper.check(machine, modified)) {
                    setupRecipe(modified);
                }
            } else {
                lastOriginRecipe = null;
                if (GTEConfig.INSTANCE.asyncRecipeSearch && getLogic().getClass() == RecipeLogic.class) {
                    if (!gtecore$hasAsyncTask()) {
                        AsyncRecipeSearchTask.addAsyncLogic(getLogic());
                    }
                } else {
                    handleSearchingRecipes(searchRecipe());
                }
            }
        }
        recipeDirty = false;
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public void onRecipeFinish() {
        machine.afterWorking();
        gtecore$lastParallel = 1;
        if (lastRecipe != null) {
            consecutiveRecipes++;
            handleRecipeIO(lastRecipe, IO.OUT);
            if (machine instanceof IDistinctRecipeHolder recipeHolder) recipeHolder.setDistinctState(true);
            if (machine.alwaysTryModifyRecipe() || gtecore$modifyRecipe) {
                if (lastOriginRecipe != null) {
                    if (gtecore$modifyRecipe || !(GTERecipeModifiers.TRY_AGAIN.contains(getMachine().getDefinition().getRecipeModifier()) && lastRecipe.parallels == MachineUtils.getHatchParallel(getMachine()) && RecipeRunnerHelper.checkConditions(machine, lastRecipe) && RecipeRunnerHelper.matchRecipe(machine, lastRecipe) && RecipeRunnerHelper.matchTickRecipe(machine, lastRecipe))) {
                        gtecore$lastParallel = lastRecipe.parallels;
                        var modified = machine.fullModifyRecipe(lastOriginRecipe.copy());
                        if (modified == null) {
                            markLastRecipeDirty();
                        } else {
                            lastRecipe = modified;
                        }
                    }
                } else {
                    markLastRecipeDirty();
                }
                gtecore$modifyRecipe = false;
            }
            if (!recipeDirty && !suspendAfterFinish && RecipeRunnerHelper.check(machine, lastRecipe)) {
                setupRecipe(lastRecipe);
            } else {
                if (suspendAfterFinish) {
                    setStatus(RecipeLogic.Status.SUSPEND);
                    suspendAfterFinish = false;
                } else {
                    setStatus(RecipeLogic.Status.IDLE);
                }
                consecutiveRecipes = 0;
                progress = 0;
                duration = 0;
                isActive = false;
            }
            if (machine instanceof IDistinctRecipeHolder recipeHolder) recipeHolder.setDistinctState(false);
        }
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    protected ActionResult handleRecipeIO(GTRecipe recipe, IO io) {
        if (io == IO.OUT && GTEConfig.INSTANCE.asyncRecipeOutput && machine instanceof IMEOutputMachine outputMachine && outputMachine.gTECore$DualMEOutput(recipe)) {
            AsyncRecipeOutputTask.addAsyncLogic(getLogic(), () -> RecipeRunnerHelper.handleRecipeOutput(machine, recipe));
            return ActionResult.SUCCESS;
        }
        if (RecipeRunnerHelper.handleRecipeIO(machine, recipe, io, chanceCaches)) {
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL_NO_REASON;
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite
    public void handleRecipeWorking() {
        assert lastRecipe != null;
        if (gtecore$handleTickRecipe(lastRecipe)) {
            if (!machine.onWorking()) {
                interruptRecipe();
                return;
            }
            setStatus(RecipeLogic.Status.WORKING);
            progress++;
            totalContinuousRunningTime++;
        } else {
            setWaiting(null);
        }
        if (isWaiting()) {
            if (machine instanceof IEnhancedMultiblockMachine enhancedMultiblockMachine) {
                enhancedMultiblockMachine.doDamping(getLogic());
            } else {
                regressRecipe();
            }
        }
    }

    @Unique
    private boolean gtecore$handleTickRecipe(GTRecipe recipe) {
        for (Map.Entry<RecipeCapability<?>, List<Content>> entry : recipe.tickInputs.entrySet()) {
            if (RecipeRunnerHelper.handleTickRecipe(machine, IO.IN, recipe, entry.getValue(), entry.getKey())) {
                return false;
            }
        }
        for (Map.Entry<RecipeCapability<?>, List<Content>> entry : recipe.tickOutputs.entrySet()) {
            if (RecipeRunnerHelper.handleTickRecipe(machine, IO.OUT, recipe, entry.getValue(), entry.getKey())) {
                return false;
            }
        }
        return true;
    }
}
