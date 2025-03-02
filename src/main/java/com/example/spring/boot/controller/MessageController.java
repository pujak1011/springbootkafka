package com.example.spring.boot.controller;

import com.example.spring.boot.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer producer;

    public MessageController(KafkaProducer producer) {
        this.producer = producer;
    }

    /* http://localhost:8080/api/v1/kafka/publish?message=hello */
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic");
    }
}
