package com.builtbroken.bonetorch.datagen;

import java.util.Set;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

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
	}


	@Override
	protected Iterable<Block> getKnownBlocks()
	{
		return BoneTorchMod.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
	}
}
