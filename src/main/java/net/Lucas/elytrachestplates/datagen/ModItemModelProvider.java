package net.Lucas.elytrachestplates.datagen;

import net.Lucas.elytrachestplates.ElytraChestplates;
import net.Lucas.elytrachestplates.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElytraChestplates.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElytraChestplates.MOD_ID, "item/" +
                        ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.getId().getPath()));
    }
}
