package org.gte.gtecore.common.forge;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.entity.IEnhancedPlayer;
import org.gte.gtecore.common.ServerCache;
import org.gte.gtecore.common.network.ServerMessage;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.utils.ServerUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = GTECore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommonEventListener {

    @SubscribeEvent
    public static void onPortalSpawnEvent(BlockEvent.PortalSpawnEvent event) {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getEntity().level().getBlockState(event.getPos()).getBlock() == Blocks.END_PORTAL_FRAME &&
                event.getEntity().getItemInHand(event.getHand()).getItem() == Items.ENDER_EYE) {
            if (event.getEntity() instanceof ServerPlayer player &&
                    Objects.equals(player.getOffhandItem().getItem(), "gtecore:end_data")) {
                player.getOffhandItem().setCount(player.getOffhandItem().getCount() - 1);
                return;
            }
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
        if (GTEConfig.INSTANCE.disableDrift && event.phase == TickEvent.Phase.END &&
                event.side == LogicalSide.CLIENT && event.player.xxa == 0 && event.player.zza == 0) {
            event.player.setDeltaMovement(event.player.getDeltaMovement().multiply(0.5, 1, 0.5));
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            if (GTEConfig.getDifficulty() < 3 && !player.getPersistentData().getBoolean("initialization")) {
                player.getPersistentData().putBoolean("initialization", true);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 72000, 2, false, false, true));
            }
            if (!GTEConfig.INSTANCE.dev) player.displayClientMessage(Component.translatable("gtocore.dev", Component.literal("GitHub").withStyle(Style.EMPTY.withColor(ChatFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/GregTech-Engineering/GregTech-Engineering/issues")))), false);
            if (player instanceof IEnhancedPlayer enhancedPlayer) {
                final var data = new CompoundTag();
                data.putUUID(ServerUtils.IDENTIFIER_KEY, ServerUtils.getServerIdentifier());
                ServerMessage.sendData(player.getServer(), player, "loggedIn", data);
                enhancedPlayer.gtecore$setDrift(enhancedPlayer.gTECore$isDisableDrift());
            }
        }
    }

    @SubscribeEvent
    public static void onLevelLoad(LevelEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel level && !ServerCache.initialized) {
            ServerLevel serverLevel = level.getServer().getLevel(Level.OVERWORLD);
            if (serverLevel == null) return;
            /*
             * InfinityCellSavaedData.INSTANCE =
             * serverLevel.getDataStorage().computeIfAbsent(InfinityCellSavaedData::readNbt,
             * InfinityCellSavaedData::new, "infinite_storage_cell_data");
             * DysonSphereSavaedData.INSTANCE = serverLevel.getDataStorage().computeIfAbsent(DysonSphereSavaedData::new,
             * DysonSphereSavaedData::new, "dyson_sphere_data");
             * WirelessEnergySavaedData.INSTANCE =
             * serverLevel.getDataStorage().computeIfAbsent(ExtendWirelessEnergySavaedData::new,
             * ExtendWirelessEnergySavaedData::new, "wireless_energy_data");
             * CommonSavaedData.INSTANCE = serverLevel.getDataStorage().computeIfAbsent(CommonSavaedData::new,
             * CommonSavaedData::new, "common_data");
             * RecipeRunLimitSavaedData.INSTANCE =
             * serverLevel.getDataStorage().computeIfAbsent(RecipeRunLimitSavaedData::new,
             * RecipeRunLimitSavaedData::new, " recipe_run_limit_data");
             * WirelessManaSavaedData.INSTANCE = level.getDataStorage().computeIfAbsent(WirelessManaSavaedData::new,
             * WirelessManaSavaedData::new, "wireless_mana_data");
             * ExperienceSystemManager.INSTANCE = level.getDataStorage().computeIfAbsent(ExperienceSystemManager::load,
             * ExperienceSystemManager::new, "gto_experience_data");
             * if (GTEConfig.INSTANCE.selfRestraint && !ServerUtils.getPersistentData().getBoolean("srm")) {
             * ServerUtils.getPersistentData().putBoolean("srm", true);
             * CommonSavaedData.INSTANCE.setDirty();
             * }
             * int difficulty = ServerUtils.getPersistentData().getInt("difficulty");
             * if (difficulty == 0) {
             * ServerUtils.getPersistentData().putInt("difficulty", GTEConfig.getDifficulty());
             * CommonSavaedData.INSTANCE.setDirty();
             * } else if (difficulty != GTEConfig.getDifficulty()) {
             * serverLevel.getServer().halt(true);
             * }
             */
            ServerCache.initialized = true;
        }
    }
}
