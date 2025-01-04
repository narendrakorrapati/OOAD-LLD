package com.narendra.entity.payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentTransaction {
    private final String refId;
    private final PaymentStatus paymentStatus;
    private final LocalDateTime transactionDateTime;
    private final double amount;

    public PaymentTransaction(PaymentStatus paymentStatus, LocalDateTime transactionDateTime, double amount) {
        this.refId = UUID.randomUUID().toString();
        this.paymentStatus = paymentStatus;
        this.transactionDateTime = transactionDateTime;
        this.amount = amount;
    }

    public String getRefId() {
        return refId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "PaymentTransaction{" +
                "refId='" + refId + '\'' +
                '}';
    }
}
