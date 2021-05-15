package io.github.fallOut015.extra_enchants.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class TwisterAbilityEnchantment extends AbilityEnchantment {
    public TwisterAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.WEAPON, slots);
    }

    @Override
    public void action(PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem) {
        PlayerEntity playerIn = playerInteractEvent$rightClickItem.getPlayer();
        //TwisterEntity twister = new TwisterEntity(playerIn.getEntityWorld(), playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), null);
        //RayTraceResult result = rayTrace(playerIn.getEntityWorld(), playerIn, RayTraceContext.FluidMode.ANY);
        //twister.setMotion(new Vector3d(result.getHitVec().getX() - playerIn.getPosX(), result.getHitVec().getY() - playerIn.getPosY(), result.getHitVec().getZ() - playerIn.getPosZ()));
    }

    // Copied from Item::rayTrace
    protected static RayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
        float f = player.xRot;
        float f1 = player.yHeadRot;
        Vector3d vec3d = player.getEyePosition(1.0F);
        float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
        float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).getValue();;
        Vector3d vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return worldIn.clip(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
    }
}
