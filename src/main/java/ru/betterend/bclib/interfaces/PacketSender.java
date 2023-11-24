package ru.betterend.bclib.interfaces;

import java.util.Objects;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.jetbrains.annotations.Nullable;

/**
 * Represents something that supports sending packets to channels.
 */

/** Copied from FabricAPI **/
public interface PacketSender {
    /**
     * Makes a packet for a channel.
     *
     * @param channelName the id of the channel
     * @param buf     the content of the packet
     */
    Packet<?> createPacket(ResourceLocation channelName, FriendlyByteBuf buf);

    /**
     * Sends a packet.
     *
     * @param packet the packet
     */
    void sendPacket(Packet<?> packet);

    /**
     * Sends a packet.
     *
     * @param packet the packet
     * @param callback an optional callback to execute after the packet is sent, may be {@code null}. The callback may also accept a {@link ChannelFutureListener}.
     */
    void sendPacket(Packet<?> packet, @Nullable GenericFutureListener<? extends Future<? super Void>> callback);

    /**
     * Sends a packet to a channel.
     *
     * @param channel the id of the channel
     * @param buf the content of the packet
     */
    default void sendPacket(ResourceLocation channel, FriendlyByteBuf buf) {
        Objects.requireNonNull(channel, "Channel cannot be null");
        Objects.requireNonNull(buf, "Payload cannot be null");

        this.sendPacket(this.createPacket(channel, buf));
    }

    /**
     * Sends a packet to a channel.
     *
     * @param channel  the id of the channel
     * @param buf the content of the packet
     * @param callback an optional callback to execute after the packet is sent, may be {@code null}
     */
    // the generic future listener can accept ChannelFutureListener
    default void sendPacket(ResourceLocation channel, FriendlyByteBuf buf, @Nullable GenericFutureListener<? extends Future<? super Void>> callback) {
        Objects.requireNonNull(channel, "Channel cannot be null");
        Objects.requireNonNull(buf, "Payload cannot be null");

        this.sendPacket(this.createPacket(channel, buf), callback);
    }
}
