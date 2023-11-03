package ru.betterend.bclib.api.dataexchange.handler.autosync;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.ProgressListener;
import ru.betterend.bclib.gui.screens.ProgressScreen;

@OnlyIn(Dist.CLIENT)
public class ChunkerProgress {
	private static ProgressScreen progressScreen;
	
	@OnlyIn(Dist.CLIENT)
	public static void setProgressScreen(ProgressScreen scr){
		progressScreen = scr;
	}
	
	@OnlyIn(Dist.CLIENT)
	public static ProgressScreen getProgressScreen(){
		return progressScreen;
	}
	
	@OnlyIn(Dist.CLIENT)
	public static ProgressListener getProgressListener(){
		return progressScreen;
	}
}
