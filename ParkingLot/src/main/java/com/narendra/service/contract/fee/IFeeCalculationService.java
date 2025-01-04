package com.narendra.service.contract.fee;

import com.narendra.entity.parking.ParkingTicket;

public interface IFeeCalculationService {
    double calculateFee(ParkingTicket parkingTicket);
}
