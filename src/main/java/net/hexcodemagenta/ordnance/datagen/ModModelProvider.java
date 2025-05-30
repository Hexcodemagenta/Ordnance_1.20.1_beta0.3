package net.hexcodemagenta.ordnance.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hexcodemagenta.ordnance.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TINY_WOLFRAMITE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOLFRAMITE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOLFRAMITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNGSTEN_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ANGEL_RODS, Models.GENERATED);

        itemModelGenerator.register(ModItems.MUSIC_DISC_BY_DUSK, Models.GENERATED);

    }
}
