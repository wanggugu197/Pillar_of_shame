package org.gte.gtecore.mixin.gtm.registry;

import org.gte.gtecore.api.registries.GTERegistration;
import org.gte.gtecore.common.data.GTECreativeModeTabs;

import com.gregtechceu.gtceu.common.data.GTBlocks;

import net.minecraft.world.level.block.Block;

import com.tterrag.registrate.util.entry.BlockEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static org.gte.gtecore.common.block.BlockMap.MACHINECASINGMAP;

@Mixin(GTBlocks.class)
public class GTBlocksMixin {

    @Inject(method = "createMachineCasingBlock(I)Lcom/tterrag/registrate/util/entry/BlockEntry;", at = @At(value = "TAIL"), remap = false)
    private static void createMachineCasingBlock(int tier, CallbackInfoReturnable<BlockEntry<Block>> cir) {
        BlockEntry<Block> block = cir.getReturnValue();
        MACHINECASINGMAP.put(tier, block);
    }

    @Inject(method = "init", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;creativeModeTab(Ljava/util/function/Supplier;)V", ordinal = 1), remap = false)
    private static void setPipeCreativeModeTab(CallbackInfo ci) {
        GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_MATERIAL_PIPE);
    }
}
