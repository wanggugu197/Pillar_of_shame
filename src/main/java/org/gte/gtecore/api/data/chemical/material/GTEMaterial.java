package org.gte.gtecore.api.data.chemical.material;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;

import net.minecraft.world.item.Rarity;

public interface GTEMaterial {

    MaterialProperties gtecore$getProperties();

    Rarity gtecore$rarity();

    void gtecore$setRarity(Rarity rarity);

    boolean gtecore$glow();

    void gtecore$setGlow();

    int gtecore$temp();

    void gtecore$setTemp(int temp);
}
