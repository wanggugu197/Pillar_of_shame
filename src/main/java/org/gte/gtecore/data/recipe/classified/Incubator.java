package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.common.recipe.condition.GravityCondition;
import org.gte.gtecore.utils.TagUtils;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidStack;

import appeng.core.definitions.AEItems;
import com.enderio.base.common.init.EIOFluids;
import earth.terrarium.adastra.common.registry.ModFluids;

import static org.gte.gtecore.common.data.GTERecipeTypes.INCUBATOR_RECIPES;

interface Incubator {

    static void init() {
        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("certus_quartz_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/quartzite"))
                .inputItems(TagUtils.createTGTag("ores/certus_quartz"))
                .inputItems(TagUtils.createTGTag("ores/barite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.CERTUS_QUARTZ_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("monazite_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/bastnasite"))
                .inputItems(TagUtils.createTGTag("ores/molybdenum"))
                .inputItems(TagUtils.createTGTag("ores/neodymium"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.MONAZITE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("biomediumraw"))
                .inputItems(GTEItems.BIOLOGICAL_CELLS.asStack(64))
                .inputItems(GTEItems.TCETIESEAWEEDEXTRACT.asStack(16))
                .inputFluids(GTMaterials.RawGrowthMedium.getFluid(10000))
                .outputFluids(GTEMaterials.BiomediumRaw.getFluid(10000))
                .EUt(1920)
                .duration(1200)
                .addCondition(new GravityCondition(true))
                .addData("filter_casing", 2)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("iron_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/goethite"))
                .inputItems(TagUtils.createTGTag("ores/yellow_limonite"))
                .inputItems(TagUtils.createTGTag("ores/hematite"))
                .inputItems(TagUtils.createTGTag("ores/malachite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.IRON_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("variation_wood"))
                .inputItems(GTEBlocks.BARNARDA_C_LOG.asStack(64))
                .inputItems(new ItemStack(Blocks.CRIMSON_STEM.asItem(), 16))
                .inputItems(TagPrefix.dust, GTMaterials.Wood, 64)
                .inputItems(TagPrefix.dust, GTMaterials.Lapotron)
                .inputFluids(GTEMaterials.UnknowWater.getFluid(10000))
                .inputFluids(GTMaterials.Biomass.getFluid(1000))
                .outputItems(GTEBlocks.VARIATION_WOOD.asStack(64))
                .EUt(1966080)
                .duration(2400)
                .addData("filter_casing", 3)
                .addData("radioactivity", 440)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("lubricant_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/soapstone"))
                .inputItems(TagUtils.createTGTag("ores/talc"))
                .inputItems(TagUtils.createTGTag("ores/glauconite_sand"))
                .inputItems(TagUtils.createTGTag("ores/pentlandite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.LUBRICANT_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("lapis_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/lazurite"))
                .inputItems(TagUtils.createTGTag("ores/sodalite"))
                .inputItems(TagUtils.createTGTag("ores/lapis"))
                .inputItems(TagUtils.createTGTag("ores/calcite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.LAPIS_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("stem_cells"))
                .chancedInput(GTEItems.GLACIO_SPIRIT.asStack(), 2000, 100)
                .inputItems(GTItems.STEM_CELLS.asStack(32))
                .inputFluids(GTMaterials.SterileGrowthMedium.getFluid(400))
                .outputItems(GTItems.STEM_CELLS.asStack(64))
                .EUt(30720)
                .duration(300)
                .addData("filter_casing", 2)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("copper_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/chalcopyrite"))
                .inputItems(TagUtils.createTGTag("ores/iron"))
                .inputItems(TagUtils.createTGTag("ores/pyrite"))
                .inputItems(TagUtils.createTGTag("ores/copper"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.COPPER_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("nickel_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/garnierite"))
                .inputItems(TagUtils.createTGTag("ores/nickel"))
                .inputItems(TagUtils.createTGTag("ores/cobaltite"))
                .inputItems(TagUtils.createTGTag("ores/pentlandite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.NICKEL_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("oilsands_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/oilsands"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.OILSANDS_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("banded_iron_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/goethite"))
                .inputItems(TagUtils.createTGTag("ores/yellow_limonite"))
                .inputItems(TagUtils.createTGTag("ores/hematite"))
                .inputItems(TagUtils.createTGTag("ores/gold"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.BANDED_IRON_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("chorus_fruit"))
                .notConsumable(new ItemStack(Blocks.CHORUS_FLOWER.asItem(), 64))
                .inputFluids(GTEMaterials.UnknowWater.getFluid(1000))
                .inputFluids(GTMaterials.EnderPearl.getFluid(100))
                .outputItems(new ItemStack(Items.CHORUS_FRUIT.asItem(), 64))
                .EUt(120)
                .duration(1200)
                .addData("radioactivity", 230)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("magnetite_vein_end_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/magnetite"))
                .inputItems(TagUtils.createTGTag("ores/vanadium_magnetite"))
                .inputItems(TagUtils.createTGTag("ores/chromite"))
                .inputItems(TagUtils.createTGTag("ores/gold"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.MAGNETITE_VEIN_END_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("pitchblende_vein_end_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/pitchblende"))
                .inputItems(TagUtils.createTGTag("ores/uraninite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.PITCHBLENDE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("seaweedbroth"))
                .inputItems(new ItemStack(Blocks.KELP.asItem(), 64))
                .inputItems(TagPrefix.dust, GTEMaterials.AlienAlgae, 32)
                .inputItems(TagPrefix.dust, GTEMaterials.AlgaeExtract, 16)
                .inputItems(GTItems.ENERGIUM_DUST.asStack(8))
                .inputItems(TagPrefix.dust, GTEMaterials.Mithril)
                .inputFluids(GTEMaterials.UnknownNutrientAgar.getFluid(50000))
                .inputFluids(GTMaterials.Methane.getFluid(50000))
                .outputFluids(GTEMaterials.SeaweedBroth.getFluid(50000))
                .EUt(7680)
                .duration(4800)
                .addData("filter_casing", 2)
                .addData("radioactivity", 80)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("galena_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/galena"))
                .inputItems(TagUtils.createTGTag("ores/silver"))
                .inputItems(TagUtils.createTGTag("ores/lead"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.GALENA_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("saltpeter_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/saltpeter"))
                .inputItems(TagUtils.createTGTag("ores/diatomite"))
                .inputItems(TagUtils.createTGTag("ores/electrotine"))
                .inputItems(TagUtils.createTGTag("ores/alunite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.SALTPETER_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("molybdenum_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/wulfenite"))
                .inputItems(TagUtils.createTGTag("ores/molybdenite"))
                .inputItems(TagUtils.createTGTag("ores/molybdenum"))
                .inputItems(TagUtils.createTGTag("ores/powellite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.MOLYBDENUM_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("dragon_cells"))
                .chancedInput(GTEItems.GLACIO_SPIRIT.asStack(), 6000, 100)
                .inputItems(GTEItems.DRAGON_CELLS.asStack(32))
                .inputFluids(GTEMaterials.BiohmediumSterilized.getFluid(4000))
                .outputItems(GTEItems.DRAGON_CELLS.asStack(64))
                .EUt(491520)
                .duration(1600)
                .addData("filter_casing", 3)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("salts_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/rock_salt"))
                .inputItems(TagUtils.createTGTag("ores/salt"))
                .inputItems(TagUtils.createTGTag("ores/lepidolite"))
                .inputItems(TagUtils.createTGTag("ores/spodumene"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.SALTS_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("redstone_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/redstone"))
                .inputItems(TagUtils.createTGTag("ores/ruby"))
                .inputItems(TagUtils.createTGTag("ores/cinnabar"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.REDSTONE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("apatite_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/apatite"))
                .inputItems(TagUtils.createTGTag("ores/tricalcium_phosphate"))
                .inputItems(TagUtils.createTGTag("ores/pyrochlore"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.APATITE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("xenoxene"))
                .inputItems(TagPrefix.dust, GTMaterials.AntimonyTrioxide, 16)
                .inputItems(TagPrefix.dust, GTMaterials.Osmium, 16)
                .inputFluids(GTMaterials.Oil.getFluid(20000))
                .outputFluids(GTEMaterials.Xenoxene.getFluid(20000))
                .EUt(491520)
                .duration(2400)
                .addData("filter_casing", 3)
                .addData("radioactivity", 360)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("sheldonite_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/bornite"))
                .inputItems(TagUtils.createTGTag("ores/cooperite"))
                .inputItems(TagUtils.createTGTag("ores/platinum"))
                .inputItems(TagUtils.createTGTag("ores/palladium"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.SHELDONITE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("mica_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/kyanite"))
                .inputItems(TagUtils.createTGTag("ores/mica"))
                .inputItems(TagUtils.createTGTag("ores/bauxite"))
                .inputItems(TagUtils.createTGTag("ores/pollucite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.MICA_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("nether_quartz_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/nether_quartz"))
                .inputItems(TagUtils.createTGTag("ores/quartzite"))
                .inputItems(new ItemStack(Blocks.ANCIENT_DEBRIS.asItem(), 5))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.NETHER_QUARTZ_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("olivine_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/bentonite"))
                .inputItems(TagUtils.createTGTag("ores/magnetite"))
                .inputItems(TagUtils.createTGTag("ores/olivine"))
                .inputItems(TagUtils.createTGTag("ores/glauconite_sand"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.OLIVINE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("beryllium_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/beryllium"))
                .inputItems(TagUtils.createTGTag("ores/emerald"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.BERYLLIUM_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("mineral_sand_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/basaltic_mineral_sand"))
                .inputItems(TagUtils.createTGTag("ores/granitic_mineral_sand"))
                .inputItems(TagUtils.createTGTag("ores/fullers_earth"))
                .inputItems(TagUtils.createTGTag("ores/gypsum"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.MINERAL_SAND_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("topaz_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/blue_topaz"))
                .inputItems(TagUtils.createTGTag("ores/topaz"))
                .inputItems(TagUtils.createTGTag("ores/chalcocite"))
                .inputItems(TagUtils.createTGTag("ores/bornite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.TOPAZ_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("manganese_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/grossular"))
                .inputItems(TagUtils.createTGTag("ores/pyrolusite"))
                .inputItems(TagUtils.createTGTag("ores/tantalite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.MANGANESE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("cassiterite_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/tin"))
                .inputItems(TagUtils.createTGTag("ores/cassiterite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.CASSITERITE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("naquadah_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/naquadah"))
                .inputItems(TagUtils.createTGTag("ores/plutonium"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.NAQUADAH_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("sapphire_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/almandine"))
                .inputItems(TagUtils.createTGTag("ores/pyrope"))
                .inputItems(TagUtils.createTGTag("ores/sapphire"))
                .inputItems(TagUtils.createTGTag("ores/green_sapphire"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.SAPPHIRE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("diamond_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/graphite"))
                .inputItems(TagUtils.createTGTag("ores/diamond"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.DIAMOND_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("bauxite_vein_end_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/bauxite"))
                .inputItems(TagUtils.createTGTag("ores/ilmenite"))
                .inputItems(TagUtils.createTGTag("ores/aluminium"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.BAUXITE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("garnet_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/red_garnet"))
                .inputItems(TagUtils.createTGTag("ores/yellow_garnet"))
                .inputItems(TagUtils.createTGTag("ores/amethyst"))
                .inputItems(TagUtils.createTGTag("ores/opal"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.GARNET_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("garnet_tin_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/cassiterite_sand"))
                .inputItems(TagUtils.createTGTag("ores/garnet_sand"))
                .inputItems(TagUtils.createTGTag("ores/asbestos"))
                .inputItems(TagUtils.createTGTag("ores/diatomite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.GARNET_TIN_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("biological_cells"))
                .chancedInput(GTEItems.GLACIO_SPIRIT.asStack(), 4000, 100)
                .inputItems(GTEItems.BIOLOGICAL_CELLS.asStack(32))
                .inputFluids(GTEMaterials.BiohmediumSterilized.getFluid(400))
                .outputItems(GTEItems.BIOLOGICAL_CELLS.asStack(64))
                .EUt(122880)
                .duration(800)
                .addData("filter_casing", 2)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("glacio_spirit"))
                .chancedInput(GTEItems.GLACIO_SPIRIT.asStack(4), 1000, 100)
                .inputItems(TagPrefix.dust, GTEMaterials.Celestine, 16)
                .inputItems(GTEItems.ESSENCE.asItem())
                .inputFluids(new FluidStack(ModFluids.CRYO_FUEL.get(), 100))
                .inputFluids(GTMaterials.Ice.getFluid(900))
                .outputItems(GTEItems.GLACIO_SPIRIT.asStack(64))
                .EUt(30720)
                .duration(2000)
                .addData("radioactivity", 40)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("tetrahedrite_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/tetrahedrite"))
                .inputItems(TagUtils.createTGTag("ores/copper"))
                .inputItems(TagUtils.createTGTag("ores/stibnite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.TETRAHEDRITE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("copper_tin_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/chalcopyrite"))
                .inputItems(TagUtils.createTGTag("ores/zeolite"))
                .inputItems(TagUtils.createTGTag("ores/cassiterite"))
                .inputItems(TagUtils.createTGTag("ores/realgar"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.COPPER_TIN_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("space_essence"))
                .inputItems(TagUtils.createTag(GTECore.id("vein_essence")))
                .inputItems(new ItemStack(AEItems.SKY_DUST.asItem()))
                .inputItems(TagPrefix.dustTiny, GTMaterials.NetherStar)
                .inputFluids(GTMaterials.Biomass.getFluid(100))
                .inputFluids(GTMaterials.SterileGrowthMedium.getFluid(10))
                .outputItems(GTEItems.SPACE_ESSENCE.asItem())
                .EUt(480)
                .duration(1200)
                .addData("radioactivity", 180)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("echo"))
                .notConsumable(new ItemStack(Blocks.SCULK_SHRIEKER.asItem(), 64))
                .notConsumable(new ItemStack(Blocks.SCULK_SENSOR.asItem(), 64))
                .inputItems(new ItemStack(Blocks.DIRT.asItem(), 64))
                .inputItems(new ItemStack(Blocks.SCULK_VEIN.asItem(), 64))
                .inputFluids(GTEMaterials.UnknowWater.getFluid(1000))
                .inputFluids(new FluidStack(EIOFluids.XP_JUICE.get().getSource(), 1000))
                .outputItems(TagPrefix.block, GTMaterials.Sculk, 64)
                .outputFluids(GTMaterials.EchoShard.getFluid(10000))
                .EUt(1920)
                .duration(2400)
                .addData("filter_casing", 3)
                .addData("radioactivity", 380)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("sulfur_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/sulfur"))
                .inputItems(TagUtils.createTGTag("ores/pyrite"))
                .inputItems(TagUtils.createTGTag("ores/sphalerite"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.SULFUR_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("variation_wood1"))
                .inputItems(GTEBlocks.BARNARDA_C_LOG.asStack(64))
                .inputItems(new ItemStack(Blocks.WARPED_STEM.asItem(), 16))
                .inputItems(TagPrefix.dust, GTMaterials.Wood, 64)
                .inputItems(TagPrefix.dust, GTMaterials.Lapotron)
                .inputFluids(GTEMaterials.UnknowWater.getFluid(10000))
                .inputFluids(GTMaterials.Biomass.getFluid(1000))
                .outputItems(GTEBlocks.VARIATION_WOOD.asStack(64))
                .EUt(1966080)
                .duration(2400)
                .addData("filter_casing", 3)
                .addData("radioactivity", 440)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("coal_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/coal"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.COAL_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("scheelite_vein_essence"))
                .inputItems(GTEItems.ESSENCE_SEED.asItem())
                .inputItems(TagUtils.createTGTag("ores/scheelite"))
                .inputItems(TagUtils.createTGTag("ores/tungstate"))
                .inputItems(TagUtils.createTGTag("ores/lithium"))
                .inputFluids(GTMaterials.Biomass.getFluid(10000))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputItems(GTEItems.SCHEELITE_VEIN_ESSENCE.asStack(64))
                .EUt(480)
                .duration(12000)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("super_cerebrum"))
                .inputItems(GTEItems.CEREBRUM.asItem())
                .inputItems(TagPrefix.dustSmall, GTMaterials.Naquadria)
                .outputItems(GTEItems.SUPER_CEREBRUM.asItem())
                .inputFluids(GTEMaterials.RapidlyReplicatingAnimalCells.getFluid(100))
                .inputFluids(GTMaterials.Mutagen.getFluid(100))
                .EUt(7680)
                .duration(200)
                .addData("filter_casing", 2)
                .addData("radioactivity", 60)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("brevibacterium"))
                .notConsumable(GTEItems.BREVIBACTERIUM_PETRI_DISH.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.BrevibacteriumFlavium, 16)
                .outputItems(TagPrefix.dust, GTEMaterials.BrevibacteriumFlavium, 64)
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(100))
                .inputFluids(GTMaterials.Bacteria.getFluid(100))
                .EUt(480)
                .duration(200)
                .addData("filter_casing", 2)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("bifidobacteriumm"))
                .notConsumable(GTEItems.BIFIDOBACTERIUMM_PETRI_DISH.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.BifidobacteriumBreve, 16)
                .outputItems(TagPrefix.dust, GTEMaterials.BifidobacteriumBreve, 64)
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(100))
                .inputFluids(GTMaterials.Bacteria.getFluid(100))
                .EUt(480)
                .duration(200)
                .addData("filter_casing", 2)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("eschericia"))
                .notConsumable(GTEItems.ESCHERICIA_PETRI_DISH.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.EschericiaColi, 16)
                .outputItems(TagPrefix.dust, GTEMaterials.EschericiaColi, 64)
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(100))
                .inputFluids(GTMaterials.Bacteria.getFluid(100))
                .EUt(480)
                .duration(200)
                .addData("filter_casing", 2)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("streptococcus"))
                .notConsumable(GTEItems.STREPTOCOCCUS_PETRI_DISH.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.StreptococcusPyogenes, 16)
                .outputItems(TagPrefix.dust, GTEMaterials.StreptococcusPyogenes, 64)
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(100))
                .inputFluids(GTMaterials.Bacteria.getFluid(100))
                .EUt(480)
                .duration(200)
                .addData("filter_casing", 2)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("cupriavidus"))
                .notConsumable(GTEItems.CUPRIAVIDUS_PETRI_DISH.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.CupriavidusNecator, 16)
                .outputItems(TagPrefix.dust, GTEMaterials.CupriavidusNecator, 64)
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(100))
                .inputFluids(GTMaterials.Bacteria.getFluid(100))
                .EUt(480)
                .duration(200)
                .addData("filter_casing", 2)
                .save();

        INCUBATOR_RECIPES.recipeBuilder(GTECore.id("shewanella"))
                .notConsumable(GTEItems.SHEWANELLA_PETRI_DISH.asItem())
                .inputItems(TagPrefix.dust, GTEMaterials.Shewanella, 16)
                .outputItems(TagPrefix.dust, GTEMaterials.Shewanella, 64)
                .inputFluids(GTEMaterials.BacterialGrowthMedium.getFluid(100))
                .inputFluids(GTMaterials.Bacteria.getFluid(100))
                .EUt(480)
                .duration(200)
                .addData("filter_casing", 2)
                .save();
    }
}
