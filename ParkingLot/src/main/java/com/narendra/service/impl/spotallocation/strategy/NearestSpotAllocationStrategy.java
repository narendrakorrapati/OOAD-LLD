package com.narendra.service.impl.spotallocation.strategy;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingFloor;
import com.narendra.entity.parking.ParkingLot;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.vehicle.VehicleType;
import com.narendra.exception.ParkingLotFullException;

public class NearestSpotAllocationStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType, ParkingLot parkingLot) {
        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if(parkingSpot.isFree()) {
                    return parkingSpot;
                }
            }
        }
        throw new ParkingLotFullException();
    }
}
