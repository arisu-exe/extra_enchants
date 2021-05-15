package io.github.fallOut015.extra_enchants;

import io.github.fallOut015.extra_enchants.enchantment.AbilityEnchantment;
import io.github.fallOut015.extra_enchants.enchantment.EnchantmentsExtraEnchants;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Hand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MainExtraEnchants.MODID)
public class MainExtraEnchants {
    public static final String MODID = "extra_enchants";

    public MainExtraEnchants() {
        EnchantmentsExtraEnchants.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class Events {
        @SubscribeEvent
        public static void onRightClickItem(final PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem) {
            if(playerInteractEvent$rightClickItem.getPlayer().isShiftKeyDown()) {
                // TODO
                // Make render effect when sneaking
                // Either that or not make sneaking mandatory
                EnchantmentHelper.getEnchantments(playerInteractEvent$rightClickItem.getItemStack()).forEach((key, value) -> {
                    if(key instanceof AbilityEnchantment) {
                        AbilityEnchantment ability = (AbilityEnchantment) key;
                        ability.action(playerInteractEvent$rightClickItem);
                        playerInteractEvent$rightClickItem.getPlayer().getCooldowns().addCooldown(playerInteractEvent$rightClickItem.getItemStack().getItem(), ability.getCooldown());
                        playerInteractEvent$rightClickItem.getPlayer().getItemInHand(playerInteractEvent$rightClickItem.getHand()).hurtAndBreak(ability.getDamage(), playerInteractEvent$rightClickItem.getPlayer(), playerEntity -> playerEntity.broadcastBreakEvent(playerInteractEvent$rightClickItem.getHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
                        playerInteractEvent$rightClickItem.getPlayer().swing(playerInteractEvent$rightClickItem.getHand());
                    }
                });
            }
        }
    }
}