package dev.chemthunder.regalia.init;

import dev.chemthunder.regalia.MasonsRegalia;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.BiConsumer;

public interface RegaliaParticles {
    DefaultParticleType HALBERD_SWEEP_PARTICLE = FabricParticleTypes.simple(true);

    static void initialize() {
        initParticles(bind(Registry.PARTICLE_TYPE));
    }

    static void registerFactories() {
        ParticleFactoryRegistry.getInstance().register(HALBERD_SWEEP_PARTICLE, SweepAttackParticle.Factory::new);
    }

    private static void initParticles(BiConsumer<ParticleType<?>, Identifier> registry) {
        registry.accept(HALBERD_SWEEP_PARTICLE, MasonsRegalia.id("halberd_sweep_particle"));
    }

    private static <T> BiConsumer<T, Identifier> bind(Registry<? super T> registry) {
        return (t, id) -> Registry.register(registry, id, t);
    }
}
