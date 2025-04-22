package org.gte.gtecore.utils.register;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.data.chemical.material.GTEMaterialBuilder;
import org.gte.gtecore.data.lang.LangHandler;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class MaterialsRegisterUtils {

    private MaterialsRegisterUtils() {}

    public static final Map<String, LangHandler.ENCN> LANG = GTCEu.isDataGen() ? new HashMap<>() : null;

    private static void addLang(String name, Supplier<LangHandler.ENCN> supplier) {
        if (LANG == null) return;
        LangHandler.ENCN lang = supplier.get();
        if (LANG.containsKey(name)) {
            GTECore.LOGGER.error("Repetitive Key: {}", name);
            throw new IllegalStateException();
        }
        if (LANG.containsValue(lang)) {
            GTECore.LOGGER.error("Repetitive Value: {}", lang);
            throw new IllegalStateException();
        }
        LANG.put(name, lang);
    }

    public static GTEMaterialBuilder material(String name, String en, String cn) {
        addLang(name, () -> new LangHandler.ENCN(en, cn));
        return new GTEMaterialBuilder(name);
    }

    public static GTEMaterialBuilder material(String name, String cn) {
        addLang(name, () -> new LangHandler.ENCN(FormattingUtil.toEnglishName(name), cn));
        return new GTEMaterialBuilder(name);
    }
}
