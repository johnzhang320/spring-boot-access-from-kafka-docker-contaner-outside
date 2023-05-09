package com.configure.kafka.producer.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	/*
	   POST
	   http://localhost:8096/api/v1/kafka/publish

	    {
           "itemName":"Philly Red Steak",
           "quantity": 6,
           "deliveryDriverName":"Bryan Hart",
           "deliveryAddress": "1st Street suite 2213, San Jose,CA",
           "customerName": "Harris Tarden",
           "arriveInMinutes": 30,
           "price":68.5
         }

	 */

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
