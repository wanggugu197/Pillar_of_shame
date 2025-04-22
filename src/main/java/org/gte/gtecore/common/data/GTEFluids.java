package org.gte.gtecore.common.data;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.fluid.GelidCryotheumFluid;
import org.gte.gtecore.common.fluid.types.GelidCryotheumFluidType;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public interface GTEFluids {

    DeferredRegister<FluidType> FLUID_TYPE = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, GTECore.MOD_ID);
    RegistryObject<FluidType> GELID_CRYOTHEUM_TYPE = FLUID_TYPE.register("gelid_cryotheum", GelidCryotheumFluidType::new);

    DeferredRegister<Fluid> FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS, GTECore.MOD_ID);
    RegistryObject<FlowingFluid> GELID_CRYOTHEUM = FLUID.register("gelid_cryotheum", GelidCryotheumFluid.Source::new);
    RegistryObject<FlowingFluid> FLOWING_GELID_CRYOTHEUM = FLUID.register("flowing_gelid_cryotheum", GelidCryotheumFluid.Flowing::new);
}
