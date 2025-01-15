package com.narendra.entity;

public enum Cash {
    ONE(1),
	TWO(2),
	FIVE(5),
	TEN(10),
	TWENTY(20),
	FIFTY(50),
	ONE_HUNDRED(100),
	TWO_HUNDRED(200),
	FIVE_HUNDRED(500);
    private final double value;
    Cash(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;
    }
}
