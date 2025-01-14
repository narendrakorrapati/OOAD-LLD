package com.narendra.service.contract.spotallocation;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.parking.SpotAllocationStrategyType;
import com.narendra.entity.vehicle.VehicleType;

public interface SpotAllocationService {

    ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType, SpotAllocationStrategyType spotAllocationStrategyType);
}
