package org.gte.gtecore.common.machine.multiblock.noenergy;

import org.gte.gtecore.api.machine.multiblock.NoEnergyMultiblockMachine;
import org.gte.gtecore.common.data.GTEOres;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

public final class PrimitiveOreMachine extends NoEnergyMultiblockMachine {

    private int delay = 1;

    public PrimitiveOreMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public boolean onWorking() {
        if (!super.onWorking()) return false;
        if (getOffsetTimer() % delay == 0) {
            if (getLevel() == null) return false;
            if (outputItem(ChemicalHelper.get(TagPrefix.rawOre, GTEOres.selectMaterial(getLevel().dimension().location())).copyWithCount(64))) {
                delay = 1;
            } else if (delay < 20) {
                delay++;
            }
        }
        return true;
    }
}
