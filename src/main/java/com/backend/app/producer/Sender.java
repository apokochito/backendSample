package com.backend.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private org.springframework.kafka.core.KafkaTemplate<String, String> KafkaTemplate;

    String kafkaTopic = "test";

    public void send(String message) {
        KafkaTemplate.send(kafkaTopic, message);
    }
}