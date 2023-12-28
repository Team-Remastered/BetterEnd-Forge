package com.teamremastered.betterendforge.world.biome;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.api.biomes.BiomeAPI;
import com.teamremastered.betterendforge.bclib.api.surface.SurfaceRuleBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiome;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiomeSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.registry.EndTags;

public class EndBiome extends BCLBiome implements SurfaceMaterialProvider {
	public static class DefaultSurfaceMaterialProvider implements SurfaceMaterialProvider{
		public static final BlockState END_STONE = Blocks.END_STONE.defaultBlockState();
		@Override
		public BlockState getTopMaterial() {
			return getUnderMaterial();
		}

		@Override
		public BlockState getAltTopMaterial() {
			return getTopMaterial();
		}

		@Override
		public BlockState getUnderMaterial() {
			return END_STONE;
		}

		@Override
		public boolean generateFloorRule(){
			return true;
		}

		@Override
		public SurfaceRuleBuilder surface() {
			SurfaceRuleBuilder builder = SurfaceRuleBuilder.start();
			
			if (generateFloorRule() && getTopMaterial()!=getUnderMaterial()){
				if (getTopMaterial()!=getAltTopMaterial()){
					builder.floor(getTopMaterial());
				} else {
					builder.chancedFloor(getTopMaterial(), getAltTopMaterial());
				}
			}
			return builder.filler(getUnderMaterial());
		}
	}

	public abstract static class Config {
		public static final SurfaceMaterialProvider DEFAULT_MATERIAL = new DefaultSurfaceMaterialProvider();

		protected static final SurfaceRules.RuleSource END_STONE = SurfaceRules.state(DefaultSurfaceMaterialProvider.END_STONE);
		protected static final SurfaceRules.RuleSource END_MOSS = SurfaceRules.state(EndBlocks.END_MOSS.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource ENDSTONE_DUST = SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource END_MYCELIUM = SurfaceRules.state(EndBlocks.END_MYCELIUM.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource FLAVOLITE =SurfaceRules.state(EndBlocks.FLAVOLITE.stone.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource SULPHURIC_ROCK =SurfaceRules.state(EndBlocks.SULPHURIC_ROCK.stone.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource BRIMSTONE =SurfaceRules.state(EndBlocks.BRIMSTONE.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource PALLIDIUM_FULL =SurfaceRules.state(EndBlocks.PALLIDIUM_FULL.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource PALLIDIUM_HEAVY =SurfaceRules.state(EndBlocks.PALLIDIUM_HEAVY.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource PALLIDIUM_THIN =SurfaceRules.state(EndBlocks.PALLIDIUM_THIN.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource PALLIDIUM_TINY =SurfaceRules.state(EndBlocks.PALLIDIUM_TINY.get().defaultBlockState());
		protected static final SurfaceRules.RuleSource UMBRALITH =SurfaceRules.state(EndBlocks.UMBRALITH.stone.get().defaultBlockState());

		public final ResourceLocation ID;

		protected Config(String name) {
			this.ID = BetterEndForge.makeID(name);
		}

		protected abstract void addCustomBuildData(BCLBiomeBuilder builder);

		public BCLBiomeBuilder.BiomeSupplier<EndBiome> getSupplier(){
			return EndBiome::new;
		}

		protected boolean hasCaves(){
			return true;
		}

		protected SurfaceMaterialProvider surfaceMaterial() {
			return DEFAULT_MATERIAL;
		}
	}

	public EndBiome(ResourceLocation biomeID, Biome biome, BCLBiomeSettings settings) {
		super(biomeID, biome, settings);
	}

	public static EndBiome create(Config biomeConfig){
		BCLBiomeBuilder builder = BCLBiomeBuilder
				.start(biomeConfig.ID)
				.category(Biome.BiomeCategory.THEEND)
				.music(SoundEvents.MUSIC_END)
				.waterColor(4159204)
				.waterFogColor(329011)
				.fogColor(0xA080A0)
				.skyColor(0)
				.mood(EndSounds.AMBIENT_DUST_WASTELANDS.get())
				.temperature(0.5f)
				.wetness(0.5f)
				.precipitation(Biome.Precipitation.NONE)
				.surface(biomeConfig.surfaceMaterial().surface().build());

		biomeConfig.addCustomBuildData(builder);
//		EndFeatures.addDefaultFeatures(builder, biomeConfig.hasCaves());


		EndBiome biome = builder.build(biomeConfig.getSupplier());
		biome.addCustomData("has_caves", biomeConfig.hasCaves());
		biome.setSurfaceMaterial(biomeConfig.surfaceMaterial());
		
		EndTags.addBiomeSurfaceToEndGroup(biome);
		return biome;
	}


	private SurfaceMaterialProvider surfMatProv = Config.DEFAULT_MATERIAL;
	private void setSurfaceMaterial(SurfaceMaterialProvider prov) {
		surfMatProv = prov;
	}

	@Override
	public BlockState getTopMaterial() {
		return surfMatProv.getTopMaterial();
	}

	@Override
	public BlockState getUnderMaterial() {
		return surfMatProv.getUnderMaterial();
	}

	@Override
	public BlockState getAltTopMaterial() {
		return surfMatProv.getAltTopMaterial();
	}

	@Override
	public boolean generateFloorRule() { return surfMatProv.generateFloorRule(); }

	@Override
	public SurfaceRuleBuilder surface() { return surfMatProv.surface(); }

	public static BlockState findTopMaterial(BCLBiome biome){
		return BiomeAPI.findTopMaterial(biome).orElse(EndBiome.Config.DEFAULT_MATERIAL.getTopMaterial());
	}

	public static BlockState findTopMaterial(Biome biome){
		return findTopMaterial(BiomeAPI.getBiome(biome));
	}

	public static BlockState findTopMaterial(WorldGenLevel world, BlockPos pos){
		return findTopMaterial(BiomeAPI.getBiome(world.getBiome(pos)));
	}

	public static BlockState findUnderMaterial(BCLBiome biome){
		return BiomeAPI.findUnderMaterial(biome).orElse(EndBiome.Config.DEFAULT_MATERIAL.getUnderMaterial());
	}

	public static BlockState findUnderMaterial(WorldGenLevel world, BlockPos pos){
		return findUnderMaterial(BiomeAPI.getBiome(world.getBiome(pos)));
	}
}
