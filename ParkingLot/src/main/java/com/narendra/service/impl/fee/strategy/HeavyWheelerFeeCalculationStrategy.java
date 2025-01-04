package com.narendra.service.impl.fee.strategy;

public class HeavyWheelerFeeCalculationStrategy implements FeeCalculationStrategy{
    private final double feePerHour;

    public HeavyWheelerFeeCalculationStrategy(double feePerHour) {
        this.feePerHour = feePerHour;
    }

    @Override
    public double calculateFee(int durationInHours) {
        return feePerHour * durationInHours;
    }
}
