package com.backend.app.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);
    // A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.boot}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info("Payload received"+consumerRecord.toString());
        latch.countDown();
    }
}
