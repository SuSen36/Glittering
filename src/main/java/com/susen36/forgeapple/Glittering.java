package com.susen36.forgeapple;


import com.susen36.forgeapple.enchantments.EnchantsRegister;
import com.susen36.forgeapple.event.AppleCraftEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Glittering.MOD_ID)
public class Glittering
{
    public static final String MOD_ID = "glittering";

    public Glittering() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        EnchantsRegister.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::eventSetup);

        }

    public void eventSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(AppleCraftEvent.class);
    }
}