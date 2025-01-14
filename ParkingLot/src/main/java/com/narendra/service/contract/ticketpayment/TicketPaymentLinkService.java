package com.narendra.service.contract.ticketpayment;

import com.narendra.entity.parking.ParkingTicket;
import com.narendra.entity.payment.PaymentTransaction;

public interface TicketPaymentLinkService {

    void linkTicketPayment(ParkingTicket parkingTicket, PaymentTransaction paymentTransaction);
}
