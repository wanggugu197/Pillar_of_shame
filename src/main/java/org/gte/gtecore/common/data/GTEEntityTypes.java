package org.gte.gtecore.common.data;

import org.gte.gtecore.common.entity.TaskEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;

import com.tterrag.registrate.util.entry.EntityEntry;

import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;

public interface GTEEntityTypes {

    EntityEntry<Entity> TASK_ENTITY = REGISTRATE
            .entity("task_entity", TaskEntity::new, MobCategory.MISC)
            .properties(builder -> builder.sized(0, 0).noSummon().fireImmune().clientTrackingRange(0).updateInterval(1))
            .register();

    static void init() {}
}
