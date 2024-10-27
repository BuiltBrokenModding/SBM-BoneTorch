package com.builtbroken.bonetorch.datagen;

import java.util.concurrent.CompletableFuture;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;

public class RecipeGenerator extends RecipeProvider
{
	private final HolderGetter<Item> items;

	public RecipeGenerator(HolderLookup.Provider lookupProvider, RecipeOutput output)
	{
		super(lookupProvider, output);
		items = lookupProvider.lookupOrThrow(Registries.ITEM);
	}

	@Override
	protected final void buildRecipes()
	{
		ShapedRecipeBuilder.shaped(items,RecipeCategory.DECORATIONS, BoneTorchMod.BONETORCH_ITEM, 4)
		.pattern("C")
		.pattern("B")
		.define('C', ItemTags.COALS)
		.define('B', Tags.Items.BONES)
		.unlockedBy("has_bone", has(Tags.Items.BONES))
		.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, BoneTorchMod.SOUL_BONETORCH_ITEM, 4)
		.pattern("C")
		.pattern("B")
		.pattern("S")
		.define('C', ItemTags.COALS)
		.define('B', Tags.Items.BONES)
		.define('S', ItemTags.SOUL_FIRE_BASE_BLOCKS)
		.unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
		.save(output);
	}

	public static final class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
			super(output, lookupProvider);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
			return new RecipeGenerator(lookupProvider, output);
		}

		@Override
		public String getName() {
			return "Bone Torch recipes";
		}
	}
}
