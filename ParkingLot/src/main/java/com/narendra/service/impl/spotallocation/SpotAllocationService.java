package com.narendra.service.impl.spotallocation;

import com.narendra.entity.parking.Entry;
import com.narendra.entity.parking.ParkingSpot;
import com.narendra.entity.vehicle.VehicleType;
import com.narendra.repository.ParkingLotRepository;
import com.narendra.service.contract.spotallocation.ISpotAllocationService;
import com.narendra.service.impl.spotallocation.strategy.SpotAllocationContext;
import com.narendra.service.impl.spotallocation.strategy.SpotAllocationContextFactory;

public class SpotAllocationService implements ISpotAllocationService {

    private final ParkingLotRepository parkingLotRepository;

    public SpotAllocationService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot getFreeParkingSpot(Entry entry, VehicleType vehicleType) {
        SpotAllocationContext spotAllocationContext = SpotAllocationContextFactory.getSpotAllocationContext();
        ParkingSpot parkingSpot = spotAllocationContext.getFreeParkingSpot(entry, vehicleType, parkingLotRepository.getParkingLot());
        System.out.println("Parking spot:" + parkingSpot + " has been selected for vehicle type:" + vehicleType);
        return parkingSpot;
    }
}
