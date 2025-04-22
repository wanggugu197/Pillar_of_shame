package org.gte.gtecore.common.data.material;

import org.gte.gtecore.api.data.chemical.material.info.GTEMaterialFlags;
import org.gte.gtecore.api.data.chemical.material.info.GTEMaterialIconSet;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.common.data.GTElements;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.util.List;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gte.gtecore.common.data.GTEMaterials.*;
import static org.gte.gtecore.utils.register.MaterialsRegisterUtils.material;

public interface GTMaterialExtend {

    static void init() {
        Neutron = Neutronium;
        Neutron.setMaterialARGB(0x10102);
        Electrum.setProperty(BLAST, new BlastProperty(740));
        Neutron.setProperty(BLAST, new BlastProperty(17690));
        Neutronium = material("amprosium", "安普洛")
                .ingot(6)
                .liquid((new FluidBuilder()).temperature(10000))
                .color(16777215)
                .iconSet(GTEMaterialIconSet.AMPROSIUM)
                .secondaryColor(0)
                .appendFlags(GTMaterials.EXT_METAL, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_LONG_ROD)
                .element(GTElements.Nq2)
                .toolStats(ToolProperty.Builder.of(160.0F, 80.0F, 65535, 6).attackSpeed(0.5F).enchantability(33).magnetic().build()).rotorStats(400, 250, 12.0F, 655360)
                .fluidPipeProperties(100000, 5000, true, true, true, true).radioactiveHazard(10.0F)
                .buildAndRegister()
                .setFormula("Ap", false);

        PlatinumMetal = material("platinum_metal", "铂金属")
                .dust()
                .color(0xfff4ba).secondaryColor(0x8d8d71)
                .iconSet(MaterialIconSet.LIGNITE)
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        PalladiumMetal = material("palladium_metal", "钯金属")
                .dust()
                .color(0xbd92b5).secondaryColor(0x535b14)
                .iconSet(MaterialIconSet.LIGNITE)
                .components(Palladium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        NaquadahOxideMixture = material("naquadah_oxide_mixture", "氧化硅岩混合物")
                .dust()
                .color(0x000A1B)
                .iconSet(MaterialIconSet.LIGNITE)
                .buildAndRegister();

        Cooperite.setComponents(new MaterialStack(PlatinumMetal, 3), new MaterialStack(Nickel, 1), new MaterialStack(Sulfur, 1), new MaterialStack(PalladiumMetal, 1));
        RutheniumTriniumAmericiumNeutronate.setComponents(new MaterialStack(Ruthenium, 1), new MaterialStack(Trinium, 2), new MaterialStack(Americium, 1), new MaterialStack(Neutronium, 2), new MaterialStack(Oxygen, 8));
        Clay.addFlags(GTEMaterialFlags.GENERATE_SMALL_DUST);
        Brick.addFlags(GTEMaterialFlags.GENERATE_SMALL_DUST);
        SodiumHydroxide.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        PotassiumDichromate.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        RareEarth.addFlags(GTEMaterialFlags.GENERATE_SMALL_DUST);
        AntimonyTrioxide.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        Ash.addFlags(GTEMaterialFlags.GENERATE_SMALL_DUST, GTEMaterialFlags.GENERATE_TINY_DUST);
        DarkAsh.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        Bone.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        NaquadriaSulfate.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        InertMetalMixture.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        RarestMetalMixture.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        AntimonyTrioxide.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        Meat.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        Obsidian.addFlags(GTEMaterialFlags.GENERATE_TINY_DUST);
        Stone.addFlags(GTEMaterialFlags.GENERATE_SMALL_DUST);
        Silicon.addFlags(GTEMaterialFlags.GENERATE_CRYSTAL_SEED);
        Diamond.addFlags(GTEMaterialFlags.GENERATE_ARTIFICIAL_GEM);
        Sapphire.addFlags(GTEMaterialFlags.GENERATE_ARTIFICIAL_GEM);
        Ruby.addFlags(GTEMaterialFlags.GENERATE_ARTIFICIAL_GEM);
        Emerald.addFlags(GTEMaterialFlags.GENERATE_ARTIFICIAL_GEM);
        RhodiumPlatedPalladium.addFlags(DISABLE_ALLOY_PROPERTY);
        YttriumBariumCuprate.addFlags(DISABLE_ALLOY_PROPERTY);
        IncoloyMA956.addFlags(GENERATE_GEAR);
        Kanthal.getProperty(BLAST).setEUtOverride(GTValues.VA[GTValues.MV]);
        Netherite.setProperty(BLAST, new BlastProperty(1748, BlastProperty.GasTier.MID, 480, 1340, 120, 120));
        Strontium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Barium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Cadmium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Iron.setProperty(PropertyKey.TOOL, ToolProperty.Builder.of(2.0F, 2.0F, 256, 2, GTToolType.MINING_HAMMER, GTToolType.SPADE, GTToolType.SAW, GTToolType.HARD_HAMMER, GTToolType.WRENCH, GTToolType.FILE, GTToolType.CROWBAR, GTToolType.SCREWDRIVER, GTToolType.WIRE_CUTTER, GTToolType.SCYTHE, GTToolType.BUTCHERY_KNIFE, GTToolType.DRILL_LV, GTToolType.DRILL_MV, GTToolType.DRILL_HV, GTToolType.DRILL_EV, GTToolType.DRILL_IV, GTToolType.CHAINSAW_LV, GTToolType.WRENCH_LV, GTToolType.WRENCH_HV, GTToolType.WRENCH_IV, GTToolType.BUZZSAW, GTToolType.SCREWDRIVER_LV, GTToolType.WIRE_CUTTER_LV, GTToolType.WIRE_CUTTER_HV, GTToolType.WIRE_CUTTER_IV).enchantability(14).addTypes(GTToolType.MORTAR).build());
        Platinum.setProperty(BLAST, new BlastProperty(1810, BlastProperty.GasTier.MID, 480, 820, 120, 110));
        RedAlloy.addFlags(GENERATE_SPRING_SMALL);
        PhosphorusPentoxide.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Iodine.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Magnesium.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Hafnium.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Bismuth.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Tin.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Rhenium.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Zinc.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Nickel.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Copper.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        OsmiumTetroxide.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Ferrosilite.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Silver.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Platinum.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Palladium.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        RhodiumPlatedPalladium.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        Brass.addFlags(GTEMaterialFlags.GENERATE_CATALYST);
        HastelloyC276.addFlags(GENERATE_ROTOR);
        Steel.addFlags(GTEMaterialFlags.GENERATE_COMPONENT);
        Aluminium.addFlags(GTEMaterialFlags.GENERATE_COMPONENT);
        StainlessSteel.addFlags(GTEMaterialFlags.GENERATE_COMPONENT);
        Titanium.addFlags(GTEMaterialFlags.GENERATE_COMPONENT);
        TungstenSteel.addFlags(GTEMaterialFlags.GENERATE_COMPONENT);
        HSSS.addFlags(GTEMaterialFlags.GENERATE_COMPONENT);
        Osmiridium.addFlags(GTEMaterialFlags.GENERATE_COMPONENT);
        Tritanium.addFlags(GTEMaterialFlags.GENERATE_COMPONENT, GENERATE_ROTOR);
        Monazite.addFlags(DISABLE_DECOMPOSITION);
        Bastnasite.addFlags(DISABLE_DECOMPOSITION);
        PotassiumSulfate.setComponents(new MaterialStack(Potassium, 2), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4));
        AmmoniumChloride.setComponents(new MaterialStack(Nitrogen, 1), new MaterialStack(Hydrogen, 4), new MaterialStack(Chlorine, 1));
        Duranium.addFlags(GENERATE_FRAME);
        Naquadria.addFlags(GENERATE_FRAME);
        Trinium.addFlags(GENERATE_FRAME);
        Copper.addFlags(GENERATE_SMALL_GEAR);
        Europium.getProperty(BLAST).setBlastTemperature(9602);
        Neutronium.setProperty(BLAST, new BlastProperty(11210));
        Neutronium.addFlags(GENERATE_ROTOR, GENERATE_SPRING, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_SPRING_SMALL);
        Neutronium.setProperty(WIRE, new WireProperties((int) GTValues.V[GTValues.UIV], 2, 64));
        Mendelevium.setProperty(WIRE, new WireProperties((int) GTValues.V[GTValues.UHV], 4, 16));
        RutheniumTetroxide.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        RutheniumTetroxide.addFlags(NO_UNIFICATION);
        Actinium.setProperty(DUST, new DustProperty());
        Actinium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Selenium.setProperty(DUST, new DustProperty());
        Aluminium.addFlags(GENERATE_ROTOR);
        Neutronium.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Carbon.setProperty(INGOT, new IngotProperty());
        RadAway.addFlags(DISABLE_DECOMPOSITION);
        Platinum.addFlags(GENERATE_SPRING);
        Chromium.addFlags(GENERATE_GEAR);
        Naquadah.addFlags(GTEMaterialFlags.GENERATE_NANITES, GENERATE_FRAME);
        NaquadahAlloy.addFlags(GENERATE_FINE_WIRE);
        RutheniumTriniumAmericiumNeutronate.addFlags(GENERATE_FINE_WIRE);
        TitaniumTungstenCarbide.addFlags(GENERATE_GEAR);
        Europium.addFlags(GENERATE_SPRING_SMALL);
        Germanium.setProperty(INGOT, new IngotProperty());
        Germanium.addFlags(GENERATE_PLATE);
        Germanium.setProperty(BLAST, new BlastProperty(3800, BlastProperty.GasTier.MID, GTValues.VA[GTValues.HV], 700, 120, 140));
        Sodium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Seaborgium.setProperty(INGOT, new IngotProperty());
        Seaborgium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Seaborgium.addFlags(GENERATE_PLATE);
        Dubnium.setProperty(INGOT, new IngotProperty());
        Dubnium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Dubnium.addFlags(GENERATE_FINE_WIRE);
        Rhenium.setProperty(INGOT, new IngotProperty());
        Rhenium.addFlags(GENERATE_PLATE);
        Rhenium.setProperty(BLAST, new BlastProperty(7400, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 900, 480, 240));
        Calcium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Calcium.setProperty(INGOT, new IngotProperty());
        Praseodymium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Praseodymium.setProperty(DUST, new DustProperty());
        Gadolinium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Gadolinium.setProperty(DUST, new DustProperty());
        Terbium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Terbium.setProperty(DUST, new DustProperty());
        Dysprosium.setProperty(DUST, new DustProperty());
        Dysprosium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Holmium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Holmium.setProperty(DUST, new DustProperty());
        Erbium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Erbium.setProperty(DUST, new DustProperty());
        Thulium.setProperty(DUST, new DustProperty());
        Thulium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Ytterbium.setProperty(DUST, new DustProperty());
        Ytterbium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Scandium.setProperty(DUST, new DustProperty());
        Scandium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        NaquadahEnriched.addFlags(GENERATE_FRAME);
        NickelZincFerrite.addFlags(GENERATE_FOIL);
        Promethium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Promethium.setProperty(DUST, new DustProperty());
        Polonium.setProperty(INGOT, new IngotProperty());
        Polonium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Polonium.setProperty(BLAST, new BlastProperty(3700, BlastProperty.GasTier.MID, GTValues.VA[GTValues.IV], 400, 120, 160));
        Hafnium.setProperty(INGOT, new IngotProperty());
        Hafnium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Hafnium.setProperty(BLAST, new BlastProperty(6800, BlastProperty.GasTier.MID, GTValues.VA[GTValues.HV], 1100, 480, 180));
        EnderEye.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        EnderPearl.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Protactinium.setProperty(DUST, new DustProperty());
        Protactinium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Neptunium.setProperty(DUST, new DustProperty());
        Neptunium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Curium.setProperty(INGOT, new IngotProperty());
        Curium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Berkelium.setProperty(INGOT, new IngotProperty());
        Berkelium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Einsteinium.setProperty(INGOT, new IngotProperty());
        Einsteinium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Californium.setProperty(INGOT, new IngotProperty());
        Californium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Fermium.setProperty(INGOT, new IngotProperty());
        Fermium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Mendelevium.setProperty(INGOT, new IngotProperty());
        Mendelevium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Oganesson.setProperty(INGOT, new IngotProperty());
        Oganesson.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Oganesson.addFlags(GENERATE_PLATE);
        Flerovium.setProperty(INGOT, new IngotProperty());
        Flerovium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Nobelium.setProperty(INGOT, new IngotProperty());
        Lawrencium.setProperty(INGOT, new IngotProperty());
        Nobelium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Lawrencium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Hassium.setProperty(INGOT, new IngotProperty());
        Hassium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Hassium.addFlags(GENERATE_PLATE);
        Rubidium.setProperty(DUST, new DustProperty());
        Rubidium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Technetium.setProperty(INGOT, new IngotProperty());
        Technetium.setProperty(BLAST, new BlastProperty(5600, BlastProperty.GasTier.MID, GTValues.VA[GTValues.HV], 800, 120, 240));
        Technetium.addFlags(GENERATE_PLATE);
        Francium.setProperty(DUST, new DustProperty());
        Strontium.setProperty(DUST, new DustProperty());
        Zirconium.setProperty(DUST, new DustProperty());
        Radium.setProperty(DUST, new DustProperty());
        Radium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Tellurium.setProperty(DUST, new DustProperty());
        Tellurium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Rutherfordium.setProperty(DUST, new DustProperty());
        Astatine.setProperty(INGOT, new IngotProperty());
        Astatine.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Bohrium.setProperty(INGOT, new IngotProperty());
        Bohrium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Thallium.setProperty(DUST, new DustProperty());
        Thallium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Meitnerium.setProperty(DUST, new DustProperty());
        Meitnerium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Roentgenium.setProperty(INGOT, new IngotProperty());
        Copernicium.setProperty(INGOT, new IngotProperty());
        Nihonium.setProperty(INGOT, new IngotProperty());
        Moscovium.setProperty(INGOT, new IngotProperty());
        Livermorium.setProperty(INGOT, new IngotProperty());
        Tennessine.setProperty(INGOT, new IngotProperty());
        Roentgenium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Copernicium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Nihonium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Moscovium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Livermorium.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Tennessine.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        ReinforcedEpoxyResin.addFlags(GENERATE_ROD);
        Phosphorus.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Tellurium.setProperty(ORE, new OreProperty());
        Rubidium.setProperty(ORE, new OreProperty());
        Rubidium.getProperty(ORE).setOreByProducts(Caesium, Potassium, Sodium);
        Titanium.setProperty(ORE, new OreProperty());
        Titanium.getProperty(ORE).setOreByProducts(Aluminium, Iron);
        Tungsten.setProperty(ORE, new OreProperty());
        Tungsten.getProperty(ORE).setOreByProducts(Lithium, Calcium);
        Indium.setProperty(ORE, new OreProperty());
        Indium.getProperty(ORE).setOreByProducts(Aluminium, Zinc);
        NaquadahEnriched.setProperty(ORE, new OreProperty());
        NaquadahEnriched.getProperty(ORE).setOreByProducts(Naquadah, Sulfur);
        Naquadah.getProperty(ORE).setOreByProducts(List.of(NaquadahOxideMixture));
        Palladium.getProperty(ORE).setOreByProducts(List.of(PalladiumMetal));
        Cooperite.getProperty(PropertyKey.ORE).setOreByProducts(Nickel, Nickel, Cobalt, PalladiumMetal);
        Nickel.getProperty(PropertyKey.ORE).setOreByProducts(Cobalt, Iron, PlatinumMetal);
        EchoShard.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Graphite.setProperty(INGOT, new IngotProperty());
        VanadiumSteel.addFlags(GENERATE_FRAME);
        Lutetium.setProperty(INGOT, new IngotProperty());
        Carbon.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Iron.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Glowstone.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Copper.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Silver.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Gold.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Iridium.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Osmium.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Rhenium.addFlags(GTEMaterialFlags.GENERATE_NANITES);
        Nickel.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Platinum.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Almandine.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Grossular.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Pyrope.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Spessartine.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Chalcopyrite.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Pentlandite.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Sphalerite.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Monazite.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Redstone.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        NaquadahEnriched.addFlags(GTEMaterialFlags.GENERATE_MILLED);
        Titanium.addFlags(GENERATE_FINE_WIRE);
        Titanium.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Boron.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Boron.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Sulfur.setProperty(FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        Sulfur.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Calcium.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Zinc.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Niobium.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Lead.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Silver.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Thorium.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Xenon.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
        Neon.getProperty(FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, (new FluidBuilder()).state(FluidState.PLASMA));
    }
}
