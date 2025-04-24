package org.gte.gtecore.common.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.gte.gtecore.common.effect.GTEMysteriousBoostEffect;

import static org.gte.gtecore.GTECore.MOD_ID;

public interface GTEEffects {

    DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MOD_ID);

    RegistryObject<GTEMysteriousBoostEffect> MYSTERIOUS_BOOST = MOB_EFFECTS.register("mysterious_boost",
            () -> new GTEMysteriousBoostEffect(MobEffectCategory.BENEFICIAL, 0xFF00FF));

    static void init(IEventBus modBus) {
        MOB_EFFECTS.register(modBus);
    }
}
