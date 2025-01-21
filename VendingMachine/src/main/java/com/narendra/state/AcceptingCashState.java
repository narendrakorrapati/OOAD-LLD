package com.narendra.state;

import com.narendra.VendingMachine;
import com.narendra.entity.Cash;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AcceptingCashState implements State{
    private final VendingMachine vendingMachine;
    private Timer timer;

    public AcceptingCashState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCash(Cash cash) {
        resetTimer();
        vendingMachine.addCash(cash);
    }
    @Override
    public List<Cash> cancel() {
        cancelTimer();
        vendingMachine.setState(vendingMachine.getEjectingCashState());
        return vendingMachine.getState().ejectCash();
    }

    @Override
    public void productSelected(int productId) {
        cancelTimer();
        //CheckingProductState transition
        vendingMachine.setState(vendingMachine.getCheckingProductState());
        vendingMachine.getState().checkProduct(productId);
    }

    @Override
    public void timeout() {
        System.out.println("timeout occurred");
        cancel();
    }
    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimeoutTask(), 5000); // 5 seconds timeout
    }

    private void resetTimer() {
        cancelTimer();
        startTimer();
    }

    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge(); // Remove cancelled tasks from the timer's queue
            timer = null;
        }
    }
    private class TimeoutTask extends TimerTask {
        @Override
        public void run() {
            timeout();
        }
    }
}
