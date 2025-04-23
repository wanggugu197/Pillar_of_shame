package org.gte.gtecore.utils.register;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.GTEValues;
import org.gte.gtecore.api.machine.SimpleNoEnergyMachine;
import org.gte.gtecore.api.machine.feature.multiblock.ICoilMachine;
import org.gte.gtecore.api.pattern.GTEPredicates;
import org.gte.gtecore.api.registries.GTEMachineBuilder;
import org.gte.gtecore.api.registries.MultiblockBuilder;
import org.gte.gtecore.common.data.GTERecipeModifiers;
import org.gte.gtecore.common.data.machines.MultiBlockA;
import org.gte.gtecore.common.machine.mana.SimpleWorkManaMachine;
import org.gte.gtecore.common.machine.multiblock.generator.CombustionEngineMachine;
import org.gte.gtecore.common.machine.multiblock.generator.GeneratorArrayMachine;
import org.gte.gtecore.common.machine.multiblock.generator.TurbineMachine;
import org.gte.gtecore.common.machine.multiblock.part.WirelessEnergyHatchPartMachine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.*;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.client.renderer.machine.OverlayTieredMachineRenderer;
import com.gregtechceu.gtceu.client.renderer.machine.SimpleGeneratorMachineRenderer;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.gregtechceu.gtceu.common.machine.multiblock.part.LaserHatchPartMachine;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import com.hepdd.gtmthings.GTMThings;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static org.gte.gtecore.api.GTEValues.*;
import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;
import static org.gte.gtecore.utils.register.BlockRegisterUtils.addLang;

public final class MachineRegisterUtils {

    private MachineRegisterUtils() {}

    public static final int[] MANA_TIERS = GTValues.tiersBetween(LV, ZPM);

    private static final MultiblockMachineDefinition DUMMY_MULTIBLOCK = MultiblockMachineDefinition.createDefinition(GTECore.id("dummy"));

    public static final BiConsumer<IMultiController, List<Component>> CHEMICAL_PLANT_DISPLAY = (controller, components) -> {
        double value = 1 - ((ICoilMachine) controller).getCoilTier() * 0.05;
        components.add(Component.translatable("gtecore.machine.eut_multiplier.tooltip", FormattingUtil.formatNumbers(value * 0.8)));
        components.add(Component.translatable("gtecore.machine.duration_multiplier.tooltip", FormattingUtil.formatNumbers(value * 0.6)));
    };

    public static GTEMachineBuilder machine(String name, String cn, Function<IMachineBlockEntity, MetaMachine> metaMachine) {
        addLang(name, cn);
        return REGISTRATE.machine(name, metaMachine);
    }

    public static MultiblockBuilder multiblock(String name, String cn, Function<IMachineBlockEntity, ? extends MultiblockControllerMachine> metaMachine) {
        addLang(name, cn);
        return REGISTRATE.multiblock(name, metaMachine);
    }

    public static MachineDefinition[] registerWirelessEnergyHatch(IO io, int amperage, PartAbility ability) {
        String id = io == IO.IN ? "input" : "output";
        String iao = io == IO.IN ? "in" : "out";
        String render = "wireless_energy_hatch";
        render = switch (amperage) {
            case 2 -> render;
            case 4 -> render + "_4a";
            case 16 -> render + "_16a";
            case 64 -> render + "_64a";
            default -> "wireless_laser_hatch.target";
        };
        String finalRender = render;
        int t = LV;
        if (amperage == 64) t = EV;
        else if (amperage > 64) t = IV;
        return registerTieredMachines("wireless_" + id + "_hatch" + (amperage > 2 ? "_" + amperage + "a" : ""), tier -> (amperage > 2 ? amperage + (amperage > 64 ? "§e安§r" : "安") : "") + GTEValues.VNFR[tier] + "无线" + (io == IO.IN ? "能源" : "动力") + "仓",
                (holder, tier) -> new WirelessEnergyHatchPartMachine(holder, tier, io, amperage), (tier, builder) -> builder
                        .langValue(VNF[tier] + " " + (amperage > 2 ? FormattingUtil.formatNumbers(amperage) + "A " : "") + "Wireless" + (io == IO.IN ? "Energy" : "Dynamo") + " Hatch")
                        .allRotation()
                        .abilities(ability)
                        .tooltips(Component.translatable("gtceu.universal.tooltip.voltage_" + iao, FormattingUtil.formatNumbers(V[tier]), VNF[tier]),
                                Component.translatable("gtceu.universal.tooltip.amperage_" + iao, amperage),
                                Component.translatable("gtceu.universal.tooltip.energy_storage_capacity", FormattingUtil.formatNumbers(WirelessEnergyHatchPartMachine.getHatchEnergyCapacity(tier, amperage))),
                                Component.translatable("gtmthings.machine.wireless_energy_hatch." + id + ".tooltip"))
                        .renderer(() -> new OverlayTieredMachineRenderer(tier, GTMThings.id("block/machine/part/" + finalRender)))
                        .register(),
                tiersBetween(t, MAX));
    }

