package org.gte.gtecore.common.machine.multiblock.noenergy;

import org.gte.gtecore.api.machine.IIWirelessInteractorMachine;
import org.gte.gtecore.api.machine.multiblock.NoEnergyMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.misc.Drone;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.common.machine.multiblock.part.DroneHatchPartMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DroneControlCenterMachine extends NoEnergyMultiblockMachine {

    public static final Map<ResourceLocation, Set<DroneControlCenterMachine>> NETWORK = new Object2ObjectOpenHashMap<>();

    private DroneHatchPartMachine droneHatchPartMachine;

    public DroneControlCenterMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Nullable
    public Drone getFirstUsableDrone(BlockPos pos) {
        if (droneHatchPartMachine == null) return null;
        return droneHatchPartMachine.getFirstUsableDrone(getPos(), pos);
    }

    @Override
    public void onPartScan(@NotNull IMultiPart part) {
        super.onPartScan(part);
        if (droneHatchPartMachine == null && part instanceof DroneHatchPartMachine machine) {
            droneHatchPartMachine = machine;
        }
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        IIWirelessInteractorMachine.addToNet(NETWORK, this);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        droneHatchPartMachine = null;
        IIWirelessInteractorMachine.removeFromNet(NETWORK, this);
    }

    @Override
    public void onUnload() {
        super.onUnload();
        IIWirelessInteractorMachine.removeFromNet(NETWORK, this);
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        if (droneHatchPartMachine != null) {
            textList.add(Component.translatable("tooltip.jade.state", ""));
            for (int i = 0; i < droneHatchPartMachine.getSize(); i++) {
                MutableComponent component = Component.translatable("side_config.ad_astra.slots").append(" " + i + ": ");
                Drone drone = droneHatchPartMachine.getDrone(i);
                if (drone == null) {
                    textList.add(component.append(Component.translatable("tooltip.jade.empty")));
                } else {
                    if (drone.isWork()) {
                        textList.add(component.append(Component.translatable(drone.getWorkState()).withStyle(ChatFormatting.AQUA)));
                    } else {
                        textList.add(component.append(Component.translatable("gtceu.multiblock.idling")));
                    }
                }
            }
        }
    }

    @Nullable
    private GTRecipe getRecipe() {
        if (droneHatchPartMachine == null) return null;
        return GTERecipeBuilder.ofRaw().duration(20).buildRawRecipe();
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe, true);
    }
}
