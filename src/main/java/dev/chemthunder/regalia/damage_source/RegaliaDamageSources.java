package dev.chemthunder.regalia.damage_source;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;


public class RegaliaDamageSources {
    public static final DamageSource SCARLET_FEVER = (new DamageSource("scarlet_fever") {
        public Text getDeathMessage(LivingEntity entity) {
            return Text.literal(entity.getName().getString() + " was banished to a higher plane");
        }
    }).setBypassesArmor();

    public static final DamageSource EPITAPHAL = (new DamageSource("epitaphal") {
        public Text getDeathMessage(LivingEntity entity) {
            return Text.literal(entity.getName().getString() + "'s soul was deemed irredeemable");
        }
    }).setBypassesArmor();
}
