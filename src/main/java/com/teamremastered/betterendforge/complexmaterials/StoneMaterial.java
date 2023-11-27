package com.teamremastered.betterendforge.complexmaterials;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseFurnaceBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseRotatedPillarBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseSlabBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseStairsBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseStoneButtonBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseWallBlock;
import com.teamremastered.betterendforge.bclib.blocks.StonePressurePlateBlock;
import com.teamremastered.betterendforge.blocks.EndFlowerPotBlock;
import com.teamremastered.betterendforge.blocks.EndPedestal;
import com.teamremastered.betterendforge.blocks.basis.StoneLanternBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

public class StoneMaterial {
	public final RegistryObject<Block> stone;
	
	public final RegistryObject<Block> polished;
	public final RegistryObject<Block> tiles;
	public final RegistryObject<Block> pillar;
	public final RegistryObject<Block> stairs;
	public final RegistryObject<Block> slab;
	public final RegistryObject<Block> wall;
	public final RegistryObject<Block> button;
	public final RegistryObject<Block> pressurePlate;
	public final RegistryObject<Block> pedestal;
	public final RegistryObject<Block> lantern;
	
	public final RegistryObject<Block> bricks;
	public final RegistryObject<Block> brickStairs;
	public final RegistryObject<Block> brickSlab;
	public final RegistryObject<Block> brickWall;
	public final RegistryObject<Block> furnace;
	public final RegistryObject<Block> flowerPot;
	
