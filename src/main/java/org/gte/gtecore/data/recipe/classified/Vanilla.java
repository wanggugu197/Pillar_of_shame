package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.machines.MultiBlockD;
import org.gte.gtecore.common.data.machines.MultiBlockG;
import org.gte.gtecore.utils.RegistriesUtils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;

import java.util.function.Consumer;

interface Vanilla {

    static void init(Consumer<FinishedRecipe> provider) {
        if (GTCEu.isProd()) {
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("stack_upgrade_tier_1"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_tier_1"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_starter_tier"), GTMachines.SUPER_CHEST[GTValues.MV].getItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("advanced_compacting_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:advanced_compacting_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:compacting_upgrade"), GTItems.ELECTRIC_PISTON_MV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("void_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:void_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), GTItems.COVER_ITEM_VOIDING.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("magnet_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:magnet_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), GTItems.ITEM_MAGNET_LV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("stack_upgrade_tier_2"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_tier_2"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_tier_1"), GTMachines.SUPER_CHEST[GTValues.HV].getItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("advanced_pickup_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:advanced_pickup_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:pickup_upgrade"), GTItems.ITEM_FILTER.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("advanced_refill_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:advanced_refill_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:refill_upgrade"), GTItems.ROBOT_ARM_MV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("tank_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:tank_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), RegistriesUtils.getItemStack("gtceu:bronze_drum"));
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("filter_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:filter_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), GTItems.ITEM_FILTER.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("advanced_magnet_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:advanced_magnet_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:magnet_upgrade"), GTItems.ITEM_MAGNET_HV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("refill_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:refill_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), GTItems.ROBOT_ARM_LV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("advanced_filter_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:advanced_filter_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:filter_upgrade"), GTItems.TAG_FILTER.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("stack_upgrade_starter_tier"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_starter_tier"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), GTMachines.SUPER_CHEST[GTValues.LV].getItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("advanced_void_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:advanced_void_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:void_upgrade"), GTItems.COVER_ITEM_VOIDING_ADVANCED.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("auto_blasting_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:auto_blasting_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:blasting_upgrade"), GTItems.CONVEYOR_MODULE_LV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("stack_upgrade_omega_tier"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_omega_tier"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_tier_4"), GTMachines.QUANTUM_CHEST[GTValues.UHV].getItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("stack_upgrade_tier_4"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_tier_4"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_tier_3"), GTMachines.QUANTUM_CHEST[GTValues.IV].getItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("stack_upgrade_tier_3"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_tier_3"), RegistriesUtils.getItemStack("sophisticatedbackpacks:stack_upgrade_tier_2"), GTMachines.SUPER_CHEST[GTValues.EV].getItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("pump_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:pump_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), GTItems.ELECTRIC_PUMP_LV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("auto_smoking_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:auto_smoking_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:smoking_upgrade"), GTItems.CONVEYOR_MODULE_LV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("compacting_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:compacting_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), GTItems.ELECTRIC_PISTON_LV.asItem());
            VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("pickup_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:pickup_upgrade"), RegistriesUtils.getItemStack("sophisticatedbackpacks:upgrade_base"), GTMachines.ITEM_COLLECTOR[GTValues.LV].getItem());

            VanillaRecipeHelper.addShapedRecipe(provider, GTECore.id("backpack"), RegistriesUtils.getItemStack("sophisticatedbackpacks:backpack"),
                    "ABA",
                    "BCB",
                    "DBD",
                    'A', new MaterialEntry(TagPrefix.screw, GTMaterials.WroughtIron), 'B', new ItemStack(Items.LEATHER.asItem()), 'C', RegistriesUtils.getItemStack("gtceu:wood_crate"), 'D', new ItemStack(Items.STRING.asItem()));

            VanillaRecipeHelper.addShapedRecipe(provider, true, GTECore.id("automatic_chisel"),
                    MultiBlockG.AUTOMATIC_CHISEL.asStack(),
                    "ABA",
                    "CDC",
                    "EFE",
                    'B', RegistriesUtils.getItemStack("chisel:chisel"), 'F', new MaterialEntry(TagPrefix.plateDouble,
                            GTMaterials.SteelMagnetic),
                    'D', GTItems.ROBOT_ARM_LV.asStack(), 'C',
                    GTItems.CONVEYOR_MODULE_LV.asStack(), 'E', new MaterialEntry(TagPrefix.plate, GTMaterials.Steel), 'A',
                    CustomTags.LV_CIRCUITS);

        }
        VanillaRecipeHelper.addSmeltingRecipe(provider, GTECore.id("raw_aluminum"), GTEItems.RAW_ALUMINUM.asStack(), ChemicalHelper.get(TagPrefix.ingot, GTMaterials.Aluminium), 0);
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("pattern_modifier_pro"), GTEItems.PATTERN_MODIFIER_PRO.asStack(), RegistriesUtils.getItemStack("expatternprovider:pattern_modifier"));
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("item_storage_cell_64m_2"), GTEItems.ITEM_STORAGE_CELL_64M.asStack(), new ItemStack(AEItems.ITEM_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_64M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("suprachronal_assembly_line_module"),
                MultiBlockD.SUPRACHRONAL_ASSEMBLY_LINE_MODULE.asStack(), MultiBlockD.SUPRACHRONAL_ASSEMBLY_LINE.getItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("fluid_storage_cell_1m"), GTEItems.FLUID_STORAGE_CELL_1M.asStack(), new ItemStack(AEItems.FLUID_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_1M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("suprachronal_assembly_line"),
                MultiBlockD.SUPRACHRONAL_ASSEMBLY_LINE.asStack(), MultiBlockD.SUPRACHRONAL_ASSEMBLY_LINE_MODULE.getItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("item_storage_cell_256m"), GTEItems.ITEM_STORAGE_CELL_256M.asStack(), new ItemStack(AEItems.ITEM_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_256M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("crafting_storage_4m"), GTEBlocks.CRAFTING_STORAGE_4M.asStack(), new ItemStack(AEBlocks.CRAFTING_UNIT.block().asItem()), GTEItems.CELL_COMPONENT_4M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("fluid_infinity_cell"), GTEItems.FLUID_INFINITY_CELL.asStack(), new ItemStack(AEItems.FLUID_CELL_HOUSING.asItem()), GTEItems.INFINITE_CELL_COMPONENT.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("crafting_storage_16m"), GTEBlocks.CRAFTING_STORAGE_16M.asStack(), new ItemStack(AEBlocks.CRAFTING_UNIT.block().asItem()), GTEItems.CELL_COMPONENT_16M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("crafting_storage_256m"), GTEBlocks.CRAFTING_STORAGE_256M.asStack(), new ItemStack(AEBlocks.CRAFTING_UNIT.block().asItem()), GTEItems.CELL_COMPONENT_256M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("fluid_storage_cell_4m_2"), GTEItems.FLUID_STORAGE_CELL_4M.asStack(), new ItemStack(AEItems.FLUID_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_4M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("item_storage_cell_4m_2"), GTEItems.ITEM_STORAGE_CELL_4M.asStack(), new ItemStack(AEItems.ITEM_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_4M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("crafting_storage_64m"), GTEBlocks.CRAFTING_STORAGE_64M.asStack(), new ItemStack(AEBlocks.CRAFTING_UNIT.block().asItem()), GTEItems.CELL_COMPONENT_64M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("item_infinity_cell"), GTEItems.ITEM_INFINITY_CELL.asStack(), new ItemStack(AEItems.ITEM_CELL_HOUSING.asItem()), GTEItems.INFINITE_CELL_COMPONENT.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("fluid_storage_cell_16m"), GTEItems.FLUID_STORAGE_CELL_16M.asStack(), new ItemStack(AEItems.FLUID_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_16M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("item_storage_cell_1m"), GTEItems.ITEM_STORAGE_CELL_1M.asStack(), new ItemStack(AEItems.ITEM_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_1M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("item_storage_cell_256m"), GTEItems.ITEM_STORAGE_CELL_256M.asStack(), new ItemStack(AEItems.ITEM_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_256M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("fluid_storage_cell_64m_2"), GTEItems.FLUID_STORAGE_CELL_64M.asStack(), new ItemStack(AEItems.FLUID_CELL_HOUSING.asItem()), GTEItems.CELL_COMPONENT_64M.asItem());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTECore.id("crafting_storage_1m"), GTEBlocks.CRAFTING_STORAGE_1M.asStack(), new ItemStack(AEBlocks.CRAFTING_UNIT.block().asItem()), GTEItems.CELL_COMPONENT_1M.asItem());
    }
}
