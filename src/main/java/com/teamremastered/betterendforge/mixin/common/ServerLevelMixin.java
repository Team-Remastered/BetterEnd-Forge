package com.teamremastered.betterendforge.mixin.common;

import com.teamremastered.betterendforge.bclib.api.biomes.BiomeAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.storage.LevelStorageSource.LevelStorageAccess;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.WritableLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.interfaces.BETargetChecker;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.world.generator.GeneratorOptions;
import com.teamremastered.betterendforge.world.generator.TerrainGenerator;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin extends Level {
	//private static String be_lastWorld = null;
	
	protected ServerLevelMixin(WritableLevelData writableLevelData, ResourceKey<Level> resourceKey, Holder<DimensionType> dimensionType, Supplier<ProfilerFiller> supplier, boolean bl, boolean bl2, long l) {
		super(writableLevelData, resourceKey, dimensionType, supplier, bl, bl2, l);
	}
	
//	@Inject(method = "<init>*", at = @At("TAIL"))
//	private void be_onServerWorldInit(MinecraftServer server, Executor workerExecutor, LevelStorageSource.LevelStorageAccess session, ServerLevelData properties, ResourceKey<Level> registryKey, DimensionType dimensionType, ChunkProgressListener worldGenerationProgressListener, ChunkGenerator chunkGenerator, boolean debugWorld, long l, List<CustomSpawner> list, boolean bl, CallbackInfo info) {
//		if (be_lastWorld != null && be_lastWorld.equals(session.getLevelId())) {
//			return;
//		}
//
//		be_lastWorld = session.getLevelId();
//		//ServerLevel world = ServerLevel.class.cast(this);
//		//EndBiomes.onWorldLoad(world.getSeed(), world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY));
//	}
	
	@Inject(method = "<init>*", at = @At("TAIL"))
	private void be_onServerWorldInit(MinecraftServer minecraftServer, Executor executor, LevelStorageAccess levelStorageAccess, ServerLevelData serverLevelData, ResourceKey resourceKey, Holder holder, ChunkProgressListener chunkProgressListener, ChunkGenerator chunkGenerator, boolean bl, long seed, List list, boolean bl2, CallbackInfo ci) {
//		ServerLevel level = ServerLevel.class.cast(this);
//		if (level.dimension() == Level.END) {
//			if (chunkGenerator instanceof NoiseBasedChunkGenerator) {
//				Holder<NoiseGeneratorSettings> sHolder = NoiseBasedChunkGeneratorAccessor.class.cast(chunkGenerator).be_getSettings();
//				BETargetChecker.class.cast(sHolder.value()).be_setTarget(true);
//
//			}
//			TerrainGenerator.initNoise(seed, chunkGenerator.getBiomeSource(), chunkGenerator.climateSampler());
//		}
	}
	
	@Inject(method = "getSharedSpawnPos", at = @At("HEAD"), cancellable = true)
	private void be_getSharedSpawnPos(CallbackInfoReturnable<BlockPos> info) {
		if (GeneratorOptions.changeSpawn()) {
			if (ServerLevel.class.cast(this).dimension() == Level.END) {
				BlockPos pos = GeneratorOptions.getSpawn();
				info.setReturnValue(pos);
			}
		}
	}
	
	@Inject(method = "makeObsidianPlatform", at = @At("HEAD"), cancellable = true)
	private static void be_createObsidianPlatform(ServerLevel serverLevel, CallbackInfo info) {
		if (!GeneratorOptions.generateObsidianPlatform()) {
			info.cancel();
		}
		else if (GeneratorOptions.changeSpawn()) {
			BlockPos blockPos = GeneratorOptions.getSpawn();
			int i = blockPos.getX();
			int j = blockPos.getY() - 2;
			int k = blockPos.getZ();
			BlockPos.betweenClosed(i - 2, j + 1, k - 2, i + 2, j + 3, k + 2).forEach((blockPosx) -> {
				serverLevel.setBlockAndUpdate(blockPosx, Blocks.AIR.defaultBlockState());
			});
			BlockPos.betweenClosed(i - 2, j, k - 2, i + 2, j, k + 2).forEach((blockPosx) -> {
				serverLevel.setBlockAndUpdate(blockPosx, Blocks.OBSIDIAN.defaultBlockState());
			});
			info.cancel();
		}
	}
	
	@ModifyArg(method = "tickChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z"))
	private BlockState be_modifyTickState(BlockPos pos, BlockState state) {
		if (state.is(Blocks.ICE)) {
			ResourceLocation biome = BiomeAPI.getBiomeID(getBiome(pos));
			if (biome.getNamespace().equals(BetterEndForge.MOD_ID)) {
				state = EndBlocks.EMERALD_ICE.get().defaultBlockState();
			}
		}
		return state;
	}
}