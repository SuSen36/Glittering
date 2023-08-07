package com.susen36.forgeapple.event;

import com.susen36.forgeapple.enchantments.EnchantsRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


@SuppressWarnings("unused")
public class AppleCraftEvent {

        @SubscribeEvent
        public static void onLivingEntityUseItem (LivingEntityUseItemEvent event) {
            ItemStack itemStack = event.getItem();
            Item item = event.getItem().getItem();
            LivingEntity entity = event.getEntityLiving();
            Level level =event.getEntityLiving().level;
            int appleLevel = EnchantmentHelper.getItemEnchantmentLevel(EnchantsRegister.GLITTERING.get(), itemStack);
            if (item.finishUsingItem(itemStack,level, entity).is(Items.ENCHANTED_GOLDEN_APPLE)&&appleLevel>0) {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, appleLevel));
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000+(appleLevel-1)*1000, 1));
                entity.heal(appleLevel*2.5f);
            }
        }
}