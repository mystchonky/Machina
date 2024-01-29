package com.mystchonky.machina.common.registrar;

import com.mystchonky.machina.Machina;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class MachinaRegistrar {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Machina.MODID);
    public static final Holder<CreativeModeTab> MACHINA_TAB = CREATIVE_TABS.register("machina", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.RECOVERY_COMPASS))
                    .displayItems((par, output) -> buildTabContents(output))
                    .title(Component.literal("Machina"))
                    .build()
    );

    public static void register(IEventBus bus) {
        ItemRegistrar.register(bus);
        BlockRegistrar.register(bus);
        BlockEntityRegistrar.register(bus);
        CREATIVE_TABS.register(bus);
    }

    private static void buildTabContents(CreativeModeTab.Output output) {
        Consumer<DeferredRegister<? extends ItemLike>> registryHandler = registry -> registry.getEntries().forEach(entry -> output.accept(entry.get()));

        registryHandler.accept(ItemRegistrar.ITEMS);
        registryHandler.accept(BlockRegistrar.BLOCKS);

    }
}
