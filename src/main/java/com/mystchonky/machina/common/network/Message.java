package com.mystchonky.machina.common.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public interface Message extends CustomPacketPayload {
    void encode(FriendlyByteBuf buf);

    void decode(FriendlyByteBuf buf);

    default void onClientReceived(Minecraft minecraft, Player player) {
    }

    default void onServerReceived(MinecraftServer minecraftServer, ServerPlayer player) {
    }

    @Override
    default void write(FriendlyByteBuf buf) {
        this.encode(buf);
    }
}