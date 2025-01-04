package com.narendra.service.contract.payment;

import com.narendra.entity.payment.PaymentMethod;
import com.narendra.entity.payment.PaymentTransaction;

public interface IPaymentService {
    PaymentTransaction processPayment(PaymentMethod paymentMethod);
}
