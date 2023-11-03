package ru.betterend.world.biome.land;

import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.biomes.BCLBiomeBuilder;
import ru.betterend.bclib.interfaces.SurfaceMaterialProvider;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndFeatures;
import ru.betterend.registry.EndSounds;
import ru.betterend.world.biome.EndBiome;

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
			.music(EndSounds.MUSIC_OPENSPACE)
			.feature(EndFeatures.LUCERNIA_BUSH_RARE)
			.feature(EndFeatures.ORANGO)
			.feature(EndFeatures.AERIDIUM)
			.feature(EndFeatures.LUTEBUS)
			.feature(EndFeatures.LAMELLARIUM)
			.structure(BiomeTags.HAS_END_CITY)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.RUTISCUS.defaultBlockState();
			}
		};
	}
}
