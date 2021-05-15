package io.github.fallOut015.extra_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Hand;

public class FlimsinessCurseEnchantment extends Enchantment {
    public FlimsinessCurseEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.BREAKABLE, slots);
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        user.getUseItem().hurtAndBreak((level + 1) * 20, user, playerEntity -> playerEntity.broadcastBreakEvent(user.getUsedItemHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
    }
    @Override
    public boolean isCurse() {
        return true;
    }
}