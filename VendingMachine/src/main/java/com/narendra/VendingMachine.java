package com.narendra;

import com.narendra.entity.Cash;
import com.narendra.entity.Product;
import com.narendra.entity.ProductInventory;
import com.narendra.state.*;

import java.util.List;

public class VendingMachine {
    private static final VendingMachine INSTANCE = new VendingMachine();
    private final ProductInventory productInventory;
    private double totalSaleAmount;
    private double totalInsertedAmount;
    private State state;
    private final State idleState;
    private final State acceptingCashState;
    private final State selectingProductState;
    private final State dispensingProductState;
    private final State dispensingChangeState;
    private final State returningCashState;

    private VendingMachine() {
        this.productInventory = new ProductInventory();
        this.idleState = new IdleState(this);
        this.acceptingCashState = new AcceptingCashState(this);
        this.selectingProductState = new SelectingProductState(this);
        this.dispensingProductState = new DispensingProductState(this);
        this.dispensingChangeState = new DispensingChangeState(this);
        this.returningCashState = new ReturningCashState(this);
        this.state = idleState;
    }
    public static VendingMachine getInstance() {
        return INSTANCE;
    }

    public void restock(Product product) {
        productInventory.restock(product);
    }

    public void initiate() {
        state.initiate();
    }

    public void insertCash(List<Cash> cash) {
        state.insertCash(cash);
    }
    public void cancel() {
        state.cancel();
    }

    public void selectProduct(int code) {
        state.selectProduct(code);
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public void setTotalSaleAmount(double totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }

    public void setTotalInsertedAmount(double totalInsertedAmount) {
        this.totalInsertedAmount = totalInsertedAmount;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getTotalInsertedAmount() {
        return totalInsertedAmount;
    }

    public State getIdleState() {
        return idleState;
    }

    public State getAcceptingCashState() {
        return acceptingCashState;
    }

    public State getSelectingProductState() {
        return selectingProductState;
    }

    public State getDispensingProductState() {
        return dispensingProductState;
    }

    public State getDispensingChangeState() {
        return dispensingChangeState;
    }

    public State getReturningCashState() {
        return returningCashState;
    }
}
