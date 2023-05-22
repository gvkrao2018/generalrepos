package com.customer.microservice.Kafkaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.microservice.Kafkaserver.service.Producer;

@RestController
@RequestMapping("/kafka-message")
public class KafkaMessageController {
	
	@Autowired
	Producer producer;
	
	@GetMapping("/producer/message")
	public ResponseEntity<String> messageToconsumer(@RequestParam("message") String message){
		producer.sendMessage(message);
		return new ResponseEntity<String>("message pushed",HttpStatus.OK);
	}

}
