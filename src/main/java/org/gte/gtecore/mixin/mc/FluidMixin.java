package org.gte.gtecore.mixin.mc;

import org.gte.gtecore.api.fluid.IFluid;
import org.gte.gtecore.utils.RLUtils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Fluid.class)
public class FluidMixin implements IFluid {

    @Unique
    private ResourceLocation gtecore$id;

    @Override
    public @NotNull ResourceLocation gtecore$getIdLocation() {
        if (gtecore$id == null) {
            gtecore$id = ForgeRegistries.FLUIDS.getKey((Fluid) (Object) this);
            if (gtecore$id == null) gtecore$id = RLUtils.mc("water");
        }
        return gtecore$id;
    }
}
