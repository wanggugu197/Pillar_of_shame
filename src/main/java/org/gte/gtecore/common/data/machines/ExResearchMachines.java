package org.gte.gtecore.common.data.machines;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.GTEValues;
import org.gte.gtecore.api.machine.part.GTEPartAbility;
import org.gte.gtecore.api.pattern.GTEPredicates;
import org.gte.gtecore.api.registries.GTEMachineBuilder;
import org.gte.gtecore.client.renderer.machine.ExResearchPartRenderer;
import org.gte.gtecore.common.block.BlockMap;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.GTEMachines;
import org.gte.gtecore.common.data.GTERecipeTypes;
import org.gte.gtecore.common.machine.multiblock.electric.DataCenterMachine;
import org.gte.gtecore.common.machine.multiblock.electric.SupercomputingCenterMachine;
import org.gte.gtecore.common.machine.multiblock.part.research.ExResearchBridgePartMachine;
import org.gte.gtecore.common.machine.multiblock.part.research.ExResearchComputationPartMachine;
import org.gte.gtecore.common.machine.multiblock.part.research.ExResearchCoolerPartMachine;
import org.gte.gtecore.common.machine.multiblock.part.research.ExResearchEmptyPartMachine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.client.renderer.machine.OverlayTieredMachineRenderer;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GTResearchMachines;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.research.ResearchStationMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DataAccessHatchMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Function;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.machine.multiblock.PartAbility.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.machines.GTResearchMachines.OVERHEAT_TOOLTIPS;
import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;
import static org.gte.gtecore.utils.register.BlockRegisterUtils.addLang;
import static org.gte.gtecore.utils.register.MachineRegisterUtils.machine;
import static org.gte.gtecore.utils.register.MachineRegisterUtils.multiblock;

public interface ExResearchMachines {

    static void init() {}

