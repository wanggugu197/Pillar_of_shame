package org.gte.gtecore.mixin.mc;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Ingredient.TagValue.class)
public interface IngredientTagValueAccessor {

    @Accessor
    TagKey<Item> getTag();
}
