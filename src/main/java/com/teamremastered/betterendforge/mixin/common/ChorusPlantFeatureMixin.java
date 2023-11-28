package com.teamremastered.betterendforge.mixin.common;

import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChorusFlowerBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ChorusPlantFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

@Mixin(ChorusPlantFeature.class)
public class ChorusPlantFeatureMixin {
	@Inject(method = "place", at = @At("HEAD"), cancellable = true)
	private void be_place(FeaturePlaceContext<NoneFeatureConfiguration> featureConfig, CallbackInfoReturnable<Boolean> info) {
		final Random random = featureConfig.random();
		final BlockPos blockPos = featureConfig.origin();
		final WorldGenLevel structureWorldAccess = featureConfig.level();
		if (structureWorldAccess.isEmptyBlock(blockPos) && structureWorldAccess.getBlockState(blockPos.below()).is(EndBlocks.CHORUS_NYLIUM.get())) {
			ChorusFlowerBlock.generatePlant(structureWorldAccess, blockPos, random, MHelper.randRange(8, 16, random));
			BlockState bottom = structureWorldAccess.getBlockState(blockPos);
			if (bottom.is(Blocks.CHORUS_PLANT)) {
				BlocksHelper.setWithoutUpdate(
					structureWorldAccess,
					blockPos,
					bottom.setValue(PipeBlock.DOWN, true)
				);
			}
			info.setReturnValue(true);
		}
	}
}
