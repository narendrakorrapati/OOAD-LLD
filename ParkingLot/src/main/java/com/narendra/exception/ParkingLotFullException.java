package com.narendra.exception;

import com.narendra.entity.vehicle.VehicleType;

public class ParkingLotFullException extends RuntimeException{

    public ParkingLotFullException(VehicleType vehicleType) {
        System.out.println("No parking spots available for vehicle type:" + vehicleType);
    }
}
