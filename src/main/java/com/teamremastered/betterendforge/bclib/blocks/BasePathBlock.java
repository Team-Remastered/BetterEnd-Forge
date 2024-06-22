package com.teamremastered.betterendforge.bclib.blocks;

import com.google.common.collect.Maps;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import net.minecraft.core.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import org.lwjgl.system.CallbackI;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

public class BasePathBlock extends BaseBlockNotFull implements LootProvider {
	private static final VoxelShape SHAPE = box(0, 0, 0, 16, 15, 16);
	
	private Block baseBlock;
	
	public BasePathBlock(Block source) {
		super(BlockBehaviour.Properties.copy(source).isValidSpawn((state, world, pos, type) -> false));
		this.baseBlock = Blocks.DIRT;
		if (source instanceof BaseTerrainBlock) {
			BaseTerrainBlock terrain = (BaseTerrainBlock) source;
			this.baseBlock = terrain.getBaseBlock();
			terrain.setPathBlock(this);
		}
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		ItemStack tool = builder.getParameter(LootContextParams.TOOL);
		if (tool != null && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0) {
			return Collections.singletonList(new ItemStack(this));
		}
		return Collections.singletonList(new ItemStack(Blocks.END_STONE));
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getCollisionShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		return getBlockModel(blockId, defaultBlockState());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		String name = blockId.getPath();
		ResourceLocation bottomId = Registry.BLOCK.getKey(baseBlock);
		String bottom = bottomId.getNamespace() + ":block/" + bottomId.getPath();
		Map<String, String> textures = Maps.newHashMap();
		textures.put("%modid%", blockId.getNamespace());
		textures.put("%top%", name + "_top");
		textures.put("%side%", name.replace("_path", "") + "_side");
		textures.put("%bottom%", bottom);
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_PATH, textures);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createRandomTopModel(modelId);
	}

	@OnlyIn(Dist.CLIENT)
	public BlockModelBuilder getBlockModelBuilder(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath();

		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + blockName);
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.mcLoc("block/block")));

		blockModel.texture("particle", stateProvider.mcLoc("block/end_stone"));
		blockModel.texture("top", stateProvider.modLoc("block/" + blockName + "_top"));

		//Remove the "_path" from the block name since we are taking the side of the normal block
		blockModel.texture("side", stateProvider.modLoc("block/" + blockName.replace("_path", "") + "_side"));
		blockModel.texture("bottom", stateProvider.mcLoc("block/end_stone"));

		blockModel.element().from(0, 0, 0).to(16,16,16)

			//Down and Up uvs do not show in the block model because they represent base values I think
			.face(Direction.DOWN).uvs(0, 0, 16, 16).texture("#bottom").cullface(Direction.DOWN).end()
			.face(Direction.UP).uvs(0, 0, 16, 16).texture("#top").end()
			.face(Direction.NORTH).uvs(0, 1, 16, 16).texture("#side").cullface(Direction.NORTH).end()
			.face(Direction.SOUTH).uvs(0, 1, 16, 16).texture("#side").cullface(Direction.SOUTH).end()
			.face(Direction.EAST).uvs(0, 1, 16, 16).texture("#side").cullface(Direction.EAST).end()
			.face(Direction.WEST).uvs(0, 1, 16, 16).texture("#side").cullface(Direction.WEST).end();

		return blockModel;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block basePathBlock) {
		BlockModelBuilder builder = getBlockModelBuilder(stateProvider, basePathBlock);
		stateProvider.simpleBlock(basePathBlock, builder);
		stateProvider.simpleBlockItem(basePathBlock, builder);
	}
}