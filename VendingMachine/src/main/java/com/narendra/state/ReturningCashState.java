package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;

import java.util.List;

public class ReturningCashState implements State {

    private final VendingMachine vendingMachine;

    public ReturningCashState(VendingMachine vendingMachine) {
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
        System.out.println("Already giving refund, wait a while");
    }

    @Override
    public void returnCash() {
        System.out.println("Returning the cash:" + vendingMachine.getTotalInsertedAmount());
        vendingMachine.setTotalInsertedAmount(0);
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    @Override
    public void selectProduct(int code) {
        System.out.println("Can't select a product now, wait a while for refund");
    }

    @Override
    public void dispenseProduct(int code) {
        System.out.println("Can't dispense a product now, wait a while for refund");
    }

    @Override
    public void dispenseChange(double price) {
        System.out.println("Can't dispense change now, wait a while for refund");
    }
}
