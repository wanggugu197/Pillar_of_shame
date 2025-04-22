package org.gte.gtecore.common.recipe.condition;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTERecipeConditions;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public final class RestrictedMachineCondition extends RecipeCondition {

    private static final ResourceLocation MULTIBLOCK = GTECore.id("multiblock");

    public static final Codec<RestrictedMachineCondition> CODEC = RecordCodecBuilder
            .create(instance -> isReverse(instance)
                    .and(ResourceLocation.CODEC.fieldOf("id").forGetter(val -> val.id))
                    .apply(instance, RestrictedMachineCondition::new));

    public static RestrictedMachineCondition multiblock() {
        return new RestrictedMachineCondition(MULTIBLOCK);
    }

    private ResourceLocation id;

    private MachineDefinition definition;

    private RestrictedMachineCondition(boolean isReverse, ResourceLocation id) {
        super(isReverse);
        this.id = id;
    }

    public RestrictedMachineCondition(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public RecipeConditionType<?> getType() {
        return GTERecipeConditions.RESTRICTED_MACHINE;
    }

    @Override
    public Component getTooltips() {
        if (id.equals(MULTIBLOCK)) {
            return Component.translatable("gtecore.recipe.restricted_machine", Component.translatable("gtceu.multiblock.title"));
        }
        if (definition == null) {
            definition = GTRegistries.MACHINES.get(id);
        }
        MachineDefinition machineDefinition = definition;
        return Component.translatable("gtecore.recipe.restricted_machine", machineDefinition == null ? "null" : Component.translatable(machineDefinition.getDescriptionId()));
    }

    @Override
    public boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        MachineDefinition machineDefinition = recipeLogic.getMachine().getDefinition();
        if (id.equals(MULTIBLOCK)) {
            return recipeLogic.getMachine() instanceof MultiblockControllerMachine;
        }
        return machineDefinition.getId().equals(id);
    }

    @Override
    public RecipeCondition createTemplate() {
        return new RestrictedMachineCondition();
    }

    @NotNull
    @Override
    public JsonObject serialize() {
        JsonObject config = super.serialize();
        config.addProperty("id", id.toString());
        return config;
    }

    @Override
    public RecipeCondition deserialize(@NotNull JsonObject config) {
        super.deserialize(config);
        id = new ResourceLocation(GsonHelper.getAsString(config, "id", "dummy"));
        return this;
    }

    @Override
    public RecipeCondition fromNetwork(FriendlyByteBuf buf) {
        super.fromNetwork(buf);
        id = new ResourceLocation(buf.readUtf());
        return this;
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf) {
        super.toNetwork(buf);
        buf.writeUtf(id.toString());
    }
}
