package com.narendra.service.impl.ticketpayment;

import com.narendra.entity.parking.ParkingTicket;
import com.narendra.entity.payment.PaymentTransaction;
import com.narendra.entity.ticketpayment.TicketPaymentTransaction;
import com.narendra.service.contract.ticketpayment.TicketPaymentLinkService;

public class TicketPaymentLinkServiceImpl implements TicketPaymentLinkService {
    @Override
    public void linkTicketPayment(ParkingTicket parkingTicket, PaymentTransaction paymentTransaction) {
        TicketPaymentTransaction ticketPaymentTransaction = new TicketPaymentTransaction(parkingTicket, paymentTransaction);
        //Save this object to DB for future reference
        System.out.println("Parking ticket" + parkingTicket + " is linked with payment transaction:" + paymentTransaction);
    }
}
