package com.narendra.service.impl.fee.strategy;

import com.narendra.entity.vehicle.VehicleType;

public class FeeCalculationContextFactory {

    public static FeeCalculationContext getFeeCalculationContext(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> new FeeCalculationContext(new TwoWheelerFeeCalculationStrategy(10));
            case FOUR_WHEELER -> new FeeCalculationContext(new FourWheelerFeeCalculationStrategy(20));
            case HEAVY -> new FeeCalculationContext(new HeavyWheelerFeeCalculationStrategy(40));
            default -> throw new IllegalArgumentException();
        };
    }
}
