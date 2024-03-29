package com.mystchonky.machina.common.registrar;

import com.mystchonky.machina.Machina;
import com.mystchonky.machina.common.attachment.PlayerActiveArsenal;
import com.mystchonky.machina.common.attachment.PlayerUnlockedGears;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class AttachmentRegistrar {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Machina.MODID);

    public static final Supplier<AttachmentType<PlayerUnlockedGears>> PLAYER_UNLOCKED_GEARS = ATTACHMENTS.register("unlocked_gears",
            () -> AttachmentType.builder(PlayerUnlockedGears::create)
                    .serialize(PlayerUnlockedGears.CODEC)
                    .build());

    public static final Supplier<AttachmentType<PlayerActiveArsenal>> PLAYER_ACTIVE_ARSENAL = ATTACHMENTS.register("active_arsenal",
            () -> AttachmentType.builder(PlayerActiveArsenal::empty)
                    .serialize(PlayerActiveArsenal.CODEC)
                    .build());

    public static void register(IEventBus bus) {
        ATTACHMENTS.register(bus);
    }
}
