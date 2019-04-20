package com.george.kafka.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;

/**
 * @author George Varghese
 * @version 1.0
 * https://github.com/varghgeorge
 */

@Component
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic}")
    public void receive(String message) {
        LOGGER.info("received car='{}'", message);
        latch.countDown();
    }
}
