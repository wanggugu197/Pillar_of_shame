package org.gte.gtecore.api.data.chemical.material;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;

import net.minecraft.world.item.Rarity;

import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true, fluent = true)
public class GTEMaterialBuilder extends Material.Builder {

    private Rarity rarity;

    private boolean glow;

    private int temp;

    public GTEMaterialBuilder(String name) {
        super(GTECore.id(name));
    }

    @Override
    public GTEMaterialBuilder wood() {
        return (GTEMaterialBuilder) super.wood();
    }

    @Override
    public GTEMaterialBuilder fluid() {
        return (GTEMaterialBuilder) super.fluid();
    }

    @Override
    public GTEMaterialBuilder liquid() {
        return (GTEMaterialBuilder) super.liquid();
    }

    @Override
    public GTEMaterialBuilder plasma() {
        return (GTEMaterialBuilder) super.plasma();
    }

    @Override
    public GTEMaterialBuilder gas() {
        return (GTEMaterialBuilder) super.gas();
    }

    @Override
    public GTEMaterialBuilder dust() {
        return (GTEMaterialBuilder) super.dust();
    }

    @Override
    public GTEMaterialBuilder gem() {
        return (GTEMaterialBuilder) super.gem();
    }

    @Override
    public GTEMaterialBuilder ingot() {
        return (GTEMaterialBuilder) super.ingot();
    }

    @Override
    public GTEMaterialBuilder polymer() {
        return (GTEMaterialBuilder) super.polymer();
    }

    @Override
    public GTEMaterialBuilder ore() {
        return (GTEMaterialBuilder) super.ore();
    }

    @Override
    public GTEMaterialBuilder addOreByproducts(Material... byproducts) {
        return (GTEMaterialBuilder) super.addOreByproducts(byproducts);
    }

    @Override
    public GTEMaterialBuilder color(int color) {
        return (GTEMaterialBuilder) super.color(color);
    }

    @Override
    public GTEMaterialBuilder secondaryColor(int color) {
        return (GTEMaterialBuilder) super.secondaryColor(color);
    }

    @Override
    public GTEMaterialBuilder iconSet(MaterialIconSet iconSet) {
        return (GTEMaterialBuilder) super.iconSet(iconSet);
    }

    @Override
    public GTEMaterialBuilder components(Object... components) {
        return (GTEMaterialBuilder) super.components(components);
    }

    @Override
    public GTEMaterialBuilder flags(MaterialFlag... flags) {
        return (GTEMaterialBuilder) super.flags(flags);
    }

    @Override
    public GTEMaterialBuilder element(Element element) {
        return (GTEMaterialBuilder) super.element(element);
    }

    @Override
    public GTEMaterialBuilder blastTemp(int temp, BlastProperty.GasTier gasTie) {
        return (GTEMaterialBuilder) super.blastTemp(temp, gasTie);
    }

    @Override
    public GTEMaterialBuilder blastTemp(int temp, BlastProperty.GasTier gasTie, int eutOverride) {
        return (GTEMaterialBuilder) super.blastTemp(temp, gasTie, eutOverride);
    }

    @Override
    public GTEMaterialBuilder blastTemp(int temp, BlastProperty.GasTier gasTie, int eutOverride, int durationOverride) {
        return (GTEMaterialBuilder) super.blastTemp(temp, gasTie, eutOverride, durationOverride);
    }

    @Override
    public GTEMaterialBuilder blastTemp(int temp) {
        return (GTEMaterialBuilder) super.blast(temp);
    }

    @Override
    public GTEMaterialBuilder cableProperties(long voltage, int amperage, int loss, boolean isSuperCon) {
        return (GTEMaterialBuilder) super.cableProperties(voltage, amperage, loss, isSuperCon);
    }

    @Override
    public Material buildAndRegister() {
        Material mat = super.buildAndRegister();
        if (mat instanceof GTEMaterial material) {
            if (rarity != null) material.gtecore$setRarity(rarity);
            if (glow) material.gtecore$setGlow();
            if (temp > 0) material.gtecore$setTemp(temp);
        }
        return mat;
    }
}
