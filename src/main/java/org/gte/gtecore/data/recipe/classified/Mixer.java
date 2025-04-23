package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.machine.GTECleanroomType;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.recipe.condition.GravityCondition;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidStack;

import com.enderio.base.common.init.EIOFluids;
import com.enderio.base.common.init.EIOItems;
import earth.terrarium.adastra.common.registry.ModFluids;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTEMaterials.*;
import static org.gte.gtecore.common.data.GTERecipeTypes.MIXER_RECIPES;

interface Mixer {

    static void init() {
        MIXER_RECIPES.builder("mica_based_pulp")
                .inputItems(TagPrefix.dust, GTMaterials.Mica, 3)
                .inputItems(TagPrefix.dust, GTMaterials.RawRubber, 2)
                .outputItems(GTEItems.MICA_BASED_PULP.asStack(5))
                .EUt(8)
                .duration(300)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("absolute_ethanol"))
                .inputFluids(Ethanol.getFluid(1000))
                .inputItems(TagPrefix.dust, ZeoliteSievingPellets)
                .outputFluids(AbsoluteEthanol.getFluid(1000))
                .outputItems(TagPrefix.dust, WetZeoliteSievingPellets)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(100).EUt(120).save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("piranha_solution"))
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(PiranhaSolution.getFluid(2000))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(50).EUt(30).save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("potassium_pyrosulfate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Potassium, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Sulfur, 2)
                .inputFluids(GTMaterials.Oxygen.getFluid(7000))
                .outputItems(TagPrefix.dust, GTEMaterials.PotassiumPyrosulfate, 11)
                .EUt(120)
                .duration(120)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("actinoids_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ActinoidsMix1)
                .inputItems(TagPrefix.dust, GTEMaterials.ActinoidsMix2)
                .outputItems(TagPrefix.dust, GTEMaterials.ActinoidsMix, 2)
                .EUt(31457280)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("znfealcl_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Zinc)
                .inputItems(TagPrefix.dust, GTMaterials.Iron)
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium)
                .inputFluids(GTMaterials.Chlorine.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.ZnFeAlClCatalyst, 4)
                .EUt(15360)
                .duration(250)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("concentration_mixing_hyper_fuel_1"))
                .inputItems(TagPrefix.dust, GTMaterials.Hassium)
                .inputItems(TagPrefix.dust, GTMaterials.Oganesson)
                .inputFluids(GTEMaterials.HyperFuel4.getFluid(1000))
                .inputFluids(GTEMaterials.DimensionallyTranscendentCrudeCatalyst.getFluid(1000))
                .outputFluids(GTEMaterials.ConcentrationMixingHyperFuel1.getFluid(1000))
                .EUt(134217728)
                .duration(800)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("astral_silver_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Silver, 2)
                .inputItems(TagPrefix.dust, GTEMaterials.Thaumium)
                .outputItems(TagPrefix.dust, GTEMaterials.AstralSilver, 3)
                .EUt(1920)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("sunnarium"))
                .notConsumable(GTItems.FIELD_GENERATOR_UIV.asItem())
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(new FluidStack(EIOFluids.LIQUID_SUNSHINE.getSource(), 1000))
                .outputFluids(GTEMaterials.Sunnarium.getFluid(1000))
                .EUt(125829120)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("iridium_trichloride_solution"))
                .inputItems(TagPrefix.dust, GTMaterials.IridiumChloride, 4)
                .inputFluids(GTMaterials.HypochlorousAcid.getFluid(1000))
                .inputFluids(GTMaterials.NitricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.IridiumTrichlorideSolution.getFluid(1000))
                .EUt(1920)
                .duration(360)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("magneto_resonatic_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Prasiolite, 3)
                .inputItems(TagPrefix.dust, GTEMaterials.BismuthTellurite, 6)
                .inputItems(TagPrefix.dust, GTEMaterials.CubicZirconia)
                .inputItems(TagPrefix.dust, GTMaterials.SteelMagnetic)
                .outputItems(TagPrefix.dust, GTEMaterials.MagnetoResonatic, 9)
                .EUt(30)
                .duration(80)
                .addCondition(new GravityCondition(true))
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("mixed_astatide_salts_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Holmium)
                .inputItems(TagPrefix.dust, GTMaterials.Thulium)
                .inputItems(TagPrefix.dust, GTMaterials.Copernicium)
                .inputItems(TagPrefix.dust, GTMaterials.Flerovium)
                .inputFluids(GTEMaterials.AstatideSolution.getFluid(3000))
                .inputFluids(GTMaterials.DistilledWater.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.MixedAstatideSalts, 7)
                .outputFluids(GTMaterials.DilutedSulfuricAcid.getFluid(6000))
                .EUt(122880)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("redstone_alloy_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .inputItems(TagPrefix.dust, GTMaterials.Silicon)
                .circuitMeta(2)
                .outputItems(TagPrefix.dust, GTEMaterials.RedstoneAlloy, 2)
                .EUt(30)
                .duration(320)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("rocket_fuel_h8n4c2o4"))
                .inputFluids(GTMaterials.Dimethylhydrazine.getFluid(1000))
                .inputFluids(GTMaterials.DinitrogenTetroxide.getFluid(1000))
                .outputFluids(GTEMaterials.RocketFuelH8n4c2o4.getFluid(1000))
                .EUt(1920)
                .duration(480)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("circuit_compound_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.DibismuthHydroborate, 3)
                .inputItems(TagPrefix.dust, GTEMaterials.BismuthTellurite, 2)
                .inputItems(TagPrefix.dust, GTMaterials.IndiumGalliumPhosphide)
                .outputItems(TagPrefix.dust, GTEMaterials.CircuitCompound, 6)
                .EUt(15)
                .duration(890)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("viscoelastic_polyurethane"))
                .inputItems(TagPrefix.dust, GTMaterials.Calcite, 5)
                .inputFluids(GTEMaterials.Polyurethane.getFluid(1000))
                .inputFluids(GTEMaterials.EthyleneGlycol.getFluid(1000))
                .outputFluids(GTEMaterials.ViscoelasticPolyurethane.getFluid(2000))
                .EUt(120)
                .duration(110)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("astatide_solution"))
                .inputItems(TagPrefix.dust, GTMaterials.Astatine)
                .inputFluids(GTMaterials.SulfuricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.AstatideSolution.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("silica_alumina_gel_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Alumina, 5)
                .inputItems(TagPrefix.dust, GTEMaterials.SilicaGel, 3)
                .outputItems(TagPrefix.dust, GTEMaterials.SilicaAluminaGel)
                .EUt(120)
                .duration(60)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("high_energy_mixture_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Glowstone, 4)
                .inputItems(TagPrefix.dust, GTMaterials.Redstone, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium)
                .circuitMeta(3)
                .outputItems(TagPrefix.dust, GTEMaterials.HighEnergyMixture, 4)
                .EUt(480)
                .duration(600)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("dimensionallytranscendentcrudecatalyst"))
                .inputItems(GTEItems.RESONATING_GEM.asItem())
                .inputFluids(GTMaterials.Nitrogen.getFluid(FluidStorageKeys.PLASMA, 1000))
                .inputFluids(GTMaterials.Helium.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(GTEMaterials.DimensionallyTranscendentCrudeCatalyst.getFluid(1000))
                .EUt(503316480)
                .duration(200)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("sodium_nitrate_solution"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumNitrate, 5)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTEMaterials.SodiumNitrateSolution.getFluid(1000))
                .EUt(120)
                .duration(80)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("filled_soul_vial"))
                .notConsumable(new ItemStack(Blocks.SOUL_CAMPFIRE.asItem()))
                .inputItems(EIOItems.EMPTY_SOUL_VIAL.asItem())
                .outputItems(EIOItems.FILLED_SOUL_VIAL.asItem())
                .EUt(2)
                .duration(2000)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("fertilizer_"))
                .inputItems(GTItems.FERTILIZER.asItem())
                .inputItems(GTEItems.SCRAP.asStack(2))
                .outputItems(GTItems.FERTILIZER.asStack(2))
                .EUt(480)
                .duration(40)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("copper_alloy_ingot_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Copper)
                .inputItems(TagPrefix.dust, GTMaterials.Silicon)
                .circuitMeta(2)
                .outputItems(TagPrefix.dust, GTEMaterials.CopperAlloy, 2)
                .EUt(30)
                .duration(120)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("molten_calcium_salts"))
                .inputItems(TagPrefix.dust, GTMaterials.Calcium)
                .inputFluids(GTEMaterials.Fluorite.getFluid(432))
                .outputFluids(GTEMaterials.MoltenCalciumSalts.getFluid(1000))
                .EUt(30)
                .duration(160)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("glucose_iron_solution"))
                .inputItems(TagPrefix.dust, GTEMaterials.Glucose, 24)
                .inputFluids(GTMaterials.Iron3Chloride.getFluid(1000))
                .outputFluids(GTEMaterials.GlucoseIronSolution.getFluid(1000))
                .EUt(30)
                .duration(80)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("sodium_ethylate_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Sodium)
                .inputFluids(GTMaterials.Ethanol.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumEthylate, 9)
                .outputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("essence_seed"))
                .inputItems(new ItemStack(Blocks.BEETROOTS.asItem(), 16))
                .inputItems(GTEItems.ESSENCE.asItem())
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .inputFluids(GTMaterials.CarbonDioxide.getFluid(1000))
                .outputItems(GTEItems.ESSENCE_SEED.asStack(16))
                .EUt(120)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("silica_gel_base"))
                .inputItems(TagPrefix.dust, GTMaterials.SiliconDioxide, 3)
                .inputItems(TagPrefix.dust, GTMaterials.SodiumHydroxide, 3)
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .outputFluids(GTEMaterials.SilicaGelBase.getFluid(1000))
                .EUt(120)
                .duration(80)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("enriched_xenoxene"))
                .inputItems(TagPrefix.dust, GTEMaterials.Taranium)
                .inputFluids(GTEMaterials.PurifiedXenoxene.getFluid(10000))
                .inputFluids(GTEMaterials.RadoxGas.getFluid(100))
                .outputFluids(GTEMaterials.EnrichedXenoxene.getFluid(10000))
                .EUt(491520)
                .duration(600)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("kelp_slurry"))
                .inputItems(new ItemStack(Items.DRIED_KELP.asItem(), 8))
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTEMaterials.KelpSlurry.getFluid(1000))
                .EUt(30)
                .duration(600)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("rocket_fuel_cn3h7o3"))
                .inputFluids(GTEMaterials.Monomethylhydrazine.getFluid(1000))
                .inputFluids(GTMaterials.NitricAcid.getFluid(1000))
                .outputFluids(GTEMaterials.RocketFuelCn3h7o3.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("conductive_alloy_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.CopperAlloy)
                .inputItems(TagPrefix.dust, GTMaterials.Iron)
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .circuitMeta(3)
                .outputItems(TagPrefix.dust, GTEMaterials.ConductiveAlloy, 3)
                .EUt(30)
                .duration(240)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("tin_alloy"))
                .inputItems(TagPrefix.dust, GTMaterials.Iron)
                .inputFluids(GTMaterials.Tin.getFluid(144))
                .outputFluids(GTMaterials.TinAlloy.getFluid(288))
                .EUt(30)
                .duration(200)
                .heat(800)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("pulsating_alloy_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Iron)
                .inputItems(TagPrefix.dust, GTMaterials.EnderPearl)
                .circuitMeta(2)
                .outputItems(TagPrefix.dust, GTEMaterials.PulsatingAlloy, 2)
                .EUt(30)
                .duration(160)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("rooted_dirt"))
                .chancedInput(new ItemStack(Blocks.MOSS_CARPET.asItem()), 1000, 0)
                .inputItems(new ItemStack(Blocks.DIRT.asItem()))
                .outputItems(new ItemStack(Blocks.ROOTED_DIRT.asItem()))
                .EUt(16)
                .duration(200)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("gamma_rays_photoresist"))
                .inputItems(TagPrefix.dust, GTEMaterials.Borocarbide, 29)
                .inputItems(TagPrefix.dust, GTEMaterials.LanthanumEmbeddedFullerene, 4)
                .inputFluids(GTEMaterials.EuvPhotoresist.getFluid(1000))
                .inputFluids(GTEMaterials.Trichloroflerane.getFluid(1000))
                .outputFluids(GTEMaterials.GammaRaysPhotoresist.getFluid(1000))
                .EUt(1966080)
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("germanium_containing_precipitate_dust"))
                .inputFluids(GTEMaterials.AshLeachingSolution.getFluid(1000))
                .inputFluids(GTEMaterials.Tannic.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.GermaniumContainingPrecipitate)
                .EUt(120)
                .duration(200)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("perlite_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Obsidian, 2)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Perlite, 3)
                .EUt(480)
                .duration(300)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("rocket_fuel_rp_1"))
                .inputFluids(GTEMaterials.Rp1.getFluid(1000))
                .inputFluids(GTMaterials.Oxygen.getFluid(FluidStorageKeys.LIQUID, 1000))
                .outputFluids(GTEMaterials.RocketFuelRp1.getFluid(1000))
                .EUt(1920)
                .duration(16)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("euv_photoresist"))
                .inputItems(TagPrefix.dust, GTEMaterials.BisethylenedithiotetraselenafulvalenePerrhenate, 31)
                .inputFluids(GTEMaterials.Photoresist.getFluid(1000))
                .inputFluids(GTEMaterials.PolyurethaneResin.getFluid(1000))
                .outputFluids(GTEMaterials.EuvPhotoresist.getFluid(1000))
                .EUt(524288)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("hastelloy_n_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Iridium, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Molybdenum, 4)
                .inputItems(TagPrefix.dust, GTMaterials.Chromium, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Titanium, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Nickel, 15)
                .circuitMeta(5)
                .outputItems(TagPrefix.dust, GTEMaterials.HastelloyN, 25)
                .EUt(1920)
                .duration(1000)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("turbid_dragon_blood"))
                .inputItems(TagPrefix.dust, GTEMaterials.SilicaGel)
                .inputFluids(GTEMaterials.DragonBlood.getFluid(1000))
                .inputFluids(GTMaterials.GelatinMixture.getFluid(1000))
                .outputFluids(GTEMaterials.TurbidDragonBlood.getFluid(1000))
                .EUt(1920)
                .duration(800)
                .cleanroom(GTECleanroomType.LAW_CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("xenoxene_mixture"))
                .inputItems(TagPrefix.dustTiny, GTEMaterials.Radox)
                .inputItems(TagPrefix.dust, GTMaterials.Antimony)
                .inputItems(TagPrefix.dust, GTMaterials.Osmium)
                .inputItems(TagPrefix.dust, GTMaterials.EnderEye)
                .inputFluids(GTEMaterials.Xenoxene.getFluid(1000))
                .inputFluids(GTMaterials.Xenon.getFluid(9000))
                .outputFluids(GTEMaterials.XenoxeneMixture.getFluid(10000))
                .EUt(1966080)
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("actinium_trinium_hydroxides_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.ActiniumTriniumHydroxides, 58)
                .inputItems(TagPrefix.dust, GTMaterials.Radium, 6)
                .inputItems(GTEItems.PROTONATED_FULLERENE_SIEVING_MATRIX.asItem())
                .inputFluids(GTMaterials.Water.getFluid(2000))
                .outputItems(GTEItems.SATURATED_FULLERENE_SIEVING_MATRIX.asItem())
                .outputFluids(GTEMaterials.ActiniumRadiumHydroxideSolution.getFluid(2000))
                .EUt(245760)
                .duration(210)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("cryo_fuel"))
                .inputItems("ad_astra:ice_shard", 16)
                .inputFluids(GTMaterials.CetaneBoostedDiesel.getFluid(1000))
                .inputFluids(GTEMaterials.ExplosiveHydrazine.getFluid(1000))
                .outputFluids(new FluidStack(ModFluids.CRYO_FUEL.get(), 1000))
                .EUt(7680)
                .duration(320)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("dense_hydrazine_fuel_mixture"))
                .inputFluids(GTEMaterials.Hydrazine.getFluid(1000))
                .inputFluids(GTMaterials.Methanol.getFluid(1000))
                .outputFluids(GTEMaterials.DenseHydrazineFuelMixture.getFluid(1000))
                .EUt(240)
                .duration(320)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("sodium_aluminium_hydride_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.AluminiumHydride, 4)
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumHydride, 2)
                .outputItems(TagPrefix.dust, GTEMaterials.SodiumAluminiumHydride, 6)
                .EUt(30)
                .duration(190)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("heavy_quark_enriched_mixture"))
                .inputFluids(GTEMaterials.HeavyQuarks.getFluid(750))
                .inputFluids(GTEMaterials.LightQuarks.getFluid(250))
                .outputFluids(GTEMaterials.HeavyQuarkEnrichedMixture.getFluid(1000))
                .EUt(32500000)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("grass_block"))
                .inputItems(new ItemStack(Blocks.DIRT.asItem()))
                .inputItems(new ItemStack(Blocks.GRASS.asItem()))
                .outputItems(new ItemStack(Blocks.GRASS_BLOCK.asItem()))
                .EUt(16)
                .duration(200)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("graphene_gel_suspension_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.GrapheneOxide, 3)
                .inputFluids(GTEMaterials.Resorcinol.getFluid(1000))
                .inputFluids(GTMaterials.Formaldehyde.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.GrapheneGelSuspension)
                .EUt(120)
                .duration(100)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("lanthanum_fullerene_mix_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Lanthanum)
                .inputItems(TagPrefix.dust, GTEMaterials.UnfoldedFullerene)
                .outputItems(TagPrefix.dust, GTEMaterials.LanthanumFullereneMix, 2)
                .EUt(30720)
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("scandium_titanium_50_mixture"))
                .inputFluids(GTEMaterials.Titanium50.getFluid(144))
                .inputFluids(GTMaterials.Scandium.getFluid(144))
                .outputFluids(GTEMaterials.ScandiumTitanium50Mixture.getFluid(288))
                .EUt(7680)
                .duration(120)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("antihydrogen"))
                .notConsumable(GTItems.FIELD_GENERATOR_UV.asItem())
                .inputFluids(GTEMaterials.PositiveElectron.getFluid(200))
                .inputFluids(GTEMaterials.Antiproton.getFluid(200))
                .outputFluids(GTEMaterials.Antihydrogen.getFluid(200))
                .EUt(491520)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("oganesson_breeding_base"))
                .inputFluids(GTEMaterials.Titanium50.getFluid(1440))
                .inputFluids(GTMaterials.Californium.getFluid(576))
                .outputFluids(GTEMaterials.OganessonBreedingBase.getFluid(2016))
                .EUt(7680)
                .duration(480)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("aluminium_bronze_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Aluminium)
                .inputItems(TagPrefix.dust, GTMaterials.Bronze, 6)
                .circuitMeta(1)
                .outputItems(TagPrefix.dust, GTEMaterials.AluminiumBronze, 7)
                .EUt(30)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("rhodium_rhenium_naquadah_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Rhenium)
                .inputItems(TagPrefix.dust, GTMaterials.Rhodium)
                .inputItems(TagPrefix.dust, GTMaterials.Naquadah)
                .outputItems(TagPrefix.dust, GTEMaterials.RhodiumRheniumNaquadahCatalyst)
                .EUt(84500)
                .duration(260)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("polycyclic_aromatic_mixture_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.Tetracene, 2)
                .inputFluids(GTMaterials.Naphthalene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.PolycyclicAromaticMixture, 3)
                .EUt(7680)
                .duration(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("boron_trifluoride_acetate"))
                .inputFluids(GTEMaterials.DiethylEther.getFluid(1000))
                .inputFluids(GTEMaterials.BoronFluoride.getFluid(1000))
                .outputFluids(GTEMaterials.BoronTrifluorideAcetate.getFluid(1000))
                .EUt(125)
                .duration(150)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("end_steel_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Endstone)
                .inputItems(TagPrefix.dust, GTEMaterials.DarkSteel)
                .inputItems(TagPrefix.dust, GTMaterials.Obsidian)
                .circuitMeta(3)
                .outputItems(TagPrefix.dust, GTEMaterials.EndSteel, 3)
                .EUt(480)
                .duration(360)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("dark_steel_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Iron)
                .inputItems(TagPrefix.dust, GTMaterials.Coal)
                .inputItems(TagPrefix.dust, GTMaterials.Obsidian)
                .circuitMeta(3)
                .outputItems(TagPrefix.dust, GTEMaterials.DarkSteel, 3)
                .EUt(30)
                .duration(300)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("fluix_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.NetherQuartz)
                .inputItems(TagPrefix.dust, GTMaterials.CertusQuartz)
                .inputItems(TagPrefix.dust, GTMaterials.Redstone)
                .outputItems(TagPrefix.dust, GTEMaterials.Fluix, 3)
                .EUt(16)
                .duration(200)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("explosivehydrazine"))
                .notConsumable(GTItems.FIELD_GENERATOR_LuV.asItem())
                .inputItems(GTItems.GELLED_TOLUENE.asStack(16))
                .inputItems(new ItemStack(Items.FIRE_CHARGE.asItem(), 8))
                .inputFluids(GTMaterials.GlycerylTrinitrate.getFluid(1000))
                .inputFluids(GTEMaterials.DenseHydrazineFuelMixture.getFluid(3000))
                .outputFluids(GTEMaterials.ExplosiveHydrazine.getFluid(4000))
                .EUt(1920)
                .duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("charged_caesium_cerium_cobalt_indium_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Indium, 10)
                .inputItems(TagPrefix.dust, GTMaterials.Cobalt, 2)
                .inputItems(TagPrefix.dust, GTMaterials.Cerium)
                .inputItems(TagPrefix.dust, GTMaterials.Caesium)
                .inputFluids(GTEMaterials.CosmicComputingMixture.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.ChargedCaesiumCeriumCobaltIndium, 14)
                .EUt(31457280)
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("vibrant_alloy_dust"))
                .circuitMeta(2)
                .inputItems(TagPrefix.dust, GTEMaterials.EnergeticAlloy)
                .inputItems(TagPrefix.dust, GTMaterials.EnderPearl)
                .outputItems(TagPrefix.dust, GTEMaterials.VibrantAlloy, 2)
                .EUt(120)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("eglin_steel_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Iron, 4)
                .inputItems(TagPrefix.dust, GTMaterials.Kanthal)
                .inputItems(TagPrefix.dust, GTMaterials.Invar, 5)
                .inputItems(TagPrefix.dust, GTMaterials.Sulfur)
                .inputItems(TagPrefix.dust, GTMaterials.Silicon)
                .inputItems(TagPrefix.dust, GTMaterials.Carbon)
                .outputItems(TagPrefix.dust, GTEMaterials.EglinSteel, 13)
                .EUt(120)
                .duration(600)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("viscoelastic_polyurethane_foam"))
                .inputFluids(GTEMaterials.ViscoelasticPolyurethane.getFluid(1000))
                .inputFluids(GTMaterials.Air.getFluid(1000))
                .outputFluids(GTEMaterials.ViscoelasticPolyurethaneFoam.getFluid(2000))
                .EUt(120)
                .duration(150)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("naquadah_solution"))
                .inputItems(TagPrefix.dust, GTMaterials.Naquadah, 2)
                .inputFluids(GTEMaterials.AmmoniumNitrateSolution.getFluid(1000))
                .outputFluids(GTEMaterials.NaquadahSolution.getFluid(1000))
                .EUt(30720)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("ti_al_chloride"))
                .inputItems(TagPrefix.dust, GTEMaterials.AluminiumChloride, 4)
                .inputFluids(GTMaterials.TitaniumTetrachloride.getFluid(1000))
                .outputItems(TagPrefix.dust, GTEMaterials.TiAlChloride)
                .EUt(120)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("aluminium_hydroxide_dust"))
                .inputItems(TagPrefix.dust, GTEMaterials.SodiumAluminate, 4)
                .inputFluids(GTMaterials.Water.getFluid(3000))
                .outputItems(TagPrefix.dust, GTEMaterials.AluminiumHydroxide, 7)
                .outputFluids(SodiumHydroxideSolution.getFluid(1000))
                .EUt(30)
                .duration(120)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("tungsten_boron_mixture_dust"))
                .inputItems(TagPrefix.dust, GTMaterials.Tungsten)
                .inputItems(TagPrefix.dust, GTMaterials.Boron, 4)
                .circuitMeta(2)
                .outputItems(TagPrefix.dust, GTEMaterials.TungstenBoronMixture)
                .EUt(480)
                .duration(100)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("coolant_liquid"))
                .inputItems(TagPrefix.dust, GTMaterials.Lazurite, 2)
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .outputFluids(GTEMaterials.CoolantLiquid.getFluid(1000))
                .EUt(30)
                .duration(200)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("dew_of_the_void"))
                .inputItems("enderio:pulsating_powder")
                .inputItems(GTEItems.GREEN_ALGAE.asStack(8))
                .inputItems(GTEItems.BROWN_ALGAE.asStack(8))
                .inputFluids(new FluidStack(EIOFluids.NUTRIENT_DISTILLATION.getSource(), 4000))
                .outputFluids(new FluidStack(EIOFluids.DEW_OF_THE_VOID.getSource(), 4000))
                .EUt(120)
                .duration(400)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("bacterial_growth_medium"))
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .inputFluids(GTEMaterials.BloodCells.getFluid(1000))
                .outputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(1000))
                .EUt(120)
                .duration(100)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("animal_cells"))
                .inputItems(TagPrefix.dust, GTMaterials.Meat, 2)
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .outputFluids(GTEMaterials.AnimalCells.getFluid(1000))
                .EUt(480)
                .duration(100)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("pluripotency_induction_gene_therapy_fluid"))
                .inputFluids(GTEMaterials.PluripotencyInductionGenePlasmids.getFluid(1000))
                .inputFluids(GTEMaterials.Chitosan.getFluid(1000))
                .outputFluids(GTEMaterials.PluripotencyInductionGeneTherapyFluid.getFluid(1000))
                .EUt(7680)
                .duration(24)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .save();

        MIXER_RECIPES.recipeBuilder(GTECore.id("clear_ammonia_solution"))
                .inputFluids(GTMaterials.Ammonia.getFluid(1000))
                .inputFluids(GTMaterials.DistilledWater.getFluid(1000))
                .outputFluids(GTEMaterials.ClearAmmoniaSolution.getFluid(1000))
                .EUt(480)
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .save();
    }
}
