package org.gte.gtecore.common.machine.multiblock.electric.voidseries;

import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEOres;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Set;

public final class PlanetCoreDrillingMachine extends ElectricMultiblockMachine {

    private Set<Material> materials;

    public PlanetCoreDrillingMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Nullable
    private GTRecipe getRecipe() {
        GTERecipeBuilder builder = GTERecipeBuilder.ofRaw().duration(20).EUt(GTValues.VA[GTValues.MAX]);
        for (Material material : getMaterials()) {
            builder.outputItems(TagPrefix.ore, material, 65536);
        }
        GTRecipe recipe = builder.buildRawRecipe();
        if (RecipeRunnerHelper.matchRecipeTickInput(this, recipe) && RecipeRunnerHelper.matchRecipeOutput(this, recipe)) return recipe;
        return null;
    }

    private Set<Material> getMaterials() {
        if (materials == null) materials = GTEOres.ALL_ORES.get(Objects.requireNonNull(getLevel()).dimension()).keySet();
        return materials;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe, true);
    }
}
