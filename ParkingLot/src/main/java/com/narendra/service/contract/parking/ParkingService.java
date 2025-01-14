package com.narendra.service.contract.parking;

import com.narendra.entity.parking.Exit;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.parking.ParkingTicket;
import com.narendra.entity.vehicle.Vehicle;

public interface ParkingService {
    ParkingTicket occupyParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot);
    void vacateParkingSpot(Exit exit, ParkingTicket parkingTicket);
}
