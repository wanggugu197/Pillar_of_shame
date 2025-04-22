package org.gte.gtecore.api.machine.mana.trait;

import org.gte.gtecore.api.capability.IManaContainer;
import org.gte.gtecore.api.capability.ManaContainerList;
import org.gte.gtecore.api.capability.recipe.ManaRecipeCapability;
import org.gte.gtecore.api.machine.feature.multiblock.IMultiblockTraitHolder;
import org.gte.gtecore.api.machine.mana.feature.IManaMultiblock;
import org.gte.gtecore.api.machine.trait.MultiblockTrait;
import org.gte.gtecore.common.machine.mana.part.ManaHatchPartMachine;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;

import net.minecraft.network.chat.Component;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ManaTrait extends MultiblockTrait {

    @NotNull
    private ManaContainerList manaContainers = ManaContainerList.EMPTY;

    public ManaTrait(IManaMultiblock machine) {
        super((IMultiblockTraitHolder) machine);
    }

    @Override
    public void onStructureInvalid() {
        manaContainers = ManaContainerList.EMPTY;
    }

    @Override
    public void onStructureFormed() {
        List<IManaContainer> containers = new ArrayList<>();
        if (getMachine() instanceof WorkableMultiblockMachine workableMultiblockMachine) {
            if (((IManaMultiblock) machine).isGeneratorMana()) {
                List<IRecipeHandler<?>> capabilities = workableMultiblockMachine.getCapabilitiesFlat(IO.OUT, ManaRecipeCapability.CAP);
                for (IRecipeHandler<?> handler : capabilities) {
                    if (handler instanceof IManaContainer container) {
                        containers.add(container);
                    }
                }
            } else {
                List<IRecipeHandler<?>> capabilities = workableMultiblockMachine.getCapabilitiesFlat(IO.IN, ManaRecipeCapability.CAP);
                for (IRecipeHandler<?> handler : capabilities) {
                    if (handler instanceof IManaContainer container) {
                        containers.add(container);
                    }
                }

            }
        } else {
            for (IMultiPart part : getMachine().getParts()) {
                if (part instanceof ManaHatchPartMachine manaHatchPartMachine) {
                    NotifiableManaContainer container = manaHatchPartMachine.getManaContainer();
                    if (((IManaMultiblock) machine).isGeneratorMana()) {
                        if (container.getHandlerIO() == IO.OUT) containers.add(manaHatchPartMachine.getManaContainer());
                    } else {
                        if (container.getHandlerIO() == IO.IN) containers.add(manaHatchPartMachine.getManaContainer());
                    }
                }
            }
        }
        if (containers.isEmpty()) {
            manaContainers = ManaContainerList.EMPTY;
        } else {
            manaContainers = new ManaContainerList(containers.toArray(new IManaContainer[0]));
        }
    }

    @Override
    public void customText(@NotNull List<Component> textList) {
        super.customText(textList);
        textList.add(Component.translatable("gtecore.machine.mana_stored", manaContainers.getCurrentMana() + " / " + manaContainers.getMaxMana()));
        if (((IManaMultiblock) machine).isGeneratorMana()) {
            textList.add(Component.translatable("gtecore.machine.mana_production", manaContainers.getMaxProductionRate() + " /t"));
        } else {
            textList.add(Component.translatable("gtecore.machine.mana_consumption", manaContainers.getMaxConsumptionRate() + " /t"));
        }
    }
}
