package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;
import com.narendra.entity.Product;

import java.util.List;

public class SelectingProductState implements State {
    private final VendingMachine vendingMachine;
    public SelectingProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initiate() {
        System.out.println("Wait for current transaction to complete");
    }

    @Override
    public void insertCash(List<Cash> cash) {
        System.out.println("Can't insert cash, select a product to proceed with dispensing");
    }

    @Override
    public void cancel() {
        vendingMachine.setState(vendingMachine.getReturningCashState());
        vendingMachine.getState().returnCash();
    }

    @Override
    public void returnCash() {
        System.out.println("Cancel to get refund");
    }

    @Override
    public void selectProduct(int code) {
        Product product = vendingMachine.getProductInventory().getProductByCode(code);
        if(product == null || product.getQuantity() == 0) {
            System.out.println("Select product code:" + code + " is out of stock, select another or cancel");
        } else if(product.getPrice() > vendingMachine.getTotalInsertedAmount()) {
            System.out.println("Insufficient funds. Selected product price:" + product.getPrice()
                    + " inserted amount:" + vendingMachine.getTotalInsertedAmount() + " enter additional amount or cancel");
            vendingMachine.setState(vendingMachine.getAcceptingCashState());
        } else {
            vendingMachine.setState(vendingMachine.getDispensingProductState());
            vendingMachine.getState().dispenseProduct(code);
        }
    }

    @Override
    public void dispenseProduct(int code) {
        System.out.println("Select a product to dispense");
    }

    @Override
    public void dispenseChange(double price) {
        System.out.println("Select a product first to calculate change and dispense");
    }
}
