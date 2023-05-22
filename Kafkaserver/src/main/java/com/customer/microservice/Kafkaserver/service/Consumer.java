package com.customer.microservice.Kafkaserver.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	
	
	@KafkaListener(topics = "develop_topic", groupId = "develop_group")
	public void readRecievedMessage(String message) {
		System.out.println("the output message is "+message);
	}

}
