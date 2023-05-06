package com.configure.kafka.producer.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	/*
	   POST
	   http://localhost:8096/api/v1/kafka/publish

	    {
          "item": "Butter Chicken",
          "deliveryType": "takeaway",
          "quantity": 2
        }

	 */

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
