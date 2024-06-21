package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BaseBookshelfBlock extends BaseRotatedPillarBlock implements LootProvider, IBCLBlockStateProvider {
	public BaseBookshelfBlock(Block source) {
		this(BlockBehaviour.Properties.copy(source));
	}
	
	public BaseBookshelfBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		ItemStack tool = builder.getParameter(LootContextParams.TOOL);
		if (tool != null) {
			int silk = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool);
			if (silk > 0) {
				return Collections.singletonList(new ItemStack(this));
			}
		}
		return Collections.singletonList(new ItemStack(Items.BOOK, 3));
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_BOOKSHELF, replacePath(blockId));
		return ModelsHelper.fromPattern(pattern);
	}

	public BlockModelBuilder getBlockModelBuilder(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath();
		String parentName = blockName.replace("bookshelf", "planks"); //get the parent block
		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + block.getRegistryName().getPath());
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.modLoc("block/block_bottom_top")));

		blockModel.texture("end", stateProvider.modLoc("block/" + parentName))
				  .texture("side", stateProvider.modLoc("block/" + blockName));

		return blockModel;
	}
	
	private ResourceLocation replacePath(ResourceLocation blockId) {
		String newPath = blockId.getPath().replace("_bookshelf", "");
		return new ResourceLocation(blockId.getNamespace(), newPath);
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block bookshelf) {
		BlockModelBuilder builder = getBlockModelBuilder(stateProvider, bookshelf);
		stateProvider.simpleBlock(bookshelf, builder);
		stateProvider.simpleBlockItem(bookshelf, stateProvider.models().getBuilder("block/" + bookshelf.getRegistryName().getPath()));
	}
}