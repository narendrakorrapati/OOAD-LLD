package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;

import java.util.List;

public class EjectingCashState implements State{

    private final VendingMachine vendingMachine;

    public EjectingCashState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public List<Cash> ejectCash() {
        System.out.println("Ejecting cash");
        vendingMachine.setState(vendingMachine.getIdelState());
        return vendingMachine.getTotalCashInserted();
    }
}
