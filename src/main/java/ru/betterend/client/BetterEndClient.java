package ru.betterend.client;

import net.minecraft.resources.ResourceLocation;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.util.TranslationHelper;
import ru.betterend.BetterEndForge;
import ru.betterend.interfaces.MultiModelItem;
import ru.betterend.registry.EndModelProviders;

public class BetterEndClient {

	public static void initializeClient() {
		EndModelProviders.register();
		MultiModelItem.register();
		ClientOptions.init();
		
		if (BCLib.isDevEnvironment()) {
			TranslationHelper.printMissingEnNames(BetterEndForge.MOD_ID);
			TranslationHelper.printMissingNames(BetterEndForge.MOD_ID, "ru_ru");
		}
		
		ResourceLocation checkFlowerId = new ResourceLocation("item/chorus_flower");
		ResourceLocation checkPlantId = new ResourceLocation("item/chorus_plant");
		ResourceLocation toLoadFlowerId = new ResourceLocation("betterend", "item/custom_chorus_flower");
		ResourceLocation toLoadPlantId = new ResourceLocation("betterend", "item/custom_chorus_plant");

//		ModelLoadingRegistry.INSTANCE.registerResourceProvider(manager -> (resourceId, context) -> {
//			if (GeneratorOptions.changeChorusPlant()) {
//				if (resourceId.equals(checkFlowerId)) {
//					return context.loadModel(toLoadFlowerId);
//				}
//				else if (resourceId.equals(checkPlantId)) {
//					return context.loadModel(toLoadPlantId);
//				}
//			}
//			return null;
//		});
		
		if(ClientOptions.isCustomSky()) {
//			DimensionRenderingRegistry.registerSkyRenderer(Level.END, new BetterEndSkyRenderer());
		}
		//FIXME: Idk how to port this atm
	}
	
//	public static void registerTooltips() {
//		ItemTooltipCallback.EVENT.register((player, stack, context, lines) -> {
//			if (stack.getItem() instanceof CrystaliteArmor) {
//				boolean hasSet = false;
//				if (player != null) {
//					hasSet = CrystaliteArmor.hasFullSet(player);
//				}
//				TranslatableComponent setDesc = new TranslatableComponent("tooltip.armor.crystalite_set");
//				setDesc.setStyle(Style.EMPTY.applyFormats(
//					hasSet ? ChatFormatting.BLUE : ChatFormatting.DARK_GRAY,
//					ChatFormatting.ITALIC
//				));
//				lines.add(TextComponent.EMPTY);
//				lines.add(setDesc);
//			}
//		});
//	}
	//FIXME: Fix the toolTips
}