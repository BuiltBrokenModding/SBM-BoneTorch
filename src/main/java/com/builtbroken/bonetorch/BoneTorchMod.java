package com.builtbroken.bonetorch;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

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

    @ObjectHolder(PREFIX + "bonetorch")
    public static TorchBlock blockTorch;
    @ObjectHolder(PREFIX + "wall_bonetorch")
    public static WallTorchBlock blockTorchWall;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new WallOrFloorItem(blockTorch, blockTorchWall, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(blockTorch.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new TorchBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.0F).setLightLevel(state -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME).setRegistryName(new ResourceLocation(DOMAIN, "bonetorch")));
        event.getRegistry().register(new WallTorchBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.0F).setLightLevel(state -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME).setRegistryName(new ResourceLocation(DOMAIN, "wall_bonetorch")));
    }
}
