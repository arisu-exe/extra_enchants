package io.github.fallOut015.extra_enchants.enchantment;

import io.github.fallOut015.extra_enchants.MainExtraEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentsExtraEnchants {
    private static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MainExtraEnchants.MODID);



    public static final RegistryObject<Enchantment> FLIMSINESS_CURSE = ENCHANTMENTS.register("flimsiness_curse", () -> new FlimsinessCurseEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> CLUMSINESS_CURSE = ENCHANTMENTS.register("clumsiness_curse", () -> new ClumsinessCurseEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> BACKFIRE_CURSE = ENCHANTMENTS.register("backfire_curse", () -> new BackfireCurseEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> HEAVINESS_CURSE = ENCHANTMENTS.register("heaviness_curse", () -> new HeavinessCurseEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET));

    public static final RegistryObject<Enchantment> FIRE_ABILITY = ENCHANTMENTS.register("pyro", () -> new PyroAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> LIGHTNING_ABILITY = ENCHANTMENTS.register("tempest", () -> new TempestAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> GRASS_ABILITY = ENCHANTMENTS.register("vines", () -> new VinesAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> NETHER_ABILITY = ENCHANTMENTS.register("hellfire", () -> new HellfireAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> WIND_ABILITY = ENCHANTMENTS.register("twister", () -> new TwisterAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> ICE_ABILITY = ENCHANTMENTS.register("chill", () -> new ChillAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));

    // something for shields



    public static void register(IEventBus bus) {
        ENCHANTMENTS.register(bus);
    }
}