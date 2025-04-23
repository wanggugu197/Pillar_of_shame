package org.gte.gtecore.common.machine.multiblock.electric.space;

import org.gte.gtecore.api.data.GTEDimensions;
import org.gte.gtecore.api.machine.multiblock.ElectricMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;
import org.gte.gtecore.utils.GTEUtils;
import org.gte.gtecore.utils.RegistriesUtils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fluids.FluidStack;

import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.ComponentPanelWidget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import earth.terrarium.adastra.common.registry.ModFluids;
import earth.terrarium.adastra.common.registry.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public final class SatelliteControlCenterMachine extends ElectricMultiblockMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            SatelliteControlCenterMachine.class, ElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    private static final Map<Item, Integer> ROCKET = GTCEu.isProd() ? Map.of(
            ModItems.TIER_1_ROCKET.get(), 1,
            ModItems.TIER_2_ROCKET.get(), 2,
            ModItems.TIER_3_ROCKET.get(), 3,
            ModItems.TIER_4_ROCKET.get(), 4,
            RegistriesUtils.getItem("ad_astra_rocketed:tier_5_rocket"), 5,
            RegistriesUtils.getItem("ad_astra_rocketed:tier_6_rocket"), 6,
            RegistriesUtils.getItem("ad_astra_rocketed:tier_7_rocket"), 7) : Map.of();

    private static final Map<Integer, FluidStack> FUEL = Map.of(
            1, GTMaterials.RocketFuel.getFluid(16000),
            2, GTEMaterials.RocketFuelRp1.getFluid(16000),
            3, GTEMaterials.DenseHydrazineFuelMixture.getFluid(16000),
            4, GTEMaterials.RocketFuelCn3h7o3.getFluid(16000),
            5, GTEMaterials.RocketFuelH8n4c2o4.getFluid(16000),
            6, new FluidStack(ModFluids.CRYO_FUEL.get(), 16000),
            7, GTEMaterials.StellarEnergyRocketFuel.getFluid(16000));

    private boolean launch;

    @Persisted
    private int tier;

    @Persisted
    private UUID uuid;

    private ResourceLocation resourceLocation;

    public SatelliteControlCenterMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void onRecipeFinish() {
        super.onRecipeFinish();
        Item item = GTEUtils.getKeyByValue(ROCKET, tier);
        if (item != null) outputItem(item.getDefaultInstance());
        GTEDimensions.ALL_PLANET.forEach((k, v) -> {
            if (v == tier) {
                if (resourceLocation == null || GTValues.RNG.nextBoolean()) resourceLocation = k;
            }
        });
        if (uuid != null && resourceLocation != null) outputItem(GTEItems.PLANET_DATA_CHIP.get().getPlanetDataChip(uuid, resourceLocation));
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        var buttonText = Component.translatable("tooltip.avaritia.tier", tier);
        buttonText.append(" ");
        buttonText.append(ComponentPanelWidget.withButton(Component.literal("[-]"), "sub"));
        buttonText.append(" ");
        buttonText.append(ComponentPanelWidget.withButton(Component.literal("[+]"), "add"));
        textList.add(buttonText);
        textList.add(ComponentPanelWidget.withButton(Component.translatable("gtecore.machine.space_elevator.set_out"), "set_out"));
    }

    @Override
    public void handleDisplayClick(String componentData, ClickData clickData) {
        if (clickData.isRemote) return;
        if ("set_out".equals(componentData)) {
            launch = true;
        } else {
            AtomicInteger max = new AtomicInteger(1);
            forEachInputItems(stack -> {
                Integer tier = ROCKET.get(stack.getItem());
                if (tier != null) {
                    max.set(Math.max(max.get(), tier));
                }
                return false;
            });
            int result = componentData.equals("add") ? 1 : -1;
            tier = Mth.clamp(tier + result, 1, max.get());
        }
    }

    @Override
    public InteractionResult onUse(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player instanceof ServerPlayer serverPlayer) {
            uuid = serverPlayer.getUUID();
        }
        return super.onUse(state, level, pos, player, hand, hit);
    }

    @Nullable
    private GTRecipe getRecipe() {
        if (launch && getTier() > GTValues.MV) {
            launch = false;
            Item item = GTEUtils.getKeyByValue(ROCKET, tier);
            if (item == null) return null;
            GTRecipe recipe = GTERecipeBuilder.ofRaw().duration(6000).inputItems(GTEItems.PLANET_SCAN_SATELLITE.asStack()).inputFluids(FUEL.get(tier)).inputItems(item).inputItems(GTEItems.PLANET_DATA_CHIP.asStack()).EUt(getOverclockVoltage()).buildRawRecipe();
            if (RecipeRunnerHelper.matchRecipe(this, recipe) && RecipeRunnerHelper.matchTickRecipe(this, recipe)) return recipe;
        }
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe, true);
    }

    @Override
    @NotNull
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
