package dev.chemthunder.regalia;

import dev.chemthunder.regalia.effect.RegaliaEffects;
import dev.chemthunder.regalia.effect.WeepingEffect;
import dev.chemthunder.regalia.init.RegaliaItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasonsRegalia implements ModInitializer {
	public static final String MOD_ID = "regalia";
    public static final StatusEffect WEEPING = Registry.register(
            Registry.STATUS_EFFECT,
            new Identifier(MasonsRegalia.MOD_ID, "weeping"),
            new WeepingEffect()
    );

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path); }

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RegaliaItems.initialize();
		LOGGER.info("Hello Fabric world!");
	}
}