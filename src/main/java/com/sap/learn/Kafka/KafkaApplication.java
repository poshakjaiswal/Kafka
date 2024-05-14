package com.sap.learn.Kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.sap.learn.Kafka.controller")

public class KafkaApplication {

	public static void main(String[] args) {

		System.out.println("Test");

		SpringApplication.run(KafkaApplication.class, args);
	}

}
