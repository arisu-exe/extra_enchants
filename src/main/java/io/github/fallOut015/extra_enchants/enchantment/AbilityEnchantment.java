package io.github.fallOut015.extra_enchants.enchantment;

import net.minecraft.enchantment.BindingCurseEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public abstract class AbilityEnchantment extends Enchantment {
    protected AbilityEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
        super(rarityIn, typeIn, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        return !(ench instanceof AbilityEnchantment);
    }
    @Override
    public ITextComponent getFullname(int level) {
        IFormattableTextComponent iformattabletextcomponent = new TranslationTextComponent(this.getDescriptionId());
        iformattabletextcomponent.withStyle(TextFormatting.GREEN);

//		if (level != 1 || this.getMaxLevel() != 1) {
//			iformattabletextcomponent.func_240702_b_(" ").func_230529_a_(new TranslationTextComponent("enchantment.level." + level));
//		}

        return iformattabletextcomponent;
    }

    abstract public void action(final PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem);
    public int getCooldown() {
        return 10;
    }
    public int getDamage() {
        return 20;
    }
}