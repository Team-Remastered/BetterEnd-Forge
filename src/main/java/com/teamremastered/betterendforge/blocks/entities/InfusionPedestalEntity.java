package com.teamremastered.betterendforge.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlockEntities;
import com.teamremastered.betterendforge.rituals.InfusionRitual;

public class InfusionPedestalEntity extends PedestalBlockEntity {
	
	private InfusionRitual linkedRitual;
	
	public InfusionPedestalEntity(BlockPos blockPos, BlockState blockState) {
		super(EndBlockEntities.INFUSION_PEDESTAL.get(), blockPos, blockState);
	}
	
	@Override
	public void setLevel(Level world) {
		super.setLevel(world);
		if (hasRitual()) {
			linkedRitual.setLocation(world, this.getBlockPos());
		}
		else {
			linkRitual(new InfusionRitual(this, world, this.getBlockPos()));
		}
	}
	
	public void linkRitual(InfusionRitual ritual) {
		linkedRitual = ritual;
	}
	
	public InfusionRitual getRitual() {
		return linkedRitual;
	}
	
	public boolean hasRitual() {
		return linkedRitual != null;
	}
	
	@Override
	public void saveAdditional(CompoundTag tag) {
		if (hasRitual()) {
			tag.put("ritual", linkedRitual.toTag(new CompoundTag()));
		}
		super.saveAdditional(tag);
	}
	
	@Override
	protected void fromTag(CompoundTag tag) {
		super.fromTag(tag);
		if (tag.contains("ritual")) {
			linkedRitual = new InfusionRitual(this, level, worldPosition);
			linkedRitual.fromTag(tag.getCompound("ritual"));
		}
	}
	
	public static <T extends BlockEntity> void tickEnity(Level level, BlockPos blockPos, BlockState blockState, T uncastedEntity) {
		if (uncastedEntity instanceof InfusionPedestalEntity) {
			InfusionPedestalEntity blockEntity = (InfusionPedestalEntity) uncastedEntity;
			if (blockEntity.hasRitual()) {
				blockEntity.linkedRitual.tick();
			}
			//PedestalBlockEntity.tick(level, blockPos, blockState, blockEntity);
		}
	}
}
