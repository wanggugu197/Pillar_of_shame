package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.NEUTRON_COMPRESSOR_RECIPES;

interface NeutronCompressor {

    static void init() {
        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_5"))
                .inputItems(TagPrefix.block, GTMaterials.HastelloyX, 64)
                .inputItems(TagPrefix.block, GTMaterials.RedSteel, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_5.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_6"))
                .inputItems(TagPrefix.block, GTEMaterials.HighDurabilityCompoundSteel, 64)
                .inputItems(TagPrefix.block, GTEMaterials.GermaniumTungstenNitride, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_6.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_7"))
                .inputItems(TagPrefix.block, GTMaterials.HSSE, 64)
                .inputItems(TagPrefix.block, GTMaterials.WatertightSteel, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_7.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_8"))
                .inputItems(TagPrefix.block, GTEMaterials.Pikyonium, 64)
                .inputItems(TagPrefix.block, GTEMaterials.AluminiumBronze, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_8.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_9"))
                .inputItems(TagPrefix.block, GTEMaterials.AbyssalAlloy, 64)
                .inputItems(TagPrefix.block, GTMaterials.SolderingAlloy, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_9.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_0"))
                .inputItems(TagPrefix.block, GTEMaterials.Lafium, 64)
                .inputItems(TagPrefix.block, GTMaterials.Potin, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_0.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_1"))
                .inputItems(TagPrefix.block, GTEMaterials.Enderite, 64)
                .inputItems(TagPrefix.block, GTMaterials.IndiumGalliumPhosphide, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_1.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_2"))
                .inputItems(TagPrefix.block, GTMaterials.RutheniumTriniumAmericiumNeutronate, 64)
                .inputItems(TagPrefix.block, GTMaterials.YttriumBariumCuprate, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_2.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_3"))
                .inputItems(TagPrefix.block, GTEMaterials.HastelloyK243, 64)
                .inputItems(TagPrefix.block, GTMaterials.CobaltBrass, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_3.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_4"))
                .inputItems(TagPrefix.block, GTEMaterials.TitanSteel, 64)
                .inputItems(TagPrefix.block, GTMaterials.UraniumRhodiumDinaquadide, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_4.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_12"))
                .inputItems(TagPrefix.block, GTMaterials.EnrichedNaquadahTriniumEuropiumDuranide, 64)
                .inputItems(TagPrefix.block, GTMaterials.RTMAlloy, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_12.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_13"))
                .inputItems(TagPrefix.block, GTMaterials.BlueSteel, 64)
                .inputItems(TagPrefix.block, GTMaterials.HastelloyC276, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_13.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_14"))
                .inputItems(TagPrefix.block, GTEMaterials.Cinobite, 64)
                .inputItems(TagPrefix.block, GTMaterials.Stellite100, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_14.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_15"))
                .inputItems(TagPrefix.block, GTMaterials.MaragingSteel300, 64)
                .inputItems(TagPrefix.block, GTEMaterials.Grisium, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_15.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_10"))
                .inputItems(TagPrefix.block, GTEMaterials.BlackTitanium, 64)
                .inputItems(TagPrefix.block, GTMaterials.NickelZincFerrite, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_10.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();

        NEUTRON_COMPRESSOR_RECIPES.recipeBuilder(GTECore.id("combined_singularity_11"))
                .inputItems(TagPrefix.block, GTMaterials.Ultimet, 64)
                .inputItems(TagPrefix.block, GTMaterials.HSLASteel, 64)
                .outputItems(GTEItems.COMBINED_SINGULARITY_11.asItem())
                .EUt(2013265920)
                .duration(200)
                .save();
    }
}
