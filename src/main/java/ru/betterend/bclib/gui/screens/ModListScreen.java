package ru.betterend.bclib.gui.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.metadata.ModEnvironment;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import ru.betterend.bclib.api.dataexchange.handler.autosync.HelloClient;
import ru.betterend.bclib.gui.gridlayout.GridColumn;
import ru.betterend.bclib.gui.gridlayout.GridLayout;
import ru.betterend.bclib.gui.gridlayout.GridRow;
import ru.betterend.bclib.gui.gridlayout.GridScreen;
import ru.betterend.bclib.util.ModUtil;
import ru.betterend.bclib.util.PathUtil;
import ru.betterend.bclib.util.Triple;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Environment(EnvType.CLIENT)
public class ModListScreen extends BCLibScreen {

	private final List<ModUtil.ModInfo> mods;
	private final HelloClient.IServerModMap serverInfo;
	private final Component description;
	private final Component buttonTitle;

	private static List<ModUtil.ModInfo> extractModList(Map<String, ModUtil.ModInfo> mods){
		List<ModUtil.ModInfo> list = new LinkedList<ModUtil.ModInfo>();
		ModUtil.getMods().forEach((id, info) -> list.add(info));
		return list;
	}
	
	public ModListScreen(Screen parent, Component title, Component description, Map<String, ModUtil.ModInfo> mods, HelloClient.IServerModMap serverInfo) {
		this(parent, title, description, CommonComponents.GUI_BACK, mods, serverInfo);
	}
	
	public ModListScreen(Screen parent, Component title, Component description, List<ModUtil.ModInfo> mods, HelloClient.IServerModMap serverInfo) {
		this(parent, title, description, CommonComponents.GUI_BACK, mods, serverInfo);
	}
	
	public ModListScreen(Screen parent, Component title, Component description, Component button, Map<String, ModUtil.ModInfo> mods, HelloClient.IServerModMap serverInfo) {
	   this(parent, title, description, button, extractModList(mods), serverInfo);
	}

	public ModListScreen(Screen parent, Component title, Component description, Component button, List<ModUtil.ModInfo> mods, HelloClient.IServerModMap serverInfo) {
		super(parent, title, 10, true);
		this.mods = mods;
		this.serverInfo = serverInfo;
		this.description = description;
		this.buttonTitle = button;
	}

	public static List<String> localMissing(HelloClient.IServerModMap serverInfo){
		return serverInfo.keySet()
				.stream()
				.filter(modid -> !ModUtil.getMods().keySet().stream().filter(mod -> mod.equals(modid)).findFirst().isPresent()).collect(Collectors.toList());
	}

	public static List<String> serverMissing(HelloClient.IServerModMap serverInfo){
		return ModUtil.getMods().entrySet()
				.stream()
				.filter(entry -> entry.getValue().metadata.getEnvironment() != ModEnvironment.CLIENT)
				.map(entry -> entry.getKey())
				.filter(modid -> !serverInfo.keySet().stream().filter(mod -> mod.equals(modid)).findFirst().isPresent()).collect(Collectors.toList());
	}


