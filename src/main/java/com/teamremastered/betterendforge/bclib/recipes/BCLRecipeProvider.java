package com.teamremastered.betterendforge.bclib.recipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BCLRecipeProvider extends RecipeProvider {
    static private HashMap<String, RecipeSupplier> suppliers = new HashMap<>();

    public BCLRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    public static void addRecipe(RecipeSupplier recipe) {
        suppliers.putIfAbsent(recipe.recipeId.toString(), recipe);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        for (RecipeSupplier recipeSupplier : suppliers.values()) {
            RecipeBuilder recipeBuilder = recipeSupplier.build();
            for (Supplier<ItemLike> itemLikeSupplier : recipeSupplier.recipeInputs.getMap().values()) {
                Item item = itemLikeSupplier.get().asItem();
                recipeBuilder.unlockedBy(getHasName(item), has(item));
            }
            recipeBuilder.save(pFinishedRecipeConsumer, recipeSupplier.recipeId);
        }

    }
}