    MultiblockMachineDefinition PROFESSIONAL_SCANNER = multiblock("professional_scanner", "专业扫描仪", ResearchStationMachine::new)
            .tooltipsText("Just a Multiblock Scanner", "一个多方块扫描仪")
            .tooltipsText("Used to scan onto Data Orbs and Data Modules et cetera", "用于扫描数据球和数据模块等")
            .tooltipsText("Requires Computation to work", "需算力来进行工作")
            .tooltipsText("Providing more Computation allows the recipe to run faster", "提供更多的算力可以使扫描进展的更快")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTERecipeTypes.PROFESSIONAL_SCANNER_RECIPES)
            .appearanceBlock(ADVANCED_COMPUTER_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "VVV", "PPP", "PPP", "PPP", "VVV", "XXX")
                    .aisle("XXX", "VAV", "AAA", "AAA", "AAA", "VAV", "XXX")
                    .aisle("XXX", "VAV", "XAX", "XSX", "XAX", "VAV", "XXX")
                    .aisle("XXX", "XAX", "---", "---", "---", "XAX", "XXX")
                    .aisle(" X ", "XAX", "---", "---", "---", "XAX", " X ")
                    .aisle(" X ", "XAX", "-A-", "-H-", "-A-", "XAX", " X ")
                    .aisle("   ", "XXX", "---", "---", "---", "XXX", "   ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(COMPUTER_CASING.get()))
                    .where(' ', any())
                    .where('-', any())
                    .where('V', blocks(COMPUTER_HEAT_VENT.get()))
                    .where('A', blocks(ADVANCED_COMPUTER_CASING.get()))
                    .where('P', blocks(COMPUTER_CASING.get())
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2, 1))
                            .or(abilities(PartAbility.COMPUTATION_DATA_RECEPTION).setExactLimit(1))
                            .or(autoAbilities(true, false, false)))
                    .where('H', abilities(PartAbility.OBJECT_HOLDER))
                    .build())
            .shapeInfo(definition -> MultiblockShapeInfo.builder()
                    .aisle("---", "XXX", "---", "---", "---", "XXX", "---")
                    .aisle("-X-", "XAX", "-A-", "-H-", "-A-", "XAX", "-X-")
                    .aisle("-X-", "XAX", "---", "---", "---", "XAX", "-X-")
                    .aisle("XXX", "XAX", "---", "---", "---", "XAX", "XXX")
                    .aisle("XXX", "VAV", "XAX", "XSX", "XAX", "VAV", "XXX")
                    .aisle("XXX", "VAV", "AAA", "AAA", "AAA", "VAV", "XXX")
                    .aisle("XXX", "VVV", "POP", "PEP", "PMP", "VVV", "XXX")
                    .where('S', ExResearchMachines.PROFESSIONAL_SCANNER, Direction.NORTH)
                    .where('X', COMPUTER_CASING.get())
                    .where('-', Blocks.AIR)
                    .where('V', COMPUTER_HEAT_VENT.get())
                    .where('A', ADVANCED_COMPUTER_CASING.get())
                    .where('P', COMPUTER_CASING.get())
                    .where('O', GTResearchMachines.COMPUTATION_HATCH_RECEIVER, Direction.SOUTH)
                    .where('E', GTMachines.ENERGY_INPUT_HATCH[GTValues.LuV], Direction.SOUTH)
                    .where('M', ConfigHolder.INSTANCE.machines.enableMaintenance ?
                            GTMachines.MAINTENANCE_HATCH.getBlock().defaultBlockState().setValue(
                                    GTMachines.MAINTENANCE_HATCH.get().getRotationState().property, Direction.SOUTH) :
                            COMPUTER_CASING.getDefaultState())
                    .where('H', GTResearchMachines.OBJECT_HOLDER, Direction.SOUTH)
                    .build())
            .sidedWorkableCasingRenderer("block/casings/hpca/advanced_computer_casing",
                    GTCEu.id("block/multiblock/research_station"))
            .register();

    MultiblockMachineDefinition SUPERCOMPUTING_CENTER = multiblock("supercomputing_center", "运算中心", SupercomputingCenterMachine::new)
            .tooltipsText("Putting computers together to provide lots of computing power", "将计算机放置在一起提供大量算力")
            .tooltipsText("The use of advanced cooling solutions enables it to output more computing power", "采用先进的冷却方案使其能够输出更多的算力")
            .tooltipsText("The machine has three levels, switched by placing items in the mainframe:", "机器有三个等级，通过在主机内放置物品切换：")
            .tooltipsText("The structure blocks of each level of the machine need to match the machine level", "每个等级的机器结构方块需要与机器等级匹配")
            .tooltipsText("Level 1: Slots are empty - HPCA series components can be placed", "等级1：槽位空置 - 可放置HPCA系列组件")
            .tooltipsText("Tungsten Borosilicate Glass - Computer Casing - Computer Heat Vent", "钨强化硼玻璃 - 计算机外壳 - 计算机散热口")
            .tooltipsText("Level 2: Place biological host - can place NICH series components", "等级2：放入生物主机 - 可放置NICH系列组件")
            .tooltipsText("Neutronium Borosilicate Glass - Biocomputer Casing - Phase Change Biocomputer Cooling Vents", "安普洛强化硼玻璃 - 生物计算机外壳 - 相变计算机散热口")
            .tooltipsText("Level 3: Place the Hyper-Causal Host - GWCA series components can be placed (with built-in bridge)", "等级3：放入超因果主机 - 可放置GWCA系列组件(自带桥接)")
            .tooltipsText("Taranium Borosilicate Glass - Graviton Computer Casing - Anti Entropy Computer Condensation Matrix", "塔兰强化硼玻璃 - 引力子计算机外壳 - 逆熵计算机冷凝矩阵")
            .tooltipsText("The machine's computing power is affected by the Hashrate correction factor", "机器算力受到 算力修正系数 的影响")
            .tooltipsText("Maximum output computing power = computing power of computing components * Hashrate correction factor", "最大输出算力 = 计算组件的算力和 * 算力修正系数")
            .tooltipsText("When level is 2 or 3, the hashrate correction factor will change", "当等级为2或3时，算力修正系数会发生变化")
            .tooltipsText("Every 10 ticks, the Hashrate correction factor will decrease by ((Hashrate correction factor - 0.4)^2/5000)*(0.8/log(Hashrate correction factor + 6)) but will not be less than 0.8", "每10tick 算力修正系数会减少 ((算力修正系数-0.4)^2/5000)*(0.8/log(算力修正系数+6)) 但是不会小于0.8")
            .tooltipsText("The thermal conductivity can be input through the thermal conductive agent tank to increase the computing power correction coefficient. The thermal conductivity will become invalid after use.", "可以通过导热剂仓输入导热剂增加算力修正系数，导热剂使用后会失效")
            .tooltipsText("If you upgrade to level 4 at level 2, you cannot upgrade further. If you upgrade to level 16 at level 3, you cannot upgrade further.", "等级2时提升到4将无法继续升高，等级3时提升到16将无法继续升高")
            .tooltipsText("The calculation power correction coefficients that can be improved by thermal conductivity multi-function phase change (MFPC) and cascade phase change MFPC (Cascade-MFPC) are", "导热剂多功能相变(MFPC)和串级相变MFPC(Cascade-MFPC)所能提高算力修正系数值分别是")
            .tooltipsText("Block 0.18/0.54 Ingot 0.02/0.06 Nugget 0.0022/0.0066", "块0.18/0.54 条0.02/0.06 粒0.0022/0.0066")
            .tooltipsText("Inputting ice shards is an extremely inefficient method, each providing 0.0001", "输入寒冰碎片是一种效率极低的方式，每个可以提供0.0001")
            .nonYAxisRotation()
            .block(GTBlocks.COMPUTER_CASING)
            .recipe(GTRecipeTypes.DUMMY_RECIPES)
            .nonYAxisRotation()
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("  AAAAAAAAAAA  ", " AA         AA ", "AA           AA", "A             A", "A             A", "A             A", "A             A", "AA           AA", " AA         AA ", "  AAAAAAAAAAA  ")
                    .aisle(" AAABBBBBBBAAA ", "AACCCCCCCCCCCAA", "ACCKKKKKKKKKCCA", " CKKKKKKKKKKKC ", " CKKKKKKKKKKKC ", " CKKKKKKKKKKKC ", " CKKKKKKKKKKKC ", "ACCKKKKKKKKKCCA", "AACCCCCCCCCCCAA", " AA         AA ")
                    .aisle("AAABBBBBBBBBAAA", "ACC         CCA", " C           C ", " K           K ", " K           K ", " K           K ", " K           K ", " C           C ", "ACCKKKKKKKKKCCA", "AA           AA")
                    .aisle("AABBBBBBBBBBBAA", " C  CC   CC  C ", " K  CC   CC  K ", " K  CC   CC  K ", " K  CC   CC  K ", " K  CC   CC  K ", " K  CC   CC  K ", " K  CC   CC  K ", " CKKKKKKKKKKKC ", "A             A")
                    .aisle("ABBBBBBBBBBBBBA", " C  CC   CC  C ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  CC   CC  K ", " CKKKKKKKKKKKC ", "A             A")
                    .aisle("ABBBBBBBBBBBBBA", " C  CC   CC  C ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  CC   CC  K ", " CKKKKKKKKKKKC ", "A             A")
                    .aisle("ABBBBBBBBBBBBBA", " C  CC   CC  C ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  CC   CC  K ", " CKKKKKKKKKKKC ", "A             A")
                    .aisle("ABBBBBBBBBBBBBA", " C  CC   CC  C ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  CC   CC  K ", " CKKKKKKKKKKKC ", "A             A")
                    .aisle("ABBBBBBBBBBBBBA", " C  CC   CC  C ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  DE   ED  K ", " K  CC   CC  K ", " CKKKKKKKKKKKC ", "A             A")
                    .aisle("AABBBBBBBBBBBAA", " C  CC   CC  C ", " K  CC   CC  K ", " K  CC   CC  K ", " K  CC   CC  K ", " K  CC   CC  K ", " K  CC   CC  K ", " K  CC   CC  K ", " CKKKKKKKKKKKC ", "A             A")
                    .aisle("AAABBBBBBBBBAAA", "ACC         CCA", " C           C ", " K           K ", " K           K ", " K           K ", " K           K ", " C           C ", "ACCKKKKKKKKKCCA", "AA           AA")
                    .aisle(" AAABBBBBBBAAA ", "AACCCCCCCCCCCAA", "ACCKKKKKKKKKCCA", " CKKKVVVVVKKKC ", " CKKVVV~VVVKKC ", " CKKKVVVVVKKKC ", " CKKKKKKKKKKKC ", "ACCKKKKKKKKKCCA", "AACCCCCCCCCCCAA", " AA         AA ")
                    .aisle("  AAAAAAAAAAA  ", " AA         AA ", "AA           AA", "A             A", "A             A", "A             A", "A             A", "AA           AA", " AA         AA ", "  AAAAAAAAAAA  ")
                    .where('A', blocks(GTBlocks.ADVANCED_COMPUTER_CASING.get()))
                    .where('B', blocks(GTBlocks.HIGH_POWER_CASING.get()))
                    .where('~', controller(blocks(definition.get())))
                    .where(' ', any())
                    .where('V', blocks(GTBlocks.COMPUTER_CASING.get())
                            .or(blocks(GTEMachines.THERMAL_CONDUCTOR_HATCH.get()).setMaxGlobalLimited(1))
                            .or(abilities(IMPORT_ITEMS))
                            .or(abilities(IMPORT_FLUIDS))
                            .or(abilities(EXPORT_ITEMS))
                            .or(abilities(EXPORT_FLUIDS))
                            .or(abilities(INPUT_ENERGY).setMaxGlobalLimited(2))
                            .or(abilities(COMPUTATION_DATA_TRANSMISSION).setMaxGlobalLimited(1))
                            .or(abilities(MAINTENANCE).setExactLimit(1)))
                    .where('C', GTEPredicates.tierBlock(BlockMap.COMPUTER_CASING_MAP, GTEValues.COMPUTER_CASING_TIER))
                    .where('K', GTEPredicates.glass())
                    .where('E', abilities(GTEPartAbility.COMPUTING_COMPONENT, HPCA_COMPONENT))
                    .where('D', GTEPredicates.tierBlock(BlockMap.COMPUTER_HEAT_MAP, GTEValues.COMPUTER_HEAT_TIER))
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/hpca/computer_casing/back"), GTCEu.id("block/multiblock/large_miner"))
            .register();

    MultiblockMachineDefinition DATA_CENTER = multiblock("data_center", "数据中心", DataCenterMachine::new)
            .tooltipsText("Your home network storage", "你的家庭网络存储器")
            .tooltipsText("Ultra-large data storage, using optical cable transmission", "超大容量数据存储，使用光缆传输")
            .noneRotation()
            .recipe(GTRecipeTypes.DUMMY_RECIPES)
            .appearanceBlock(GTBlocks.COMPUTER_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" AAAAAAA ", "AA     AA", "A       A", "A       A", "A       A", "A       A", "A       A", "AA     AA", " AAAAAAA ")
                    .aisle("AA     AA", "AAAAAAAAA", " ABBBBBA ", " ABBBBBA ", " ABBBBBA ", " ABBBBBA ", " ABBBBBA ", "AAAAAAAAA", "AA     AA")
                    .aisle("A       A", " ACCCCCA ", " B     B ", " B     B ", " B     B ", " B     B ", " B     B ", " ACCCCCA ", "A       A")
                    .aisle("A       A", " ACCCCCA ", " B     B ", " B DDD B ", " B DDD B ", " B DDD B ", " B     B ", " ACCCCCA ", "A       A")
                    .aisle("A       A", " ACCCCCA ", " B     B ", " B DDD B ", " B D D B ", " B DDD B ", " B     B ", " ACC~CCA ", "A       A")
                    .aisle("A       A", " ACCCCCA ", " B     B ", " B DDD B ", " B DDD B ", " B DDD B ", " B     B ", " ACCCCCA ", "A       A")
                    .aisle("A       A", " ACCCCCA ", " B     B ", " B     B ", " B     B ", " B     B ", " B     B ", " ACCCCCA ", "A       A")
                    .aisle("AA     AA", "AAAAAAAAA", " ABBBBBA ", " ABBBBBA ", " ABBBBBA ", " ABBBBBA ", " ABBBBBA ", "AAAAAAAAA", "AA     AA")
                    .aisle(" AAAAAAA ", "AA     AA", "A       A", "A       A", "A       A", "A       A", "A       A", "AA     AA", " AAAAAAA ")
                    .where('~', controller(blocks(definition.get())))
                    .where('A', blocks(GTEBlocks.BIOCOMPUTER_CASING.get()))
                    .where('B', blocks(GTBlocks.HIGH_POWER_CASING.get())
                            .or(abilities(GTEPartAbility.ExDATA_ACCESS)))
                    .where('C', blocks(GTBlocks.HIGH_POWER_CASING.get())
                            .or(abilities(INPUT_ENERGY).setMaxGlobalLimited(2))
                            .or(abilities(OPTICAL_DATA_RECEPTION))
                            .or(abilities(OPTICAL_DATA_TRANSMISSION))
                            .or(abilities(MAINTENANCE).setExactLimit(1)))
                    .where('D', blocks(GTEBlocks.AMPROSIUM_ACTIVE_CASING.get()))
                    .where(' ', any())
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/hpca/high_power_casing"), GTCEu.id("block/multiblock/data_bank"))
            .register();

    MachineDefinition NICH_EMPTY_COMPONENT = registerHPCAPart(
            "nich_empty_component", "空NICH组件",
            ExResearchEmptyPartMachine::new, false, false, 3)
            .register();

    MachineDefinition NICH_COMPUTING_COMPONENTS = registerHPCAPart(
            "nich_computing_components", "NICH计算组件",
            holder -> new ExResearchComputationPartMachine(holder, 3), true, true, 3)
            .tooltips(
                    Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", GTValues.VA[ZPM]),
                    Component.translatable("gtceu.machine.hpca.component_general.max_eut", GTValues.VA[GTValues.UHV]),
                    Component.translatable("gtceu.machine.hpca.component_type.computation_cwut", 64),
                    Component.translatable("gtceu.machine.hpca.component_type.computation_cooling", 16))
            .tooltipBuilder(OVERHEAT_TOOLTIPS)
            .register();

    MachineDefinition NICH_COOLING_COMPONENTS = registerHPCAPart(
            "nich_cooling_components", "NICH冷却组件",
            holder -> new ExResearchCoolerPartMachine(holder, 3), true, false, 3)
            .tooltips(Component.translatable("gtceu.machine.hpca.component_general.max_eut", GTValues.VA[GTValues.UV]),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_active"),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_active_coolant",
                            80, GTMaterials.Helium.getLocalizedName()),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_cooling", 8))
            .register();

    MachineDefinition NICH_BRIDGE_COMPONENT = registerHPCAPart(
            "nich_bridge_component", "NICH桥接组件",
            holder -> new ExResearchBridgePartMachine(holder, 3), true, false, 3)
            .tooltips(Component.translatable("gtceu.machine.hpca.component_type.bridge"),
                    Component.translatable("gtceu.machine.hpca.component_general.max_eut", GTValues.VA[GTValues.UHV]))
            .register();

    MachineDefinition GWCA_EMPTY_COMPONENT = registerHPCAPart(
            "gwca_empty_component", "空GWCA组件",
            ExResearchEmptyPartMachine::new, false, false, 4)
            .register();

    MachineDefinition GWCA_COMPUTING_COMPONENTS = registerHPCAPart(
            "gwca_computing_components", "GWCA计算组件",
            holder -> new ExResearchComputationPartMachine(holder, 4), true, true, 4)
            .tooltips(
                    Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", GTValues.VA[GTValues.UV]),
                    Component.translatable("gtceu.machine.hpca.component_general.max_eut", GTValues.VA[GTValues.UEV]),
                    Component.translatable("gtceu.machine.hpca.component_type.computation_cwut", 1024),
                    Component.translatable("gtceu.machine.hpca.component_type.computation_cooling", 256))
            .tooltipBuilder(OVERHEAT_TOOLTIPS)
            .register();

    MachineDefinition GWCA_COOLING_COMPONENTS = registerHPCAPart(
            "gwca_cooling_components", "GWCA冷却组件",
            holder -> new ExResearchCoolerPartMachine(holder, 4), true, false, 4)
            .tooltips(Component.translatable("gtceu.machine.hpca.component_general.max_eut", GTValues.VA[GTValues.UHV]),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_active"),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_active_coolant",
                            320, GTMaterials.Helium.getLocalizedName()),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_cooling", 64))
            .register();

    MachineDefinition BIO_DATA_ACCESS_HATCH = machine("bio_data_access_hatch", "生物数据访问仓", (holder) -> new DataAccessHatchMachine(holder, UHV, false))
            .tier(UHV)
            .rotationState(RotationState.ALL)
            .abilities(GTEPartAbility.ExDATA_ACCESS)
            .tooltips(Component.translatable("gtceu.machine.data_access_hatch.tooltip.0"),
                    Component.translatable("gtceu.machine.data_access_hatch.tooltip.1", 25),
                    Component.translatable("gtceu.universal.disabled"))
            .renderer(() -> new OverlayTieredMachineRenderer(UHV, GTCEu.id("block/machine/part/data_access_hatch")))
            .register();

    MachineDefinition BLACK_HOLE_DATA_ACCESS_HATCH = machine("black_hole_data_access_hatch", "黑洞数据访问仓", (holder) -> new DataAccessHatchMachine(holder, UIV, false))
            .tier(UIV)
            .rotationState(RotationState.ALL)
            .abilities(GTEPartAbility.ExDATA_ACCESS)
            .tooltips(Component.translatable("gtceu.machine.data_access_hatch.tooltip.0"),
                    Component.translatable("gtceu.machine.data_access_hatch.tooltip.1", 36),
                    Component.translatable("gtceu.universal.disabled"))
            .renderer(() -> new OverlayTieredMachineRenderer(UIV, GTCEu.id("block/machine/part/data_access_hatch")))
            .register();

    MachineDefinition VIRTUAL_UNIVERSE_DATA_ACCESS_HATCH = machine("virtual_universe_data_access_hatch", "虚拟宇宙数据访问仓", (holder) -> new DataAccessHatchMachine(holder, OpV, false))
            .tier(OpV)
            .rotationState(RotationState.ALL)
            .abilities(GTEPartAbility.ExDATA_ACCESS)
            .tooltips(Component.translatable("gtceu.machine.data_access_hatch.tooltip.0"),
                    Component.translatable("gtceu.machine.data_access_hatch.tooltip.1", 49),
                    Component.translatable("gtceu.universal.disabled"))
            .renderer(() -> new OverlayTieredMachineRenderer(OpV, GTCEu.id("block/machine/part/data_access_hatch")))
            .register();

    private static GTEMachineBuilder registerHPCAPart(String name, String cn,
                                                      Function<IMachineBlockEntity, MetaMachine> constructor,
                                                      boolean activeTexture,
                                                      boolean damagedTexture,
                                                      int tire) {
        addLang(name, cn);
        return REGISTRATE.machine(name, constructor)
                .allRotation()
                .abilities(GTEPartAbility.COMPUTING_COMPONENT)
                .renderer(() -> new ExResearchPartRenderer(
                        tire, GTECore.id("block/casings/about_computer/" + name),
                        !activeTexture ? null : GTECore.id("block/casings/about_computer/" + name + "_active"),
                        !activeTexture ? null : GTECore.id("block/casings/about_computer/" + name + "_active_emissive"),
                        !damagedTexture ? null : GTECore.id("block/casings/about_computer/" + "damaged_" + name),
                        !damagedTexture ? null : GTECore.id("block/casings/about_computer/" + "damaged_" + name + "_active"),
                        !damagedTexture ? null : GTECore.id("block/casings/about_computer/" + "damaged_" + name + "_active_emissive")));
    }
}
