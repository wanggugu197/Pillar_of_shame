package org.gte.gtecore.data.recipe.generated;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeCategories;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.fluids.FluidStack;

import com.tterrag.registrate.util.entry.BlockEntry;

import static org.gte.gtecore.common.data.GTERecipeTypes.*;

public interface GlassRecipe {

    static void init() {
        ALLOY_SMELTER_RECIPES.recipeBuilder(GTECore.id("borosilicate_glass"))
                .inputItems(TagPrefix.block, GTMaterials.BorosilicateGlass)
                .notConsumable(GTItems.SHAPE_MOLD_BLOCK)
                .outputItems(GTEBlocks.BOROSILICATE_GLASS.asItem())
                .category(GTRecipeCategories.INGOT_MOLDING)
                .EUt(30)
                .duration(200)
                .save();

        addGlass(GTValues.EV, GTMaterials.Titanium, GTEBlocks.TITANIUM_BOROSILICATE_GLASS);
        addGlass(GTValues.IV, GTMaterials.Tungsten, GTEBlocks.TUNGSTEN_BOROSILICATE_GLASS);
        addGlass(GTValues.LuV, GTMaterials.HSSS, GTEBlocks.HSSS_BOROSILICATE_GLASS);
        addGlass(GTValues.ZPM, GTMaterials.Naquadah, GTEBlocks.NAQUADAH_BOROSILICATE_GLASS);
        addGlass(GTValues.UV, GTMaterials.Tritanium, GTEBlocks.TRITANIUM_BOROSILICATE_GLASS);
        addGlass(GTValues.UHV, GTMaterials.Neutronium, GTEBlocks.AMPROSIUM_BOROSILICATE_GLASS);
        addGlass(GTValues.UEV, GTEMaterials.Enderium, GTEBlocks.ENDERIUM_BOROSILICATE_GLASS);
        addGlass(GTValues.UIV, GTEMaterials.Taranium, GTEBlocks.TARANIUM_BOROSILICATE_GLASS);
        addGlass(GTValues.UXV, GTEMaterials.HeavyQuarkDegenerateMatter, GTEBlocks.QUARKS_BOROSILICATE_GLASS);
        addGlass(GTValues.OpV, GTEMaterials.Draconium, GTEBlocks.DRACONIUM_BOROSILICATE_GLASS);
        addGlass(GTValues.MAX, GTEMaterials.CosmicNeutronium, GTEBlocks.COSMIC_NEUTRONIUM_BOROSILICATE_GLASS);
    }

    private static void addGlass(int tier, Material material, BlockEntry<Block> block) {
        FluidStack fluidStack = material.getFluid(1152);
        FLUID_SOLIDFICATION_RECIPES.recipeBuilder(GTECore.id("borosilicate_glass_" + material.getName()))
                .inputItems(GTEBlocks.BOROSILICATE_GLASS.asItem())
                .inputFluids(fluidStack)
                .outputItems(block.asItem())
                .EUt(GTValues.VA[tier])
                .duration(200)
                .save();

        LIQUEFACTION_FURNACE_RECIPES.recipeBuilder(GTECore.id("borosilicate_glass_" + material.getName()))
                .inputItems(block.asItem())
                .outputFluids(fluidStack)
                .EUt(GTValues.VA[tier])
                .duration(200)
                .blastFurnaceTemp(Math.max(800, (int) (material.getBlastTemperature() * 0.6)))
                .save();
    }
}
