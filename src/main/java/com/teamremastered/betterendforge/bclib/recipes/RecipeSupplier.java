package com.teamremastered.betterendforge.bclib.recipes;

import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
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

    boolean isShaped;

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
        this.isShaped = true;
        return this;
    }

    public RecipeSupplier setShapeless(String... lines) {
        this.recipeShape = lines;
        this.isShaped = false;
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
                materials.set(pos++, material);
            }
        }
        return materials;
    }

    public RecipeBuilder build() {
        if (this.isShaped) {
            ShapedRecipeBuilder shapedRecipeBuilder = ShapedRecipeBuilder
                    .shaped(this.recipeOutput.getItem(), this.recipeOutput.getCount())
                    .group(recipeGroup);

            for (String line : this.recipeShape) {
                shapedRecipeBuilder.pattern(line);
            }

            for (HashMap.Entry<Character, Supplier<ItemLike>> entry : this.recipeInputs.getMap().entrySet()) {
                shapedRecipeBuilder.define(entry.getKey(), Ingredient.of(entry.getValue().get()));
            }
            return shapedRecipeBuilder;
        } else {
            ShapelessRecipeBuilder shapelessRecipeBuilder =  ShapelessRecipeBuilder
                    .shapeless(this.recipeOutput.getItem(), this.recipeOutput.getCount())
                    .group(recipeGroup);

            for (HashMap.Entry<Character, Supplier<ItemLike>> entry : this.recipeInputs.getMap().entrySet()) {
                int itemCount = 0;
                for (String line : this.recipeShape) {
                    for (int i =0; i< line.length(); i++) {
                        if (line.charAt(i) == entry.getKey()) {
                            itemCount ++;
                        }
                    }
                }
                shapelessRecipeBuilder.requires(entry.getValue().get(), itemCount);
            }

            return shapelessRecipeBuilder;
        }
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
