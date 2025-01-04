package com.narendra.entity.payment;

public class CardDetails {

    private final int cvv;
    private final String cardNum;
    private final String nameOnCard;

    public CardDetails(int cvv, String cardNum, String nameOnCard) {
        this.cvv = cvv;
        this.cardNum = cardNum;
        this.nameOnCard = nameOnCard;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }
}
