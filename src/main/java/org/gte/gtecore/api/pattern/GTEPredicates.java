package org.gte.gtecore.api.pattern;

import org.gte.gtecore.api.machine.part.GTEPartAbility;
import org.gte.gtecore.common.block.WirelessEnergyUnitBlock;
import org.gte.gtecore.common.data.GTEBlocks;
import org.gte.gtecore.common.data.machines.ManaMachine;
import org.gte.gtecore.utils.FunctionContainer;
import org.gte.gtecore.utils.GTEUtils;

import com.gregtechceu.gtceu.api.block.MetaMachineBlock;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IRotorHolderMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.error.PatternStringError;
import com.gregtechceu.gtceu.api.pattern.predicates.SimplePredicate;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import com.lowdragmc.lowdraglib.utils.BlockInfo;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

import static org.gte.gtecore.api.GTEValues.*;
import static org.gte.gtecore.common.block.BlockMap.*;

public interface GTEPredicates {

    static TraceabilityPredicate glass() {
        return tierBlock(GLASSMAP, GLASS_TIER);
    }

    static TraceabilityPredicate machineCasing() {
        return tierBlock(MACHINECASINGMAP, MACHINE_CASING_TIER);
    }

    static TraceabilityPredicate integralFramework() {
        return tierBlock(INTEGRALFRAMEWORKMAP, INTEGRAL_FRAMEWORK_TIER);
    }

    static TraceabilityPredicate absBlocks() {
        return Predicates.blocks(GTEBlocks.ABS_BLACK_CASING.get(), GTEBlocks.ABS_BLUE_CASING.get(), GTEBlocks.ABS_BROWN_CASING.get(), GTEBlocks.ABS_GREEN_CASING.get(), GTEBlocks.ABS_GREY_CASING.get(), GTEBlocks.ABS_LIME_CASING.get(), GTEBlocks.ABS_ORANGE_CASING.get(), GTEBlocks.ABS_RAD_CASING.get(), GTEBlocks.ABS_WHITE_CASING.get(), GTEBlocks.ABS_YELLOW_CASING.get(), GTEBlocks.ABS_CYAN_CASING.get(), GTEBlocks.ABS_MAGENTA_CASING.get(), GTEBlocks.ABS_PINK_CASING.get(), GTEBlocks.ABS_PURPLE_CASING.get(), GTEBlocks.ABS_LIGHT_BULL_CASING.get(), GTEBlocks.ABS_LIGHT_GREY_CASING.get());
    }

