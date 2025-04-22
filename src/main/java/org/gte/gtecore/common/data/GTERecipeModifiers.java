package org.gte.gtecore.common.data;

import org.gte.gtecore.api.capability.recipe.ManaRecipeCapability;
import org.gte.gtecore.api.machine.feature.IOverclockConfigMachine;
import org.gte.gtecore.api.machine.feature.IPowerAmplifierMachine;
import org.gte.gtecore.api.machine.feature.IUpgradeMachine;
import org.gte.gtecore.api.machine.feature.multiblock.ICoilMachine;
import org.gte.gtecore.api.machine.trait.IEnhancedRecipeLogic;
import org.gte.gtecore.api.recipe.*;
import org.gte.gtecore.common.machine.multiblock.generator.GeneratorArrayMachine;
import org.gte.gtecore.utils.GTEUtils;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeCapabilityHolder;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.SimpleGeneratorMachine;
import com.gregtechceu.gtceu.api.machine.feature.IOverclockMachine;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.LargeBoilerMachine;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
public interface GTERecipeModifiers {

    GTERecipeModifier PARALLELIZABLE_OVERCLOCK = new GTERecipeModifierList((machine, recipe) -> overclocking(machine, hatchParallel(machine, recipe)));
    GTERecipeModifier PARALLELIZABLE_PERFECT_OVERCLOCK = new GTERecipeModifierList((machine, recipe) -> perfectOverclocking(machine, hatchParallel(machine, recipe)));

    GTERecipeModifier GCYM_OVERCLOCKING = new GTERecipeModifierList((machine, recipe) -> overclocking(machine, hatchParallel(machine, recipe), false, false, 0.8, 0.6));

    Set<GTERecipeModifier> TRY_AGAIN = Set.of(PARALLELIZABLE_OVERCLOCK, PARALLELIZABLE_PERFECT_OVERCLOCK, GCYM_OVERCLOCKING);

    GTERecipeModifier GENERATOR_OVERCLOCKING = GTERecipeModifiers::generatorOverclocking;
    GTERecipeModifier PERFECT_OVERCLOCKING = GTERecipeModifiers::perfectOverclocking;
    GTERecipeModifier OVERCLOCKING = GTERecipeModifiers::overclocking;

    GTERecipeModifier HATCH_PARALLEL = GTERecipeModifiers::hatchParallel;

    GTERecipeModifier SIMPLE_GENERATOR_MACHINEMODIFIER = (machine, recipe) -> {
        if (machine instanceof SimpleGeneratorMachine generator) {
            var EUt = RecipeHelper.getOutputEUt(recipe);
            if (EUt > 0) {
                recipe = accurateParallel(machine, recipe, (int) (generator.getOverclockVoltage() / EUt));
                recipe.duration = recipe.duration * GeneratorArrayMachine.getEfficiency(generator.getRecipeType(), generator.getTier()) / 100;
                if (recipe.duration < 1) return null;
                return recipe;
            }
            return recipe;
        }
        return null;
    };

    GTERecipeModifier LARGE_BOILER_MODIFIER = (machine, recipe) -> {
        if (machine instanceof LargeBoilerMachine largeBoilerMachine) {
            int temperature = recipe.data.getInt("temperature");
            if (temperature > 0 && largeBoilerMachine.getCurrentTemperature() < temperature) return null;
            double duration = recipe.duration * 1600.0D / largeBoilerMachine.maxTemperature;
            if (duration < 1) {
                recipe = accurateParallel(machine, recipe, (int) (1 / duration));
            }
            if (largeBoilerMachine.getThrottle() < 100) {
                duration = duration * 100 / largeBoilerMachine.getThrottle();
            }
            recipe.duration = (int) duration;
        }
        return recipe;
    };

    GTERecipeModifier LARGE_CHEMICAL_OROVERCLOCK = (machine, recipe) -> {
        if (machine instanceof WorkableElectricMultiblockMachine multiblockMachine && multiblockMachine.getMultiblockState().getMatchContext().get("CoilType") instanceof ICoilType coil && coil.getTier() >= multiblockMachine.getTier()) {
            return perfectOverclocking(machine, recipe);
        }
        return overclocking(machine, recipe);
    };

