package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndSounds;

public class DryShrublandBiome extends EndBiome.Config {
	public DryShrublandBiome() {
		super("dry_shrubland");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.fogColor(132, 35, 13)
			.fogDensity(1.2F)
			.waterAndFogColor(113, 88, 53)
			.plantsColor(237, 122, 66)
			.music(EndSounds.MUSIC_OPENSPACE.get())
//			.feature(EndFeatures.LUCERNIA_BUSH_RARE)
//			.feature(EndFeatures.ORANGO)
//			.feature(EndFeatures.AERIDIUM)
//			.feature(EndFeatures.LUTEBUS)
//			.feature(EndFeatures.LAMELLARIUM)
//			.structure(BiomeTags.HAS_END_CITY)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.RUTISCUS.get().defaultBlockState();
			}
		};
	}
}
