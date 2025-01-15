package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;
import com.narendra.entity.Product;

import java.util.List;

public class DispensingProductState implements State {

    private final VendingMachine vendingMachine;

    public DispensingProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initiate() {
        System.out.println("Wait for current transaction to complete");
    }

    @Override
    public void insertCash(List<Cash> cash) {
        System.out.println("Wait for current transaction to complete");
    }

    @Override
    public void cancel() {
        System.out.println("Can't cancel while the product is dispensing");
    }

    @Override
    public void returnCash() {
        System.out.println("Can't process refund while the product is dispensing");
    }

    @Override
    public void selectProduct(int code) {
        System.out.println("Can't select a product while the product is dispensing");
    }

    @Override
    public void dispenseProduct(int code) {
        Product product = vendingMachine.getProductInventory().getProductByCode(code);
        product.decreaseQuantity();
        vendingMachine.setTotalSaleAmount(vendingMachine.getTotalSaleAmount() + product.getPrice());
        vendingMachine.setState(vendingMachine.getDispensingChangeState());
        vendingMachine.getState().dispenseChange(product.getPrice());
    }

    @Override
    public void dispenseChange(double price) {
        System.out.println("Can't dispense change while product is dispensing");
    }
}
