package com.builtbroken.bonetorch.datagen;

import java.util.function.Consumer;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

public class RecipeGenerator extends RecipeProvider
{
	public RecipeGenerator(PackOutput output)
	{
		super(output);
	}

	@Override
	protected final void buildRecipes(Consumer<FinishedRecipe> writer)
	{
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BoneTorchMod.BONETORCH_ITEM.get(), 4)
		.pattern("c")
		.pattern("s")
		.define('c', ItemTags.COALS)
		.define('s', Tags.Items.BONES)
		.unlockedBy("has_bone", has(Tags.Items.BONES))
		.save(writer);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BoneTorchMod.SOUL_BONETORCH_ITEM.get(), 4)
		.pattern("C")
		.pattern("B")
		.pattern("S")
		.define('C', ItemTags.COALS)
		.define('B', Tags.Items.BONES)
		.define('S', ItemTags.SOUL_FIRE_BASE_BLOCKS)
		.unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
		.save(writer);
	}
}
