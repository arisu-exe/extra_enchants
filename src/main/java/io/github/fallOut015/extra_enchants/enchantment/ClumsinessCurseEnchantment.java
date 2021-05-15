package io.github.fallOut015.extra_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class ClumsinessCurseEnchantment extends Enchantment {
    public ClumsinessCurseEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.BREAKABLE, slots);
    }

    @Override
    public boolean isCurse() {
        return true;
    }
}