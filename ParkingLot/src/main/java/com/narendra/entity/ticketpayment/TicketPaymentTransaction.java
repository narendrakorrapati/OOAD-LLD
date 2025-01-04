package com.narendra.entity.ticketpayment;

import com.narendra.entity.parking.ParkingTicket;
import com.narendra.entity.payment.PaymentTransaction;

import java.time.LocalDateTime;

public class TicketPaymentTransaction {

    private final ParkingTicket parkingTicket;
    private final PaymentTransaction paymentTransaction;
    private final LocalDateTime linkedAt;

    public TicketPaymentTransaction(ParkingTicket parkingTicket, PaymentTransaction paymentTransaction) {
        this.parkingTicket = parkingTicket;
        this.paymentTransaction = paymentTransaction;
        this.linkedAt = LocalDateTime.now();
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }

    public LocalDateTime getLinkedAt() {
        return linkedAt;
    }
}
