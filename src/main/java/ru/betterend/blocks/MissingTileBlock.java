package ru.betterend.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.level.block.Blocks;
import ru.betterend.bclib.blocks.BaseBlock;

public class MissingTileBlock extends BaseBlock {
	public MissingTileBlock() {
		super(FabricBlockSettings.copyOf(Blocks.END_STONE));
	}
}
