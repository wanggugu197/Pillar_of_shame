package org.gte.gtecore.api.gui;

import org.gte.gtecore.api.machine.feature.IOverclockConfigMachine;

import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfigurator;
import com.gregtechceu.gtceu.api.gui.widget.IntInputWidget;

import net.minecraft.network.chat.Component;

import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;

public final class OverclockConfigurator implements IFancyConfigurator {

    private final IOverclockConfigMachine machine;

    public OverclockConfigurator(IOverclockConfigMachine machine) {
        this.machine = machine;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gtecore.machine.overclock_configurator");
    }

    @Override
    public IGuiTexture getIcon() {
        return GTEGuiTextures.OVERCLOCK_CONFIG;
    }

    @Override
    public Widget createConfigurator() {
        return new WidgetGroup(0, 0, 100, 20).addWidget(new IntInputWidget(machine::gTECore$getOCLimit, machine::gTECore$setOCLimit).setMin(1).setMax(200));
    }
}
