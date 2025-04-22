package org.gte.gtecore.mixin.ae2.gui;

import org.gte.gtecore.integration.ae2.BlockingType;
import org.gte.gtecore.integration.ae2.GTESettings;
import org.gte.gtecore.integration.ae2.IPatternProviderMenu;

import appeng.helpers.patternprovider.PatternProviderLogic;
import appeng.menu.guisync.GuiSync;
import appeng.menu.implementations.PatternProviderMenu;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PatternProviderMenu.class)
public class PatternProviderMenuMixin implements IPatternProviderMenu {

    @Shadow(remap = false)
    @Final
    protected PatternProviderLogic logic;

    @Unique
    @GuiSync(8)
    private BlockingType gtecore$enhancedblockingmode = BlockingType.ALL;

    @Inject(method = "broadcastChanges", at = @At(value = "INVOKE", target = "Lappeng/helpers/patternprovider/PatternProviderLogic;getUnlockStack()Lappeng/api/stacks/GenericStack;", remap = false))
    private void broadcastChanges(CallbackInfo ci) {
        gtecore$enhancedblockingmode = logic.getConfigManager().getSetting(GTESettings.BLOCKING_TYPE);
    }

    @Override
    public BlockingType gtecore$getBlocking() {
        return gtecore$enhancedblockingmode;
    }
}