	public static void addModDesc(GridColumn grid, List<ModUtil.ModInfo> mods, HelloClient.IServerModMap serverInfo, GridScreen parent) {
		final int STATE_OK = 6;
		final int STATE_SERVER_MISSING_CLIENT_MOD = 5;
		final int STATE_MISSING_NOT_OFFERED = 4;
		final int STATE_VERSION_CLIENT_ONLY = 7;
		final int STATE_VERSION_NOT_OFFERED = 3;
		final int STATE_VERSION = 2;
		final int STATE_SERVER_MISSING = 1;
		final int STATE_MISSING = 0;
		

		List<Triple<String, Integer, String>> items = new LinkedList<>();
		if (serverInfo!=null) {
			serverInfo.keySet()
					.stream()
					.filter(modid -> !mods.stream().filter(mod -> mod.metadata.getId().equals(modid)).findFirst().isPresent())
					.forEach(modid -> {
						HelloClient.OfferedModInfo nfo = serverInfo.get(modid);
						String stateString = nfo.version();
						if (nfo.size()>0) {
							stateString = "Version: " + stateString + ", Size: " + PathUtil.humanReadableFileSize(nfo.size());
						}
						if (nfo.canDownload()) {
							stateString += ", offered by server";
						}

						items.add(new Triple<>(modid, nfo.canDownload()?STATE_MISSING:STATE_MISSING_NOT_OFFERED, stateString));
					});
		}

		mods.forEach(mod -> {
			String serverVersion = null;
			int serverSize = 0;
			int state = STATE_OK;
			if (serverInfo != null) {
				final String modID = mod.metadata.getId();


				HelloClient.OfferedModInfo data = serverInfo.get(modID);
				if (data!=null) {
					final String modVer = data.version();
					final int size = data.size();
					if (!modVer.equals(mod.getVersion())) {
						if (mod.metadata.getEnvironment() == ModEnvironment.CLIENT)
							state = STATE_VERSION_CLIENT_ONLY;
						else
							state = data.canDownload()?STATE_VERSION:STATE_VERSION_NOT_OFFERED;
						serverVersion = modVer;
						serverSize = size;
					}
				} else if (mod.metadata.getEnvironment() == ModEnvironment.CLIENT){
					state = STATE_SERVER_MISSING_CLIENT_MOD;
				} else {
					state = STATE_SERVER_MISSING;
				}
			}

			String stateString = mod.metadata.getVersion().toString();
			if (serverVersion!=null) {
				stateString = "Client: " + stateString;
				stateString += ", Server: " + serverVersion;
				if (serverSize>0) {
					stateString += ", Size: " + PathUtil.humanReadableFileSize(serverSize);
				}
			}
			if (mod.metadata.getEnvironment() == ModEnvironment.CLIENT) {
				stateString+= ", client-only";
			} else if (mod.metadata.getEnvironment() == ModEnvironment.SERVER) {
				stateString+= ", server-only";
			}
			items.add(new Triple<>(mod.metadata.getName(), state, stateString));
		});

		items.stream()
				.sorted(Comparator.comparing(a -> a.second + a.first.toLowerCase(Locale.ROOT)))
				.forEach(t -> {
					final String name = t.first;
					final int state = t.second;
					final String stateString = t.third;

					int color = GridLayout.COLOR_RED;
					final String typeText;
					if (state==STATE_VERSION || state==STATE_VERSION_NOT_OFFERED || state==STATE_VERSION_CLIENT_ONLY) {
						typeText = "[VERSION]";
						if (state == STATE_VERSION_NOT_OFFERED) {
							color = GridLayout.COLOR_YELLOW;
						} else if (state == STATE_VERSION_CLIENT_ONLY) {
							color = GridLayout.COLOR_DARK_GREEN;
						}
					} else if (state==STATE_MISSING || state==STATE_MISSING_NOT_OFFERED) {
						typeText = "[MISSING]";
						if (state == STATE_MISSING_NOT_OFFERED) {
							color = GridLayout.COLOR_YELLOW;
						}
					} else if (state==STATE_SERVER_MISSING || state == STATE_SERVER_MISSING_CLIENT_MOD) {
						if (state == STATE_SERVER_MISSING_CLIENT_MOD) {
							color = GridLayout.COLOR_CYAN;
							typeText = "[OK]";
						} else {
							typeText = "[NOT ON SERVER]";
						}
					} else {
						color = GridLayout.COLOR_DARK_GREEN;
						typeText = "[OK]";
					}
					TextComponent dash = new TextComponent("-");
					TextComponent typeTextComponent = new TextComponent(typeText);
					GridRow row = grid.addRow();

					row.addString(dash, parent);

					row.addSpacer(4);
					row.addString(new TextComponent(name), parent);

					row.addSpacer(4);
					row.addString(typeTextComponent, color, parent);

					if (!stateString.isEmpty()) {
						row = grid.addRow();
						row.addSpacer(4 + parent.getWidth(dash));
						row.addString(new TextComponent(stateString), GridLayout.COLOR_GRAY, parent);
					}

					grid.addSpacerRow();
				});
	}

	@Override
	protected void initLayout() {
		if (description != null) {
			grid.addSpacerRow();
			grid.addRow().addMessage(description, font, GridLayout.Alignment.CENTER);
			grid.addSpacerRow(8);
		}

		GridRow row = grid.addRow();
		row.addSpacer(10);
		GridColumn col = row.addColumn(200, GridLayout.GridValueType.CONSTANT);
		addModDesc(col, mods, serverInfo, this);

		grid.addSpacerRow(8);
		row = grid.addRow();
		row.addFiller();
		row.addButton(buttonTitle, 20, font, (n)-> {
			onClose();
		});
		row.addFiller();
	}

}
