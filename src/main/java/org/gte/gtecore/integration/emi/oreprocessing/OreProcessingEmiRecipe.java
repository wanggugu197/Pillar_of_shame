package org.gte.gtecore.integration.emi.oreprocessing;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.lowdragmc.lowdraglib.emi.ModularEmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

class OreProcessingEmiRecipe extends ModularEmiRecipe<OreByProductWidget> {

    private final Material material;

    OreProcessingEmiRecipe(Material material) {
        super(() -> new OreByProductWidget(material));
        this.material = material;
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return OreProcessingEmiCategory.CATEGORY;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return material.getResourceLocation();
    }

    @Override
    public boolean supportsRecipeTree() {
        return false;
    }
}
