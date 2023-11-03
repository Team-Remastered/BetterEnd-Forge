package ru.betterend.bclib.sdf.operator;

import ru.betterend.bclib.util.MHelper;

public class SDFUnion extends SDFBinary {
	@Override
	public float getDistance(float x, float y, float z) {
		float a = this.sourceA.getDistance(x, y, z);
		float b = this.sourceB.getDistance(x, y, z);
		this.selectValue(a, b);
		return MHelper.min(a, b);
	}
}
