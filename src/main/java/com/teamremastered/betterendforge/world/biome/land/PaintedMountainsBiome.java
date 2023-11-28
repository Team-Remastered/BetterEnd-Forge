package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.registry.EndStructures;

public class PaintedMountainsBiome extends EndBiome.Config {
	public PaintedMountainsBiome() {
		super("painted_mountains");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.structure(EndStructures.PAINTED_MOUNTAIN)
			.fogColor(226, 239, 168)
			.fogDensity(2)
			.waterAndFogColor(192, 180, 131)
			.music(EndSounds.MUSIC_OPENSPACE.get())
			.loop(EndSounds.AMBIENT_DUST_WASTELANDS.get())
			.particles(ParticleTypes.WHITE_ASH, 0.01F)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.ENDSTONE_DUST.get().defaultBlockState();
			}
		};
	}
}
