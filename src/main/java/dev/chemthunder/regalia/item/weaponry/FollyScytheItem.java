package dev.chemthunder.regalia.item.weaponry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class FollyScytheItem extends SwordItem {
    public FollyScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();

        world.addParticle(ParticleTypes.SOUL, target.getX(), target.getY(), target.getZ(), 0, 0, 0);


        return super.postHit(stack, target, attacker);
    }
}
