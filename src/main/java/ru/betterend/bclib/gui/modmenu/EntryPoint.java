package ru.betterend.bclib.gui.modmenu;

import ru.betterend.bclib.integration.modmenu.ModMenuIntegration;

@Deprecated()
public class EntryPoint extends ModMenuIntegration {
	public static final Object entrypointObject = createEntrypoint(new EntryPoint());
	
	public EntryPoint() {
		super(MainScreen::new);
	}
}
