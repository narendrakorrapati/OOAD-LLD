package com.narendra.service.impl.fee.strategy;

public class FeeCalculationContext {

    private final FeeCalculationStrategy feeCalculationStrategy;

    public FeeCalculationContext(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }

    public double calculateFee(int durationInHours) {
        return feeCalculationStrategy.calculateFee(durationInHours);
    }
}
