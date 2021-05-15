package io.github.fallOut015.extra_enchants.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class VinesAbilityEnchantment extends AbilityEnchantment {
    public VinesAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.WEAPON, slots);
    }

    @Override
    public void action(PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem) {

    }
}