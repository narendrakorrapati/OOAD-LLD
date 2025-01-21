package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;

import java.util.ArrayList;

public class IdleState implements State{
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCash(Cash cash) {
        vendingMachine.setTotalCashInserted(new ArrayList<>());
        vendingMachine.setState(vendingMachine.getAcceptingCashState());
        vendingMachine.getState().insertCash(cash);
    }
}
