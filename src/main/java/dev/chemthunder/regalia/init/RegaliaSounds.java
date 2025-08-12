package dev.chemthunder.regalia.init;

import dev.chemthunder.regalia.MasonsRegalia;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public interface RegaliaSounds {
    Map<SoundEvent, Identifier> SOUND_EVENTS = new LinkedHashMap<>();

    SoundEvent ITEM_HALBERD_execute = createSoundEvent("item.halberd.execute");

    static void initialize() {
        SOUND_EVENTS.keySet().forEach(soundEvent -> Registry.register(Registry.SOUND_EVENT, SOUND_EVENTS.get(soundEvent), soundEvent));
    }

    private static SoundEvent createSoundEvent(String path) {
        SoundEvent soundEvent = new SoundEvent(new Identifier(MasonsRegalia.MOD_ID, path));
        SOUND_EVENTS.put(soundEvent, new Identifier(MasonsRegalia.MOD_ID, path));
        return soundEvent;
    }
}
