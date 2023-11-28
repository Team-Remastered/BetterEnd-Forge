package com.teamremastered.betterendforge.world.biome.cave;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiomeSettings;
import com.teamremastered.betterendforge.noise.OpenSimplexNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.world.biome.EndBiome;

public class JadeCaveBiome extends EndCaveBiome.Config {
	public static class Biome extends EndCaveBiome {
		private static final OpenSimplexNoise WALL_NOISE = new OpenSimplexNoise("jade_cave".hashCode());
		private static final OpenSimplexNoise DEPTH_NOISE = new OpenSimplexNoise("depth_noise".hashCode());
		private static final BlockState[] JADE = new BlockState[3];

		public Biome(ResourceLocation biomeID, net.minecraft.world.level.biome.Biome biome, BCLBiomeSettings settings) {
			super(biomeID, biome, settings);

			JADE[0] = EndBlocks.VIRID_JADESTONE.stone.get().defaultBlockState();
			JADE[1] = EndBlocks.AZURE_JADESTONE.stone.get().defaultBlockState();
			JADE[2] = EndBlocks.SANDY_JADESTONE.stone.get().defaultBlockState();
		}

		@Override
		public BlockState getWall(BlockPos pos) {
			double depth = DEPTH_NOISE.eval(pos.getX() * 0.02, pos.getZ() * 0.02) * 0.2 + 0.5;
			int index = Mth.floor((pos.getY() + WALL_NOISE.eval(pos.getX() * 0.2, pos.getZ() * 0.2) * 1.5) * depth + 0.5);
			index = Mth.abs(index) % 3;
			return JADE[index];
		}
	}

	public JadeCaveBiome() {
		super("jade_cave");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		super.addCustomBuildData(builder);
		builder.fogColor(118, 150, 112)
			   .fogDensity(2.0F)
			   .waterAndFogColor(95, 223, 255);
	}

	@Override
	public BCLBiomeBuilder.BiomeSupplier<EndBiome> getSupplier() {
		return JadeCaveBiome.Biome::new;
	}
}
