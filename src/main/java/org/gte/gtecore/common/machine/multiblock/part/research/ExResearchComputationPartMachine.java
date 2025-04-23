package org.gte.gtecore.common.machine.multiblock.part.research;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IHPCAComputationProvider;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;

import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;
import lombok.Getter;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.OpV;

@Getter
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ExResearchComputationPartMachine extends ExResearchBasePartMachine implements IHPCAComputationProvider {

    public ExResearchComputationPartMachine(IMachineBlockEntity holder, int tier) {
        super(holder, tier);
    }

    @Override
    public ResourceTexture getComponentIcon() {
        if (isDamaged()) {
            if (tier == 3) return GuiTextures.HPCA_ICON_DAMAGED_ADVANCED_COMPUTATION_COMPONENT;
            else if (tier == 4) return GuiTextures.HPCA_ICON_DAMAGED_ADVANCED_COMPUTATION_COMPONENT;
            else return GuiTextures.HPCA_ICON_DAMAGED_ADVANCED_COMPUTATION_COMPONENT;
        }
        if (tier == 3) return GuiTextures.HPCA_ICON_ADVANCED_COMPUTATION_COMPONENT;
        else if (tier == 4) return GuiTextures.HPCA_ICON_ADVANCED_COMPUTATION_COMPONENT;
        else return GuiTextures.HPCA_ICON_ADVANCED_COMPUTATION_COMPONENT;
    }

    @Override
    public int getUpkeepEUt() {
        if (tier == 3) return GTValues.VA[LuV];
        else if (tier == 4) return GTValues.VA[UV];
        else return GTValues.VA[UEV];
    }

    @Override
    public int getMaxEUt() {
        if (tier == 3) return GTValues.VA[UV];
        else if (tier == 4) return GTValues.VA[UEV];
        else return GTValues.VA[OpV];
    }

    @Override
    public int getCWUPerTick() {
        if (isDamaged()) return 0;
        else if (tier == 3) return 64;
        else if (tier == 4) return 1024;
        else return 16384;
    }

    @Override
    public int getCoolingPerTick() {
        if (tier == 3) return 16;
        else if (tier == 4) return 256;
        else return 4096;
    }

    @Override
    public boolean canBeDamaged() {
        return true;
    }
}
