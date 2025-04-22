package org.gte.gtecore.mixin.ae2;

import org.gte.gtecore.integration.ae2.BlockingType;
import org.gte.gtecore.integration.ae2.GTESettings;
import org.gte.gtecore.integration.ae2.IPatternProviderLogic;
import org.gte.gtecore.integration.ae2.PatternProviderTargetCache;

import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;

import appeng.api.networking.IManagedGridNode;
import appeng.api.networking.security.IActionSource;
import appeng.helpers.patternprovider.PatternProviderLogic;
import appeng.helpers.patternprovider.PatternProviderLogicHost;
import appeng.helpers.patternprovider.PatternProviderTarget;
import appeng.util.ConfigManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PatternProviderLogic.class)
public class PatternProviderLogicMixin implements IPatternProviderLogic {

    @Unique
    private final PatternProviderTargetCache[] gtecore$targetCaches = new PatternProviderTargetCache[6];

    @Shadow(remap = false)
    @Final
    private ConfigManager configManager;

    @Shadow(remap = false)
    @Final
    private PatternProviderLogicHost host;

    @Shadow(remap = false)
    @Final
    private IActionSource actionSource;

    @Inject(method = "<init>(Lappeng/api/networking/IManagedGridNode;Lappeng/helpers/patternprovider/PatternProviderLogicHost;I)V", at = @At("TAIL"), remap = false)
    private void PatternProviderLogic(IManagedGridNode mainNode, PatternProviderLogicHost host, int patternInventorySize, CallbackInfo ci) {
        configManager.registerSetting(GTESettings.BLOCKING_TYPE, BlockingType.ALL);
    }

    @Override
    public BlockingType gtecore$getBlocking() {
        return configManager.getSetting(GTESettings.BLOCKING_TYPE);
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    @Nullable
    private PatternProviderTarget findAdapter(Direction side) {
        if (gtecore$targetCaches[side.get3DDataValue()] == null) {
            var thisBe = host.getBlockEntity();
            gtecore$targetCaches[side.get3DDataValue()] = new PatternProviderTargetCache(this, (ServerLevel) thisBe.getLevel(), thisBe.getBlockPos().relative(side), side.getOpposite(), actionSource);
        }
        @Nullable
        PatternProviderTarget ret = gtecore$targetCaches[side.get3DDataValue()].find();
        return ret;
    }
}