    static GTERecipeModifier overclocking(boolean perfect, double reductionEUt, double reductionDuration) {
        return (machine, recipe) -> overclocking(machine, recipe, perfect, false, reductionEUt, reductionDuration);
    }

    static GTERecipeModifier accurateParallel(int parallel) {
        return (machine, recipe) -> accurateParallel(machine, recipe, parallel);
    }

    static GTERecipeModifier recipeReduction(double reductionEUt, double reductionDuration) {
        return (machine, recipe) -> recipeReduction(machine, recipe, reductionEUt, reductionDuration);
    }

    static GTERecipeModifier coilReductionOverclock(boolean perfect) {
        return (machine, recipe) -> {
            if (machine instanceof ICoilMachine coilMachine) {
                return overclocking(machine, hatchParallel(machine, recipe), perfect, false, (1.0 - coilMachine.getCoilTier() * 0.05), (1.0 - coilMachine.getCoilTier() * 0.05));
            }
            return null;
        };
    }

    static GTRecipe crackerOverclock(MetaMachine machine, GTRecipe recipe) {
        if (machine instanceof ICoilMachine coilMachine) {
            return overclocking(machine, recipe, false, false, (1.0 - coilMachine.getCoilTier() * 0.1), 1);
        }
        return null;
    }

    static GTRecipe pyrolyseOvenOverclock(MetaMachine machine, GTRecipe recipe) {
        if (machine instanceof ICoilMachine coilMachine) {
            if (coilMachine.getCoilTier() == 0) {
                return overclocking(machine, recipe, false, false, 1, 1.33);
            } else {
                return overclocking(machine, recipe, false, false, 1, 2.0 / (coilMachine.getCoilTier() + 1));
            }
        }
        return null;
    }

    static GTRecipe ebfOverclock(MetaMachine machine, GTRecipe recipe) {
        if (machine instanceof ICoilMachine coilMachine && machine instanceof IOverclockMachine overclockMachine) {
            int temperature = coilMachine.getCoilType().getCoilTemperature() + (100 * Math.max(0, ((WorkableElectricMultiblockMachine) coilMachine).getTier() - GTValues.MV));
            int recipeTemp = recipe.data.getInt("ebf_temp");
            if (recipeTemp > temperature) return null;
            long recipeVoltage = (long) (RecipeHelper.getInputEUt(recipe) * OverclockingLogic.getCoilEUtDiscount(recipeTemp, temperature));
            int duration = recipe.duration;
            if (machine instanceof IUpgradeMachine upgradeMachine) {
                recipeVoltage = (long) (recipeVoltage * upgradeMachine.gtecore$getEnergy());
                duration = (int) (duration * upgradeMachine.gtecore$getSpeed());
            }
            if (machine instanceof IPowerAmplifierMachine powerAmplifierMachine) {
                recipeVoltage = (long) (recipeVoltage * powerAmplifierMachine.gtecore$getPowerAmplifier());
                duration = (int) (duration / powerAmplifierMachine.gtecore$getPowerAmplifier());
            }
            long maxVoltage = overclockMachine.getOverclockVoltage();
            int amountPerfectOC = Math.max(0, (temperature - recipeTemp) / 900);
            long overclockVoltage;
            int limit;
            if (machine instanceof IOverclockConfigMachine configMachine) {
                limit = configMachine.gTECore$getOCLimit();
            } else {
                limit = 20;
            }
            int ocLevel = 0;
            while (duration > limit) {
                int factor = amountPerfectOC > 0 ? 1 : 2;
                overclockVoltage = recipeVoltage << factor;
                if (overclockVoltage > maxVoltage) break;
                amountPerfectOC--;
                recipeVoltage = overclockVoltage;
                duration >>= 1;
                ocLevel += factor;
            }
            recipe.ocLevel = ocLevel / 2;
            recipe.duration = duration;
            recipe.tickInputs.put(EURecipeCapability.CAP, List.of(ContentBuilder.builderEU(recipeVoltage)));
        }
        return recipe;
    }

