package net.hexcodemagenta.ordnance.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hexcodemagenta.ordnance.Ordnance;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.hexcodemagenta.ordnance.Ordnance.MOD_ID;

public class ModItemGroups {
    public static final ItemGroup ORDNANCE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Ordnance.MOD_ID, "wolframite_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ordnance"))
                    .icon(() -> new ItemStack(ModItems.WOLFRAMITE_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.WOLFRAMITE_INGOT);
                        entries.add(ModItems.TUNGSTEN_INGOT);
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.TUNGSTENSTEEL_INGOT);

                        entries.add(ModItems.WOLFRAMITE_DUST);
                        entries.add(ModItems.TUNGSTEN_DUST);
                        entries.add(ModItems.IRON_DUST);
                        entries.add(ModItems.COAL_DUST);
                        entries.add(ModItems.STEEL_DUST);
                        entries.add(ModItems.TUNGSTENSTEEL_DUST);

                        entries.add(ModItems.TINY_WOLFRAMITE_DUST);

                        entries.add(ModItems.ANGEL_RODS);

                        entries.add(ModItems.MUSIC_DISC_BY_DUSK);

                    }).build());



    public static void registerItemGroups() {
        Ordnance.LOGGER.info("Registering Item Groups for " + MOD_ID);
    }
}
