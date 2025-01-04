package com.narendra.service.impl.fee.strategy.decorator;

import com.narendra.service.impl.fee.strategy.FeeCalculationStrategy;

public class ElectricChargeFeeCalculationStrategyDecorator extends FeeCalculationStrategyDecorator{

    public ElectricChargeFeeCalculationStrategyDecorator(FeeCalculationStrategy feeCalculationStrategy) {
        super(feeCalculationStrategy);
    }
    @Override
    public double calculateFee(int durationInHours) {
        return feeCalculationStrategy.calculateFee(durationInHours) + 40;
    }
}
