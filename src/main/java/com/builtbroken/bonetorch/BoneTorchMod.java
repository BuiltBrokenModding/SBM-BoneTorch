package com.builtbroken.bonetorch;

import com.builtbroken.bonetorch.torch.BlockBoneTorch;
import com.builtbroken.bonetorch.torch.BlockBoneTorchWall;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * Simple mod to add a bone torch to MC. Idea was spawned from running out of
 * torches in the nether. Where the player may still be able to get coal and bones
 * from wither skeletons.
 * Created by Dark on 7/25/2015.
 */
@Mod(BoneTorchMod.DOMAIN)
@Mod.EventBusSubscriber(bus=Bus.MOD)
public class BoneTorchMod
{
    public static final String DOMAIN = "bonetorch";
    public static final String PREFIX = DOMAIN + ":";

    public static BlockBoneTorch blockTorch;
    public static BlockBoneTorchWall blockTorchWall;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new WallOrFloorItem(blockTorch, blockTorchWall, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(blockTorch.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(blockTorch = new BlockBoneTorch());
        event.getRegistry().register(blockTorchWall = new BlockBoneTorchWall());
    }
}
