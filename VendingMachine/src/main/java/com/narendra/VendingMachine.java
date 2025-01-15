package com.narendra;

import com.narendra.entity.Cash;
import com.narendra.entity.Product;
import com.narendra.entity.ProductInventory;
import com.narendra.entity.State;

import java.util.List;

public class VendingMachine {
    private static final VendingMachine INSTANCE = new VendingMachine();
    private final ProductInventory productInventory;
    private double totalSaleAmount;
    private State state;
    private double totalInsertedAmount;
    private VendingMachine() {
        this.state = State.IDLE;
        productInventory = new ProductInventory();
    }
    public static VendingMachine getInstance() {
        return INSTANCE;
    }

    public void restock(Product product) {
        productInventory.restock(product);
    }

    public void initiate() {
        if(state == State.IDLE) {
            this.totalInsertedAmount = 0;
            this.state = State.ACCEPTING_CASH;
            System.out.println("Getting ready Accepting Cash");
        } else {
            throw new IllegalStateException("Transaction Initiation is not supported in state:" + state);
        }
    }

    public void insertCash(List<Cash> cash) {
        switch (state) {
            case IDLE:
                throw new IllegalStateException("Initiate the transaction to insert cash");
            case ACCEPTING_CASH:
                this.totalInsertedAmount = cash.stream().mapToDouble(Cash::getValue).sum();
                System.out.println("Cash inserted successfully:" + totalInsertedAmount);
                this.state = State.SELECTING_PRODUCT;
                break;
            case RETURNING_CASH:
                throw new IllegalStateException("Please wait while your refund is processed");
            case SELECTING_PRODUCT:
                throw new IllegalStateException("Cash cannot be inserted now. Please select a product");
            case DISPENSING_PRODUCT:
                throw new IllegalStateException("Cash cannot be inserted now. Wait a while for product to dispense");
            case DISPENSING_CHANGE:
                throw new IllegalStateException("Cash cannot be inserted now. Wait a while for change to dispense");
        }
    }
    public void cancel() {
        switch (state) {
            case IDLE:
                throw new IllegalStateException("No transaction is active to cancel");
            case ACCEPTING_CASH, SELECTING_PRODUCT:
                state = State.RETURNING_CASH;
                returnCash();
                break;
            case RETURNING_CASH:
                throw new IllegalStateException("Please wait while your refund is processed");
            case DISPENSING_PRODUCT:
                throw new IllegalStateException("Can't cancel right now, please wait a while your product is dispensed");
            case DISPENSING_CHANGE:
                throw new IllegalStateException("Can't cancel right now, please wait a while your change is dispensed");
        }
    }

    private void returnCash() {
        switch (state) {
            case IDLE:
                throw new IllegalStateException("Can't return cash while in Idle state");
            case ACCEPTING_CASH:
                throw new IllegalStateException("Can't accept cash now while giving you the refund");
            case RETURNING_CASH:
                this.state = State.IDLE;
                System.out.println("Returning the cash:" + totalInsertedAmount);
                this.totalInsertedAmount = 0;
                break;
            case SELECTING_PRODUCT:
                this.state = State.RETURNING_CASH;
                returnCash();
                break;
            case DISPENSING_PRODUCT:
                throw new IllegalStateException("Can't cancel right now, please wait a while your product is dispensed");
            case DISPENSING_CHANGE:
                throw new IllegalStateException("Can't cancel right now, please wait a while your change is dispensed");
        }
    }

    public void selectProduct(int code) {
        switch (state) {
            case IDLE:
                throw new IllegalStateException("Can't select product in Idle state");
            case ACCEPTING_CASH:
                throw new IllegalStateException("Can't accept cash now while selecting a product");
            case RETURNING_CASH:
                throw new IllegalStateException("Can't refund while select a product");
            case SELECTING_PRODUCT:
                Product product = productInventory.getProductByCode(code);
                if(product == null || product.getQuantity() == 0) {
                    System.out.println("Selected product:" + code + " is out of stock, select another or cancel");
                } else if(product.getPrice() > totalInsertedAmount){
                    insufficientFunds(product);
                } else {
                    System.out.println("Selected the product:" + code);
                    this.state = State.DISPENSING_PRODUCT;
                    dispenseProduct(code);
                }
                break;
            case DISPENSING_PRODUCT:
                throw new IllegalStateException("Can't cancel right now, please wait a while your product is dispensed");
            case DISPENSING_CHANGE:
                throw new IllegalStateException("Can't cancel right now, please wait a while your change is dispensed");
        }
    }

    private void insufficientFunds(Product product) {
        System.out.println("Insufficient amount. Total inserted amount:" + totalInsertedAmount
                + ", product price:" + product.getPrice() + ", Insert additional amount or cancel");
        this.state = State.ACCEPTING_CASH;
    }

    private void dispenseProduct(int code) {
        switch (state) {
            case IDLE:
                throw new IllegalStateException("Can't dispense product in Idle state");
            case ACCEPTING_CASH:
                throw new IllegalStateException("Can't accept cash now while product is dispensing");
            case RETURNING_CASH:
                throw new IllegalStateException("Can't refund while product is dispensing");
            case SELECTING_PRODUCT:
                throw new IllegalStateException("Can't select product while a product is dispensing");
            case DISPENSING_PRODUCT:
                Product product = productInventory.getProductByCode(code);
                product.decreaseQuantity();
                System.out.println("Dispensed the product:" + product);
                state = State.DISPENSING_CHANGE;
                dispenseChange(product);
                break;
            case DISPENSING_CHANGE:
                throw new IllegalStateException("Can't cancel right now, please wait a while your change is dispensed");
        }
    }

    private void dispenseChange(Product product) {
        switch (state) {
            case IDLE:
                throw new IllegalStateException("Can't dispense change in Idle state");
            case ACCEPTING_CASH:
                throw new IllegalStateException("Can't accept cash now while change is dispensing");
            case RETURNING_CASH:
                throw new IllegalStateException("Can't refund while change is dispensing");
            case SELECTING_PRODUCT:
                throw new IllegalStateException("Can't select product while a change is dispensing");
            case DISPENSING_PRODUCT:
                throw new IllegalStateException("Can't dispense product while a change is dispensing");
            case DISPENSING_CHANGE:
                double change = totalInsertedAmount - product.getPrice();
                if(change > 0.0) {
                    System.out.println("Dispensing change:" + change);
                }
                this.totalSaleAmount += product.getPrice();
                state = State.IDLE;
                break;
        }
    }
    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }
}
