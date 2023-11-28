package com.teamremastered.betterendforge.bclib.gui.gridlayout;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.teamremastered.betterendforge.bclib.gui.gridlayout.GridLayout.GridValueType;


@OnlyIn(Dist.CLIENT)
public abstract class GridCustomRenderCell extends GridCell{
	protected GridCustomRenderCell(double width, GridValueType widthType, double height) {
		super(width, height, widthType, null, null);
		this.customRender = this::onRender;
	}
	
	public abstract void onRender(PoseStack poseStack, GridTransform transform, Object context);
}
