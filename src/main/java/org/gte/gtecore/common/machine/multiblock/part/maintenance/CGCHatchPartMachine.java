package org.gte.gtecore.common.machine.multiblock.part.maintenance;

import org.gte.gtecore.api.machine.feature.IGravityPartMachine;

import com.gregtechceu.gtceu.api.gui.widget.IntInputWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.Mth;

import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class CGCHatchPartMachine extends ACMHatchPartMachine implements IGravityPartMachine {

    @Persisted
    private int currentGravity;

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            CGCHatchPartMachine.class, ACMHatchPartMachine.MANAGED_FIELD_HOLDER);

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    public CGCHatchPartMachine(IMachineBlockEntity metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public int getCurrentGravity() {
        return currentGravity;
    }

    @Override
    public Widget createUIWidget() {
        Widget widget = super.createUIWidget();
        if (widget instanceof WidgetGroup group) {
            group.addWidget(new IntInputWidget(10, 35, 80, 10, this::getCurrentGravity, this::setCurrentGravity).setMin(0).setMax(100));
            return group;
        }
        return widget;
    }

    private void setCurrentGravity(int gravity) {
        currentGravity = Mth.clamp(gravity, 0, 100);
    }
}
