package com.narendra.controller;

import com.narendra.entity.parking.ParkingTicket;
import com.narendra.entity.payment.PaymentTransaction;
import com.narendra.service.contract.ticketpayment.ITicketPaymentLinkService;

public class TicketPaymentLinkController {

    private final ITicketPaymentLinkService ticketPaymentLinkService;

    public TicketPaymentLinkController(ITicketPaymentLinkService ticketPaymentLinkService) {
        this.ticketPaymentLinkService = ticketPaymentLinkService;
    }

    public void linkTicketPayment(ParkingTicket parkingTicket, PaymentTransaction paymentTransaction) {
        ticketPaymentLinkService.linkTicketPayment(parkingTicket, paymentTransaction);
    }
}
