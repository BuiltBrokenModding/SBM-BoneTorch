package com.builtbroken.bonetorch;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=BoneTorchMod.DOMAIN, bus=Bus.MOD, value=Dist.CLIENT)
public class ClientRegistrar
{
    @SubscribeEvent
    public static void registerItems(FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(BoneTorchMod.blockTorch, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BoneTorchMod.blockTorchWall, RenderType.cutout());
    }
}
