package com.narendra.service.impl.spotallocation.strategy;

import com.narendra.entity.parking.SpotAllocationStrategyType;

/**
 * Singleton is not necessary if we are using spring DI.
 */
public class SpotAllocationContextFactory {
    private static final SpotAllocationContextFactory INSTANCE = new SpotAllocationContextFactory();

    private SpotAllocationContextFactory() {
    }
    public static SpotAllocationContextFactory getInstance() {
        return INSTANCE;
    }
    public SpotAllocationContext getSpotAllocationContext(SpotAllocationStrategyType spotAllocationStrategyType) {
        return switch (spotAllocationStrategyType) {
            case NEAREST -> new SpotAllocationContext(new NearestSpotAllocationStrategy());
        };
    }
}
