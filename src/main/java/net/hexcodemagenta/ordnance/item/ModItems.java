package net.hexcodemagenta.ordnance.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hexcodemagenta.ordnance.Ordnance;
import net.hexcodemagenta.ordnance.item.custom.*;
import net.hexcodemagenta.ordnance.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static net.hexcodemagenta.ordnance.Ordnance.MOD_ID;

public class ModItems {
    public static final Item WOLFRAMITE_INGOT = registerItem("wolframite_ingot",
            new WolframiteItem(new FabricItemSettings()));
    public static final Item TUNGSTEN_INGOT = registerItem("tungsten_ingot",
            new TungstenItem(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            new SteelItem(new FabricItemSettings()));
    public static final Item TUNGSTENSTEEL_INGOT = registerItem("tungstensteel_ingot",
            new TungstenSteelItem(new FabricItemSettings()));

    public static final Item WOLFRAMITE_DUST = registerItem("wolframite_dust",
            new WolframiteItem(new FabricItemSettings()));
    public static final Item TUNGSTEN_DUST = registerItem("tungsten_dust",
            new TungstenItem(new FabricItemSettings()));

    public static final Item IRON_DUST = registerItem("iron_dust",
            new IronItem(new FabricItemSettings()));
    public static final Item COAL_DUST = registerItem("coal_dust",
            new CarbonItem(new FabricItemSettings()));
    public static final Item STEEL_DUST = registerItem("steel_dust",
            new SteelItem(new FabricItemSettings()));
    public static final Item TUNGSTENSTEEL_DUST = registerItem("tungstensteel_dust",
            new TungstenSteelItem(new FabricItemSettings()));

    public static final Item TINY_WOLFRAMITE_DUST = registerItem("tiny_wolframite_dust",
            new WolframiteItem(new FabricItemSettings()));

    public static final Item ANGEL_RODS = registerItem("angel_rods",
            new AngelRodsItem(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item HAMMAH = registerItem("hammah",
            new PickaxeItem(ModToolMaterial.HAMMAH, 0, -3.3f, new FabricItemSettings()));
    public static final Item CHARSCALIBUR = registerItem("charscalibur",
            new Item(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item MUSIC_DISC_BY_DUSK = registerItem("music_disc_by_dusk",
            new MusicDiscItem(12, ModSounds.BY_DUSK, new FabricItemSettings().rarity(Rarity.RARE).maxCount(1), 208));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Ordnance.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Ordnance.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
