package com.narendra.controller;

import com.narendra.entity.payment.PaymentMethod;
import com.narendra.entity.payment.PaymentTransaction;
import com.narendra.service.contract.payment.IPaymentService;

public class PaymentController {
    private final IPaymentService paymentService;

    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public PaymentTransaction processPayment(PaymentMethod paymentMethod) {
        return paymentService.processPayment(paymentMethod);
    }
}
