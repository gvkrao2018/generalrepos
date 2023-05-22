package com.customer.microservice.Kafkaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		kafkaTemplate.send("develop_topic", message);
	}
}
