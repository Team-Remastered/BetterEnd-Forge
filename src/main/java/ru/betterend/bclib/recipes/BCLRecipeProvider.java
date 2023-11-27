package ru.betterend.bclib.recipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BCLRecipeProvider extends RecipeProvider {
    static private ArrayList<RecipeSupplier> suppliers = new ArrayList<>();

    public BCLRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    public static void addRecipe(RecipeSupplier recipe) {
        suppliers.add(recipe);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        for (RecipeSupplier recipeSupplier : suppliers) {
            RecipeBuilder recipeBuilder = recipeSupplier.build();
            for (Supplier<ItemLike> itemLikeSupplier : recipeSupplier.recipeInputs.getMap().values()) {
                Item item = itemLikeSupplier.get().asItem();
                recipeBuilder.unlockedBy(getHasName(item), has(item));
            }
            recipeBuilder.save(pFinishedRecipeConsumer);
        }

    }
}
