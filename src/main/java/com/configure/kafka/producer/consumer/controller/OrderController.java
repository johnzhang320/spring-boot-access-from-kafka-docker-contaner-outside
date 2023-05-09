package com.configure.kafka.producer.consumer.controller;

import com.configure.kafka.producer.consumer.model.Order;
import com.configure.kafka.producer.consumer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
