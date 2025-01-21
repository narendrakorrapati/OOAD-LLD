package com.narendra;

import com.narendra.entity.Cash;
import com.narendra.entity.Product;

import java.util.List;

public class VendingMachineSimulator {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.getProductInventory().restock(new Product("Pepsi", 10.0, 1));
        vendingMachine.getProductInventory().restock(new Product("Coke", 11.0, 10));

        vendingMachine.insertCash(Cash.TEN);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        vendingMachine.productSelected(1);
    }
}
