package com.builtbroken.bonetorch.datagen;

import java.util.Set;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockLootTableGenerator extends BlockLootSubProvider
{
	protected BlockLootTableGenerator()
	{
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	public void generate()
	{
		dropSelf(BoneTorchMod.BONETORCH.get());
		dropSelf(BoneTorchMod.SOUL_BONETORCH.get());
	}


	@Override
	protected Iterable<Block> getKnownBlocks()
	{
		return (Iterable<Block>) BoneTorchMod.BLOCKS.getEntries().stream().map(DeferredHolder::get).toList();
	}
}
