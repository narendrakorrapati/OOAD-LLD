package com.narendra.service.impl.spotallocation;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.parking.SpotAllocationStrategyType;
import com.narendra.entity.vehicle.VehicleType;
import com.narendra.repository.ParkingLotRepository;
import com.narendra.service.contract.spotallocation.ISpotAllocationService;
import com.narendra.service.impl.spotallocation.strategy.SpotAllocationContext;
import com.narendra.service.impl.spotallocation.strategy.SpotAllocationContextFactory;

public class SpotAllocationService implements ISpotAllocationService {

    private final ParkingLotRepository parkingLotRepository;
    private final SpotAllocationContextFactory spotAllocationContextFactory;

    public SpotAllocationService(ParkingLotRepository parkingLotRepository, SpotAllocationContextFactory spotAllocationContextFactory) {
        this.parkingLotRepository = parkingLotRepository;
        this.spotAllocationContextFactory = spotAllocationContextFactory;
    }

    @Override
    public ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType, SpotAllocationStrategyType spotAllocationStrategyType) {
        SpotAllocationContext spotAllocationContext = spotAllocationContextFactory.getSpotAllocationContext(spotAllocationStrategyType);
        ParkingSpot parkingSpot = spotAllocationContext.getFreeParkingSpot(entry, vehicleType, parkingLotRepository.getParkingLot());
        System.out.println("Parking spot:" + parkingSpot + " has been selected for vehicle type:" + vehicleType);
        return parkingSpot;
    }
}
