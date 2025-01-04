package com.narendra.service.impl.spotallocation.strategy;

public class SpotAllocationContextFactory {
    public static SpotAllocationContext getSpotAllocationContext() {
        return new SpotAllocationContext(new NearestSpotAllocationStrategy());
    }
}
