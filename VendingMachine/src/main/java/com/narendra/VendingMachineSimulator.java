package com.narendra;

import com.narendra.entity.Cash;
import com.narendra.entity.Product;

import java.util.List;

public class VendingMachineSimulator {

    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.restock(new Product("Pepsi", 10, 10));
        vendingMachine.restock(new Product("Coke", 20, 20));

        vendingMachine.initiate();
        vendingMachine.insertCash(List.of(Cash.FIVE_RUPEES));
        vendingMachine.selectProduct(1);
        vendingMachine.cancel();

        System.out.println(vendingMachine.getProductInventory());

        System.out.println("Total sale amount:" + vendingMachine.getTotalSaleAmount());
    }
}
