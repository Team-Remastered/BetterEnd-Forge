package com.teamremastered.betterendforge.bclib.sdf.primitive;

import net.minecraft.util.Mth;
import com.teamremastered.betterendforge.bclib.util.MHelper;

public class SDFCapsule extends SDFPrimitive {
	private float radius;
	private float height;
	
	public SDFCapsule setRadius(float radius) {
		this.radius = radius;
		return this;
	}
	
	public SDFCapsule setHeight(float height) {
		this.height = height;
		return this;
	}
	
	@Override
	public float getDistance(float x, float y, float z) {
		return MHelper.length(x, y - Mth.clamp(y, 0, height), z) - radius;
	}
}
