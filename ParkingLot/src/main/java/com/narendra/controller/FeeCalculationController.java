package com.narendra.controller;

import com.narendra.entity.parking.ParkingTicket;
import com.narendra.service.contract.fee.IFeeCalculationService;

public class FeeCalculationController {

    private final IFeeCalculationService feeCalculationService;

    public FeeCalculationController(IFeeCalculationService feeCalculationService) {
        this.feeCalculationService = feeCalculationService;
    }

    public double calculateFee(ParkingTicket parkingTicket) {
        return feeCalculationService.calculateFee(parkingTicket);
    }
}
