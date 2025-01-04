package com.narendra.service.impl.fee.strategy;

public class FourWheelerFeeCalculationStrategy implements FeeCalculationStrategy{
    private final double feePerHour;

    public FourWheelerFeeCalculationStrategy(double feePerHour) {
        this.feePerHour = feePerHour;
    }

    @Override
    public double calculateFee(int durationInHours) {
        return feePerHour * durationInHours;
    }
}
