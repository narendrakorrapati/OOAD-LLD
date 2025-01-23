package com.narendra;

import java.util.Map;

public class Coffee {
    private final CoffeeType coffeeType;
    private double price;
    private final Map<Ingredient, Integer> recipe;

    public Coffee(CoffeeType coffeeType, double price, Map<Ingredient, Integer> recipe) {
        this.coffeeType = coffeeType;
        this.price = price;
        this.recipe = recipe;
    }

    public void updateIngredient(Ingredient ingredient, Integer quantity) {
        recipe.put(ingredient, quantity);
    }

    public void removeIngredient(Ingredient ingredient) {
        recipe.remove(ingredient);
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeType=" + coffeeType +
                ", price=" + price +
                '}';
    }
}
