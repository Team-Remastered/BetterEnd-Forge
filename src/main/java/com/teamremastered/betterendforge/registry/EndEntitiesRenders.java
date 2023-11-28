package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.entity.model.CubozoaEntityModel;
import com.teamremastered.betterendforge.entity.model.DragonflyEntityModel;
import com.teamremastered.betterendforge.entity.model.EndFishEntityModel;
import com.teamremastered.betterendforge.entity.model.EndSlimeEntityModel;
import com.teamremastered.betterendforge.entity.model.SilkMothEntityModel;
import com.teamremastered.betterendforge.entity.render.RendererEntityCubozoa;
import com.teamremastered.betterendforge.entity.render.RendererEntityDragonfly;
import com.teamremastered.betterendforge.entity.render.RendererEntityEndFish;
import com.teamremastered.betterendforge.entity.render.RendererEntityEndSlime;
import com.teamremastered.betterendforge.entity.render.RendererEntityShadowWalker;
import com.teamremastered.betterendforge.entity.render.SilkMothEntityRenderer;
import com.teamremastered.betterendforge.item.model.ArmoredElytraModel;
import com.teamremastered.betterendforge.item.model.CrystaliteBootsModel;
import com.teamremastered.betterendforge.item.model.CrystaliteChestplateModel;
import com.teamremastered.betterendforge.item.model.CrystaliteHelmetModel;
import com.teamremastered.betterendforge.item.model.CrystaliteLeggingsModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndEntitiesRenders {
	public static final ModelLayerLocation DRAGONFLY_MODEL = registerMain("dragonfly");
	public static final ModelLayerLocation END_SLIME_SHELL_MODEL = registerMain("endslime_shell");
	public static final ModelLayerLocation END_SLIME_MODEL = registerMain("endslime");
	public static final ModelLayerLocation END_FISH_MODEL = registerMain("endfish");
	public static final ModelLayerLocation CUBOZOA_MODEL = registerMain("cubozoa");
	public static final ModelLayerLocation SILK_MOTH_MODEL = registerMain("silkmoth");
	public static final ModelLayerLocation TEST_MODEL = registerMain("test");
	
	public static final ModelLayerLocation ARMORED_ELYTRA = registerMain("armored_elytra");
	public static final ModelLayerLocation CRYSTALITE_CHESTPLATE = registerMain("crystalite_chestplate");
	public static final ModelLayerLocation CRYSTALITE_CHESTPLATE_THIN = registerMain("crystalite_chestplate_thin");
	public static final ModelLayerLocation CRYSTALITE_HELMET = registerMain("crystalite_helmet");
	public static final ModelLayerLocation CRYSTALITE_LEGGINGS = registerMain("crystalite_leggings");
	public static final ModelLayerLocation CRYSTALITE_BOOTS = registerMain("crystalite_boots");

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(DRAGONFLY_MODEL, DragonflyEntityModel::getTexturedModelData);
		event.registerLayerDefinition(END_SLIME_SHELL_MODEL, EndSlimeEntityModel::getShellOnlyTexturedModelData);
		event.registerLayerDefinition(END_SLIME_MODEL, EndSlimeEntityModel::getCompleteTexturedModelData);
		event.registerLayerDefinition(END_FISH_MODEL, EndFishEntityModel::getTexturedModelData);
		event.registerLayerDefinition(CUBOZOA_MODEL, CubozoaEntityModel::getTexturedModelData);
		event.registerLayerDefinition(SILK_MOTH_MODEL, SilkMothEntityModel::getTexturedModelData);

		event.registerLayerDefinition(ARMORED_ELYTRA, ArmoredElytraModel::getTexturedModelData);
		event.registerLayerDefinition(CRYSTALITE_CHESTPLATE, CrystaliteChestplateModel::getRegularTexturedModelData);
		event.registerLayerDefinition(CRYSTALITE_CHESTPLATE_THIN, CrystaliteChestplateModel::getThinTexturedModelData);
		event.registerLayerDefinition(CRYSTALITE_HELMET, CrystaliteHelmetModel::getTexturedModelData);
		event.registerLayerDefinition(CRYSTALITE_LEGGINGS, CrystaliteLeggingsModel::getTexturedModelData);
		event.registerLayerDefinition(CRYSTALITE_BOOTS, CrystaliteBootsModel::getTexturedModelData);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EndEntities.DRAGONFLY.get(), RendererEntityDragonfly::new);
		event.registerEntityRenderer(EndEntities.END_SLIME.get(), RendererEntityEndSlime::new);
		event.registerEntityRenderer(EndEntities.END_FISH.get(), RendererEntityEndFish::new);
		event.registerEntityRenderer(EndEntities.SHADOW_WALKER.get(), RendererEntityShadowWalker::new);
		event.registerEntityRenderer(EndEntities.CUBOZOA.get(), RendererEntityCubozoa::new);
		event.registerEntityRenderer(EndEntities.SILK_MOTH.get(), SilkMothEntityRenderer::new);

	}
	
	public static ModelLayerLocation registerMain(String id) {
		return new ModelLayerLocation(BetterEndForge.makeID(id), "main");
	}
}
