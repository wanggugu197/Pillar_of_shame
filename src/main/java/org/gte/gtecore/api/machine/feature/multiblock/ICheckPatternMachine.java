package org.gte.gtecore.api.machine.feature.multiblock;

import org.gte.gtecore.api.gui.GTEGuiTextures;

import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfiguratorButton;
import com.gregtechceu.gtceu.api.machine.MetaMachine;

import net.minecraft.network.chat.Component;

import java.util.List;

public interface ICheckPatternMachine {

    default void gTECore$setTime(int time) {}

    default int gTECore$getTime() {
        return 0;
    }

    default boolean gtecore$hasButton() {
        return false;
    }

    static void attachConfigurators(ConfiguratorPanel configuratorPanel, MetaMachine machine) {
        if (machine instanceof ICheckPatternMachine checkPatternMachine) {
            configuratorPanel.attachConfigurators(new IFancyConfiguratorButton.Toggle(
                    GTEGuiTextures.STRUCTURE_CHECK.getSubTexture(0, 0, 1, 0.5),
                    GTEGuiTextures.STRUCTURE_CHECK.getSubTexture(0, 0.5, 1, 0.5),
                    () -> checkPatternMachine.gTECore$getTime() < 1, (clickData, pressed) -> {
                        if (checkPatternMachine.gTECore$getTime() > 0) checkPatternMachine.gTECore$setTime(0);
                    })
                    .setTooltipsSupplier(pressed -> List.of(Component.translatable("gtecore.machine.structure_check"))));
        }
    }
}
