package com.narendra.entity.vehicle;

public class Vehicle {
    private final String regId;
    private final VehicleType vehicleType;

    public Vehicle(String regId, VehicleType vehicleType) {
        this.regId = regId;
        this.vehicleType = vehicleType;
    }

    public String getRegId() {
        return regId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "regId='" + regId + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
