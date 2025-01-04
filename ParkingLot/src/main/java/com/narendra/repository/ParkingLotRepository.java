package com.narendra.repository;

import com.narendra.entity.parking.ParkingLot;

public class ParkingLotRepository {

    private final ParkingLot parkingLot;

    public ParkingLotRepository(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
