package com.narendra.service.impl.parking;

import com.narendra.entity.parking.Exit;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.parking.ParkingTicket;
import com.narendra.entity.vehicle.Vehicle;
import com.narendra.exception.ParkingSpotAlreadyOccupiedException;
import com.narendra.service.contract.parking.IParkingService;

import java.time.LocalDateTime;

public class ParkingService implements IParkingService {
    @Override
    public synchronized ParkingTicket occupyParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        if(!parkingSpot.isFree()) {
            throw new ParkingSpotAlreadyOccupiedException();
        }
        parkingSpot.setFree(false);
        ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot);
        System.out.println("Parking Ticket:" + parkingTicket + " has been generated for vehicle:" + vehicle);
        return parkingTicket;
    }

    @Override
    public void vacateParkingSpot(Exit exit, ParkingTicket parkingTicket) {
        parkingTicket.setExitedDateTime(LocalDateTime.now());
        parkingTicket.getParkingSpot().setFree(true);
    }
}
