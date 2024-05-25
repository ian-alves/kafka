package com.ian.paymentservice.service;

import com.ian.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
