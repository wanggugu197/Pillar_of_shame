package org.gte.gtecore.mixin.mc;

import org.gte.gtecore.api.item.IItem;
import org.gte.gtecore.utils.RLUtils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = Item.class, priority = 0)
public class ItemMixin implements IItem {

    @Unique
    private ResourceLocation gtecore$id;

    @Override
    public @NotNull ResourceLocation gtecore$getIdLocation() {
        if (gtecore$id == null) {
            gtecore$id = ForgeRegistries.ITEMS.getKey((Item) (Object) this);
            if (gtecore$id == null) gtecore$id = RLUtils.mc("air");
        }
        return gtecore$id;
    }
}
