package net.Lucas.elytrachestplates.item;

import net.Lucas.elytrachestplates.ElytraChestplates;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CustomSmithingTemplateItem extends SmithingTemplateItem {
    public CustomSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpdradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditonalSlotEmptyIcons) {
        super(pAppliesTo, pIngredients, pUpdradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditonalSlotEmptyIcons);
    }
    private static final String DESCRIPTION_ID = Util.makeDescriptionId("item",
            new ResourceLocation("elytrachestplates:elytra_smithing_template"));
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component ELYTRA_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item",
            new ResourceLocation("elytrachestplates:smithing_template.elytra_upgrade"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ELYTRA_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item",
            new ResourceLocation("elytra"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ELYTRA_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade",
            new ResourceLocation("elytrachestplates:elytra_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component ELYTRA_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item",
            new ResourceLocation("elytrachestplates:smithing_template.elytra_upgrade.base_slot_description")));
    private static final Component ELYTRA_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item",
            new ResourceLocation("elytrachestplates:smithing_template.elytra_upgrade.additions_slot_description")));

    private static final ResourceLocation EMPTY_SLOT_ELYTRA = new ResourceLocation(ElytraChestplates.MOD_ID, "item/empty_elytra");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");

    private static List<ResourceLocation> createElytraChestplateUpgradeIconList() { return List.of(EMPTY_SLOT_CHESTPLATE); }
    private static List<ResourceLocation> createElytraChestplateUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ELYTRA);
    }
    public static CustomSmithingTemplateItem createElytraChestplateUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                ELYTRA_UPGRADE_APPLIES_TO, ELYTRA_UPGRADE_INGREDIENTS,
                ELYTRA_UPGRADE, ELYTRA_UPGRADE_BASE_SLOT_DESCRIPTION,
                ELYTRA_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createElytraChestplateUpgradeIconList(), createElytraChestplateUpgradeMaterialList());
    }
    @Override
    public @NotNull String getDescriptionId() {
        return DESCRIPTION_ID;
    }

}
