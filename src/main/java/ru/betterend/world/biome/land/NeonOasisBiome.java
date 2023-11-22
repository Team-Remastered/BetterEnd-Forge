package ru.betterend.world.biome.land;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceRules.RuleSource;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import ru.betterend.bclib.api.biomes.BCLBiomeBuilder;
import ru.betterend.bclib.api.surface.SurfaceRuleBuilder;
import ru.betterend.bclib.api.surface.rules.SwitchRuleSource;
import ru.betterend.bclib.interfaces.SurfaceMaterialProvider;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndFeatures;
import ru.betterend.registry.EndSounds;
import ru.betterend.world.biome.EndBiome;
import ru.betterend.world.surface.SplitNoiseCondition;

import java.util.List;

public class NeonOasisBiome extends EndBiome.Config {
	public NeonOasisBiome() {
		super("neon_oasis");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.genChance(0.5F)
			.fogColor(226, 239, 168)
			.fogDensity(2)
			.waterAndFogColor(106, 238, 215)
			.particles(ParticleTypes.WHITE_ASH, 0.01F)
			.loop(EndSounds.AMBIENT_DUST_WASTELANDS.get())
			.music(EndSounds.MUSIC_OPENSPACE.get())
			.feature(EndFeatures.DESERT_LAKE)
			.feature(EndFeatures.NEON_CACTUS)
			.feature(EndFeatures.UMBRELLA_MOSS)
			.feature(EndFeatures.CREEPING_MOSS)
			.feature(EndFeatures.CHARNIA_GREEN)
			.feature(EndFeatures.CHARNIA_CYAN)
			.feature(EndFeatures.CHARNIA_RED)
			.structure(BiomeTags.HAS_END_CITY)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.ENDSTONE_DUST.get().defaultBlockState();
			}

			@Override
			public BlockState getAltTopMaterial() {
				return EndBlocks.END_MOSS.get().defaultBlockState();
			}
			
			@Override
			public SurfaceRuleBuilder surface() {
				RuleSource surfaceBlockRule = new SwitchRuleSource(
					new SplitNoiseCondition(),
					List.of(
						SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState()),
						SurfaceRules.state(EndBlocks.END_MOSS.get().defaultBlockState())
					)
				);
				return super
					.surface()
					.ceil(Blocks.END_STONE.defaultBlockState())
					.rule(1, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, surfaceBlockRule))
					.rule(4, SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(5, false, CaveSurface.FLOOR),
						SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState())
					));
			}
		};
	}
}
