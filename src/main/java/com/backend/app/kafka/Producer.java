package com.backend.app.kafka;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private static Logger logger = LogManager.getLogger();
    private final KafkaTemplate<String, String> KafkaTemplate;

    @Value("${kafka.topic}")
    private String kafkaTopic;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.KafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        logger.info("KAFKA PRODUCER - Sending Kafka message...");
        KafkaTemplate.send(kafkaTopic, message);
    }

}
