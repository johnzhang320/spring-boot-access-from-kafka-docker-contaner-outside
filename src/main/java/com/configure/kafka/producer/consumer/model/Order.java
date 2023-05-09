package com.configure.kafka.producer.consumer.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {
    private String messageFrom;
    private String itemName;
    private String deliveryDriverName;
    private String deliveryAddress;
    private String customerName;
    private Integer arriveInMinutes;
    private Double price;
    private Integer quantity;
}
