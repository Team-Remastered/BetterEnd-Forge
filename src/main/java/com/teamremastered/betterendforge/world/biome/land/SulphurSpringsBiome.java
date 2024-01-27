package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.api.surface.SurfaceRuleBuilder;
import com.teamremastered.betterendforge.bclib.api.surface.rules.SwitchRuleSource;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import com.teamremastered.betterendforge.world.surface.SulphuricSurfaceNoiseCondition;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceRules.RuleSource;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndEntities;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndSounds;

import java.util.List;

public class SulphurSpringsBiome extends EndBiome.Config {
	public SulphurSpringsBiome() {
		super("sulphur_springs");
	}

	@Override
	protected boolean hasCaves() {
		return false;
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.music(EndSounds.MUSIC_OPENSPACE.get())
			.loop(EndSounds.AMBIENT_SULPHUR_SPRINGS.get())
			.waterColor(25, 90, 157)
			.waterFogColor(30, 65, 61)
			.fogColor(207, 194, 62)
			.fogDensity(1.5F)
			.terrainHeight(0F)
			.particles(EndParticles.SULPHUR_PARTICLE.get(), 0.001F)
//			.feature(EndFeatures.GEYSER)
//			.feature(EndFeatures.SURFACE_VENT)
//			.feature(EndFeatures.SULPHURIC_LAKE)
//			.feature(EndFeatures.SULPHURIC_CAVE)
//			.feature(EndFeatures.HYDRALUX)
//			.feature(EndFeatures.CHARNIA_GREEN)
//			.feature(EndFeatures.CHARNIA_ORANGE)
//			.feature(EndFeatures.CHARNIA_RED_RARE)
			.spawn(EndEntities.END_FISH.get(), 50, 3, 8)
			.spawn(EndEntities.CUBOZOA.get(), 50, 3, 8)
			.spawn(EntityType.ENDERMAN, 50, 1, 4);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.FLAVOLITE.stone.get().defaultBlockState();
			}

			@Override
			public BlockState getAltTopMaterial() {
				return Blocks.END_STONE.defaultBlockState();
			}

			@Override
			public boolean generateFloorRule() {
				return false;
			}

			@Override
			public SurfaceRuleBuilder surface() {
				RuleSource surfaceBlockRule = new SwitchRuleSource(
					new SulphuricSurfaceNoiseCondition(),
					List.of(
						SurfaceRules.state(surfaceMaterial().getAltTopMaterial()),
						SurfaceRules.state(surfaceMaterial().getTopMaterial()),
						SULPHURIC_ROCK,
						BRIMSTONE
					)
				);
				return super
					.surface()
					.rule(2, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, surfaceBlockRule))
					.rule(2, SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(5, false, CaveSurface.FLOOR), surfaceBlockRule));
			}
		};
	}
}
