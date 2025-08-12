package dev.chemthunder.regalia.item.divinity;

import dev.chemthunder.regalia.init.RegaliaParticles;
import dev.chemthunder.regalia.item.CustomHitParticleItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;

public class HalberdItem extends SwordItem implements CustomHitParticleItem {
    public HalberdItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {


        return super.postHit(stack, target, attacker);
    }


    @Override
    public void spawnHitParticles(PlayerEntity player) {
        double d0 = (-MathHelper.sin(player.getYaw() * ((float) Math.PI / 180F)));
        double d1 = MathHelper.cos(player.getYaw() * ((float) Math.PI / 180F));
        if (player.world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(RegaliaParticles.HALBERD_SWEEP_PARTICLE, player.getX() + d0, player.getBodyY(0.5D), player.getZ() + d1, 0, d0, 0.0D, d1, 0.0D);
        }
    }
}
