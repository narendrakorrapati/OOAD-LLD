package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;
import com.narendra.entity.Product;

public class DispensingProductState implements State{

    private final VendingMachine vendingMachine;

    public DispensingProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void dispenseProduct(Product product) {
        System.out.println("Dispensing product:" + product.getName());
        product.decreaseQuantity();
        double totalCash = vendingMachine.getTotalCashInserted().stream().mapToDouble(Cash::getValue).sum();

        if(totalCash > product.getPrice()) {
            System.out.println("Dispensing change:" + (totalCash - product.getPrice()));
        }
        vendingMachine.setState(vendingMachine.getIdelState());
    }
}
