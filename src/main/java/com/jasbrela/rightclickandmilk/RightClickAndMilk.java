package com.jasbrela.rightclickandmilk;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RightClickAndMilk.MODID)
public class RightClickAndMilk
{
    public static final String MODID = "rightclickandmilk";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RightClickAndMilk()
    {
        MinecraftForge.EVENT_BUS.register(new CowMilkHandler());
    }
}
