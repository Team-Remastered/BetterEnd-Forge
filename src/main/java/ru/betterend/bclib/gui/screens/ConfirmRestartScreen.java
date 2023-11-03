package ru.betterend.bclib.gui.screens;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import ru.betterend.bclib.gui.gridlayout.GridLayout.Alignment;
import ru.betterend.bclib.gui.gridlayout.GridRow;


@OnlyIn(Dist.CLIENT)
public class ConfirmRestartScreen extends BCLibScreen {
	private final Component description;
	private final Listener listener;

	public ConfirmRestartScreen(Listener listener) {
		this(listener, null);
	}

	public ConfirmRestartScreen(Listener listener, Component message) {
		super(new TranslatableComponent("title.bclib.confirmrestart"));

		this.description = message==null?new TranslatableComponent("message.bclib.confirmrestart"):message;
		this.listener = listener;
	}

	protected void initLayout() {
		final int BUTTON_HEIGHT = 20;
	
		grid.addRow().addMessage(this.description, this.font, Alignment.CENTER);
		
		grid.addSpacerRow();
		
		GridRow row = grid.addRow();
		row.addFiller();
		row.addButton(CommonComponents.GUI_PROCEED, BUTTON_HEIGHT, font, (button) -> {
			listener.proceed();
		});
		row.addFiller();
	}

	public boolean shouldCloseOnEsc() {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public interface Listener {
		void proceed();
	}
}
