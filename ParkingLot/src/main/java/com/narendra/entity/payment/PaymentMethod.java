package com.narendra.entity.payment;

public abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
