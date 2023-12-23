package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndFeatures;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndSounds;

public class UmbrellaJungleBiome extends EndBiome.Config {
	public UmbrellaJungleBiome() {
		super("umbrella_jungle");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.fogColor(87, 223, 221)
			.waterAndFogColor(119, 198, 253)
			.foliageColor(27, 183, 194)
			.fogDensity(2.3F)
			.particles(EndParticles.JUNGLE_SPORE.get(), 0.001F)
			.music(EndSounds.MUSIC_FOREST.get())
			.loop(EndSounds.AMBIENT_UMBRELLA_JUNGLE.get())
//			.feature(EndFeatures.END_LAKE)
//			.feature(EndFeatures.UMBRELLA_TREE)
//			.feature(EndFeatures.JELLYSHROOM)
//			.feature(EndFeatures.TWISTED_UMBRELLA_MOSS)
//			.feature(EndFeatures.SMALL_JELLYSHROOM_FLOOR)
//			.feature(EndFeatures.JUNGLE_GRASS)
//			.feature(EndFeatures.CYAN_MOSS)
//			.feature(EndFeatures.CYAN_MOSS_WOOD)
//			.feature(EndFeatures.JUNGLE_FERN_WOOD)
//			.feature(EndFeatures.SMALL_JELLYSHROOM_WALL)
//			.feature(EndFeatures.SMALL_JELLYSHROOM_WOOD)
//			.feature(EndFeatures.SMALL_JELLYSHROOM_CEIL)
//			.feature(EndFeatures.JUNGLE_VINE)
//			.feature(EndFeatures.CHARNIA_CYAN)
//			.feature(EndFeatures.CHARNIA_GREEN)
//			.feature(EndFeatures.CHARNIA_LIGHT_BLUE)
//			.feature(EndFeatures.CHARNIA_RED_RARE)
//			.structure(BiomeTags.HAS_END_CITY)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.JUNGLE_MOSS.get().defaultBlockState();
			}
		};
	}
}