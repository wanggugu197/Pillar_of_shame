package org.gte.gtecore.data;

import org.gte.gtecore.data.lang.LangHandler;
import org.gte.gtecore.data.lang.provider.SimplifiedChineseLanguageProvider;
import org.gte.gtecore.data.lang.provider.TraditionalChineseLanguageProvider;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.data.tags.TagsHandler;

import com.tterrag.registrate.providers.ProviderType;

import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;

public interface Datagen {

    static void init() {
        if (GTCEu.isDataGen()) {
            REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, TagsHandler::initBlock);
            REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, TagsHandler::initItem);
            REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::enInitialize);
            REGISTRATE.addDataGenerator(SimplifiedChineseLanguageProvider.LANG, LangHandler::cnInitialize);
            REGISTRATE.addDataGenerator(TraditionalChineseLanguageProvider.LANG, LangHandler::twInitialize);
        }
    }
}
