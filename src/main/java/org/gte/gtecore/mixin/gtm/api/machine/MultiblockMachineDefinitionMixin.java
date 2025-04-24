package org.gte.gtecore.mixin.gtm.api.machine;

import org.gte.gtecore.api.machine.IMultiblockMachineDefinition;

import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;

import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.List;
import java.util.function.Supplier;

@Mixin(MultiblockMachineDefinition.class)
public class MultiblockMachineDefinitionMixin implements IMultiblockMachineDefinition {

    @Shadow(remap = false)
    private Supplier<List<MultiblockShapeInfo>> shapes;

    @Shadow(remap = false)
    private @Nullable Supplier<ItemStack[]> recoveryItems;

    @Unique
    private Pattern[] gtecore$patterns;

    @Override
    public void gtecore$clear() {
        shapes = List::of;
        gtecore$patterns = null;
        recoveryItems = null;
    }

    @Override
    public Pattern[] gtecore$getPatterns() {
        return gtecore$patterns;
    }

    @Override
    public void gtecore$setPatterns(Pattern[] patterns) {
        gtecore$patterns = patterns;
    }
}
