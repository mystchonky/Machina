package com.mystchonky.machina.common.registrar;

import net.neoforged.bus.api.IEventBus;

public class BlockEntityRegistrar {
//    private static final DeferredRegister<BlockEntityType<?>> BlOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Machina.MODID);
//    public static final Supplier<BlockEntityType<NexusBlockEntity>> ENERGY_NEXUS_BLOCK_ENTITY =
//            BlOCK_ENTITIES.register("nexus_block_entity", () ->
//                    BlockEntityType.Builder.of(
//                            NexusBlockEntity::new,
//                            BlockRegistrar.ENERGY_NEXUS.block().get()
//                    ).build(null)
//            );

    public static void register(IEventBus bus) {
//        BlOCK_ENTITIES.register(bus);
    }
}
