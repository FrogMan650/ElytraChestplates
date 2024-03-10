package net.Lucas.elytrachestplates.datagen;

import net.Lucas.elytrachestplates.ElytraChestplates;
import net.Lucas.elytrachestplates.item.ModItems;
import net.Lucas.elytrachestplates.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ElytraChestplates.MOD_ID);
    }

    @Override
    protected void start() {
        add("template_from_end_city_loot", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build() },
                ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.get()));
    }
}
