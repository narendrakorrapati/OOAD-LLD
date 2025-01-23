package com.narendra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeVendingMachine {
    private final IngredientInventory ingredientInventory;
    private final Menu menu;
    private Coffee selectedCoffee;
    private double amountPaid;

    public CoffeeVendingMachine() {
        Notification notification = new Notification();
        this.ingredientInventory = new IngredientInventory(notification, 10);
        ingredientInventory.restockIngredient(Ingredient.MILK, 10);
        ingredientInventory.restockIngredient(Ingredient.COFFEE_POWDER, 10);
        ingredientInventory.restockIngredient(Ingredient.SUGAR, 10);
        ingredientInventory.restockIngredient(Ingredient.WATER, 10);

        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(Ingredient.COFFEE_POWDER, 2);
        espressoRecipe.put(Ingredient.MILK, 3);
        espressoRecipe.put(Ingredient.SUGAR, 5);
        espressoRecipe.put(Ingredient.WATER, 2);
        Coffee espresso = new Coffee(CoffeeType.ESPRESSO, 25, espressoRecipe);

        Map<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(Ingredient.COFFEE_POWDER, 2);
        cappuccinoRecipe.put(Ingredient.MILK, 3);
        cappuccinoRecipe.put(Ingredient.SUGAR, 5);
        cappuccinoRecipe.put(Ingredient.WATER, 2);
        Coffee cappuccino = new Coffee(CoffeeType.CAPPUCCINO, 50, cappuccinoRecipe);

        Map<Ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(Ingredient.COFFEE_POWDER, 2);
        latteRecipe.put(Ingredient.MILK, 3);
        latteRecipe.put(Ingredient.SUGAR, 5);
        latteRecipe.put(Ingredient.WATER, 2);
        Coffee latte = new Coffee(CoffeeType.CAPPUCCINO, 40, latteRecipe);

        this.menu = new Menu();

        menu.addCoffee(espresso);
        menu.addCoffee(cappuccino);
        menu.addCoffee(latte);
    }

    public IngredientInventory getIngredientInventory() {
        return ingredientInventory;
    }

    public Menu getMenu() {
        return menu;
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public void setSelectedCoffee(Coffee selectedCoffee) {
        this.selectedCoffee = selectedCoffee;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void selectCoffee(Coffee coffee) {
        if(ingredientInventory.hasSufficientIngredients(coffee.getRecipe())) {
            this.selectedCoffee = coffee;
            System.out.println("You have selected coffee:" + coffee.getCoffeeType());
        } else {
            System.out.println("Insufficient ingredients for Coffee Type:" + coffee.getCoffeeType() + ", please select a different one");
        }
    }

    public boolean makePayment(double amount) {
        this.amountPaid += amount;
        return true;
    }

    public Coffee dispense() {
        if(amountPaid < selectedCoffee.getPrice()) {
            System.out.println("Insufficient funds. Price:" + selectedCoffee.getPrice() + " but paid " + amountPaid + " only");
            return null;
        }

        ingredientInventory.updateIngredients(selectedCoffee.getRecipe());

        System.out.println("Dispensing coffee " + selectedCoffee.getCoffeeType());

        if(amountPaid > selectedCoffee.getPrice()) {
            System.out.println("Dispensing change:" + (amountPaid - selectedCoffee.getPrice()));
        }

        Coffee coffeeToReturn = selectedCoffee;
        selectedCoffee = null;
        amountPaid = 0;

        return coffeeToReturn;
    }
}
