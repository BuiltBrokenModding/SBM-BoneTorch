package com.builtbroken.bonetorch;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.Mod.EventBusSubscriber.Bus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DOMAIN);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DOMAIN);
	public static final DeferredBlock<TorchBlock> BONETORCH = BLOCKS.register("bonetorch", () -> new TorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).sound(SoundType.WOOD), ParticleTypes.FLAME));
	public static final DeferredBlock<WallTorchBlock> WALL_BONETORCH = BLOCKS.register("wall_bonetorch", () -> new WallTorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).sound(SoundType.WOOD), ParticleTypes.FLAME));
	public static final DeferredItem<StandingAndWallBlockItem> BONETORCH_ITEM = ITEMS.register("bonetorch", () -> new StandingAndWallBlockItem(BONETORCH.get(), WALL_BONETORCH.get(), new Item.Properties(), Direction.DOWN));

	public BoneTorchMod(IEventBus modEventBus)
	{
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event)
	{
		if (event.getTabKey()==CreativeModeTabs.FUNCTIONAL_BLOCKS)
			event.getEntries().putAfter(new ItemStack(Items.REDSTONE_TORCH), new ItemStack(BONETORCH_ITEM.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
	}
}
