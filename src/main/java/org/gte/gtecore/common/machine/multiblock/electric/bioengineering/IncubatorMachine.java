package org.gte.gtecore.common.machine.multiblock.electric.bioengineering;

import org.gte.gtecore.api.machine.multiblock.TierCasingMultiblockMachine;
import org.gte.gtecore.common.machine.trait.RadioactivityTrait;

import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import static org.gte.gtecore.api.GTEValues.GLASS_TIER;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class IncubatorMachine extends TierCasingMultiblockMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            IncubatorMachine.class, TierCasingMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Persisted
    private final RadioactivityTrait radioactivityTrait;

    private int cleanroomTier = 1;

    public IncubatorMachine(IMachineBlockEntity holder) {
        super(holder, GLASS_TIER);
        radioactivityTrait = new RadioactivityTrait(this);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        IFilterType filterType = getMultiblockState().getMatchContext().get("FilterType");
        if (filterType != null) {
            switch (filterType.getCleanroomType().getName()) {
                case "cleanroom":
                    cleanroomTier = 1;
                    break;
                case "sterile_cleanroom":
                    cleanroomTier = 2;
                    break;
                case "law_cleanroom":
                    cleanroomTier = 3;
            }
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        cleanroomTier = 1;
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        textList.add(Component.translatable("tooltip.avaritia.tier", cleanroomTier));
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (recipe == null) return false;
        if (recipe.data.contains("filter_casing") && recipe.data.getInt("filter_casing") > cleanroomTier) {
            return false;
        }
        return super.beforeWorking(recipe);
    }
}
