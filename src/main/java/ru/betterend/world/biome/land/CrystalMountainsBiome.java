package ru.betterend.world.biome.land;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.biomes.BCLBiomeBuilder;
import ru.betterend.bclib.interfaces.SurfaceMaterialProvider;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndFeatures;
import ru.betterend.registry.EndSounds;
import ru.betterend.registry.EndStructures;
import ru.betterend.world.biome.EndBiome;

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
			.feature(EndFeatures.CRYSTAL_GRASS)
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
