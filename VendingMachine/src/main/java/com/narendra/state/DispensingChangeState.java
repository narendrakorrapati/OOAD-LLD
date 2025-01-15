package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;

import java.util.List;

public class DispensingChangeState implements State {

    private final VendingMachine vendingMachine;

    public DispensingChangeState(VendingMachine vendingMachine) {
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
        System.out.println("Can't cancel while the change is dispensing");
    }

    @Override
    public void returnCash() {
        System.out.println("Can't refund while the change is dispensing");
    }

    @Override
    public void selectProduct(int code) {
        System.out.println("Can't select a product while the change is dispensing");
    }

    @Override
    public void dispenseProduct(int code) {
        System.out.println("Can't dispense product while the change is dispensing");
    }

    @Override
    public void dispenseChange(double price) {
        double change = vendingMachine.getTotalInsertedAmount() - price;
        System.out.println("Dispensing a change of:" + change);
        vendingMachine.setState(vendingMachine.getState());
    }
}
