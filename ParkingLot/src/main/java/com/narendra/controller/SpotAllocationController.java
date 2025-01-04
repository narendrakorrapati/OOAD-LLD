package com.narendra.controller;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.vehicle.VehicleType;
import com.narendra.service.contract.spotallocation.ISpotAllocationService;

public class SpotAllocationController {
    private final ISpotAllocationService spotAllocationService;

    public SpotAllocationController(ISpotAllocationService spotAllocationService) {
        this.spotAllocationService = spotAllocationService;
    }
    /*
      Enforce role based checking
     */
    public ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType) {
        return spotAllocationService.getFreeParkingSpot(entry, vehicleType);
    }
}
