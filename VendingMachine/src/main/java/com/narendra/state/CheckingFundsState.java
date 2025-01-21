package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;
import com.narendra.entity.Product;

public class CheckingFundsState implements State{

    private final VendingMachine vendingMachine;

    public CheckingFundsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void checkFunds(Product product) {
        double totalCash = vendingMachine.getTotalCashInserted().stream().mapToDouble(Cash::getValue).sum();
        if(totalCash < product.getPrice()) {
            this.handleInsufficientFunds(product.getPrice(), totalCash);
        } else {
            vendingMachine.setState(vendingMachine.getDispensingProductState());
            vendingMachine.getState().dispenseProduct(product);
        }
    }

    @Override
    public void handleInsufficientFunds(double price, double cash) {
        System.out.println("Insufficient funds. Actual price is " + price + " but has cash " + cash + ". Insert more cash");
        vendingMachine.setState(vendingMachine.getAcceptingCashState());
    }
}
