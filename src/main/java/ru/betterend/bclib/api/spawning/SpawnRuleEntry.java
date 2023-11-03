package ru.betterend.bclib.api.spawning;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;
import ru.betterend.bclib.interfaces.SpawnRule;

import java.util.Random;

public class SpawnRuleEntry<M extends Mob> implements Comparable<SpawnRuleEntry> {
	private final SpawnRule rule;
	private final byte priority;
	
	public SpawnRuleEntry(int priority, SpawnRule rule) {
		this.priority = (byte) priority;
		this.rule = rule;
	}
	
	protected boolean canSpawn(EntityType<M> type, LevelAccessor world, MobSpawnType spawnReason, BlockPos pos, Random random) {
		return rule.canSpawn(type, world, spawnReason, pos, random);
	}
	
	@Override
	public int compareTo(@NotNull SpawnRuleEntry entry) {
		return Integer.compare(priority, entry.priority);
	}
}
