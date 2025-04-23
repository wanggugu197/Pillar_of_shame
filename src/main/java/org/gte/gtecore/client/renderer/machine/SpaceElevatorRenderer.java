package org.gte.gtecore.client.renderer.machine;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.client.ClientUtil;
import org.gte.gtecore.client.renderer.GTERenderTypes;
import org.gte.gtecore.client.renderer.RenderBufferHelper;
import org.gte.gtecore.common.machine.multiblock.electric.space.SpaceElevatorMachine;
import org.gte.gtecore.common.machine.multiblock.electric.space.SuperSpaceElevatorMachine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.ModelData;

import com.lowdragmc.lowdraglib.utils.TrackedDummyWorld;
import com.mojang.blaze3d.vertex.PoseStack;

import java.util.function.Consumer;

public final class SpaceElevatorRenderer extends WorkableCasingMachineRenderer {

    private static final ResourceLocation CLIMBER_MODEL = GTECore.id("obj/climber");

    public SpaceElevatorRenderer() {
        super(GTECore.id("block/casings/space_elevator_mechanical_casing"), GTCEu.id("block/multiblock/data_bank"));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void render(BlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (blockEntity instanceof IMachineBlockEntity machineBlockEntity) {
            MetaMachine metaMachine = machineBlockEntity.getMetaMachine();
            if (metaMachine instanceof SpaceElevatorMachine machine && machine.isFormed() && (machine.getSpoolCount() >= machine.getMaxSpoolCount() || blockEntity.getLevel() instanceof TrackedDummyWorld)) {
                boolean Super = machine instanceof SuperSpaceElevatorMachine;
                double x = 0.5, y = 1, z = 0.5;
                if (Super) {
                    switch (machine.getFrontFacing()) {
                        case NORTH -> z = 4.5;
                        case SOUTH -> z = -3.5;
                        case WEST -> x = 4.5;
                        case EAST -> x = -3.5;
                    }
                } else {
                    switch (machine.getFrontFacing()) {
                        case NORTH -> z = 3.5;
                        case SOUTH -> z = -2.5;
                        case WEST -> x = 3.5;
                        case EAST -> x = -2.5;
                    }
                }
                poseStack.pushPose();
                RenderBufferHelper.renderCylinder(poseStack, buffer.getBuffer(GTERenderTypes.LIGHT_CYLINDER), (float) x, (float) (y - 2), (float) z, Super ? 0.5F : 0.3F, 360, 10, 0, 0, 0, 255);
                poseStack.translate(x, y + machine.getHigh(), z);
                RendererModel(poseStack, buffer, Super ? 8 : 4, CLIMBER_MODEL);
                poseStack.popPose();
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    static void RendererModel(PoseStack poseStack, MultiBufferSource buffer, float scale, ResourceLocation climberModel) {
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        ClientUtil.modelRenderer().renderModel(poseStack.last(), buffer.getBuffer(RenderType.solid()), null, ClientUtil.getBakedModel(climberModel), 1.0F, 1.0F, 1.0F, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.solid());
        poseStack.popPose();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void onAdditionalModel(Consumer<ResourceLocation> registry) {
        super.onAdditionalModel(registry);
        registry.accept(CLIMBER_MODEL);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasTESR(BlockEntity blockEntity) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isGlobalRenderer(BlockEntity blockEntity) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getViewDistance() {
        return 256;
    }
}
