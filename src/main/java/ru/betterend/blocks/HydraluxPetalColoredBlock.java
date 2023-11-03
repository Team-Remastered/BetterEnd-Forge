package ru.betterend.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.interfaces.CustomColorProvider;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.client.models.Patterns;

import java.util.Optional;

public class HydraluxPetalColoredBlock extends HydraluxPetalBlock implements CustomColorProvider {
	public HydraluxPetalColoredBlock(FabricBlockSettings settings) {
		super(settings);
	}
	
	@Override
	public BlockColor getProvider() {
		return (state, world, pos, tintIndex) -> BlocksHelper.getBlockColor(this);
	}
	
	@Override
	public ItemColor getItemProvider() {
		return (stack, tintIndex) -> BlocksHelper.getBlockColor(this);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		String path = "betterend:block/block_petal_colored";
		Optional<String> pattern = Patterns.createJson(Patterns.BLOCK_PETAL_COLORED, path, path);
		return ModelsHelper.fromPattern(pattern);
	}
}
