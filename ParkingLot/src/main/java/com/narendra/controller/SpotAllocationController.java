package com.narendra.controller;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.parking.SpotAllocationStrategyType;
import com.narendra.entity.vehicle.VehicleType;
import com.narendra.service.contract.spotallocation.SpotAllocationService;

public class SpotAllocationController {
    private final SpotAllocationService spotAllocationService;

    public SpotAllocationController(SpotAllocationService spotAllocationService) {
        this.spotAllocationService = spotAllocationService;
    }
    /*
      Enforce role based checking
     */
    public ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType, SpotAllocationStrategyType spotAllocationStrategyType) {
        return spotAllocationService.getFreeParkingSpot(entry, vehicleType, spotAllocationStrategyType);
    }
}
