package com.configure.kafka.producer.consumer.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {
    private String item;
    private String deliveryType;

    private Integer quantity;
}
