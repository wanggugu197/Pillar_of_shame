package org.gte.gtecore.common.machine.multiblock.electric.processing;

import org.gte.gtecore.api.machine.feature.multiblock.IMultiStructureMachine;
import org.gte.gtecore.api.machine.multiblock.CrossRecipeMultiblockMachine;
import org.gte.gtecore.api.pattern.GTEPredicates;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTERecipeTypes;
import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.util.List;
import java.util.Map;

import static com.gregtechceu.gtceu.api.machine.multiblock.PartAbility.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;

public final class CompoundExtremeCoolingMachine extends CrossRecipeMultiblockMachine implements IMultiStructureMachine {

    private static final Map<Integer, BlockPattern> PATTERNS = new Int2ObjectOpenHashMap<>(3, 0.9F);

    public CompoundExtremeCoolingMachine(IMachineBlockEntity holder) {
        super(holder, false, true, MachineUtils::getHatchParallel);
    }

    @Override
    public void setActiveRecipeType(int activeRecipeType) {
        super.setActiveRecipeType(activeRecipeType);
        updateCheck();
    }

    public static BlockPattern getBlockPattern(int tier, MachineDefinition definition) {
        FactoryBlockPattern builder = FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.UP, RelativeDirection.BACK).where(' ', any());
        return PATTERNS.computeIfAbsent(tier, t -> {
            if (t == 1) {
                builder.aisle("                   MM     MM       MM     MM                   ", "                   MMHHHHHMM       MMHHHHHMM                   ", "                   MMOOOOOMM       MMOOOOOMM                   ", "                   MMHHHHHMM QQQQQ MMHHHHHMM                   ", "                   MMPPPPPMM QQSQQ MMPPPPPMM                   ", "                   MMHHHHHMM QQQQQ MMHHHHHMM                   ", "                   MMOOOOOMM       MMOOOOOMM                   ", "                   MMHHHHHMM       MMHHHHHMM                   ", "                   MM     MM       MM     MM                   ")
                        .aisle("                 KKMMKKKKKMMQQQQQQQMMKKKKKMMKK                 ", "                 KKKKKKKKKKKKRRRRRKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKRRRRRKKKKKKKKKKKK                 ", "                 KKMMKKKKKMMQQQQQQQMMKKKKKMMKK                 ")
                        .aisle("                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 K LL     LL       LL     LL K                 ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "                 K LL     LL       LL     LL K                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ")
                        .aisle("                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "  E    E    E   KK                           KK   E    E    E  ", " BBBBBBBBBBBBB  KK                           KK  BBBBBBBBBBBBB ", " BBBBBBBBBBBBB  KK                           KK  BBBBBBBBBBBBB ", " BBBBBBBBBBBBB  KK NN     NN       NN     NN KK  BBBBBBBBBBBBB ", " BBBBBBBBBBBBB  KK                           KK  BBBBBBBBBBBBB ", " BBBBBBBBBBBBB  KK                           KK  BBBBBBBBBBBBB ", "  E    E    E   KK                           KK   E    E    E  ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ")
                        .aisle("  E    E    E    KKKKKKKKKKKKKKKKKKKKKKKKKKKKK    E    E    E  ", " BBBBBBBBBBBBB  KKKKKK   KKKKH   HKKKK   KKKKKK  BBBBBBBBBBBBB ", "ACD          CA AC           MMMMM           CA AC          DCA", "ACDFFFFFFFFFFCA AC           MJJJM           CA ACFFFFFFFFFFDCA", "ACD          CA AC NN     NN MJJJM NN     NN CA AC          DCA", "ACDFFFFFFFFFFCA AC           MJJJM           CA ACFFFFFFFFFFDCA", "ACD          CA AC           MMMMM           CA AC          DCA", " BBBBBBBBBBBBB  KKKKKK   KKKKH   HKKKK   KKKKKK  BBBBBBBBBBBBB ", "  E    E    E    KKKKKKKKKKKKKKKKKKKKKKKKKKKKK    E    E    E  ")
                        .aisle("  E    E    E    KKCCKKKKKCCKKKKKKKCCKKKKKCCKK    E    E    E  ", " BBBBBBBBBBBBB  KKKKKK   KKKK     KKKK   KKKKKK  BBBBBBBBBBBBB ", "ACDFFFFFFFFFFCA AC           MJJJM           CA ACFFFFFFFFFFDCA", " DDGGGGGGGGGGGJJJGLLLLLLLLLLLL   LLLLLLLLLLLLGJJJGGGGGGGGGGGDD ", " DDHHHHHHHHHHD   D NN     NN M   M NN     NN D   DHHHHHHHHHHDD ", " DDGGGGGGGGGGGJJJGLLLLLLLLLLLL   LLLLLLLLLLLLGJJJGGGGGGGGGGGDD ", "ACDFFFFFFFFFFCA AC           MJJJM           CA ACFFFFFFFFFFDCA", " BBBBBBBBBBBBB  KKKKKK   KKKK     KKKK   KKKKKK  BBBBBBBBBBBBB ", "  E    E    E    KKCCKKKKKCCKKKKKKKCCKKKKKCCKK    E    E    E  ")
                        .aisle("  E    E    E    KKCCKKKKKCCKKKKKKKCCKKKKKCCKK    E    E    E  ", " BBBBBBBBBBBBB  KKKKKK   KKKK     KKKK   KKKKKK  BBBBBBBBBBBBB ", "ACD          CA AC           MJJJM           CA AC          DCA", " DDHHHHHHHHHHD   D           M   M           D   DHHHHHHHHHHDD ", " DDI         D   D NN     NN M   M NN     NN D   D         IDD ", " DDHHHHHHHHHHD   D           M   M           D   DHHHHHHHHHHDD ", "ACD          CA AC           MJJJM           CA AC          DCA", " BBBBBBBBBBBBB  KKKKKK   KKKK     KKKK   KKKKKK  BBBBBBBBBBBBB ", "  E    E    E    KKCCKKKKKCCKKKKKKKCCKKKKKCCKK    E    E    E  ")
                        .aisle("  E    E    E    KKCCKKKKKCCKKKKKKKCCKKKKKCCKK    E    E    E  ", " BBBBBBBBBBBBB  KKKKKK   KKKK     KKKK   KKKKKK  BBBBBBBBBBBBB ", "ACDFFFFFFFFFFCA AC           MJJJM           CA ACFFFFFFFFFFDCA", " DDGGGGGGGGGGGJJJGLLLLLLLLLLLL   LLLLLLLLLLLLGJJJGGGGGGGGGGGDD ", " DDHHHHHHHHHHD   D NN     NN M   M NN     NN D   DHHHHHHHHHHDD ", " DDGGGGGGGGGGGJJJGLLLLLLLLLLLL   LLLLLLLLLLLLGJJJGGGGGGGGGGGDD ", "ACDFFFFFFFFFFCA AC           MJJJM           CA ACFFFFFFFFFFDCA", " BBBBBBBBBBBBB  KKKKKK   KKKK     KKKK   KKKKKK  BBBBBBBBBBBBB ", "  E    E    E    KKCCKKKKKCCKKKKKKKCCKKKKKCCKK    E    E    E  ")
                        .aisle("  E    E    E    KKKKKKKKKKKKKKKKKKKKKKKKKKKKK    E    E    E  ", " BBBBBBBBBBBBB  KKKKKK   KKKKH   HKKKK   KKKKKK  BBBBBBBBBBBBB ", "ACD          CA AC           MMMMM           CA AC          DCA", "ACDFFFFFFFFFFCA AC           MJJJM           CA ACFFFFFFFFFFDCA", "ACD          CA AC NN     NN MJJJM NN     NN CA AC          DCA", "ACDFFFFFFFFFFCA AC           MJJJM           CA ACFFFFFFFFFFDCA", "ACD          CA AC           MMMMM           CA AC          DCA", " BBBBBBBBBBBBB  KKKKKK   KKKKH   HKKKK   KKKKKK  BBBBBBBBBBBBB ", "  E    E    E    KKKKKKKKKKKKKKKKKKKKKKKKKKKKK    E    E    E  ")
                        .aisle("                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "  E    E    E   KK                           KK   E    E    E  ", " BBBBBBBBBBBBB  KK                           KK  BBBBBBBBBBBBB ", " BBBBBBBBBBBBB  KK                           KK  BBBBBBBBBBBBB ", " BBBBBBBBBBBBB  KK NN     NN       NN     NN KK  BBBBBBBBBBBBB ", " BBBBBBBBBBBBB  KK                           KK  BBBBBBBBBBBBB ", " BBBBBBBBBBBBB  KK                           KK  BBBBBBBBBBBBB ", "  E    E    E   KK                           KK   E    E    E  ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ")
                        .aisle("                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 K LL     LL       LL     LL K                 ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "  E    E    E    K LL     LL       LL     LL K    E    E    E  ", "                 K LL     LL       LL     LL K                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ")
                        .aisle("                 KKMMKKKKKMMQQQQQQQMMKKKKKMMKK                 ", "                 KKKKKKKKKKKKRRRRRKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKKKKKKKKKKKKKKKKKK                 ", "                 KKKKKKKKKKKKRRRRRKKKKKKKKKKKK                 ", "                 KKMMKKKKKMMQQQQQQQMMKKKKKMMKK                 ")
                        .aisle("                   MM     MM       MM     MM                   ", "                   MMHHHHHMM       MMHHHHHMM                   ", "                   MMOOOOOMM       MMOOOOOMM                   ", "                   MMHHHHHMM       MMHHHHHMM                   ", "                   MMPPPPPMM       MMPPPPPMM                   ", "                   MMHHHHHMM       MMHHHHHMM                   ", "                   MMOOOOOMM       MMOOOOOMM                   ", "                   MMHHHHHMM       MMHHHHHMM                   ", "                   MM     MM       MM     MM                   ")
                        .where('A', blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.WatertightSteel)))
                        .where('B', blocks(GCYMBlocks.CASING_LASER_SAFE_ENGRAVING.get()))
                        .where('C', blocks(GTBlocks.HIGH_POWER_CASING.get()))
                        .where('D', blocks(GTEBlocks.LASER_CASING.get()))
                        .where('E', blocks(GTBlocks.SUPERCONDUCTING_COIL.get()))
                        .where('F', blocks(ChemicalHelper.getBlock(TagPrefix.block, GTMaterials.Sapphire)))
                        .where('G', blocks(GTEBlocks.LASER_COOLING_CASING.get()))
                        .where('H', blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.Neutronium)))
                        .where('I', blocks(GTBlocks.BATTERY_ULTIMATE_UHV.get()))
                        .where('J', blocks(GTBlocks.FUSION_GLASS.get()))
                        .where('K', blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get()))
                        .where('L', blocks(GTBlocks.CASING_TUNGSTENSTEEL_PIPE.get()))
                        .where('M', blocks(GTEBlocks.ANTIFREEZE_HEATPROOF_MACHINE_CASING.get()))
                        .where('N', blocks(GTEBlocks.HOLLOW_CASING.get()))
                        .where('O', blocks(GTEBlocks.AMPROSIUM_PIPE_CASING.get()))
                        .where('P', blocks(GTBlocks.FILTER_CASING.get()))
                        .where('Q', blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                                .or(GTEPredicates.autoThreadLaserAbilities(definition.getRecipeTypes()))
                                .or(abilities(PARALLEL_HATCH).setMaxGlobalLimited(1))
                                .or(abilities(MAINTENANCE).setExactLimit(1)))
                        .where('R', blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                        .where('S', controller(blocks(definition.get())));
            } else {
                builder.aisle("   GG     GG       GG     GG   ", "   GGIIIIIGG       GGIIIIIGG   ", "   GGJJJJJGG       GGJJJJJGG   ", "   GGIIIIIGG LLLLL GGIIIIIGG   ", "   GGKKKKKGG LLOLL GGKKKKKGG   ", "   GGIIIIIGG LLLLL GGIIIIIGG   ", "   GGJJJJJGG       GGJJJJJGG   ", "   GGIIIIIGG       GGIIIIIGG   ", "   GG     GG       GG     GG   ")
                        .aisle(" AAGGAAAAAGGLLLLLLLGGAAAAAGGAA ", " AAAAAAAAAAAAMMMMMAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAMMMMMAAAAAAAAAAAA ", " AAGGAAAAAGGLLLLLLLGGAAAAAGGAA ")
                        .aisle(" AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ")
                        .aisle(" AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", "AA                           AA", "AA                           AA", "AA                           AA", "AA HH     HH       HH     HH AA", "AA                           AA", "AA                           AA", "AA                           AA", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ")
                        .aisle(" AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", "AAAAAA   AAAAI   IAAAA   AAAAAA", "BC           GGGGG           CB", "BC           GNNNG           CB", "BC HH     HH GNNNG HH     HH CB", "BC           GNNNG           CB", "BC           GGGGG           CB", "AAAAAA   AAAAI   IAAAA   AAAAAA", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ")
                        .aisle(" AACCAAAAACCAAAAAAACCAAAAACCAA ", "AAAAAA   AAAA     AAAA   AAAAAA", "BC           GNNNG           CB", " DFFFFFFFFFFFF   FFFFFFFFFFFFD ", " E HH     HH G   G HH     HH E ", " DFFFFFFFFFFFF   FFFFFFFFFFFFD ", "BC           GNNNG           CB", "AAAAAA   AAAA     AAAA   AAAAAA", " AACCAAAAACCAAAAAAACCAAAAACCAA ")
                        .aisle(" AACCAAAAACCAAAAAAACCAAAAACCAA ", "AAAAAA   AAAA     AAAA   AAAAAA", "BC           GNNNG           CB", " E           G   G           E ", " E HH     HH G   G HH     HH E ", " E           G   G           E ", "BC           GNNNG           CB", "AAAAAA   AAAA     AAAA   AAAAAA", " AACCAAAAACCAAAAAAACCAAAAACCAA ")
                        .aisle(" AACCAAAAACCAAAAAAACCAAAAACCAA ", "AAAAAA   AAAA     AAAA   AAAAAA", "BC           GNNNG           CB", " DFFFFFFFFFFFF   FFFFFFFFFFFFD ", " E HH     HH G   G HH     HH E ", " DFFFFFFFFFFFF   FFFFFFFFFFFFD ", "BC           GNNNG           CB", "AAAAAA   AAAA     AAAA   AAAAAA", " AACCAAAAACCAAAAAAACCAAAAACCAA ")
                        .aisle(" AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", "AAAAAA   AAAAI   IAAAA   AAAAAA", "BC           GGGGG           CB", "BC           GNNNG           CB", "BC HH     HH GNNNG HH     HH CB", "BC           GNNNG           CB", "BC           GGGGG           CB", "AAAAAA   AAAAI   IAAAA   AAAAAA", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ")
                        .aisle(" AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", "AA                           AA", "AA                           AA", "AA                           AA", "AA HH     HH       HH     HH AA", "AA                           AA", "AA                           AA", "AA                           AA", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ")
                        .aisle(" AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " A FF     FF       FF     FF A ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ")
                        .aisle(" AAGGAAAAAGGLLLLLLLGGAAAAAGGAA ", " AAAAAAAAAAAAMMMMMAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ", " AAAAAAAAAAAAMMMMMAAAAAAAAAAAA ", " AAGGAAAAAGGLLLLLLLGGAAAAAGGAA ")
                        .aisle("   GG     GG       GG     GG   ", "   GGIIIIIGG       GGIIIIIGG   ", "   GGJJJJJGG       GGJJJJJGG   ", "   GGIIIIIGG       GGIIIIIGG   ", "   GGKKKKKGG       GGKKKKKGG   ", "   GGIIIIIGG       GGIIIIIGG   ", "   GGJJJJJGG       GGJJJJJGG   ", "   GGIIIIIGG       GGIIIIIGG   ", "   GG     GG       GG     GG   ")
                        .where('A', blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get()))
                        .where('B', blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.WatertightSteel)))
                        .where('C', blocks(GTBlocks.HIGH_POWER_CASING.get()))
                        .where('D', blocks(GTEBlocks.LASER_COOLING_CASING.get()))
                        .where('E', blocks(GTEBlocks.LASER_CASING.get()))
                        .where('F', blocks(GTBlocks.CASING_TUNGSTENSTEEL_PIPE.get()))
                        .where('G', blocks(GTEBlocks.ANTIFREEZE_HEATPROOF_MACHINE_CASING.get()))
                        .where('H', blocks(GTEBlocks.HOLLOW_CASING.get()))
                        .where('I', blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.Neutronium)))
                        .where('J', blocks(GTEBlocks.AMPROSIUM_PIPE_CASING.get()))
                        .where('K', blocks(GTBlocks.FILTER_CASING.get()))
                        .where('L', blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                                .or(GTEPredicates.autoThreadLaserAbilities(definition.getRecipeTypes()))
                                .or(abilities(PARALLEL_HATCH).setMaxGlobalLimited(1))
                                .or(abilities(MAINTENANCE).setExactLimit(1)))
                        .where('M', blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                        .where('N', blocks(GTBlocks.FUSION_GLASS.get()))
                        .where('O', controller(blocks(definition.get())));
            }
            return builder.build();
        });
    }

    @Override
    public BlockPattern getPattern() {
        return getBlockPattern(getRecipeType() == GTERecipeTypes.PLASMA_CONDENSER_RECIPES ? 1 : 0, getDefinition());
    }

    @Override
    public List<BlockPattern> getMultiPattern() {
        return List.of(getBlockPattern(0, getDefinition()), getBlockPattern(1, getDefinition()));
    }
}
