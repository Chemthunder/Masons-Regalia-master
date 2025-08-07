package dev.chemthunder.regalia.item.divinity;

import dev.chemthunder.regalia.damage_source.RegaliaDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;


public class BoundItem extends SwordItem {
    public BoundItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!(target instanceof ServerPlayerEntity player)) return super.postHit(stack, target, attacker);

        // target is a player
        if (player.getHealth() <= 1.0f) {
            player.setHealth(5.0f); // restore health
            player.damage(RegaliaDamageSources.SCARLET_FEVER, 9999f);

            player.getServer().execute(() -> {
                if (player.isDead()) {
                    player.teleport(player.getX() + 20, player.getY() + 500000, player.getZ() + 20);
                }

                ServerWorld world = (ServerWorld) player.getWorld();
                world.spawnParticles(ParticleTypes.END_ROD,
                        player.getX(), player.getY() + 1, player.getZ(),
                        25, 0.3, 0.5, 0.3, 0.01
                );
            });
        }

        return super.postHit(stack, target, attacker);
    }
}
