package ru.betterend.integration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import ru.betterend.bclib.api.ModIntegrationAPI;
import ru.betterend.bclib.integration.ModIntegration;
import ru.betterend.bclib.recipes.GridRecipe;
import ru.betterend.BetterEndForge;
import ru.betterend.config.Configs;
import ru.betterend.events.PlayerAdvancementsCallback;
import ru.betterend.integration.byg.BYGIntegration;
import ru.betterend.item.GuideBookItem;
import ru.betterend.registry.EndItems;

public class Integrations {
	public static final ModIntegration BYG = ModIntegrationAPI.register(new BYGIntegration());
	public static final ModIntegration NOURISH = ModIntegrationAPI.register(new NourishIntegration());
	public static final ModIntegration FLAMBOYANT_REFABRICATED = ModIntegrationAPI.register(new FlamboyantRefabricatedIntegration());
	
	private static boolean hasHydrogen;
	
	public static void init() {
		if (hasGuideBook()) {
			GuideBookItem.register();
			
			PlayerAdvancementsCallback.PLAYER_ADVANCEMENT_COMPLETE.register((player, advancement, criterionName) -> {
				ResourceLocation advId = new ResourceLocation("minecraft:end/enter_end_gateway");
				if (advId.equals(advancement.getId())) {
					player.addItem(new ItemStack(GuideBookItem.GUIDE_BOOK));
				}
			});
			
			GridRecipe.make(BetterEndForge.MOD_ID, "guide_book", GuideBookItem.GUIDE_BOOK)
					  .checkConfig(Configs.RECIPE_CONFIG)
					  .setShape("D", "B", "C")
					  .addMaterial('D', EndItems.ENDER_DUST.get())
					  .addMaterial('B', Items.BOOK)
					  .addMaterial('C', EndItems.CRYSTAL_SHARDS.get())
					  .build();
		}
		hasHydrogen = FabricLoader.getInstance().isModLoaded("hydrogen");
	}
	
	public static boolean hasGuideBook() {
		return FabricLoader.getInstance().isModLoaded("patchouli");
	}
	
	public static boolean hasHydrogen() {
		return hasHydrogen;
	}
}
