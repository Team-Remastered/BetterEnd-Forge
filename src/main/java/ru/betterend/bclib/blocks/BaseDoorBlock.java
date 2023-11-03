package ru.betterend.bclib.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.api.tag.NamedBlockTags;
import ru.betterend.bclib.api.tag.NamedItemTags;
import ru.betterend.bclib.api.tag.TagAPI.TagLocation;
import ru.betterend.bclib.client.models.BasePatterns;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.models.PatternsHelper;
import ru.betterend.bclib.client.render.BCLRenderLayer;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.LootProvider;
import ru.betterend.bclib.interfaces.RenderLayerProvider;
import ru.betterend.bclib.interfaces.TagProvider;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BaseDoorBlock extends DoorBlock implements RenderLayerProvider, BlockModelProvider, TagProvider, LootProvider {
	public BaseDoorBlock(Block source) {
		this(FabricBlockSettings.copyOf(source).strength(3F, 3F).noOcclusion());
	}
	
	public BaseDoorBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) return Collections.singletonList(new ItemStack(this.asItem()));
		else return Collections.emptyList();
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		DoorType doorType = getDoorType(blockState);
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_DOOR_BOTTOM, resourceLocation);
		switch (doorType) {
			case TOP_HINGE:
				pattern = PatternsHelper.createJson(BasePatterns.BLOCK_DOOR_TOP_HINGE, resourceLocation);
				break;
			case BOTTOM_HINGE:
				pattern = PatternsHelper.createJson(BasePatterns.BLOCK_DOOR_BOTTOM_HINGE, resourceLocation);
				break;
			case TOP:
				pattern = PatternsHelper.createJson(BasePatterns.BLOCK_DOOR_TOP, resourceLocation);
				break;
			default:
				break;
		}
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		Direction facing = blockState.getValue(FACING);
		DoorType doorType = getDoorType(blockState);
		boolean open = blockState.getValue(OPEN);
		boolean hinge = doorType.isHinge();
		BlockModelRotation rotation = BlockModelRotation.X0_Y0;
		switch (facing) {
			case EAST:
				if (hinge && open) {
					rotation = BlockModelRotation.X0_Y90;
				}
				else if (open) {
					rotation = BlockModelRotation.X0_Y270;
				}
				break;
			case SOUTH:
				if (!hinge && !open || hinge && !open) {
					rotation = BlockModelRotation.X0_Y90;
				}
				else if (hinge) {
					rotation = BlockModelRotation.X0_Y180;
				}
				break;
			case WEST:
				if (!hinge && !open || hinge && !open) {
					rotation = BlockModelRotation.X0_Y180;
				}
				else if (hinge) {
					rotation = BlockModelRotation.X0_Y270;
				}
				else {
					rotation = BlockModelRotation.X0_Y90;
				}
				break;
			case NORTH:
			default:
				if (!hinge && !open || hinge && !open) {
					rotation = BlockModelRotation.X0_Y270;
				}
				else if (!hinge) {
					rotation = BlockModelRotation.X0_Y180;
				}
				break;
		}
		ResourceLocation modelId = new ResourceLocation(
			stateId.getNamespace(),
			"block/" + stateId.getPath() + "_" + doorType
		);
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createMultiVariant(modelId, rotation.getRotation(), false);
	}
	
	protected DoorType getDoorType(BlockState blockState) {
		boolean isHinge = isHinge(blockState.getValue(HINGE), blockState.getValue(OPEN));
		switch (blockState.getValue(HALF)) {
			case UPPER: {
				return isHinge ? DoorType.TOP_HINGE : DoorType.TOP;
			}
			case LOWER: {
				return isHinge ? DoorType.BOTTOM_HINGE : DoorType.BOTTOM;
			}
		}
		return DoorType.BOTTOM;
	}
	
	private boolean isHinge(DoorHingeSide hingeSide, boolean open) {
		boolean isHinge = hingeSide == DoorHingeSide.RIGHT;
		return isHinge && !open || !isHinge && open;
	}
	
	@Override
	public void addTags(List<TagLocation<Block>> blockTags, List<TagLocation<Item>> itemTags) {
		blockTags.add(NamedBlockTags.DOORS);
		itemTags.add(NamedItemTags.DOORS);
	}
	
	protected enum DoorType implements StringRepresentable {
		BOTTOM_HINGE("bottom_hinge"), TOP_HINGE("top_hinge"), BOTTOM("bottom"), TOP("top");
		
		private final String name;
		
		DoorType(String name) {
			this.name = name;
		}
		
		public boolean isHinge() {
			return this == BOTTOM_HINGE || this == TOP_HINGE;
		}
		
		@Override
		public String toString() {
			return getSerializedName();
		}
		
		@Override
		public String getSerializedName() {
			return name;
		}
	}
}
