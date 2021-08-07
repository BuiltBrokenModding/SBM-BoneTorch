package com.builtbroken.bonetorch;

import com.builtbroken.bonetorch.compat.torchbandolier.TorchBandolierCompat;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
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
		event.getRegistry().register(new StandingAndWallBlockItem(blockTorch, blockTorchWall, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)).setRegistryName(blockTorch.getRegistryName()));

		if(ModList.get().isLoaded("torchbandolier"))
			TorchBandolierCompat.register(event);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new TorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.0F).lightLevel(state -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME).setRegistryName(new ResourceLocation(DOMAIN, "bonetorch")));
		event.getRegistry().register(new WallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.0F).lightLevel(state -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME).setRegistryName(new ResourceLocation(DOMAIN, "wall_bonetorch")));
	}
}
