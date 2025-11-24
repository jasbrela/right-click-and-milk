package com.jasbrela.rightclickandmilk;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(RightClickAndMilk.MODID)
public class RightClickAndMilk
{
    public static final String MODID = "rightclickandmilk";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RightClickAndMilk(IEventBus modEventBus, ModContainer modContainer)
    {
        NeoForge.EVENT_BUS.register(new CowMilkHandler());
    }
}
