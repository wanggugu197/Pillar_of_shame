package org.gte.gtecore.common.block;

import org.gte.gtecore.common.entity.NukeBombEntity;

import com.gregtechceu.gtceu.common.block.explosive.GTExplosiveBlock;
import com.gregtechceu.gtceu.common.entity.GTExplosiveEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.NotNull;

public final class NukeBombBlock extends GTExplosiveBlock {

    public NukeBombBlock(Properties properties) {
        super(properties, true, true, 40);
    }

    @Override
    protected @NotNull GTExplosiveEntity createEntity(@NotNull Level world, @NotNull BlockPos pos,
                                                      @NotNull LivingEntity exploder) {
        float x = pos.getX() + 0.5F, y = pos.getY(), z = pos.getZ() + 0.5F;
        return new NukeBombEntity(world, x, y, z, exploder);
    }
}
