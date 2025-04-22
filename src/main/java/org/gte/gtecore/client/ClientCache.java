package org.gte.gtecore.client;

import net.minecraft.resources.ResourceLocation;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

public class ClientCache {

    public static boolean disableDrift;

    public static final Set<ResourceLocation> UNLOCKED_PLANET = new ObjectOpenHashSet<>();

    public static boolean initializedBook;

    @Nullable
    public static UUID SERVER_IDENTIFIER;
}
