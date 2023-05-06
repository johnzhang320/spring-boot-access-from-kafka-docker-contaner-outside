package com.configure.kafka.producer.consumer.controller;

import com.configure.kafka.producer.consumer.model.Order;
import com.configure.kafka.producer.consumer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import static com.configure.kafka.producer.consumer.config.Constants.TOPIC_NAME;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class OrderController {
    private final ProducerService producerService;
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello world";
    }
    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello:"+name;
    }
    @PostMapping("/publish")
    public ResponseEntity<Order> publish(@RequestBody Order order) {

        producerService.sendOrder(order);
        return ResponseEntity.ok(order);
    }

}
