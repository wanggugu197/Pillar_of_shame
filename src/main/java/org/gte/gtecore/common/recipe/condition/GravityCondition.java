package org.gte.gtecore.common.recipe.condition;

import org.gte.gtecore.api.machine.feature.IGravityPartMachine;
import org.gte.gtecore.common.data.GTERecipeConditions;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.GsonHelper;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import earth.terrarium.adastra.api.systems.GravityApi;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public final class GravityCondition extends RecipeCondition {

    public static final Codec<GravityCondition> CODEC = RecordCodecBuilder
            .create(instance -> isReverse(instance)
                    .and(Codec.BOOL.fieldOf("gravity").forGetter(val -> val.zero))
                    .apply(instance, GravityCondition::new));

    private boolean zero;

    public GravityCondition(boolean zero) {
        this.zero = zero;
    }

    private GravityCondition(boolean isReverse, boolean zero) {
        super(isReverse);
        this.zero = zero;
    }

    @Override
    public RecipeConditionType<?> getType() {
        return GTERecipeConditions.GRAVITY;
    }

    @Override
    public Component getTooltips() {
        return Component.translatable("gtecore.condition." + (zero ? "zero_" : "") + "gravity");
    }

    @Override
    public boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        MetaMachine machine = recipeLogic.getMachine();
        if (machine instanceof MultiblockControllerMachine controllerMachine) {
            for (IMultiPart part : controllerMachine.self().getParts()) {
                if (part instanceof IGravityPartMachine gravityPart) {
                    return gravityPart.getCurrentGravity() == (zero ? 0 : 100);
                }
            }
        }
        return GravityApi.API.getGravity(machine.getLevel(), machine.getPos()) == 0 && zero;
    }

    @Override
    public RecipeCondition createTemplate() {
        return new GravityCondition();
    }

    @NotNull
    @Override
    public JsonObject serialize() {
        JsonObject config = super.serialize();
        config.addProperty("gravity", zero);
        return config;
    }

    @Override
    public RecipeCondition deserialize(@NotNull JsonObject config) {
        super.deserialize(config);
        zero = GsonHelper.getAsBoolean(config, "gravity", false);
        return this;
    }

    @Override
    public RecipeCondition fromNetwork(FriendlyByteBuf buf) {
        super.fromNetwork(buf);
        zero = buf.readBoolean();
        return this;
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf) {
        super.toNetwork(buf);
        buf.writeBoolean(zero);
    }
}
