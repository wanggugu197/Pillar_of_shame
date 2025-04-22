package org.gte.gtecore.api.data.chemical.material.info;

import org.gte.gtecore.client.renderer.item.HaloItemRenderer;
import org.gte.gtecore.client.renderer.item.StereoscopicItemRenderer;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;

import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import lombok.Getter;

@Getter
public final class GTEMaterialIconSet extends MaterialIconSet {

    private final ICustomRenderer customRenderer;

    private GTEMaterialIconSet(String name, MaterialIconSet parentIconset, boolean isRootIconset, IRenderer customRenderer) {
        this(name, parentIconset, isRootIconset, customRenderer == null ? null : () -> customRenderer);
    }

    private GTEMaterialIconSet(String name, MaterialIconSet parentIconset, boolean isRootIconset, ICustomRenderer customRenderer) {
        super(name, parentIconset, isRootIconset);
        this.customRenderer = customRenderer;
    }

    public static final GTEMaterialIconSet AMPROSIUM = new GTEMaterialIconSet("amprosium", METALLIC, false, HaloItemRenderer.WHITE_HALO);
    public static final GTEMaterialIconSet TRANSCENDENT = new GTEMaterialIconSet("transcendent", METALLIC, false, () -> StereoscopicItemRenderer.INSTANCE);
    public static final GTEMaterialIconSet QUANTUM_CHROMO_DYNAMICALLY = new GTEMaterialIconSet("quantum_chromo_dynamically", METALLIC, false, HaloItemRenderer.QUANTUM_CHROMO_DYNAMICALLY_HALO);
    public static final GTEMaterialIconSet COSMIC = new GTEMaterialIconSet("cosmic", METALLIC, false, HaloItemRenderer.COSMIC_HALO);
    public static final GTEMaterialIconSet CHAOS = new GTEMaterialIconSet("chaos", METALLIC, false, HaloItemRenderer.CHAOS_HALO);
    public static final GTEMaterialIconSet CHAOS_INFINITY = new GTEMaterialIconSet("chaos_infinity", METALLIC, false, HaloItemRenderer.CHAOS_INFINITY_HALO);
    public static final GTEMaterialIconSet NEUTRONIUM = new GTEMaterialIconSet("neutronium", METALLIC, false, HaloItemRenderer.NEUTRONIUM_HALO);
    public static final GTEMaterialIconSet COSMIC_NEUTRONIUM = new GTEMaterialIconSet("cosmic_neutronium", METALLIC, false, HaloItemRenderer.COSMIC_NEUTRONIUM_HALO);
    public static final GTEMaterialIconSet MAGNETOHYDRODYNAMICALLY_CONSTRAINED_STAR_MATTER = new GTEMaterialIconSet("magnetohydrodynamically_constrained_star_matter", null, true, HaloItemRenderer.MAGNETOHYDRODYNAMICALLY_CONSTRAINED_STAR_MATTER_HALO);
    public static final GTEMaterialIconSet INFINITY = new GTEMaterialIconSet("infinity", null, true, HaloItemRenderer.INFINITY_HALO);
    public static final GTEMaterialIconSet ETERNITY = new GTEMaterialIconSet("eternity", null, true, HaloItemRenderer.ETERNITY_HALO);
    public static final GTEMaterialIconSet MAGMATTER = new GTEMaterialIconSet("magmatter", null, true, HaloItemRenderer.MAGMATTER_HALO);

    public static final MaterialIconSet LIMPID = new MaterialIconSet("limpid", DULL);
}
