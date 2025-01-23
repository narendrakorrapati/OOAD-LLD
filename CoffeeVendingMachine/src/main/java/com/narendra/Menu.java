package com.narendra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private final List<Coffee> coffees;
    public Menu() {
        this.coffees = new ArrayList<>();
    }
    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }
    public List<Coffee> display() {
        return coffees;
    }
}
