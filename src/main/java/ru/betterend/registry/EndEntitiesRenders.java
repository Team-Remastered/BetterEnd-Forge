package ru.betterend.registry;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.betterend.BetterEndForge;
import ru.betterend.entity.model.CubozoaEntityModel;
import ru.betterend.entity.model.DragonflyEntityModel;
import ru.betterend.entity.model.EndFishEntityModel;
import ru.betterend.entity.model.EndSlimeEntityModel;
import ru.betterend.entity.model.SilkMothEntityModel;
import ru.betterend.entity.render.RendererEntityCubozoa;
import ru.betterend.entity.render.RendererEntityDragonfly;
import ru.betterend.entity.render.RendererEntityEndFish;
import ru.betterend.entity.render.RendererEntityEndSlime;
import ru.betterend.entity.render.RendererEntityShadowWalker;
import ru.betterend.entity.render.SilkMothEntityRenderer;
import ru.betterend.item.model.ArmoredElytraModel;
import ru.betterend.item.model.CrystaliteBootsModel;
import ru.betterend.item.model.CrystaliteChestplateModel;
import ru.betterend.item.model.CrystaliteHelmetModel;
import ru.betterend.item.model.CrystaliteLeggingsModel;

import java.util.function.Function;

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
	
	private static ModelLayerLocation registerMain(String id) {
		return new ModelLayerLocation(BetterEndForge.makeID(id), "main");
	}
}
