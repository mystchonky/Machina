package com.mystchonky.machina.common.network.messages;

import com.mystchonky.machina.Machina;
import com.mystchonky.machina.common.attachment.Arsenal;
import com.mystchonky.machina.common.attachment.AttachmentManager;
import com.mystchonky.machina.common.network.Message;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

public record MessageUpdateArsenal(Arsenal arsenal) implements Message {

    public static final Type<MessageUpdateArsenal> TYPE = new Type<>(Machina.prefix("update_arsenal"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageUpdateArsenal> STREAM_CODEC = StreamCodec.composite(
            Arsenal.STREAM_CODEC,
            MessageUpdateArsenal::arsenal,
            MessageUpdateArsenal::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @Override
    public void onServerReceived(MinecraftServer minecraft, ServerPlayer player) {
        Arsenal.set(player, arsenal());
        AttachmentManager.syncArsenal(player);
    }
}
