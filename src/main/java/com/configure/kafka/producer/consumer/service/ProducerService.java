package com.configure.kafka.producer.consumer.service;

import com.configure.kafka.producer.consumer.config.Constants;
import com.configure.kafka.producer.consumer.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.configure.kafka.producer.consumer.config.Constants.TOPIC_NAME;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProducerService {
    private final KafkaTemplate<String, Order> kafkaTemplate;
    public void sendOrder(Order order) {
        log.info("sending order:"+order.toString());
        order.setMessageFrom("Boostrap-server:"+ Constants.BOOTSTRAP_NAME);
        kafkaTemplate.send(new ProducerRecord<>(TOPIC_NAME, order));
    }

}
