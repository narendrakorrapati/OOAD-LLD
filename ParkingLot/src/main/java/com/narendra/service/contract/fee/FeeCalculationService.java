package com.narendra.service.contract.fee;

import com.narendra.entity.parking.ParkingTicket;

public interface FeeCalculationService {
    double calculateFee(ParkingTicket parkingTicket);
}
