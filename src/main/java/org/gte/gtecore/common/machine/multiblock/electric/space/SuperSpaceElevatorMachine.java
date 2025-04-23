package org.gte.gtecore.common.machine.multiblock.electric.space;

import org.gte.gtecore.utils.MachineUtils;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import net.minecraft.core.BlockPos;

public final class SuperSpaceElevatorMachine extends SpaceElevatorMachine {

    public SuperSpaceElevatorMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public int getMaxSpoolCount() {
        return 1024;
    }

    @Override
    int getBaseHigh() {
        poss.clear();
        BlockPos blockPos = MachineUtils.getOffsetPos(4, -2, getFrontFacing(), getPos());
        poss.add(blockPos.offset(9, 2, 1));
        poss.add(blockPos.offset(9, 2, -1));
        poss.add(blockPos.offset(11, 2, 1));
        poss.add(blockPos.offset(11, 2, -1));
        poss.add(blockPos.offset(13, 2, 1));
        poss.add(blockPos.offset(13, 2, -1));
        poss.add(blockPos.offset(15, 2, 1));
        poss.add(blockPos.offset(15, 2, -1));
        poss.add(blockPos.offset(-9, 2, 1));
        poss.add(blockPos.offset(-9, 2, -1));
        poss.add(blockPos.offset(-11, 2, 1));
        poss.add(blockPos.offset(-11, 2, -1));
        poss.add(blockPos.offset(-13, 2, 1));
        poss.add(blockPos.offset(-13, 2, -1));
        poss.add(blockPos.offset(-15, 2, 1));
        poss.add(blockPos.offset(-15, 2, -1));
        poss.add(blockPos.offset(1, 2, 9));
        poss.add(blockPos.offset(-1, 2, 9));
        poss.add(blockPos.offset(1, 2, 11));
        poss.add(blockPos.offset(-1, 2, 11));
        poss.add(blockPos.offset(1, 2, 13));
        poss.add(blockPos.offset(-1, 2, 13));
        poss.add(blockPos.offset(1, 2, 15));
        poss.add(blockPos.offset(-1, 2, 15));
        poss.add(blockPos.offset(1, 2, -9));
        poss.add(blockPos.offset(-1, 2, -9));
        poss.add(blockPos.offset(1, 2, -11));
        poss.add(blockPos.offset(-1, 2, -11));
        poss.add(blockPos.offset(1, 2, -13));
        poss.add(blockPos.offset(-1, 2, -13));
        poss.add(blockPos.offset(1, 2, -15));
        poss.add(blockPos.offset(-1, 2, -15));
        poss.add(blockPos.offset(10, 2, 7));
        poss.add(blockPos.offset(10, 2, -7));
        poss.add(blockPos.offset(12, 2, 7));
        poss.add(blockPos.offset(12, 2, -7));
        poss.add(blockPos.offset(14, 2, 7));
        poss.add(blockPos.offset(14, 2, -7));
        poss.add(blockPos.offset(-10, 2, 7));
        poss.add(blockPos.offset(-10, 2, -7));
        poss.add(blockPos.offset(-12, 2, 7));
        poss.add(blockPos.offset(-12, 2, -7));
        poss.add(blockPos.offset(-14, 2, 7));
        poss.add(blockPos.offset(-14, 2, -7));
        poss.add(blockPos.offset(7, 2, 10));
        poss.add(blockPos.offset(-7, 2, 10));
        poss.add(blockPos.offset(7, 2, 12));
        poss.add(blockPos.offset(-7, 2, 12));
        poss.add(blockPos.offset(7, 2, 14));
        poss.add(blockPos.offset(-7, 2, 14));
        poss.add(blockPos.offset(7, 2, -10));
        poss.add(blockPos.offset(-7, 2, -10));
        poss.add(blockPos.offset(7, 2, -12));
        poss.add(blockPos.offset(-7, 2, -12));
        poss.add(blockPos.offset(7, 2, -14));
        poss.add(blockPos.offset(-7, 2, -14));
        poss.add(blockPos.offset(21, 2, 12));
        poss.add(blockPos.offset(12, 2, 21));
        poss.add(blockPos.offset(-21, 2, 12));
        poss.add(blockPos.offset(-12, 2, 21));
        poss.add(blockPos.offset(21, 2, -12));
        poss.add(blockPos.offset(12, 2, -21));
        poss.add(blockPos.offset(-21, 2, -12));
        poss.add(blockPos.offset(-12, 2, -21));
        return 50;
    }
}
