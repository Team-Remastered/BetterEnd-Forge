package com.teamremastered.betterendforge.integration;

import com.teamremastered.betterendforge.bclib.api.ModIntegrationAPI;
import com.teamremastered.betterendforge.bclib.integration.ModIntegration;
import com.teamremastered.betterendforge.integration.byg.BYGIntegration;
import com.teamremastered.betterendforge.item.GuideBookItem;
import net.minecraftforge.fml.ModList;

public class Integrations {
	public static final ModIntegration BYG = ModIntegrationAPI.register(new BYGIntegration());
	public static final ModIntegration NOURISH = ModIntegrationAPI.register(new NourishIntegration());
	public static final ModIntegration FLAMBOYANT_REFABRICATED = ModIntegrationAPI.register(new FlamboyantRefabricatedIntegration());
	
	private static boolean hasHydrogen;
	
	public static void init() {
		if (hasGuideBook()) {
			GuideBookItem.register();
			
//			PlayerAdvancementsCallback.PLAYER_ADVANCEMENT_COMPLETE.register((player, advancement, criterionName) -> {
//				ResourceLocation advId = new ResourceLocation("minecraft:end/enter_end_gateway");
//				if (advId.equals(advancement.getId())) {
//					player.addItem(new ItemStack(GuideBookItem.GUIDE_BOOK));
//				}
//			}); //FIXME: Needs to convert this to Forge
			
//			GridRecipe.make(BetterEndForge.MOD_ID, "guide_book", GuideBookItem.GUIDE_BOOK.get())
//
//					  .setShape("D", "B", "C")
//					  .addMaterial('D', EndItems.ENDER_DUST.get())
//					  .addMaterial('B', Items.BOOK)
//					  .addMaterial('C', EndItems.CRYSTAL_SHARDS.get())
//					  .build();
		}
		hasHydrogen = ModList.get().isLoaded("hydrogen");
	}
	
	public static boolean hasGuideBook() {
		return ModList.get().isLoaded("patchouli");
	}
	
	public static boolean hasHydrogen() {
		return hasHydrogen;
	}
}
