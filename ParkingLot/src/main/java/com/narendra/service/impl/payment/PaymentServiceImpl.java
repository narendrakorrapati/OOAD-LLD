package com.narendra.service.impl.payment;

import com.narendra.entity.payment.PaymentMethod;
import com.narendra.entity.payment.PaymentStatus;
import com.narendra.entity.payment.PaymentTransaction;
import com.narendra.service.contract.payment.PaymentService;

import java.time.LocalDateTime;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentTransaction processPayment(PaymentMethod paymentMethod) {
        PaymentTransaction paymentTransaction = new PaymentTransaction(PaymentStatus.SUCCESS, LocalDateTime.now(),paymentMethod.getAmount());
        System.out.println("Payment is success for amount : " + paymentMethod.getAmount() + " with reference id:" + paymentTransaction.getRefId());
        return paymentTransaction;
    }
}
