package org.gte.gtecore.common.recipe;

import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.data.GTERecipeTypes;
import org.gte.gtecore.data.recipe.classified.ManaSimulator;
import org.gte.gtecore.data.recipe.generated.GenerateDisassembly;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.gregtechceu.gtceu.utils.ResearchManager;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.level.material.Fluid;

import java.util.Collections;

import static com.gregtechceu.gtceu.api.GTValues.MV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static org.gte.gtecore.common.data.GTERecipeTypes.*;

public final class RecipeTypeModify {

    private RecipeTypeModify() {}

    private static final CuttingFluid[] FLUID_TIERS = new CuttingFluid[] {
            new CuttingFluid(GTMaterials.Water.getFluid(), 60),
            new CuttingFluid(GTMaterials.Lubricant.getFluid(), 2880),
            new CuttingFluid(GTEMaterials.FilteredSater.getFluid(), 3840),
            new CuttingFluid(GTEMaterials.OzoneWater.getFluid(), 15360),
            new CuttingFluid(GTEMaterials.FlocculentWater.getFluid(), 61440),
            new CuttingFluid(GTEMaterials.PHNeutralWater.getFluid(), 245760),
            new CuttingFluid(GTEMaterials.ExtremeTemperatureWater.getFluid(), 983040),
            new CuttingFluid(GTEMaterials.ElectricEquilibriumWater.getFluid(), 3932160),
            new CuttingFluid(GTEMaterials.DegassedWater.getFluid(), 15728640),
            new CuttingFluid(GTEMaterials.BaryonicPerfectionWater.getFluid(), 62914560)
    };

    public static void init() {
        COMBUSTION_GENERATOR_FUELS.setMaxIOSize(0, 0, 2, 0);
        GAS_TURBINE_FUELS.setMaxIOSize(0, 0, 2, 0);
        DUMMY_RECIPES.setMaxIOSize(1, 1, 1, 1);
        WIREMILL_RECIPES.setMaxIOSize(1, 1, 0, 0);

        SIFTER_RECIPES.setMaxIOSize(1, 6, 1, 0);

        CHEMICAL_RECIPES.onRecipeBuild((r, p) -> {});

        ASSEMBLY_LINE_RECIPES.onRecipeBuild((recipeBuilder, provider) -> {
            ResearchManager.createDefaultResearchRecipe(recipeBuilder, provider);
            GenerateDisassembly.generateDisassembly(recipeBuilder, provider);
        });

        ASSEMBLER_RECIPES.setMANAIO(IO.IN);
        ASSEMBLER_RECIPES.onRecipeBuild(GenerateDisassembly::generateDisassembly);

        PLASMA_GENERATOR_FUELS.onRecipeBuild((recipeBuilder, provider) -> {
            long eu = recipeBuilder.duration * GTValues.V[GTValues.EV] * 5;
            FluidIngredient output = FluidRecipeCapability.CAP.of(recipeBuilder.output
                    .get(FluidRecipeCapability.CAP).get(0).getContent()).copy();
            FluidIngredient input = FluidRecipeCapability.CAP.of(recipeBuilder.input
                    .get(FluidRecipeCapability.CAP).get(0).getContent());
            output.setAmount(output.getAmount() << 2);
            input.setAmount(input.getAmount() * 5);
            GTERecipeTypes.HEAT_EXCHANGER_RECIPES.recipeBuilder(recipeBuilder.id)
                    .inputFluids(input)
                    .inputFluids(GTMaterials.DistilledWater.getFluid((int) (eu / 160)))
                    .outputFluids(output)
                    .outputFluids(GTEMaterials.HighPressureSteam.getFluid((int) (eu / 4)))
                    .outputFluids(GTEMaterials.SupercriticalSteam.getFluid((int) (eu / 16)))
                    .addData("eu", eu)
                    .duration(200)
                    .save(provider);
        });

        LASER_ENGRAVER_RECIPES.setMaxIOSize(2, 1, 2, 1)
                .onRecipeBuild((recipeBuilder, provider) -> {
                    if (recipeBuilder.data.contains("special")) return;
                    GTRecipeBuilder recipe = GTERecipeTypes.DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES.copyFrom(recipeBuilder)
                            .duration((int) (recipeBuilder.duration * 0.2))
                            .EUt(recipeBuilder.EUt() << 2);
                    double value = Math.log10(recipeBuilder.EUt()) / Math.log10(4);
                    if (value > 10) {
                        recipe.inputFluids(GTEMaterials.EuvPhotoresist.getFluid((int) (value / 2)));
                    } else {
                        recipe.inputFluids(GTEMaterials.Photoresist.getFluid((int) value));
                    }
                    recipe.save(provider);
                });

        CUTTER_RECIPES.onRecipeBuild((recipeBuilder, provider) -> {
            if (recipeBuilder.input.getOrDefault(FluidRecipeCapability.CAP, Collections.emptyList()).isEmpty() &&
                    recipeBuilder.tickInput.getOrDefault(FluidRecipeCapability.CAP, Collections.emptyList()).isEmpty()) {

                int originalDuration = recipeBuilder.duration;
                int index = getEUTierIndex(GTUtil.getTierByVoltage(recipeBuilder.EUt()));

                GTRecipeBuilder builder = recipeBuilder.copy(recipeBuilder.id);
                addCuttingFluid(recipeBuilder, index);
                if (index > 1 && index < FLUID_TIERS.length - 1) {
                    int maxUpgradeTiers = FLUID_TIERS.length - index;

                    for (int upgradeTier = 1; upgradeTier < maxUpgradeTiers; upgradeTier++) {
                        double reductionFactor = Math.pow(0.8, upgradeTier);

                        GTRecipeBuilder upgradedRecipe = builder.copy(builder.id.getPath() + "_upgraded_t" + (index + upgradeTier))
                                .duration((int) Math.max(1, originalDuration * reductionFactor));

                        addUpgradedCuttingFluid(upgradedRecipe, index, index + upgradeTier, originalDuration, builder.EUt(), reductionFactor);
                    }
                }
            }
        });

        CIRCUIT_ASSEMBLER_RECIPES.onRecipeBuild((recipeBuilder, provider) -> {
            if (recipeBuilder.input.getOrDefault(FluidRecipeCapability.CAP, Collections.emptyList()).isEmpty() &&
                    recipeBuilder.tickInput.getOrDefault(FluidRecipeCapability.CAP, Collections.emptyList())
                            .isEmpty()) {
                if (recipeBuilder.EUt() < GTValues.VA[GTValues.HV]) {
                    recipeBuilder.inputFluids(GTMaterials.Tin.getFluid(Math.max(1, 144 * recipeBuilder.getSolderMultiplier())));
                } else if (recipeBuilder.EUt() < GTValues.VA[GTValues.UV]) {
                    recipeBuilder.inputFluids(GTMaterials.SolderingAlloy.getFluid(Math.max(1, 144 * recipeBuilder.getSolderMultiplier())));
                } else if (recipeBuilder.EUt() < GTValues.VA[GTValues.UIV]) {
                    recipeBuilder.inputFluids(GTEMaterials.MutatedLivingSolder.getFluid(Math.max(1, 144 * (GTUtil.getFloorTierByVoltage(recipeBuilder.EUt()) - 6))));
                } else {
                    recipeBuilder.inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(Math.max(1, 144 * (GTUtil.getFloorTierByVoltage(recipeBuilder.EUt()) - 8))));
                }
            }
        });

