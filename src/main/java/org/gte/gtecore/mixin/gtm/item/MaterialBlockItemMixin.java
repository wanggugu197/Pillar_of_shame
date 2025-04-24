package org.gte.gtecore.mixin.gtm.item;

import org.gte.gtecore.api.data.chemical.material.GTEMaterial;
import org.gte.gtecore.api.data.chemical.material.info.GTEMaterialIconSet;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.MaterialBlock;
import com.gregtechceu.gtceu.api.item.MaterialBlockItem;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;

import com.llamalad7.mixinextras.sugar.Local;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MaterialBlockItem.class)
public abstract class MaterialBlockItemMixin extends BlockItem {

    @Shadow(remap = false)
    public abstract @NotNull MaterialBlock getBlock();

    @Unique
    private ICustomRenderer gtecore$customRenderer;

    protected MaterialBlockItemMixin(Block block, Properties properties) {
        super(block, properties);
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), index = 2, argsOnly = true, remap = false)
    private static Item.Properties init(Item.Properties value, @Local(argsOnly = true) MaterialBlock block) {
        if (block.material instanceof GTEMaterial material) {
            Rarity rarity = material.gtecore$rarity();
            if (rarity != null) value.rarity(rarity);
        }
        return value;
    }

    @Inject(method = "<init>", at = @At("RETURN"), remap = false)
    private void MaterialBlockItem(MaterialBlock block, Item.Properties properties, CallbackInfo ci) {
        if (GTCEu.isClientSide()) {
            if (block.material.getMaterialIconSet() instanceof GTEMaterialIconSet iconSet) {
                gtecore$customRenderer = iconSet.getCustomRenderer();
            }
        }
    }

    @Inject(method = "getRenderer", at = @At("HEAD"), remap = false, cancellable = true)
    private void getRenderer(ItemStack stack, CallbackInfoReturnable<IRenderer> cir) {
        if (gtecore$customRenderer != null) {
            cir.setReturnValue(gtecore$customRenderer.getRenderer());
        }
    }

    @Override
    public boolean isFoil(@NotNull ItemStack itemStack) {
        if (getBlock().material instanceof GTEMaterial gteMaterial && gteMaterial.gtecore$glow()) return true;
        return super.isFoil(itemStack);
    }
}
