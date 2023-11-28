package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.item.model.CrystaliteArmorProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import shadow.fabric.api.client.rendering.v1.ArmorRenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class EndModelProviders {
	
	public final static CrystaliteArmorProvider CRYSTALITE_PROVIDER = new CrystaliteArmorProvider();
	
	public final static void register() {
		ArmorRenderingRegistry.registerModel(CRYSTALITE_PROVIDER, CRYSTALITE_PROVIDER.getRenderedItems());
		ArmorRenderingRegistry.registerTexture(CRYSTALITE_PROVIDER, CRYSTALITE_PROVIDER.getRenderedItems());
	}
}
