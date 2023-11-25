package ru.betterend.world.generator;

import net.minecraft.util.Mth;
//FIXME: Review this class to add the config options since I just put default values
public class LayerOptions {
	public final float distance;
	public final float scale;
	public final float coverage;
	public final int center;
	public final int heightVariation;
	public final int minY;
	public final int maxY;
	public final long centerDist;
	public final boolean hasCentralIsland;
	
	public LayerOptions(String name, float distance, float scale, int center, int heightVariation, boolean hasCentral) {
		this.distance = distance;
		this.scale = scale;
		this.center = center;
		this.heightVariation = heightVariation;
		this.coverage = 0.5F;
		this.minY = this.center - this.heightVariation;
		this.maxY = this.center + this.heightVariation;
		this.centerDist = Mth.floor(1000 / this.distance);
		this.hasCentralIsland = hasCentral;
	}
	
	private float clampDistance(float value) {
		return Mth.clamp(value, 1, 8192);
	}
	
	private float clampScale(float value) {
		return Mth.clamp(value, 0.1F, 1024);
	}
	
	private float clampCoverage(float value) {
		return 0.9999F - Mth.clamp(value, 0, 1) * 2;
	}
	
	private int clampCenter(int value) {
		return Mth.clamp(value, 0, 255);
	}
	
	private int clampVariation(int value) {
		return Mth.clamp(value, 0, 255);
	}
}