    static GTRecipe hatchParallel(MetaMachine machine, GTRecipe recipe) {
        return accurateParallel(machine, recipe, MachineUtils.getHatchParallel(machine));
    }

    static GTRecipe accurateParallel(MetaMachine machine, GTRecipe recipe, int maxParallel) {
        if (maxParallel > 1 && machine instanceof IRecipeLogicMachine holder && holder.getRecipeLogic() instanceof IEnhancedRecipeLogic logic) {
            if (logic.gtecore$getlastParallel() == maxParallel) {
                GTRecipe copied = recipe.copy(ContentModifier.multiplier(maxParallel), false);
                if (RecipeRunnerHelper.matchRecipe(holder, copied)) {
                    copied.parallels = maxParallel;
                    return copied;
                }
            }
            maxParallel = ParallelLogic.getParallelAmount(machine, recipe, maxParallel);
            logic.gtecore$cleanParallelMap();
            return matchParallel(holder, recipe, maxParallel);
        }
        return recipe;
    }

    private static GTRecipe matchParallel(IRecipeCapabilityHolder holder, GTRecipe recipe, int parallel) {
        if (parallel > 1) {
            GTRecipe copied = recipe.copy(ContentModifier.multiplier(parallel), false);
            if (RecipeRunnerHelper.matchRecipe(holder, copied)) {
                copied.parallels *= parallel;
                return copied;
            } else {
                return matchParallel(holder, recipe, parallel / 2);
            }
        }
        return recipe;
    }

    static GTRecipe recipeReduction(MetaMachine machine, GTRecipe recipe, double reductionEUt, double reductionDuration) {
        if (reductionEUt != 1) {
            recipe.tickInputs.put(EURecipeCapability.CAP, List.of(ContentBuilder.builderEU((long) Math.max(1, RecipeHelper.getInputEUt(recipe) * reductionEUt))));
        }
        if (reductionDuration != 1) {
            recipe.duration = (int) Math.max(1, recipe.duration * reductionDuration);
        }
        return recipe;
    }

    static GTRecipe laserLossOverclocking(MetaMachine machine, @Nullable GTRecipe recipe) {
        return overclocking(machine, recipe, false, true, false, 1, 1);
    }

    static GTRecipe generatorOverclocking(MetaMachine machine, @Nullable GTRecipe recipe) {
        return overclocking(machine, recipe, true, true, 1, 1);
    }

    static GTRecipe perfectOverclocking(MetaMachine machine, @Nullable GTRecipe recipe) {
        return overclocking(machine, recipe, true, false, 1, 1);
    }

    static GTRecipe overclocking(MetaMachine machine, @Nullable GTRecipe recipe) {
        double reductionEUt = 1;
        double reductionDuration = 1;
        if (machine instanceof IUpgradeMachine upgradeMachine) {
            reductionEUt = reductionEUt * upgradeMachine.gtecore$getEnergy();
            reductionDuration = reductionDuration * upgradeMachine.gtecore$getSpeed();
        }
        return overclocking(machine, recipe, false, false, reductionEUt, reductionDuration);
    }

    static GTRecipe overclocking(MetaMachine machine, @Nullable GTRecipe recipe, boolean perfect, boolean generator, double reductionEUt, double reductionDuration) {
        return overclocking(machine, recipe, perfect, false, generator, reductionEUt, reductionDuration);
    }

    static GTRecipe overclocking(MetaMachine machine, @Nullable GTRecipe recipe, boolean perfect, boolean laserLoss, boolean generator, double reductionEUt, double reductionDuration) {
        if (machine instanceof IOverclockMachine overclockMachine) {
            if (machine instanceof IPowerAmplifierMachine powerAmplifierMachine) {
                reductionEUt = reductionEUt * powerAmplifierMachine.gtecore$getPowerAmplifier();
                reductionDuration = reductionDuration / powerAmplifierMachine.gtecore$getPowerAmplifier();
            }
            long recipeVoltage = (long) ((generator ? RecipeHelper.getOutputEUt(recipe) : RecipeHelper.getInputEUt(recipe)) * reductionEUt);
            return overclocking(machine, recipe, recipeVoltage, overclockMachine.getOverclockVoltage(), perfect, laserLoss, generator, reductionDuration);
        }
        return recipe;
    }

