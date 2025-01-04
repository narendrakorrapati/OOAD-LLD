package com.narendra.service.impl.spotallocation.strategy;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingLot;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.vehicle.VehicleType;

public class SpotAllocationContext {
    private SpotAllocationStrategy spotAllocationStrategy;

    public SpotAllocationContext(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType, ParkingLot parkingLot) {
        return spotAllocationStrategy.getFreeParkingSpot(entry, vehicleType, parkingLot);
    }
}
