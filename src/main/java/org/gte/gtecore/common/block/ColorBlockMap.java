package org.gte.gtecore.common.block;

import org.gte.gtecore.common.data.GTEBlocks;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import com.google.common.collect.ImmutableMap;

public final class ColorBlockMap {

    public static final ImmutableMap<DyeColor, Block> ABS_MAP;

    static {
        ImmutableMap.Builder<DyeColor, Block> ABSBuilder = ImmutableMap.builder();

        ABSBuilder.put(DyeColor.BLACK, GTEBlocks.ABS_BLACK_CASING.get());
        ABSBuilder.put(DyeColor.BLUE, GTEBlocks.ABS_BLUE_CASING.get());
        ABSBuilder.put(DyeColor.BROWN, GTEBlocks.ABS_BROWN_CASING.get());
        ABSBuilder.put(DyeColor.GREEN, GTEBlocks.ABS_GREEN_CASING.get());
        ABSBuilder.put(DyeColor.GRAY, GTEBlocks.ABS_GREY_CASING.get());
        ABSBuilder.put(DyeColor.LIME, GTEBlocks.ABS_LIME_CASING.get());
        ABSBuilder.put(DyeColor.ORANGE, GTEBlocks.ABS_ORANGE_CASING.get());
        ABSBuilder.put(DyeColor.RED, GTEBlocks.ABS_RAD_CASING.get());
        ABSBuilder.put(DyeColor.WHITE, GTEBlocks.ABS_WHITE_CASING.get());
        ABSBuilder.put(DyeColor.YELLOW, GTEBlocks.ABS_YELLOW_CASING.get());
        ABSBuilder.put(DyeColor.CYAN, GTEBlocks.ABS_CYAN_CASING.get());
        ABSBuilder.put(DyeColor.MAGENTA, GTEBlocks.ABS_MAGENTA_CASING.get());
        ABSBuilder.put(DyeColor.PINK, GTEBlocks.ABS_PINK_CASING.get());
        ABSBuilder.put(DyeColor.PURPLE, GTEBlocks.ABS_PURPLE_CASING.get());
        ABSBuilder.put(DyeColor.LIGHT_BLUE, GTEBlocks.ABS_LIGHT_BULL_CASING.get());
        ABSBuilder.put(DyeColor.LIGHT_GRAY, GTEBlocks.ABS_LIGHT_GREY_CASING.get());

        ABS_MAP = ABSBuilder.build();
    }
}
