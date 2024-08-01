package com.example.spring.boot.controller;

import com.example.spring.boot.dto.User;
import com.example.spring.boot.kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http://localhost:8080/api/v2/kafka/publish
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok(" json message sent to kafka topic");
    }
}