	public StoneMaterial(String name, MaterialColor color) {
		BlockBehaviour.Properties material = BlockBehaviour.Properties.copy(Blocks.END_STONE).color(color);
		
		stone = EndBlocks.registerBlock(name,  () -> new BaseBlock(material));
		polished = EndBlocks.registerBlock(name + "_polished",  () -> new BaseBlock(material));
		tiles = EndBlocks.registerBlock(name + "_tiles",  () -> new BaseBlock(material));
		pillar = EndBlocks.registerBlock(name + "_pillar",  () -> new BaseRotatedPillarBlock(material));
		stairs = EndBlocks.registerBlock(name + "_stairs",  () -> new BaseStairsBlock(stone.get()));
		slab = EndBlocks.registerBlock(name + "_slab",  () -> new BaseSlabBlock(stone.get()));
		wall = EndBlocks.registerBlock(name + "_wall",  () -> new BaseWallBlock(stone.get()));
		button = EndBlocks.registerBlock(name + "_button",  () -> new BaseStoneButtonBlock(stone.get()));
		pressurePlate = EndBlocks.registerBlock(name + "_plate",  () -> new StonePressurePlateBlock(stone.get()));
		pedestal = EndBlocks.registerBlock(name + "_pedestal",  () -> new EndPedestal(stone.get()));
		lantern = EndBlocks.registerBlock(name + "_lantern",  () -> new StoneLanternBlock(stone.get()));
		
		bricks = EndBlocks.registerBlock(name + "_bricks",  () -> new BaseBlock(material));
		brickStairs = EndBlocks.registerBlock(name + "_bricks_stairs",  () -> new BaseStairsBlock(bricks.get()));
		brickSlab = EndBlocks.registerBlock(name + "_bricks_slab",  () -> new BaseSlabBlock(bricks.get()));
		brickWall = EndBlocks.registerBlock(name + "_bricks_wall",  () -> new BaseWallBlock(bricks.get()));
		furnace = EndBlocks.registerBlock(name + "_furnace",  () -> new BaseFurnaceBlock(bricks.get()));
		flowerPot = EndBlocks.registerBlock(name + "_flower_pot",  () -> new EndFlowerPotBlock(bricks.get()));
		
		// Recipes //
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bricks", bricks.get())
//
//				  .setOutputCount(4)
//				  .setShape("##", "##")
//				  .addMaterial('#', stone.get())
//				  .setGroup("end_bricks")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_polished", polished.get())
//
//				  .setOutputCount(4)
//				  .setShape("##", "##")
//				  .addMaterial('#', bricks.get())
//				  .setGroup("end_tile")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_tiles", tiles.get())
//
//				  .setOutputCount(4)
//				  .setShape("##", "##")
//				  .addMaterial('#', polished.get())
//				  .setGroup("end_small_tile")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_pillar", pillar.get())
//
//				  .setShape("#", "#")
//				  .addMaterial('#', slab.get())
//				  .setGroup("end_pillar")
//				  .build();
//
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_stairs", stairs.get())
//
//				  .setOutputCount(4)
//				  .setShape("#  ", "## ", "###")
//				  .addMaterial('#', stone.get())
//				  .setGroup("end_stone_stairs")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_slab", slab.get())
//
//				  .setOutputCount(6)
//				  .setShape("###")
//				  .addMaterial('#', stone.get())
//				  .setGroup("end_stone_slabs")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bricks_stairs", brickStairs.get())
//
//				  .setOutputCount(4)
//				  .setShape("#  ", "## ", "###")
//				  .addMaterial('#', bricks.get())
//				  .setGroup("end_stone_stairs")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bricks_slab", brickSlab.get())
//
//				  .setOutputCount(6)
//				  .setShape("###")
//				  .addMaterial('#', bricks.get())
//				  .setGroup("end_stone_slabs")
//				  .build();
//
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_wall", wall.get())
//
//				  .setOutputCount(6)
//				  .setShape("###", "###")
//				  .addMaterial('#', stone.get())
//				  .setGroup("end_wall")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bricks_wall", brickWall.get())
//
//				  .setOutputCount(6)
//				  .setShape("###", "###")
//				  .addMaterial('#', bricks.get())
//				  .setGroup("end_wall")
//				  .build();
//
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_button", button.get())
//
//				  .setList("#")
//				  .addMaterial('#', stone.get())
//				  .setGroup("end_stone_buttons")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_pressure_plate", pressurePlate.get())
//
//				  .setShape("##")
//				  .addMaterial('#', stone.get())
//				  .setGroup("end_stone_plates")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_lantern", lantern.get())
//
//				  .setShape("S", "#", "S")
//				  .addMaterial('#', EndItems.CRYSTAL_SHARDS.get())
//				  .addMaterial('S', slab.get(), brickSlab.get())
//				  .setGroup("end_stone_lanterns")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_furnace", furnace.get())
//
//				  .setShape("###", "# #", "###")
//				  .addMaterial('#', stone.get())
//				  .setGroup("end_stone_ITEM_FURNACES")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_flower_pot", flowerPot.get())
//
//				  .setOutputCount(3)
//				  .setShape("# #", " # ")
//				  .addMaterial('#', bricks.get())
//				  .setGroup("end_pots")
//				  .build();
//
//		CraftingRecipes.registerPedestal(name + "_pedestal", pedestal.get(), slab.get(), pillar.get());
//
//		// Item Tags //
//		TagAPI.addItemTag(NamedItemTags.SLABS, slab.get(), brickSlab.get());
//		TagAPI.addItemTag(NamedItemTags.STONE_BRICKS, bricks.get());
//		TagAPI.addItemTag(NamedItemTags.STONE_CRAFTING_MATERIALS, stone.get());
//		TagAPI.addItemTag(NamedItemTags.STONE_TOOL_MATERIALS, stone.get());
//		TagAPI.addItemTag(NamedCommonItemTags.FURNACES, furnace.get());
//
//		// Block Tags //
//		TagAPI.addBlockTag(NamedBlockTags.STONE_BRICKS, bricks.get());
//		TagAPI.addBlockTag(NamedBlockTags.WALLS, wall.get(), brickWall.get());
//		TagAPI.addBlockTag(NamedBlockTags.SLABS, slab.get(), brickSlab.get());
//		TagAPI.addBlockTags(pressurePlate.get(), NamedBlockTags.PRESSURE_PLATES, NamedBlockTags.STONE_PRESSURE_PLATES);
//		TagAPI.addBlockTag(NamedCommonBlockTags.END_STONES, stone.get());
//
//		TagAPI.addBlockTag(NamedCommonBlockTags.DRAGON_IMMUNE, stone.get(), stairs.get(), slab.get(), wall.get());
//
//		TagAPI.addBlockTag(NamedCommonBlockTags.GEN_END_STONES, stone.get());
//		TagAPI.addBlockTag(NamedCommonBlockTags.END_STONES, stone.get());
		//FIXME: Move the recipes because they try to access blocks that are not yet registered
	}
}