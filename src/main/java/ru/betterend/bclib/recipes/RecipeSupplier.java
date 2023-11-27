package ru.betterend.bclib.recipes;

import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public class RecipeSupplier {
    ResourceLocation recipeId;
    String recipeGroup;

    Inputs recipeInputs = new Inputs();
    Output recipeOutput;

    private String[] recipeShape;

    public RecipeSupplier(String modId, String recipeName) {
        this.recipeId = new ResourceLocation(modId, recipeName);
    }

    public RecipeSupplier addInput(Character symbol, Supplier<ItemLike> itemLikeSupplier) {
        this.recipeInputs.add(symbol, itemLikeSupplier);
        return this;
    }

    public RecipeSupplier setOutput(Supplier<ItemLike> outputSupplier, int count) {
        this.recipeOutput = new Output(outputSupplier, count);
        return this;
    }

    public RecipeSupplier setOutput(Supplier<ItemLike> outputSupplier) {
        return this.setOutput(outputSupplier, 1);
    }


    public RecipeSupplier setShape(String... lines) {
        this.recipeShape = lines;
        return this;
    }

    public RecipeSupplier setGroup(String recipeGroup) {
        this.recipeGroup = recipeGroup;
        return this;
    }

    public int getHeight() {
        return this.recipeShape.length;
    }

    public int getWidth() {
        return this.recipeShape[0].length();
    }


    private NonNullList<Ingredient> getMaterials() {
        NonNullList<Ingredient> materials = NonNullList.withSize(this.getWidth() * this.getHeight(), Ingredient.EMPTY);
        int pos = 0;
        for (String line : this.recipeShape) {
            for (int i = 0; i < this.getWidth(); i++) {
                char c = line.charAt(i);
                Ingredient material = Ingredient.of(this.recipeInputs.inputMap.get(c).get());
                materials.set(pos++, material == null ? Ingredient.EMPTY : material);
            }
        }
        return materials;
    }

    public ShapedRecipeBuilder build() {
        ShapedRecipeBuilder recipeBuilder = ShapedRecipeBuilder
                .shaped(this.recipeOutput.getItem(), this.recipeOutput.getCount())
                .group(recipeGroup);

        for (String line : this.recipeShape) {
            recipeBuilder.pattern(line);
        }

        for (HashMap.Entry<Character, Supplier<ItemLike>> entry : this.recipeInputs.getMap().entrySet()) {
            recipeBuilder.define(entry.getKey(), Ingredient.of(entry.getValue().get()));
        }

        return recipeBuilder;
    }

    public static class Output {
        private final Supplier<ItemLike> outputSupplier;
        private final int count;

        public Output(Supplier<ItemLike> outputSupplier, int count) {
            this.outputSupplier = outputSupplier;
            this.count = count;
        }

        public ItemLike getItem() {
            return this.outputSupplier.get();
        }

        public int getCount() {
            return this.count;
        }

        public ItemStack getItemStack() {
            return new ItemStack(this.outputSupplier.get(), this.count);
        }
    }

    public static class Inputs {
        private final HashMap<Character, Supplier<ItemLike>> inputMap = new HashMap<>();

        public Inputs() {

        }

        public Inputs add(Character symbol, Supplier<ItemLike> ingredientSupplier) {
            this.inputMap.putIfAbsent(symbol, ingredientSupplier);
            return this;
        }

        public HashMap<Character, Supplier<ItemLike>> getMap() {
            return this.inputMap;
        }
    }
}
