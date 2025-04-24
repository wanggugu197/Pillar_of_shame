package org.gte.gtecore.mixin.mc;

import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.api.entity.IEnhancedPlayer;
import org.gte.gtecore.api.misc.PlanetManagement;
import org.gte.gtecore.client.ClientCache;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.network.ServerMessage;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.utils.ServerUtils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;
import com.gregtechceu.gtceu.common.data.GTDamageTypes;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = Player.class, priority = 0)
public abstract class PlayerMixin extends LivingEntity implements IEnhancedPlayer {

    @Shadow
    @Final
    private Abilities abilities;

    @Shadow
    public abstract void onUpdateAbilities();

    @Shadow
    public abstract FoodData getFoodData();

    @Shadow
    @Final
    private Inventory inventory;
    @Unique
    private boolean gTECore$amprosium;
    @Unique
    private boolean gTECore$disableDrift;
    @Unique
    private boolean gTECore$canFly;
    @Unique
    private boolean gTECore$spaceState;
    @Unique
    private boolean gTECore$wardenState;

    private PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean gTECore$canFly() {
        return gTECore$canFly;
    }

    @Override
    public boolean gTECore$isSpaceState() {
        return gTECore$spaceState;
    }

    @Override
    public boolean gTECore$isWardenState() {
        return gTECore$wardenState;
    }

    @Override
    public boolean gTECore$isDisableDrift() {
        return gTECore$disableDrift;
    }

    @Override
    public boolean gTECore$isAmprosium() {
        return gTECore$amprosium;
    }

    @Override
    public void gtecore$setDrift(boolean drift) {
        if ((Object) this instanceof ServerPlayer player) {
            gTECore$disableDrift = drift;
            ServerMessage.disableDrift(player, gTECore$disableDrift);
        }
    }

    @Inject(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;setSharedFlag(IZ)V"))
    private void travel(Vec3 travelVector, CallbackInfo ci) {
        if (xxa == 0 && zza == 0 && ClientCache.disableDrift) {
            setDeltaMovement(getDeltaMovement().multiply(0.5, 1, 0.5));
        }
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void readAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
        gTECore$spaceState = compound.getBoolean("spaceState");
        gTECore$wardenState = compound.getBoolean("wardenState");
        gTECore$disableDrift = compound.getBoolean("disableDrift");
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void addAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
        compound.putBoolean("spaceState", gTECore$spaceState);
        compound.putBoolean("wardenState", gTECore$wardenState);
        compound.putBoolean("disableDrift", gTECore$disableDrift);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo ci) {
        if (tickCount % 20 == 0) {
            Level level = level();
            if (level.isClientSide) return;
            MinecraftServer server = level.getServer();
            if (server == null) return;
            if (getFoodData().getFoodLevel() > (GTEConfig.getDifficulty() == 1 ? 5 : 15) && getHealth() < getMaxHealth() - 4 && tickCount % 80 == 0 && getRandom().nextBoolean()) {
                heal(Math.max(1, (int) Math.log(getMaxHealth() * Math.max(1, 4 - GTEConfig.getDifficulty()) / 4)));
            }
            gTECore$amprosium = false;
            boolean hasHotIronIngot = false;
            for (ItemStack stack : inventory.items) {
                if (stack.isEmpty()) continue;
                if (stack.getItem() == GTEItems.HOT_IRON_INGOT.asItem()) {
                    hasHotIronIngot = true;
                    break;
                } else if (!gTECore$amprosium && ChemicalHelper.getMaterialStack(stack).material() == GTMaterials.Neutronium) {
                    gTECore$amprosium = true;
                }
            }
            if (hasHotIronIngot) {
                float heatDamage = ((850 + 273 - 1750) / 1000.0F) + 2;
                ItemStack armor = getItemBySlot(EquipmentSlot.CHEST);
                if (!armor.isEmpty() && armor.getItem() instanceof ArmorComponentItem armorItem) {
                    heatDamage *= armorItem.getArmorLogic().getHeatResistance();
                }
                if (heatDamage > 0.0) {
                    hurt(GTDamageTypes.HEAT.source(level), heatDamage);
                }
            }
            String name = getName().getString();
            String armorSlots = getArmorSlots().toString();
            gTECore$wardenState = Objects.equals(armorSlots, "[1 warden_boots, 1 warden_leggings, 1 warden_chestplate, 1 warden_helmet]");
            boolean inf = Objects.equals(armorSlots, "[1 infinity_boots, 1 infinity_pants, 1 infinity_chestplate, 1 infinity_helmet]");
            if (level.dimension().location().equals(GTEDimensions.CREATE)) {
                if (!inf) {
                    gTECore$discard(server);
                }
                ServerUtils.runCommandSilent(server, "execute at " + name + " run kill @e[distance=..100,name=!" + name + ",type=!item]");
            } else if (level.dimension().location().equals(GTEDimensions.OTHERSIDE)) {
                if (!(gTECore$wardenState || inf)) {
                    gTECore$discard(server);
                }
            } else if ((Object) this instanceof ServerPlayer serverPlayer) {
                if (GTCEu.isProd() && GTEDimensions.ALL_PLANET.containsKey(level.dimension().location()) && !PlanetManagement.isUnlocked(serverPlayer, level.dimension().location())) {
                    serverPlayer.displayClientMessage(Component.translatable("gtecore.ununlocked"), false);
                    gTECore$discard(server);
                }
            }
            CompoundTag data = getPersistentData();
            boolean canFly = gTECore$wardenState;
            if (gTECore$canFly && !canFly) {
                data.putBoolean("night_vision", false);
                data.putInt("fly_speed", 1);
                abilities.setFlyingSpeed(0.05F);
                onUpdateAbilities();
            }
            gTECore$canFly = canFly;
            gTECore$spaceState = inf;
            if (gTECore$wardenState) {
                addEffect(new MobEffectInstance(MobEffects.SATURATION, 200, 0, false, false));
                if (data.getBoolean("night_vision")) {
                    addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
                }
            }
        }
    }

    @Redirect(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodData;setFoodLevel(I)V"))
    private void gTECore$setFoodLevel(FoodData foodData, int foodLevel) {}

    @Unique
    private void gTECore$discard(MinecraftServer server) {
        ServerUtils.teleportToDimension(server, this, GTEDimensions.OVERWORLD, new Vec3(0, 100, 0));
        kill();
    }
}
