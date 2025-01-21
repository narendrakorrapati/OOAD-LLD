package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Product;

public class CheckingProduct implements State{
    private final VendingMachine vendingMachine;

    public CheckingProduct(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void checkProduct(int productId) {
        Product product = vendingMachine.getProductInventory().getProductByCode(productId);

        if(product == null) {
            this.handleInvalidProduct(productId);
        } else if(product.getQuantity() <= 0) {
            this.handleOutOfStock(productId);
        } else {
            vendingMachine.setState(vendingMachine.getCheckingFundsState());
            vendingMachine.getState().checkFunds(product);
        }
    }

    @Override
    public void handleInvalidProduct(int productId) {
        System.out.println("Selected product is not found in inventory:" + productId + ", select another");
        vendingMachine.setState(vendingMachine.getAcceptingCashState());
    }

    @Override
    public void handleOutOfStock(int productId) {
        System.out.println("Selected product is out of stock:" + productId + ", select another or cancel");
        vendingMachine.setState(vendingMachine.getAcceptingCashState());
    }
}
