package org.gte.gtecore.common.machine.multiblock.part.research;

import org.gte.gtecore.common.data.GTEBlocks;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.common.machine.multiblock.part.hpca.HPCAComponentPartMachine;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import lombok.Getter;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@Getter
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public abstract class ExResearchBasePartMachine extends HPCAComponentPartMachine {

    protected final int tier;

    ExResearchBasePartMachine(IMachineBlockEntity holder, int tier) {
        super(holder);
        this.tier = tier;
    }

    @Override
    public boolean isAdvanced() {
        return true;
    }

    @Override
    public void onDrops(List<ItemStack> drops) {
        for (int i = 0; i < drops.size(); ++i) {
            ItemStack drop = drops.get(i);
            if (drop.getItem() == this.getDefinition().getItem()) {
                if (canBeDamaged() && isDamaged()) {
                    if (tier == 3) drops.set(i, GTEBlocks.BIOCOMPUTER_CASING.asStack());
                    else if (tier == 4) drops.set(i, GTEBlocks.GRAVITON_COMPUTER_CASING.asStack());
                    else drops.set(i, GTEBlocks.GRAVITON_COMPUTER_CASING.asStack());
                }
                break;
            }
        }
    }
}
