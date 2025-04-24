package org.gte.gtecore.mixin.gtm.registry;

import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.registries.GTERegistration;
import org.gte.gtecore.common.data.GTECreativeModeTabs;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.register.BlockRegisterUtils;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.MaterialBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTMaterialBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.tterrag.registrate.util.entry.BlockEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(GTMaterialBlocks.class)
public abstract class GTMaterialBlocksMixin {

    @Shadow(remap = false)
    static ImmutableTable.Builder<TagPrefix, Material, BlockEntry<? extends MaterialBlock>> MATERIAL_BLOCKS_BUILDER;

    @Shadow(remap = false)
    private static void registerMaterialBlock(TagPrefix tagPrefix, Material material, GTRegistrate registrate) {}

    @Unique
    private static ImmutableMap<Material, Set<TagPrefix>> ORE_MAP;

    @Unique
    private static final Set<TagPrefix> gTECore$DEEPSLATE = Set.of(TagPrefix.oreDeepslate, GTETagPrefix.SCULK_STONE, GTETagPrefix.GLOOMSLATE);

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public static void generateMaterialBlocks() {
        GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_MATERIAL_BLOCK);
        for (TagPrefix tagPrefix : TagPrefix.values()) {
            if (tagPrefix.doGenerateBlock() && !TagPrefix.ORES.containsKey(tagPrefix)) {
                for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
                    GTRegistrate registrate;
                    if (tagPrefix instanceof GTETagPrefix) {
                        registrate = GTERegistration.REGISTRATE;
                    } else {
                        registrate = registry.getRegistrate();
                    }
                    for (Material material : registry.getAllMaterials()) {
                        if (tagPrefix.doGenerateBlock(material)) {
                            registerMaterialBlock(tagPrefix, material, registrate);
                        }
                    }
                }
            }
        }
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    private static void registerOreBlock(Material material, GTRegistrate registrate) {
        BlockRegisterUtils.registerOreBlock(material, registrate, ORE_MAP, gTECore$DEEPSLATE, MATERIAL_BLOCKS_BUILDER);
    }

    @Inject(method = "generateOreBlocks", at = @At("TAIL"), remap = false)
    private static void generateOreBlocks(CallbackInfo ci) {
        ORE_MAP = null;
    }

    static {
        ImmutableMap.Builder<Material, Set<TagPrefix>> OREBuilder = ImmutableMap.builder();
        OREBuilder.put(GTMaterials.Electrotine, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Garnierite, Set.of(GTETagPrefix.MERCURY_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Oilsands, Set.of(GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Opal, Set.of(GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Pyrite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTEMaterials.Ostrum, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.CERES_STONE));
        OREBuilder.put(GTMaterials.CertusQuartz, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.GraniticMineralSand, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE));
        OREBuilder.put(GTMaterials.Amethyst, Set.of(GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTEMaterials.Calorite, Set.of(GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Alunite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Sapphire, Set.of(GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.VanadiumMagnetite, Set.of(GTETagPrefix.MARS_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.VENUS_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Bornite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.GLACIO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Cobaltite, Set.of(GTETagPrefix.MERCURY_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Cooperite, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.GLACIO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Magnesite, Set.of(GTETagPrefix.TITAN_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Gold, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.GLACIO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.VENUS_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Titanium, Set.of(GTETagPrefix.ENCELADUS_STONE));
        OREBuilder.put(GTMaterials.Cobalt, Set.of(GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Malachite, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Redstone, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.ENCELADUS_STONE));
        OREBuilder.put(GTMaterials.BlueTopaz, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Spessartine, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE));
        OREBuilder.put(GTMaterials.Uraninite, Set.of(GTETagPrefix.PLUTO_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Pyrochlore, Set.of(GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Goethite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Trona, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Saltpeter, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Spodumene, Set.of(GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Mica, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.GarnetYellow, Set.of(GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Beryllium, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Sulfur, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Gypsum, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE));
        OREBuilder.put(GTMaterials.Tungsten, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.GarnetSand, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Cassiterite, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.NetherQuartz, Set.of(TagPrefix.oreNetherrack));
        OREBuilder.put(GTMaterials.GlauconiteSand, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.VENUS_STONE, GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Soapstone, Set.of(GTETagPrefix.CERES_STONE, GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Nickel, Set.of(GTETagPrefix.MERCURY_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Almandine, Set.of(GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Pyrolusite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.GLACIO_STONE, GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Calcite, Set.of(GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Sodalite, Set.of(GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Zeolite, Set.of(GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Lithium, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE));
        OREBuilder.put(GTMaterials.Silver, Set.of(GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Sphalerite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Ruby, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.ENCELADUS_STONE));
        OREBuilder.put(GTMaterials.Naquadah, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Apatite, Set.of(GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Palladium, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Topaz, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Neodymium, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Bentonite, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Pollucite, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Talc, Set.of(GTETagPrefix.CERES_STONE, GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.CassiteriteSand, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Lepidolite, Set.of(GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Coal, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.GLACIO_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Stibnite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.MARS_STONE, GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.BasalticMineralSand, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE));
        OREBuilder.put(GTMaterials.Salt, Set.of(GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Barite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Magnetite, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.VENUS_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Copper, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Asbestos, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Scheelite, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE));
        OREBuilder.put(GTMaterials.GarnetRed, Set.of(GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Tin, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Realgar, Set.of(GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Iron, Set.of(GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MARS_STONE));
        OREBuilder.put(GTEMaterials.Celestine, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Galena, Set.of(GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Chalcocite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Chromite, Set.of(GTETagPrefix.TITAN_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Tetrahedrite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.MARS_STONE, GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Molybdenite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Kyanite, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Emerald, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Aluminium, Set.of(GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Platinum, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE));
        OREBuilder.put(GTMaterials.Ilmenite, Set.of(GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTEMaterials.Desh, Set.of(GTETagPrefix.TITAN_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.TricalciumPhosphate, Set.of(GTETagPrefix.MARS_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Bauxite, Set.of(GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Lead, Set.of(GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.PLUTO_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Quartzite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.YellowLimonite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Pyrope, Set.of(GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Tungstate, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE));
        OREBuilder.put(GTMaterials.Pentlandite, Set.of(GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.GANYMEDE_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Graphite, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Diatomite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.GLACIO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Cinnabar, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.ENCELADUS_STONE));
        OREBuilder.put(GTMaterials.Lazurite, Set.of(GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTMaterials.Grossular, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE));
        OREBuilder.put(GTMaterials.RockSalt, Set.of(GTETagPrefix.GLACIO_STONE));
        OREBuilder.put(GTEMaterials.Zircon, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Monazite, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Molybdenum, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Powellite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Plutonium239, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Olivine, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Chalcopyrite, Set.of(GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.GANYMEDE_STONE));
        OREBuilder.put(GTMaterials.Bastnasite, Set.of(GTETagPrefix.GLACIO_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.Wulfenite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.ENCELADUS_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Pitchblende, Set.of(GTETagPrefix.PLUTO_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.MOON_STONE));
        OREBuilder.put(GTMaterials.FullersEarth, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE));
        OREBuilder.put(GTMaterials.Diamond, Set.of(GTETagPrefix.IO_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.GreenSapphire, Set.of(GTETagPrefix.TITAN_STONE));
        OREBuilder.put(GTMaterials.Hematite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.IO_STONE, GTETagPrefix.MARS_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.TITAN_STONE, GTETagPrefix.VENUS_STONE));
        OREBuilder.put(GTMaterials.Tantalite, Set.of(TagPrefix.oreNetherrack, GTETagPrefix.GLACIO_STONE, GTETagPrefix.MERCURY_STONE, GTETagPrefix.CERES_STONE, GTETagPrefix.PLUTO_STONE));
        OREBuilder.put(GTMaterials.Lapis, Set.of(GTETagPrefix.GLACIO_STONE));
        ORE_MAP = OREBuilder.build();
    }
}
