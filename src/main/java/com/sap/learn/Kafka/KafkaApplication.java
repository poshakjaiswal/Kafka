package com.sap.learn.Kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {

		System.out.println("Test");

		SpringApplication.run(KafkaApplication.class, args);
	}

}
