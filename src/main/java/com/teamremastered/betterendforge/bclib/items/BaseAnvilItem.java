package com.teamremastered.betterendforge.bclib.items;

import com.teamremastered.betterendforge.bclib.blocks.BaseAnvilBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.ItemModelProvider;

import java.util.List;
import java.util.Locale;

public class BaseAnvilItem extends BlockItem implements ItemModelProvider {
	public final static String DESTRUCTION = "destruction";
	
	public BaseAnvilItem(Block block, Properties properties) {
		super(block, properties);
	}
	
	@Override
	protected BlockState getPlacementState(BlockPlaceContext blockPlaceContext) {
		BlockState blockState = super.getPlacementState(blockPlaceContext);
		ItemStack stack = blockPlaceContext.getItemInHand();
		int destruction = stack.getOrCreateTag().getInt(DESTRUCTION);
		if (blockState != null) {
			BaseAnvilBlock block = (BaseAnvilBlock) blockState.getBlock();
			IntegerProperty durabilityProp = block.getDurabilityProp();
			if (destruction == 0) {
				blockState = blockState.setValue(durabilityProp, 0).setValue(BaseAnvilBlock.DESTRUCTION, 0);
			}
			else {
				int destructionValue = destruction / block.getMaxDurability();
				int durabilityValue = destruction - destructionValue * block.getMaxDurability();
				blockState = blockState.setValue(durabilityProp, durabilityValue).setValue(BaseAnvilBlock.DESTRUCTION, destructionValue);
			}
		}
		return blockState;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		int destruction = itemStack.getOrCreateTag().getInt(DESTRUCTION);
		if (destruction > 0) {
			BaseAnvilBlock block = (BaseAnvilBlock) ((BaseAnvilItem) itemStack.getItem()).getBlock();
			int maxValue = block.getMaxDurability() * 3;
			float damage = maxValue - destruction;
			String percents = String.format(Locale.ROOT, "%.0f%%", damage);
			list.add(new TranslatableComponent("message.bclib.anvil_damage").append(": " + percents));
		}
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		Block anvilBlock = getBlock();
		ResourceLocation blockId = Registry.BLOCK.getKey(anvilBlock);
		return ((BlockModelProvider) anvilBlock).getBlockModel(blockId, anvilBlock.defaultBlockState());
	}
}
