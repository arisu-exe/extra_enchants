package io.github.fallOut015.extra_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

public class BackfireCurseEnchantment extends Enchantment {
    public BackfireCurseEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.WEAPON, slots);
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        user.hurt(DamageSource.MAGIC, 2 * level);
    }
    @Override
    public boolean isCurse() {
        return true;
    }
}