package com.ian.jsonconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ian.jsonconsumer.model.Payment;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraude(@Payload Payment payment) {
        log.info("Recebi o pagamento {}", payment.toString());
        log.info("Validando fraude");
        log.info("Compra aprovada");
    }

    // em microserviços esse listener poderia estar criado em outro projeto com sua
    // funcionalidade específica
    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        Thread.sleep(2000);
        log.info("Gerando pdf do produto com id {}", payment.getId());
    }

    // em microserviços esse listener poderia estar criado em outro projeto com sua
    // funcionalidade específica
    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        Thread.sleep(3000);
        log.info("Enviando email...");
    }
}
