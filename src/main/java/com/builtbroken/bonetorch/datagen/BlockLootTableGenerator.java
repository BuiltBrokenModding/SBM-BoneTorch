package com.builtbroken.bonetorch.datagen;

import java.util.Set;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockLootTableGenerator extends BlockLootSubProvider
{
	protected BlockLootTableGenerator(HolderLookup.Provider lookupProvider)
	{
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
	}

	@Override
	public void generate()
	{
		dropSelf(BoneTorchMod.BONETORCH.get());
		dropSelf(BoneTorchMod.COPPER_BONETORCH.get());
		dropSelf(BoneTorchMod.SOUL_BONETORCH.get());
	}


	@Override
	protected Iterable<Block> getKnownBlocks()
	{
		return (Iterable<Block>) BoneTorchMod.BLOCKS.getEntries().stream().map(DeferredHolder::get).toList();
	}
}
