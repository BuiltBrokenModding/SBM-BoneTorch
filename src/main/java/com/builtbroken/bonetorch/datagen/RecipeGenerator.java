package com.builtbroken.bonetorch.datagen;

import java.util.concurrent.CompletableFuture;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.Tags;

public class RecipeGenerator extends RecipeProvider
{
	public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
	{
		super(output, lookupProvider);
	}

	@Override
	protected final void buildRecipes(RecipeOutput recipeOutput)
	{
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BoneTorchMod.BONETORCH_ITEM, 4)
		.pattern("c")
		.pattern("s")
		.define('c', ItemTags.COALS)
		.define('s', Tags.Items.BONES)
		.unlockedBy("has_bone", has(Tags.Items.BONES))
		.save(recipeOutput);
	}
}
