package com.narendra.exception;

public class ParkingFloorNotFoundException extends RuntimeException{
    public ParkingFloorNotFoundException(String s) {
        super(s);
    }
}
