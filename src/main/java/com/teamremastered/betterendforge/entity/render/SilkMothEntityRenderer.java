package com.teamremastered.betterendforge.entity.render;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.entity.SilkMothEntity;
import com.teamremastered.betterendforge.entity.model.SilkMothEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import com.teamremastered.betterendforge.registry.EndEntitiesRenders;

public class SilkMothEntityRenderer extends MobRenderer<SilkMothEntity, SilkMothEntityModel> {
	private static final ResourceLocation TEXTURE = BetterEndForge.makeID("textures/entity/silk_moth.png");
	
	public SilkMothEntityRenderer(EntityRendererProvider.Context ctx) {
		super(ctx, new SilkMothEntityModel(ctx.bakeLayer(EndEntitiesRenders.SILK_MOTH_MODEL)), 0.5f);
	}
	
	@Override
	public ResourceLocation getTextureLocation(SilkMothEntity entity) {
		return TEXTURE;
	}
}