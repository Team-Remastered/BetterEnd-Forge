package ru.betterend.bclib.sdf.operator;

import ru.betterend.bclib.util.MHelper;

public class SDFCopyRotate extends SDFUnary {
	int count = 1;
	
	public SDFCopyRotate setCount(int count) {
		this.count = count;
		return this;
	}
	
	@Override
	public float getDistance(float x, float y, float z) {
		float px = (float) Math.atan2(x, z);
		float pz = MHelper.length(x, z);
		return this.source.getDistance(px, y, pz);
	}
}
