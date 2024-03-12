package net.Lucas.elytrachestplates.datagen;

import net.Lucas.elytrachestplates.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("SAS")
                .pattern("SBS")
                .pattern("SSS")
                .define('A', ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.get())
                .define('B', Blocks.PURPUR_BLOCK)
                .define('S', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pRecipeOutput);
        

        netheriteSmithing(pRecipeOutput, ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.get(), Items.DIAMOND_CHESTPLATE,
                Items.ELYTRA, ModItems.DIAMOND_ELYTRA_CHESTPLATE.get());

        netheriteSmithing(pRecipeOutput, ModItems.ELYTRA_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_CHESTPLATE,
                Items.ELYTRA, ModItems.NETHERITE_ELYTRA_CHESTPLATE.get());

        netheriteSmithing(pRecipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.DIAMOND_ELYTRA_CHESTPLATE.get(),
                Items.NETHERITE_INGOT, ModItems.NETHERITE_ELYTRA_CHESTPLATE.get());
    }

    protected static void netheriteSmithing(Consumer<FinishedRecipe> pRecipeOutput, Item modTemplate, Item itemToUpgrade, Item itemToUpgradeWith, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(modTemplate), Ingredient.of(itemToUpgrade), Ingredient.of(itemToUpgradeWith),
                RecipeCategory.MISC, pResultItem).unlocks("has_netherite_ingot", has(itemToUpgradeWith)).save(pRecipeOutput,
                getItemName(pResultItem) + "_smithing_" + getItemName(itemToUpgradeWith));
    }
}
