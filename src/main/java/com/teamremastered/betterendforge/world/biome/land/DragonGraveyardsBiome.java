package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndSounds;

public class DragonGraveyardsBiome extends EndBiome.Config {
	public DragonGraveyardsBiome() {
		super("dragon_graveyards");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.genChance(0.1f)
			.fogColor(244, 46, 79)
			.fogDensity(1.3F)
			.particles(EndParticles.FIREFLY.get(), 0.0007F)
			.music(EndSounds.MUSIC_OPENSPACE.get())
			.loop(EndSounds.AMBIENT_GLOWING_GRASSLANDS.get())
			.waterAndFogColor(203, 59, 167)
			.plantsColor(244, 46, 79)
//			.feature(EndFeatures.OBSIDIAN_PILLAR_BASEMENT)
//			.feature(EndFeatures.DRAGON_BONE_BLOCK_ORE)
//			.feature(EndFeatures.FALLEN_PILLAR)
//			.feature(EndFeatures.OBSIDIAN_BOULDER)
//			.feature(EndFeatures.GIGANTIC_AMARANITA)
//			.feature(EndFeatures.LARGE_AMARANITA)
//			.feature(EndFeatures.SMALL_AMARANITA)
//			.feature(EndFeatures.GLOBULAGUS)
//			.feature(EndFeatures.CLAWFERN)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.SANGNUM.get().defaultBlockState();
			}
		};
	}
}
