package com.narendra.controller;

import com.narendra.entity.parking.Exit;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.parking.ParkingTicket;
import com.narendra.entity.vehicle.Vehicle;
import com.narendra.service.contract.parking.IParkingService;

public class ParkingController {
    private final IParkingService parkingService;

    public ParkingController(IParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public ParkingTicket occupyParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        return parkingService.occupyParkingSpot(vehicle, parkingSpot);
    }

    public void vacateParkingSpot(Exit exit, ParkingTicket parkingTicket) {
        //Validate if payment transaction is success for the ticket
        parkingService.vacateParkingSpot(exit, parkingTicket);
    }
}
