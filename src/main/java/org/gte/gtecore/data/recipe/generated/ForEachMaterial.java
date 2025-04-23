package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.data.recipe.generated.DecompositionRecipeHandler;
import com.gregtechceu.gtceu.data.recipe.generated.PolarizingRecipeHandler;
import com.gregtechceu.gtceu.data.recipe.generated.ToolRecipeHandler;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public interface ForEachMaterial {

    static void init(Consumer<FinishedRecipe> consumer) {
        for (Material material : GTCEuAPI.materialManager.getRegisteredMaterials()) {
            if (material.hasFlag(MaterialFlags.NO_UNIFICATION)) {
                continue;
            }

            DecompositionRecipeHandler.run(consumer, material);
            if (!material.hasProperty(PropertyKey.DUST)) continue;
            ToolRecipeHandler.run(consumer, material);
            PolarizingRecipeHandler.run(consumer, material);
            GTEMaterialRecipeHandler.run(consumer, material);
            GTEOreRecipeHandler.run(consumer, material);
            GTEPartsRecipeHandler.run(consumer, material);
            GTEPipeRecipeHandler.run(consumer, material);
            GTERecyclingRecipeHandler.run(consumer, material);
            GTEWireCombiningHandler.run(material);
            GTEWireRecipeHandler.run(consumer, material);
            GTEDisposableToolHandler.run(material);
        }
    }
}
