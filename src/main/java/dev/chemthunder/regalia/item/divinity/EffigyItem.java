package dev.chemthunder.regalia.item.divinity;

import dev.chemthunder.regalia.init.RegaliaItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class EffigyItem extends Item {
    public EffigyItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity.getHealth() <= 4.0f)
            banishPlayer(user, stack, entity, hand);
        return ActionResult.PASS;
    }

    public static void banishPlayer(PlayerEntity user, ItemStack stack, LivingEntity entity, Hand hand) {
        World world = entity.getWorld();

        entity.setHealth(10f);
        stack.decrement(1);
        user.giveItemStack(RegaliaItems.BROKEN_EFFIGY.getDefaultStack());
        user.swingHand(Hand.MAIN_HAND);
        user.playSound(new SoundEvent(SoundEvents.ITEM_TRIDENT_THUNDER.getId()), 5, 5);
        entity.teleport(entity.getX() + 50, entity.getY() + 2500000, entity.getY() + 50);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 999999999, 250));
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.4, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.3, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.2, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.1, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.1, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.5, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.7, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.8, 0);
        world.addParticle(ParticleTypes.SOUL, entity.getX(), entity.getY(), entity.getZ(), 0, 0.9, 0);

    }
}