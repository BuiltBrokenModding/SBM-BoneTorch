package com.builtbroken.bonetorch;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
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
@EventBusSubscriber
public class BoneTorchMod
{
	public static final String DOMAIN = "bonetorch";
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DOMAIN);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DOMAIN);
	public static final DeferredBlock<TorchBlock> BONETORCH = BLOCKS.registerBlock("bonetorch", p -> new TorchBlock(ParticleTypes.FLAME, p), () -> BlockBehaviour.Properties.ofLegacyCopy(Blocks.TORCH));
	public static final DeferredBlock<WallTorchBlock> WALL_BONETORCH = BLOCKS.registerBlock("wall_bonetorch", p -> new WallTorchBlock(ParticleTypes.FLAME, p.overrideLootTable(BONETORCH.get().getLootTable()).overrideDescription(BONETORCH.get().getDescriptionId())), () -> BlockBehaviour.Properties.ofLegacyCopy(Blocks.TORCH));
	public static final DeferredItem<StandingAndWallBlockItem> BONETORCH_ITEM = ITEMS.registerItem("bonetorch", p -> new StandingAndWallBlockItem(BONETORCH.get(), WALL_BONETORCH.get(), Direction.DOWN, p.useBlockDescriptionPrefix()));
	public static final DeferredBlock<TorchBlock> COPPER_BONETORCH = BLOCKS.registerBlock("copper_bonetorch", p -> new TorchBlock(ParticleTypes.COPPER_FIRE_FLAME, p), () -> BlockBehaviour.Properties.ofLegacyCopy(Blocks.COPPER_TORCH));
	public static final DeferredBlock<WallTorchBlock> WALL_COPPER_BONETORCH = BLOCKS.registerBlock("wall_copper_bonetorch", p -> new WallTorchBlock(ParticleTypes.COPPER_FIRE_FLAME, p.overrideLootTable(COPPER_BONETORCH.get().getLootTable()).overrideDescription(COPPER_BONETORCH.get().getDescriptionId())), () -> BlockBehaviour.Properties.ofLegacyCopy(Blocks.COPPER_TORCH));
	public static final DeferredItem<StandingAndWallBlockItem> COPPER_BONETORCH_ITEM = ITEMS.registerItem("copper_bonetorch", p -> new StandingAndWallBlockItem(COPPER_BONETORCH.get(), WALL_COPPER_BONETORCH.get(), Direction.DOWN, p.useBlockDescriptionPrefix()));
	public static final DeferredBlock<TorchBlock> SOUL_BONETORCH = BLOCKS.registerBlock("soul_bonetorch", p -> new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, p), () -> BlockBehaviour.Properties.ofLegacyCopy(Blocks.SOUL_TORCH));
	public static final DeferredBlock<WallTorchBlock> WALL_SOUL_BONETORCH = BLOCKS.registerBlock("wall_soul_bonetorch", p -> new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, p.overrideLootTable(SOUL_BONETORCH.get().getLootTable()).overrideDescription(SOUL_BONETORCH.get().getDescriptionId())), () -> BlockBehaviour.Properties.ofLegacyCopy(Blocks.SOUL_TORCH));
	public static final DeferredItem<StandingAndWallBlockItem> SOUL_BONETORCH_ITEM = ITEMS.registerItem("soul_bonetorch", p -> new StandingAndWallBlockItem(SOUL_BONETORCH.get(), WALL_SOUL_BONETORCH.get(), Direction.DOWN, p.useBlockDescriptionPrefix()));

	public BoneTorchMod(IEventBus modEventBus)
	{
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event)
	{
		if (event.getTabKey()==CreativeModeTabs.FUNCTIONAL_BLOCKS)
		{
			event.insertAfter(new ItemStack(Items.REDSTONE_TORCH), new ItemStack(BONETORCH_ITEM.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(new ItemStack(BONETORCH_ITEM.get()), new ItemStack(SOUL_BONETORCH_ITEM.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(new ItemStack(SOUL_BONETORCH_ITEM.get()), new ItemStack(COPPER_BONETORCH_ITEM.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
}
