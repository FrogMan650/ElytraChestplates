package net.Lucas.elytrachestplates.item;

import net.Lucas.elytrachestplates.ElytraChestplates;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElytraChestplates.MOD_ID);

    public static final RegistryObject<Item> DIAMOND_ELYTRA_CHESTPLATE = ITEMS.register("diamond_elytra_chestplate",
            () -> new DiamondElytraChestplate(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> NETHERITE_ELYTRA_CHESTPLATE = ITEMS.register("netherite_elytra_chestplate",
            () -> new NetheriteElytraChestplate(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final RegistryObject<Item> ELYTRA_UPGRADE_SMITHING_TEMPLATE = ITEMS.register(
            "elytra_upgrade_smithing_template", CustomSmithingTemplateItem::createElytraChestplateUpgradeTemplate);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
