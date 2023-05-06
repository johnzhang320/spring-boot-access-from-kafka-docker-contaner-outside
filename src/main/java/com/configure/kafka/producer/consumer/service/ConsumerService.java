package com.configure.kafka.producer.consumer.service;

import com.configure.kafka.producer.consumer.config.Constants;
import com.configure.kafka.producer.consumer.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ConsumerService {
    @KafkaListener(topics= Constants.TOPIC_NAME, groupId=Constants.GROUP_ID_CONFIG)
    public void kafkaListener(Order order) {
        log.info("Consumer received order: {} ", order.toString());
    }

}
