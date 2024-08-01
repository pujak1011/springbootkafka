package com.example.spring.boot.kafka;

import com.example.spring.boot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics="JsonTopicOne", groupId = "myGroup")
    public void consume(User data){
       LOGGER.info(String.format("Json Message receive => %s", data.toString()));
    }
}
