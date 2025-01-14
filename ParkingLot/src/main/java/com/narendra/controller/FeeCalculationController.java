package com.narendra.controller;

import com.narendra.entity.parking.ParkingTicket;
import com.narendra.service.contract.fee.FeeCalculationService;

public class FeeCalculationController {

    private final FeeCalculationService feeCalculationService;

    public FeeCalculationController(FeeCalculationService feeCalculationService) {
        this.feeCalculationService = feeCalculationService;
    }

    public double calculateFee(ParkingTicket parkingTicket) {
        return feeCalculationService.calculateFee(parkingTicket);
    }
}
