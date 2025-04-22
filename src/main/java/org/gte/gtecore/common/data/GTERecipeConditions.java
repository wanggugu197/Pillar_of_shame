package org.gte.gtecore.common.data;

import org.gte.gtecore.common.recipe.condition.*;

import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public interface GTERecipeConditions {

    RecipeConditionType<GravityCondition> GRAVITY = GTRegistries.RECIPE_CONDITIONS.register("gravity",
            new RecipeConditionType<>(GravityCondition::new, GravityCondition.CODEC));

    RecipeConditionType<VacuumCondition> VACUUM = GTRegistries.RECIPE_CONDITIONS.register("vacuum",
            new RecipeConditionType<>(VacuumCondition::new, VacuumCondition.CODEC));

    RecipeConditionType<RestrictedMachineCondition> RESTRICTED_MACHINE = GTRegistries.RECIPE_CONDITIONS.register("restricted_machine",
            new RecipeConditionType<>(RestrictedMachineCondition::new, RestrictedMachineCondition.CODEC));

    RecipeConditionType<HeatCondition> HEAT = GTRegistries.RECIPE_CONDITIONS.register("heat",
            new RecipeConditionType<>(HeatCondition::new, HeatCondition.CODEC));

    RecipeConditionType<RunLimitCondition> RUN_LIMIT = GTRegistries.RECIPE_CONDITIONS.register("run_limit",
            new RecipeConditionType<>(RunLimitCondition::new, RunLimitCondition.CODEC));

    static void init() {}
}
