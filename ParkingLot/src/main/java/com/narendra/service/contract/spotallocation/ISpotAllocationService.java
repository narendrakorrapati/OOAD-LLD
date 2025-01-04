package com.narendra.service.contract.spotallocation;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.vehicle.VehicleType;

public interface ISpotAllocationService {

    ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType);
}