    public static MachineDefinition[] registerLaserHatch(IO io, int amperage, PartAbility ability) {
        String name = io == IO.IN ? "target" : "source";
        return registerTieredMachines(amperage + "a_laser_" + name + "_hatch", tier -> amperage + "§e安§r" + GTEValues.VNFR[tier] + "激光" + (io == IO.IN ? "靶" : "源") + "仓",
                (holder, tier) -> new LaserHatchPartMachine(holder, io, tier, amperage), (tier, builder) -> builder
                        .langValue(VNF[tier] + " " + FormattingUtil.formatNumbers(amperage) + "A Laser " + FormattingUtil.toEnglishName(name) + " Hatch")
                        .allRotation()
                        .tooltips(Component.translatable("gtceu.machine.laser_hatch." + name + ".tooltip"),
                                Component.translatable("gtceu.machine.laser_hatch.both.tooltip"),
                                Component.translatable("gtceu.universal.disabled"))
                        .abilities(ability)
                        .renderer(() -> new OverlayTieredMachineRenderer(tier, GTCEu.id("block/machine/part/laser_hatch." + name)))
                        .register(),
                tiersBetween(IV, MAX));
    }

    public static MachineDefinition[] registerSimpleGenerator(String name, String cn, GTRecipeType recipeType, Int2IntFunction tankScalingFunction, int... tiers) {
        return registerTieredMachines(name, tier -> "%s%s %s".formatted(GTEValues.VLVHCN[tier], cn, VLVT[tier]),
                (holder, tier) -> new SimpleGeneratorMachine(holder, tier, 0.1F * tier, tankScalingFunction),
                (tier, builder) -> builder
                        .langValue("%s %s %s".formatted(VLVH[tier], FormattingUtil.toEnglishName(name), VLVT[tier]))
                        .editableUI(SimpleGeneratorMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                        .allRotation()
                        .recipeType(recipeType)
                        .recipeModifier(GTERecipeModifiers.SIMPLE_GENERATOR_MACHINEMODIFIER)
                        .addOutputLimit(ItemRecipeCapability.CAP, 0)
                        .addOutputLimit(FluidRecipeCapability.CAP, 0)
                        .renderer(() -> new SimpleGeneratorMachineRenderer(tier, GTECore.id("block/generators/" + name)))
                        .tooltips(Component.translatable("gtecore.machine.efficiency.tooltip", GeneratorArrayMachine.getEfficiency(recipeType, tier)).append("%"))
                        .tooltips(Component.translatable("gtceu.universal.tooltip.amperage_out", GeneratorArrayMachine.getAmperage(tier)))
                        .tooltips(GTMachineUtils.workableTiered(tier, V[tier], V[tier] << 6, recipeType, tankScalingFunction.apply(tier), false))
                        .register(),
                tiers);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, String cn, GTRecipeType recipeType,
                                                             Int2IntFunction tankScalingFunction) {
        return registerSimpleMachines(name, cn, recipeType, tankScalingFunction, GTMachineUtils.ELECTRIC_TIERS);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, String cn,
                                                             GTRecipeType recipeType,
                                                             Int2IntFunction tankScalingFunction,
                                                             int... tiers) {
        return registerSimpleMachines(name, cn, recipeType, tankScalingFunction, GTECore.id("block/machines/" + name), tiers);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, String cn,
                                                             GTRecipeType recipeType,
                                                             Int2IntFunction tankScalingFunction,
                                                             ResourceLocation workableModel, int... tiers) {
        return registerTieredMachines(name, tier -> "%s%s %s".formatted(GTEValues.VLVHCN[tier], cn, VLVT[tier]),
                (holder, tier) -> new SimpleTieredMachine(holder, tier, tankScalingFunction), (tier, builder) -> {
                    builder.recipeModifier(GTERecipeModifiers.OVERCLOCKING);
                    return builder
                            .langValue("%s %s %s".formatted(VLVH[tier], FormattingUtil.toEnglishName(name), VLVT[tier]))
                            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                            .nonYAxisRotation()
                            .recipeType(recipeType)
                            .workableTieredHullRenderer(workableModel)
                            .tooltips(GTMachineUtils.workableTiered(tier, V[tier], V[tier] << 6, recipeType,
                                    tankScalingFunction.apply(tier), true))
                            .register();
                },
                tiers);
    }

    public static MachineDefinition[] registerSimpleNoEnergyMachines(String name, String cn,
                                                                     GTRecipeType recipeType,
                                                                     Int2IntFunction tankScalingFunction,
                                                                     int... tiers) {
        return registerSimpleNoEnergyMachines(name, cn, recipeType, tankScalingFunction, GTECore.id("block/machines/" + name), tiers);
    }

    public static MachineDefinition[] registerSimpleNoEnergyMachines(String name, String cn,
                                                                     GTRecipeType recipeType,
                                                                     Int2IntFunction tankScalingFunction,
                                                                     ResourceLocation workableModel, int... tiers) {
        return registerTieredMachines(name, tier -> "%s%s %s".formatted(GTEValues.VLVHCN[tier], cn, VLVT[tier]),
                (holder, tier) -> new SimpleNoEnergyMachine(holder, tier, tankScalingFunction), (tier, builder) -> builder
                        .langValue("%s %s %s".formatted(VLVH[tier], FormattingUtil.toEnglishName(name), VLVT[tier]))
                        .editableUI(SimpleNoEnergyMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                        .nonYAxisRotation()
                        .recipeType(recipeType)
                        .noRecipeModifier()
                        .workableTieredHullRenderer(workableModel)
                        .tooltips(workableNoEnergy(recipeType, tankScalingFunction.apply(tier)))
                        .register(),
                tiers);
    }

    public static Component[] workableNoEnergy(GTRecipeType recipeType, long tankCapacity) {
        List<Component> tooltipComponents = new ArrayList<>();
        if (recipeType.getMaxInputs(FluidRecipeCapability.CAP) > 0 ||
                recipeType.getMaxOutputs(FluidRecipeCapability.CAP) > 0)
            tooltipComponents
                    .add(Component.translatable("gtceu.universal.tooltip.fluid_storage_capacity",
                            FormattingUtil.formatNumbers(tankCapacity)));
        return tooltipComponents.toArray(Component[]::new);
    }

    public static MachineDefinition[] registerTieredMachines(String name, Function<Integer, String> cn, BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory, BiFunction<Integer, GTEMachineBuilder, MachineDefinition> builder, int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[TIER_COUNT];
        for (int tier : tiers) {
            String n = VN[tier].toLowerCase(Locale.ROOT) + "_" + name;
            if (cn != null) addLang(n, cn.apply(tier));
            GTEMachineBuilder register = REGISTRATE.machine(n, holder -> factory.apply(holder, tier)).tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static Pair<MachineDefinition, MachineDefinition> registerSteamMachines(String name, String cn,
                                                                                   BiFunction<IMachineBlockEntity, Boolean, MetaMachine> factory,
                                                                                   BiFunction<Boolean, GTEMachineBuilder, MachineDefinition> builder) {
        MachineDefinition lowTier = builder.apply(false,
                machine("lp_%s".formatted(name), "低压蒸汽%s".formatted(cn), holder -> factory.apply(holder, false))
                        .langValue("Low Pressure " + FormattingUtil.toEnglishName(name))
                        .tier(0));
        MachineDefinition highTier = builder.apply(true,
                machine("hp_%s".formatted(name), "高压蒸汽%s".formatted(cn), holder -> factory.apply(holder, true))
                        .langValue("High Pressure " + FormattingUtil.toEnglishName(name))
                        .tier(1));
        return Pair.of(lowTier, highTier);
    }

    public static MultiblockMachineDefinition[] registerTieredMultis(String name, Function<Integer, String> cn,
                                                                     BiFunction<IMachineBlockEntity, Integer, MultiblockControllerMachine> factory,
                                                                     BiFunction<Integer, MultiblockBuilder, MultiblockMachineDefinition> builder,
                                                                     int... tiers) {
        MultiblockMachineDefinition[] definitions = new MultiblockMachineDefinition[TIER_COUNT];
        for (int tier : tiers) {
            MultiblockBuilder register = multiblock(VN[tier].toLowerCase(Locale.ROOT) + "_" + name, cn.apply(tier), holder -> factory.apply(holder, tier)).tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static MultiblockMachineDefinition registerLargeCombustionEngine(GTRegistrate registrate, String name, String cn,
                                                                            int tier, GTRecipeType recipeType,
                                                                            Supplier<? extends Block> casing,
                                                                            Supplier<? extends Block> gear,
                                                                            Supplier<? extends Block> intake,
                                                                            ResourceLocation casingTexture,
                                                                            ResourceLocation overlayModel, boolean isGTM) {
        if (!isGTM) addLang(name, cn);
        MultiblockMachineBuilder builder = registrate.multiblock(name, holder -> new CombustionEngineMachine(holder, tier))
                .rotationState(RotationState.ALL)
                .recipeType(recipeType)
                .generator(true)
                .alwaysTryModifyRecipe(true)
                .appearanceBlock(casing)
                .pattern(definition -> FactoryBlockPattern.start()
                        .aisle("XXX", "XDX", "XXX")
                        .aisle("XCX", "CGC", "XCX")
                        .aisle("XCX", "CGC", "XCX")
                        .aisle("AAA", "AYA", "AAA")
                        .where('X', Predicates.blocks(casing.get()))
                        .where('G', Predicates.blocks(gear.get()))
                        .where('C', Predicates.blocks(casing.get()).setMinGlobalLimited(3).or(Predicates.autoAbilities(definition.getRecipeTypes(), false, false, true, true, true, true)).or(Predicates.autoAbilities(true, true, false)))
                        .where('D', Predicates.ability(PartAbility.OUTPUT_ENERGY, Stream.of(EV, IV, LuV, ZPM, UV, UHV).filter(t -> t >= tier).mapToInt(Integer::intValue).toArray()).addTooltips(Component.translatable("gtceu.machine.large_combustion_engine.tooltip.boost_regular", VN[tier])))
                        .where('A', Predicates.blocks(intake.get()).addTooltips(Component.translatable("gtceu.multiblock.pattern.clear_amount_1")))
                        .where('Y', Predicates.controller(Predicates.blocks(definition.getBlock())))
                        .build())
                .workableCasingRenderer(casingTexture, overlayModel)
                .tooltips(Component.translatable("gtceu.universal.tooltip.base_production_eut", V[tier] << 1), Component.translatable("gtceu.universal.tooltip.uses_per_hour_lubricant", FluidHelper.getBucket()), tier > EV ? Component.translatable("gtceu.machine.large_combustion_engine.tooltip.boost_extreme", V[tier] << 3) : Component.translatable("gtceu.machine.large_combustion_engine.tooltip.boost_regular", V[tier] * 6));
        return builder.register();
    }

    public static MultiblockMachineDefinition registerLargeTurbine(GTRegistrate registrate, String name, String cn, int tier, boolean special, GTRecipeType recipeType, Supplier<? extends Block> casing, Supplier<? extends Block> gear, ResourceLocation casingTexture, ResourceLocation overlayModel, boolean isGTM) {
        if (Objects.equals(name, "plasma_large_turbine")) {
            DUMMY_MULTIBLOCK.setItemSupplier(MultiBlockA.VOID_MINER::getItem);
            return DUMMY_MULTIBLOCK;
        }
        if (!isGTM) addLang(name, cn);
        MultiblockMachineBuilder builder = registrate.multiblock(name, holder -> new TurbineMachine(holder, tier, special, false))
                .rotationState(RotationState.ALL)
                .recipeType(recipeType)
                .generator(true)
                .alwaysTryModifyRecipe(true)
                .tooltips(Component.translatable("gtecore.machine.mega_steam_turbine.tooltip.2"))
                .appearanceBlock(casing)
                .pattern(definition -> FactoryBlockPattern.start()
                        .aisle("CCCC", "CHHC", "CCCC")
                        .aisle("CHHC", "RGGR", "CHHC")
                        .aisle("CCCC", "CSHC", "CCCC")
                        .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                        .where('G', Predicates.blocks(gear.get()))
                        .where('C', Predicates.blocks(casing.get()))
                        .where('R', GTEPredicates.RotorBlock(tier).setExactLimit(1)
                                .or(Predicates.abilities(PartAbility.OUTPUT_ENERGY)).setExactLimit(1))
                        .where('H', Predicates.blocks(casing.get()).or(Predicates.autoAbilities(definition.getRecipeTypes(), false, false, true, true, true, true).or(Predicates.autoAbilities(true, true, false))))
                        .build())
                .workableCasingRenderer(casingTexture, overlayModel)
                .tooltips(Component.translatable("gtceu.universal.tooltip.base_production_eut", (int) (V[tier] * (special ? 2.5 : 2))), Component.translatable("gtceu.multiblock.turbine.efficiency_tooltip", VNF[tier]));
        return builder.register();
    }

    //////////////////////////////////////
    // *** Mana Machine ***//
    //////////////////////////////////////
    public static GTEMachineBuilder manaMachine(String name, String cn, Function<IMachineBlockEntity, MetaMachine> metaMachine) {
        addLang(name, cn);
        return REGISTRATE.manaMachine(name, metaMachine);
    }

    public static MachineDefinition[] registerSimpleManaMachines(String name, String cn, GTRecipeType recipeType, Int2IntFunction tankScalingFunction, ResourceLocation workableModel, int... tiers) {
        return registerTieredManaMachines(name, tier -> "%s%s".formatted(MANACN[tier], cn), (holder, tier) -> new SimpleWorkManaMachine(holder, tier, tankScalingFunction), (tier, builder) -> {
            builder.noRecipeModifier();
            return builder
                    .langValue("%s %s".formatted(MANAN[tier], FormattingUtil.toEnglishName(name)))
                    .editableUI(SimpleNoEnergyMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                    .nonYAxisRotation()
                    .recipeType(recipeType)
                    .tooltips(Component.translatable("gtecore.machine.mana_eu").withStyle(ChatFormatting.GREEN))
                    .tooltips(Component.translatable("gtceu.machine.perfect_oc").withStyle(ChatFormatting.YELLOW))
                    .tooltips(Component.translatable("gtecore.machine.mana_input", Component.literal(GTEValues.MANA[tier] + " /t").withStyle(ChatFormatting.WHITE)).withStyle(ChatFormatting.AQUA))
                    .workableTieredHullRenderer(workableModel)
                    .tooltips(workableNoEnergy(recipeType, tankScalingFunction.apply(tier)))
                    .register();
        },
                tiers);
    }

    public static MachineDefinition[] registerTieredManaMachines(String name, Function<Integer, String> cn, BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory, BiFunction<Integer, GTEMachineBuilder, MachineDefinition> builder, int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[TIER_COUNT];
        for (int tier : tiers) {
            GTEMachineBuilder register = manaMachine(VN[tier].toLowerCase(Locale.ROOT) + "_" + name, cn.apply(tier), holder -> factory.apply(holder, tier)).tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }
}
