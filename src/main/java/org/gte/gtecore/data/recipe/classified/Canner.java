package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidStack;

import com.enderio.base.common.init.EIOFluids;
import dev.shadowsoffire.apotheosis.ench.Ench;

import static org.gte.gtecore.common.data.GTERecipeTypes.CANNER_RECIPES;

interface Canner {

    static void init() {
        CANNER_RECIPES.recipeBuilder(GTECore.id("ender_air"))
                .inputItems(new ItemStack(Items.GLASS_BOTTLE.asItem()))
                .inputFluids(GTMaterials.EnderAir.getFluid(1000))
                .outputItems("botania:ender_air_bottle")
                .EUt(30)
                .duration(60)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("reactor_uranium_simple"))
                .inputItems(GTEItems.REACTOR_FUEL_ROD.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Uranium238, 16)
                .inputFluids(GTMaterials.Uranium235.getFluid(96))
                .outputItems(GTEItems.REACTOR_URANIUM_SIMPLE.asItem())
                .EUt(1920)
                .duration(120)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("sculk"))
                .inputItems(new ItemStack(Blocks.DIRT.asItem()))
                .inputItems(new ItemStack(Blocks.SCULK_VEIN.asItem()))
                .inputFluids(new FluidStack(EIOFluids.XP_JUICE.get().getSource(), 10))
                .outputItems(TagPrefix.block, GTMaterials.Sculk)
                .EUt(480)
                .duration(600)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("dense_neutron_plasma_cell"))
                .notConsumable(GTETagPrefix.NANITES, GTMaterials.Neutronium)
                .inputItems(GTEItems.EXTREMELY_DURABLE_PLASMA_CELL.asItem())
                .inputFluids(GTEMaterials.DenseNeutron.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.DENSE_NEUTRON_PLASMA_CELL.asItem())
                .EUt(125829120)
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("reactor_mox_simple"))
                .inputItems(GTEItems.REACTOR_FUEL_ROD.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Uranium238, 18)
                .inputFluids(GTMaterials.Plutonium239.getFluid(432))
                .outputItems(GTEItems.REACTOR_MOX_SIMPLE.asItem())
                .EUt(7680)
                .duration(120)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("reactor_thorium_simple"))
                .inputItems(GTEItems.REACTOR_FUEL_ROD.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Thorium, 12)
                .outputItems(GTEItems.REACTOR_THORIUM_SIMPLE.asItem())
                .EUt(480)
                .duration(120)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("infused_breath"))
                .inputItems(new ItemStack(Items.DRAGON_BREATH.asItem()))
                .inputFluids(new FluidStack(EIOFluids.XP_JUICE.get().getSource(), 1000))
                .outputItems(Ench.Items.INFUSED_BREATH.get(), 3)
                .EUt(480)
                .duration(400)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("crystal_matrix_plasma_containment_cell"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Enderium)
                .inputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTEMaterials.CrystalMatrix.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.CRYSTAL_MATRIX_PLASMA_CONTAINMENT_CELL.asItem())
                .EUt(125829120)
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("reactor_naquadah_simple"))
                .inputItems(GTEItems.TUNGSTEN_CARBIDE_REACTOR_FUEL_ROD.asItem())
                .inputItems(TagPrefix.dust, GTMaterials.Naquadah, 4)
                .inputFluids(GTMaterials.Thorium.getFluid(144))
                .outputItems(GTEItems.REACTOR_NAQUADAH_SIMPLE.asItem())
                .EUt(30720)
                .duration(120)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("rhenium_plasma_containment_cell"))
                .notConsumable(GTETagPrefix.NANITES, GTMaterials.Naquadah)
                .inputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTEMaterials.DegenerateRhenium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.RHENIUM_PLASMA_CONTAINMENT_CELL.asItem())
                .EUt(30720)
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("chaos_containment_unit"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.CosmicNeutronium)
                .inputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asItem())
                .inputFluids(GTEMaterials.Chaos.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.CHAOS_CONTAINMENT_UNIT.asItem())
                .EUt(503316480)
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("bose_einstein_cooling_container"))
                .notConsumable(GTETagPrefix.NANITES, GTMaterials.Iridium)
                .inputItems(GTEItems.EMPTY_LASER_COOLING_CONTAINER.asItem())
                .inputFluids(GTMaterials.Rubidium.getFluid(288))
                .outputItems(GTEItems.BOSE_EINSTEIN_COOLING_CONTAINER.asItem())
                .EUt(90000)
                .duration(280)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("actinium_superhydride_plasma_containment_cell"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Infuscolium)
                .inputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTEMaterials.ActiniumSuperhydride.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL.asItem())
                .EUt(31457280)
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("awakened_draconium_plasma_containment_cell"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Draconium)
                .inputItems(GTEItems.PLASMA_CONTAINMENT_CELL.asItem())
                .inputFluids(GTEMaterials.AwakenedDraconium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.AWAKENED_DRACONIUM_PLASMA_CONTAINMENT_CELL.asItem())
                .EUt(125829120)
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("charged_triplet_neutronium_sphere"))
                .notConsumable(GTETagPrefix.NANITES, GTMaterials.Neutronium)
                .inputItems(GTEItems.TRIPLET_NEUTRONIUM_SPHERE.asItem())
                .inputFluids(GTEMaterials.FreeAlphaGas.getFluid(1000))
                .outputItems(GTEItems.CHARGED_TRIPLET_NEUTRONIUM_SPHERE.asItem())
                .EUt(500000)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        CANNER_RECIPES.recipeBuilder(GTECore.id("cosmic_mesh_containment_unit"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Uruium)
                .inputItems(GTEItems.TIME_DILATION_CONTAINMENT_UNIT.asItem())
                .inputFluids(GTEMaterials.CosmicMesh.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputItems(GTEItems.COSMIC_MESH_CONTAINMENT_UNIT.asItem())
                .EUt(503316480)
                .duration(20)
                .save();
    }
}