    static TraceabilityPredicate autoLaserAbilities(GTRecipeType... recipeType) {
        TraceabilityPredicate predicate = Predicates.autoAbilities(recipeType, false, false, true, true, true, true);
        for (GTRecipeType type : recipeType) {
            if (type.getMaxInputs(EURecipeCapability.CAP) > 0) {
                predicate = predicate.or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMaxGlobalLimited(2).setPreviewCount(1)).or(Predicates.abilities(PartAbility.INPUT_LASER).setMaxGlobalLimited(1).setPreviewCount(1));
                break;
            } else if (type.getMaxOutputs(EURecipeCapability.CAP) > 0) {
                predicate = predicate.or(Predicates.abilities(PartAbility.OUTPUT_ENERGY).setMaxGlobalLimited(2).setPreviewCount(1)).or(Predicates.abilities(PartAbility.OUTPUT_LASER).setMaxGlobalLimited(1).setPreviewCount(1));
                break;
            }
        }
        return predicate;
    }

    static TraceabilityPredicate autoAccelerateAbilities(GTRecipeType... recipeType) {
        return Predicates.autoAbilities(recipeType).or(Predicates.abilities(GTEPartAbility.ACCELERATE_HATCH).setMaxGlobalLimited(1));
    }

    static TraceabilityPredicate autoMnaAccelerateAbilities(GTRecipeType... recipeType) {
        return autoAccelerateAbilities(recipeType).or(Predicates.blocks(ManaMachine.MANA_AMPLIFIER_HATCH.getBlock()).setMaxGlobalLimited(1));
    }

    static TraceabilityPredicate autoThreadLaserAbilities(GTRecipeType... recipeType) {
        return autoLaserAbilities(recipeType).or(Predicates.abilities(GTEPartAbility.THREAD_HATCH).setMaxGlobalLimited(1)).or(Predicates.abilities(GTEPartAbility.ACCELERATE_HATCH).setMaxGlobalLimited(1));
    }

    static TraceabilityPredicate tierBlock(Int2ObjectMap<Supplier<?>> map, String tierType) {
        BlockInfo[] blockInfos = new BlockInfo[map.size()];
        int index = 0;
        for (Supplier<?> blockSupplier : map.values()) {
            Block block = (Block) blockSupplier.get();
            blockInfos[index] = BlockInfo.fromBlockState(block.defaultBlockState());
            index++;
        }
        return new TraceabilityPredicate(state -> {
            BlockState blockState = state.getBlockState();
            for (Int2ObjectMap.Entry<Supplier<?>> entry : map.int2ObjectEntrySet()) {
                if (blockState.is((Block) entry.getValue().get())) {
                    int tier = entry.getIntKey();
                    int type = state.getMatchContext().getOrPut(tierType, tier);
                    if (type != tier) {
                        state.setError(new PatternStringError("gtecore.machine.pattern.error.tier"));
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }, () -> blockInfos).addTooltips(Component.translatable("gtecore.machine.pattern.error.tier"));
    }

    static TraceabilityPredicate RotorBlock(int tier) {
        return new TraceabilityPredicate(new SimplePredicate(state -> {
            Level level = state.getWorld();
            BlockPos pos = state.getPos();
            MetaMachine machine = MetaMachine.getMachine(level, pos);
            if (machine instanceof IRotorHolderMachine holder && machine.getDefinition().getTier() >= tier) {
                return level.getBlockState(pos.relative(holder.self().getFrontFacing())).isAir();
            }
            return false;
        }, () -> PartAbility.ROTOR_HOLDER.getAllBlocks().stream().filter(b -> b instanceof MetaMachineBlock metaMachineBlock && metaMachineBlock.getDefinition().getTier() >= tier).map(BlockInfo::fromBlock).toArray(BlockInfo[]::new))).addTooltips(Component.translatable("gtceu.multiblock.pattern.clear_amount_3"));
    }

    static TraceabilityPredicate wirelessEnergyUnit() {
        return containerBlock(() -> new FunctionContainer<>(new ArrayList<WirelessEnergyUnitBlock>(), (data, state) -> {
            if (state.getBlockState().getBlock() instanceof WirelessEnergyUnitBlock block) {
                data.add(block);
            }
            return data;
        }), "wirelessEnergyUnit", GTEBlocks.LV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.MV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.HV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.EV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.IV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.LUV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.ZPM_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.UV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.UHV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.UEV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.UIV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.UXV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.OPV_WIRELESS_ENERGY_UNIT.get(), GTEBlocks.MAX_WIRELESS_ENERGY_UNIT.get()).setPreviewCount(1);
    }

    static TraceabilityPredicate fissionComponent() {
        return containerBlock(() -> new FunctionContainer<>(new int[4], (integer, state) -> {
            Block block = state.getBlockState().getBlock();
            if (block == GTEBlocks.FISSION_FUEL_COMPONENT.get()) {
                integer[0]++;
                integer[2] += GTEUtils.adjacentBlock(state.world, state.getPos(), GTEBlocks.FISSION_FUEL_COMPONENT.get());
            } else if (block == GTEBlocks.FISSION_COOLER_COMPONENT.get() && GTEUtils.adjacentBlock(state.world, state.getPos(), GTEBlocks.FISSION_FUEL_COMPONENT.get()) > 1) {
                integer[1]++;
                integer[3] += GTEUtils.adjacentBlock(state.world, state.getPos(), GTEBlocks.FISSION_COOLER_COMPONENT.get());
            }
            return integer;
        }), "fissionComponent", GTEBlocks.FISSION_FUEL_COMPONENT.get(), GTEBlocks.FISSION_COOLER_COMPONENT.get()).setPreviewCount(1);
    }

    static TraceabilityPredicate countBlock(String name, Block... blocks) {
        return containerBlock(() -> new FunctionContainer<>(0, (integer, state) -> ++integer), name, blocks);
    }

    private static <T> TraceabilityPredicate containerBlock(Supplier<FunctionContainer<T, MultiblockState>> containerSupplier, String name, Block... blocks) {
        TraceabilityPredicate predicate = Predicates.blocks(blocks);
        return new TraceabilityPredicate(new SimplePredicate(state -> {
            if (predicate.test(state)) {
                FunctionContainer<T, MultiblockState> container = state.getMatchContext().getOrPut(name, containerSupplier.get());
                container.apply(state);
                return true;
            }
            return false;
        }, () -> predicate.common.stream().map(p -> p.candidates).filter(Objects::nonNull).map(Supplier::get).flatMap(Arrays::stream).toArray(BlockInfo[]::new)));
    }
}
