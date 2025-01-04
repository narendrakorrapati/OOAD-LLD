package com.narendra.entity.payment;

public class CardPaymentMethod extends PaymentMethod{
    private final CardDetails cardDetails;
    public CardPaymentMethod(double amount, CardDetails cardDetails) {
        super(amount);
        this.cardDetails = cardDetails;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }
}
