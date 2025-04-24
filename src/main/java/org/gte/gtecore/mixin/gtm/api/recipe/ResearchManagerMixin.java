package org.gte.gtecore.mixin.gtm.api.recipe;

import org.gte.gtecore.common.data.GTEItems;

import com.gregtechceu.gtceu.utils.ResearchManager;

import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ResearchManager.class)
public class ResearchManagerMixin {

    @Inject(method = "getDefaultResearchStationItem", at = @At("HEAD"), remap = false, cancellable = true)
    private static void getDefaultResearchStationItem(int cwut, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack stack = null;
        if (cwut > 16384) {
            stack = GTEItems.MICROCOSM.asStack();
        } else if (cwut > 4096) {
            stack = GTEItems.OBSIDIAN_MATRIX.asStack();
        } else if (cwut > 1024) {
            stack = GTEItems.ATOMIC_ARCHIVES.asStack();
        } else if (cwut > 256) {
            stack = GTEItems.NEURAL_MATRIX.asStack();
        }
        if (stack == null) return;
        cir.setReturnValue(stack);
    }
}