    static GTRecipe overclocking(MetaMachine machine, @Nullable GTRecipe recipe, long recipeVoltage, long maxVoltage, boolean perfect, boolean laserLoss, boolean generator, double reductionDuration) {
        if (recipe instanceof IGTRecipe igtRecipe) {
            int duration = (int) (recipe.duration * reductionDuration);
            int factor = (perfect || igtRecipe.gtecore$perfect()) ? 1 : 2;
            int limit;
            if (machine instanceof IOverclockConfigMachine configMachine) {
                limit = configMachine.gTECore$getOCLimit();
            } else {
                limit = 2;
            }
            int ocLevel = 0;
            while (duration > limit) {
                long overclockVoltage = recipeVoltage << factor;
                if (overclockVoltage > maxVoltage) break;
                if (laserLoss) duration = duration * 5 / 4;
                recipeVoltage = overclockVoltage;
                duration >>= 1;
                ocLevel += factor;
            }
            recipe.ocLevel = ocLevel / 2;
            recipe.duration = duration;
            List<Content> content = List.of(ContentBuilder.builderEU(recipeVoltage));
            if (generator) {
                recipe.tickOutputs.put(EURecipeCapability.CAP, content);
            } else {
                recipe.tickInputs.put(EURecipeCapability.CAP, content);
            }
        }
        return recipe;
    }

    static GTRecipe externalEnergyOverclocking(MetaMachine machine, @Nullable GTRecipe recipe, long recipeVoltage, long maxVoltage, boolean perfect, double reductionEUt, double reductionDuration) {
        return overclocking(machine, recipe, recipeVoltage, (long) (maxVoltage * reductionEUt), perfect, false, false, reductionDuration);
    }

    static GTRecipe manaOverclocking(MetaMachine machine, @Nullable GTRecipe recipe, long maxMana, boolean perfect, double reductionManat, double reductionDuration) {
        if (recipe != null) {
            long recipeMana = GTEUtils.getInputMANAt(recipe);
            int duration = (int) (recipe.duration * reductionDuration);
            int factor = perfect ? 1 : 2;
            int limit;
            if (machine instanceof IOverclockConfigMachine configMachine) {
                limit = configMachine.gTECore$getOCLimit();
            } else {
                limit = 20;
            }
            int ocLevel = 0;
            while (duration > limit) {
                long overclockVoltage = recipeMana << factor;
                if (overclockVoltage > maxMana) break;
                recipeMana = overclockVoltage;
                duration >>= 1;
                ocLevel += factor;
            }
            recipe.ocLevel = ocLevel / 2;
            recipe.duration = duration;
            List<Content> content = List.of(ContentBuilder.builderEU(recipeMana));
            recipe.tickInputs.put(ManaRecipeCapability.CAP, content);
        }
        return recipe;
    }

    class Overclocking implements OverclockingLogic {

        private final boolean perfect;

        public Overclocking(boolean perfect) {
            this.perfect = perfect;
        }

        @Override
        public OCResult runOverclockingLogic(OCParams ocParams, long maxVoltage) {
            int duration = ocParams.duration();
            long recipeVoltage = ocParams.eut();
            int factor = perfect ? 1 : 2;
            int ocLevel = 0;
            while (duration > 2) {
                long overclockVoltage = recipeVoltage << factor;
                if (overclockVoltage > maxVoltage) break;
                recipeVoltage = overclockVoltage;
                duration >>= 1;
                ocLevel += factor;
            }
            return new OCResult((double) recipeVoltage / ocParams.eut(), (double) duration / ocParams.duration(), ocLevel / 2, ocParams.maxParallels());
        }
    }
}
