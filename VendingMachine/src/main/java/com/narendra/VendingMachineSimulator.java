package com.narendra;

import com.narendra.entity.Cash;
import com.narendra.entity.Product;

import java.util.List;

public class VendingMachineSimulator {

    public static void main(String[] args) {

        VendingMachine vendingMachine = VendingMachine.getInstance();

        testInitialState(vendingMachine);
        testRestockAndInventory(vendingMachine);
        testInitialize(vendingMachine);
        testInsertCash(vendingMachine);
        testCancel(vendingMachine);
    }

    private static void testCancel(VendingMachine vendingMachine) {
        vendingMachine.cancel();
        assert vendingMachine.getState() == vendingMachine.getIdleState() : "State should be idle";
        assert vendingMachine.getTotalInsertedAmount() == 0 : "Total inserted amount should be 0.0";
        System.out.println("Test 5: Passed, cancel() working");
    }

    private static void testInsertCash(VendingMachine vendingMachine) {
        vendingMachine.insertCash(List.of(Cash.TEN, Cash.TWO));
        assert vendingMachine.getState() == vendingMachine.getSelectingProductState() : "Current state should be Selecting Product state";
        assert vendingMachine.getTotalInsertedAmount() == 12 : "Amount should be 12";
        System.out.println("Test 4: Passed, insertCash() working");
    }

    private static void testInitialize(VendingMachine vendingMachine) {
        vendingMachine.initiate();
        assert vendingMachine.getState() == vendingMachine.getAcceptingCashState() : "Current state should be Accepting cash";
        System.out.println("Test 3: Passed, initialize () working");
    }

    private static void testRestockAndInventory(VendingMachine vendingMachine) {
        Product product = new Product("Pepsi", 10, 5);
        vendingMachine.getProductInventory().restock(product);

        assert vendingMachine.getProductInventory().getProductByCode(1) == product : "Product not restocked correctly";
        System.out.println("Test 2: Passed, product restocked successfully");
    }

    private static void testInitialState(VendingMachine vendingMachine) {
        assert vendingMachine.getState() == vendingMachine.getIdleState() : "Initial state should be Idle state";
        System.out.println("Test 1: Passed, initial state is Idle state");
    }
}
