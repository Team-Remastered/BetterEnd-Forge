package ru.betterend.bclib.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import ru.betterend.bclib.api.tag.NamedBlockTags;
import ru.betterend.bclib.api.tag.NamedItemTags;
import ru.betterend.bclib.api.tag.TagAPI.TagLocation;
import ru.betterend.bclib.client.render.BCLRenderLayer;
import ru.betterend.bclib.interfaces.RenderLayerProvider;
import ru.betterend.bclib.interfaces.TagProvider;
import ru.betterend.bclib.interfaces.tools.AddMineableHoe;
import ru.betterend.bclib.interfaces.tools.AddMineableShears;

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
				.luminance(light)
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
	public void addTags(List<TagLocation<Block>> blockTags, List<TagLocation<Item>> itemTags) {
		blockTags.add(NamedBlockTags.LEAVES);
		itemTags.add(NamedItemTags.LEAVES);
	}
}