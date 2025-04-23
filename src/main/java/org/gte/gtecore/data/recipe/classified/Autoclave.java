package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.recipe.condition.GravityCondition;
import org.gte.gtecore.common.recipe.condition.VacuumCondition;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import com.enderio.base.common.init.EIOItems;
import committee.nova.mods.avaritia.init.registry.ModItems;

import static org.gte.gtecore.common.data.GTERecipeTypes.AUTOCLAVE_RECIPES;

interface Autoclave {

    static void init() {
        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("sterilized_petri_dish"))
                .inputItems(GTItems.PETRI_DISH)
                .inputFluids(GTEMaterials.AbsoluteEthanol.getFluid(100))
                .outputItems(GTEItems.STERILIZED_PETRI_DISH)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .duration(25).EUt(7680).save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("spacetime_catalyst"))
                .inputItems(ModItems.infinity_catalyst.get())
                .inputFluids(GTEMaterials.SpaceTime.getFluid(1000))
                .outputItems(GTEItems.SPACETIME_CATALYST.asItem())
                .EUt(8053063680L)
                .duration(1200)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("dry_graphene_gel_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.GrapheneGelSuspension)
                .inputFluids(GTMaterials.Acetone.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.DryGrapheneGel)
                .EUt(480)
                .duration(260)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("soul_soil"))
                .inputItems(EIOItems.FILLED_SOUL_VIAL.asItem())
                .inputItems(new ItemStack(Blocks.ROOTED_DIRT.asItem()))
                .inputFluids(GTMaterials.LiquidNetherAir.getFluid(100))
                .outputItems(EIOItems.EMPTY_SOUL_VIAL.asItem())
                .outputItems(new ItemStack(Blocks.SOUL_SOIL.asItem()))
                .EUt(480)
                .duration(240)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("ender_crystal"))
                .inputItems(EIOItems.VIBRANT_CRYSTAL.asItem())
                .inputFluids(GTEMaterials.Enderium.getFluid(8))
                .outputItems(EIOItems.ENDER_CRYSTAL.asItem())
                .EUt(30)
                .duration(200)
                .addCondition(new VacuumCondition(4))
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("hassium_seed_crystal"))
                .inputItems(TagPrefix.dustTiny, GTMaterials.Hassium)
                .inputFluids(GTMaterials.Nitrogen.getFluid(10000))
                .outputItems(GTEItems.HASSIUM_SEED_CRYSTAL.asItem())
                .EUt(31457280)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("unstable_star"))
                .inputItems(GTETagPrefix.NANITES, GTEMaterials.Orichalcum)
                .inputItems(GTItems.GRAVI_STAR.asItem())
                .inputFluids(GTEMaterials.Adamantine.getFluid(288))
                .outputItems(GTETagPrefix.CONTAMINABLE_NANITES, GTEMaterials.Orichalcum)
                .outputItems(GTEItems.UNSTABLE_STAR.asItem())
                .EUt(491520)
                .duration(480)
                .addCondition(new GravityCondition(true))
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("nuclear_star"))
                .inputItems(GTETagPrefix.NANITES, GTEMaterials.CosmicNeutronium)
                .inputItems(GTEItems.UNSTABLE_STAR.asItem())
                .inputFluids(GTEMaterials.Infinity.getFluid(288))
                .outputItems(GTETagPrefix.CONTAMINABLE_NANITES, GTEMaterials.CosmicNeutronium)
                .outputItems(GTEItems.NUCLEAR_STAR.asItem())
                .EUt(31457280)
                .duration(480)
                .addCondition(new GravityCondition(true))
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("super_mutated_living_solder"))
                .inputItems(GTEItems.SPACE_ESSENCE.asStack(64))
                .inputItems(GTEItems.DRACONIUM_DIRT.asStack(64))
                .inputFluids(GTEMaterials.MutatedLivingSolder.getFluid(10000))
                .outputItems(GTEBlocks.ESSENCE_BLOCK.asItem())
                .outputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(10000))
                .EUt(7864320)
                .duration(2400)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("contained_kerr_singularity"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Vibranium)
                .inputItems(GTEItems.CONTAINED_KERR_NEWMANN_SINGULARITY.asItem())
                .inputFluids(GTEMaterials.FreeElectronGas.getFluid(1000))
                .outputItems(GTEItems.CONTAINED_KERR_SINGULARITY.asItem())
                .EUt(1966080)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("draconium_dust"))
                .notConsumable(GTETagPrefix.NANITES, GTEMaterials.Enderium, 64)
                .inputItems(GTEItems.DRACONIUM_DIRT.asItem())
                .inputFluids(GTEMaterials.DragonElement.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.Draconium)
                .EUt(125829120)
                .duration(200)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("prescient_crystal"))
                .inputItems(EIOItems.VIBRANT_CRYSTAL.asItem())
                .inputFluids(GTEMaterials.Mithril.getFluid(8))
                .outputItems(EIOItems.PRESCIENT_CRYSTAL.asItem())
                .EUt(30)
                .duration(200)
                .addCondition(new VacuumCondition(4))
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("vibrant_crystal"))
                .inputItems(TagPrefix.gem, GTMaterials.Emerald)
                .inputFluids(GTEMaterials.PulsatingAlloy.getFluid(72))
                .outputItems(EIOItems.VIBRANT_CRYSTAL.asItem())
                .EUt(30)
                .duration(160)
                .addCondition(new VacuumCondition(2))
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("imprinted_resonatic_circuit_board"))
                .inputItems(GTEItems.RAW_IMPRINTED_RESONATIC_CIRCUIT_BOARD.asItem())
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(432))
                .outputItems(GTEItems.IMPRINTED_RESONATIC_CIRCUIT_BOARD.asItem())
                .EUt(1920)
                .duration(300)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        AUTOCLAVE_RECIPES.recipeBuilder(GTECore.id("pulsating_crystal"))
                .inputItems(TagPrefix.gem, GTMaterials.Diamond)
                .inputFluids(GTEMaterials.PulsatingAlloy.getFluid(72))
                .outputItems(EIOItems.PULSATING_CRYSTAL.asItem())
                .EUt(30)
                .duration(100)
                .addCondition(new VacuumCondition(2))
                .save();
    }
}
