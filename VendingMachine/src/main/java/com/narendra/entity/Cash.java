package com.narendra.entity;

public enum Cash {
    ONE_RUPEE(1),
	TWO_RUPEES(2),
	FIVE_RUPEES(5),
	TEN_RUPEES(10),
	TWENTY_RUPEES(20),
	FIFTY_RUPEES(50),
	ONE_HUNDRED_RUPEES(100),
	TWO_HUNDRED_RUPEES(200),
	FIVE_HUNDRED_RUPEES(500);
    private final double value;
    Cash(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;
    }
}
