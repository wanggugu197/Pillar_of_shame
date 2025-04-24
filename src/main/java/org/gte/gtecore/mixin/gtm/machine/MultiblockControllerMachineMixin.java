package org.gte.gtecore.mixin.gtm.machine;

import org.gte.gtecore.api.machine.feature.multiblock.ICheckPatternMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockWorldSavedData;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.concurrent.locks.Lock;

@Mixin(MultiblockControllerMachine.class)
public abstract class MultiblockControllerMachineMixin extends MetaMachine implements IMultiController, ICheckPatternMachine {

    @Unique
    private int gTECore$time = 1;

    @Shadow(remap = false)
    protected boolean isFormed;

    @Shadow(remap = false)
    public abstract Lock getPatternLock();

    @Shadow(remap = false)
    public abstract void setFlipped(boolean isFlipped);

    protected MultiblockControllerMachineMixin(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void loadCustomPersistedData(@NotNull CompoundTag tag) {
        super.loadCustomPersistedData(tag);
        isFormed = false;
    }

    @Override
    public boolean checkPattern() {
        if (gTECore$time < 1) {
            BlockPattern pattern = getPattern();
            if (pattern != null && pattern.checkPatternAt(getMultiblockState(), false)) {
                return true;
            } else if (gtecore$hasButton()) {
                gTECore$time = 10;
            }
        } else {
            gTECore$time--;
        }
        return false;
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public void asyncCheckPattern(long periodID) {
        if ((getMultiblockState().hasError() || !isFormed) && (getHolder().getOffset() + periodID) % 4 == 0 && checkPatternWithTryLock()) {
            if (getLevel() instanceof ServerLevel serverLevel) {
                serverLevel.getServer().execute(() -> {
                    getPatternLock().lock();
                    setFlipped(getMultiblockState().isNeededFlip());
                    onStructureFormed();
                    var mwsd = MultiblockWorldSavedData.getOrCreate(serverLevel);
                    mwsd.addMapping(getMultiblockState());
                    mwsd.removeAsyncLogic(this);
                    getPatternLock().unlock();
                });
            }
        }
    }

    @Override
    public void gTECore$setTime(int time) {
        gTECore$time = time;
    }

    @Override
    public int gTECore$getTime() {
        return gTECore$time;
    }
}
