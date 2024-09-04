package com.daredftw.bitermod.item;

import com.daredftw.bitermod.BiterMod;
import com.daredftw.bitermod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BiterMod.MODID);

    public static final RegistryObject<CreativeModeTab> BITERMOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("bitermod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LIVING_EGG.get()))
                    .title(Component.translatable("creativetab.bitermod.bitermod_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.LIVING_EGG.get());
                        output.accept(ModItems.CHISEL.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> BITERMOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("bitermod_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.POLLUTION_EMITTER.get()))
                    .withTabsBefore(BITERMOD_ITEMS_TAB.getId()) // Defines order of tabs
                    .title(Component.translatable("creativetab.bitermod.bitermod_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.POLLUTION_EMITTER.get());
                        output.accept(ModBlocks.LIVING_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_LIVING_ORE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
