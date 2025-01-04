package com.narendra.entity.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingFloor {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;
    private final DisplayBoard displayBoard;

    public ParkingFloor(DisplayBoard displayBoard) {
        this.floorNumber = counter.incrementAndGet();
        this.parkingSpots = new ArrayList<>();
        this.displayBoard = displayBoard;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        parkingSpot.addParkingSpotObserver(displayBoard);
        displayBoard.updateDisplayBoard(parkingSpot.getVehicleType(), parkingSpot.isFree() ? 1 : -1);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
