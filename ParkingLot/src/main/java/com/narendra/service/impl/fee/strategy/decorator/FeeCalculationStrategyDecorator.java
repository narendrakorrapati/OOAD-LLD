package com.narendra.service.impl.fee.strategy.decorator;

import com.narendra.service.impl.fee.strategy.FeeCalculationStrategy;

public abstract class FeeCalculationStrategyDecorator implements FeeCalculationStrategy {

    protected FeeCalculationStrategy feeCalculationStrategy;

    public FeeCalculationStrategyDecorator(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }
}
