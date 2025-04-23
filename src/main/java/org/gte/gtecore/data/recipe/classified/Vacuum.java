package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEFluids;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraftforge.fluids.FluidStack;

import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Oxygen;
import static org.gte.gtecore.common.data.GTERecipeTypes.VACUUM_RECIPES;

interface Vacuum {

    static void init() {
        VACUUM_RECIPES.recipeBuilder(GTECore.id("frozen_pearl"))
                .inputItems(TagPrefix.gem, GTMaterials.EnderPearl)
                .inputFluids(GTMaterials.Ice.getFluid(576))
                .outputItems("torchmaster:frozen_pearl")
                .EUt(120)
                .duration(120)
                .save();

        VACUUM_RECIPES.recipeBuilder(GTECore.id("metastable_oganesson"))
                .inputFluids(GTEMaterials.HotOganesson.getFluid(1000))
                .inputFluids(new FluidStack(GTEFluids.GELID_CRYOTHEUM.get(), 144))
                .outputItems(TagPrefix.dustSmall, GTEMaterials.Enderium, 2)
                .outputFluids(GTEMaterials.MetastableOganesson.getFluid(144))
                .EUt(491520)
                .duration(280)
                .save();

        VACUUM_RECIPES.recipeBuilder(GTECore.id("fullerene_polymer_matrix_fine_tubing"))
                .inputItems(GTEItems.FULLERENE_POLYMER_MATRIX_SOFT_TUBING.asItem())
                .outputItems(GTEItems.FULLERENE_POLYMER_MATRIX_FINE_TUBING.asItem())
                .EUt(500)
                .duration(240)
                .save();

        VACUUM_RECIPES.recipeBuilder(GTECore.id("cold_ice_casing"))
                .inputItems(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.asItem())
                .inputFluids(GTMaterials.Ice.getFluid(10000))
                .inputFluids(GTMaterials.VanadiumGallium.getFluid(576))
                .outputItems(GTEBlocks.COLD_ICE_CASING.asItem())
                .EUt(1920)
                .duration(200)
                .save();

        VACUUM_RECIPES.recipeBuilder(GTECore.id("fuming_nitric_acid"))
                .inputFluids(GTEMaterials.FumingNitricAcid.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.CrystallineNitricAcid, 5)
                .EUt(120)
                .duration(180)
                .save();

        VACUUM_RECIPES.recipeBuilder(GTECore.id("liquid_hydrogen"))
                .inputFluids(GTEMaterials.HighPressureHydrogen.getFluid(1000))
                .outputFluids(GTEMaterials.LiquidHydrogen.getFluid(1000))
                .EUt(7680)
                .duration(240)
                .save();

        VACUUM_RECIPES.recipeBuilder(GTECore.id("draconium_ingot"))
                .inputItems(TagPrefix.ingotHot, GTEMaterials.Draconium)
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.LIQUID, 1000))
                .outputItems(TagPrefix.ingot, GTEMaterials.Draconium)
                .outputFluids(GTMaterials.Helium.getFluid(500))
                .EUt(125829120)
                .duration(100)
                .save();

        VACUUM_RECIPES.builder("liquid_oxygen")
                .inputFluids(GTEMaterials.HighPressureOxygen.getFluid(1000))
                .outputFluids(Oxygen.getFluid(FluidStorageKeys.LIQUID, 1000))
                .duration(240).EUt(VA[EV]).save();

        VACUUM_RECIPES.builder("liquid_nitrogen")
                .inputFluids(GTEMaterials.HighPressureNitrogen.getFluid(1000))
                .outputFluids(GTEMaterials.LiquidNitrogen.getFluid(1000))
                .duration(320).EUt(VA[EV]).save();

        VACUUM_RECIPES.builder("stainless_steel_ingot")
                .outputItems(TagPrefix.ingot, GTMaterials.StainlessSteel)
                .inputFluids(GTMaterials.StainlessSteel.getFluid(FluidStorageKeys.MOLTEN, 144))
                .EUt(120)
                .duration(120)
                .save();

        VACUUM_RECIPES.builder("manganese_phosphide_ingot")
                .outputItems(TagPrefix.ingot, GTMaterials.ManganesePhosphide)
                .inputFluids(GTMaterials.ManganesePhosphide.getFluid(FluidStorageKeys.MOLTEN, 144))
                .EUt(120)
                .duration(80)
                .save();
    }
}
