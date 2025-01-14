package com.narendra.service.impl.parking.addon;

import com.narendra.entity.parking.ParkingTicket;
import com.narendra.service.contract.parking.addon.AddonParkingService;
import com.narendra.service.impl.fee.strategy.FeeCalculationStrategy;
import com.narendra.service.impl.fee.strategy.decorator.WashFeeCalculationStrategyDecorator;

public class WashAddonParkingService implements AddonParkingService {
    @Override
    public void availAddonParkingService(ParkingTicket parkingTicket) {
        FeeCalculationStrategy feeCalculationStrategy = parkingTicket.getParkingSpot().getFeeCalculationStrategy();
        parkingTicket.getParkingSpot().setFeeCalculationStrategy(new WashFeeCalculationStrategyDecorator(feeCalculationStrategy));
        System.out.println(parkingTicket + " Availing wash addon service");
    }
}
