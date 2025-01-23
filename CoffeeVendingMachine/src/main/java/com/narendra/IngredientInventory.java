package com.narendra;

import java.util.HashMap;
import java.util.Map;

public class IngredientInventory {
    private final Map<Ingredient, Integer> ingredientQuantityMap;
    private final Notification notification;
    private int thresholdForNotification;

    public IngredientInventory(Notification notification, int thresholdForNotification) {
        this.ingredientQuantityMap = new HashMap<>();
        this.notification = notification;
        this.thresholdForNotification = thresholdForNotification;
    }

    public void restockIngredient(Ingredient ingredient, Integer quantity) {
        ingredientQuantityMap.put(ingredient, quantity);
    }

    public void updateIngredients(Map<Ingredient, Integer> recipe) {
        Map<Ingredient, Integer> belowThreshold = new HashMap<>();

        for(Ingredient ingredient : recipe.keySet()) {
            ingredientQuantityMap.put(ingredient, ingredientQuantityMap.get(ingredient) - recipe.get(ingredient));
            if(ingredientQuantityMap.get(ingredient) < thresholdForNotification) {
                belowThreshold.put(ingredient, ingredientQuantityMap.get(ingredient));
            }
        }

        notification.notify(belowThreshold);
    }

    public int getThresholdForNotification() {
        return thresholdForNotification;
    }

    public void setThresholdForNotification(int thresholdForNotification) {
        this.thresholdForNotification = thresholdForNotification;
    }

    public boolean hasSufficientIngredients(Map<Ingredient, Integer> recipe) {
        for(Ingredient ingredient: recipe.keySet()) {
            if(ingredientQuantityMap.get(ingredient) < recipe.get(ingredient)) {
                return false;
            }
        }

        return true;
    }
}
