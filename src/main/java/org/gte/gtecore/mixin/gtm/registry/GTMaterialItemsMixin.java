package org.gte.gtecore.mixin.gtm.registry;

import org.gte.gtecore.api.data.tag.GTETagPrefix;
import org.gte.gtecore.api.registries.GTERegistration;
import org.gte.gtecore.common.data.GTECreativeModeTabs;
import org.gte.gtecore.utils.register.ItemRegisterUtils;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.TagPrefixItem;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTMaterialItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.tterrag.registrate.util.entry.ItemEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.gregtechceu.gtceu.common.data.GTCreativeModeTabs.MATERIAL_ITEM;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

@Mixin(GTMaterialItems.class)
public final class GTMaterialItemsMixin {

    @Shadow(remap = false)
    static ImmutableTable.Builder<TagPrefix, Material, ItemEntry<TagPrefixItem>> MATERIAL_ITEMS_BUILDER;

    @Shadow(remap = false)
    public static Table<TagPrefix, Material, ItemEntry<TagPrefixItem>> MATERIAL_ITEMS;

    @Inject(method = "generateTools", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;creativeModeTab(Ljava/util/function/Supplier;)V"), remap = false)
    private static void setToolCreativeModeTab(CallbackInfo ci) {
        GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_ITEM);
    }

    /**
     * @author .
     * @reason .
     */
    @Overwrite(remap = false)
    public static void generateMaterialItems() {
        REGISTRATE.creativeModeTab(() -> MATERIAL_ITEM);
        GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_MATERIAL_ITEM);
        for (var tagPrefix : TagPrefix.values()) {
            if (tagPrefix.doGenerateItem()) {
                for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
                    GTRegistrate registrate;
                    if (tagPrefix instanceof GTETagPrefix) {
                        registrate = GTERegistration.REGISTRATE;
                    } else {
                        registrate = registry.getRegistrate();
                    }
                    for (Material material : registry.getAllMaterials()) {
                        if (tagPrefix.doGenerateItem(material)) {
                            ItemRegisterUtils.generateMaterialItem(registrate, tagPrefix, material, MATERIAL_ITEMS_BUILDER);
                        }
                    }
                }
            }
        }
        MATERIAL_ITEMS = MATERIAL_ITEMS_BUILDER.build();
    }

    @Inject(method = "generateTool", at = @At("HEAD"), remap = false, cancellable = true)
    private static void generateTool(Material material, GTToolType toolType, GTRegistrate registrate, CallbackInfo ci) {
        if (toolType == GTToolType.KNIFE && (material == GTMaterials.Flint)) ci.cancel();
    }
}
