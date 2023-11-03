package ru.betterend.world.biome.cave;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.biomes.BCLBiomeBuilder;
import ru.betterend.bclib.api.biomes.BCLBiomeBuilder.BiomeSupplier;
import ru.betterend.bclib.blocks.BlockProperties;
import ru.betterend.bclib.interfaces.SurfaceMaterialProvider;
import ru.betterend.bclib.world.biomes.BCLBiomeSettings;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndFeatures;
import ru.betterend.registry.EndParticles;
import ru.betterend.world.biome.EndBiome;

public class LushAuroraCaveBiome extends EndCaveBiome.Config {
	public static class Biome extends EndCaveBiome {
		public Biome(ResourceLocation biomeID, net.minecraft.world.level.biome.Biome biome, BCLBiomeSettings settings) {
			super(biomeID, biome, settings);

			this.addFloorFeature(EndFeatures.BIG_AURORA_CRYSTAL, 1);
			this.addFloorFeature(EndFeatures.CAVE_BUSH, 5);
			this.addFloorFeature(EndFeatures.CAVE_GRASS, 40);
			this.addFloorFeature(EndFeatures.END_STONE_STALAGMITE_CAVEMOSS, 5);

			this.addCeilFeature(EndFeatures.CAVE_BUSH, 1);
			this.addCeilFeature(EndFeatures.CAVE_PUMPKIN, 1);
			this.addCeilFeature(EndFeatures.RUBINEA, 3);
			this.addCeilFeature(EndFeatures.MAGNULA, 1);
			this.addCeilFeature(EndFeatures.END_STONE_STALACTITE_CAVEMOSS, 10);
		}

		@Override
		public float getFloorDensity() {
			return 0.2F;
		}

		@Override
		public float getCeilDensity() {
			return 0.1F;
		}

		@Override
		public BlockState getCeil(BlockPos pos) {
			return EndBlocks.CAVE_MOSS.defaultBlockState()
									  .setValue(BlockProperties.TRIPLE_SHAPE, BlockProperties.TripleShape.TOP);
		}
	}

	public LushAuroraCaveBiome() {
		super("lush_aurora_cave");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		super.addCustomBuildData(builder);
		builder.fogColor(150, 30, 68)
			   .fogDensity(2.0F)
			   .plantsColor(108, 25, 46)
			   .waterAndFogColor(186, 77, 237)
			   .particles(EndParticles.GLOWING_SPHERE, 0.001F)
			   ;
	}

	@Override
	public BiomeSupplier<EndBiome> getSupplier() {
		return LushAuroraCaveBiome.Biome::new;
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.CAVE_MOSS.defaultBlockState();
			}
		};
	}
}
