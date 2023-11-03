package ru.betterend.bclib.items.tool;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.interfaces.ItemModelProvider;

public class BaseShovelItem extends ShovelItem implements ItemModelProvider {
	public BaseShovelItem(Tier material, float attackDamage, float attackSpeed, Properties settings) {
		super(material, attackDamage, attackSpeed, settings);
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return ModelsHelper.createHandheldItem(resourceLocation);
	}
}
