package com.narendra.entity.parking;

import com.narendra.entity.vehicle.VehicleType;
import com.narendra.observer.ParkingSpotObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingSpot {
    private final String id;
	private final VehicleType vehicleType;
	private boolean isFree;
	private final List<ParkingSpotObserver> parkingSpotObservers;
    public ParkingSpot(VehicleType vehicleType) {
        this.id = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
        this.isFree = true;
        this.parkingSpotObservers = new ArrayList<>();
    }

    public void addParkingSpotObserver(ParkingSpotObserver parkingSpotObserver) {
        this.parkingSpotObservers.add(parkingSpotObserver);
    }

    public boolean removeParkingSpotObserver(ParkingSpotObserver parkingSpotObserver) {
        return this.parkingSpotObservers.remove(parkingSpotObserver);
    }
    public String getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
        notifyObservers(isFree ? 1 : -1);
    }
    private void notifyObservers(int count) {
        for(ParkingSpotObserver parkingSpotObserver : parkingSpotObservers) {
            parkingSpotObserver.updateDisplayBoard(vehicleType, count);
        }
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id='" + id + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
