package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static org.gte.gtecore.common.data.GTERecipeTypes.ROCKET_ASSEMBLER_RECIPES;

interface RocketAssembler {

    static void init() {
        ROCKET_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("tier_1_rocket"))
                .inputItems("ad_astra:rocket_nose_cone")
                .inputItems(GTItems.SENSOR_HV.asItem())
                .inputItems(GTItems.EMITTER_HV.asItem())
                .inputItems("ad_astra:steel_tank", 4)
                .inputItems(TagPrefix.pipeSmallFluid, GTMaterials.Steel, 8)
                .inputItems(TagPrefix.bolt, GTMaterials.StainlessSteel, 32)
                .inputItems("ad_astra:rocket_fin", 4)
                .inputItems("ad_astra:steel_engine", 4)
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_1.asStack(12))
                .inputFluids(GTMaterials.Aluminium.getFluid(2304))
                .inputFluids(GTMaterials.Polyethylene.getFluid(2304))
                .inputFluids(GTMaterials.Lubricant.getFluid(4000))
                .outputItems("ad_astra:tier_1_rocket")
                .EUt(480)
                .duration(600)
                .save();

        ROCKET_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("tier_2_rocket"))
                .inputItems("ad_astra:rocket_nose_cone")
                .inputItems(GTItems.SENSOR_HV.asStack(2))
                .inputItems(GTItems.EMITTER_HV.asStack(2))
                .inputItems("ad_astra:steel_tank", 6)
                .inputItems(TagPrefix.pipeSmallFluid, GTMaterials.StainlessSteel, 8)
                .inputItems(TagPrefix.bolt, GTMaterials.Titanium, 32)
                .inputItems("ad_astra:rocket_fin", 4)
                .inputItems("ad_astra:steel_engine", 6)
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_2.asStack(12))
                .inputFluids(GTMaterials.Aluminium.getFluid(2304))
                .inputFluids(GTMaterials.Polyethylene.getFluid(2304))
                .inputFluids(GTMaterials.Lubricant.getFluid(8000))
                .outputItems("ad_astra:tier_2_rocket")
                .EUt(1920)
                .duration(600)
                .save();

        ROCKET_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("tier_3_rocket"))
                .inputItems("ad_astra:rocket_nose_cone")
                .inputItems(GTItems.SENSOR_EV.asStack(2))
                .inputItems(GTItems.EMITTER_EV.asStack(2))
                .inputItems("ad_astra:steel_tank", 8)
                .inputItems(TagPrefix.pipeSmallFluid, GTMaterials.Titanium, 8)
                .inputItems(TagPrefix.bolt, GTMaterials.TungstenSteel, 32)
                .inputItems("ad_astra:rocket_fin", 4)
                .inputItems("ad_astra:steel_engine", 8)
                .inputItems(GTEItems.HEAVY_DUTY_PLATE_3.asStack(12))
                .inputFluids(GTMaterials.Aluminium.getFluid(2304))
                .inputFluids(GTMaterials.PolyvinylChloride.getFluid(2304))
                .inputFluids(GTMaterials.Lubricant.getFluid(8000))
                .outputItems("ad_astra:tier_3_rocket")
                .EUt(1920)
                .duration(1200)
                .save();

        ROCKET_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("tier_4_rocket"))
                .inputItems("ad_astra:rocket_nose_cone")
                .inputItems(GTItems.SENSOR_EV.asStack(4))
                .inputItems(GTItems.FIELD_GENERATOR_EV.asStack(4))
                .inputItems("ad_astra:desh_tank", 8)
                .inputItems(TagPrefix.pipeSmallFluid, GTMaterials.TungstenSteel, 8)
                .inputItems(TagPrefix.bolt, GTMaterials.TungstenSteel, 32)
                .inputItems("ad_astra:rocket_fin", 4)
                .inputItems("ad_astra:desh_engine", 8)
                .inputItems(TagPrefix.plateDense, GTEMaterials.Desh, 16)
                .inputFluids(GTMaterials.Aluminium.getFluid(2304))
                .inputFluids(GTMaterials.Polytetrafluoroethylene.getFluid(2304))
                .inputFluids(GTMaterials.Lubricant.getFluid(8000))
                .outputItems("ad_astra:tier_4_rocket")
                .EUt(7680)
                .duration(1200)
                .save();

        ROCKET_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("tier_5_rocket"))
                .inputItems("ad_astra:rocket_nose_cone")
                .inputItems(GTItems.SENSOR_IV.asStack(4))
                .inputItems(GTItems.FIELD_GENERATOR_IV.asStack(4))
                .inputItems("ad_astra:ostrum_tank", 8)
                .inputItems(TagPrefix.pipeSmallFluid, GTMaterials.TungstenCarbide, 8)
                .inputItems(TagPrefix.bolt, GTMaterials.Neodymium, 32)
                .inputItems("ad_astra:rocket_fin", 4)
                .inputItems("ad_astra:ostrum_engine", 8)
                .inputItems(TagPrefix.plateDense, GTEMaterials.Ostrum, 16)
                .inputFluids(GTMaterials.Titanium.getFluid(2304))
                .inputFluids(GTMaterials.Polybenzimidazole.getFluid(2304))
                .inputFluids(GTMaterials.Lubricant.getFluid(8000))
                .outputItems("ad_astra_rocketed:tier_5_rocket")
                .EUt(30720)
                .duration(1200)
                .save();

        ROCKET_ASSEMBLER_RECIPES.recipeBuilder(GTECore.id("tier_6_rocket"))
                .inputItems("ad_astra:rocket_nose_cone")
                .inputItems(GTItems.SENSOR_LuV.asStack(4))
                .inputItems(GTItems.FIELD_GENERATOR_LuV.asStack(4))
                .inputItems("ad_astra:calorite_tank", 8)
                .inputItems(TagPrefix.pipeSmallFluid, GTMaterials.Tungsten, 8)
                .inputItems(TagPrefix.bolt, GTMaterials.NiobiumTitanium, 32)
                .inputItems("ad_astra:rocket_fin", 4)
                .inputItems("ad_astra:calorite_engine", 8)
                .inputItems(TagPrefix.plateDense, GTEMaterials.Calorite, 16)
                .inputFluids(GTMaterials.Titanium.getFluid(2304))
                .inputFluids(GTMaterials.Polybenzimidazole.getFluid(2304))
                .inputFluids(GTMaterials.Lubricant.getFluid(8000))
                .outputItems("ad_astra_rocketed:tier_6_rocket")
                .EUt(122880)
                .duration(1200)
                .save();
    }
}
