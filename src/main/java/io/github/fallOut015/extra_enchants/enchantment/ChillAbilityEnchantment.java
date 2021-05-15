package io.github.fallOut015.extra_enchants.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ChillAbilityEnchantment extends AbilityEnchantment {
    public ChillAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.WEAPON, slots);
    }

    @Override
    public void action(PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem) {
        for(int i = 0; i < 16; ++ i) {
            double x = playerInteractEvent$rightClickItem.getPlayer().getX();
            double y = playerInteractEvent$rightClickItem.getPlayer().getY();
            double z = playerInteractEvent$rightClickItem.getPlayer().getZ();
            float a = 22.5f * i;
            double xspeed = Math.cos(a);
//			double yspeed = Math.sin(a);
            double yspeed = 0;
            double zspeed = Math.tan(a);
            playerInteractEvent$rightClickItem.getWorld().addParticle(ParticleTypes.CLOUD, true, x, y, z, xspeed, yspeed, zspeed);
        }
    }
}