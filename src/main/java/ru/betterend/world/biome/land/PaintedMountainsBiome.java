package ru.betterend.world.biome.land;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.biomes.BCLBiomeBuilder;
import ru.betterend.bclib.interfaces.SurfaceMaterialProvider;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndSounds;
import ru.betterend.registry.EndStructures;
import ru.betterend.world.biome.EndBiome;

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
