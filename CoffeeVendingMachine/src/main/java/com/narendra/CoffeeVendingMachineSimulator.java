package com.narendra;

import java.util.List;

public class CoffeeVendingMachineSimulator {
    public static void main(String[] args) {
        CoffeeVendingMachine coffeeVendingMachine = new CoffeeVendingMachine();

        List<Coffee> menu = coffeeVendingMachine.getMenu().display();
        System.out.println(menu);

        coffeeVendingMachine.selectCoffee(menu.get(0));

        coffeeVendingMachine.makePayment(50);
        coffeeVendingMachine.dispense();

    }
}
