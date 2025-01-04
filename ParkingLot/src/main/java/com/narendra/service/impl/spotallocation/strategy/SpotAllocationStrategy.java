package com.narendra.service.impl.spotallocation.strategy;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingLot;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.vehicle.VehicleType;

public interface SpotAllocationStrategy {
    ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType, ParkingLot parkingLot);
}
