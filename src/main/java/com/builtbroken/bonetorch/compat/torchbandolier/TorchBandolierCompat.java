package com.builtbroken.bonetorch.compat.torchbandolier;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.RegistryObject;
import net.silentchaos512.torchbandolier.item.TorchBandolierItem;

public class TorchBandolierCompat
{
	public static final RegistryObject<TorchBandolierItem> BONETORCH_BANDOLIER = BoneTorchMod.ITEMS.register("bone_torch_bandolier", () -> new TorchBandolierItem(BoneTorchMod.BONETORCH.get()));
	public static final RegistryObject<TorchBandolierItem> SOUL_BONETORCH_BANDOLIER = BoneTorchMod.ITEMS.register("soul_bone_torch_bandolier", () -> new TorchBandolierItem(BoneTorchMod.SOUL_BONETORCH.get()));

	public static void init() {}

	public static void addToCreativeTab(BuildCreativeModeTabContentsEvent event)
	{
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
		{
			event.accept(BONETORCH_BANDOLIER.get().createFullStack());
			event.accept(SOUL_BONETORCH_BANDOLIER.get().createFullStack());
		}
	}
}
