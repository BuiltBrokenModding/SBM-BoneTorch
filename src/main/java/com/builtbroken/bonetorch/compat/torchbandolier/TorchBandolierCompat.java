package com.builtbroken.bonetorch.compat.torchbandolier;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.silentchaos512.torchbandolier.item.TorchBandolierItem;

public class TorchBandolierCompat
{
	public static void register(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new TorchBandolierItem(() -> BoneTorchMod.blockTorch).setRegistryName("bone_torch_bandolier"));
	}
}
