package com.narendra.entity.parking;

import com.narendra.entity.vehicle.VehicleType;
import com.narendra.observer.ParkingSpotObserver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DisplayBoard implements ParkingSpotObserver {
    private final Map<VehicleType, Integer> freeSpots;

    public DisplayBoard() {
        this.freeSpots = new ConcurrentHashMap<>();

        for(VehicleType vehicleType : VehicleType.values()) {
            freeSpots.put(vehicleType, 0);
        }
    }

    @Override
    public void updateDisplayBoard(VehicleType vehicleType, int count) {
        addOrUpdateVehicleType(vehicleType, count);
        displayFreeSpots();
    }

    public void addOrUpdateVehicleType(VehicleType vehicleType, int count) {
        freeSpots.put(vehicleType, freeSpots.getOrDefault(vehicleType, 0) + count);
    }

    public void displayFreeSpots() {
        System.out.println(freeSpots);
    }
}
