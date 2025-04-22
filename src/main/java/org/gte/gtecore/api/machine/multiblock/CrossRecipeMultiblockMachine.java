package org.gte.gtecore.api.machine.multiblock;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.gui.GTEGuiTextures;
import org.gte.gtecore.api.machine.feature.IOverclockConfigMachine;
import org.gte.gtecore.api.machine.feature.multiblock.IDistinctRecipeHolder;
import org.gte.gtecore.api.machine.feature.multiblock.IMEOutputMachine;
import org.gte.gtecore.api.machine.feature.multiblock.IParallelMachine;
import org.gte.gtecore.api.machine.trait.CustomParallelTrait;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.machine.trait.MultiblockTrait;
import org.gte.gtecore.api.recipe.AsyncRecipeOutputTask;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.ParallelConfigurator;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTERecipeModifiers;
import org.gte.gtecore.common.machine.multiblock.part.ThreadHatchPartMachine;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.utils.ItemUtils;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfiguratorButton;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.ActionResult;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class CrossRecipeMultiblockMachine extends ElectricMultiblockMachine implements IParallelMachine, IOverclockConfigMachine, IDistinctRecipeHolder {

    private static final CompoundTag EMPTY_TAG = new CompoundTag();

    public static CrossRecipeMultiblockMachine createHatchParallel(IMachineBlockEntity holder) {
        return new CrossRecipeMultiblockMachine(holder, false, true, MachineUtils::getHatchParallel);
    }

    public static Function<IMachineBlockEntity, CrossRecipeMultiblockMachine> createParallel(boolean infinite, boolean isHatchParallel, ToIntFunction<CrossRecipeMultiblockMachine> parallel) {
        return holder -> new CrossRecipeMultiblockMachine(holder, infinite, isHatchParallel, parallel);
    }

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            CrossRecipeMultiblockMachine.class, ElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Persisted
    @Getter
    private final Set<GTRecipe> originRecipes = new ObjectOpenHashSet<>();
    @Persisted
    @Getter
    private final Set<GTRecipe> lastRecipes = new ObjectOpenHashSet<>();

    private GTRecipe lastMatchRecipe;

    private int lastParallel;
    private int lastparallel;

    @Persisted
    private boolean hasItem;
    @Persisted
    private boolean hasFluid;

    @Persisted
    @Getter
    @Setter
    private boolean jadeInfo = true;

    private ThreadHatchPartMachine threadHatchPartMachine;

    @Persisted
    private final CustomParallelTrait customParallelTrait;
    private final boolean infinite;
    private final boolean isHatchParallel;

    protected CrossRecipeMultiblockMachine(IMachineBlockEntity holder, boolean infinite, boolean isHatchParallel, @NotNull ToIntFunction<CrossRecipeMultiblockMachine> parallel) {
        super(holder);
        this.infinite = infinite;
        this.isHatchParallel = isHatchParallel;
        customParallelTrait = new CustomParallelTrait(this, false, machine -> parallel.applyAsInt((CrossRecipeMultiblockMachine) machine));
    }

    public int getThread() {
        return infinite ? 128 : threadHatchPartMachine == null ? 1 : threadHatchPartMachine.getCurrentThread();
    }

    private boolean isRepeatedRecipes() {
        if (threadHatchPartMachine == null) return true;
        return threadHatchPartMachine.isRepeatedRecipes();
    }

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        super.attachConfigurators(configuratorPanel);
        if (!isHatchParallel) configuratorPanel.attachConfigurators(new ParallelConfigurator(this));
        configuratorPanel.attachConfigurators(new IFancyConfiguratorButton.Toggle(
                GTEGuiTextures.FOLDING_OUTPUT.getSubTexture(0, 0, 1, 0.5),
                GTEGuiTextures.FOLDING_OUTPUT.getSubTexture(0, 0.5, 1, 0.5),
                this::isJadeInfo, (clickData, pressed) -> this.setJadeInfo(pressed))
                .setTooltipsSupplier(pressed -> List.of(Component.translatable("gtceu.top.recipe_output").append(Component.translatable(pressed ? "waila.ae2.Showing" : "config.jade.display_fluids_none")))));
    }

    private GTRecipe getRecipe() {
        GTRecipe match = LookupRecipe();
        if (match == null) return null;
        long totalEu = 0;
        lastRecipes.clear();
        hasItem = false;
        hasFluid = false;
        for (int i = 0; i < getThread(); i++) {
            totalEu += match.duration * RecipeHelper.getInputEUt(match);
            match.tickInputs.clear();
            match.data = EMPTY_TAG;
            if (isRepeatedRecipes()) match.id = GTECore.id("thread_" + i);
            if (!hasItem && match.outputs.getOrDefault(ItemRecipeCapability.CAP, List.of()).isEmpty()) {
                hasItem = true;
            }
            if (!hasFluid && match.outputs.getOrDefault(FluidRecipeCapability.CAP, List.of()).isEmpty()) {
                hasFluid = true;
            }
            lastRecipes.add(match);
            match = LookupRecipe();
            if (match == null) break;
        }
        long maxEUt = getOverclockVoltage();
        double d = (double) totalEu / maxEUt;
        int limit = gTECore$getOCLimit();
        return GTERecipeBuilder.ofRaw().EUt(d >= limit ? maxEUt : Math.max(1, (long) (maxEUt * d / limit))).duration((int) Math.max(d, limit)).buildRawRecipe();
    }

    private GTRecipe LookupRecipe() {
        if (lastMatchRecipe != null) {
            lastparallel = lastParallel;
            GTRecipe recipe = modifyRecipe(lastMatchRecipe.copy());
            if (recipe == null) {
                lastMatchRecipe = null;
            } else {
                if (lastParallel != getRealParallel()) {
                    lastparallel = 1;
                    lastMatchRecipe = null;
                }
                return recipe;
            }
        }
        if (getRecipeLogic().gTECore$isLockRecipe() && originRecipes.size() >= getThread()) {
            for (GTRecipe recipe : originRecipes) {
                GTRecipe modify = modifyRecipe(recipe.copy());
                if (modify != null) {
                    if (lastParallel == getRealParallel()) lastMatchRecipe = recipe;
                    return modify;
                }
            }
        } else {
            Iterator<GTRecipe> iterator = getRecipeType().searchRecipe(this, recipe -> RecipeHelper.getRecipeEUtTier(recipe) <= getOverclockTier() && RecipeRunnerHelper.matchRecipe(this, recipe) && RecipeRunnerHelper.checkConditions(this, recipe));
            while (iterator.hasNext()) {
                GTRecipe recipe = iterator.next();
                if (recipe != null) {
                    if (isRepeatedRecipes() || !lastRecipes.contains(recipe)) {
                        GTRecipe modify = modifyRecipe(recipe.copy());
                        if (modify != null) {
                            if (getRecipeLogic().gTECore$isLockRecipe()) originRecipes.add(recipe);
                            if (lastParallel == getRealParallel()) lastMatchRecipe = recipe;
                            return modify;
                        }
                    }
                }
            }
        }
        return null;
    }

    private GTRecipe modifyRecipe(GTRecipe recipe) {
        setDistinctState(true);
        recipe.conditions.clear();
        recipe = fullModifyRecipe(recipe);
        if (recipe != null && (recipe.parallels > 1 || RecipeRunnerHelper.matchRecipeInput(this, recipe)) && RecipeRunnerHelper.handleRecipeInput(this, recipe)) {
            recipe.ocLevel = getTier() - RecipeHelper.getRecipeEUtTier(recipe);
            recipe.inputs.clear();
            lastParallel = recipe.parallels;
            setDistinctState(false);
            return recipe;
        }
        setDistinctState(false);
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CrossRecipeLogic(this, this::getRecipe);
    }

    @NotNull
    @Override
    public CrossRecipeLogic getRecipeLogic() {
        return (CrossRecipeLogic) super.getRecipeLogic();
    }

    @Override
    @Nullable
    public GTRecipe fullModifyRecipe(@NotNull GTRecipe recipe) {
        for (MultiblockTrait trait : getMultiblockTraits()) {
            recipe = trait.modifyRecipe(recipe);
            if (recipe == null) return null;
        }
        return doModifyRecipe(recipe);
    }

    @Override
    public GTRecipe getRealRecipe(@NotNull GTRecipe recipe) {
        return GTERecipeModifiers.accurateParallel(this, recipe, getRealParallel());
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        if (!isFormed()) return;
        if (!isActive()) return;
        for (GTRecipe recipe : lastRecipes) {
            textList.add(Component.translatable("gtceu.top.recipe_output"));
            int recipeTier = RecipeHelper.getPreOCRecipeEuTier(recipe);
            int chanceTier = recipeTier + recipe.ocLevel;
            var function = recipe.getType().getChanceFunction();
            double maxDurationSec = (double) recipe.duration / 20.0;
            var itemOutputs = recipe.getOutputContents(ItemRecipeCapability.CAP);
            var fluidOutputs = recipe.getOutputContents(FluidRecipeCapability.CAP);
            for (var item : itemOutputs) {
                ItemStack stack = ItemUtils.getFirst(ItemRecipeCapability.CAP.of(item.content));
                if (stack.isEmpty()) continue;
                int count = stack.getCount();
                double countD = count;
                if (item.chance < item.maxChance) {
                    countD = countD * recipe.parallels *
                            function.getBoostedChance(item, recipeTier, chanceTier) / item.maxChance;
                    count = countD < 1 ? 1 : (int) Math.round(countD);
                }
                if (count < maxDurationSec) {
                    String key = "gtceu.multiblock.output_line." + (item.chance < item.maxChance ? "2" : "0");
                    textList.add(Component.translatable(key, stack.getHoverName(), count,
                            FormattingUtil.formatNumber2Places(maxDurationSec / countD)));
                } else {
                    String key = "gtceu.multiblock.output_line." + (item.chance < item.maxChance ? "3" : "1");
                    textList.add(Component.translatable(key, stack.getHoverName(), count,
                            FormattingUtil.formatNumber2Places(countD / maxDurationSec)));
                }
            }
            for (var fluid : fluidOutputs) {
                var stacks = FluidRecipeCapability.CAP.of(fluid.content).getStacks();
                if (stacks.length == 0) continue;
                var stack = stacks[0];
                int amount = stack.getAmount();
                double amountD = amount;
                if (fluid.chance < fluid.maxChance) {
                    amountD = amountD * recipe.parallels *
                            function.getBoostedChance(fluid, recipeTier, chanceTier) / fluid.maxChance;
                    amount = amountD < 1 ? 1 : (int) Math.round(amountD);
                }
                if (amount < maxDurationSec) {
                    String key = "gtceu.multiblock.output_line." + (fluid.chance < fluid.maxChance ? "2" : "0");
                    textList.add(Component.translatable(key, stack.getDisplayName(), amount,
                            FormattingUtil.formatNumber2Places(maxDurationSec / amountD)));
                } else {
                    String key = "gtceu.multiblock.output_line." + (fluid.chance < fluid.maxChance ? "3" : "1");
                    textList.add(Component.translatable(key, stack.getDisplayName(), amount,
                            FormattingUtil.formatNumber2Places(amountD / maxDurationSec)));
                }
            }
        }
    }

    @Override
    public void onPartScan(@NotNull IMultiPart part) {
        super.onPartScan(part);
        if (threadHatchPartMachine == null && part instanceof ThreadHatchPartMachine threadHatchPart) {
            threadHatchPartMachine = threadHatchPart;
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        threadHatchPartMachine = null;
    }

    @Override
    public int getMaxParallel() {
        return customParallelTrait.getMaxParallel();
    }

    @Override
    public int getParallel() {
        if (isHatchParallel) return 0;
        return customParallelTrait.getParallel();
    }

    @Override
    public void setParallel(int number) {
        customParallelTrait.setParallel(number);
    }

    private int getRealParallel() {
        return isHatchParallel ? getMaxParallel() : getParallel();
    }

    public static class CrossRecipeLogic extends CustomRecipeLogic {

        private CrossRecipeLogic(IRecipeLogicMachine machine, Supplier<GTRecipe> recipeSupplier) {
            super(machine, recipeSupplier);
        }

        @Override
        public CrossRecipeMultiblockMachine getMachine() {
            return (CrossRecipeMultiblockMachine) super.getMachine();
        }

        @Override
        public boolean canLockRecipe() {
            return true;
        }

        @Override
        public void gTECore$setLockRecipe(boolean look) {
            super.gTECore$setLockRecipe(look);
            getMachine().originRecipes.clear();
        }

        @Override
        public int gtecore$getlastParallel() {
            return getMachine().lastparallel;
        }

        @Override
        protected ActionResult handleRecipeIO(GTRecipe recipe, IO io) {
            if (io == IO.OUT) {
                if (GTEConfig.INSTANCE.asyncRecipeOutput && machine instanceof IMEOutputMachine outputMachine && outputMachine.gTECore$DualMEOutput(getMachine().hasItem, getMachine().hasFluid)) {
                    Set<GTRecipe> recipes = new HashSet<>(getMachine().lastRecipes);
                    AsyncRecipeOutputTask.addAsyncLogic(this, () -> output(recipes));
                } else {
                    output(getMachine().lastRecipes);
                }
                getMachine().lastRecipes.clear();
                return ActionResult.SUCCESS;
            }
            if (RecipeRunnerHelper.handleRecipeInput(machine, recipe)) {
                return ActionResult.SUCCESS;
            }
            return ActionResult.FAIL_NO_REASON;
        }

        private void output(Set<GTRecipe> recipes) {
            for (GTRecipe recipe : recipes) {
                RecipeRunnerHelper.handleRecipeOutput(this.machine, recipe);
            }
        }
    }
}
