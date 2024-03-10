package net.Lucas.elytrachestplates.item;

import net.Lucas.elytrachestplates.ElytraChestplates;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElytraChestplates.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ELYTRA_TAB = CREATIVE_MODE_TABS.register("elytra_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.ELYTRA))
                    .title(Component.translatable("creativetab.elytrachestplates.elytra_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.ELYTRA);
                        pOutput.accept(ModItems.DIAMOND_ELYTRA_CHESTPLATE.get());
                        pOutput.accept(ModItems.NETHERITE_ELYTRA_CHESTPLATE.get());
                        pOutput.accept(ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
