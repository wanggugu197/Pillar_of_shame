package org.gte.gtecore.mixin.mc;

import org.gte.gtecore.config.GTEConfig;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AbstractSkeleton.class, priority = 0)
public class AbstractSkeletonMixin extends Monster {

    @Unique
    private float gTECore$intensify;

    protected AbstractSkeletonMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        gTECore$intensify = GTEConfig.getDifficulty() == 1 ? 1 : 1 + getRandom().nextInt(Math.max(1, level().getDifficulty().getId()));
    }

    @ModifyArg(method = "performRangedAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow;shoot(DDDFF)V"), index = 3)
    private float modifyVelocity(float velocity) {
        return velocity * gTECore$intensify;
    }

    @Inject(method = "getArrow", at = @At("RETURN"))
    private void getArrow(ItemStack arrowStack, float velocity, CallbackInfoReturnable<AbstractArrow> cir) {
        AbstractArrow abstractarrow = cir.getReturnValue();
        abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() * gTECore$intensify);
        abstractarrow.setKnockback((int) (abstractarrow.getKnockback() * gTECore$intensify));
    }
}
