package org.gte.gtecore.data;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.machine.IMultiblockMachineDefinition;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.common.data.GTELoots;
import org.gte.gtecore.common.data.GTERecipeTypes;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.data.recipe.*;
import org.gte.gtecore.data.recipe.classified.$ClassifiedRecipe;
import org.gte.gtecore.data.recipe.generated.*;
import org.gte.gtecore.data.recipe.generated.ComponentRecipes;
import org.gte.gtecore.data.recipe.mod.ImmersiveAircraft;
import org.gte.gtecore.data.recipe.processing.*;
import org.gte.gtecore.integration.emi.GTEMIRecipe;
import org.gte.gtecore.integration.emi.multipage.MultiblockInfoEmiRecipe;
import org.gte.gtecore.utils.RegistriesUtils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.ItemMaterialData;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.category.GTRecipeCategory;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.pack.GTDynamicDataPack;
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents;
import com.gregtechceu.gtceu.data.recipe.MaterialInfoLoader;
import com.gregtechceu.gtceu.data.recipe.configurable.RecipeAddition;
import com.gregtechceu.gtceu.data.recipe.misc.*;
import com.gregtechceu.gtceu.data.recipe.serialized.chemistry.ChemistryRecipes;
import com.gregtechceu.gtceu.integration.emi.recipe.GTRecipeEMICategory;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.block.Block;

import com.google.common.collect.ImmutableSet;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.config.EmiConfig;
import dev.emi.emi.config.SidebarSide;
import dev.emi.emi.recipe.special.EmiRepairItemRecipe;
import dev.shadowsoffire.placebo.loot.LootSystem;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.Set;
import java.util.function.Consumer;

import static org.gte.gtecore.common.data.GTERecipes.*;

public interface Data {

    static void init() {
        long time = System.currentTimeMillis();

        ItemMaterialData.reinitializeMaterialData();
        MaterialInfoLoader.init();
        GTCraftingComponents.init();
        GTERecipeBuilder.initialization();
        RecipeFilter.init();
        Consumer<FinishedRecipe> consumer = GTDynamicDataPack::addRecipe;

        BlastProperty.GasTier.LOW.setFluid(() -> FluidIngredient.of(GTMaterials.Nitrogen.getFluid(1000)));
        BlastProperty.GasTier.MID.setFluid(() -> FluidIngredient.of(GTMaterials.Helium.getFluid(100)));
        BlastProperty.GasTier.HIGH.setFluid(() -> FluidIngredient.of(GTMaterials.Argon.getFluid(100)));
        BlastProperty.GasTier.HIGHER.setFluid(() -> FluidIngredient.of(GTMaterials.Neon.getFluid(100)));
        BlastProperty.GasTier.HIGHEST.setFluid(() -> FluidIngredient.of(GTMaterials.Krypton.getFluid(100)));

        CustomToolRecipes.init(consumer);
        ChemistryRecipes.init(consumer);
        MetaTileEntityMachineRecipeLoader.init(consumer);
        MiscRecipeLoader.init(consumer);
        VanillaStandardRecipes.init(consumer);
        WoodMachineRecipes.init(consumer);
        StoneMachineRecipes.init(consumer);
        CraftingRecipeLoader.init(consumer);
        FusionLoader.init(consumer);
        MachineRecipeLoader.init(consumer);
        AssemblerRecipeLoader.init(consumer);
        AssemblyLineLoader.init(consumer);
        BatteryRecipes.init(consumer);
        DecorationRecipes.init(consumer);

        CircuitRecipes.init(consumer);
        MetaTileEntityLoader.init(consumer);

        GCYMRecipes.init(consumer);
        RecipeAddition.init(consumer);
        SHAPED_FILTER_RECIPES = null;
        SHAPELESS_FILTER_RECIPES = null;

        ForEachMaterial.init(consumer);

        // GTE
        GTMTRecipe.init(consumer);
        GCYRecipes.init(consumer);
        MachineRecipe.init(consumer);
        ComponentRecipes.init(consumer);
        MiscRecipe.init(consumer);
        FuelRecipe.init();
        BrineRecipes.init();
        NaquadahProcess.init();
        PlatGroupMetals.init();
        ElementCopying.init();
        StoneDustProcess.init();
        Lanthanidetreatment.init();
        NewResearchSystem.init();
        RadiationHatchRecipes.init();
        PetrochemRecipes.init();
        GlassRecipe.init();
        DyeRecipes.init();
        WoodRecipes.init();
        ImmersiveAircraft.init(consumer);
        $ClassifiedRecipe.init(consumer);
        GenerateDisassembly.DISASSEMBLY_RECORD.clear();
        GenerateDisassembly.DISASSEMBLY_BLACKLIST.clear();
        RecyclingRecipes.init(consumer);
        ItemMaterialData.ITEM_MATERIAL_INFO.clear();
        GTERecipeBuilder.clean();
        LootSystem.defaultBlockTable(RegistriesUtils.getBlock("farmersrespite:kettle"));
        GTELoots.BLOCKS.forEach(b -> LootSystem.defaultBlockTable((Block) b));
        GTELoots.BLOCKS = null;
        GTECore.LOGGER.info("Data loading took {}ms", System.currentTimeMillis() - time);
    }

    static void asyncInit() {
        init();
        GTERecipeBuilder.RECIPE_MAP.values().forEach(recipe -> recipe.recipeCategory.addRecipe(recipe));
        if (GTCEu.Mods.isEMILoaded()) {
            IMultiblockMachineDefinition.init();
            long time = System.currentTimeMillis();
            EmiConfig.logUntranslatedTags = false;
            EmiConfig.workstationLocation = SidebarSide.LEFT;
            EmiRepairItemRecipe.TOOLS.clear();
            EMI_RECIPE_WIDGETS = new Object2ObjectOpenHashMap<>();
            ImmutableSet.Builder<EmiRecipe> recipes = ImmutableSet.builder();
            for (GTRecipeCategory category : GTRegistries.RECIPE_CATEGORIES) {
                if (!category.shouldRegisterDisplays()) continue;
                var type = category.getRecipeType();
                if (category == type.getCategory()) type.buildRepresentativeRecipes();
                EmiRecipeCategory emiCategory = GTRecipeEMICategory.CATEGORIES.apply(category);
                type.getRecipesInCategory(category).stream().map(recipe -> new GTEMIRecipe(recipe, emiCategory)).forEach(recipes::add);
            }
            for (MachineDefinition machine : GTRegistries.MACHINES.values()) {
                if (machine instanceof MultiblockMachineDefinition definition && definition.isRenderXEIPreview()) {
                    recipes.add(new MultiblockInfoEmiRecipe(definition));
                }
            }
            EMI_RECIPE_WIDGETS = null;
            EMI_RECIPES = recipes.build();
            if (!GTEConfig.INSTANCE.recipeCheck) {
                for (GTRecipeType type : GTRegistries.RECIPE_TYPES) {
                    if (type == GTERecipeTypes.FURNACE_RECIPES) {
                        type.getCategoryMap().putIfAbsent(GTRecipeTypes.FURNACE_RECIPES.getCategory(), Set.of());
                    } else {
                        type.getCategoryMap().replaceAll((k, v) -> Set.of());
                    }
                }
            }
            GTECore.LOGGER.info("Pre initialization EMI GTRecipe took {}ms", System.currentTimeMillis() - time);
        }
    }
}
