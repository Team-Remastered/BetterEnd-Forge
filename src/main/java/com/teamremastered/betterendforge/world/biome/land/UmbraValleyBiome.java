package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.api.surface.SurfaceRuleBuilder;
import com.teamremastered.betterendforge.bclib.api.surface.rules.SwitchRuleSource;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.world.surface.UmbraSurfaceNoiseCondition;

import java.util.List;

public class UmbraValleyBiome extends EndBiome.Config {
	private static final Block[] SURFACE_BLOCKS = new Block[] {
		EndBlocks.PALLIDIUM_FULL.get(),
		EndBlocks.PALLIDIUM_HEAVY.get(),
		EndBlocks.PALLIDIUM_THIN.get(),
		EndBlocks.PALLIDIUM_TINY.get(),
		EndBlocks.UMBRALITH.stone.get()
	};
	
	public UmbraValleyBiome() {
		super("umbra_valley");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.fogColor(100, 100, 100)
			.plantsColor(172, 189, 190)
			.waterAndFogColor(69, 104, 134)
			.particles(EndParticles.AMBER_SPHERE.get(), 0.0001F)
			.loop(EndSounds.UMBRA_VALLEY.get())
			.music(EndSounds.MUSIC_DARK.get())
//			.feature(EndFeatures.UMBRALITH_ARCH)
//			.feature(EndFeatures.THIN_UMBRALITH_ARCH)
//			.feature(EndFeatures.INFLEXIA)
//			.feature(EndFeatures.FLAMMALIX)
			;
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.UMBRALITH.stone.get().defaultBlockState();
			}
			
			@Override
			public BlockState getUnderMaterial() {
				return EndBlocks.UMBRALITH.stone.get().defaultBlockState();
			}

			@Override
			public BlockState getAltTopMaterial() {
				return EndBlocks.PALLIDIUM_FULL.get().defaultBlockState();
			}

			@Override
			public boolean generateFloorRule() {
				return false;
			}

			@Override
			public SurfaceRuleBuilder surface() {
				return super.surface()
					.rule(2, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
						new SwitchRuleSource(
							new UmbraSurfaceNoiseCondition(),
							List.of(
								SurfaceRules.state(surfaceMaterial().getAltTopMaterial()),
								PALLIDIUM_HEAVY,
								PALLIDIUM_THIN,
								PALLIDIUM_TINY,
								SurfaceRules.state(surfaceMaterial().getTopMaterial())
							)
						)
					));
			}
		};
	}
	
	public static Block getSurface(int x, int z) {
		return SURFACE_BLOCKS[UmbraSurfaceNoiseCondition.getDepth(x, z)];
	}
}
