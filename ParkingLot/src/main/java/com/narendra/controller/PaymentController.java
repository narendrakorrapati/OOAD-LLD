package com.narendra.controller;

import com.narendra.entity.payment.PaymentMethod;
import com.narendra.entity.payment.PaymentTransaction;
import com.narendra.service.contract.payment.PaymentService;

public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public PaymentTransaction processPayment(PaymentMethod paymentMethod) {
        return paymentService.processPayment(paymentMethod);
    }
}
