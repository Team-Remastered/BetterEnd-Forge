package ru.betterend.bclib.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.LootProvider;

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
public class BaseBlock extends Block implements BlockModelProvider, LootProvider {
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
	static FabricBlockSettings acceptAndReturn(Consumer<FabricBlockSettings> customizeProperties, FabricBlockSettings settings) {
		customizeProperties.accept(settings);
		return settings;
	}
}