package org.gte.gtecore.common.machine.multiblock.part;

import org.gte.gtecore.api.machine.part.ItemHatchPartMachine;
import org.gte.gtecore.common.data.GTEItems;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IInteractedMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;
import com.gregtechceu.gtceu.common.data.GTDamageTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import com.google.common.collect.ImmutableMap;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.annotation.RequireRerender;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@Getter
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class BallHatchPartMachine extends ItemHatchPartMachine implements IInteractedMachine {

    public static final Map<Item, Integer> GRINDBALL;

    static {
        ImmutableMap.Builder<Item, Integer> grindball = ImmutableMap.builder();
        grindball.put(GTEItems.GRINDBALL_SOAPSTONE.get(), 1);
        grindball.put(GTEItems.GRINDBALL_ALUMINIUM.get(), 2);
        GRINDBALL = grindball.build();
    }

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            BallHatchPartMachine.class, ItemHatchPartMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    @DescSynced
    @RequireRerender
    private boolean isWorking;

    public BallHatchPartMachine(IMachineBlockEntity holder) {
        super(holder, 1, i -> GRINDBALL.containsKey(i.getItem()));
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public boolean beforeWorking(IWorkableMultiController controller) {
        isWorking = true;
        return super.beforeWorking(controller);
    }

    @Override
    public boolean afterWorking(IWorkableMultiController controller) {
        isWorking = false;
        return super.afterWorking(controller);
    }

    @Override
    public InteractionResult onUse(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
                                   BlockHitResult hit) {
        if (!isRemote() && isWorking && !player.isCreative()) {
            player.hurt(GTDamageTypes.TURBINE.source(level), 40);
            return InteractionResult.FAIL;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onDrops(List<ItemStack> list) {
        if (!isWorking) {
            super.onDrops(list);
        }
    }
}
