package org.gte.gtecore.common.saved;

import org.gte.gtecore.api.data.GTEDimensions;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;

import it.unimi.dsi.fastutil.ints.IntIntImmutablePair;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import static org.gte.gtecore.api.GTEValues.*;

@Getter
public final class DysonSphereSavaedData extends SavedData {

    private final Object2IntOpenHashMap<String> DysonLaunchData;
    private final Object2IntOpenHashMap<String> DysonDamageData;
    private final Object2BooleanOpenHashMap<String> DysonUse;

    public static boolean getDimensionUse(ResourceKey<Level> dim) {
        String galaxy = GTEDimensions.getGalaxy(dim.location());
        if (galaxy == null) return false;
        return INSTANCE.DysonUse.getOrDefault(galaxy, false);
    }

    public static IntIntImmutablePair getDimensionData(ResourceKey<Level> dim) {
        String galaxy = GTEDimensions.getGalaxy(dim.location());
        if (galaxy == null) return IntIntImmutablePair.of(0, 0);
        return IntIntImmutablePair.of(INSTANCE.DysonLaunchData.getOrDefault(galaxy, 0), INSTANCE.DysonDamageData.getOrDefault(galaxy, 0));
    }

    public static int getDimensionLaunchData(ResourceKey<Level> dim) {
        String galaxy = GTEDimensions.getGalaxy(dim.location());
        if (galaxy == null) return 0;
        return INSTANCE.DysonLaunchData.getOrDefault(galaxy, 0);
    }

    public static void setDysonData(ResourceKey<Level> dim, int a, int b) {
        String galaxy = GTEDimensions.getGalaxy(dim.location());
        if (galaxy == null) return;
        INSTANCE.DysonLaunchData.put(galaxy, a);
        INSTANCE.DysonDamageData.put(galaxy, b);
        INSTANCE.setDirty();
    }

    public static void setDysonUse(ResourceKey<Level> dim, boolean a) {
        String galaxy = GTEDimensions.getGalaxy(dim.location());
        if (galaxy == null) return;
        INSTANCE.DysonUse.put(galaxy, a);
        INSTANCE.setDirty();
    }

    public static DysonSphereSavaedData INSTANCE = new DysonSphereSavaedData();

    public DysonSphereSavaedData() {
        DysonDamageData = new Object2IntOpenHashMap<>();
        DysonLaunchData = new Object2IntOpenHashMap<>();
        DysonUse = new Object2BooleanOpenHashMap<>();
    }

    public DysonSphereSavaedData(CompoundTag compoundTag) {
        this();
        ListTag dyson = compoundTag.getList(DYSON_LIST, Tag.TAG_COMPOUND);
        for (int i = 0; i < dyson.size(); i++) {
            CompoundTag tag = dyson.getCompound(i);
            DysonLaunchData.put(tag.getString(GALAXY), tag.getInt(DYSON_COUNT));
            DysonDamageData.put(tag.getString(GALAXY), tag.getInt(DYSON_DAMAGE));
            DysonUse.put(tag.getString(GALAXY), tag.getBoolean(DYSON_USE));
        }
    }

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag compoundTag) {
        ListTag listTag = new ListTag();
        DysonLaunchData.forEach((g, i) -> {
            CompoundTag tag = new CompoundTag();
            tag.putString(GALAXY, g);
            tag.putInt(DYSON_COUNT, i);
            tag.putInt(DYSON_DAMAGE, DysonDamageData.getOrDefault(g, 0));
            tag.putBoolean(DYSON_USE, DysonUse.getOrDefault(g, false));
            listTag.add(tag);
        });
        compoundTag.put(DYSON_LIST, listTag);
        return compoundTag;
    }
}
