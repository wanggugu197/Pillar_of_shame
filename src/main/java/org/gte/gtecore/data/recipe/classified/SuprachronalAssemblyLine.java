package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import static org.gte.gtecore.common.data.GTERecipeTypes.SUPRACHRONAL_ASSEMBLY_LINE_RECIPES;

interface SuprachronalAssemblyLine {

    static void init() {
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("create_ultimate_battery"))
                .inputItems(TagPrefix.frameGt, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter)
                .inputItems(GTEItems.SUPRACHRONAL_MAINFRAME_COMPLEX.asStack(4))
                .inputItems(GTEItems.MEGA_MAX_BATTERY.asStack(16))
                .inputItems(GTEItems.MAX_FIELD_GENERATOR.asStack(16))
                .inputItems(GTEItems.FM_WAFER.asStack(64))
                .inputItems(GTEItems.FM_WAFER.asStack(64))
                .inputItems(GTEItems.FM_WAFER.asStack(64))
                .inputItems(GTEItems.FM_WAFER.asStack(64))
                .inputItems(GTEItems.FM_WAFER.asStack(64))
                .inputItems(GTEItems.FM_WAFER.asStack(64))
                .inputItems(GTEItems.FM_WAFER.asStack(64))
                .inputItems(GTEItems.FM_WAFER.asStack(64))
                .inputItems(TagPrefix.wireGtHex, GTEMaterials.Infinity, 16)
                .inputItems(TagPrefix.plateDouble, GTEMaterials.Infinity, 64)
                .inputItems(TagPrefix.plate, GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter, 32)
                .inputItems(TagPrefix.plateDouble, GTEMaterials.Cosmic, 32)
                .inputFluids(GTEMaterials.Infinity.getFluid(1000))
                .inputFluids(GTEMaterials.SpaceTime.getFluid(1000))
                .inputFluids(GTEMaterials.Eternity.getFluid(1000))
                .inputFluids(GTEMaterials.MagnetohydrodynamicallyConstrainedStarMatter.getFluid(1000))
                .outputItems(GTEItems.CREATE_ULTIMATE_BATTERY.asItem())
                .EUt(32212254720L)
                .duration(8000)
                .stationResearch(b -> b.researchStack(GTEItems.MEGA_MAX_BATTERY.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(16384)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("max_robot_arm"))
                .inputItems(TagPrefix.rodLong, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.gear, GTEMaterials.TranscendentMetal, 2)
                .inputItems(TagPrefix.gearSmall, GTEMaterials.TranscendentMetal, 6)
                .inputItems(GTEItems.MAX_ELECTRIC_MOTOR.asStack(4))
                .inputItems(GTEItems.MAX_ELECTRIC_PISTON.asItem())
                .inputItems(CustomTags.MAX_CIRCUITS)
                .inputItems(CustomTags.OpV_CIRCUITS, 2)
                .inputItems(CustomTags.UXV_CIRCUITS, 4)
                .inputItems(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium, 16)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(18432))
                .inputFluids(GTEMaterials.SpacetimeContinuum.getFluid(36864))
                .inputFluids(GTEMaterials.DimensionAllyshiftedSuperFluid.getFluid(64000))
                .inputFluids(GTEMaterials.Infinity.getFluid(576))
                .outputItems(GTEItems.MAX_ROBOT_ARM.asItem())
                .EUt(2013265920)
                .duration(1200)
                .stationResearch(b -> b.researchStack(GTItems.ROBOT_ARM_OpV.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(4096)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("max_conveyor_module"))
                .inputItems(GTEItems.MAX_ELECTRIC_MOTOR.asStack(2))
                .inputItems(TagPrefix.plate, GTEMaterials.TranscendentMetal, 4)
                .inputItems(TagPrefix.ring, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.round, GTEMaterials.TranscendentMetal, 32)
                .inputItems(TagPrefix.screw, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.plate, GTEMaterials.WhiteDwarfMatter, 8)
                .inputItems(TagPrefix.plate, GTEMaterials.BlackDwarfMatter, 8)
                .inputItems(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium, 16)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(18432))
                .inputFluids(GTEMaterials.DimensionAllyshiftedSuperFluid.getFluid(64000))
                .inputFluids(GTMaterials.StyreneButadieneRubber.getFluid(40320))
                .inputFluids(GTEMaterials.Infinity.getFluid(576))
                .outputItems(GTEItems.MAX_CONVEYOR_MODULE.asItem())
                .EUt(2013265920)
                .duration(1200)
                .stationResearch(b -> b.researchStack(GTItems.CONVEYOR_MODULE_OpV.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(4096)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_ev"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(5)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(5))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 50))
                .inputFluids(GTMaterials.UUMatter.getFluid(500))
                .inputFluids(GTEMaterials.Periodicium.getFluid(500))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.EV].get())
                .EUt(2013265920)
                .duration(10)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.HV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_lv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(2)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(2))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 20))
                .inputFluids(GTMaterials.UUMatter.getFluid(200))
                .inputFluids(GTEMaterials.Periodicium.getFluid(200))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.LV].get())
                .EUt(2013265920)
                .duration(4)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.ULV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_iv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(6)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(6))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 60))
                .inputFluids(GTMaterials.UUMatter.getFluid(600))
                .inputFluids(GTEMaterials.Periodicium.getFluid(600))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.IV].get())
                .EUt(2013265920)
                .duration(12)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.EV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_hv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(4)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(4))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 40))
                .inputFluids(GTMaterials.UUMatter.getFluid(400))
                .inputFluids(GTEMaterials.Periodicium.getFluid(400))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.HV].get())
                .EUt(2013265920)
                .duration(8)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.MV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_mv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(3)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(3))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 30))
                .inputFluids(GTMaterials.UUMatter.getFluid(300))
                .inputFluids(GTEMaterials.Periodicium.getFluid(300))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.MV].get())
                .EUt(2013265920)
                .duration(6)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.LV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_uv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(9)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(9))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 90))
                .inputFluids(GTMaterials.UUMatter.getFluid(900))
                .inputFluids(GTEMaterials.Periodicium.getFluid(900))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UV].get())
                .EUt(2013265920)
                .duration(18)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.ZPM].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_luv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(7)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(7))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 70))
                .inputFluids(GTMaterials.UUMatter.getFluid(700))
                .inputFluids(GTEMaterials.Periodicium.getFluid(700))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.LuV].get())
                .EUt(2013265920)
                .duration(14)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.IV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_max"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(15)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(15))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 150))
                .inputFluids(GTMaterials.UUMatter.getFluid(1500))
                .inputFluids(GTEMaterials.Periodicium.getFluid(1500))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.MAX].get())
                .EUt(2013265920)
                .duration(30)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.OpV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_opv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(14)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(14))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 140))
                .inputFluids(GTMaterials.UUMatter.getFluid(1400))
                .inputFluids(GTEMaterials.Periodicium.getFluid(1400))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.OpV].get())
                .EUt(2013265920)
                .duration(28)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UXV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_uev"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(11)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(11))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 110))
                .inputFluids(GTMaterials.UUMatter.getFluid(1100))
                .inputFluids(GTEMaterials.Periodicium.getFluid(1100))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UEV].get())
                .EUt(2013265920)
                .duration(22)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UHV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_uhv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(10)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(10))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 100))
                .inputFluids(GTMaterials.UUMatter.getFluid(1000))
                .inputFluids(GTEMaterials.Periodicium.getFluid(1000))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UHV].get())
                .EUt(2013265920)
                .duration(20)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_uiv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(12)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(12))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 120))
                .inputFluids(GTMaterials.UUMatter.getFluid(1200))
                .inputFluids(GTEMaterials.Periodicium.getFluid(1200))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UIV].get())
                .EUt(2013265920)
                .duration(24)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UEV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("max_field_generator"))
                .inputItems(TagPrefix.frameGt, GTEMaterials.Infinity)
                .inputItems(TagPrefix.plate, GTEMaterials.Chaos, 12)
                .inputItems(GTEItems.NUCLEAR_STAR.asStack(4))
                .inputItems(GTEItems.MAX_EMITTER.asStack(2))
                .inputItems(CustomTags.MAX_CIRCUITS, 2)
                .inputItems(TagPrefix.wireFine, GTEMaterials.WhiteDwarfMatter, 64)
                .inputItems(TagPrefix.wireFine, GTEMaterials.BlackDwarfMatter, 64)
                .inputItems(TagPrefix.wireFine, GTEMaterials.Shirabon, 64)
                .inputItems(TagPrefix.wireFine, GTEMaterials.Cosmic, 64)
                .inputItems(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium, 32)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(36864))
                .inputFluids(GTEMaterials.SpacetimeContinuum.getFluid(73728))
                .inputFluids(GTEMaterials.Infinity.getFluid(576))
                .outputItems(GTEItems.MAX_FIELD_GENERATOR.asItem())
                .EUt(2013265920)
                .duration(1200)
                .stationResearch(b -> b.researchStack(GTItems.FIELD_GENERATOR_OpV.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(6114)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_ulv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(1)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(1))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 10))
                .inputFluids(GTMaterials.UUMatter.getFluid(100))
                .inputFluids(GTEMaterials.Periodicium.getFluid(100))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.ULV].get())
                .EUt(2013265920)
                .duration(2)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACAUSAL_MAINFRAME.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_uxv"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(13)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(13))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 130))
                .inputFluids(GTMaterials.UUMatter.getFluid(1300))
                .inputFluids(GTEMaterials.Periodicium.getFluid(1300))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UXV].get())
                .EUt(2013265920)
                .duration(26)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.UIV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("suprachronal_circuit_zpm"))
                .notConsumable(GTEItems.HYPERDIMENSIONAL_DRONE.asItem())
                .inputItems(GTEItems.TIMEPIECE.asItem())
                .circuitMeta(8)
                .inputFluids(GTEMaterials.SpaceTime.getFluid(8))
                .inputFluids(GTEMaterials.RawStarMatter.getFluid(FluidStorageKeys.PLASMA, 80))
                .inputFluids(GTMaterials.UUMatter.getFluid(800))
                .inputFluids(GTEMaterials.Periodicium.getFluid(800))
                .outputItems(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.ZPM].get())
                .EUt(2013265920)
                .duration(16)
                .stationResearch(b -> b.researchStack(GTEItems.SUPRACHRONAL_CIRCUIT[GTValues.LuV].asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(8192)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("max_electric_piston"))
                .inputItems(GTEItems.MAX_ELECTRIC_MOTOR.asItem())
                .inputItems(TagPrefix.plate, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.ring, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.round, GTEMaterials.TranscendentMetal, 32)
                .inputItems(TagPrefix.rod, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.gear, GTEMaterials.TranscendentMetal, 2)
                .inputItems(TagPrefix.gearSmall, GTEMaterials.TranscendentMetal, 4)
                .inputItems(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium, 16)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(18432))
                .inputFluids(GTEMaterials.SpacetimeContinuum.getFluid(36864))
                .inputFluids(GTEMaterials.DimensionAllyshiftedSuperFluid.getFluid(64000))
                .inputFluids(GTEMaterials.Infinity.getFluid(576))
                .outputItems(GTEItems.MAX_ELECTRIC_PISTON.asItem())
                .EUt(2013265920)
                .duration(1200)
                .stationResearch(b -> b.researchStack(GTItems.ELECTRIC_PISTON_OpV.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(4096)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("max_electric_pump"))
                .inputItems(GTEItems.MAX_ELECTRIC_MOTOR.asItem())
                .inputItems(TagPrefix.pipeSmallFluid, GTEMaterials.Neutron, 64)
                .inputItems(TagPrefix.plate, GTEMaterials.TranscendentMetal, 4)
                .inputItems(TagPrefix.screw, GTEMaterials.TranscendentMetal, 16)
                .inputItems(TagPrefix.plateDouble, GTEMaterials.BlackDwarfMatter, 4)
                .inputItems(TagPrefix.plateDouble, GTEMaterials.WhiteDwarfMatter, 4)
                .inputItems(TagPrefix.rotor, GTEMaterials.TranscendentMetal)
                .inputItems(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium, 16)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(18432))
                .inputFluids(GTEMaterials.SpacetimeContinuum.getFluid(36864))
                .inputFluids(GTEMaterials.DimensionAllyshiftedSuperFluid.getFluid(64000))
                .inputFluids(GTEMaterials.Infinity.getFluid(576))
                .outputItems(GTEItems.MAX_ELECTRIC_PUMP.asItem())
                .EUt(2013265920)
                .duration(1200)
                .stationResearch(b -> b.researchStack(GTItems.ELECTRIC_PUMP_OpV.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(4096)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("max_emitter"))
                .inputItems(TagPrefix.frameGt, GTEMaterials.Infinity)
                .inputItems(GTEItems.MAX_ELECTRIC_MOTOR.asItem())
                .inputItems(TagPrefix.rodLong, GTEMaterials.TranscendentMetal, 8)
                .inputItems(GTEItems.NUCLEAR_STAR.asStack(4))
                .inputItems(CustomTags.MAX_CIRCUITS, 2)
                .inputItems(TagPrefix.foil, GTEMaterials.WhiteDwarfMatter, 64)
                .inputItems(TagPrefix.foil, GTEMaterials.BlackDwarfMatter, 64)
                .inputItems(TagPrefix.foil, GTEMaterials.Shirabon, 64)
                .inputItems(TagPrefix.foil, GTEMaterials.Cosmic, 64)
                .inputItems(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium, 32)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(36864))
                .inputFluids(GTEMaterials.SpacetimeContinuum.getFluid(73728))
                .inputFluids(GTEMaterials.Infinity.getFluid(576))
                .outputItems(GTEItems.MAX_EMITTER.asItem())
                .EUt(2013265920)
                .duration(1200)
                .stationResearch(b -> b.researchStack(GTItems.EMITTER_OpV.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(6114)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("max_electric_motor"))
                .inputItems(TagPrefix.rodLong, GTEMaterials.Magmatter)
                .inputItems(TagPrefix.rodLong, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.ring, GTEMaterials.TranscendentMetal, 8)
                .inputItems(TagPrefix.round, GTEMaterials.TranscendentMetal, 16)
                .inputItems(TagPrefix.wireFine, GTEMaterials.BlackDwarfMatter, 64)
                .inputItems(TagPrefix.wireFine, GTEMaterials.BlackDwarfMatter, 64)
                .inputItems(TagPrefix.wireFine, GTEMaterials.WhiteDwarfMatter, 64)
                .inputItems(TagPrefix.wireFine, GTEMaterials.WhiteDwarfMatter, 64)
                .inputItems(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium, 16)
                .inputItems(GTETagPrefix.CURVED_PLATE, GTEMaterials.TranscendentMetal, 4)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(16000))
                .inputFluids(GTEMaterials.SpacetimeContinuum.getFluid(32000))
                .inputFluids(GTEMaterials.DimensionAllyshiftedSuperFluid.getFluid(64000))
                .inputFluids(GTEMaterials.Infinity.getFluid(576))
                .outputItems(GTEItems.MAX_ELECTRIC_MOTOR.asItem())
                .EUt(2013265920)
                .duration(1200)
                .stationResearch(b -> b.researchStack(GTItems.ELECTRIC_MOTOR_OpV.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(4096)
                        .EUt(2013265920))
                .save();

        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder(GTECore.id("max_sensor"))
                .inputItems(TagPrefix.frameGt, GTEMaterials.Infinity)
                .inputItems(GTEItems.MAX_ELECTRIC_MOTOR.asItem())
                .inputItems(TagPrefix.plate, GTEMaterials.TranscendentMetal, 8)
                .inputItems(GTEItems.NUCLEAR_STAR.asStack(4))
                .inputItems(CustomTags.MAX_CIRCUITS, 2)
                .inputItems(TagPrefix.foil, GTEMaterials.WhiteDwarfMatter, 64)
                .inputItems(TagPrefix.foil, GTEMaterials.BlackDwarfMatter, 64)
                .inputItems(TagPrefix.foil, GTEMaterials.Shirabon, 64)
                .inputItems(TagPrefix.foil, GTEMaterials.Cosmic, 64)
                .inputItems(TagPrefix.cableGtSingle, GTEMaterials.CosmicNeutronium, 32)
                .inputFluids(GTEMaterials.SuperMutatedLivingSolder.getFluid(36864))
                .inputFluids(GTEMaterials.SpacetimeContinuum.getFluid(73728))
                .inputFluids(GTEMaterials.Infinity.getFluid(576))
                .outputItems(GTEItems.MAX_SENSOR.asItem())
                .EUt(2013265920)
                .duration(1200)
                .stationResearch(b -> b.researchStack(GTItems.SENSOR_OpV.asStack())
                        .dataStack(GTEItems.CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.asStack())
                        .CWUt(6114)
                        .EUt(2013265920))
                .save();
    }
}
