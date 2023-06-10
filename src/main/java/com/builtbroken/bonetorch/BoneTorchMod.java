package com.builtbroken.bonetorch;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DOMAIN);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DOMAIN);
	public static final RegistryObject<TorchBlock> BONETORCH = BLOCKS.register("bonetorch", () -> new TorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).sound(SoundType.WOOD), ParticleTypes.FLAME));
	public static final RegistryObject<WallTorchBlock> WALL_BONETORCH = BLOCKS.register("wall_bonetorch", () -> new WallTorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).sound(SoundType.WOOD), ParticleTypes.FLAME));
	public static final RegistryObject<StandingAndWallBlockItem> BONETORCH_ITEM = ITEMS.register("bonetorch", () -> new StandingAndWallBlockItem(BONETORCH.get(), WALL_BONETORCH.get(), new Item.Properties(), Direction.DOWN));

	public BoneTorchMod()
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

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
