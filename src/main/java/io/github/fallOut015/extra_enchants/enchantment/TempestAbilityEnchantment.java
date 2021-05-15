package io.github.fallOut015.extra_enchants.enchantment;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class TempestAbilityEnchantment extends AbilityEnchantment {
    public TempestAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.WEAPON, slots);
    }

    @Override
    public void action(PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem) {
        PlayerEntity playerIn = playerInteractEvent$rightClickItem.getPlayer();

        RayTraceResult result = rayTrace(playerIn.level, playerIn, RayTraceContext.FluidMode.ANY);

        double d0 = Math.min(result.getLocation().y(), playerIn.getY());
        double d1 = Math.max(result.getLocation().y(), playerIn.getY()) + 1.0D;
        float f = (float) MathHelper.atan2(result.getLocation().z() - playerIn.getZ(), result.getLocation().x() - playerIn.getX());

        for(int l = 2; l < 12; ++ l) {
            double d2 = 1.5D * (double)(l + 1);
            this.spawnLightning(playerIn.getX() + (double)MathHelper.cos(f) * d2, playerIn.getZ() + (double)MathHelper.sin(f) * d2, d0, d1, playerIn);
        }
    }

    private void spawnLightning(double d1, double d3, double d5, double d7, PlayerEntity playerIn) {
        // Based off of EvokerEntity::spawnFangs

        if(playerIn.level instanceof ServerWorld) {
            BlockPos blockpos = new BlockPos(d1, d7, d3);
            boolean flag = false;
            double d0 = 0.0D;

            while(true) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = playerIn.level.getBlockState(blockpos1);
                if(blockstate.isFaceSturdy(playerIn.level, blockpos1, Direction.UP)) {
                    if(!playerIn.level.isEmptyBlock(blockpos)) {
                        BlockState blockstate1 = playerIn.level.getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(playerIn.level, blockpos);
                        if(!voxelshape.isEmpty()) {
                            d0 = voxelshape.max(Direction.Axis.Y);
                        }
                    }

                    flag = true;
                    break;
                }

                blockpos = blockpos.below();
                if(blockpos.getY() < MathHelper.floor(d5) - 1) {
                    break;
                }
            }

            if(flag) {
                LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(playerIn.level);
                BlockPos bp = new BlockPos(d1, blockpos.getY() + d0, d3);
                lightningboltentity.moveTo(Vector3d.atCenterOf(bp));
                lightningboltentity.setVisualOnly(false);
                playerIn.level.addFreshEntity(lightningboltentity);
            }
        }

        // make custom lightning bolt that can't hurt user or set fires? yes
        // TODO
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
        double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).getValue();
        Vector3d vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return worldIn.clip(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
    }
}