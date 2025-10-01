package com.builtbroken.bonetorch.datagen;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.DetectedVersion;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent.DataProviderFromOutputLookup;

@EventBusSubscriber(modid = BoneTorchMod.DOMAIN)
public class DataGenRegistrar
{
	@SubscribeEvent
	public static void onGatherData(GatherDataEvent.Client event)
	{
		event.createProvider((DataProviderFromOutputLookup<LootTableProvider>) (output, lookupProvider) -> new LootTableProvider(output, Set.of(), List.of(new SubProviderEntry(BlockLootTableGenerator::new, LootContextParamSets.BLOCK)), lookupProvider));
		event.createProvider(RecipeGenerator.Runner::new);
		event.createProvider(output -> new PackMetadataGenerator(output)
			.add(PackMetadataSection.CLIENT_TYPE, new PackMetadataSection(
				Component.literal("SBM-BoneTorch resources"),
				DetectedVersion.BUILT_IN.packVersion(PackType.CLIENT_RESOURCES).minorRange()))
			.add(PackMetadataSection.SERVER_TYPE, new PackMetadataSection(
				Component.literal("SBM-BoneTorch data"),
				DetectedVersion.BUILT_IN.packVersion(PackType.SERVER_DATA).minorRange())));
	}
}
