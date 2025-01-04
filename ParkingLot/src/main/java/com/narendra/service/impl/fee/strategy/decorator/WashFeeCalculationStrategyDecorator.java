package com.narendra.service.impl.fee.strategy.decorator;

import com.narendra.service.impl.fee.strategy.FeeCalculationStrategy;

public class WashFeeCalculationStrategyDecorator extends FeeCalculationStrategyDecorator{

    public WashFeeCalculationStrategyDecorator(FeeCalculationStrategy feeCalculationStrategy) {
        super(feeCalculationStrategy);
    }
    @Override
    public double calculateFee(int durationInHours) {
        return feeCalculationStrategy.calculateFee(durationInHours) + 50;
    }
}
