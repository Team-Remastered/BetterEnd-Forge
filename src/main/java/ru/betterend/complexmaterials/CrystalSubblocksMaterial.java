package ru.betterend.complexmaterials;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.bclib.api.tag.NamedBlockTags;
import ru.betterend.bclib.api.tag.NamedItemTags;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.blocks.BaseSlabBlock;
import ru.betterend.bclib.blocks.BaseStairsBlock;
import ru.betterend.bclib.blocks.BaseWallBlock;
import ru.betterend.bclib.recipes.GridRecipe;
import ru.betterend.BetterEndForge;
import ru.betterend.blocks.EndPedestal;
import ru.betterend.blocks.basis.LitBaseBlock;
import ru.betterend.blocks.basis.LitPillarBlock;
import ru.betterend.recipe.CraftingRecipes;
import ru.betterend.registry.EndBlocks;

import java.util.function.Supplier;

public class CrystalSubblocksMaterial {
	public final RegistryObject<Block> polished;
	public final RegistryObject<Block> tiles;
	public final RegistryObject<Block> pillar;
	public final RegistryObject<Block> stairs;
	public final RegistryObject<Block> slab;
	public final RegistryObject<Block> wall;
	public final RegistryObject<Block> pedestal;
	public final RegistryObject<Block> bricks;
	public final RegistryObject<Block> brick_stairs;
	public final RegistryObject<Block> brick_slab;
	public final RegistryObject<Block> brick_wall;
	
	public CrystalSubblocksMaterial(String name, final Supplier<? extends Block> source) {
		polished = EndBlocks.registerBlock(name + "_polished", () -> new LitBaseBlock(BlockBehaviour.Properties.copy(source.get())));
		tiles = EndBlocks.registerBlock(name + "_tiles", () -> new LitBaseBlock(BlockBehaviour.Properties.copy(source.get())));
		pillar = EndBlocks.registerBlock(name + "_pillar", () -> new LitPillarBlock(BlockBehaviour.Properties.copy(source.get())));
		stairs = EndBlocks.registerBlock(name + "_stairs", () -> new BaseStairsBlock(source.get()));
		slab = EndBlocks.registerBlock(name + "_slab", () -> new BaseSlabBlock(source.get()));
		wall = EndBlocks.registerBlock(name + "_wall", () -> new BaseWallBlock(source.get()));
		pedestal = EndBlocks.registerBlock(name + "_pedestal", () -> new EndPedestal(source.get()));
		bricks = EndBlocks.registerBlock(name + "_bricks", () -> new LitBaseBlock(BlockBehaviour.Properties.copy(source.get())));
		brick_stairs = EndBlocks.registerBlock(name + "_bricks_stairs", () -> new BaseStairsBlock(bricks.get()));
		brick_slab = EndBlocks.registerBlock(name + "_bricks_slab", () -> new BaseSlabBlock(bricks.get()));
		brick_wall = EndBlocks.registerBlock(name + "_bricks_wall", () -> new BaseWallBlock(bricks.get()));
		
		// Recipes //
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bricks", bricks.get())
//
//				  .setOutputCount(4)
//				  .setShape("##", "##")
//				  .addMaterial('#', source.get())
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
//				  .addMaterial('#', source.get())
//				  .setGroup("end_stone_stairs")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_slab", slab.get())
//
//				  .setOutputCount(6)
//				  .setShape("###")
//				  .addMaterial('#', source.get())
//				  .setGroup("end_stone_slabs")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bricks_stairs", brick_stairs.get())
//
//				  .setOutputCount(4)
//				  .setShape("#  ", "## ", "###")
//				  .addMaterial('#', bricks.get())
//				  .setGroup("end_stone_stairs")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bricks_slab", brick_slab.get())
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
//				  .addMaterial('#', source.get())
//				  .setGroup("end_wall")
//				  .build();
//		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bricks_wall", brick_wall.get())
//
//				  .setOutputCount(6)
//				  .setShape("###", "###")
//				  .addMaterial('#', bricks.get())
//				  .setGroup("end_wall")
//				  .build();
//
//		CraftingRecipes.registerPedestal(name + "_pedestal", pedestal.get(), slab.get(), pillar.get());
//
//		// Item Tags //
//		TagAPI.addItemTag(NamedItemTags.SLABS, slab.get(), brick_slab.get());
//		TagAPI.addItemTag(NamedItemTags.STONE_BRICKS, bricks.get());
//		TagAPI.addItemTag(NamedItemTags.STONE_CRAFTING_MATERIALS, source.get());
//		TagAPI.addItemTag(NamedItemTags.STONE_TOOL_MATERIALS, source.get());
//
//		// Block Tags //
//		TagAPI.addBlockTag(NamedBlockTags.STONE_BRICKS, bricks.get());
//		TagAPI.addBlockTag(NamedBlockTags.WALLS, wall.get(), brick_wall.get());
//		TagAPI.addBlockTag(NamedBlockTags.SLABS, slab.get(), brick_slab.get());
	} //FIXME: Fix Recipes
}