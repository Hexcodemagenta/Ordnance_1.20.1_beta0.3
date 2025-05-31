package net.hexcodemagenta.ordnance.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hexcodemagenta.ordnance.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> WOLFRAMITE_SMELTABLES = List.of(ModItems.WOLFRAMITE_DUST);
    private static final List<ItemConvertible> STEEL_SMELTABLES = List.of(ModItems.STEEL_DUST);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, WOLFRAMITE_SMELTABLES, RecipeCategory.MISC, ModItems.WOLFRAMITE_INGOT,
                1.0f, 1000, "wolframite");
        offerBlasting(exporter, WOLFRAMITE_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT,
                1.0f, 1000, "wolframite");
        offerSmelting(exporter, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL_INGOT,
                1.0f, 200, "wolframite");
        offerBlasting(exporter, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL_INGOT,
                1.0f, 100, "wolframite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TINY_WOLFRAMITE_DUST, RecipeCategory.MISC,
                ModItems.WOLFRAMITE_DUST);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ANGEL_RODS, 1)
                .pattern(" T ")
                .pattern("NWN")
                .pattern("FWF")
                .input('W', ModItems.WOLFRAMITE_INGOT)
                .input('T', ModItems.TUNGSTENSTEEL_INGOT)
                .input('F', Items.FEATHER)
                .input('N', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(ModItems.WOLFRAMITE_INGOT), conditionsFromItem(ModItems.WOLFRAMITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ANGEL_RODS)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_DUST, 2)
                .input(ModItems.IRON_DUST)
                .input(ModItems.IRON_DUST)
                .input(ModItems.IRON_DUST)
                .input(ModItems.COAL_DUST)
                .criterion(hasItem(ModItems.IRON_DUST), conditionsFromItem(ModItems.IRON_DUST))
                .criterion(hasItem(ModItems.COAL_DUST), conditionsFromItem(ModItems.COAL_DUST))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_DUST)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TUNGSTENSTEEL_DUST, 3)
                .input(ModItems.STEEL_DUST)
                .input(ModItems.STEEL_DUST)
                .input(ModItems.TUNGSTEN_DUST)
                .input(ModItems.TUNGSTEN_DUST)
                .input(ModItems.COAL_DUST)
                .criterion(hasItem(ModItems.STEEL_DUST), conditionsFromItem(ModItems.STEEL_DUST))
                .criterion(hasItem(ModItems.TUNGSTEN_DUST), conditionsFromItem(ModItems.TUNGSTEN_DUST))
                .criterion(hasItem(ModItems.COAL_DUST), conditionsFromItem(ModItems.COAL_DUST))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TUNGSTENSTEEL_DUST)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TUNGSTENSTEEL_DUST, 3)
                .input(Items.MUSIC_DISC_RELIC)
                .input(ModItems.STEEL_DUST)
                .criterion(hasItem(ModItems.STEEL_DUST), conditionsFromItem(ModItems.STEEL_DUST))
                .criterion(hasItem(Items.MUSIC_DISC_RELIC), conditionsFromItem(Items.MUSIC_DISC_RELIC))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MUSIC_DISC_BY_DUSK)));

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.TINY_WOLFRAMITE_DUST,
                Items.GRANITE);

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.WOLFRAMITE_DUST,
                ModItems.WOLFRAMITE_INGOT);

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.IRON_DUST,
                Items.IRON_INGOT);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.COAL_DUST,
                Items.COAL);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.STEEL_DUST,
                ModItems.STEEL_INGOT);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.TUNGSTEN_DUST,
                ModItems.TUNGSTEN_INGOT);


    }
}
