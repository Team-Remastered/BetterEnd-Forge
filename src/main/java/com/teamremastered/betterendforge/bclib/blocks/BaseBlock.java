package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;

import java.util.function.Consumer;

/**
 * Base class for a default Block.
 * <p>
 * This Block-Type will:
 * <ul>
 *	 <li>Drop itself</li>
 *	 <li>Automatically create an Item-Model from the Block-Model</li>
 * </ul>
 */
public class BaseBlock extends Block implements BlockModelProvider, LootProvider, IBCLBlockStateProvider {
	/**
	 * Creates a new Block with the passed properties
	 *
	 * @param settings The properties of the Block.
	 */
	public BaseBlock(Properties settings) {
		super(settings);
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * This implementation will load the Block-Model and return it as the Item-Model
	 */
	@Override
	public BlockModel getItemModel(ResourceLocation blockId) {
		return getBlockModel(blockId, defaultBlockState());
	}
	
	/**
	 * This method is used internally.
	 * <p>
	 * It is called from Block-Contructors, to allow the augmentation of the blocks
	 * preset properties.
	 * <p>
	 * For example in {@link BaseLeavesBlock#BaseLeavesBlock(Block, MaterialColor, Consumer)}
	 *
	 * @param customizeProperties A {@link Consumer} to call with the preset properties
	 * @param settings			The properties as created by the Block
	 * @return The reconfigured {@code settings}
	 */
	static BlockBehaviour.Properties acceptAndReturn(Consumer<BlockBehaviour.Properties> customizeProperties, BlockBehaviour.Properties settings) {
		customizeProperties.accept(settings);
		return settings;
	}

	/** Used to generate blockstates and models **/

	public static BlockModelBuilder cubeAll(BlockStateProvider stateProvider, String blockName) {

		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + blockName);
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.mcLoc("block/cube")));

		blockModel.texture("particle", stateProvider.modLoc("block/" + blockName));
		blockModel.texture("up", stateProvider.modLoc("block/" + blockName));
		blockModel.texture("north", stateProvider.modLoc("block/" + blockName));
		blockModel.texture("south", stateProvider.modLoc("block/" + blockName));
		blockModel.texture("east", stateProvider.modLoc("block/" + blockName));
		blockModel.texture("west", stateProvider.modLoc("block/" + blockName));
		blockModel.texture("down", stateProvider.modLoc("block/" + blockName));

		return blockModel;
	}

	/** The parent model cube_all doesn't want to work for some reason **/
	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath();

		stateProvider.simpleBlock(block, cubeAll(stateProvider, blockName));
		stateProvider.simpleBlockItem(block, cubeAll(stateProvider, blockName));

	}
}