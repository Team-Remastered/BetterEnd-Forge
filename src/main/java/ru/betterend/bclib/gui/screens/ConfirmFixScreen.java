package ru.betterend.bclib.gui.screens;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.gui.gridlayout.GridCheckboxCell;
import ru.betterend.bclib.gui.gridlayout.GridLayout.Alignment;
import ru.betterend.bclib.gui.gridlayout.GridRow;

@OnlyIn(Dist.CLIENT)
public class ConfirmFixScreen extends BCLibScreen {
	protected final Listener listener;
	private final Component description;
	protected int id;
	
	public ConfirmFixScreen(@Nullable Screen parent, Listener listener) {
		super(parent, new TranslatableComponent("bclib.datafixer.backupWarning.title"));
		this.listener = listener;
		
		this.description = new TranslatableComponent("bclib.datafixer.backupWarning.message");
	}
	
	protected void initLayout() {
		final int BUTTON_HEIGHT = 20;
		
		grid.addRow().addMessage(this.description, this.font, Alignment.CENTER);
		grid.addSpacerRow();
		
		GridRow row = grid.addRow();
		GridCheckboxCell backup = row.addCheckbox(new TranslatableComponent("bclib.datafixer.backupWarning.backup"), true, BUTTON_HEIGHT, this.font);
		
		grid.addSpacerRow(10);
		
		row = grid.addRow();
		GridCheckboxCell fix = row.addCheckbox(new TranslatableComponent("bclib.datafixer.backupWarning.fix"), true, BUTTON_HEIGHT, this.font);
		
		grid.addSpacerRow(20);
		
		row = grid.addRow();
		row.addFiller();
		row.addButton(CommonComponents.GUI_CANCEL, BUTTON_HEIGHT, this.font, (button) -> {
			onClose();
		});
		row.addSpacer();
		row.addButton(CommonComponents.GUI_PROCEED, BUTTON_HEIGHT, this.font, (button) -> {
			this.listener.proceed(backup.isChecked(), fix.isChecked());
		});
		row.addFiller();
	}
	
	public boolean shouldCloseOnEsc() {
		return true;
	}
	
	@OnlyIn(Dist.CLIENT)
	public interface Listener {
		void proceed(boolean createBackup, boolean applyPatches);
	}
}
