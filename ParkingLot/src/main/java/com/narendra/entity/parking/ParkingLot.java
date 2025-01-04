package com.narendra.entity.parking;

import com.narendra.entity.common.Address;
import com.narendra.exception.ParkingFloorNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private final String id;
    private final Address address;
    private final List<ParkingFloor> parkingFloors;
    private final List<Entry> entries;
    private final List<Exit> exits;

    public ParkingLot(Address address) {
        this.id = UUID.randomUUID().toString();
        this.address = address;
        this.parkingFloors = new ArrayList<>();
        this.entries = new ArrayList<>();
        this.exits = new ArrayList<>();
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloors.add(parkingFloor);
    }

    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }

    public ParkingFloor getParkingFloor(ParkingSpot parkingSpot) {
        for(ParkingFloor parkingFloor : parkingFloors) {
            if(parkingFloor.getParkingSpots().contains(parkingSpot)) {
                return parkingFloor;
            }
        }
        throw  new ParkingFloorNotFoundException("Can't find Floor for Parking Spot" + parkingSpot);
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public List<Exit> getExits() {
        return exits;
    }
}
