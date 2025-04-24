package org.gte.gtecore.mixin.gtm.chemical;

import org.gte.gtecore.api.data.chemical.material.GTEMaterial;
import org.gte.gtecore.api.data.chemical.material.info.GTEMaterialIconSet;
import org.gte.gtecore.client.renderer.item.MaterialsColorMap;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import net.minecraft.world.item.Rarity;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.IntSupplier;

@Mixin(Material.class)
public abstract class MaterialMixin implements GTEMaterial {

    @Shadow(remap = false)
    @Final
    private @NotNull MaterialProperties properties;

    @Shadow(remap = false)
    public abstract ImmutableList<MaterialStack> getMaterialComponents();

    @Unique
    private long gTECore$mass;

    @Unique
    private int gTECore$temp;

    @Unique
    private Rarity gtecore$rarity;

    @Unique
    private boolean gtecore$glow;

    @Override
    public Rarity gtecore$rarity() {
        return gtecore$rarity;
    }

    @Override
    public void gtecore$setRarity(Rarity rarity) {
        this.gtecore$rarity = rarity;
    }

    @Override
    public boolean gtecore$glow() {
        return gtecore$glow;
    }

    @Override
    public void gtecore$setGlow() {
        this.gtecore$glow = true;
    }

    @Override
    public MaterialProperties gtecore$getProperties() {
        return properties;
    }

    @Override
    public int gtecore$temp() {
        return gTECore$temp;
    }

    @Override
    public void gtecore$setTemp(int temp) {
        gTECore$temp = temp;
    }

    @Inject(method = "getMaterialIconSet", at = @At("HEAD"), remap = false, cancellable = true)
    private void getMaterialIconSet(CallbackInfoReturnable<MaterialIconSet> cir) {
        if ((Object) this == GTEMaterials.Neutron) {
            cir.setReturnValue(GTEMaterialIconSet.NEUTRONIUM);
        }
    }

    @Inject(method = "getMass", at = @At("HEAD"), remap = false, cancellable = true)
    private void gmass(CallbackInfoReturnable<Long> cir) {
        if (getMaterialComponents() == null || gTECore$mass > 0) cir.setReturnValue(gTECore$mass);
    }

    @Inject(method = "getMass", at = @At("RETURN"), remap = false, cancellable = true)
    private void smass(CallbackInfoReturnable<Long> cir) {
        if (gTECore$mass == 0) {
            gTECore$mass = Math.max(10, Math.min(Integer.MAX_VALUE, cir.getReturnValue()));
            cir.setReturnValue(gTECore$mass);
        }
    }

    @Inject(method = "getMaterialRGB()I", at = @At("HEAD"), remap = false, cancellable = true)
    private void getMaterialRGB(CallbackInfoReturnable<Integer> cir) {
        if (GTCEu.isClientSide()) {
            IntSupplier supplier = MaterialsColorMap.MaterialColors.get(this);
            if (supplier == null) return;
            cir.setReturnValue(supplier.getAsInt());
        }
    }

    @Inject(method = "getMaterialARGB(I)I", at = @At("HEAD"), remap = false, cancellable = true)
    private void getMaterialARGB(CallbackInfoReturnable<Integer> cir) {
        if (GTCEu.isClientSide()) {
            IntSupplier supplier = MaterialsColorMap.MaterialColors.get(this);
            if (supplier == null) return;
            cir.setReturnValue(supplier.getAsInt());
        }
    }
}
