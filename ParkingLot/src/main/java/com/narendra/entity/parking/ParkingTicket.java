package com.narendra.entity.parking;

import com.narendra.entity.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {

    private final String id;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime enteredDateTime;
    private LocalDateTime exitedDateTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.enteredDateTime = LocalDateTime.now().minusHours(1);//To simulate fee computation for 1hour
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEnteredDateTime() {
        return enteredDateTime;
    }

    public LocalDateTime getExitedDateTime() {
        return exitedDateTime;
    }

    public void setExitedDateTime(LocalDateTime exitedDateTime) {
        this.exitedDateTime = exitedDateTime;
    }
    @Override
    public String toString() {
        return "ParkingTicket{" +
                "id='" + id + '\'' +
                ", enteredDateTime=" + enteredDateTime +
                '}';
    }
}
