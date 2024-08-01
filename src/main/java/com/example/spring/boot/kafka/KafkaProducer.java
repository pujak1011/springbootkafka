package com.example.spring.boot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer  {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> KafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        KafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message){
        LOGGER.info(String.format("Message Sent %s", message));
        KafkaTemplate.send("topicOne", message);
    }
}
