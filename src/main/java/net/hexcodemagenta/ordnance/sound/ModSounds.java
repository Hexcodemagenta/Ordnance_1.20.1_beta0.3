package net.hexcodemagenta.ordnance.sound;

import net.hexcodemagenta.ordnance.Ordnance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent BY_DUSK = registerSoundEvent("by_dusk");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Ordnance.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {Ordnance.LOGGER.info("registering Sounds for " + Ordnance.MOD_ID); }
}
