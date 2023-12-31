package com.teamremastered.betterendforge.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.entity.CubozoaEntity;
import com.teamremastered.betterendforge.entity.model.CubozoaEntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import com.teamremastered.betterendforge.registry.EndEntitiesRenders;

public class RendererEntityCubozoa extends MobRenderer<CubozoaEntity, CubozoaEntityModel> {
	private static final ResourceLocation[] TEXTURE = new ResourceLocation[2];
	private static final RenderType[] GLOW = new RenderType[2];
	
	public RendererEntityCubozoa(EntityRendererProvider.Context ctx) {
		super(ctx, new CubozoaEntityModel(ctx.bakeLayer(EndEntitiesRenders.CUBOZOA_MODEL)), 0.5f);
		this.addLayer(new EyesLayer<CubozoaEntity, CubozoaEntityModel>(this) {
			@Override
			public RenderType renderType() {
				return GLOW[0];
			}
			
			@Override
			public void render(PoseStack matrices, MultiBufferSource vertexConsumers, int light, CubozoaEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
				VertexConsumer vertexConsumer = vertexConsumers.getBuffer(GLOW[entity.getVariant()]);
				this.getParentModel()
					.renderToBuffer(matrices,
						vertexConsumer,
						15728640,
						OverlayTexture.NO_OVERLAY,
						1.0F,
						1.0F,
						1.0F,
						1.0F
					);
			}
		});
	}
	
	@Override
	protected void scale(CubozoaEntity entity, PoseStack matrixStack, float f) {
		float scale = entity.getScale();
		matrixStack.scale(scale, scale, scale);
	}
	
	@Override
	public ResourceLocation getTextureLocation(CubozoaEntity entity) {
		return TEXTURE[entity.getVariant()];
	}
	
	static {
		TEXTURE[0] = BetterEndForge.makeID("textures/entity/cubozoa/cubozoa.png");
		TEXTURE[1] = BetterEndForge.makeID("textures/entity/cubozoa/cubozoa_sulphur.png");
		
		GLOW[0] = RenderType.eyes(BetterEndForge.makeID("textures/entity/cubozoa/cubozoa_glow.png"));
		GLOW[1] = RenderType.eyes(BetterEndForge.makeID("textures/entity/cubozoa/cubozoa_sulphur_glow.png"));
	}
}