package org.gte.gtecore.api.machine.multiblock.part;

import org.gte.gtecore.api.machine.trait.IEnhancedRecipeLogic;

import com.gregtechceu.gtceu.api.gui.widget.IntInputWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;

import net.minecraft.util.Mth;

import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import org.jetbrains.annotations.NotNull;

public class AmountConfigurationHatchPartMachine extends TieredPartMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            AmountConfigurationHatchPartMachine.class, TieredPartMachine.MANAGED_FIELD_HOLDER);

    private final int min;
    private final int max;

    @Persisted
    private int current = -1;

    public AmountConfigurationHatchPartMachine(IMachineBlockEntity holder, int tier, int min, int max) {
        super(holder, tier);
        this.max = max;
        this.min = min;
    }

    @Override
    public Widget createUIWidget() {
        return new WidgetGroup(0, 0, 100, 20).addWidget(new IntInputWidget(this::getCurrent, this::setCurrent).setMin(min).setMax(max));
    }

    @Override
    @NotNull
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public boolean canShared() {
        return false;
    }

    private void setCurrent(int amount) {
        current = Mth.clamp(amount, min, max);
        for (var c : getControllers()) {
            if (c instanceof IRecipeLogicMachine machine && machine.getRecipeLogic() instanceof IEnhancedRecipeLogic recipeLogic) {
                recipeLogic.gtecore$setModifyRecipe();
            }
        }
    }

    protected int getCurrent() {
        if (current == -1) current = max;
        return current;
    }
}
