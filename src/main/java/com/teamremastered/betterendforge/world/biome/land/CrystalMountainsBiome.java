package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.registry.world.EndStructures;

public class CrystalMountainsBiome extends EndBiome.Config {
	public CrystalMountainsBiome() {
		super("crystal_mountains");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.structure(EndStructures.MOUNTAIN)
			.plantsColor(255, 133, 211)
			.music(EndSounds.MUSIC_OPENSPACE.get())
//			.feature(EndFeatures.CRYSTAL_GRASS)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.CRYSTAL_MOSS.get().defaultBlockState();
			}
		};
	}
}
