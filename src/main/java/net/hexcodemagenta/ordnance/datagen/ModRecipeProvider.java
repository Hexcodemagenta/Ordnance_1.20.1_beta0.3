package net.hexcodemagenta.ordnance.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hexcodemagenta.ordnance.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> WOLFRAMITE_SMELTABLES = List.of(ModItems.WOLFRAMITE_DUST);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, WOLFRAMITE_SMELTABLES, RecipeCategory.MISC, ModItems.WOLFRAMITE_INGOT,
                1.0f, 1000, "wolframite");
        offerBlasting(exporter, WOLFRAMITE_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT,
                1.0f, 1000, "wolframite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TINY_WOLFRAMITE_DUST, RecipeCategory.MISC,
                ModItems.WOLFRAMITE_DUST);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ANGEL_RODS, 1)
                .pattern(" T ")
                .pattern("NWN")
                .pattern("FWF")
                .input('W', ModItems.WOLFRAMITE_INGOT)
                .input('T', ModItems.TUNGSTEN_INGOT)
                .input('F', Items.FEATHER)
                .input('N', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(ModItems.WOLFRAMITE_INGOT), conditionsFromItem(ModItems.WOLFRAMITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ANGEL_RODS)));

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.TINY_WOLFRAMITE_DUST,
                Items.GRANITE);
    }
}
