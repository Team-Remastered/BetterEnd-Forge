package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.api.tag.NamedBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedItemTags;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;
import com.teamremastered.betterendforge.bclib.interfaces.TagProvider;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableHoe;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableShears;

import java.util.List;

public class SimpleLeavesBlock extends BaseBlockNotFull implements RenderLayerProvider, TagProvider, AddMineableShears, AddMineableHoe {
	public SimpleLeavesBlock(MaterialColor color) {
		this(
			BlockBehaviour.Properties
				.of(Material.LEAVES)
				.strength(0.2F)
				.color(color)
				.sound(SoundType.GRASS)
				.noOcclusion()
				.isValidSpawn((state, world, pos, type) -> false)
				.isSuffocating((state, world, pos) -> false)
				.isViewBlocking((state, world, pos) -> false)
		);
	}
	
	public SimpleLeavesBlock(MaterialColor color, int light) {
		this(
			BlockBehaviour.Properties
				.of(Material.LEAVES)
				.lightLevel(BlocksHelper.getLightValue(light))
				.color(color)
				.strength(0.2F)
				.sound(SoundType.GRASS)
				.noOcclusion()
				.isValidSpawn((state, world, pos, type) -> false)
				.isSuffocating((state, world, pos) -> false)
				.isViewBlocking((state, world, pos) -> false)
		);
	}
	
	public SimpleLeavesBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	public void addTags(List<TagAPI.TagLocation<Block>> blockTags, List<TagAPI.TagLocation<Item>> itemTags) {
		blockTags.add(NamedBlockTags.LEAVES);
		itemTags.add(NamedItemTags.LEAVES);
	}
}