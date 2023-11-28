package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.api.surface.SurfaceRuleBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndSounds;

public class DustWastelandsBiome extends EndBiome.Config {
	public DustWastelandsBiome() {
		super("dust_wastelands");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.fogColor(226, 239, 168)
			.fogDensity(2)
			.waterAndFogColor(192, 180, 131)
			.terrainHeight(1.5F)
			.particles(ParticleTypes.WHITE_ASH, 0.01F)
			.loop(EndSounds.AMBIENT_DUST_WASTELANDS.get())
			.music(EndSounds.MUSIC_OPENSPACE.get())
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
			public SurfaceRuleBuilder surface() {
				return super
					.surface()
					.ceil(Blocks.END_STONE.defaultBlockState())
					.rule(4, SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(5, false, CaveSurface.FLOOR),
						SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState())
					));
			}
		};
	}
}
