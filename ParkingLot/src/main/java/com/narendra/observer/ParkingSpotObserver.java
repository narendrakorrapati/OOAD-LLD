package com.narendra.observer;

import com.narendra.entity.vehicle.VehicleType;

public interface ParkingSpotObserver {
    void updateDisplayBoard(VehicleType vehicleType, int count);
}
