package com.teamremastered.betterendforge.entity.render;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.entity.DragonflyEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import com.teamremastered.betterendforge.entity.model.DragonflyEntityModel;
import com.teamremastered.betterendforge.registry.EndEntitiesRenders;

public class RendererEntityDragonfly extends MobRenderer<DragonflyEntity, DragonflyEntityModel> {
	private static final ResourceLocation TEXTURE = BetterEndForge.makeID("textures/entity/dragonfly.png");
	private static final RenderType GLOW = RenderType.eyes(BetterEndForge.makeID("textures/entity/dragonfly_glow.png"));
	
	public RendererEntityDragonfly(EntityRendererProvider.Context ctx) {
		super(ctx, new DragonflyEntityModel(ctx.bakeLayer(EndEntitiesRenders.DRAGONFLY_MODEL)), 0.5f);
		this.addLayer(new EyesLayer<DragonflyEntity, DragonflyEntityModel>(this) {
			@Override
			public RenderType renderType() {
				return GLOW;
			}
		});
	}
	
	@Override
	public ResourceLocation getTextureLocation(DragonflyEntity entity) {
		return TEXTURE;
	}
}