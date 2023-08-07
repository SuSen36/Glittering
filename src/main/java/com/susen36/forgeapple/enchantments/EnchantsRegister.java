package com.susen36.forgeapple.enchantments;

import com.susen36.forgeapple.Glittering;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class EnchantsRegister {

    public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Glittering.MOD_ID);

    public static final EnchantmentCategory GOLDEN_APPLE = EnchantmentCategory.create("golden_apple", (item) -> {
        return item == Items.GOLDEN_APPLE;
    });

    public static final RegistryObject<Enchantment> GLITTERING = ENCHANTS.register("glittering", () -> new GlitteringEnchantment(
            Enchantment.Rarity.COMMON,
            GOLDEN_APPLE,
            new EquipmentSlot[]{ EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND }
    ));

    public static void register(IEventBus eventBus){
        ENCHANTS.register(eventBus);
    }

}
