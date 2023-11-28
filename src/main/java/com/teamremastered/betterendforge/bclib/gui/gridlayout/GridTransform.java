package com.teamremastered.betterendforge.bclib.gui.gridlayout;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GridTransform {
	public final int left;
	public final int top;
	public final int width;
	public final int height;
	
	GridTransform(int left, int top, int width, int height) {
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "{" + "left=" + left + ", top=" + top + ", width=" + width + ", height=" + height + '}';
	}
	
}
