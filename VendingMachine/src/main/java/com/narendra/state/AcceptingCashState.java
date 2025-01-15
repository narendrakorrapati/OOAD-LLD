package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;

import java.util.List;

public class AcceptingCashState implements State {

    private final VendingMachine vendingMachine;

    public AcceptingCashState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initiate() {
        System.out.println("Wait for current transaction to complete");
    }

    @Override
    public void insertCash(List<Cash> cash) {
        vendingMachine.setTotalInsertedAmount(cash.stream().mapToDouble(Cash::getValue).sum());
        System.out.println("Total amount inserted:" + vendingMachine.getTotalInsertedAmount());
        vendingMachine.setState(vendingMachine.getSelectingProductState());
    }

    @Override
    public void cancel() {
        vendingMachine.setState(vendingMachine.getReturningCashState());
        vendingMachine.getState().returnCash();
    }

    @Override
    public void returnCash() {
        System.out.println("Please cancel the transaction to get refund");
    }

    @Override
    public void selectProduct(int code) {
        System.out.println("Insert cash to select a product");
    }

    @Override
    public void dispenseProduct(int code) {
        System.out.println("You have not inserted cash");
    }

    @Override
    public void dispenseChange(double price) {
        System.out.println("You have not inserted cash");
    }
}
