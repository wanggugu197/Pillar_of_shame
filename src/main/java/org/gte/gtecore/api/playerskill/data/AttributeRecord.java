package org.gte.gtecore.api.playerskill.data;

import org.gte.gtecore.api.playerskill.experiencelevel.BasicExperienceLevel;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.UUID;
import java.util.function.ToDoubleFunction;

public record AttributeRecord(UUID uuid, Attribute attribute, AttributeModifier.Operation operation, ToDoubleFunction<BasicExperienceLevel> valueCalculator) {

    public AttributeModifier getModifier(BasicExperienceLevel expLevel) {
        return new AttributeModifier(uuid, "gtecore.exp." + expLevel.skillType.getEnglishName().toLowerCase() + "_" + attribute.getDescriptionId().toLowerCase() + "_" + operation.name().toLowerCase() + "_bonus", valueCalculator.applyAsDouble(expLevel), operation);
    }
}
