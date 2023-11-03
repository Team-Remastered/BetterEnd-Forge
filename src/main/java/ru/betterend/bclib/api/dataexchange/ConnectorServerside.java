package ru.betterend.bclib.api.dataexchange;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.api.dataexchange.handler.DataExchange;

/**
 * This is an internal class that handles a Serverside Connection to a Client-Player
 */
public class ConnectorServerside extends Connector {
	private MinecraftServer server;
	ConnectorServerside(DataExchange api) {
		super(api);
		server = null;
	}
	
	@Override
	public boolean onClient() {
		return false;
	}
	
	public void onPlayInit(ServerGamePacketListenerImpl handler, MinecraftServer server){
		if (this.server!=null && this.server != server){
			BCLib.LOGGER.warning("Server changed!");
		}
		this.server = server;
		for(DataHandlerDescriptor desc : getDescriptors()){
			ServerPlayNetworking.registerReceiver(handler, desc.IDENTIFIER, (_server, _player, _handler, _buf, _responseSender) -> {
				receiveFromClient(desc, _server, _player, _handler, _buf, _responseSender);
			});
		}
	}

	public void onPlayReady(ServerGamePacketListenerImpl handler, PacketSender sender, MinecraftServer server){
		for(DataHandlerDescriptor desc : getDescriptors()){
			if (desc.sendOnJoin){
				BaseDataHandler h = desc.JOIN_INSTANCE.get();
				if (h.getOriginatesOnServer()) {
					h.sendToClient(server, handler.player);
				}
			}
		}
	}

	public void onPlayDisconnect(ServerGamePacketListenerImpl handler, MinecraftServer server){
		for(DataHandlerDescriptor desc : getDescriptors()){
			ServerPlayNetworking.unregisterReceiver(handler, desc.IDENTIFIER);
		}
	}
	
	void receiveFromClient(DataHandlerDescriptor desc, MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender){
		BaseDataHandler h = desc.INSTANCE.get();
		h.receiveFromClient(server, player, handler, buf, responseSender);
	}
	
	public void sendToClient(BaseDataHandler h){
		if (server==null){
			throw new RuntimeException("[internal error] Server not initialized yet!");
		}
		h.sendToClient(this.server);
	}
}