        STEAM_BOILER_RECIPES.onRecipeBuild((builder, provider) -> {
            GTERecipeTypes.THERMAL_GENERATOR_FUELS.copyFrom(builder)
                    .EUt(-8)
                    .duration((int) Math.sqrt(builder.duration))
                    .save(provider);

            GTERecipeTypes.MANA_SIMULATOR_FUEL.copyFrom(builder)
                    .MANAt(-(int) (1.5 * ManaSimulator.BUFF_FACTOR))
                    .EUt(VA[MV])
                    .duration(builder.duration / 2)
                    .save(provider);
        });

        LARGE_BOILER_RECIPES.addDataInfo(data -> {
            int temperature = data.getInt("temperature");
            if (temperature > 0) {
                return I18n.get("gtceu.multiblock.hpca.temperature", temperature);
            }
            return "";
        });
    }

    private static int getEUTierIndex(int euTier) {
        return switch (euTier) {
            case 0, 1 -> 0;
            case 2, 3 -> 1;
            case 4 -> 2;
            case 5 -> 3;
            case 6 -> 4;
            case 7 -> 5;
            case 8 -> 6;
            case 9 -> 7;
            case 10 -> 8;
            default -> 9;
        };
    }

    private static void addCuttingFluid(GTRecipeBuilder recipeBuilder, int index) {
        CuttingFluid selected = FLUID_TIERS[index];
        int fluidAmount = (int) Math.max(1, recipeBuilder.duration * recipeBuilder.EUt() / selected.divisor());
        recipeBuilder.inputFluids(FluidIngredient.of(fluidAmount, selected.fluid()));
    }

    private static void addUpgradedCuttingFluid(GTRecipeBuilder recipeBuilder, int originalIndex, int index, int originalDuration, long originalEUt, double reductionFactor) {
        CuttingFluid selected = FLUID_TIERS[index];

        int fluidAmount = (int) Math.max(1, originalDuration * originalEUt * reductionFactor / FLUID_TIERS[originalIndex].divisor());

        recipeBuilder.inputFluids(FluidIngredient.of(fluidAmount, selected.fluid()));
        recipeBuilder.save(a -> {});
    }

    private record CuttingFluid(Fluid fluid, int divisor) {}
}
