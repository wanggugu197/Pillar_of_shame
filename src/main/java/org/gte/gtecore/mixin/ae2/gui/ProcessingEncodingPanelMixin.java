package org.gte.gtecore.mixin.ae2.gui;

import org.gte.gtecore.client.gui.IPatterEncodingTermMenu;
import org.gte.gtecore.client.gui.ModifyIcon;
import org.gte.gtecore.client.gui.ModifyIconButton;

import net.minecraft.network.chat.Component;

import appeng.client.gui.WidgetContainer;
import appeng.client.gui.me.items.EncodingModePanel;
import appeng.client.gui.me.items.PatternEncodingTermScreen;
import appeng.client.gui.me.items.ProcessingEncodingPanel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProcessingEncodingPanel.class)
public abstract class ProcessingEncodingPanelMixin extends EncodingModePanel {

    @Unique
    private ModifyIconButton gteCore$multipleTow;
    @Unique
    private ModifyIconButton gteCore$multipleThree;
    @Unique
    private ModifyIconButton gteCore$multipleFive;
    @Unique
    private ModifyIconButton gteCore$dividingTow;
    @Unique
    private ModifyIconButton gteCore$dividingThree;
    @Unique
    private ModifyIconButton gteCore$dividingFive;

    protected ProcessingEncodingPanelMixin(PatternEncodingTermScreen<?> screen, WidgetContainer widgets) {
        super(screen, widgets);
    }

    @Inject(method = "<init>", at = @At("TAIL"), remap = false)
    private void init(PatternEncodingTermScreen<?> screen, WidgetContainer widgets, CallbackInfo ci) {
        gteCore$multipleTow = new ModifyIconButton(b -> ((IPatterEncodingTermMenu) menu).gteCore$modifyPatter(2), ModifyIcon.MULTIPLY_2,
                Component.translatable("gtecore.pattern.multiply", 2),
                Component.translatable("gtecore.pattern.tooltip.multiply", 2));

        gteCore$multipleThree = new ModifyIconButton(b -> ((IPatterEncodingTermMenu) menu).gteCore$modifyPatter(3), ModifyIcon.MULTIPLY_3,
                Component.translatable("gtecore.pattern.multiply", 3),
                Component.translatable("gtecore.pattern.tooltip.multiply", 3));

        gteCore$multipleFive = new ModifyIconButton(b -> ((IPatterEncodingTermMenu) menu).gteCore$modifyPatter(5), ModifyIcon.MULTIPLY_5,
                Component.translatable("gtecore.pattern.multiply", 5),
                Component.translatable("gtecore.pattern.tooltip.multiply", 5));

        gteCore$dividingTow = new ModifyIconButton(b -> ((IPatterEncodingTermMenu) menu).gteCore$modifyPatter(-2), ModifyIcon.DIVISION_2,
                Component.translatable("gtecore.pattern.divide", 2),
                Component.translatable("gtecore.pattern.tooltip.divide", 2));

        gteCore$dividingThree = new ModifyIconButton(b -> ((IPatterEncodingTermMenu) menu).gteCore$modifyPatter(-3), ModifyIcon.DIVISION_3,
                Component.translatable("gtecore.pattern.divide", 3),
                Component.translatable("gtecore.pattern.tooltip.divide", 3));

        gteCore$dividingFive = new ModifyIconButton(b -> ((IPatterEncodingTermMenu) menu).gteCore$modifyPatter(-5), ModifyIcon.DIVISION_5,
                Component.translatable("gtecore.pattern.divide", 5),
                Component.translatable("gtecore.pattern.tooltip.divide", 5));

        widgets.add("modify1", gteCore$multipleTow);
        widgets.add("modify2", gteCore$multipleThree);
        widgets.add("modify3", gteCore$multipleFive);
        widgets.add("modify4", gteCore$dividingTow);
        widgets.add("modify5", gteCore$dividingThree);
        widgets.add("modify6", gteCore$dividingFive);
    }

    @Inject(method = "setVisible", at = @At("TAIL"), remap = false)
    private void setVisibleHooks(boolean visible, CallbackInfo ci) {
        gteCore$multipleTow.setVisibility(visible);
        gteCore$multipleThree.setVisibility(visible);
        gteCore$multipleFive.setVisibility(visible);
        gteCore$dividingTow.setVisibility(visible);
        gteCore$dividingThree.setVisibility(visible);
        gteCore$dividingFive.setVisibility(visible);
    }
}
