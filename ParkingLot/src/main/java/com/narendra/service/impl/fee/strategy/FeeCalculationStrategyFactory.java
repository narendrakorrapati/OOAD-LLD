package com.narendra.service.impl.fee.strategy;

import com.narendra.entity.vehicle.VehicleType;

public class FeeCalculationStrategyFactory {

    public static FeeCalculationStrategy getFeeCalculationStrategy(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> new TwoWheelerFeeCalculationStrategy(10);
            case FOUR_WHEELER -> new FourWheelerFeeCalculationStrategy(20);
            case HEAVY -> new HeavyWheelerFeeCalculationStrategy(40);
            default -> throw new IllegalArgumentException();
        };
    }
}
