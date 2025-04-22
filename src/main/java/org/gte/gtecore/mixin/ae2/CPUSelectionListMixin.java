package org.gte.gtecore.mixin.ae2;

import org.gte.gtecore.utils.NumberUtils;

import appeng.client.gui.ICompositeWidget;
import appeng.client.gui.widgets.CPUSelectionList;
import appeng.menu.me.crafting.CraftingStatusMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CPUSelectionList.class)
public abstract class CPUSelectionListMixin implements ICompositeWidget {

    /**
     * @author qiuyeqaq
     * @reason .
     */
    @Overwrite(remap = false)
    private String formatStorage(CraftingStatusMenu.CraftingCpuListEntry cpu) {
        return NumberUtils.numberText(cpu.storage()).getString();
    }
}
