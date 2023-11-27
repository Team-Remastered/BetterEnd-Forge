package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;

import java.util.HashMap;
import java.util.Optional;

public class BaseCraftingTableBlock extends CraftingTableBlock implements BlockModelProvider, LootProvider {
	public BaseCraftingTableBlock(Block source) {
		this(BlockBehaviour.Properties.copy(source));
	}
	
	public BaseCraftingTableBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		String blockName = blockId.getPath();
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_SIDED, new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			
			{
				put("%modid%", blockId.getNamespace());
				put("%particle%", blockName + "_front");
				put("%down%", blockName + "_bottom");
				put("%up%", blockName + "_top");
				put("%north%", blockName + "_front");
				put("%south%", blockName + "_side");
				put("%west%", blockName + "_front");
				put("%east%", blockName + "_side");
			}
		});
		return ModelsHelper.fromPattern(pattern);
	}
}
