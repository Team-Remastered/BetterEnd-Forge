package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.blocks.BaseLeavesBlock;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.interfaces.PottablePlant;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;

public class PottableLeavesBlock extends BaseLeavesBlock implements PottablePlant, IBCLBlockStateProvider {
	
	public PottableLeavesBlock(Block sapling, MaterialColor color) {
		super(sapling, color);
	}
	
	public PottableLeavesBlock(Block sapling, MaterialColor color, int light) {
		super(sapling, color, light);
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		if (sapling instanceof PottablePlant) {
			return ((PottablePlant) sapling).canPlantOn(block);
		}
		return true;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		ModelFile leaves = stateProvider.models().withExistingParent(block.getRegistryName().getPath(), stateProvider.mcLoc("block/leaves"))
				.texture("all", stateProvider.modLoc("block/" + block.getRegistryName().getPath()));
		stateProvider.simpleBlock(block, leaves);
		stateProvider.simpleBlockItem(block, leaves);
	}
}