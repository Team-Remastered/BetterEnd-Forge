package ru.betterend.blocks;

import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.blocks.BlockHelper;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.render.BCLRenderLayer;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.RenderLayerProvider;
import ru.betterend.bclib.interfaces.tools.AddMineablePickaxe;
import ru.betterend.blocks.basis.EndLanternBlock;
import ru.betterend.client.models.Patterns;

import java.util.Map;
import java.util.Optional;

public class BulbVineLanternBlock extends EndLanternBlock implements RenderLayerProvider, BlockModelProvider, AddMineablePickaxe {
	private static final VoxelShape SHAPE_CEIL = Block.box(4, 4, 4, 12, 16, 12);
	private static final VoxelShape SHAPE_FLOOR = Block.box(4, 0, 4, 12, 12, 12);
	
	public BulbVineLanternBlock() {
		this(BlockBehaviour.Properties.of(Material.METAL)
								.destroyTime(1)
								.explosionResistance(1)
								.mapColor(MaterialColor.COLOR_LIGHT_GRAY)
								.lightLevel(BlockHelper.getLightValue(15))
								.requiresCorrectToolForDrops()
								.sound(SoundType.LANTERN));
	}
	
	public BulbVineLanternBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return state.getValue(IS_FLOOR) ? SHAPE_FLOOR : SHAPE_CEIL;
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		Map<String, String> textures = Maps.newHashMap();
		textures.put("%glow%", getGlowTexture());
		textures.put("%metal%", getMetalTexture(resourceLocation));
		Optional<String> pattern = blockState.getValue(IS_FLOOR) ? Patterns.createJson(
			Patterns.BLOCK_BULB_LANTERN_FLOOR,
			textures
		) : Patterns.createJson(Patterns.BLOCK_BULB_LANTERN_CEIL, textures);
		return ModelsHelper.fromPattern(pattern);
	}
	
	protected String getMetalTexture(ResourceLocation blockId) {
		String name = blockId.getPath();
		name = name.substring(0, name.indexOf('_'));
		return name + "_bulb_vine_lantern_metal";
	}
	
	protected String getGlowTexture() {
		return "bulb_vine_lantern_bulb";
	}
	
}
