package com.narendra.service.impl.fee;

import com.narendra.entity.parking.ParkingTicket;
import com.narendra.service.contract.fee.IFeeCalculationService;
import com.narendra.service.impl.fee.strategy.FeeCalculationContextFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FeeCalculationService implements IFeeCalculationService {
    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime enteredDateTime = parkingTicket.getEnteredDateTime();
        int durationInHours = (int)ChronoUnit.HOURS.between(enteredDateTime, currentTime);
        double amount = FeeCalculationContextFactory.getFeeCalculationContext(
                parkingTicket.getVehicle().getVehicleType()).calculateFee(durationInHours);

        System.out.println("Fee amount for parking ticket" + parkingTicket + " is " + amount);
        return amount;
    }
}
