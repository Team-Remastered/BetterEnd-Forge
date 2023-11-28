package com.teamremastered.betterendforge.bclib.gui.screens;

import com.teamremastered.betterendforge.bclib.gui.gridlayout.GridLayout;
import com.teamremastered.betterendforge.bclib.gui.gridlayout.GridRow;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

@OnlyIn(Dist.CLIENT)
public class WarnBCLibVersionMismatch extends BCLibScreen {
	private final Component description;
	private final Listener listener;
	public WarnBCLibVersionMismatch(Listener listener) {
		super(new TranslatableComponent("title.bclib.bclibmissmatch"));
		
		this.description = new TranslatableComponent("message.bclib.bclibmissmatch");
		this.listener = listener;
	}
	
	protected void initLayout() {
		final int BUTTON_HEIGHT = 20;
		
		grid.addRow().addMessage(this.description, this.font, GridLayout.Alignment.CENTER);
		grid.addSpacerRow(20);
		GridRow row = grid.addRow();
		row.addFiller();
		row.addButton(CommonComponents.GUI_NO, BUTTON_HEIGHT, this.font, (button) -> {
			listener.proceed(false);
		});
		row.addSpacer();
		row.addButton(CommonComponents.GUI_YES, BUTTON_HEIGHT, this.font, (button) -> {
			listener.proceed(true);
		});
		row.addFiller();
	}
	
	public boolean shouldCloseOnEsc() {
		return false;
	}
	
	@OnlyIn(Dist.CLIENT)
	public interface Listener {
		void proceed(boolean download);
	}
}
