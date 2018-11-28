package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class JmsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsConsumerApplication.class, args);
	}
}