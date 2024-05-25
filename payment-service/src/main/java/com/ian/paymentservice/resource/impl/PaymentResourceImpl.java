package com.ian.paymentservice.resource.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ian.paymentservice.model.Payment;
import com.ian.paymentservice.resource.PaymentResource;
import com.ian.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentservice;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        paymentservice.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}