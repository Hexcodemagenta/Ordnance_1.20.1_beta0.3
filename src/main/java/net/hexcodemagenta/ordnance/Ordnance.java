package net.hexcodemagenta.ordnance;

import net.fabricmc.api.ModInitializer;

import net.hexcodemagenta.ordnance.datagen.ModItemTagProvider;
import net.hexcodemagenta.ordnance.entity.ModEntities;
import net.hexcodemagenta.ordnance.item.ModItemGroups;
import net.hexcodemagenta.ordnance.item.ModItems;
import net.hexcodemagenta.ordnance.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ordnance implements ModInitializer {
	public static final String MOD_ID = "ordnance";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEntities.registerModEntities();
		ModItemGroups.registerItemGroups();
		ModSounds.registerModSounds();

		LOGGER.info("uhhh... what ordnance?");
	}
}