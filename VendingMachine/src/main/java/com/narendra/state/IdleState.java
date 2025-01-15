package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;

import java.util.List;

public class IdleState implements State {

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initiate() {
        vendingMachine.setState(vendingMachine.getAcceptingCashState());
        vendingMachine.setTotalInsertedAmount(0);
        System.out.println("Initiated the transaction");
    }

    @Override
    public void insertCash(List<Cash> cash) {
        System.out.println("Can't take cash in idle state");
    }

    @Override
    public void cancel() {
        System.out.println("No active transaction to cancel in idle state");
    }

    @Override
    public void returnCash() {
        System.out.println("No cash to return in idle state");
    }

    @Override
    public void selectProduct(int code) {
        System.out.println("Can't select a product in idle state");
    }

    @Override
    public void dispenseProduct(int code) {
        System.out.println("Can't dispense a product in idle state");
    }

    @Override
    public void dispenseChange(double price) {
        System.out.println("Can't dispense change in idle state");
    }
}
