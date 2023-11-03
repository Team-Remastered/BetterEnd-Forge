package ru.betterend.bclib.items.tool;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.interfaces.ItemModelProvider;

public class BaseAxeItem extends AxeItem implements ItemModelProvider {
	public BaseAxeItem(Tier material, float attackDamage, float attackSpeed, Properties settings) {
		super(material, attackDamage, attackSpeed, settings);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return ModelsHelper.createHandheldItem(resourceLocation);
	}
}
