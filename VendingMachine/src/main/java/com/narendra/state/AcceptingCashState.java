package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;

import java.util.List;

public class AcceptingCashState implements State{
    private final VendingMachine vendingMachine;

    public AcceptingCashState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCash(Cash cash) {
        vendingMachine.addCash(cash);
    }
    @Override
    public List<Cash> cancel() {
        vendingMachine.setState(vendingMachine.getEjectingCashState());
        return vendingMachine.getState().ejectCash();
    }

    @Override
    public void productSelected(int productId) {
        //CheckingProductState transition
        vendingMachine.setState(vendingMachine.getCheckingProductState());
        vendingMachine.getState().checkProduct(productId);
    }
}
