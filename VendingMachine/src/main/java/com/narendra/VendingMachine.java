package com.narendra;

import com.narendra.entity.Cash;
import com.narendra.entity.ProductInventory;
import com.narendra.state.*;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private final ProductInventory productInventory;
    private List<Cash> totalCashInserted;
    private State state;
    private final State idelState;
    private final State acceptingCashState;
    private final State checkingProductState;
    private final State checkingFundsState;
    private final State dispensingProductState;
    private final State ejectingCashState;

    public VendingMachine() {
        totalCashInserted = new ArrayList<>();
        idelState = new IdleState(this);
        acceptingCashState = new AcceptingCashState(this);
        checkingProductState = new CheckingProduct(this);
        checkingFundsState = new CheckingFundsState(this);
        dispensingProductState = new DispensingProductState(this);
        ejectingCashState = new EjectingCashState(this);
        this.state = idelState;
        this.productInventory = new ProductInventory();
    }

    public void addCash(Cash cash) {
        totalCashInserted.add(cash);
    }

    public State getIdelState() {
        return idelState;
    }

    public State getAcceptingCashState() {
        return acceptingCashState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Cash> getTotalCashInserted() {
        return totalCashInserted;
    }

    public void setTotalCashInserted(List<Cash> totalCashInserted) {
        this.totalCashInserted = totalCashInserted;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

    public State getCheckingProductState() {
        return checkingProductState;
    }

    public State getCheckingFundsState() {
        return checkingFundsState;
    }

    public State getDispensingProductState() {
        return dispensingProductState;
    }

    public State getEjectingCashState() {
        return ejectingCashState;
    }

    public void insertCash(Cash cash) {
        state.insertCash(cash);
    }

    public void productSelected(int productId) {
        state.productSelected(productId);
    }

    public List<Cash> cancel() {
        return state.cancel();
    }
}
