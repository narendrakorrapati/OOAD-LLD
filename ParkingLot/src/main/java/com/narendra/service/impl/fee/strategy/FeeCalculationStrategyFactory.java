package com.narendra.service.impl.fee.strategy;

import com.narendra.entity.vehicle.VehicleType;

/**
 * Singleton is not necessary if we are using spring DI.
 */
public class FeeCalculationStrategyFactory {
    private static final FeeCalculationStrategyFactory INSTANCE = new FeeCalculationStrategyFactory();
    private FeeCalculationStrategyFactory()  {
    }

    public static FeeCalculationStrategyFactory getInstance() {
        return INSTANCE;
    }

    public FeeCalculationStrategy getFeeCalculationStrategy(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> new TwoWheelerFeeCalculationStrategy(10);
            case FOUR_WHEELER -> new FourWheelerFeeCalculationStrategy(20);
            case HEAVY -> new HeavyWheelerFeeCalculationStrategy(40);
            default -> throw new IllegalArgumentException();
        };
    }
}
