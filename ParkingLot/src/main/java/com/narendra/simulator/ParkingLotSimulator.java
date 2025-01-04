package com.narendra.simulator;

import com.narendra.controller.ParkingController;
import com.narendra.controller.PaymentController;
import com.narendra.controller.SpotAllocationController;
import com.narendra.controller.TicketPaymentLinkController;
import com.narendra.entity.common.Address;
import com.narendra.entity.parking.*;
import com.narendra.entity.payment.CashPaymentMethod;
import com.narendra.entity.payment.PaymentTransaction;
import com.narendra.entity.vehicle.Vehicle;
import com.narendra.entity.vehicle.VehicleType;
import com.narendra.repository.ParkingLotRepository;
import com.narendra.service.contract.fee.IFeeCalculationService;
import com.narendra.service.contract.parking.IParkingService;
import com.narendra.service.contract.payment.IPaymentService;
import com.narendra.service.contract.spotallocation.ISpotAllocationService;
import com.narendra.service.contract.ticketpayment.ITicketPaymentLinkService;
import com.narendra.service.impl.fee.FeeCalculationService;
import com.narendra.service.impl.parking.ParkingService;
import com.narendra.service.impl.payment.PaymentService;
import com.narendra.service.impl.spotallocation.SpotAllocationService;
import com.narendra.service.impl.ticketpayment.TicketPaymentLinkService;

public class ParkingLotSimulator {
    public static void main(String[] args) {
        //Setup entities/core objects
        DisplayBoard floorDisplayBoard1 = new DisplayBoard();
        DisplayBoard floorDisplayBoard2 = new DisplayBoard();

        ParkingSpot twoWheelerFloor1 = new ParkingSpot(VehicleType.TWO_WHEELER);
        ParkingSpot twoWheelerFloor2 = new ParkingSpot(VehicleType.TWO_WHEELER);

        ParkingSpot fourWheelerFloor1 = new ParkingSpot(VehicleType.FOUR_WHEELER);
        ParkingSpot fourWheelerFloor2 = new ParkingSpot(VehicleType.FOUR_WHEELER);

        ParkingSpot heavyFloor1 = new ParkingSpot(VehicleType.HEAVY);
        ParkingSpot heavyFloor2 = new ParkingSpot(VehicleType.HEAVY);

        ParkingFloor floor1 = new ParkingFloor(floorDisplayBoard1);
        floor1.addParkingSpot(twoWheelerFloor1);
        floor1.addParkingSpot(fourWheelerFloor1);
        floor1.addParkingSpot(heavyFloor1);

        ParkingFloor floor2 = new ParkingFloor(floorDisplayBoard2);
        floor2.addParkingSpot(twoWheelerFloor2);
        floor2.addParkingSpot(fourWheelerFloor2);
        floor2.addParkingSpot(heavyFloor2);

        Entry entry1 = new Entry();
        Entry entry2 = new Entry();

        Exit exit1 = new Exit();
        Exit exit2 = new Exit();

        ParkingLot parkingLot = new ParkingLot(new Address("Street1", "City1", "State1", "Country1", "500000"));
        parkingLot.addParkingFloor(floor1);
        parkingLot.addParkingFloor(floor2);
        parkingLot.addEntry(entry1);
        parkingLot.addEntry(entry2);
        parkingLot.addExit(exit1);
        parkingLot.addExit(exit2);

        //Setup Services/Repositories
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingLot);
        IParkingService parkingService = new ParkingService();
        IFeeCalculationService feeCalculationService = new FeeCalculationService();
        IPaymentService paymentService = new PaymentService();
        ISpotAllocationService spotAllocationService = new SpotAllocationService(parkingLotRepository);
        ITicketPaymentLinkService ticketPaymentLinkService = new TicketPaymentLinkService();

        //Setup Controllers
        SpotAllocationController spotAllocationController = new SpotAllocationController(spotAllocationService);
        ParkingController parkingController = new ParkingController(parkingService);
        PaymentController paymentController = new PaymentController(paymentService);
        TicketPaymentLinkController ticketPaymentLinkController = new TicketPaymentLinkController(ticketPaymentLinkService);

        //Simulate occupy of two-wheeler vehicle.
        Vehicle vehicle = new Vehicle("123456", VehicleType.TWO_WHEELER);
        ParkingSpot parkingSpot = spotAllocationController.getFreeParkingSpot(entry1, vehicle.getVehicleType());
        ParkingTicket parkingTicket = parkingController.occupyParkingSpot(vehicle, parkingSpot);

        //Simulate vacate of two-wheeler vehicle.
        double fee = feeCalculationService.calculateFee(parkingTicket);
        PaymentTransaction paymentTransaction = paymentController.processPayment(new CashPaymentMethod(fee));
        ticketPaymentLinkController.linkTicketPayment(parkingTicket, paymentTransaction);
        parkingController.vacateParkingSpot(exit1, parkingTicket);
    }
}
